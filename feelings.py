import sys
sys.path.append("{{your 'phoenixdb' folder path}}/apache-phoenix-4.14.2-HBase-1.3-bin/python/")
import phoenixdb
import math
import jpype
from lxml import objectify
import warnings
import json
import pandas as pd
import numpy as np
import sqlite3
import psqlparse
import multiprocessing as mp
from lxml import objectify
from datetime import datetime
import getpass
import re
import os
import csv


"""

"""

class Feelings:
    
    def __init__(self, db='phoenix'):
        self.db = db
        

    """
    JVM Configuration
    """        
    def _init_jvm(self):

        ## set JVM config
        jvm_path = jpype.getDefaultJVMPath()
        jvm_cp = "-Djava.class.path={{your path}}"
        jvm_conf = "-Dlog4j.configuration=file:{{your path}}"

        if jpype.isJVMStarted():
            return

        try:
            jpype.startJVM(jvm_path, jvm_cp, jvm_conf)

        except Exception as e:
            print(e)
        
    """
    Connection (Thick driver)
    """
    def _get_conn(self):
        # start jvm
        self._init_jvm()
        
        # import java packages
        DriverManager = jpype.JPackage("java").sql.DriverManager
        PhoenixConnection = jpype.JPackage("org").apache.phoenix.jdbc.PhoenixConnection
        Properties = jpype.JPackage("java").util.Properties
        
        # set properties
        props = Properties()
        
        prop_path = "{{your hbase-site.xml path}}"
        xml_data = objectify.parse(prop_path)
        xml_root = xml_data.getroot()
        

        for i in range(len(xml_root.getchildren())) :
            child = xml_root.getchildren()[i]
            subchild = child.getchildren()

            sub_prop = subchild[0]
            sub_value = subchild[1]

            if "phoenix" in sub_prop :
                props.setProperty(sub_prop, sub_value)
        
        
        props.setProperty("useCursorFetch", "True")
        props.setProperty("phoenix.query.maxIntraRegionParallelization", "7")
        props.setProperty("phoenix.query.queuesize", "10000")
        props.setProperty("phoenix.client.localIndexUpgrade", "false")
        props.setProperty("phoenix.transactions.autoFlush", "false")
        props.setProperty("phoenix.connection.autoCommit", "false")
        props.setProperty("phoenix.mutate.maxSize", "500000")
        

        # connection
        db_url = "{{your thick driver DB Url}}"

        warnings.filterwarnings("ignore")
        
        conn = DriverManager.getConnection(db_url, props).unwrap(PhoenixConnection)

        return conn

    
    """
    SELECT Query
    """
    def get(self, arg_query):
        
        # connection
        conn = self._get_conn()
        
        conn.setReadOnly(True)
        conn.setAutoCommit(True)
        warnings.filterwarnings("default")
        
        # import java packages
        PhoenixRuntime = jpype.JPackage("org").apache.phoenix.util.PhoenixRuntime
        Collections = jpype.JPackage("java").util.Collections
        StringReader = jpype.JPackage("java").io.StringReader

        arg_query = arg_query + ";"
        reader = StringReader(arg_query)
        
        # execute Statement
        json_list = PhoenixRuntime.executeStatements(conn, reader, Collections.emptyList())
        
        # get results
        data = json_list[0]
        dtypes = json.loads(json_list[1])
        
        df = pd.read_json(data, orient='split', dtype=dtypes)

        conn.close()

        return df
    
    
    """
    INSERT Query
    """
    # method for multi-processing of general insert
    def _runner(self, args) :
        W, input_file_sp,db_url, table = args

        conn = phoenixdb.connect(db_url, autocommit = True)
        cursor = conn.cursor()

        targ_col = re.sub("'", "", str(tuple(input_file_sp[W].columns.tolist())))
        targ_q = re.sub("'", "", str(tuple(["?"]*len(input_file_sp[W].columns))))
        Cmds = "upsert into "+ table + " " + targ_col + " values " + targ_q

        upTup = []

        for U in range(0,len(input_file_sp[W].index)) :
            upTup.append(tuple(input_file_sp[W].iloc[U, :].tolist()))

        cursor.executemany(Cmds, upTup)
        cursor.close()
            
        
    def insert(self, table_name, df, delimiter=',', bulk_yn = False):
        # bulk insert
        if bulk_yn:
            print('> Start [Bulk INSERT]...')
            
            # connection
            conn = self._get_conn()
            
            # Convert Dataframe into CSV file
            filename = '{{your temporary CSV path}}/feelings_tmp_{}.csv'.format(datetime.now().strftime('%Y%m%d%H%M%S%f'))
            print('    [!] Convert Dataframe into CSV file...')

            df.to_csv(filename, index=False, quoting=csv.QUOTE_NONNUMERIC, sep=delimiter)
            print('    [!] Completed')

            # set args
            args = ["-t", table_name, filename]
            
            # import java packages
            ExecutionCommand = jpype.JClass("org.apache.phoenix.util.PhoenixRuntime$ExecutionCommand")
            execCmd = ExecutionCommand.parseArgs(args)
            CSVCommonsLoader = jpype.JPackage("org").apache.phoenix.util.CSVCommonsLoader
            csvLoader = CSVCommonsLoader(conn, table_name, execCmd.getColumns(), execCmd.isStrict(), delimiter,
                             execCmd.getQuoteCharacter(), execCmd.getEscapeCharacter(), execCmd.getArrayElementSeparator())
            
            # Upsert
            csvLoader.upsert(filename)
            
            # Delete CSV file
            os.remove(filename)
            
            
        # general insert   
        else:
            print('> Start [INSERT]...')
            
            nSplit = 10000
            db_url="{{your thin driver DB Url}}"
            
            # multi-processing
            if len(df.index) >= nSplit :                
                cnt = math.ceil((df.shape[0] / nSplit))
                df.index = range(0,len(df.index))

                input_file_sp = []    
                for i in range(cnt):
                    input_file_sp.append(df[nSplit*i : nSplit*(i+1)])

                outL=[]
                with mp.Pool(processes = 10) as P :                    
                    W = list(range(0, len(input_file_sp)))   
                    args = ((Ws, input_file_sp, db_url, table_name) for Ws in W)
                    outL = P.map_async(self._runner, args).get()

            else :
                try :
                    # Connection (Thin driver)
                    conn = phoenixdb.connect(db_url, autocommit=True)
                    
                    cursor = conn.cursor()

                    targ_col = re.sub("'", "", str(tuple(df.columns.tolist())))
                    targ_q = re.sub("'", "", str(tuple(["?"]*len(df.columns))))
                    Cmds = "upsert into "+ table_name + " " + targ_col + " values " + targ_q

                    for W in range(0, len(df.index)) :
                        upTup = tuple(df.iloc[W,:].tolist())
                        cursor.execute(Cmds, upTup)

                        upload_pct = int(W/len(df.index)*100)

                        if (W % 1000 == 0) and (W != 0):
                            print("    [!] " + str(upload_pct) + "% uploaded")

                    conn.close()

                except Exception as e :
                    print(e)
                    conn.close()
                    
                    
        print('> Completed!')
            