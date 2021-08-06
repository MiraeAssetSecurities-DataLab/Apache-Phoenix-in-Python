
# Feelings

Apache Phoenix is a SQL skin over HBase delivered as a client-embedded JDBC driver targeting low latency queries over HBase data.

Copyright ⓒ2014 Apache Software Foundation. All Rights Reserved.

### Description 

*Feelings* is a Python project using a modified version of the [Maven project of Apache Phoenix.](http://www.apache.org/dyn/closer.lua/phoenix/apache-phoenix-4.14.3-HBase-1.3/src/apache-phoenix-4.14.3-HBase-1.3-src.tar.gz)

### Details

1. apache-phoenix-4.14.3-HBase-1.3-src/phoenix-core/src/main/java/org/apache/phoenix/jdbc/<strong>PhoenixConnection.java</strong>
    * Method: <strong>executeStatements</strong><br>
    Printing out result of query -> <strong>Return</strong> Result using <strong>json String List</strong> format<br><br>
2. apache-phoenix-4.14.3-HBase-1.3-src/phoenix-core/src/main/java/org/apache/phoenix/util/<strong>PhoenixRuntime.java</strong>
    * Method: <strong>executeStatements</strong><br>
    Change Return Type into <strong>json String List</strong>
    ~~~java
    public ArrayList<String> executeStatements
    ~~~
3. apache-phoenix-4.14.3-HBase-1.3-src/phoenix-core/src/it/java/org/apache/phoenix/end2end/<strong>ExecuteStatementsIT.java</strong>
    * Method: <strong>testExecuteStatements</strong><br>
    Skip 2 line
    ~~~java
    [82]    //int nStatements = PhoenixRuntime.executeStatements(conn, new StringReader(statements), binds);
    [83]    //assertEquals(7, nStatements);
    ~~~
4. apache-phoenix-4.14.3-HBase-1.3-src-v10/phoenix-core/<strong>pom.xml</strong>
    * Add dependency
    ~~~
    <dependency>
        <groupId>com.googlecode.json-simple</groupId>
        <artifactId>json-simple</artifactId>
        <version>1.1</version>
    </dependency>
    ~~~
5. Maven Compile
    * Linux Command
    ~~~
    cd apache-phoenix-4.14.3-HBase-1.3-src
    mvn package -DSkipTests (Error occurred, but keep going!)
    cd phoenix-client
    mvn package -DSkipTests
    ~~~
    
    if you want to compile again, use a command "mvn clean install -DSkipTests"<br><br>
    
5. Use compiled JAR file in Python
    * JAR Directory: apache-phoenix-4.14.3-HBase-1.3-src-v10/phoenix-client/target/<strong>phoenix-4.14.3-HBase-1.3-client.jar</strong>
        * In this project, there is no JAR file because of the size(104MB).
    * Apply JAR to Python using <strong>Jpype</strong>

### Prerequisite

* jpype 0.5.5.2

### Environment

* Python 3.4
* Apache HBase 1.3
* Phoenix 4.14.3

### Usage 

(1) Import module

~~~python
from feelings import *
fs = Feelings()
~~~

(2) SELECT
* Return type: DataFrame
~~~python
query = """
SELECT *
  FROM {TABLENAME}
"""
data = fs.get(query)
~~~

(3) INSERT
* Input type: DataFrame

A. general insert

~~~python
fs.insert('{TABLENAME}', DataFrame)
~~~

B. bulk insert
~~~python
# delimiter = ','(default)
fs.insert('{TABLENAME}', DataFrame, bulk_yn=True)
# delimiter = ';'
fs.insert('{TABLENAME}', DataFrame, delimiter = ';', bulk_yn=True)
~~~

<hr>
Team DataLab, Mirae Asset Securities

Deukhwan Lee | 이득환 | deukhwan.lee.a@miraeasset.com 
Seungil Lee | 이승일 | seungil.lee@miraeasset.com
Uram Lee | 이우람 | uram999@naver.com
Dokyung Lee | 이도경 | dokylee54@gmail.com