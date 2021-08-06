// $ANTLR 3.5.2 PhoenixSQL.g 2021-06-29 11:06:45

/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.phoenix.parse;

///CLOVER:OFF
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.apache.hadoop.hbase.util.Pair;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import java.lang.Boolean;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.sql.SQLException;
import org.apache.phoenix.expression.function.CountAggregateFunction;
import org.apache.phoenix.expression.LiteralExpression;
import org.apache.phoenix.jdbc.PhoenixDatabaseMetaData;
import org.apache.phoenix.parse.PFunction;
import org.apache.phoenix.parse.PFunction.FunctionArgument;
import org.apache.phoenix.parse.UDFParseNode;
import org.apache.phoenix.query.QueryConstants;
import org.apache.phoenix.schema.SortOrder;
import org.apache.phoenix.schema.IllegalDataException;
import org.apache.phoenix.schema.PIndexState;
import org.apache.phoenix.schema.PTableType;
import org.apache.phoenix.schema.PTable.IndexType;
import org.apache.phoenix.schema.stats.StatisticsCollectionScope;
import org.apache.phoenix.schema.types.PDataType;
import org.apache.phoenix.schema.types.PDate;
import org.apache.phoenix.schema.types.PTime;
import org.apache.phoenix.schema.types.PTimestamp;
import org.apache.phoenix.schema.types.PUnsignedDate;
import org.apache.phoenix.schema.types.PUnsignedTime;
import org.apache.phoenix.schema.types.PUnsignedTimestamp;
import org.apache.phoenix.util.SchemaUtil;
import org.apache.phoenix.parse.LikeParseNode.LikeType;
import org.apache.phoenix.trace.util.Tracing;
import org.apache.phoenix.parse.AddJarsStatement;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@SuppressWarnings("all")
public class PhoenixSQLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTIVE", "ADD", "ALL", "ALTER", 
		"AND", "ANY", "ARRAY", "AS", "ASC", "ASTERISK", "ASYNC", "AT", "BETWEEN", 
		"BIND_NAME", "BY", "CACHE", "CASCADE", "CASE", "CAST", "CHAR", "CHAR_ESC", 
		"CLOSE", "COLON", "COLUMN", "COLUMNS", "COMMA", "COMMENT_AND_HINT_END", 
		"COMMENT_START", "CONCAT", "CONSTANT", "CONSTRAINT", "CREATE", "CURRENT", 
		"CURSOR", "CYCLE", "DBL_QUOTE_CHAR", "DECIMAL", "DECLARE", "DEFAULT", 
		"DEFAULTVALUE", "DELETE", "DESC", "DIGIT", "DISABLE", "DISTINCT", "DIVIDE", 
		"DOT", "DOUBLE", "DOUBLE_EQ", "DOUBLE_QUOTE", "DROP", "DUPLICATE", "ELSE", 
		"END", "EOL", "EQ", "EXECUTE", "EXISTS", "EXPLAIN", "Exponent", "FALSE", 
		"FETCH", "FIELDCHAR", "FIRST", "FOR", "FROM", "FULL", "FUNCTION", "GRANT", 
		"GROUP", "GT", "HAVING", "HINT_START", "IF", "IGNORE", "ILIKE", "IMMUTABLE", 
		"IN", "INCLUDE", "INCREMENT", "INDEX", "INNER", "INTO", "IS", "JAR", "JARS", 
		"JOIN", "KEY", "LAST", "LCURLY", "LEFT", "LETTER", "LIKE", "LIMIT", "LIST", 
		"LOCAL", "LPAREN", "LSQUARE", "LT", "MAXVALUE", "MINUS", "MINVALUE", "ML_COMMENT", 
		"ML_HINT", "NAME", "NEXT", "NOEQ1", "NOEQ2", "NOT", "NULL", "NULLS", "NUMBER", 
		"OFF", "OFFSET", "ON", "ONLY", "OPEN", "OR", "ORDER", "OTHER", "OUTER", 
		"OUTER_JOIN", "PERCENT", "PLUS", "POSINTEGER", "PRIMARY", "QUESTION", 
		"RCURLY", "REBUILD", "REPLACE", "RETURNS", "REVOKE", "RIGHT", "ROW", "ROWS", 
		"ROW_TIMESTAMP", "RPAREN", "RSQUARE", "SAMPLING", "SCHEMA", "SELECT", 
		"SEMICOLON", "SEQUENCE", "SESSION", "SET", "SL_COMMENT", "SL_COMMENT1", 
		"SL_COMMENT2", "SOME", "SPLIT", "START", "STATISTICS", "STRING_LITERAL", 
		"TABLE", "TABLES", "TABLESAMPLE", "TEMPORARY", "THEN", "TILDE", "TO", 
		"TRACE", "TRUE", "UNION", "UNUSABLE", "UPDATE", "UPGRADE", "UPSERT", "USABLE", 
		"USE", "USING", "VALUE", "VALUES", "VIEW", "WHEN", "WHERE", "WITH", "WITHIN", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int ACTIVE=4;
	public static final int ADD=5;
	public static final int ALL=6;
	public static final int ALTER=7;
	public static final int AND=8;
	public static final int ANY=9;
	public static final int ARRAY=10;
	public static final int AS=11;
	public static final int ASC=12;
	public static final int ASTERISK=13;
	public static final int ASYNC=14;
	public static final int AT=15;
	public static final int BETWEEN=16;
	public static final int BIND_NAME=17;
	public static final int BY=18;
	public static final int CACHE=19;
	public static final int CASCADE=20;
	public static final int CASE=21;
	public static final int CAST=22;
	public static final int CHAR=23;
	public static final int CHAR_ESC=24;
	public static final int CLOSE=25;
	public static final int COLON=26;
	public static final int COLUMN=27;
	public static final int COLUMNS=28;
	public static final int COMMA=29;
	public static final int COMMENT_AND_HINT_END=30;
	public static final int COMMENT_START=31;
	public static final int CONCAT=32;
	public static final int CONSTANT=33;
	public static final int CONSTRAINT=34;
	public static final int CREATE=35;
	public static final int CURRENT=36;
	public static final int CURSOR=37;
	public static final int CYCLE=38;
	public static final int DBL_QUOTE_CHAR=39;
	public static final int DECIMAL=40;
	public static final int DECLARE=41;
	public static final int DEFAULT=42;
	public static final int DEFAULTVALUE=43;
	public static final int DELETE=44;
	public static final int DESC=45;
	public static final int DIGIT=46;
	public static final int DISABLE=47;
	public static final int DISTINCT=48;
	public static final int DIVIDE=49;
	public static final int DOT=50;
	public static final int DOUBLE=51;
	public static final int DOUBLE_EQ=52;
	public static final int DOUBLE_QUOTE=53;
	public static final int DROP=54;
	public static final int DUPLICATE=55;
	public static final int ELSE=56;
	public static final int END=57;
	public static final int EOL=58;
	public static final int EQ=59;
	public static final int EXECUTE=60;
	public static final int EXISTS=61;
	public static final int EXPLAIN=62;
	public static final int Exponent=63;
	public static final int FALSE=64;
	public static final int FETCH=65;
	public static final int FIELDCHAR=66;
	public static final int FIRST=67;
	public static final int FOR=68;
	public static final int FROM=69;
	public static final int FULL=70;
	public static final int FUNCTION=71;
	public static final int GRANT=72;
	public static final int GROUP=73;
	public static final int GT=74;
	public static final int HAVING=75;
	public static final int HINT_START=76;
	public static final int IF=77;
	public static final int IGNORE=78;
	public static final int ILIKE=79;
	public static final int IMMUTABLE=80;
	public static final int IN=81;
	public static final int INCLUDE=82;
	public static final int INCREMENT=83;
	public static final int INDEX=84;
	public static final int INNER=85;
	public static final int INTO=86;
	public static final int IS=87;
	public static final int JAR=88;
	public static final int JARS=89;
	public static final int JOIN=90;
	public static final int KEY=91;
	public static final int LAST=92;
	public static final int LCURLY=93;
	public static final int LEFT=94;
	public static final int LETTER=95;
	public static final int LIKE=96;
	public static final int LIMIT=97;
	public static final int LIST=98;
	public static final int LOCAL=99;
	public static final int LPAREN=100;
	public static final int LSQUARE=101;
	public static final int LT=102;
	public static final int MAXVALUE=103;
	public static final int MINUS=104;
	public static final int MINVALUE=105;
	public static final int ML_COMMENT=106;
	public static final int ML_HINT=107;
	public static final int NAME=108;
	public static final int NEXT=109;
	public static final int NOEQ1=110;
	public static final int NOEQ2=111;
	public static final int NOT=112;
	public static final int NULL=113;
	public static final int NULLS=114;
	public static final int NUMBER=115;
	public static final int OFF=116;
	public static final int OFFSET=117;
	public static final int ON=118;
	public static final int ONLY=119;
	public static final int OPEN=120;
	public static final int OR=121;
	public static final int ORDER=122;
	public static final int OTHER=123;
	public static final int OUTER=124;
	public static final int OUTER_JOIN=125;
	public static final int PERCENT=126;
	public static final int PLUS=127;
	public static final int POSINTEGER=128;
	public static final int PRIMARY=129;
	public static final int QUESTION=130;
	public static final int RCURLY=131;
	public static final int REBUILD=132;
	public static final int REPLACE=133;
	public static final int RETURNS=134;
	public static final int REVOKE=135;
	public static final int RIGHT=136;
	public static final int ROW=137;
	public static final int ROWS=138;
	public static final int ROW_TIMESTAMP=139;
	public static final int RPAREN=140;
	public static final int RSQUARE=141;
	public static final int SAMPLING=142;
	public static final int SCHEMA=143;
	public static final int SELECT=144;
	public static final int SEMICOLON=145;
	public static final int SEQUENCE=146;
	public static final int SESSION=147;
	public static final int SET=148;
	public static final int SL_COMMENT=149;
	public static final int SL_COMMENT1=150;
	public static final int SL_COMMENT2=151;
	public static final int SOME=152;
	public static final int SPLIT=153;
	public static final int START=154;
	public static final int STATISTICS=155;
	public static final int STRING_LITERAL=156;
	public static final int TABLE=157;
	public static final int TABLES=158;
	public static final int TABLESAMPLE=159;
	public static final int TEMPORARY=160;
	public static final int THEN=161;
	public static final int TILDE=162;
	public static final int TO=163;
	public static final int TRACE=164;
	public static final int TRUE=165;
	public static final int UNION=166;
	public static final int UNUSABLE=167;
	public static final int UPDATE=168;
	public static final int UPGRADE=169;
	public static final int UPSERT=170;
	public static final int USABLE=171;
	public static final int USE=172;
	public static final int USING=173;
	public static final int VALUE=174;
	public static final int VALUES=175;
	public static final int VIEW=176;
	public static final int WHEN=177;
	public static final int WHERE=178;
	public static final int WITH=179;
	public static final int WITHIN=180;
	public static final int WS=181;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public PhoenixSQLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public PhoenixSQLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return PhoenixSQLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "PhoenixSQL.g"; }


	    
	    /**
	     * used to turn '?' binds into : binds.
	     */
	    private int anonBindNum;
	    private ParseNodeFactory factory;
	    private ParseContext.Stack contextStack = new ParseContext.Stack();
	    private Map<String, UDFParseNode> udfParseNodes = new HashMap<String, UDFParseNode>(1);

	    public void setParseNodeFactory(ParseNodeFactory factory) {
	        this.factory = factory;
	    }
	    
	    public boolean isCountFunction(String field) {
	        return CountAggregateFunction.NORMALIZED_NAME.equals(SchemaUtil.normalizeIdentifier(field));
	    }
	     
	    public int line(Token t) {
	        return t.getLine();
	    }

	    public int column(Token t) {
	        return t.getCharPositionInLine() + 1;
	    }
	    
	    private void throwRecognitionException(Token t) throws RecognitionException {
	        RecognitionException e = new RecognitionException();
	        e.token = t;
	        e.line = t.getLine();
	        e.charPositionInLine = t.getCharPositionInLine();
	        e.input = input;
	        throw e;
	    }
	    
	    public int getBindCount() {
	        return anonBindNum;
	    }
	    
	    public void resetBindCount() {
	        anonBindNum = 0;
	    }
	    
	    public String nextBind() {
	        return Integer.toString(++anonBindNum);
	    }
	    
	    public void updateBind(String namedBind){
	         int nBind = Integer.parseInt(namedBind);
	         if (nBind > anonBindNum) {
	             anonBindNum = nBind;
	         }
	    }

	    protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
	        throws RecognitionException {
	        RecognitionException e = null;
	        // if next token is what we are looking for then "delete" this token
	        if (mismatchIsUnwantedToken(input, ttype)) {
	            e = new UnwantedTokenException(ttype, input);
	        } else if (mismatchIsMissingToken(input, follow)) {
	            Object inserted = getMissingSymbol(input, e, ttype, follow);
	            e = new MissingTokenException(ttype, input, inserted);
	        } else {
	            e = new MismatchedTokenException(ttype, input);
	        }
	        throw e;
	    }

	    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
	        throws RecognitionException
	    {
	        throw e;
	    }
	    
	    @Override
	    public String getErrorMessage(RecognitionException e, String[] tokenNames) {
	        if (e instanceof MismatchedTokenException) {
	            MismatchedTokenException mte = (MismatchedTokenException)e;
	            String txt = mte.token.getText();
	            String p = mte.token.getType() == -1 ? "EOF" : PARAPHRASE[mte.token.getType()];
	            String expecting = (mte.expecting < PARAPHRASE.length && mte.expecting >= 0) ? PARAPHRASE[mte.expecting] : null;
	            if (expecting == null) {
	                return "unexpected token (" + line(mte.token) + "," + column(mte.token) + "): " + (txt != null ? txt : p);
	            } else {
	                return "expecting " + expecting +
	                    ", found '" + (txt != null ? txt : p) + "'";
	            }
	        } else if (e instanceof NoViableAltException) {
	            //NoViableAltException nvae = (NoViableAltException)e;
	            return "unexpected token: (" + line(e.token) + "," + column(e.token) + ")" + getTokenErrorDisplay(e.token);
	        }
	        return super.getErrorMessage(e, tokenNames);
	     }

	    public String getTokenErrorDisplay(int t) {
	        String ret = PARAPHRASE[t];
	        if (ret == null) ret = "<UNKNOWN>";
	        return ret;
	    }


	    private String[] PARAPHRASE = new String[getTokenNames().length];
	    {
	        PARAPHRASE[NAME] = "a field or entity name";
	        PARAPHRASE[NUMBER] = "a number";
	        PARAPHRASE[EQ] = "an equals sign";
	        PARAPHRASE[LT] = "a left angle bracket";
	        PARAPHRASE[GT] = "a right angle bracket";
	        PARAPHRASE[COMMA] = "a comma";
	        PARAPHRASE[LPAREN] = "a left parentheses";
	        PARAPHRASE[RPAREN] = "a right parentheses";
	        PARAPHRASE[SEMICOLON] = "a semi-colon";
	        PARAPHRASE[COLON] = "a colon";
	        PARAPHRASE[LSQUARE] = "left square bracket";
	        PARAPHRASE[RSQUARE] = "right square bracket";
	        PARAPHRASE[LCURLY] = "left curly bracket";
	        PARAPHRASE[RCURLY] = "right curly bracket";
	        PARAPHRASE[AT] = "at";
	        PARAPHRASE[MINUS] = "a subtraction";
	        PARAPHRASE[TILDE] = "a tilde";
	        PARAPHRASE[PLUS] = "an addition";
	        PARAPHRASE[ASTERISK] = "an asterisk";
	        PARAPHRASE[DIVIDE] = "a division";
	        PARAPHRASE[FIELDCHAR] = "a field character";
	        PARAPHRASE[LETTER] = "an ansi letter";
	        PARAPHRASE[POSINTEGER] = "a positive integer";
	        PARAPHRASE[DIGIT] = "a number from 0 to 9";
	    }



	// $ANTLR start "nextStatement"
	// PhoenixSQL.g:383:1: nextStatement returns [BindableStatement ret] : (s= oneStatement SEMICOLON | EOF );
	public final BindableStatement nextStatement() throws RecognitionException {
		BindableStatement ret = null;


		BindableStatement s =null;

		try {
			// PhoenixSQL.g:384:5: (s= oneStatement SEMICOLON | EOF )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==ADD||LA1_0==ALTER||LA1_0==CLOSE||LA1_0==CREATE||LA1_0==DECLARE||LA1_0==DELETE||LA1_0==DROP||LA1_0==EXECUTE||LA1_0==EXPLAIN||LA1_0==FETCH||LA1_0==GRANT||LA1_0==LIST||LA1_0==OPEN||LA1_0==REVOKE||LA1_0==SELECT||LA1_0==TRACE||LA1_0==UPDATE||LA1_0==UPSERT||LA1_0==USE) ) {
				alt1=1;
			}
			else if ( (LA1_0==EOF) ) {
				alt1=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// PhoenixSQL.g:384:8: s= oneStatement SEMICOLON
					{
					pushFollow(FOLLOW_oneStatement_in_nextStatement1275);
					s=oneStatement();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {
					    		try {
					    			ret = s;
					    		} finally {
					    			udfParseNodes.clear();
					    		}
					    	}
					match(input,SEMICOLON,FOLLOW_SEMICOLON_in_nextStatement1279); if (state.failed) return ret;
					}
					break;
				case 2 :
					// PhoenixSQL.g:391:8: EOF
					{
					match(input,EOF,FOLLOW_EOF_in_nextStatement1288); if (state.failed) return ret;
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "nextStatement"



	// $ANTLR start "statement"
	// PhoenixSQL.g:395:1: statement returns [BindableStatement ret] : s= oneStatement EOF ;
	public final BindableStatement statement() throws RecognitionException {
		BindableStatement ret = null;


		BindableStatement s =null;

		try {
			// PhoenixSQL.g:396:5: (s= oneStatement EOF )
			// PhoenixSQL.g:396:9: s= oneStatement EOF
			{
			pushFollow(FOLLOW_oneStatement_in_statement1314);
			s=oneStatement();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {
			        		try {
			    			ret = s;
			    		} finally {
			    			udfParseNodes.clear();
			    		}
			    	}
			match(input,EOF,FOLLOW_EOF_in_statement1318); if (state.failed) return ret;
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "statement"



	// $ANTLR start "query"
	// PhoenixSQL.g:406:1: query returns [SelectStatement ret] : s= select_node EOF ;
	public final SelectStatement query() throws RecognitionException {
		SelectStatement ret = null;


		SelectStatement s =null;

		try {
			// PhoenixSQL.g:407:5: (s= select_node EOF )
			// PhoenixSQL.g:407:9: s= select_node EOF
			{
			pushFollow(FOLLOW_select_node_in_query1344);
			s=select_node();
			state._fsp--;
			if (state.failed) return ret;
			match(input,EOF,FOLLOW_EOF_in_query1346); if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret =s;}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "query"



	// $ANTLR start "oneStatement"
	// PhoenixSQL.g:411:1: oneStatement returns [BindableStatement ret] : (s= select_node |s= upsert_node |s= delete_node |s= create_table_node |s= create_schema_node |s= create_view_node |s= create_index_node |s= cursor_open_node |s= cursor_close_node |s= cursor_fetch_node |s= declare_cursor_node |s= drop_table_node |s= drop_index_node |s= alter_index_node |s= alter_table_node |s= trace_node |s= create_function_node |s= drop_function_node |s= add_jars_node |s= list_jars_node |s= delete_jar_node |s= alter_session_node |s= create_sequence_node |s= grant_permission_node |s= revoke_permission_node |s= drop_sequence_node |s= drop_schema_node |s= use_schema_node |s= update_statistics_node |s= execute_upgrade_node |s= explain_node ) ;
	public final BindableStatement oneStatement() throws RecognitionException {
		BindableStatement ret = null;


		BindableStatement s =null;

		 contextStack.push(new ParseContext()); 
		try {
			// PhoenixSQL.g:413:5: ( (s= select_node |s= upsert_node |s= delete_node |s= create_table_node |s= create_schema_node |s= create_view_node |s= create_index_node |s= cursor_open_node |s= cursor_close_node |s= cursor_fetch_node |s= declare_cursor_node |s= drop_table_node |s= drop_index_node |s= alter_index_node |s= alter_table_node |s= trace_node |s= create_function_node |s= drop_function_node |s= add_jars_node |s= list_jars_node |s= delete_jar_node |s= alter_session_node |s= create_sequence_node |s= grant_permission_node |s= revoke_permission_node |s= drop_sequence_node |s= drop_schema_node |s= use_schema_node |s= update_statistics_node |s= execute_upgrade_node |s= explain_node ) )
			// PhoenixSQL.g:413:8: (s= select_node |s= upsert_node |s= delete_node |s= create_table_node |s= create_schema_node |s= create_view_node |s= create_index_node |s= cursor_open_node |s= cursor_close_node |s= cursor_fetch_node |s= declare_cursor_node |s= drop_table_node |s= drop_index_node |s= alter_index_node |s= alter_table_node |s= trace_node |s= create_function_node |s= drop_function_node |s= add_jars_node |s= list_jars_node |s= delete_jar_node |s= alter_session_node |s= create_sequence_node |s= grant_permission_node |s= revoke_permission_node |s= drop_sequence_node |s= drop_schema_node |s= use_schema_node |s= update_statistics_node |s= execute_upgrade_node |s= explain_node )
			{
			// PhoenixSQL.g:413:8: (s= select_node |s= upsert_node |s= delete_node |s= create_table_node |s= create_schema_node |s= create_view_node |s= create_index_node |s= cursor_open_node |s= cursor_close_node |s= cursor_fetch_node |s= declare_cursor_node |s= drop_table_node |s= drop_index_node |s= alter_index_node |s= alter_table_node |s= trace_node |s= create_function_node |s= drop_function_node |s= add_jars_node |s= list_jars_node |s= delete_jar_node |s= alter_session_node |s= create_sequence_node |s= grant_permission_node |s= revoke_permission_node |s= drop_sequence_node |s= drop_schema_node |s= use_schema_node |s= update_statistics_node |s= execute_upgrade_node |s= explain_node )
			int alt2=31;
			switch ( input.LA(1) ) {
			case SELECT:
				{
				alt2=1;
				}
				break;
			case UPSERT:
				{
				alt2=2;
				}
				break;
			case DELETE:
				{
				int LA2_3 = input.LA(2);
				if ( (LA2_3==JAR) ) {
					alt2=21;
				}
				else if ( (LA2_3==FROM||LA2_3==ML_HINT) ) {
					alt2=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CREATE:
				{
				switch ( input.LA(2) ) {
				case SCHEMA:
					{
					alt2=5;
					}
					break;
				case VIEW:
					{
					alt2=6;
					}
					break;
				case SEQUENCE:
					{
					alt2=23;
					}
					break;
				case IMMUTABLE:
				case TABLE:
					{
					alt2=4;
					}
					break;
				case INDEX:
				case LOCAL:
					{
					alt2=7;
					}
					break;
				case FUNCTION:
				case OR:
				case TEMPORARY:
					{
					alt2=17;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case OPEN:
				{
				alt2=8;
				}
				break;
			case CLOSE:
				{
				alt2=9;
				}
				break;
			case FETCH:
				{
				alt2=10;
				}
				break;
			case DECLARE:
				{
				alt2=11;
				}
				break;
			case DROP:
				{
				switch ( input.LA(2) ) {
				case INDEX:
					{
					alt2=13;
					}
					break;
				case FUNCTION:
					{
					alt2=18;
					}
					break;
				case SEQUENCE:
					{
					alt2=26;
					}
					break;
				case SCHEMA:
					{
					alt2=27;
					}
					break;
				case TABLE:
				case VIEW:
					{
					alt2=12;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 9, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case ALTER:
				{
				switch ( input.LA(2) ) {
				case INDEX:
					{
					alt2=14;
					}
					break;
				case SESSION:
					{
					alt2=22;
					}
					break;
				case TABLE:
				case VIEW:
					{
					alt2=15;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 10, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case TRACE:
				{
				alt2=16;
				}
				break;
			case ADD:
				{
				alt2=19;
				}
				break;
			case LIST:
				{
				alt2=20;
				}
				break;
			case GRANT:
				{
				alt2=24;
				}
				break;
			case REVOKE:
				{
				alt2=25;
				}
				break;
			case USE:
				{
				alt2=28;
				}
				break;
			case UPDATE:
				{
				alt2=29;
				}
				break;
			case EXECUTE:
				{
				alt2=30;
				}
				break;
			case EXPLAIN:
				{
				alt2=31;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// PhoenixSQL.g:413:9: s= select_node
					{
					pushFollow(FOLLOW_select_node_in_oneStatement1378);
					s=select_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 2 :
					// PhoenixSQL.g:414:7: s= upsert_node
					{
					pushFollow(FOLLOW_upsert_node_in_oneStatement1388);
					s=upsert_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 3 :
					// PhoenixSQL.g:415:9: s= delete_node
					{
					pushFollow(FOLLOW_delete_node_in_oneStatement1400);
					s=delete_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 4 :
					// PhoenixSQL.g:416:9: s= create_table_node
					{
					pushFollow(FOLLOW_create_table_node_in_oneStatement1412);
					s=create_table_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 5 :
					// PhoenixSQL.g:417:9: s= create_schema_node
					{
					pushFollow(FOLLOW_create_schema_node_in_oneStatement1424);
					s=create_schema_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 6 :
					// PhoenixSQL.g:418:9: s= create_view_node
					{
					pushFollow(FOLLOW_create_view_node_in_oneStatement1436);
					s=create_view_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 7 :
					// PhoenixSQL.g:419:9: s= create_index_node
					{
					pushFollow(FOLLOW_create_index_node_in_oneStatement1448);
					s=create_index_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 8 :
					// PhoenixSQL.g:420:9: s= cursor_open_node
					{
					pushFollow(FOLLOW_cursor_open_node_in_oneStatement1460);
					s=cursor_open_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 9 :
					// PhoenixSQL.g:421:9: s= cursor_close_node
					{
					pushFollow(FOLLOW_cursor_close_node_in_oneStatement1472);
					s=cursor_close_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 10 :
					// PhoenixSQL.g:422:9: s= cursor_fetch_node
					{
					pushFollow(FOLLOW_cursor_fetch_node_in_oneStatement1484);
					s=cursor_fetch_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 11 :
					// PhoenixSQL.g:423:9: s= declare_cursor_node
					{
					pushFollow(FOLLOW_declare_cursor_node_in_oneStatement1496);
					s=declare_cursor_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 12 :
					// PhoenixSQL.g:424:9: s= drop_table_node
					{
					pushFollow(FOLLOW_drop_table_node_in_oneStatement1508);
					s=drop_table_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 13 :
					// PhoenixSQL.g:425:9: s= drop_index_node
					{
					pushFollow(FOLLOW_drop_index_node_in_oneStatement1520);
					s=drop_index_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 14 :
					// PhoenixSQL.g:426:9: s= alter_index_node
					{
					pushFollow(FOLLOW_alter_index_node_in_oneStatement1532);
					s=alter_index_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 15 :
					// PhoenixSQL.g:427:9: s= alter_table_node
					{
					pushFollow(FOLLOW_alter_table_node_in_oneStatement1544);
					s=alter_table_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 16 :
					// PhoenixSQL.g:428:9: s= trace_node
					{
					pushFollow(FOLLOW_trace_node_in_oneStatement1556);
					s=trace_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 17 :
					// PhoenixSQL.g:429:9: s= create_function_node
					{
					pushFollow(FOLLOW_create_function_node_in_oneStatement1568);
					s=create_function_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 18 :
					// PhoenixSQL.g:430:9: s= drop_function_node
					{
					pushFollow(FOLLOW_drop_function_node_in_oneStatement1580);
					s=drop_function_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 19 :
					// PhoenixSQL.g:431:9: s= add_jars_node
					{
					pushFollow(FOLLOW_add_jars_node_in_oneStatement1592);
					s=add_jars_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 20 :
					// PhoenixSQL.g:432:9: s= list_jars_node
					{
					pushFollow(FOLLOW_list_jars_node_in_oneStatement1604);
					s=list_jars_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 21 :
					// PhoenixSQL.g:433:9: s= delete_jar_node
					{
					pushFollow(FOLLOW_delete_jar_node_in_oneStatement1616);
					s=delete_jar_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 22 :
					// PhoenixSQL.g:434:9: s= alter_session_node
					{
					pushFollow(FOLLOW_alter_session_node_in_oneStatement1628);
					s=alter_session_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 23 :
					// PhoenixSQL.g:435:7: s= create_sequence_node
					{
					pushFollow(FOLLOW_create_sequence_node_in_oneStatement1638);
					s=create_sequence_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 24 :
					// PhoenixSQL.g:436:9: s= grant_permission_node
					{
					pushFollow(FOLLOW_grant_permission_node_in_oneStatement1650);
					s=grant_permission_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 25 :
					// PhoenixSQL.g:437:9: s= revoke_permission_node
					{
					pushFollow(FOLLOW_revoke_permission_node_in_oneStatement1662);
					s=revoke_permission_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 26 :
					// PhoenixSQL.g:438:7: s= drop_sequence_node
					{
					pushFollow(FOLLOW_drop_sequence_node_in_oneStatement1672);
					s=drop_sequence_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 27 :
					// PhoenixSQL.g:439:7: s= drop_schema_node
					{
					pushFollow(FOLLOW_drop_schema_node_in_oneStatement1682);
					s=drop_schema_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 28 :
					// PhoenixSQL.g:440:7: s= use_schema_node
					{
					pushFollow(FOLLOW_use_schema_node_in_oneStatement1692);
					s=use_schema_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 29 :
					// PhoenixSQL.g:441:9: s= update_statistics_node
					{
					pushFollow(FOLLOW_update_statistics_node_in_oneStatement1704);
					s=update_statistics_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 30 :
					// PhoenixSQL.g:442:9: s= execute_upgrade_node
					{
					pushFollow(FOLLOW_execute_upgrade_node_in_oneStatement1716);
					s=execute_upgrade_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;
				case 31 :
					// PhoenixSQL.g:443:9: s= explain_node
					{
					pushFollow(FOLLOW_explain_node_in_oneStatement1728);
					s=explain_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) { ret = s; }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
			 contextStack.pop(); 
		}
		return ret;
	}
	// $ANTLR end "oneStatement"



	// $ANTLR start "explain_node"
	// PhoenixSQL.g:447:1: explain_node returns [BindableStatement ret] : EXPLAIN q= oneStatement ;
	public final BindableStatement explain_node() throws RecognitionException {
		BindableStatement ret = null;


		BindableStatement q =null;

		try {
			// PhoenixSQL.g:448:5: ( EXPLAIN q= oneStatement )
			// PhoenixSQL.g:448:9: EXPLAIN q= oneStatement
			{
			match(input,EXPLAIN,FOLLOW_EXPLAIN_in_explain_node1761); if (state.failed) return ret;
			pushFollow(FOLLOW_oneStatement_in_explain_node1765);
			q=oneStatement();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret =factory.explain(q);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "explain_node"



	// $ANTLR start "create_table_node"
	// PhoenixSQL.g:452:1: create_table_node returns [CreateTableStatement ret] : CREATE (im= IMMUTABLE )? TABLE ( IF NOT ex= EXISTS )? t= from_table_name ( LPAREN c= column_defs (pk= pk_constraint )? RPAREN ) (p= fam_properties )? ( SPLIT ON s= value_expression_list )? ;
	public final CreateTableStatement create_table_node() throws RecognitionException {
		CreateTableStatement ret = null;


		Token im=null;
		Token ex=null;
		TableName t =null;
		List<ColumnDef> c =null;
		PrimaryKeyConstraint pk =null;
		ListMultimap<String,Pair<String,Object>> p =null;
		List<ParseNode> s =null;

		try {
			// PhoenixSQL.g:453:5: ( CREATE (im= IMMUTABLE )? TABLE ( IF NOT ex= EXISTS )? t= from_table_name ( LPAREN c= column_defs (pk= pk_constraint )? RPAREN ) (p= fam_properties )? ( SPLIT ON s= value_expression_list )? )
			// PhoenixSQL.g:453:9: CREATE (im= IMMUTABLE )? TABLE ( IF NOT ex= EXISTS )? t= from_table_name ( LPAREN c= column_defs (pk= pk_constraint )? RPAREN ) (p= fam_properties )? ( SPLIT ON s= value_expression_list )?
			{
			match(input,CREATE,FOLLOW_CREATE_in_create_table_node1791); if (state.failed) return ret;
			// PhoenixSQL.g:453:16: (im= IMMUTABLE )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IMMUTABLE) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// PhoenixSQL.g:453:17: im= IMMUTABLE
					{
					im=(Token)match(input,IMMUTABLE,FOLLOW_IMMUTABLE_in_create_table_node1796); if (state.failed) return ret;
					}
					break;

			}

			match(input,TABLE,FOLLOW_TABLE_in_create_table_node1800); if (state.failed) return ret;
			// PhoenixSQL.g:453:38: ( IF NOT ex= EXISTS )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==IF) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// PhoenixSQL.g:453:39: IF NOT ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_create_table_node1803); if (state.failed) return ret;
					match(input,NOT,FOLLOW_NOT_in_create_table_node1805); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_create_table_node1809); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_from_table_name_in_create_table_node1815);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:454:9: ( LPAREN c= column_defs (pk= pk_constraint )? RPAREN )
			// PhoenixSQL.g:454:10: LPAREN c= column_defs (pk= pk_constraint )? RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_create_table_node1827); if (state.failed) return ret;
			pushFollow(FOLLOW_column_defs_in_create_table_node1831);
			c=column_defs();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:454:31: (pk= pk_constraint )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==COMMA||LA5_0==CONSTRAINT) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// PhoenixSQL.g:454:32: pk= pk_constraint
					{
					pushFollow(FOLLOW_pk_constraint_in_create_table_node1836);
					pk=pk_constraint();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			match(input,RPAREN,FOLLOW_RPAREN_in_create_table_node1840); if (state.failed) return ret;
			}

			// PhoenixSQL.g:455:9: (p= fam_properties )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==NAME) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// PhoenixSQL.g:455:10: p= fam_properties
					{
					pushFollow(FOLLOW_fam_properties_in_create_table_node1854);
					p=fam_properties();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:456:9: ( SPLIT ON s= value_expression_list )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==SPLIT) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// PhoenixSQL.g:456:10: SPLIT ON s= value_expression_list
					{
					match(input,SPLIT,FOLLOW_SPLIT_in_create_table_node1867); if (state.failed) return ret;
					match(input,ON,FOLLOW_ON_in_create_table_node1869); if (state.failed) return ret;
					pushFollow(FOLLOW_value_expression_list_in_create_table_node1873);
					s=value_expression_list();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.createTable(t, p, c, pk, s, PTableType.TABLE, ex!=null, null, null, getBindCount(), im!=null ? true : null); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "create_table_node"



	// $ANTLR start "create_schema_node"
	// PhoenixSQL.g:461:1: create_schema_node returns [CreateSchemaStatement ret] : CREATE SCHEMA ( IF NOT ex= EXISTS )? s= identifier ;
	public final CreateSchemaStatement create_schema_node() throws RecognitionException {
		CreateSchemaStatement ret = null;


		Token ex=null;
		String s =null;

		try {
			// PhoenixSQL.g:462:5: ( CREATE SCHEMA ( IF NOT ex= EXISTS )? s= identifier )
			// PhoenixSQL.g:462:9: CREATE SCHEMA ( IF NOT ex= EXISTS )? s= identifier
			{
			match(input,CREATE,FOLLOW_CREATE_in_create_schema_node1912); if (state.failed) return ret;
			match(input,SCHEMA,FOLLOW_SCHEMA_in_create_schema_node1914); if (state.failed) return ret;
			// PhoenixSQL.g:462:23: ( IF NOT ex= EXISTS )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==IF) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// PhoenixSQL.g:462:24: IF NOT ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_create_schema_node1917); if (state.failed) return ret;
					match(input,NOT,FOLLOW_NOT_in_create_schema_node1919); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_create_schema_node1923); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_identifier_in_create_schema_node1929);
			s=identifier();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.createSchema(s, ex!=null); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "create_schema_node"



	// $ANTLR start "grant_permission_node"
	// PhoenixSQL.g:467:1: grant_permission_node returns [ChangePermsStatement ret] : GRANT p= literal ( ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier ) )? TO (g= GROUP )? ug= literal ;
	public final ChangePermsStatement grant_permission_node() throws RecognitionException {
		ChangePermsStatement ret = null;


		Token s=null;
		Token g=null;
		LiteralParseNode p =null;
		TableName table =null;
		String schema =null;
		LiteralParseNode ug =null;

		try {
			// PhoenixSQL.g:468:5: ( GRANT p= literal ( ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier ) )? TO (g= GROUP )? ug= literal )
			// PhoenixSQL.g:468:9: GRANT p= literal ( ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier ) )? TO (g= GROUP )? ug= literal
			{
			match(input,GRANT,FOLLOW_GRANT_in_grant_permission_node1963); if (state.failed) return ret;
			pushFollow(FOLLOW_literal_in_grant_permission_node1967);
			p=literal();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:468:25: ( ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier ) )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==ON) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// PhoenixSQL.g:468:26: ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier )
					{
					match(input,ON,FOLLOW_ON_in_grant_permission_node1970); if (state.failed) return ret;
					// PhoenixSQL.g:468:29: ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier )
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==NAME||LA10_0==TABLE) ) {
						alt10=1;
					}
					else if ( (LA10_0==SCHEMA) ) {
						alt10=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						throw nvae;
					}

					switch (alt10) {
						case 1 :
							// PhoenixSQL.g:468:30: ( TABLE )? table= table_name
							{
							// PhoenixSQL.g:468:30: ( TABLE )?
							int alt9=2;
							int LA9_0 = input.LA(1);
							if ( (LA9_0==TABLE) ) {
								alt9=1;
							}
							switch (alt9) {
								case 1 :
									// PhoenixSQL.g:468:31: TABLE
									{
									match(input,TABLE,FOLLOW_TABLE_in_grant_permission_node1974); if (state.failed) return ret;
									}
									break;

							}

							pushFollow(FOLLOW_table_name_in_grant_permission_node1980);
							table=table_name();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;
						case 2 :
							// PhoenixSQL.g:468:58: s= SCHEMA schema= identifier
							{
							s=(Token)match(input,SCHEMA,FOLLOW_SCHEMA_in_grant_permission_node1986); if (state.failed) return ret;
							pushFollow(FOLLOW_identifier_in_grant_permission_node1990);
							schema=identifier();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					}
					break;

			}

			match(input,TO,FOLLOW_TO_in_grant_permission_node1995); if (state.failed) return ret;
			// PhoenixSQL.g:468:91: (g= GROUP )?
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==GROUP) ) {
				alt12=1;
			}
			switch (alt12) {
				case 1 :
					// PhoenixSQL.g:468:92: g= GROUP
					{
					g=(Token)match(input,GROUP,FOLLOW_GROUP_in_grant_permission_node2000); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_literal_in_grant_permission_node2006);
			ug=literal();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {
			            String permsString = SchemaUtil.normalizeLiteral(p);
			            if (permsString != null && permsString.length() > 5) {
			                throw new RuntimeException("Permissions String length should be less than 5 characters");
			            }
			            ret = factory.changePermsStatement(permsString, s!=null, table, schema, g!=null, ug, Boolean.TRUE);
			        }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "grant_permission_node"



	// $ANTLR start "revoke_permission_node"
	// PhoenixSQL.g:479:1: revoke_permission_node returns [ChangePermsStatement ret] : REVOKE (p= literal )? ( ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier ) )? FROM (g= GROUP )? ug= literal ;
	public final ChangePermsStatement revoke_permission_node() throws RecognitionException {
		ChangePermsStatement ret = null;


		Token s=null;
		Token g=null;
		LiteralParseNode p =null;
		TableName table =null;
		String schema =null;
		LiteralParseNode ug =null;

		try {
			// PhoenixSQL.g:480:5: ( REVOKE (p= literal )? ( ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier ) )? FROM (g= GROUP )? ug= literal )
			// PhoenixSQL.g:480:9: REVOKE (p= literal )? ( ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier ) )? FROM (g= GROUP )? ug= literal
			{
			match(input,REVOKE,FOLLOW_REVOKE_in_revoke_permission_node2040); if (state.failed) return ret;
			// PhoenixSQL.g:480:16: (p= literal )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==DECIMAL||LA13_0==DOUBLE||LA13_0==FALSE||LA13_0==NAME||LA13_0==NULL||LA13_0==NUMBER||LA13_0==STRING_LITERAL||LA13_0==TRUE) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// PhoenixSQL.g:480:17: p= literal
					{
					pushFollow(FOLLOW_literal_in_revoke_permission_node2045);
					p=literal();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:480:29: ( ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier ) )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==ON) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// PhoenixSQL.g:480:30: ON ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier )
					{
					match(input,ON,FOLLOW_ON_in_revoke_permission_node2050); if (state.failed) return ret;
					// PhoenixSQL.g:480:33: ( ( TABLE )? table= table_name |s= SCHEMA schema= identifier )
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==NAME||LA15_0==TABLE) ) {
						alt15=1;
					}
					else if ( (LA15_0==SCHEMA) ) {
						alt15=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						NoViableAltException nvae =
							new NoViableAltException("", 15, 0, input);
						throw nvae;
					}

					switch (alt15) {
						case 1 :
							// PhoenixSQL.g:480:34: ( TABLE )? table= table_name
							{
							// PhoenixSQL.g:480:34: ( TABLE )?
							int alt14=2;
							int LA14_0 = input.LA(1);
							if ( (LA14_0==TABLE) ) {
								alt14=1;
							}
							switch (alt14) {
								case 1 :
									// PhoenixSQL.g:480:35: TABLE
									{
									match(input,TABLE,FOLLOW_TABLE_in_revoke_permission_node2054); if (state.failed) return ret;
									}
									break;

							}

							pushFollow(FOLLOW_table_name_in_revoke_permission_node2060);
							table=table_name();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;
						case 2 :
							// PhoenixSQL.g:480:62: s= SCHEMA schema= identifier
							{
							s=(Token)match(input,SCHEMA,FOLLOW_SCHEMA_in_revoke_permission_node2066); if (state.failed) return ret;
							pushFollow(FOLLOW_identifier_in_revoke_permission_node2070);
							schema=identifier();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					}
					break;

			}

			match(input,FROM,FOLLOW_FROM_in_revoke_permission_node2075); if (state.failed) return ret;
			// PhoenixSQL.g:480:97: (g= GROUP )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==GROUP) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// PhoenixSQL.g:480:98: g= GROUP
					{
					g=(Token)match(input,GROUP,FOLLOW_GROUP_in_revoke_permission_node2080); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_literal_in_revoke_permission_node2086);
			ug=literal();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {
			            String permsString = SchemaUtil.normalizeLiteral(p);
			            if (permsString != null && permsString.length() > 5) {
			                throw new RuntimeException("Permissions String length should be less than 5 characters");
			            }
			            ret = factory.changePermsStatement(permsString, s!=null, table, schema, g!=null, ug, Boolean.FALSE);
			        }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "revoke_permission_node"



	// $ANTLR start "create_view_node"
	// PhoenixSQL.g:491:1: create_view_node returns [CreateTableStatement ret] : CREATE VIEW ( IF NOT ex= EXISTS )? t= from_table_name ( LPAREN c= column_defs (pk= pk_constraint )? RPAREN )? ( AS SELECT ASTERISK FROM bt= from_table_name ( WHERE w= expression )? )? (p= fam_properties )? ;
	public final CreateTableStatement create_view_node() throws RecognitionException {
		CreateTableStatement ret = null;


		Token ex=null;
		TableName t =null;
		List<ColumnDef> c =null;
		PrimaryKeyConstraint pk =null;
		TableName bt =null;
		ParseNode w =null;
		ListMultimap<String,Pair<String,Object>> p =null;

		try {
			// PhoenixSQL.g:492:5: ( CREATE VIEW ( IF NOT ex= EXISTS )? t= from_table_name ( LPAREN c= column_defs (pk= pk_constraint )? RPAREN )? ( AS SELECT ASTERISK FROM bt= from_table_name ( WHERE w= expression )? )? (p= fam_properties )? )
			// PhoenixSQL.g:492:9: CREATE VIEW ( IF NOT ex= EXISTS )? t= from_table_name ( LPAREN c= column_defs (pk= pk_constraint )? RPAREN )? ( AS SELECT ASTERISK FROM bt= from_table_name ( WHERE w= expression )? )? (p= fam_properties )?
			{
			match(input,CREATE,FOLLOW_CREATE_in_create_view_node2120); if (state.failed) return ret;
			match(input,VIEW,FOLLOW_VIEW_in_create_view_node2122); if (state.failed) return ret;
			// PhoenixSQL.g:492:21: ( IF NOT ex= EXISTS )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==IF) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// PhoenixSQL.g:492:22: IF NOT ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_create_view_node2125); if (state.failed) return ret;
					match(input,NOT,FOLLOW_NOT_in_create_view_node2127); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_create_view_node2131); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_from_table_name_in_create_view_node2137);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:493:9: ( LPAREN c= column_defs (pk= pk_constraint )? RPAREN )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==LPAREN) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// PhoenixSQL.g:493:10: LPAREN c= column_defs (pk= pk_constraint )? RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_create_view_node2149); if (state.failed) return ret;
					pushFollow(FOLLOW_column_defs_in_create_view_node2153);
					c=column_defs();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:493:31: (pk= pk_constraint )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==COMMA||LA19_0==CONSTRAINT) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// PhoenixSQL.g:493:32: pk= pk_constraint
							{
							pushFollow(FOLLOW_pk_constraint_in_create_view_node2158);
							pk=pk_constraint();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_create_view_node2162); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:494:9: ( AS SELECT ASTERISK FROM bt= from_table_name ( WHERE w= expression )? )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==AS) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// PhoenixSQL.g:494:11: AS SELECT ASTERISK FROM bt= from_table_name ( WHERE w= expression )?
					{
					match(input,AS,FOLLOW_AS_in_create_view_node2176); if (state.failed) return ret;
					match(input,SELECT,FOLLOW_SELECT_in_create_view_node2178); if (state.failed) return ret;
					match(input,ASTERISK,FOLLOW_ASTERISK_in_create_view_node2180); if (state.failed) return ret;
					match(input,FROM,FOLLOW_FROM_in_create_view_node2192); if (state.failed) return ret;
					pushFollow(FOLLOW_from_table_name_in_create_view_node2196);
					bt=from_table_name();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:496:11: ( WHERE w= expression )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==WHERE) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// PhoenixSQL.g:496:12: WHERE w= expression
							{
							match(input,WHERE,FOLLOW_WHERE_in_create_view_node2209); if (state.failed) return ret;
							pushFollow(FOLLOW_expression_in_create_view_node2213);
							w=expression();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					}
					break;

			}

			// PhoenixSQL.g:497:9: (p= fam_properties )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==NAME) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// PhoenixSQL.g:497:10: p= fam_properties
					{
					pushFollow(FOLLOW_fam_properties_in_create_view_node2231);
					p=fam_properties();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) { ret = factory.createTable(t, p, c, pk, null, PTableType.VIEW, ex!=null, bt==null ? t : bt, w, getBindCount(), null); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "create_view_node"



	// $ANTLR start "create_index_node"
	// PhoenixSQL.g:502:1: create_index_node returns [CreateIndexStatement ret] : CREATE (l= LOCAL )? INDEX ( IF NOT ex= EXISTS )? i= index_name ON t= from_table_name ( LPAREN ik= ik_constraint RPAREN ) ( INCLUDE ( LPAREN icrefs= column_names RPAREN ) )? (async= ASYNC )? (p= fam_properties )? ( SPLIT ON v= value_expression_list )? ;
	public final CreateIndexStatement create_index_node() throws RecognitionException {
		CreateIndexStatement ret = null;


		Token l=null;
		Token ex=null;
		Token async=null;
		NamedNode i =null;
		TableName t =null;
		IndexKeyConstraint ik =null;
		List<ColumnName> icrefs =null;
		ListMultimap<String,Pair<String,Object>> p =null;
		List<ParseNode> v =null;

		try {
			// PhoenixSQL.g:503:5: ( CREATE (l= LOCAL )? INDEX ( IF NOT ex= EXISTS )? i= index_name ON t= from_table_name ( LPAREN ik= ik_constraint RPAREN ) ( INCLUDE ( LPAREN icrefs= column_names RPAREN ) )? (async= ASYNC )? (p= fam_properties )? ( SPLIT ON v= value_expression_list )? )
			// PhoenixSQL.g:503:9: CREATE (l= LOCAL )? INDEX ( IF NOT ex= EXISTS )? i= index_name ON t= from_table_name ( LPAREN ik= ik_constraint RPAREN ) ( INCLUDE ( LPAREN icrefs= column_names RPAREN ) )? (async= ASYNC )? (p= fam_properties )? ( SPLIT ON v= value_expression_list )?
			{
			match(input,CREATE,FOLLOW_CREATE_in_create_index_node2267); if (state.failed) return ret;
			// PhoenixSQL.g:503:17: (l= LOCAL )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==LOCAL) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// PhoenixSQL.g:503:17: l= LOCAL
					{
					l=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_create_index_node2271); if (state.failed) return ret;
					}
					break;

			}

			match(input,INDEX,FOLLOW_INDEX_in_create_index_node2274); if (state.failed) return ret;
			// PhoenixSQL.g:503:31: ( IF NOT ex= EXISTS )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==IF) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// PhoenixSQL.g:503:32: IF NOT ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_create_index_node2277); if (state.failed) return ret;
					match(input,NOT,FOLLOW_NOT_in_create_index_node2279); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_create_index_node2283); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_index_name_in_create_index_node2289);
			i=index_name();
			state._fsp--;
			if (state.failed) return ret;
			match(input,ON,FOLLOW_ON_in_create_index_node2291); if (state.failed) return ret;
			pushFollow(FOLLOW_from_table_name_in_create_index_node2295);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:504:9: ( LPAREN ik= ik_constraint RPAREN )
			// PhoenixSQL.g:504:10: LPAREN ik= ik_constraint RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_create_index_node2306); if (state.failed) return ret;
			pushFollow(FOLLOW_ik_constraint_in_create_index_node2310);
			ik=ik_constraint();
			state._fsp--;
			if (state.failed) return ret;
			match(input,RPAREN,FOLLOW_RPAREN_in_create_index_node2312); if (state.failed) return ret;
			}

			// PhoenixSQL.g:505:9: ( INCLUDE ( LPAREN icrefs= column_names RPAREN ) )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==INCLUDE) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// PhoenixSQL.g:505:10: INCLUDE ( LPAREN icrefs= column_names RPAREN )
					{
					match(input,INCLUDE,FOLLOW_INCLUDE_in_create_index_node2324); if (state.failed) return ret;
					// PhoenixSQL.g:505:18: ( LPAREN icrefs= column_names RPAREN )
					// PhoenixSQL.g:505:19: LPAREN icrefs= column_names RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_create_index_node2327); if (state.failed) return ret;
					pushFollow(FOLLOW_column_names_in_create_index_node2331);
					icrefs=column_names();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_create_index_node2333); if (state.failed) return ret;
					}

					}
					break;

			}

			// PhoenixSQL.g:506:9: (async= ASYNC )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==ASYNC) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// PhoenixSQL.g:506:10: async= ASYNC
					{
					async=(Token)match(input,ASYNC,FOLLOW_ASYNC_in_create_index_node2349); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:507:9: (p= fam_properties )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==NAME) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// PhoenixSQL.g:507:10: p= fam_properties
					{
					pushFollow(FOLLOW_fam_properties_in_create_index_node2364);
					p=fam_properties();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:508:9: ( SPLIT ON v= value_expression_list )?
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==SPLIT) ) {
				alt29=1;
			}
			switch (alt29) {
				case 1 :
					// PhoenixSQL.g:508:10: SPLIT ON v= value_expression_list
					{
					match(input,SPLIT,FOLLOW_SPLIT_in_create_index_node2377); if (state.failed) return ret;
					match(input,ON,FOLLOW_ON_in_create_index_node2379); if (state.failed) return ret;
					pushFollow(FOLLOW_value_expression_list_in_create_index_node2383);
					v=value_expression_list();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.createIndex(i, factory.namedTable(null,t), ik, icrefs, v, p, ex!=null, l==null ? IndexType.getDefault() : IndexType.LOCAL, async != null, getBindCount(), new HashMap<String, UDFParseNode>(udfParseNodes)); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "create_index_node"



	// $ANTLR start "create_sequence_node"
	// PhoenixSQL.g:513:1: create_sequence_node returns [CreateSequenceStatement ret] : CREATE SEQUENCE ( IF NOT ex= EXISTS )? t= from_table_name ( START ( WITH )? s= value_expression )? ( INCREMENT ( BY )? i= value_expression )? ( MINVALUE min= value_expression )? ( MAXVALUE max= value_expression )? (cyc= CYCLE )? ( CACHE c= int_literal_or_bind )? ;
	public final CreateSequenceStatement create_sequence_node() throws RecognitionException {
		CreateSequenceStatement ret = null;


		Token ex=null;
		Token cyc=null;
		TableName t =null;
		ParseNode s =null;
		ParseNode i =null;
		ParseNode min =null;
		ParseNode max =null;
		ParseNode c =null;

		try {
			// PhoenixSQL.g:514:5: ( CREATE SEQUENCE ( IF NOT ex= EXISTS )? t= from_table_name ( START ( WITH )? s= value_expression )? ( INCREMENT ( BY )? i= value_expression )? ( MINVALUE min= value_expression )? ( MAXVALUE max= value_expression )? (cyc= CYCLE )? ( CACHE c= int_literal_or_bind )? )
			// PhoenixSQL.g:514:9: CREATE SEQUENCE ( IF NOT ex= EXISTS )? t= from_table_name ( START ( WITH )? s= value_expression )? ( INCREMENT ( BY )? i= value_expression )? ( MINVALUE min= value_expression )? ( MAXVALUE max= value_expression )? (cyc= CYCLE )? ( CACHE c= int_literal_or_bind )?
			{
			match(input,CREATE,FOLLOW_CREATE_in_create_sequence_node2419); if (state.failed) return ret;
			match(input,SEQUENCE,FOLLOW_SEQUENCE_in_create_sequence_node2421); if (state.failed) return ret;
			// PhoenixSQL.g:514:26: ( IF NOT ex= EXISTS )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==IF) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// PhoenixSQL.g:514:27: IF NOT ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_create_sequence_node2425); if (state.failed) return ret;
					match(input,NOT,FOLLOW_NOT_in_create_sequence_node2427); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_create_sequence_node2431); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_from_table_name_in_create_sequence_node2437);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:515:9: ( START ( WITH )? s= value_expression )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==START) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// PhoenixSQL.g:515:10: START ( WITH )? s= value_expression
					{
					match(input,START,FOLLOW_START_in_create_sequence_node2448); if (state.failed) return ret;
					// PhoenixSQL.g:515:16: ( WITH )?
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( (LA31_0==WITH) ) {
						alt31=1;
					}
					switch (alt31) {
						case 1 :
							// PhoenixSQL.g:515:16: WITH
							{
							match(input,WITH,FOLLOW_WITH_in_create_sequence_node2450); if (state.failed) return ret;
							}
							break;

					}

					pushFollow(FOLLOW_value_expression_in_create_sequence_node2455);
					s=value_expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:516:9: ( INCREMENT ( BY )? i= value_expression )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==INCREMENT) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// PhoenixSQL.g:516:10: INCREMENT ( BY )? i= value_expression
					{
					match(input,INCREMENT,FOLLOW_INCREMENT_in_create_sequence_node2468); if (state.failed) return ret;
					// PhoenixSQL.g:516:20: ( BY )?
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==BY) ) {
						alt33=1;
					}
					switch (alt33) {
						case 1 :
							// PhoenixSQL.g:516:20: BY
							{
							match(input,BY,FOLLOW_BY_in_create_sequence_node2470); if (state.failed) return ret;
							}
							break;

					}

					pushFollow(FOLLOW_value_expression_in_create_sequence_node2475);
					i=value_expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:517:9: ( MINVALUE min= value_expression )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==MINVALUE) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// PhoenixSQL.g:517:10: MINVALUE min= value_expression
					{
					match(input,MINVALUE,FOLLOW_MINVALUE_in_create_sequence_node2488); if (state.failed) return ret;
					pushFollow(FOLLOW_value_expression_in_create_sequence_node2492);
					min=value_expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:518:9: ( MAXVALUE max= value_expression )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==MAXVALUE) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// PhoenixSQL.g:518:10: MAXVALUE max= value_expression
					{
					match(input,MAXVALUE,FOLLOW_MAXVALUE_in_create_sequence_node2505); if (state.failed) return ret;
					pushFollow(FOLLOW_value_expression_in_create_sequence_node2509);
					max=value_expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:519:9: (cyc= CYCLE )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==CYCLE) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// PhoenixSQL.g:519:10: cyc= CYCLE
					{
					cyc=(Token)match(input,CYCLE,FOLLOW_CYCLE_in_create_sequence_node2524); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:520:9: ( CACHE c= int_literal_or_bind )?
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==CACHE) ) {
				alt38=1;
			}
			switch (alt38) {
				case 1 :
					// PhoenixSQL.g:520:10: CACHE c= int_literal_or_bind
					{
					match(input,CACHE,FOLLOW_CACHE_in_create_sequence_node2538); if (state.failed) return ret;
					pushFollow(FOLLOW_int_literal_or_bind_in_create_sequence_node2542);
					c=int_literal_or_bind();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) { ret = factory.createSequence(t, s, i, c, min, max, cyc!=null, ex!=null, getBindCount()); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "create_sequence_node"



	// $ANTLR start "int_literal_or_bind"
	// PhoenixSQL.g:524:1: int_literal_or_bind returns [ParseNode ret] : (n= int_or_long_literal |b= bind_expression );
	public final ParseNode int_literal_or_bind() throws RecognitionException {
		ParseNode ret = null;


		LiteralParseNode n =null;
		BindParseNode b =null;

		try {
			// PhoenixSQL.g:525:5: (n= int_or_long_literal |b= bind_expression )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==NUMBER) ) {
				alt39=1;
			}
			else if ( (LA39_0==BIND_NAME||LA39_0==QUESTION) ) {
				alt39=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// PhoenixSQL.g:525:7: n= int_or_long_literal
					{
					pushFollow(FOLLOW_int_or_long_literal_in_int_literal_or_bind2573);
					n=int_or_long_literal();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = n; }
					}
					break;
				case 2 :
					// PhoenixSQL.g:526:7: b= bind_expression
					{
					pushFollow(FOLLOW_bind_expression_in_int_literal_or_bind2585);
					b=bind_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = b; }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "int_literal_or_bind"



	// $ANTLR start "drop_sequence_node"
	// PhoenixSQL.g:530:1: drop_sequence_node returns [DropSequenceStatement ret] : DROP SEQUENCE ( IF ex= EXISTS )? t= from_table_name ;
	public final DropSequenceStatement drop_sequence_node() throws RecognitionException {
		DropSequenceStatement ret = null;


		Token ex=null;
		TableName t =null;

		try {
			// PhoenixSQL.g:531:5: ( DROP SEQUENCE ( IF ex= EXISTS )? t= from_table_name )
			// PhoenixSQL.g:531:9: DROP SEQUENCE ( IF ex= EXISTS )? t= from_table_name
			{
			match(input,DROP,FOLLOW_DROP_in_drop_sequence_node2611); if (state.failed) return ret;
			match(input,SEQUENCE,FOLLOW_SEQUENCE_in_drop_sequence_node2613); if (state.failed) return ret;
			// PhoenixSQL.g:531:24: ( IF ex= EXISTS )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==IF) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// PhoenixSQL.g:531:25: IF ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_drop_sequence_node2617); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_drop_sequence_node2621); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_from_table_name_in_drop_sequence_node2627);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = factory.dropSequence(t, ex!=null, getBindCount()); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "drop_sequence_node"



	// $ANTLR start "pk_constraint"
	// PhoenixSQL.g:535:1: pk_constraint returns [PrimaryKeyConstraint ret] : ( COMMA )? CONSTRAINT n= identifier PRIMARY KEY LPAREN cols= col_name_with_sort_order_rowtimestamp_list RPAREN ;
	public final PrimaryKeyConstraint pk_constraint() throws RecognitionException {
		PrimaryKeyConstraint ret = null;


		String n =null;
		List<ColumnDefInPkConstraint> cols =null;

		try {
			// PhoenixSQL.g:536:5: ( ( COMMA )? CONSTRAINT n= identifier PRIMARY KEY LPAREN cols= col_name_with_sort_order_rowtimestamp_list RPAREN )
			// PhoenixSQL.g:536:9: ( COMMA )? CONSTRAINT n= identifier PRIMARY KEY LPAREN cols= col_name_with_sort_order_rowtimestamp_list RPAREN
			{
			// PhoenixSQL.g:536:9: ( COMMA )?
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==COMMA) ) {
				alt41=1;
			}
			switch (alt41) {
				case 1 :
					// PhoenixSQL.g:536:9: COMMA
					{
					match(input,COMMA,FOLLOW_COMMA_in_pk_constraint2656); if (state.failed) return ret;
					}
					break;

			}

			match(input,CONSTRAINT,FOLLOW_CONSTRAINT_in_pk_constraint2659); if (state.failed) return ret;
			pushFollow(FOLLOW_identifier_in_pk_constraint2663);
			n=identifier();
			state._fsp--;
			if (state.failed) return ret;
			match(input,PRIMARY,FOLLOW_PRIMARY_in_pk_constraint2665); if (state.failed) return ret;
			match(input,KEY,FOLLOW_KEY_in_pk_constraint2667); if (state.failed) return ret;
			match(input,LPAREN,FOLLOW_LPAREN_in_pk_constraint2669); if (state.failed) return ret;
			pushFollow(FOLLOW_col_name_with_sort_order_rowtimestamp_list_in_pk_constraint2673);
			cols=col_name_with_sort_order_rowtimestamp_list();
			state._fsp--;
			if (state.failed) return ret;
			match(input,RPAREN,FOLLOW_RPAREN_in_pk_constraint2675); if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = factory.primaryKey(n,cols); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "pk_constraint"



	// $ANTLR start "col_name_with_sort_order_rowtimestamp_list"
	// PhoenixSQL.g:539:1: col_name_with_sort_order_rowtimestamp_list returns [List<ColumnDefInPkConstraint> ret] : p= col_name_with_sort_order_rowtimestamp ( COMMA p= col_name_with_sort_order_rowtimestamp )* ;
	public final List<ColumnDefInPkConstraint> col_name_with_sort_order_rowtimestamp_list() throws RecognitionException {
		List<ColumnDefInPkConstraint> ret = null;


		ColumnDefInPkConstraint p =null;

		ret = new ArrayList<ColumnDefInPkConstraint>(); 
		try {
			// PhoenixSQL.g:541:5: (p= col_name_with_sort_order_rowtimestamp ( COMMA p= col_name_with_sort_order_rowtimestamp )* )
			// PhoenixSQL.g:541:9: p= col_name_with_sort_order_rowtimestamp ( COMMA p= col_name_with_sort_order_rowtimestamp )*
			{
			pushFollow(FOLLOW_col_name_with_sort_order_rowtimestamp_in_col_name_with_sort_order_rowtimestamp_list2706);
			p=col_name_with_sort_order_rowtimestamp();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.add(p);}
			// PhoenixSQL.g:541:65: ( COMMA p= col_name_with_sort_order_rowtimestamp )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==COMMA) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// PhoenixSQL.g:541:66: COMMA p= col_name_with_sort_order_rowtimestamp
					{
					match(input,COMMA,FOLLOW_COMMA_in_col_name_with_sort_order_rowtimestamp_list2712); if (state.failed) return ret;
					pushFollow(FOLLOW_col_name_with_sort_order_rowtimestamp_in_col_name_with_sort_order_rowtimestamp_list2718);
					p=col_name_with_sort_order_rowtimestamp();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(p);}
					}
					break;

				default :
					break loop42;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "col_name_with_sort_order_rowtimestamp_list"



	// $ANTLR start "col_name_with_sort_order_rowtimestamp"
	// PhoenixSQL.g:544:1: col_name_with_sort_order_rowtimestamp returns [ColumnDefInPkConstraint ret] : f= identifier (order= ASC |order= DESC )? (rr= ROW_TIMESTAMP )? ;
	public final ColumnDefInPkConstraint col_name_with_sort_order_rowtimestamp() throws RecognitionException {
		ColumnDefInPkConstraint ret = null;


		Token order=null;
		Token rr=null;
		String f =null;

		try {
			// PhoenixSQL.g:545:5: (f= identifier (order= ASC |order= DESC )? (rr= ROW_TIMESTAMP )? )
			// PhoenixSQL.g:545:9: f= identifier (order= ASC |order= DESC )? (rr= ROW_TIMESTAMP )?
			{
			pushFollow(FOLLOW_identifier_in_col_name_with_sort_order_rowtimestamp2745);
			f=identifier();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:545:22: (order= ASC |order= DESC )?
			int alt43=3;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==ASC) ) {
				alt43=1;
			}
			else if ( (LA43_0==DESC) ) {
				alt43=2;
			}
			switch (alt43) {
				case 1 :
					// PhoenixSQL.g:545:23: order= ASC
					{
					order=(Token)match(input,ASC,FOLLOW_ASC_in_col_name_with_sort_order_rowtimestamp2750); if (state.failed) return ret;
					}
					break;
				case 2 :
					// PhoenixSQL.g:545:33: order= DESC
					{
					order=(Token)match(input,DESC,FOLLOW_DESC_in_col_name_with_sort_order_rowtimestamp2754); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:545:46: (rr= ROW_TIMESTAMP )?
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==ROW_TIMESTAMP) ) {
				alt44=1;
			}
			switch (alt44) {
				case 1 :
					// PhoenixSQL.g:545:47: rr= ROW_TIMESTAMP
					{
					rr=(Token)match(input,ROW_TIMESTAMP,FOLLOW_ROW_TIMESTAMP_in_col_name_with_sort_order_rowtimestamp2761); if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) { ret = factory.columnDefInPkConstraint(factory.columnName(f), order == null ? SortOrder.getDefault() : SortOrder.fromDDLValue(order.getText()), rr != null); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "col_name_with_sort_order_rowtimestamp"



	// $ANTLR start "ik_constraint"
	// PhoenixSQL.g:549:1: ik_constraint returns [IndexKeyConstraint ret] : x= expression_with_sort_order_list ;
	public final IndexKeyConstraint ik_constraint() throws RecognitionException {
		IndexKeyConstraint ret = null;


		List<Pair<ParseNode, SortOrder>> x =null;

		try {
			// PhoenixSQL.g:550:5: (x= expression_with_sort_order_list )
			// PhoenixSQL.g:550:9: x= expression_with_sort_order_list
			{
			pushFollow(FOLLOW_expression_with_sort_order_list_in_ik_constraint2796);
			x=expression_with_sort_order_list();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.indexKey(x); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "ik_constraint"



	// $ANTLR start "expression_with_sort_order_list"
	// PhoenixSQL.g:553:1: expression_with_sort_order_list returns [List<Pair<ParseNode, SortOrder>> ret] : p= expression_with_sort_order ( COMMA p= expression_with_sort_order )* ;
	public final List<Pair<ParseNode, SortOrder>> expression_with_sort_order_list() throws RecognitionException {
		List<Pair<ParseNode, SortOrder>> ret = null;


		Pair<ParseNode, SortOrder> p =null;

		ret = new ArrayList<Pair<ParseNode, SortOrder>>(); 
		try {
			// PhoenixSQL.g:555:5: (p= expression_with_sort_order ( COMMA p= expression_with_sort_order )* )
			// PhoenixSQL.g:555:9: p= expression_with_sort_order ( COMMA p= expression_with_sort_order )*
			{
			pushFollow(FOLLOW_expression_with_sort_order_in_expression_with_sort_order_list2823);
			p=expression_with_sort_order();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.add(p);}
			// PhoenixSQL.g:555:54: ( COMMA p= expression_with_sort_order )*
			loop45:
			while (true) {
				int alt45=2;
				int LA45_0 = input.LA(1);
				if ( (LA45_0==COMMA) ) {
					alt45=1;
				}

				switch (alt45) {
				case 1 :
					// PhoenixSQL.g:555:55: COMMA p= expression_with_sort_order
					{
					match(input,COMMA,FOLLOW_COMMA_in_expression_with_sort_order_list2829); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_with_sort_order_in_expression_with_sort_order_list2835);
					p=expression_with_sort_order();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(p);}
					}
					break;

				default :
					break loop45;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "expression_with_sort_order_list"



	// $ANTLR start "expression_with_sort_order"
	// PhoenixSQL.g:558:1: expression_with_sort_order returns [Pair<ParseNode, SortOrder> ret] : (x= expression ) (order= ASC |order= DESC )? ;
	public final Pair<ParseNode, SortOrder> expression_with_sort_order() throws RecognitionException {
		Pair<ParseNode, SortOrder> ret = null;


		Token order=null;
		ParseNode x =null;

		try {
			// PhoenixSQL.g:559:5: ( (x= expression ) (order= ASC |order= DESC )? )
			// PhoenixSQL.g:559:9: (x= expression ) (order= ASC |order= DESC )?
			{
			// PhoenixSQL.g:559:9: (x= expression )
			// PhoenixSQL.g:559:10: x= expression
			{
			pushFollow(FOLLOW_expression_in_expression_with_sort_order2862);
			x=expression();
			state._fsp--;
			if (state.failed) return ret;
			}

			// PhoenixSQL.g:559:24: (order= ASC |order= DESC )?
			int alt46=3;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==ASC) ) {
				alt46=1;
			}
			else if ( (LA46_0==DESC) ) {
				alt46=2;
			}
			switch (alt46) {
				case 1 :
					// PhoenixSQL.g:559:25: order= ASC
					{
					order=(Token)match(input,ASC,FOLLOW_ASC_in_expression_with_sort_order2868); if (state.failed) return ret;
					}
					break;
				case 2 :
					// PhoenixSQL.g:559:35: order= DESC
					{
					order=(Token)match(input,DESC,FOLLOW_DESC_in_expression_with_sort_order2872); if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = Pair.newPair(x, order == null ? SortOrder.getDefault() : SortOrder.fromDDLValue(order.getText()));}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "expression_with_sort_order"



	// $ANTLR start "fam_properties"
	// PhoenixSQL.g:562:1: fam_properties returns [ListMultimap<String,Pair<String,Object>> ret] : p= fam_prop_name EQ v= prop_value ( COMMA p= fam_prop_name EQ v= prop_value )* ;
	public final ListMultimap<String,Pair<String,Object>> fam_properties() throws RecognitionException {
		ListMultimap<String,Pair<String,Object>> ret = null;


		PropertyName p =null;
		Object v =null;

		ret = ArrayListMultimap.<String,Pair<String,Object>>create(); 
		try {
			// PhoenixSQL.g:564:5: (p= fam_prop_name EQ v= prop_value ( COMMA p= fam_prop_name EQ v= prop_value )* )
			// PhoenixSQL.g:564:8: p= fam_prop_name EQ v= prop_value ( COMMA p= fam_prop_name EQ v= prop_value )*
			{
			pushFollow(FOLLOW_fam_prop_name_in_fam_properties2900);
			p=fam_prop_name();
			state._fsp--;
			if (state.failed) return ret;
			match(input,EQ,FOLLOW_EQ_in_fam_properties2902); if (state.failed) return ret;
			pushFollow(FOLLOW_prop_value_in_fam_properties2906);
			v=prop_value();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.put(p.getFamilyName(),new Pair<String,Object>(p.getPropertyName(),v));}
			// PhoenixSQL.g:564:119: ( COMMA p= fam_prop_name EQ v= prop_value )*
			loop47:
			while (true) {
				int alt47=2;
				int LA47_0 = input.LA(1);
				if ( (LA47_0==COMMA) ) {
					alt47=1;
				}

				switch (alt47) {
				case 1 :
					// PhoenixSQL.g:564:120: COMMA p= fam_prop_name EQ v= prop_value
					{
					match(input,COMMA,FOLLOW_COMMA_in_fam_properties2912); if (state.failed) return ret;
					pushFollow(FOLLOW_fam_prop_name_in_fam_properties2916);
					p=fam_prop_name();
					state._fsp--;
					if (state.failed) return ret;
					match(input,EQ,FOLLOW_EQ_in_fam_properties2918); if (state.failed) return ret;
					pushFollow(FOLLOW_prop_value_in_fam_properties2922);
					v=prop_value();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.put(p.getFamilyName(),new Pair<String,Object>(p.getPropertyName(),v));}
					}
					break;

				default :
					break loop47;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "fam_properties"



	// $ANTLR start "fam_prop_name"
	// PhoenixSQL.g:567:1: fam_prop_name returns [PropertyName ret] : (propName= identifier |familyName= identifier DOT propName= identifier );
	public final PropertyName fam_prop_name() throws RecognitionException {
		PropertyName ret = null;


		String propName =null;
		String familyName =null;

		try {
			// PhoenixSQL.g:568:5: (propName= identifier |familyName= identifier DOT propName= identifier )
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==NAME) ) {
				int LA48_1 = input.LA(2);
				if ( (LA48_1==EQ) ) {
					alt48=1;
				}
				else if ( (LA48_1==DOT) ) {
					alt48=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 48, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}

			switch (alt48) {
				case 1 :
					// PhoenixSQL.g:568:9: propName= identifier
					{
					pushFollow(FOLLOW_identifier_in_fam_prop_name2952);
					propName=identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.propertyName(propName); }
					}
					break;
				case 2 :
					// PhoenixSQL.g:569:9: familyName= identifier DOT propName= identifier
					{
					pushFollow(FOLLOW_identifier_in_fam_prop_name2966);
					familyName=identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,DOT,FOLLOW_DOT_in_fam_prop_name2968); if (state.failed) return ret;
					pushFollow(FOLLOW_identifier_in_fam_prop_name2972);
					propName=identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.propertyName(familyName, propName); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "fam_prop_name"



	// $ANTLR start "prop_value"
	// PhoenixSQL.g:572:1: prop_value returns [Object ret] : (v= identifier |l= literal );
	public final Object prop_value() throws RecognitionException {
		Object ret = null;


		String v =null;
		LiteralParseNode l =null;

		try {
			// PhoenixSQL.g:573:5: (v= identifier |l= literal )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==NAME) ) {
				int LA49_1 = input.LA(2);
				if ( (LA49_1==EOF||LA49_1==COMMA||LA49_1==SEMICOLON||LA49_1==SPLIT) ) {
					alt49=1;
				}
				else if ( (LA49_1==STRING_LITERAL) ) {
					alt49=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 49, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA49_0==DECIMAL||LA49_0==DOUBLE||LA49_0==FALSE||LA49_0==NULL||LA49_0==NUMBER||LA49_0==STRING_LITERAL||LA49_0==TRUE) ) {
				alt49=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// PhoenixSQL.g:573:9: v= identifier
					{
					pushFollow(FOLLOW_identifier_in_prop_value3003);
					v=identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = v; }
					}
					break;
				case 2 :
					// PhoenixSQL.g:574:9: l= literal
					{
					pushFollow(FOLLOW_literal_in_prop_value3017);
					l=literal();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = l.getValue(); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "prop_value"



	// $ANTLR start "column_name"
	// PhoenixSQL.g:577:1: column_name returns [ColumnName ret] : (field= identifier |family= identifier DOT field= identifier );
	public final ColumnName column_name() throws RecognitionException {
		ColumnName ret = null;


		String field =null;
		String family =null;

		try {
			// PhoenixSQL.g:578:5: (field= identifier |family= identifier DOT field= identifier )
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==NAME) ) {
				int LA50_1 = input.LA(2);
				if ( (LA50_1==EOF||LA50_1==COMMA||LA50_1==EQ||LA50_1==NAME||LA50_1==RPAREN||LA50_1==SEMICOLON) ) {
					alt50=1;
				}
				else if ( (LA50_1==DOT) ) {
					alt50=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 50, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}

			switch (alt50) {
				case 1 :
					// PhoenixSQL.g:578:9: field= identifier
					{
					pushFollow(FOLLOW_identifier_in_column_name3048);
					field=identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.columnName(field); }
					}
					break;
				case 2 :
					// PhoenixSQL.g:579:9: family= identifier DOT field= identifier
					{
					pushFollow(FOLLOW_identifier_in_column_name3062);
					family=identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,DOT,FOLLOW_DOT_in_column_name3064); if (state.failed) return ret;
					pushFollow(FOLLOW_identifier_in_column_name3068);
					field=identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.columnName(family, field); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "column_name"



	// $ANTLR start "column_names"
	// PhoenixSQL.g:582:1: column_names returns [List<ColumnName> ret] : v= column_name ( COMMA v= column_name )* ;
	public final List<ColumnName> column_names() throws RecognitionException {
		List<ColumnName> ret = null;


		ColumnName v =null;

		ret = new ArrayList<ColumnName>(); 
		try {
			// PhoenixSQL.g:584:5: (v= column_name ( COMMA v= column_name )* )
			// PhoenixSQL.g:584:8: v= column_name ( COMMA v= column_name )*
			{
			pushFollow(FOLLOW_column_name_in_column_names3100);
			v=column_name();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.add(v);}
			// PhoenixSQL.g:584:40: ( COMMA v= column_name )*
			loop51:
			while (true) {
				int alt51=2;
				int LA51_0 = input.LA(1);
				if ( (LA51_0==COMMA) ) {
					alt51=1;
				}

				switch (alt51) {
				case 1 :
					// PhoenixSQL.g:584:41: COMMA v= column_name
					{
					match(input,COMMA,FOLLOW_COMMA_in_column_names3106); if (state.failed) return ret;
					pushFollow(FOLLOW_column_name_in_column_names3112);
					v=column_name();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(v);}
					}
					break;

				default :
					break loop51;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "column_names"



	// $ANTLR start "drop_table_node"
	// PhoenixSQL.g:589:1: drop_table_node returns [DropTableStatement ret] : DROP (v= VIEW | TABLE ) ( IF ex= EXISTS )? t= from_table_name (c= CASCADE )? ;
	public final DropTableStatement drop_table_node() throws RecognitionException {
		DropTableStatement ret = null;


		Token v=null;
		Token ex=null;
		Token c=null;
		TableName t =null;

		try {
			// PhoenixSQL.g:590:5: ( DROP (v= VIEW | TABLE ) ( IF ex= EXISTS )? t= from_table_name (c= CASCADE )? )
			// PhoenixSQL.g:590:9: DROP (v= VIEW | TABLE ) ( IF ex= EXISTS )? t= from_table_name (c= CASCADE )?
			{
			match(input,DROP,FOLLOW_DROP_in_drop_table_node3139); if (state.failed) return ret;
			// PhoenixSQL.g:590:14: (v= VIEW | TABLE )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==VIEW) ) {
				alt52=1;
			}
			else if ( (LA52_0==TABLE) ) {
				alt52=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}

			switch (alt52) {
				case 1 :
					// PhoenixSQL.g:590:15: v= VIEW
					{
					v=(Token)match(input,VIEW,FOLLOW_VIEW_in_drop_table_node3144); if (state.failed) return ret;
					}
					break;
				case 2 :
					// PhoenixSQL.g:590:24: TABLE
					{
					match(input,TABLE,FOLLOW_TABLE_in_drop_table_node3148); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:590:31: ( IF ex= EXISTS )?
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==IF) ) {
				alt53=1;
			}
			switch (alt53) {
				case 1 :
					// PhoenixSQL.g:590:32: IF ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_drop_table_node3152); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_drop_table_node3156); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_from_table_name_in_drop_table_node3162);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:590:65: (c= CASCADE )?
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==CASCADE) ) {
				alt54=1;
			}
			switch (alt54) {
				case 1 :
					// PhoenixSQL.g:590:66: c= CASCADE
					{
					c=(Token)match(input,CASCADE,FOLLOW_CASCADE_in_drop_table_node3167); if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.dropTable(t, v==null ? (QueryConstants.SYSTEM_SCHEMA_NAME.equals(t.getSchemaName()) ? PTableType.SYSTEM : PTableType.TABLE) : PTableType.VIEW, ex!=null, c!=null); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "drop_table_node"



	// $ANTLR start "drop_schema_node"
	// PhoenixSQL.g:594:1: drop_schema_node returns [DropSchemaStatement ret] : DROP SCHEMA ( IF ex= EXISTS )? s= identifier (c= CASCADE )? ;
	public final DropSchemaStatement drop_schema_node() throws RecognitionException {
		DropSchemaStatement ret = null;


		Token ex=null;
		Token c=null;
		String s =null;

		try {
			// PhoenixSQL.g:595:5: ( DROP SCHEMA ( IF ex= EXISTS )? s= identifier (c= CASCADE )? )
			// PhoenixSQL.g:595:9: DROP SCHEMA ( IF ex= EXISTS )? s= identifier (c= CASCADE )?
			{
			match(input,DROP,FOLLOW_DROP_in_drop_schema_node3202); if (state.failed) return ret;
			match(input,SCHEMA,FOLLOW_SCHEMA_in_drop_schema_node3204); if (state.failed) return ret;
			// PhoenixSQL.g:595:21: ( IF ex= EXISTS )?
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==IF) ) {
				alt55=1;
			}
			switch (alt55) {
				case 1 :
					// PhoenixSQL.g:595:22: IF ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_drop_schema_node3207); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_drop_schema_node3211); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_identifier_in_drop_schema_node3217);
			s=identifier();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:595:50: (c= CASCADE )?
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==CASCADE) ) {
				alt56=1;
			}
			switch (alt56) {
				case 1 :
					// PhoenixSQL.g:595:51: c= CASCADE
					{
					c=(Token)match(input,CASCADE,FOLLOW_CASCADE_in_drop_schema_node3222); if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.dropSchema(s, ex!=null, c!=null); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "drop_schema_node"



	// $ANTLR start "drop_index_node"
	// PhoenixSQL.g:601:1: drop_index_node returns [DropIndexStatement ret] : DROP INDEX ( IF ex= EXISTS )? i= index_name ON t= from_table_name ;
	public final DropIndexStatement drop_index_node() throws RecognitionException {
		DropIndexStatement ret = null;


		Token ex=null;
		NamedNode i =null;
		TableName t =null;

		try {
			// PhoenixSQL.g:602:5: ( DROP INDEX ( IF ex= EXISTS )? i= index_name ON t= from_table_name )
			// PhoenixSQL.g:602:7: DROP INDEX ( IF ex= EXISTS )? i= index_name ON t= from_table_name
			{
			match(input,DROP,FOLLOW_DROP_in_drop_index_node3257); if (state.failed) return ret;
			match(input,INDEX,FOLLOW_INDEX_in_drop_index_node3259); if (state.failed) return ret;
			// PhoenixSQL.g:602:18: ( IF ex= EXISTS )?
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==IF) ) {
				alt57=1;
			}
			switch (alt57) {
				case 1 :
					// PhoenixSQL.g:602:19: IF ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_drop_index_node3262); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_drop_index_node3266); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_index_name_in_drop_index_node3272);
			i=index_name();
			state._fsp--;
			if (state.failed) return ret;
			match(input,ON,FOLLOW_ON_in_drop_index_node3274); if (state.failed) return ret;
			pushFollow(FOLLOW_from_table_name_in_drop_index_node3278);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.dropIndex(i, t, ex!=null); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "drop_index_node"



	// $ANTLR start "alter_index_node"
	// PhoenixSQL.g:607:1: alter_index_node returns [AlterIndexStatement ret] : ALTER INDEX ( IF ex= EXISTS )? i= index_name ON t= from_table_name ( (s= ( USABLE | UNUSABLE | REBUILD | DISABLE | ACTIVE ) ) (async= ASYNC )? ( ( ( SET )? ) p= fam_properties )? ) ;
	public final AlterIndexStatement alter_index_node() throws RecognitionException {
		AlterIndexStatement ret = null;


		Token ex=null;
		Token s=null;
		Token async=null;
		NamedNode i =null;
		TableName t =null;
		ListMultimap<String,Pair<String,Object>> p =null;

		try {
			// PhoenixSQL.g:608:5: ( ALTER INDEX ( IF ex= EXISTS )? i= index_name ON t= from_table_name ( (s= ( USABLE | UNUSABLE | REBUILD | DISABLE | ACTIVE ) ) (async= ASYNC )? ( ( ( SET )? ) p= fam_properties )? ) )
			// PhoenixSQL.g:608:7: ALTER INDEX ( IF ex= EXISTS )? i= index_name ON t= from_table_name ( (s= ( USABLE | UNUSABLE | REBUILD | DISABLE | ACTIVE ) ) (async= ASYNC )? ( ( ( SET )? ) p= fam_properties )? )
			{
			match(input,ALTER,FOLLOW_ALTER_in_alter_index_node3308); if (state.failed) return ret;
			match(input,INDEX,FOLLOW_INDEX_in_alter_index_node3310); if (state.failed) return ret;
			// PhoenixSQL.g:608:19: ( IF ex= EXISTS )?
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==IF) ) {
				alt58=1;
			}
			switch (alt58) {
				case 1 :
					// PhoenixSQL.g:608:20: IF ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_alter_index_node3313); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_alter_index_node3317); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_index_name_in_alter_index_node3323);
			i=index_name();
			state._fsp--;
			if (state.failed) return ret;
			match(input,ON,FOLLOW_ON_in_alter_index_node3325); if (state.failed) return ret;
			pushFollow(FOLLOW_from_table_name_in_alter_index_node3329);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:609:7: ( (s= ( USABLE | UNUSABLE | REBUILD | DISABLE | ACTIVE ) ) (async= ASYNC )? ( ( ( SET )? ) p= fam_properties )? )
			// PhoenixSQL.g:609:8: (s= ( USABLE | UNUSABLE | REBUILD | DISABLE | ACTIVE ) ) (async= ASYNC )? ( ( ( SET )? ) p= fam_properties )?
			{
			// PhoenixSQL.g:609:8: (s= ( USABLE | UNUSABLE | REBUILD | DISABLE | ACTIVE ) )
			// PhoenixSQL.g:609:9: s= ( USABLE | UNUSABLE | REBUILD | DISABLE | ACTIVE )
			{
			s=input.LT(1);
			if ( input.LA(1)==ACTIVE||input.LA(1)==DISABLE||input.LA(1)==REBUILD||input.LA(1)==UNUSABLE||input.LA(1)==USABLE ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			// PhoenixSQL.g:609:61: (async= ASYNC )?
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==ASYNC) ) {
				alt59=1;
			}
			switch (alt59) {
				case 1 :
					// PhoenixSQL.g:609:62: async= ASYNC
					{
					async=(Token)match(input,ASYNC,FOLLOW_ASYNC_in_alter_index_node3365); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:609:76: ( ( ( SET )? ) p= fam_properties )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==NAME||LA61_0==SET) ) {
				alt61=1;
			}
			switch (alt61) {
				case 1 :
					// PhoenixSQL.g:609:77: ( ( SET )? ) p= fam_properties
					{
					// PhoenixSQL.g:609:77: ( ( SET )? )
					// PhoenixSQL.g:609:78: ( SET )?
					{
					// PhoenixSQL.g:609:78: ( SET )?
					int alt60=2;
					int LA60_0 = input.LA(1);
					if ( (LA60_0==SET) ) {
						alt60=1;
					}
					switch (alt60) {
						case 1 :
							// PhoenixSQL.g:609:78: SET
							{
							match(input,SET,FOLLOW_SET_in_alter_index_node3371); if (state.failed) return ret;
							}
							break;

					}

					}

					pushFollow(FOLLOW_fam_properties_in_alter_index_node3376);
					p=fam_properties();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {ret = factory.alterIndex(factory.namedTable(null, TableName.create(t.getSchemaName(), i.getName())), t.getTableName(), ex!=null, PIndexState.valueOf(SchemaUtil.normalizeIdentifier(s.getText())), async!=null, p); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "alter_index_node"



	// $ANTLR start "trace_node"
	// PhoenixSQL.g:614:1: trace_node returns [TraceStatement ret] : TRACE ( (flag= ON ( WITH SAMPLING s= sampling_rate )? ) |flag= OFF ) ;
	public final TraceStatement trace_node() throws RecognitionException {
		TraceStatement ret = null;


		Token flag=null;
		LiteralParseNode s =null;

		try {
			// PhoenixSQL.g:615:5: ( TRACE ( (flag= ON ( WITH SAMPLING s= sampling_rate )? ) |flag= OFF ) )
			// PhoenixSQL.g:615:9: TRACE ( (flag= ON ( WITH SAMPLING s= sampling_rate )? ) |flag= OFF )
			{
			match(input,TRACE,FOLLOW_TRACE_in_trace_node3411); if (state.failed) return ret;
			// PhoenixSQL.g:615:15: ( (flag= ON ( WITH SAMPLING s= sampling_rate )? ) |flag= OFF )
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==ON) ) {
				alt63=1;
			}
			else if ( (LA63_0==OFF) ) {
				alt63=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 63, 0, input);
				throw nvae;
			}

			switch (alt63) {
				case 1 :
					// PhoenixSQL.g:615:16: (flag= ON ( WITH SAMPLING s= sampling_rate )? )
					{
					// PhoenixSQL.g:615:16: (flag= ON ( WITH SAMPLING s= sampling_rate )? )
					// PhoenixSQL.g:615:17: flag= ON ( WITH SAMPLING s= sampling_rate )?
					{
					flag=(Token)match(input,ON,FOLLOW_ON_in_trace_node3419); if (state.failed) return ret;
					// PhoenixSQL.g:615:28: ( WITH SAMPLING s= sampling_rate )?
					int alt62=2;
					int LA62_0 = input.LA(1);
					if ( (LA62_0==WITH) ) {
						alt62=1;
					}
					switch (alt62) {
						case 1 :
							// PhoenixSQL.g:615:30: WITH SAMPLING s= sampling_rate
							{
							match(input,WITH,FOLLOW_WITH_in_trace_node3424); if (state.failed) return ret;
							match(input,SAMPLING,FOLLOW_SAMPLING_in_trace_node3426); if (state.failed) return ret;
							pushFollow(FOLLOW_sampling_rate_in_trace_node3432);
							s=sampling_rate();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					}

					}
					break;
				case 2 :
					// PhoenixSQL.g:615:67: flag= OFF
					{
					flag=(Token)match(input,OFF,FOLLOW_OFF_in_trace_node3443); if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.trace(Tracing.isTraceOn(flag.getText()), s == null ? Tracing.isTraceOn(flag.getText()) ? 1.0 : 0.0 : (((BigDecimal)s.getValue())).doubleValue());}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "trace_node"



	// $ANTLR start "create_function_node"
	// PhoenixSQL.g:620:1: create_function_node returns [CreateFunctionStatement ret] : CREATE ( OR replace= REPLACE )? (temp= TEMPORARY )? FUNCTION function= identifier ( LPAREN args= zero_or_more_data_types RPAREN ) RETURNS r= identifier AS (className= jar_path ) ( USING JAR (jarPath= jar_path ) )? ;
	public final CreateFunctionStatement create_function_node() throws RecognitionException {
		CreateFunctionStatement ret = null;


		Token replace=null;
		Token temp=null;
		String function =null;
		List<FunctionArgument> args =null;
		String r =null;
		LiteralParseNode className =null;
		LiteralParseNode jarPath =null;

		try {
			// PhoenixSQL.g:621:5: ( CREATE ( OR replace= REPLACE )? (temp= TEMPORARY )? FUNCTION function= identifier ( LPAREN args= zero_or_more_data_types RPAREN ) RETURNS r= identifier AS (className= jar_path ) ( USING JAR (jarPath= jar_path ) )? )
			// PhoenixSQL.g:621:9: CREATE ( OR replace= REPLACE )? (temp= TEMPORARY )? FUNCTION function= identifier ( LPAREN args= zero_or_more_data_types RPAREN ) RETURNS r= identifier AS (className= jar_path ) ( USING JAR (jarPath= jar_path ) )?
			{
			match(input,CREATE,FOLLOW_CREATE_in_create_function_node3477); if (state.failed) return ret;
			// PhoenixSQL.g:621:16: ( OR replace= REPLACE )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==OR) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// PhoenixSQL.g:621:17: OR replace= REPLACE
					{
					match(input,OR,FOLLOW_OR_in_create_function_node3480); if (state.failed) return ret;
					replace=(Token)match(input,REPLACE,FOLLOW_REPLACE_in_create_function_node3484); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:621:38: (temp= TEMPORARY )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==TEMPORARY) ) {
				alt65=1;
			}
			switch (alt65) {
				case 1 :
					// PhoenixSQL.g:621:39: temp= TEMPORARY
					{
					temp=(Token)match(input,TEMPORARY,FOLLOW_TEMPORARY_in_create_function_node3491); if (state.failed) return ret;
					}
					break;

			}

			match(input,FUNCTION,FOLLOW_FUNCTION_in_create_function_node3495); if (state.failed) return ret;
			pushFollow(FOLLOW_identifier_in_create_function_node3499);
			function=identifier();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:622:8: ( LPAREN args= zero_or_more_data_types RPAREN )
			// PhoenixSQL.g:622:9: LPAREN args= zero_or_more_data_types RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_create_function_node3510); if (state.failed) return ret;
			pushFollow(FOLLOW_zero_or_more_data_types_in_create_function_node3514);
			args=zero_or_more_data_types();
			state._fsp--;
			if (state.failed) return ret;
			match(input,RPAREN,FOLLOW_RPAREN_in_create_function_node3516); if (state.failed) return ret;
			}

			match(input,RETURNS,FOLLOW_RETURNS_in_create_function_node3526); if (state.failed) return ret;
			pushFollow(FOLLOW_identifier_in_create_function_node3530);
			r=identifier();
			state._fsp--;
			if (state.failed) return ret;
			match(input,AS,FOLLOW_AS_in_create_function_node3532); if (state.failed) return ret;
			// PhoenixSQL.g:623:32: (className= jar_path )
			// PhoenixSQL.g:623:33: className= jar_path
			{
			pushFollow(FOLLOW_jar_path_in_create_function_node3538);
			className=jar_path();
			state._fsp--;
			if (state.failed) return ret;
			}

			// PhoenixSQL.g:624:8: ( USING JAR (jarPath= jar_path ) )?
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==USING) ) {
				alt66=1;
			}
			switch (alt66) {
				case 1 :
					// PhoenixSQL.g:624:9: USING JAR (jarPath= jar_path )
					{
					match(input,USING,FOLLOW_USING_in_create_function_node3549); if (state.failed) return ret;
					match(input,JAR,FOLLOW_JAR_in_create_function_node3551); if (state.failed) return ret;
					// PhoenixSQL.g:624:19: (jarPath= jar_path )
					// PhoenixSQL.g:624:20: jarPath= jar_path
					{
					pushFollow(FOLLOW_jar_path_in_create_function_node3558);
					jarPath=jar_path();
					state._fsp--;
					if (state.failed) return ret;
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			            ret = factory.createFunction(new PFunction(SchemaUtil.normalizeIdentifier(function), args,r,(String)className.getValue(), jarPath == null ? null : (String)jarPath.getValue()), temp!=null, replace!=null);
			        }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "create_function_node"



	// $ANTLR start "jar_path"
	// PhoenixSQL.g:630:1: jar_path returns [LiteralParseNode ret] : l= literal ;
	public final LiteralParseNode jar_path() throws RecognitionException {
		LiteralParseNode ret = null;


		LiteralParseNode l =null;

		try {
			// PhoenixSQL.g:631:5: (l= literal )
			// PhoenixSQL.g:631:7: l= literal
			{
			pushFollow(FOLLOW_literal_in_jar_path3595);
			l=literal();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = l; }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "jar_path"



	// $ANTLR start "drop_function_node"
	// PhoenixSQL.g:634:1: drop_function_node returns [DropFunctionStatement ret] : DROP FUNCTION ( IF ex= EXISTS )? function= identifier ;
	public final DropFunctionStatement drop_function_node() throws RecognitionException {
		DropFunctionStatement ret = null;


		Token ex=null;
		String function =null;

		try {
			// PhoenixSQL.g:635:5: ( DROP FUNCTION ( IF ex= EXISTS )? function= identifier )
			// PhoenixSQL.g:635:7: DROP FUNCTION ( IF ex= EXISTS )? function= identifier
			{
			match(input,DROP,FOLLOW_DROP_in_drop_function_node3618); if (state.failed) return ret;
			match(input,FUNCTION,FOLLOW_FUNCTION_in_drop_function_node3620); if (state.failed) return ret;
			// PhoenixSQL.g:635:21: ( IF ex= EXISTS )?
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==IF) ) {
				alt67=1;
			}
			switch (alt67) {
				case 1 :
					// PhoenixSQL.g:635:22: IF ex= EXISTS
					{
					match(input,IF,FOLLOW_IF_in_drop_function_node3623); if (state.failed) return ret;
					ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_drop_function_node3627); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_identifier_in_drop_function_node3633);
			function=identifier();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.dropFunction(SchemaUtil.normalizeIdentifier(function), ex!=null);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "drop_function_node"



	// $ANTLR start "add_jars_node"
	// PhoenixSQL.g:638:1: add_jars_node returns [AddJarsStatement ret] : ADD JARS jarPaths= one_or_more_jarpaths ;
	public final AddJarsStatement add_jars_node() throws RecognitionException {
		AddJarsStatement ret = null;


		List<LiteralParseNode> jarPaths =null;

		try {
			// PhoenixSQL.g:639:5: ( ADD JARS jarPaths= one_or_more_jarpaths )
			// PhoenixSQL.g:639:7: ADD JARS jarPaths= one_or_more_jarpaths
			{
			match(input,ADD,FOLLOW_ADD_in_add_jars_node3656); if (state.failed) return ret;
			match(input,JARS,FOLLOW_JARS_in_add_jars_node3658); if (state.failed) return ret;
			pushFollow(FOLLOW_one_or_more_jarpaths_in_add_jars_node3664);
			jarPaths=one_or_more_jarpaths();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = factory.addJars(jarPaths);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "add_jars_node"



	// $ANTLR start "list_jars_node"
	// PhoenixSQL.g:642:1: list_jars_node returns [ListJarsStatement ret] : LIST JARS ;
	public final ListJarsStatement list_jars_node() throws RecognitionException {
		ListJarsStatement ret = null;


		try {
			// PhoenixSQL.g:643:5: ( LIST JARS )
			// PhoenixSQL.g:643:7: LIST JARS
			{
			match(input,LIST,FOLLOW_LIST_in_list_jars_node3687); if (state.failed) return ret;
			match(input,JARS,FOLLOW_JARS_in_list_jars_node3689); if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = factory.listJars();}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "list_jars_node"



	// $ANTLR start "delete_jar_node"
	// PhoenixSQL.g:646:1: delete_jar_node returns [DeleteJarStatement ret] : DELETE JAR jarPath= jar_path ;
	public final DeleteJarStatement delete_jar_node() throws RecognitionException {
		DeleteJarStatement ret = null;


		LiteralParseNode jarPath =null;

		try {
			// PhoenixSQL.g:647:5: ( DELETE JAR jarPath= jar_path )
			// PhoenixSQL.g:647:7: DELETE JAR jarPath= jar_path
			{
			match(input,DELETE,FOLLOW_DELETE_in_delete_jar_node3712); if (state.failed) return ret;
			match(input,JAR,FOLLOW_JAR_in_delete_jar_node3714); if (state.failed) return ret;
			pushFollow(FOLLOW_jar_path_in_delete_jar_node3720);
			jarPath=jar_path();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = factory.deleteJar(jarPath);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "delete_jar_node"



	// $ANTLR start "alter_session_node"
	// PhoenixSQL.g:651:1: alter_session_node returns [AlterSessionStatement ret] : ALTER SESSION ( SET p= properties ) ;
	public final AlterSessionStatement alter_session_node() throws RecognitionException {
		AlterSessionStatement ret = null;


		Map<String,Object> p =null;

		try {
			// PhoenixSQL.g:652:5: ( ALTER SESSION ( SET p= properties ) )
			// PhoenixSQL.g:652:9: ALTER SESSION ( SET p= properties )
			{
			match(input,ALTER,FOLLOW_ALTER_in_alter_session_node3746); if (state.failed) return ret;
			match(input,SESSION,FOLLOW_SESSION_in_alter_session_node3748); if (state.failed) return ret;
			// PhoenixSQL.g:652:23: ( SET p= properties )
			// PhoenixSQL.g:652:24: SET p= properties
			{
			match(input,SET,FOLLOW_SET_in_alter_session_node3751); if (state.failed) return ret;
			pushFollow(FOLLOW_properties_in_alter_session_node3755);
			p=properties();
			state._fsp--;
			if (state.failed) return ret;
			}

			if ( state.backtracking==0 ) {ret = factory.alterSession(p);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "alter_session_node"



	// $ANTLR start "alter_table_node"
	// PhoenixSQL.g:657:1: alter_table_node returns [AlterTableStatement ret] : ALTER ( TABLE |v= VIEW ) t= from_table_name ( ( DROP COLUMN ( IF ex= EXISTS )? c= column_names ) | ( ADD ( IF NOT ex= EXISTS )? (d= column_defs ) (p= fam_properties )? ) | ( SET (p= fam_properties ) ) ) ;
	public final AlterTableStatement alter_table_node() throws RecognitionException {
		AlterTableStatement ret = null;


		Token v=null;
		Token ex=null;
		TableName t =null;
		List<ColumnName> c =null;
		List<ColumnDef> d =null;
		ListMultimap<String,Pair<String,Object>> p =null;

		try {
			// PhoenixSQL.g:658:5: ( ALTER ( TABLE |v= VIEW ) t= from_table_name ( ( DROP COLUMN ( IF ex= EXISTS )? c= column_names ) | ( ADD ( IF NOT ex= EXISTS )? (d= column_defs ) (p= fam_properties )? ) | ( SET (p= fam_properties ) ) ) )
			// PhoenixSQL.g:658:9: ALTER ( TABLE |v= VIEW ) t= from_table_name ( ( DROP COLUMN ( IF ex= EXISTS )? c= column_names ) | ( ADD ( IF NOT ex= EXISTS )? (d= column_defs ) (p= fam_properties )? ) | ( SET (p= fam_properties ) ) )
			{
			match(input,ALTER,FOLLOW_ALTER_in_alter_table_node3789); if (state.failed) return ret;
			// PhoenixSQL.g:658:15: ( TABLE |v= VIEW )
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==TABLE) ) {
				alt68=1;
			}
			else if ( (LA68_0==VIEW) ) {
				alt68=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}

			switch (alt68) {
				case 1 :
					// PhoenixSQL.g:658:16: TABLE
					{
					match(input,TABLE,FOLLOW_TABLE_in_alter_table_node3792); if (state.failed) return ret;
					}
					break;
				case 2 :
					// PhoenixSQL.g:658:24: v= VIEW
					{
					v=(Token)match(input,VIEW,FOLLOW_VIEW_in_alter_table_node3798); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_from_table_name_in_alter_table_node3803);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:659:9: ( ( DROP COLUMN ( IF ex= EXISTS )? c= column_names ) | ( ADD ( IF NOT ex= EXISTS )? (d= column_defs ) (p= fam_properties )? ) | ( SET (p= fam_properties ) ) )
			int alt72=3;
			switch ( input.LA(1) ) {
			case DROP:
				{
				alt72=1;
				}
				break;
			case ADD:
				{
				alt72=2;
				}
				break;
			case SET:
				{
				alt72=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}
			switch (alt72) {
				case 1 :
					// PhoenixSQL.g:659:11: ( DROP COLUMN ( IF ex= EXISTS )? c= column_names )
					{
					// PhoenixSQL.g:659:11: ( DROP COLUMN ( IF ex= EXISTS )? c= column_names )
					// PhoenixSQL.g:659:12: DROP COLUMN ( IF ex= EXISTS )? c= column_names
					{
					match(input,DROP,FOLLOW_DROP_in_alter_table_node3816); if (state.failed) return ret;
					match(input,COLUMN,FOLLOW_COLUMN_in_alter_table_node3818); if (state.failed) return ret;
					// PhoenixSQL.g:659:24: ( IF ex= EXISTS )?
					int alt69=2;
					int LA69_0 = input.LA(1);
					if ( (LA69_0==IF) ) {
						alt69=1;
					}
					switch (alt69) {
						case 1 :
							// PhoenixSQL.g:659:25: IF ex= EXISTS
							{
							match(input,IF,FOLLOW_IF_in_alter_table_node3821); if (state.failed) return ret;
							ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_alter_table_node3825); if (state.failed) return ret;
							}
							break;

					}

					pushFollow(FOLLOW_column_names_in_alter_table_node3831);
					c=column_names();
					state._fsp--;
					if (state.failed) return ret;
					}

					}
					break;
				case 2 :
					// PhoenixSQL.g:659:58: ( ADD ( IF NOT ex= EXISTS )? (d= column_defs ) (p= fam_properties )? )
					{
					// PhoenixSQL.g:659:58: ( ADD ( IF NOT ex= EXISTS )? (d= column_defs ) (p= fam_properties )? )
					// PhoenixSQL.g:659:59: ADD ( IF NOT ex= EXISTS )? (d= column_defs ) (p= fam_properties )?
					{
					match(input,ADD,FOLLOW_ADD_in_alter_table_node3837); if (state.failed) return ret;
					// PhoenixSQL.g:659:63: ( IF NOT ex= EXISTS )?
					int alt70=2;
					int LA70_0 = input.LA(1);
					if ( (LA70_0==IF) ) {
						alt70=1;
					}
					switch (alt70) {
						case 1 :
							// PhoenixSQL.g:659:64: IF NOT ex= EXISTS
							{
							match(input,IF,FOLLOW_IF_in_alter_table_node3840); if (state.failed) return ret;
							match(input,NOT,FOLLOW_NOT_in_alter_table_node3842); if (state.failed) return ret;
							ex=(Token)match(input,EXISTS,FOLLOW_EXISTS_in_alter_table_node3846); if (state.failed) return ret;
							}
							break;

					}

					// PhoenixSQL.g:659:83: (d= column_defs )
					// PhoenixSQL.g:659:84: d= column_defs
					{
					pushFollow(FOLLOW_column_defs_in_alter_table_node3853);
					d=column_defs();
					state._fsp--;
					if (state.failed) return ret;
					}

					// PhoenixSQL.g:659:99: (p= fam_properties )?
					int alt71=2;
					int LA71_0 = input.LA(1);
					if ( (LA71_0==NAME) ) {
						alt71=1;
					}
					switch (alt71) {
						case 1 :
							// PhoenixSQL.g:659:100: p= fam_properties
							{
							pushFollow(FOLLOW_fam_properties_in_alter_table_node3859);
							p=fam_properties();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					}

					}
					break;
				case 3 :
					// PhoenixSQL.g:659:122: ( SET (p= fam_properties ) )
					{
					// PhoenixSQL.g:659:122: ( SET (p= fam_properties ) )
					// PhoenixSQL.g:659:123: SET (p= fam_properties )
					{
					match(input,SET,FOLLOW_SET_in_alter_table_node3867); if (state.failed) return ret;
					// PhoenixSQL.g:659:127: (p= fam_properties )
					// PhoenixSQL.g:659:128: p= fam_properties
					{
					pushFollow(FOLLOW_fam_properties_in_alter_table_node3872);
					p=fam_properties();
					state._fsp--;
					if (state.failed) return ret;
					}

					}

					}
					break;

			}

			if ( state.backtracking==0 ) { PTableType tt = v==null ? (QueryConstants.SYSTEM_SCHEMA_NAME.equals(t.getSchemaName()) ? PTableType.SYSTEM : PTableType.TABLE) : PTableType.VIEW; ret = ( c == null ? factory.addColumn(factory.namedTable(null,t), tt, d, ex!=null, p) : factory.dropColumn(factory.namedTable(null,t), tt, c, ex!=null) ); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "alter_table_node"



	// $ANTLR start "update_statistics_node"
	// PhoenixSQL.g:663:1: update_statistics_node returns [UpdateStatisticsStatement ret] : UPDATE STATISTICS t= from_table_name (s= INDEX |s= ALL |s= COLUMNS )? ( SET (p= properties ) )? ;
	public final UpdateStatisticsStatement update_statistics_node() throws RecognitionException {
		UpdateStatisticsStatement ret = null;


		Token s=null;
		TableName t =null;
		Map<String,Object> p =null;

		try {
			// PhoenixSQL.g:664:2: ( UPDATE STATISTICS t= from_table_name (s= INDEX |s= ALL |s= COLUMNS )? ( SET (p= properties ) )? )
			// PhoenixSQL.g:664:6: UPDATE STATISTICS t= from_table_name (s= INDEX |s= ALL |s= COLUMNS )? ( SET (p= properties ) )?
			{
			match(input,UPDATE,FOLLOW_UPDATE_in_update_statistics_node3906); if (state.failed) return ret;
			match(input,STATISTICS,FOLLOW_STATISTICS_in_update_statistics_node3908); if (state.failed) return ret;
			pushFollow(FOLLOW_from_table_name_in_update_statistics_node3912);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:664:42: (s= INDEX |s= ALL |s= COLUMNS )?
			int alt73=4;
			switch ( input.LA(1) ) {
				case INDEX:
					{
					alt73=1;
					}
					break;
				case ALL:
					{
					alt73=2;
					}
					break;
				case COLUMNS:
					{
					alt73=3;
					}
					break;
			}
			switch (alt73) {
				case 1 :
					// PhoenixSQL.g:664:43: s= INDEX
					{
					s=(Token)match(input,INDEX,FOLLOW_INDEX_in_update_statistics_node3917); if (state.failed) return ret;
					}
					break;
				case 2 :
					// PhoenixSQL.g:664:53: s= ALL
					{
					s=(Token)match(input,ALL,FOLLOW_ALL_in_update_statistics_node3923); if (state.failed) return ret;
					}
					break;
				case 3 :
					// PhoenixSQL.g:664:61: s= COLUMNS
					{
					s=(Token)match(input,COLUMNS,FOLLOW_COLUMNS_in_update_statistics_node3929); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:664:73: ( SET (p= properties ) )?
			int alt74=2;
			int LA74_0 = input.LA(1);
			if ( (LA74_0==SET) ) {
				alt74=1;
			}
			switch (alt74) {
				case 1 :
					// PhoenixSQL.g:664:74: SET (p= properties )
					{
					match(input,SET,FOLLOW_SET_in_update_statistics_node3934); if (state.failed) return ret;
					// PhoenixSQL.g:664:78: (p= properties )
					// PhoenixSQL.g:664:79: p= properties
					{
					pushFollow(FOLLOW_properties_in_update_statistics_node3939);
					p=properties();
					state._fsp--;
					if (state.failed) return ret;
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.updateStatistics(factory.namedTable(null, t), s == null ? StatisticsCollectionScope.getDefault() : StatisticsCollectionScope.valueOf(SchemaUtil.normalizeIdentifier(s.getText())), p);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "update_statistics_node"



	// $ANTLR start "execute_upgrade_node"
	// PhoenixSQL.g:668:1: execute_upgrade_node returns [ExecuteUpgradeStatement ret] : EXECUTE UPGRADE ;
	public final ExecuteUpgradeStatement execute_upgrade_node() throws RecognitionException {
		ExecuteUpgradeStatement ret = null;


		try {
			// PhoenixSQL.g:669:2: ( EXECUTE UPGRADE )
			// PhoenixSQL.g:669:6: EXECUTE UPGRADE
			{
			match(input,EXECUTE,FOLLOW_EXECUTE_in_execute_upgrade_node3963); if (state.failed) return ret;
			match(input,UPGRADE,FOLLOW_UPGRADE_in_execute_upgrade_node3965); if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.executeUpgrade();}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "execute_upgrade_node"



	// $ANTLR start "prop_name"
	// PhoenixSQL.g:673:1: prop_name returns [String ret] : p= identifier ;
	public final String prop_name() throws RecognitionException {
		String ret = null;


		String p =null;

		try {
			// PhoenixSQL.g:674:5: (p= identifier )
			// PhoenixSQL.g:674:9: p= identifier
			{
			pushFollow(FOLLOW_identifier_in_prop_name3991);
			p=identifier();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = SchemaUtil.normalizeIdentifier(p); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "prop_name"



	// $ANTLR start "properties"
	// PhoenixSQL.g:677:1: properties returns [Map<String,Object> ret] : k= prop_name EQ v= prop_value ( COMMA k= prop_name EQ v= prop_value )* ;
	public final Map<String,Object> properties() throws RecognitionException {
		Map<String,Object> ret = null;


		String k =null;
		Object v =null;

		ret = new HashMap<String,Object>(); 
		try {
			// PhoenixSQL.g:679:5: (k= prop_name EQ v= prop_value ( COMMA k= prop_name EQ v= prop_value )* )
			// PhoenixSQL.g:679:8: k= prop_name EQ v= prop_value ( COMMA k= prop_name EQ v= prop_value )*
			{
			pushFollow(FOLLOW_prop_name_in_properties4025);
			k=prop_name();
			state._fsp--;
			if (state.failed) return ret;
			match(input,EQ,FOLLOW_EQ_in_properties4027); if (state.failed) return ret;
			pushFollow(FOLLOW_prop_value_in_properties4031);
			v=prop_value();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.put(k,v);}
			// PhoenixSQL.g:679:54: ( COMMA k= prop_name EQ v= prop_value )*
			loop75:
			while (true) {
				int alt75=2;
				int LA75_0 = input.LA(1);
				if ( (LA75_0==COMMA) ) {
					alt75=1;
				}

				switch (alt75) {
				case 1 :
					// PhoenixSQL.g:679:55: COMMA k= prop_name EQ v= prop_value
					{
					match(input,COMMA,FOLLOW_COMMA_in_properties4037); if (state.failed) return ret;
					pushFollow(FOLLOW_prop_name_in_properties4041);
					k=prop_name();
					state._fsp--;
					if (state.failed) return ret;
					match(input,EQ,FOLLOW_EQ_in_properties4043); if (state.failed) return ret;
					pushFollow(FOLLOW_prop_value_in_properties4047);
					v=prop_value();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.put(k,v);}
					}
					break;

				default :
					break loop75;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "properties"



	// $ANTLR start "column_defs"
	// PhoenixSQL.g:682:1: column_defs returns [List<ColumnDef> ret] : v= column_def ( COMMA v= column_def )* ;
	public final List<ColumnDef> column_defs() throws RecognitionException {
		List<ColumnDef> ret = null;


		ColumnDef v =null;

		ret = new ArrayList<ColumnDef>(); 
		try {
			// PhoenixSQL.g:684:5: (v= column_def ( COMMA v= column_def )* )
			// PhoenixSQL.g:684:8: v= column_def ( COMMA v= column_def )*
			{
			pushFollow(FOLLOW_column_def_in_column_defs4082);
			v=column_def();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.add(v);}
			// PhoenixSQL.g:684:39: ( COMMA v= column_def )*
			loop76:
			while (true) {
				int alt76=2;
				int LA76_0 = input.LA(1);
				if ( (LA76_0==COMMA) ) {
					int LA76_1 = input.LA(2);
					if ( (LA76_1==NAME) ) {
						alt76=1;
					}

				}

				switch (alt76) {
				case 1 :
					// PhoenixSQL.g:684:40: COMMA v= column_def
					{
					match(input,COMMA,FOLLOW_COMMA_in_column_defs4088); if (state.failed) return ret;
					pushFollow(FOLLOW_column_def_in_column_defs4094);
					v=column_def();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(v);}
					}
					break;

				default :
					break loop76;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "column_defs"



	// $ANTLR start "column_def"
	// PhoenixSQL.g:687:1: column_def returns [ColumnDef ret] : c= column_name dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? ( (nn= NOT )? n= NULL )? ( DEFAULT df= expression )? (pk= PRIMARY KEY (order= ASC |order= DESC )? (rr= ROW_TIMESTAMP )? )? ;
	public final ColumnDef column_def() throws RecognitionException {
		ColumnDef ret = null;


		Token l=null;
		Token s=null;
		Token ar=null;
		Token lsq=null;
		Token a=null;
		Token nn=null;
		Token n=null;
		Token pk=null;
		Token order=null;
		Token rr=null;
		ColumnName c =null;
		String dt =null;
		ParseNode df =null;

		try {
			// PhoenixSQL.g:688:5: (c= column_name dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? ( (nn= NOT )? n= NULL )? ( DEFAULT df= expression )? (pk= PRIMARY KEY (order= ASC |order= DESC )? (rr= ROW_TIMESTAMP )? )? )
			// PhoenixSQL.g:688:9: c= column_name dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? ( (nn= NOT )? n= NULL )? ( DEFAULT df= expression )? (pk= PRIMARY KEY (order= ASC |order= DESC )? (rr= ROW_TIMESTAMP )? )?
			{
			pushFollow(FOLLOW_column_name_in_column_def4120);
			c=column_name();
			state._fsp--;
			if (state.failed) return ret;
			pushFollow(FOLLOW_identifier_in_column_def4124);
			dt=identifier();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:688:37: ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )?
			int alt78=2;
			int LA78_0 = input.LA(1);
			if ( (LA78_0==LPAREN) ) {
				alt78=1;
			}
			switch (alt78) {
				case 1 :
					// PhoenixSQL.g:688:38: LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_column_def4127); if (state.failed) return ret;
					l=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_column_def4131); if (state.failed) return ret;
					// PhoenixSQL.g:688:54: ( COMMA s= NUMBER )?
					int alt77=2;
					int LA77_0 = input.LA(1);
					if ( (LA77_0==COMMA) ) {
						alt77=1;
					}
					switch (alt77) {
						case 1 :
							// PhoenixSQL.g:688:55: COMMA s= NUMBER
							{
							match(input,COMMA,FOLLOW_COMMA_in_column_def4134); if (state.failed) return ret;
							s=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_column_def4138); if (state.failed) return ret;
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_column_def4142); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:688:83: (ar= ARRAY )?
			int alt79=2;
			int LA79_0 = input.LA(1);
			if ( (LA79_0==ARRAY) ) {
				alt79=1;
			}
			switch (alt79) {
				case 1 :
					// PhoenixSQL.g:688:83: ar= ARRAY
					{
					ar=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_column_def4148); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:688:91: (lsq= LSQUARE (a= NUMBER )? RSQUARE )?
			int alt81=2;
			int LA81_0 = input.LA(1);
			if ( (LA81_0==LSQUARE) ) {
				alt81=1;
			}
			switch (alt81) {
				case 1 :
					// PhoenixSQL.g:688:92: lsq= LSQUARE (a= NUMBER )? RSQUARE
					{
					lsq=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_column_def4154); if (state.failed) return ret;
					// PhoenixSQL.g:688:104: (a= NUMBER )?
					int alt80=2;
					int LA80_0 = input.LA(1);
					if ( (LA80_0==NUMBER) ) {
						alt80=1;
					}
					switch (alt80) {
						case 1 :
							// PhoenixSQL.g:688:105: a= NUMBER
							{
							a=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_column_def4159); if (state.failed) return ret;
							}
							break;

					}

					match(input,RSQUARE,FOLLOW_RSQUARE_in_column_def4163); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:688:126: ( (nn= NOT )? n= NULL )?
			int alt83=2;
			int LA83_0 = input.LA(1);
			if ( ((LA83_0 >= NOT && LA83_0 <= NULL)) ) {
				alt83=1;
			}
			switch (alt83) {
				case 1 :
					// PhoenixSQL.g:688:127: (nn= NOT )? n= NULL
					{
					// PhoenixSQL.g:688:129: (nn= NOT )?
					int alt82=2;
					int LA82_0 = input.LA(1);
					if ( (LA82_0==NOT) ) {
						alt82=1;
					}
					switch (alt82) {
						case 1 :
							// PhoenixSQL.g:688:129: nn= NOT
							{
							nn=(Token)match(input,NOT,FOLLOW_NOT_in_column_def4170); if (state.failed) return ret;
							}
							break;

					}

					n=(Token)match(input,NULL,FOLLOW_NULL_in_column_def4175); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:688:144: ( DEFAULT df= expression )?
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==DEFAULT) ) {
				alt84=1;
			}
			switch (alt84) {
				case 1 :
					// PhoenixSQL.g:688:145: DEFAULT df= expression
					{
					match(input,DEFAULT,FOLLOW_DEFAULT_in_column_def4180); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_column_def4184);
					df=expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:688:169: (pk= PRIMARY KEY (order= ASC |order= DESC )? (rr= ROW_TIMESTAMP )? )?
			int alt87=2;
			int LA87_0 = input.LA(1);
			if ( (LA87_0==PRIMARY) ) {
				alt87=1;
			}
			switch (alt87) {
				case 1 :
					// PhoenixSQL.g:688:170: pk= PRIMARY KEY (order= ASC |order= DESC )? (rr= ROW_TIMESTAMP )?
					{
					pk=(Token)match(input,PRIMARY,FOLLOW_PRIMARY_in_column_def4191); if (state.failed) return ret;
					match(input,KEY,FOLLOW_KEY_in_column_def4193); if (state.failed) return ret;
					// PhoenixSQL.g:688:185: (order= ASC |order= DESC )?
					int alt85=3;
					int LA85_0 = input.LA(1);
					if ( (LA85_0==ASC) ) {
						alt85=1;
					}
					else if ( (LA85_0==DESC) ) {
						alt85=2;
					}
					switch (alt85) {
						case 1 :
							// PhoenixSQL.g:688:186: order= ASC
							{
							order=(Token)match(input,ASC,FOLLOW_ASC_in_column_def4198); if (state.failed) return ret;
							}
							break;
						case 2 :
							// PhoenixSQL.g:688:196: order= DESC
							{
							order=(Token)match(input,DESC,FOLLOW_DESC_in_column_def4202); if (state.failed) return ret;
							}
							break;

					}

					// PhoenixSQL.g:688:211: (rr= ROW_TIMESTAMP )?
					int alt86=2;
					int LA86_0 = input.LA(1);
					if ( (LA86_0==ROW_TIMESTAMP) ) {
						alt86=1;
					}
					switch (alt86) {
						case 1 :
							// PhoenixSQL.g:688:211: rr= ROW_TIMESTAMP
							{
							rr=(Token)match(input,ROW_TIMESTAMP,FOLLOW_ROW_TIMESTAMP_in_column_def4208); if (state.failed) return ret;
							}
							break;

					}

					}
					break;

			}

			if ( state.backtracking==0 ) { ret = factory.columnDef(c, dt, ar != null || lsq != null, a == null ? null :  Integer.parseInt( a.getText() ), nn!=null ? Boolean.FALSE : n!=null ? Boolean.TRUE : null, 
			            l == null ? null : Integer.parseInt( l.getText() ),
			            s == null ? null : Integer.parseInt( s.getText() ),
			            pk != null, 
			            order == null ? SortOrder.getDefault() : SortOrder.fromDDLValue(order.getText()),
			            df == null ? null : df.toString(),
			            rr != null); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "column_def"



	// $ANTLR start "dyn_column_defs"
	// PhoenixSQL.g:698:1: dyn_column_defs returns [List<ColumnDef> ret] : v= dyn_column_def ( COMMA v= dyn_column_def )* ;
	public final List<ColumnDef> dyn_column_defs() throws RecognitionException {
		List<ColumnDef> ret = null;


		ColumnDef v =null;

		ret = new ArrayList<ColumnDef>(); 
		try {
			// PhoenixSQL.g:700:5: (v= dyn_column_def ( COMMA v= dyn_column_def )* )
			// PhoenixSQL.g:700:8: v= dyn_column_def ( COMMA v= dyn_column_def )*
			{
			pushFollow(FOLLOW_dyn_column_def_in_dyn_column_defs4251);
			v=dyn_column_def();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.add(v);}
			// PhoenixSQL.g:700:43: ( COMMA v= dyn_column_def )*
			loop88:
			while (true) {
				int alt88=2;
				int LA88_0 = input.LA(1);
				if ( (LA88_0==COMMA) ) {
					alt88=1;
				}

				switch (alt88) {
				case 1 :
					// PhoenixSQL.g:700:44: COMMA v= dyn_column_def
					{
					match(input,COMMA,FOLLOW_COMMA_in_dyn_column_defs4257); if (state.failed) return ret;
					pushFollow(FOLLOW_dyn_column_def_in_dyn_column_defs4263);
					v=dyn_column_def();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(v);}
					}
					break;

				default :
					break loop88;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "dyn_column_defs"



	// $ANTLR start "dyn_column_def"
	// PhoenixSQL.g:703:1: dyn_column_def returns [ColumnDef ret] : c= column_name dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? ;
	public final ColumnDef dyn_column_def() throws RecognitionException {
		ColumnDef ret = null;


		Token l=null;
		Token s=null;
		Token ar=null;
		Token lsq=null;
		Token a=null;
		ColumnName c =null;
		String dt =null;

		try {
			// PhoenixSQL.g:704:5: (c= column_name dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? )
			// PhoenixSQL.g:704:9: c= column_name dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )?
			{
			pushFollow(FOLLOW_column_name_in_dyn_column_def4289);
			c=column_name();
			state._fsp--;
			if (state.failed) return ret;
			pushFollow(FOLLOW_identifier_in_dyn_column_def4293);
			dt=identifier();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:704:37: ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )?
			int alt90=2;
			int LA90_0 = input.LA(1);
			if ( (LA90_0==LPAREN) ) {
				alt90=1;
			}
			switch (alt90) {
				case 1 :
					// PhoenixSQL.g:704:38: LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_dyn_column_def4296); if (state.failed) return ret;
					l=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_dyn_column_def4300); if (state.failed) return ret;
					// PhoenixSQL.g:704:54: ( COMMA s= NUMBER )?
					int alt89=2;
					int LA89_0 = input.LA(1);
					if ( (LA89_0==COMMA) ) {
						alt89=1;
					}
					switch (alt89) {
						case 1 :
							// PhoenixSQL.g:704:55: COMMA s= NUMBER
							{
							match(input,COMMA,FOLLOW_COMMA_in_dyn_column_def4303); if (state.failed) return ret;
							s=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_dyn_column_def4307); if (state.failed) return ret;
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_dyn_column_def4311); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:704:83: (ar= ARRAY )?
			int alt91=2;
			int LA91_0 = input.LA(1);
			if ( (LA91_0==ARRAY) ) {
				alt91=1;
			}
			switch (alt91) {
				case 1 :
					// PhoenixSQL.g:704:83: ar= ARRAY
					{
					ar=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_dyn_column_def4317); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:704:91: (lsq= LSQUARE (a= NUMBER )? RSQUARE )?
			int alt93=2;
			int LA93_0 = input.LA(1);
			if ( (LA93_0==LSQUARE) ) {
				alt93=1;
			}
			switch (alt93) {
				case 1 :
					// PhoenixSQL.g:704:92: lsq= LSQUARE (a= NUMBER )? RSQUARE
					{
					lsq=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dyn_column_def4323); if (state.failed) return ret;
					// PhoenixSQL.g:704:104: (a= NUMBER )?
					int alt92=2;
					int LA92_0 = input.LA(1);
					if ( (LA92_0==NUMBER) ) {
						alt92=1;
					}
					switch (alt92) {
						case 1 :
							// PhoenixSQL.g:704:105: a= NUMBER
							{
							a=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_dyn_column_def4328); if (state.failed) return ret;
							}
							break;

					}

					match(input,RSQUARE,FOLLOW_RSQUARE_in_dyn_column_def4332); if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.columnDef(c, dt, ar != null || lsq != null, a == null ? null :  Integer.parseInt( a.getText() ), Boolean.TRUE,
			            l == null ? null : Integer.parseInt( l.getText() ),
			            s == null ? null : Integer.parseInt( s.getText() ),
			            false, 
			            SortOrder.getDefault(),
			            false); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "dyn_column_def"



	// $ANTLR start "dyn_column_name_or_def"
	// PhoenixSQL.g:713:1: dyn_column_name_or_def returns [ColumnDef ret] : c= column_name (dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? )? ;
	public final ColumnDef dyn_column_name_or_def() throws RecognitionException {
		ColumnDef ret = null;


		Token l=null;
		Token s=null;
		Token ar=null;
		Token lsq=null;
		Token a=null;
		ColumnName c =null;
		String dt =null;

		try {
			// PhoenixSQL.g:714:5: (c= column_name (dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? )? )
			// PhoenixSQL.g:714:9: c= column_name (dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? )?
			{
			pushFollow(FOLLOW_column_name_in_dyn_column_name_or_def4369);
			c=column_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:714:23: (dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? )?
			int alt99=2;
			int LA99_0 = input.LA(1);
			if ( (LA99_0==NAME) ) {
				alt99=1;
			}
			switch (alt99) {
				case 1 :
					// PhoenixSQL.g:714:24: dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )?
					{
					pushFollow(FOLLOW_identifier_in_dyn_column_name_or_def4374);
					dt=identifier();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:714:38: ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )?
					int alt95=2;
					int LA95_0 = input.LA(1);
					if ( (LA95_0==LPAREN) ) {
						alt95=1;
					}
					switch (alt95) {
						case 1 :
							// PhoenixSQL.g:714:39: LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN
							{
							match(input,LPAREN,FOLLOW_LPAREN_in_dyn_column_name_or_def4377); if (state.failed) return ret;
							l=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_dyn_column_name_or_def4381); if (state.failed) return ret;
							// PhoenixSQL.g:714:55: ( COMMA s= NUMBER )?
							int alt94=2;
							int LA94_0 = input.LA(1);
							if ( (LA94_0==COMMA) ) {
								alt94=1;
							}
							switch (alt94) {
								case 1 :
									// PhoenixSQL.g:714:56: COMMA s= NUMBER
									{
									match(input,COMMA,FOLLOW_COMMA_in_dyn_column_name_or_def4384); if (state.failed) return ret;
									s=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_dyn_column_name_or_def4388); if (state.failed) return ret;
									}
									break;

							}

							match(input,RPAREN,FOLLOW_RPAREN_in_dyn_column_name_or_def4392); if (state.failed) return ret;
							}
							break;

					}

					// PhoenixSQL.g:714:84: (ar= ARRAY )?
					int alt96=2;
					int LA96_0 = input.LA(1);
					if ( (LA96_0==ARRAY) ) {
						alt96=1;
					}
					switch (alt96) {
						case 1 :
							// PhoenixSQL.g:714:84: ar= ARRAY
							{
							ar=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_dyn_column_name_or_def4398); if (state.failed) return ret;
							}
							break;

					}

					// PhoenixSQL.g:714:92: (lsq= LSQUARE (a= NUMBER )? RSQUARE )?
					int alt98=2;
					int LA98_0 = input.LA(1);
					if ( (LA98_0==LSQUARE) ) {
						alt98=1;
					}
					switch (alt98) {
						case 1 :
							// PhoenixSQL.g:714:93: lsq= LSQUARE (a= NUMBER )? RSQUARE
							{
							lsq=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_dyn_column_name_or_def4404); if (state.failed) return ret;
							// PhoenixSQL.g:714:105: (a= NUMBER )?
							int alt97=2;
							int LA97_0 = input.LA(1);
							if ( (LA97_0==NUMBER) ) {
								alt97=1;
							}
							switch (alt97) {
								case 1 :
									// PhoenixSQL.g:714:106: a= NUMBER
									{
									a=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_dyn_column_name_or_def4409); if (state.failed) return ret;
									}
									break;

							}

							match(input,RSQUARE,FOLLOW_RSQUARE_in_dyn_column_name_or_def4413); if (state.failed) return ret;
							}
							break;

					}

					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.columnDef(c, dt, ar != null || lsq != null, a == null ? null :  Integer.parseInt( a.getText() ), Boolean.TRUE,
			            l == null ? null : Integer.parseInt( l.getText() ),
			            s == null ? null : Integer.parseInt( s.getText() ),
			            false, 
			            SortOrder.getDefault(),
			            false); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "dyn_column_name_or_def"



	// $ANTLR start "subquery_expression"
	// PhoenixSQL.g:723:1: subquery_expression returns [ParseNode ret] : s= select_node ;
	public final ParseNode subquery_expression() throws RecognitionException {
		ParseNode ret = null;


		SelectStatement s =null;

		try {
			// PhoenixSQL.g:724:5: (s= select_node )
			// PhoenixSQL.g:724:8: s= select_node
			{
			pushFollow(FOLLOW_select_node_in_subquery_expression4453);
			s=select_node();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.subquery(s, false);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "subquery_expression"



	// $ANTLR start "single_select"
	// PhoenixSQL.g:727:1: single_select returns [SelectStatement ret] : SELECT (h= hintClause )? (d= DISTINCT | ALL )? sel= select_list ( FROM from= parseFrom )? ( WHERE where= expression )? ( GROUP BY group= group_by )? ( HAVING having= expression )? ;
	public final SelectStatement single_select() throws RecognitionException {
		SelectStatement ret = null;


		Token d=null;
		HintNode h =null;
		List<AliasedNode> sel =null;
		TableNode from =null;
		ParseNode where =null;
		List<ParseNode> group =null;
		ParseNode having =null;

		 contextStack.push(new ParseContext()); 
		try {
			// PhoenixSQL.g:729:5: ( SELECT (h= hintClause )? (d= DISTINCT | ALL )? sel= select_list ( FROM from= parseFrom )? ( WHERE where= expression )? ( GROUP BY group= group_by )? ( HAVING having= expression )? )
			// PhoenixSQL.g:729:9: SELECT (h= hintClause )? (d= DISTINCT | ALL )? sel= select_list ( FROM from= parseFrom )? ( WHERE where= expression )? ( GROUP BY group= group_by )? ( HAVING having= expression )?
			{
			match(input,SELECT,FOLLOW_SELECT_in_single_select4486); if (state.failed) return ret;
			// PhoenixSQL.g:729:16: (h= hintClause )?
			int alt100=2;
			int LA100_0 = input.LA(1);
			if ( (LA100_0==ML_HINT) ) {
				alt100=1;
			}
			switch (alt100) {
				case 1 :
					// PhoenixSQL.g:729:17: h= hintClause
					{
					pushFollow(FOLLOW_hintClause_in_single_select4491);
					h=hintClause();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:730:9: (d= DISTINCT | ALL )?
			int alt101=3;
			int LA101_0 = input.LA(1);
			if ( (LA101_0==DISTINCT) ) {
				alt101=1;
			}
			else if ( (LA101_0==ALL) ) {
				alt101=2;
			}
			switch (alt101) {
				case 1 :
					// PhoenixSQL.g:730:10: d= DISTINCT
					{
					d=(Token)match(input,DISTINCT,FOLLOW_DISTINCT_in_single_select4507); if (state.failed) return ret;
					}
					break;
				case 2 :
					// PhoenixSQL.g:730:23: ALL
					{
					match(input,ALL,FOLLOW_ALL_in_single_select4511); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_select_list_in_single_select4517);
			sel=select_list();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:731:9: ( FROM from= parseFrom )?
			int alt102=2;
			int LA102_0 = input.LA(1);
			if ( (LA102_0==FROM) ) {
				alt102=1;
			}
			switch (alt102) {
				case 1 :
					// PhoenixSQL.g:731:10: FROM from= parseFrom
					{
					match(input,FROM,FOLLOW_FROM_in_single_select4528); if (state.failed) return ret;
					pushFollow(FOLLOW_parseFrom_in_single_select4532);
					from=parseFrom();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:732:9: ( WHERE where= expression )?
			int alt103=2;
			int LA103_0 = input.LA(1);
			if ( (LA103_0==WHERE) ) {
				alt103=1;
			}
			switch (alt103) {
				case 1 :
					// PhoenixSQL.g:732:10: WHERE where= expression
					{
					match(input,WHERE,FOLLOW_WHERE_in_single_select4545); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_single_select4549);
					where=expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:733:9: ( GROUP BY group= group_by )?
			int alt104=2;
			int LA104_0 = input.LA(1);
			if ( (LA104_0==GROUP) ) {
				alt104=1;
			}
			switch (alt104) {
				case 1 :
					// PhoenixSQL.g:733:10: GROUP BY group= group_by
					{
					match(input,GROUP,FOLLOW_GROUP_in_single_select4562); if (state.failed) return ret;
					match(input,BY,FOLLOW_BY_in_single_select4564); if (state.failed) return ret;
					pushFollow(FOLLOW_group_by_in_single_select4568);
					group=group_by();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:734:9: ( HAVING having= expression )?
			int alt105=2;
			int LA105_0 = input.LA(1);
			if ( (LA105_0==HAVING) ) {
				alt105=1;
			}
			switch (alt105) {
				case 1 :
					// PhoenixSQL.g:734:10: HAVING having= expression
					{
					match(input,HAVING,FOLLOW_HAVING_in_single_select4581); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_single_select4585);
					having=expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) { ParseContext context = contextStack.peek(); ret = factory.select(from, h, d!=null, sel, where, group, having, null, null,null, getBindCount(), context.isAggregate(), context.hasSequences(), null, new HashMap<String,UDFParseNode>(udfParseNodes)); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
			 contextStack.pop(); 
		}
		return ret;
	}
	// $ANTLR end "single_select"



	// $ANTLR start "unioned_selects"
	// PhoenixSQL.g:739:1: unioned_selects returns [List<SelectStatement> ret] : s= single_select ( UNION ALL s= single_select )* ;
	public final List<SelectStatement> unioned_selects() throws RecognitionException {
		List<SelectStatement> ret = null;


		SelectStatement s =null;

		ret = new ArrayList<SelectStatement>();
		try {
			// PhoenixSQL.g:741:5: (s= single_select ( UNION ALL s= single_select )* )
			// PhoenixSQL.g:741:9: s= single_select ( UNION ALL s= single_select )*
			{
			pushFollow(FOLLOW_single_select_in_unioned_selects4629);
			s=single_select();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.add(s);}
			// PhoenixSQL.g:741:39: ( UNION ALL s= single_select )*
			loop106:
			while (true) {
				int alt106=2;
				int LA106_0 = input.LA(1);
				if ( (LA106_0==UNION) ) {
					alt106=1;
				}

				switch (alt106) {
				case 1 :
					// PhoenixSQL.g:741:40: UNION ALL s= single_select
					{
					match(input,UNION,FOLLOW_UNION_in_unioned_selects4634); if (state.failed) return ret;
					match(input,ALL,FOLLOW_ALL_in_unioned_selects4636); if (state.failed) return ret;
					pushFollow(FOLLOW_single_select_in_unioned_selects4640);
					s=single_select();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(s);}
					}
					break;

				default :
					break loop106;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "unioned_selects"



	// $ANTLR start "select_node"
	// PhoenixSQL.g:745:1: select_node returns [SelectStatement ret] : u= unioned_selects ( ORDER BY order= order_by )? ( LIMIT l= limit )? ( OFFSET o= offset ( ROW | ROWS )? )? ( FETCH ( FIRST | NEXT ) (l= limit )? ( ROW | ROWS ) ONLY )? ;
	public final SelectStatement select_node() throws RecognitionException {
		SelectStatement ret = null;


		List<SelectStatement> u =null;
		List<OrderByNode> order =null;
		LimitNode l =null;
		OffsetNode o =null;

		 contextStack.push(new ParseContext()); 
		try {
			// PhoenixSQL.g:747:5: (u= unioned_selects ( ORDER BY order= order_by )? ( LIMIT l= limit )? ( OFFSET o= offset ( ROW | ROWS )? )? ( FETCH ( FIRST | NEXT ) (l= limit )? ( ROW | ROWS ) ONLY )? )
			// PhoenixSQL.g:747:9: u= unioned_selects ( ORDER BY order= order_by )? ( LIMIT l= limit )? ( OFFSET o= offset ( ROW | ROWS )? )? ( FETCH ( FIRST | NEXT ) (l= limit )? ( ROW | ROWS ) ONLY )?
			{
			pushFollow(FOLLOW_unioned_selects_in_select_node4678);
			u=unioned_selects();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:748:9: ( ORDER BY order= order_by )?
			int alt107=2;
			int LA107_0 = input.LA(1);
			if ( (LA107_0==ORDER) ) {
				alt107=1;
			}
			switch (alt107) {
				case 1 :
					// PhoenixSQL.g:748:10: ORDER BY order= order_by
					{
					match(input,ORDER,FOLLOW_ORDER_in_select_node4689); if (state.failed) return ret;
					match(input,BY,FOLLOW_BY_in_select_node4691); if (state.failed) return ret;
					pushFollow(FOLLOW_order_by_in_select_node4695);
					order=order_by();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:749:9: ( LIMIT l= limit )?
			int alt108=2;
			int LA108_0 = input.LA(1);
			if ( (LA108_0==LIMIT) ) {
				alt108=1;
			}
			switch (alt108) {
				case 1 :
					// PhoenixSQL.g:749:10: LIMIT l= limit
					{
					match(input,LIMIT,FOLLOW_LIMIT_in_select_node4708); if (state.failed) return ret;
					pushFollow(FOLLOW_limit_in_select_node4712);
					l=limit();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:750:9: ( OFFSET o= offset ( ROW | ROWS )? )?
			int alt110=2;
			int LA110_0 = input.LA(1);
			if ( (LA110_0==OFFSET) ) {
				alt110=1;
			}
			switch (alt110) {
				case 1 :
					// PhoenixSQL.g:750:10: OFFSET o= offset ( ROW | ROWS )?
					{
					match(input,OFFSET,FOLLOW_OFFSET_in_select_node4725); if (state.failed) return ret;
					pushFollow(FOLLOW_offset_in_select_node4729);
					o=offset();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:750:26: ( ROW | ROWS )?
					int alt109=2;
					int LA109_0 = input.LA(1);
					if ( ((LA109_0 >= ROW && LA109_0 <= ROWS)) ) {
						alt109=1;
					}
					switch (alt109) {
						case 1 :
							// PhoenixSQL.g:
							{
							if ( (input.LA(1) >= ROW && input.LA(1) <= ROWS) ) {
								input.consume();
								state.errorRecovery=false;
								state.failed=false;
							}
							else {
								if (state.backtracking>0) {state.failed=true; return ret;}
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}
							}
							break;

					}

					}
					break;

			}

			// PhoenixSQL.g:751:9: ( FETCH ( FIRST | NEXT ) (l= limit )? ( ROW | ROWS ) ONLY )?
			int alt112=2;
			int LA112_0 = input.LA(1);
			if ( (LA112_0==FETCH) ) {
				alt112=1;
			}
			switch (alt112) {
				case 1 :
					// PhoenixSQL.g:751:10: FETCH ( FIRST | NEXT ) (l= limit )? ( ROW | ROWS ) ONLY
					{
					match(input,FETCH,FOLLOW_FETCH_in_select_node4751); if (state.failed) return ret;
					if ( input.LA(1)==FIRST||input.LA(1)==NEXT ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					// PhoenixSQL.g:751:31: (l= limit )?
					int alt111=2;
					int LA111_0 = input.LA(1);
					if ( (LA111_0==BIND_NAME||LA111_0==NUMBER||LA111_0==QUESTION) ) {
						alt111=1;
					}
					switch (alt111) {
						case 1 :
							// PhoenixSQL.g:751:32: l= limit
							{
							pushFollow(FOLLOW_limit_in_select_node4764);
							l=limit();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					if ( (input.LA(1) >= ROW && input.LA(1) <= ROWS) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					match(input,ONLY,FOLLOW_ONLY_in_select_node4776); if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) { ParseContext context = contextStack.peek(); ret = factory.select(u, order, l, o, getBindCount(), context.isAggregate()); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
			 contextStack.pop(); 
		}
		return ret;
	}
	// $ANTLR end "select_node"



	// $ANTLR start "upsert_node"
	// PhoenixSQL.g:757:1: upsert_node returns [UpsertStatement ret] : UPSERT (hint= hintClause )? INTO t= from_table_name ( LPAREN p= upsert_column_refs RPAREN )? ( ( VALUES LPAREN v= one_or_more_expressions RPAREN ( ON DUPLICATE KEY (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) ) )? ) |s= select_node ) ;
	public final UpsertStatement upsert_node() throws RecognitionException {
		UpsertStatement ret = null;


		Token ig=null;
		HintNode hint =null;
		TableName t =null;
		Pair<List<ColumnDef>,List<ColumnName>> p =null;
		List<ParseNode> v =null;
		List<Pair<ColumnName,ParseNode>> pairs =null;
		SelectStatement s =null;

		try {
			// PhoenixSQL.g:758:5: ( UPSERT (hint= hintClause )? INTO t= from_table_name ( LPAREN p= upsert_column_refs RPAREN )? ( ( VALUES LPAREN v= one_or_more_expressions RPAREN ( ON DUPLICATE KEY (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) ) )? ) |s= select_node ) )
			// PhoenixSQL.g:758:9: UPSERT (hint= hintClause )? INTO t= from_table_name ( LPAREN p= upsert_column_refs RPAREN )? ( ( VALUES LPAREN v= one_or_more_expressions RPAREN ( ON DUPLICATE KEY (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) ) )? ) |s= select_node )
			{
			match(input,UPSERT,FOLLOW_UPSERT_in_upsert_node4815); if (state.failed) return ret;
			// PhoenixSQL.g:758:16: (hint= hintClause )?
			int alt113=2;
			int LA113_0 = input.LA(1);
			if ( (LA113_0==ML_HINT) ) {
				alt113=1;
			}
			switch (alt113) {
				case 1 :
					// PhoenixSQL.g:758:17: hint= hintClause
					{
					pushFollow(FOLLOW_hintClause_in_upsert_node4820);
					hint=hintClause();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			match(input,INTO,FOLLOW_INTO_in_upsert_node4824); if (state.failed) return ret;
			pushFollow(FOLLOW_from_table_name_in_upsert_node4828);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:759:9: ( LPAREN p= upsert_column_refs RPAREN )?
			int alt114=2;
			int LA114_0 = input.LA(1);
			if ( (LA114_0==LPAREN) ) {
				alt114=1;
			}
			switch (alt114) {
				case 1 :
					// PhoenixSQL.g:759:10: LPAREN p= upsert_column_refs RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_upsert_node4839); if (state.failed) return ret;
					pushFollow(FOLLOW_upsert_column_refs_in_upsert_node4843);
					p=upsert_column_refs();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_upsert_node4845); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:760:9: ( ( VALUES LPAREN v= one_or_more_expressions RPAREN ( ON DUPLICATE KEY (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) ) )? ) |s= select_node )
			int alt117=2;
			int LA117_0 = input.LA(1);
			if ( (LA117_0==VALUES) ) {
				alt117=1;
			}
			else if ( (LA117_0==SELECT) ) {
				alt117=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 117, 0, input);
				throw nvae;
			}

			switch (alt117) {
				case 1 :
					// PhoenixSQL.g:760:10: ( VALUES LPAREN v= one_or_more_expressions RPAREN ( ON DUPLICATE KEY (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) ) )? )
					{
					// PhoenixSQL.g:760:10: ( VALUES LPAREN v= one_or_more_expressions RPAREN ( ON DUPLICATE KEY (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) ) )? )
					// PhoenixSQL.g:760:11: VALUES LPAREN v= one_or_more_expressions RPAREN ( ON DUPLICATE KEY (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) ) )?
					{
					match(input,VALUES,FOLLOW_VALUES_in_upsert_node4859); if (state.failed) return ret;
					match(input,LPAREN,FOLLOW_LPAREN_in_upsert_node4861); if (state.failed) return ret;
					pushFollow(FOLLOW_one_or_more_expressions_in_upsert_node4865);
					v=one_or_more_expressions();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_upsert_node4867); if (state.failed) return ret;
					// PhoenixSQL.g:760:58: ( ON DUPLICATE KEY (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) ) )?
					int alt116=2;
					int LA116_0 = input.LA(1);
					if ( (LA116_0==ON) ) {
						alt116=1;
					}
					switch (alt116) {
						case 1 :
							// PhoenixSQL.g:760:60: ON DUPLICATE KEY (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) )
							{
							match(input,ON,FOLLOW_ON_in_upsert_node4871); if (state.failed) return ret;
							match(input,DUPLICATE,FOLLOW_DUPLICATE_in_upsert_node4873); if (state.failed) return ret;
							match(input,KEY,FOLLOW_KEY_in_upsert_node4875); if (state.failed) return ret;
							// PhoenixSQL.g:760:77: (ig= IGNORE | ( UPDATE pairs= update_column_pairs ) )
							int alt115=2;
							int LA115_0 = input.LA(1);
							if ( (LA115_0==IGNORE) ) {
								alt115=1;
							}
							else if ( (LA115_0==UPDATE) ) {
								alt115=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return ret;}
								NoViableAltException nvae =
									new NoViableAltException("", 115, 0, input);
								throw nvae;
							}

							switch (alt115) {
								case 1 :
									// PhoenixSQL.g:760:79: ig= IGNORE
									{
									ig=(Token)match(input,IGNORE,FOLLOW_IGNORE_in_upsert_node4881); if (state.failed) return ret;
									}
									break;
								case 2 :
									// PhoenixSQL.g:760:91: ( UPDATE pairs= update_column_pairs )
									{
									// PhoenixSQL.g:760:91: ( UPDATE pairs= update_column_pairs )
									// PhoenixSQL.g:760:93: UPDATE pairs= update_column_pairs
									{
									match(input,UPDATE,FOLLOW_UPDATE_in_upsert_node4887); if (state.failed) return ret;
									pushFollow(FOLLOW_update_column_pairs_in_upsert_node4891);
									pairs=update_column_pairs();
									state._fsp--;
									if (state.failed) return ret;
									}

									}
									break;

							}

							}
							break;

					}

					}

					}
					break;
				case 2 :
					// PhoenixSQL.g:760:137: s= select_node
					{
					pushFollow(FOLLOW_select_node_in_upsert_node4906);
					s=select_node();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.upsert(
			            factory.namedTable(null,t,p == null ? null : p.getFirst()), 
			            hint, p == null ? null : p.getSecond(), 
			            v, s, getBindCount(), 
			            new HashMap<String, UDFParseNode>(udfParseNodes),
			            ig != null ? Collections.<Pair<ColumnName,ParseNode>>emptyList() : pairs != null ? pairs : null); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "upsert_node"



	// $ANTLR start "update_column_pairs"
	// PhoenixSQL.g:769:1: update_column_pairs returns [ List<Pair<ColumnName,ParseNode>> ret] : p= update_column_pair ( COMMA p= update_column_pair )* ;
	public final List<Pair<ColumnName,ParseNode>> update_column_pairs() throws RecognitionException {
		List<Pair<ColumnName,ParseNode>> ret = null;


		Pair<ColumnName,ParseNode> p =null;

		ret = new ArrayList<Pair<ColumnName,ParseNode>>(); 
		try {
			// PhoenixSQL.g:771:5: (p= update_column_pair ( COMMA p= update_column_pair )* )
			// PhoenixSQL.g:771:8: p= update_column_pair ( COMMA p= update_column_pair )*
			{
			pushFollow(FOLLOW_update_column_pair_in_update_column_pairs4947);
			p=update_column_pair();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret.add(p); }
			// PhoenixSQL.g:772:8: ( COMMA p= update_column_pair )*
			loop118:
			while (true) {
				int alt118=2;
				int LA118_0 = input.LA(1);
				if ( (LA118_0==COMMA) ) {
					alt118=1;
				}

				switch (alt118) {
				case 1 :
					// PhoenixSQL.g:772:9: COMMA p= update_column_pair
					{
					match(input,COMMA,FOLLOW_COMMA_in_update_column_pairs4959); if (state.failed) return ret;
					pushFollow(FOLLOW_update_column_pair_in_update_column_pairs4963);
					p=update_column_pair();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret.add(p); }
					}
					break;

				default :
					break loop118;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "update_column_pairs"



	// $ANTLR start "update_column_pair"
	// PhoenixSQL.g:775:1: update_column_pair returns [ Pair<ColumnName,ParseNode> ret ] : c= column_name EQ e= expression ;
	public final Pair<ColumnName,ParseNode> update_column_pair() throws RecognitionException {
		Pair<ColumnName,ParseNode> ret = null;


		ColumnName c =null;
		ParseNode e =null;

		try {
			// PhoenixSQL.g:776:5: (c= column_name EQ e= expression )
			// PhoenixSQL.g:776:8: c= column_name EQ e= expression
			{
			pushFollow(FOLLOW_column_name_in_update_column_pair4988);
			c=column_name();
			state._fsp--;
			if (state.failed) return ret;
			match(input,EQ,FOLLOW_EQ_in_update_column_pair4990); if (state.failed) return ret;
			pushFollow(FOLLOW_expression_in_update_column_pair4994);
			e=expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = new Pair<ColumnName,ParseNode>(c,e); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "update_column_pair"



	// $ANTLR start "upsert_column_refs"
	// PhoenixSQL.g:780:1: upsert_column_refs returns [Pair<List<ColumnDef>,List<ColumnName>> ret] : d= dyn_column_name_or_def ( COMMA d= dyn_column_name_or_def )* ;
	public final Pair<List<ColumnDef>,List<ColumnName>> upsert_column_refs() throws RecognitionException {
		Pair<List<ColumnDef>,List<ColumnName>> ret = null;


		ColumnDef d =null;

		ret = new Pair<List<ColumnDef>,List<ColumnName>>(new ArrayList<ColumnDef>(), new ArrayList<ColumnName>()); 
		try {
			// PhoenixSQL.g:782:5: (d= dyn_column_name_or_def ( COMMA d= dyn_column_name_or_def )* )
			// PhoenixSQL.g:782:8: d= dyn_column_name_or_def ( COMMA d= dyn_column_name_or_def )*
			{
			pushFollow(FOLLOW_dyn_column_name_or_def_in_upsert_column_refs5023);
			d=dyn_column_name_or_def();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { if (d.getDataType()!=null) { ret.getFirst().add(d); } ret.getSecond().add(d.getColumnDefName()); }
			// PhoenixSQL.g:783:8: ( COMMA d= dyn_column_name_or_def )*
			loop119:
			while (true) {
				int alt119=2;
				int LA119_0 = input.LA(1);
				if ( (LA119_0==COMMA) ) {
					alt119=1;
				}

				switch (alt119) {
				case 1 :
					// PhoenixSQL.g:783:9: COMMA d= dyn_column_name_or_def
					{
					match(input,COMMA,FOLLOW_COMMA_in_upsert_column_refs5036); if (state.failed) return ret;
					pushFollow(FOLLOW_dyn_column_name_or_def_in_upsert_column_refs5040);
					d=dyn_column_name_or_def();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { if (d.getDataType()!=null) { ret.getFirst().add(d); } ret.getSecond().add(d.getColumnDefName()); }
					}
					break;

				default :
					break loop119;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "upsert_column_refs"



	// $ANTLR start "declare_cursor_node"
	// PhoenixSQL.g:788:1: declare_cursor_node returns [DeclareCursorStatement ret] : DECLARE c= cursor_name CURSOR FOR s= select_node ;
	public final DeclareCursorStatement declare_cursor_node() throws RecognitionException {
		DeclareCursorStatement ret = null;


		CursorName c =null;
		SelectStatement s =null;

		try {
			// PhoenixSQL.g:789:5: ( DECLARE c= cursor_name CURSOR FOR s= select_node )
			// PhoenixSQL.g:789:10: DECLARE c= cursor_name CURSOR FOR s= select_node
			{
			match(input,DECLARE,FOLLOW_DECLARE_in_declare_cursor_node5068); if (state.failed) return ret;
			pushFollow(FOLLOW_cursor_name_in_declare_cursor_node5072);
			c=cursor_name();
			state._fsp--;
			if (state.failed) return ret;
			match(input,CURSOR,FOLLOW_CURSOR_in_declare_cursor_node5074); if (state.failed) return ret;
			match(input,FOR,FOLLOW_FOR_in_declare_cursor_node5076); if (state.failed) return ret;
			pushFollow(FOLLOW_select_node_in_declare_cursor_node5080);
			s=select_node();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.declareCursor(c, s); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "declare_cursor_node"



	// $ANTLR start "cursor_open_node"
	// PhoenixSQL.g:793:1: cursor_open_node returns [OpenStatement ret] : OPEN c= cursor_name ;
	public final OpenStatement cursor_open_node() throws RecognitionException {
		OpenStatement ret = null;


		CursorName c =null;

		try {
			// PhoenixSQL.g:794:5: ( OPEN c= cursor_name )
			// PhoenixSQL.g:794:10: OPEN c= cursor_name
			{
			match(input,OPEN,FOLLOW_OPEN_in_cursor_open_node5114); if (state.failed) return ret;
			pushFollow(FOLLOW_cursor_name_in_cursor_open_node5118);
			c=cursor_name();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.open(c);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "cursor_open_node"



	// $ANTLR start "cursor_close_node"
	// PhoenixSQL.g:797:1: cursor_close_node returns [CloseStatement ret] : CLOSE c= cursor_name ;
	public final CloseStatement cursor_close_node() throws RecognitionException {
		CloseStatement ret = null;


		CursorName c =null;

		try {
			// PhoenixSQL.g:798:5: ( CLOSE c= cursor_name )
			// PhoenixSQL.g:798:10: CLOSE c= cursor_name
			{
			match(input,CLOSE,FOLLOW_CLOSE_in_cursor_close_node5145); if (state.failed) return ret;
			pushFollow(FOLLOW_cursor_name_in_cursor_close_node5149);
			c=cursor_name();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.close(c);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "cursor_close_node"



	// $ANTLR start "cursor_fetch_node"
	// PhoenixSQL.g:801:1: cursor_fetch_node returns [FetchStatement ret] : FETCH NEXT (a= NUMBER )? ( ROW | ROWS )? FROM c= cursor_name ;
	public final FetchStatement cursor_fetch_node() throws RecognitionException {
		FetchStatement ret = null;


		Token a=null;
		CursorName c =null;

		try {
			// PhoenixSQL.g:802:5: ( FETCH NEXT (a= NUMBER )? ( ROW | ROWS )? FROM c= cursor_name )
			// PhoenixSQL.g:802:10: FETCH NEXT (a= NUMBER )? ( ROW | ROWS )? FROM c= cursor_name
			{
			match(input,FETCH,FOLLOW_FETCH_in_cursor_fetch_node5175); if (state.failed) return ret;
			match(input,NEXT,FOLLOW_NEXT_in_cursor_fetch_node5177); if (state.failed) return ret;
			// PhoenixSQL.g:802:21: (a= NUMBER )?
			int alt120=2;
			int LA120_0 = input.LA(1);
			if ( (LA120_0==NUMBER) ) {
				alt120=1;
			}
			switch (alt120) {
				case 1 :
					// PhoenixSQL.g:802:22: a= NUMBER
					{
					a=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_cursor_fetch_node5182); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:802:33: ( ROW | ROWS )?
			int alt121=2;
			int LA121_0 = input.LA(1);
			if ( ((LA121_0 >= ROW && LA121_0 <= ROWS)) ) {
				alt121=1;
			}
			switch (alt121) {
				case 1 :
					// PhoenixSQL.g:
					{
					if ( (input.LA(1) >= ROW && input.LA(1) <= ROWS) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			match(input,FROM,FOLLOW_FROM_in_cursor_fetch_node5193); if (state.failed) return ret;
			pushFollow(FOLLOW_cursor_name_in_cursor_fetch_node5197);
			c=cursor_name();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.fetch(c,true, a == null ? 1 :  Integer.parseInt( a.getText() )); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "cursor_fetch_node"



	// $ANTLR start "delete_node"
	// PhoenixSQL.g:806:1: delete_node returns [DeleteStatement ret] : DELETE (hint= hintClause )? FROM t= from_table_name ( WHERE v= expression )? ( ORDER BY order= order_by )? ( LIMIT l= limit )? ;
	public final DeleteStatement delete_node() throws RecognitionException {
		DeleteStatement ret = null;


		HintNode hint =null;
		TableName t =null;
		ParseNode v =null;
		List<OrderByNode> order =null;
		LimitNode l =null;

		try {
			// PhoenixSQL.g:807:5: ( DELETE (hint= hintClause )? FROM t= from_table_name ( WHERE v= expression )? ( ORDER BY order= order_by )? ( LIMIT l= limit )? )
			// PhoenixSQL.g:807:9: DELETE (hint= hintClause )? FROM t= from_table_name ( WHERE v= expression )? ( ORDER BY order= order_by )? ( LIMIT l= limit )?
			{
			match(input,DELETE,FOLLOW_DELETE_in_delete_node5223); if (state.failed) return ret;
			// PhoenixSQL.g:807:16: (hint= hintClause )?
			int alt122=2;
			int LA122_0 = input.LA(1);
			if ( (LA122_0==ML_HINT) ) {
				alt122=1;
			}
			switch (alt122) {
				case 1 :
					// PhoenixSQL.g:807:17: hint= hintClause
					{
					pushFollow(FOLLOW_hintClause_in_delete_node5228);
					hint=hintClause();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			match(input,FROM,FOLLOW_FROM_in_delete_node5232); if (state.failed) return ret;
			pushFollow(FOLLOW_from_table_name_in_delete_node5236);
			t=from_table_name();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:808:9: ( WHERE v= expression )?
			int alt123=2;
			int LA123_0 = input.LA(1);
			if ( (LA123_0==WHERE) ) {
				alt123=1;
			}
			switch (alt123) {
				case 1 :
					// PhoenixSQL.g:808:10: WHERE v= expression
					{
					match(input,WHERE,FOLLOW_WHERE_in_delete_node5247); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_delete_node5251);
					v=expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:809:9: ( ORDER BY order= order_by )?
			int alt124=2;
			int LA124_0 = input.LA(1);
			if ( (LA124_0==ORDER) ) {
				alt124=1;
			}
			switch (alt124) {
				case 1 :
					// PhoenixSQL.g:809:10: ORDER BY order= order_by
					{
					match(input,ORDER,FOLLOW_ORDER_in_delete_node5264); if (state.failed) return ret;
					match(input,BY,FOLLOW_BY_in_delete_node5266); if (state.failed) return ret;
					pushFollow(FOLLOW_order_by_in_delete_node5270);
					order=order_by();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:810:9: ( LIMIT l= limit )?
			int alt125=2;
			int LA125_0 = input.LA(1);
			if ( (LA125_0==LIMIT) ) {
				alt125=1;
			}
			switch (alt125) {
				case 1 :
					// PhoenixSQL.g:810:10: LIMIT l= limit
					{
					match(input,LIMIT,FOLLOW_LIMIT_in_delete_node5283); if (state.failed) return ret;
					pushFollow(FOLLOW_limit_in_delete_node5287);
					l=limit();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.delete(factory.namedTable(null,t), hint, v, order, l, getBindCount(), new HashMap<String, UDFParseNode>(udfParseNodes)); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "delete_node"



	// $ANTLR start "limit"
	// PhoenixSQL.g:814:1: limit returns [LimitNode ret] : (b= bind_expression |l= int_or_long_literal );
	public final LimitNode limit() throws RecognitionException {
		LimitNode ret = null;


		BindParseNode b =null;
		LiteralParseNode l =null;

		try {
			// PhoenixSQL.g:815:5: (b= bind_expression |l= int_or_long_literal )
			int alt126=2;
			int LA126_0 = input.LA(1);
			if ( (LA126_0==BIND_NAME||LA126_0==QUESTION) ) {
				alt126=1;
			}
			else if ( (LA126_0==NUMBER) ) {
				alt126=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 126, 0, input);
				throw nvae;
			}

			switch (alt126) {
				case 1 :
					// PhoenixSQL.g:815:7: b= bind_expression
					{
					pushFollow(FOLLOW_bind_expression_in_limit5322);
					b=bind_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.limit(b); }
					}
					break;
				case 2 :
					// PhoenixSQL.g:816:7: l= int_or_long_literal
					{
					pushFollow(FOLLOW_int_or_long_literal_in_limit5334);
					l=int_or_long_literal();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.limit(l); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "limit"



	// $ANTLR start "offset"
	// PhoenixSQL.g:819:1: offset returns [OffsetNode ret] : (b= bind_expression |l= int_or_long_literal );
	public final OffsetNode offset() throws RecognitionException {
		OffsetNode ret = null;


		BindParseNode b =null;
		LiteralParseNode l =null;

		try {
			// PhoenixSQL.g:820:2: (b= bind_expression |l= int_or_long_literal )
			int alt127=2;
			int LA127_0 = input.LA(1);
			if ( (LA127_0==BIND_NAME||LA127_0==QUESTION) ) {
				alt127=1;
			}
			else if ( (LA127_0==NUMBER) ) {
				alt127=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 127, 0, input);
				throw nvae;
			}

			switch (alt127) {
				case 1 :
					// PhoenixSQL.g:820:4: b= bind_expression
					{
					pushFollow(FOLLOW_bind_expression_in_offset5360);
					b=bind_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.offset(b); }
					}
					break;
				case 2 :
					// PhoenixSQL.g:821:7: l= int_or_long_literal
					{
					pushFollow(FOLLOW_int_or_long_literal_in_offset5372);
					l=int_or_long_literal();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.offset(l); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "offset"



	// $ANTLR start "sampling_rate"
	// PhoenixSQL.g:824:1: sampling_rate returns [LiteralParseNode ret] : l= literal ;
	public final LiteralParseNode sampling_rate() throws RecognitionException {
		LiteralParseNode ret = null;


		LiteralParseNode l =null;

		try {
			// PhoenixSQL.g:825:5: (l= literal )
			// PhoenixSQL.g:825:7: l= literal
			{
			pushFollow(FOLLOW_literal_in_sampling_rate5397);
			l=literal();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = l; }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "sampling_rate"



	// $ANTLR start "tableSampleNode"
	// PhoenixSQL.g:828:1: tableSampleNode returns [LiteralParseNode ret] : l= literal ;
	public final LiteralParseNode tableSampleNode() throws RecognitionException {
		LiteralParseNode ret = null;


		LiteralParseNode l =null;

		try {
			// PhoenixSQL.g:829:5: (l= literal )
			// PhoenixSQL.g:829:7: l= literal
			{
			pushFollow(FOLLOW_literal_in_tableSampleNode5422);
			l=literal();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = l; }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "tableSampleNode"



	// $ANTLR start "hintClause"
	// PhoenixSQL.g:832:1: hintClause returns [HintNode ret] : c= ML_HINT ;
	public final HintNode hintClause() throws RecognitionException {
		HintNode ret = null;


		Token c=null;

		try {
			// PhoenixSQL.g:833:5: (c= ML_HINT )
			// PhoenixSQL.g:833:8: c= ML_HINT
			{
			c=(Token)match(input,ML_HINT,FOLLOW_ML_HINT_in_hintClause5448); if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = factory.hint(c.getText()); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "hintClause"



	// $ANTLR start "select_list"
	// PhoenixSQL.g:837:1: select_list returns [List<AliasedNode> ret] : (n= selectable ( COMMA n= selectable )* | ASTERISK );
	public final List<AliasedNode> select_list() throws RecognitionException {
		List<AliasedNode> ret = null;


		AliasedNode n =null;

		ret = new ArrayList<AliasedNode>();
		try {
			// PhoenixSQL.g:839:5: (n= selectable ( COMMA n= selectable )* | ASTERISK )
			int alt129=2;
			int LA129_0 = input.LA(1);
			if ( (LA129_0==ARRAY||LA129_0==BIND_NAME||(LA129_0 >= CASE && LA129_0 <= CAST)||LA129_0==CURRENT||LA129_0==DECIMAL||LA129_0==DOUBLE||LA129_0==EXISTS||LA129_0==FALSE||LA129_0==LPAREN||LA129_0==MINUS||(LA129_0 >= NAME && LA129_0 <= NEXT)||(LA129_0 >= NOT && LA129_0 <= NULL)||LA129_0==NUMBER||LA129_0==QUESTION||LA129_0==STRING_LITERAL||LA129_0==TRUE) ) {
				alt129=1;
			}
			else if ( (LA129_0==ASTERISK) ) {
				alt129=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 129, 0, input);
				throw nvae;
			}

			switch (alt129) {
				case 1 :
					// PhoenixSQL.g:839:9: n= selectable ( COMMA n= selectable )*
					{
					pushFollow(FOLLOW_selectable_in_select_list5480);
					n=selectable();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(n);}
					// PhoenixSQL.g:839:36: ( COMMA n= selectable )*
					loop128:
					while (true) {
						int alt128=2;
						int LA128_0 = input.LA(1);
						if ( (LA128_0==COMMA) ) {
							alt128=1;
						}

						switch (alt128) {
						case 1 :
							// PhoenixSQL.g:839:37: COMMA n= selectable
							{
							match(input,COMMA,FOLLOW_COMMA_in_select_list5485); if (state.failed) return ret;
							pushFollow(FOLLOW_selectable_in_select_list5489);
							n=selectable();
							state._fsp--;
							if (state.failed) return ret;
							if ( state.backtracking==0 ) {ret.add(n);}
							}
							break;

						default :
							break loop128;
						}
					}

					}
					break;
				case 2 :
					// PhoenixSQL.g:840:7: ASTERISK
					{
					match(input,ASTERISK,FOLLOW_ASTERISK_in_select_list5501); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = Collections.<AliasedNode>singletonList(factory.aliasedNode(null, factory.wildcard()));}
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "select_list"



	// $ANTLR start "selectable"
	// PhoenixSQL.g:844:1: selectable returns [AliasedNode ret] : (field= expression (a= parseAlias )? |familyName= identifier DOT ASTERISK |s= identifier DOT t= identifier DOT ASTERISK );
	public final AliasedNode selectable() throws RecognitionException {
		AliasedNode ret = null;


		ParseNode field =null;
		String a =null;
		String familyName =null;
		String s =null;
		String t =null;

		try {
			// PhoenixSQL.g:845:5: (field= expression (a= parseAlias )? |familyName= identifier DOT ASTERISK |s= identifier DOT t= identifier DOT ASTERISK )
			int alt131=3;
			int LA131_0 = input.LA(1);
			if ( (LA131_0==ARRAY||LA131_0==BIND_NAME||(LA131_0 >= CASE && LA131_0 <= CAST)||LA131_0==CURRENT||LA131_0==DECIMAL||LA131_0==DOUBLE||LA131_0==EXISTS||LA131_0==FALSE||LA131_0==LPAREN||LA131_0==MINUS||LA131_0==NEXT||(LA131_0 >= NOT && LA131_0 <= NULL)||LA131_0==NUMBER||LA131_0==QUESTION||LA131_0==STRING_LITERAL||LA131_0==TRUE) ) {
				alt131=1;
			}
			else if ( (LA131_0==NAME) ) {
				int LA131_2 = input.LA(2);
				if ( (LA131_2==EOF||LA131_2==AND||LA131_2==AS||LA131_2==ASTERISK||LA131_2==BETWEEN||LA131_2==COMMA||LA131_2==CONCAT||LA131_2==DIVIDE||LA131_2==EQ||LA131_2==FETCH||LA131_2==FROM||(LA131_2 >= GROUP && LA131_2 <= HAVING)||LA131_2==ILIKE||LA131_2==IN||LA131_2==IS||(LA131_2 >= LIKE && LA131_2 <= LIMIT)||(LA131_2 >= LPAREN && LA131_2 <= LT)||LA131_2==MINUS||LA131_2==NAME||(LA131_2 >= NOEQ1 && LA131_2 <= NOT)||LA131_2==OFFSET||(LA131_2 >= OR && LA131_2 <= ORDER)||(LA131_2 >= PERCENT && LA131_2 <= PLUS)||LA131_2==RPAREN||LA131_2==SEMICOLON||LA131_2==STRING_LITERAL||LA131_2==UNION||LA131_2==WHERE) ) {
					alt131=1;
				}
				else if ( (LA131_2==DOT) ) {
					int LA131_3 = input.LA(3);
					if ( (LA131_3==ASTERISK) ) {
						alt131=2;
					}
					else if ( (LA131_3==NAME) ) {
						int LA131_5 = input.LA(4);
						if ( (LA131_5==EOF||LA131_5==AND||LA131_5==AS||LA131_5==ASTERISK||LA131_5==BETWEEN||LA131_5==COMMA||LA131_5==CONCAT||LA131_5==DIVIDE||LA131_5==EQ||LA131_5==FETCH||LA131_5==FROM||(LA131_5 >= GROUP && LA131_5 <= HAVING)||LA131_5==ILIKE||LA131_5==IN||LA131_5==IS||(LA131_5 >= LIKE && LA131_5 <= LIMIT)||(LA131_5 >= LSQUARE && LA131_5 <= LT)||LA131_5==MINUS||LA131_5==NAME||(LA131_5 >= NOEQ1 && LA131_5 <= NOT)||LA131_5==OFFSET||(LA131_5 >= OR && LA131_5 <= ORDER)||(LA131_5 >= PERCENT && LA131_5 <= PLUS)||LA131_5==RPAREN||LA131_5==SEMICOLON||LA131_5==UNION||LA131_5==WHERE) ) {
							alt131=1;
						}
						else if ( (LA131_5==DOT) ) {
							int LA131_6 = input.LA(5);
							if ( (LA131_6==ASTERISK) ) {
								alt131=3;
							}
							else if ( (LA131_6==NAME) ) {
								alt131=1;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return ret;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 131, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return ret;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 131, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 131, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 131, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 131, 0, input);
				throw nvae;
			}

			switch (alt131) {
				case 1 :
					// PhoenixSQL.g:845:9: field= expression (a= parseAlias )?
					{
					pushFollow(FOLLOW_expression_in_selectable5530);
					field=expression();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:845:26: (a= parseAlias )?
					int alt130=2;
					int LA130_0 = input.LA(1);
					if ( (LA130_0==AS||LA130_0==NAME) ) {
						alt130=1;
					}
					switch (alt130) {
						case 1 :
							// PhoenixSQL.g:845:27: a= parseAlias
							{
							pushFollow(FOLLOW_parseAlias_in_selectable5535);
							a=parseAlias();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					if ( state.backtracking==0 ) { ret = factory.aliasedNode(a, field); }
					}
					break;
				case 2 :
					// PhoenixSQL.g:846:8: familyName= identifier DOT ASTERISK
					{
					pushFollow(FOLLOW_identifier_in_selectable5550);
					familyName=identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,DOT,FOLLOW_DOT_in_selectable5552); if (state.failed) return ret;
					match(input,ASTERISK,FOLLOW_ASTERISK_in_selectable5554); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.aliasedNode(null, factory.family(familyName));}
					}
					break;
				case 3 :
					// PhoenixSQL.g:847:9: s= identifier DOT t= identifier DOT ASTERISK
					{
					pushFollow(FOLLOW_identifier_in_selectable5569);
					s=identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,DOT,FOLLOW_DOT_in_selectable5571); if (state.failed) return ret;
					pushFollow(FOLLOW_identifier_in_selectable5575);
					t=identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,DOT,FOLLOW_DOT_in_selectable5577); if (state.failed) return ret;
					match(input,ASTERISK,FOLLOW_ASTERISK_in_selectable5579); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.aliasedNode(null, factory.tableWildcard(factory.table(s, t))); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "selectable"



	// $ANTLR start "group_by"
	// PhoenixSQL.g:852:1: group_by returns [List<ParseNode> ret] : expr= expression ( COMMA expr= expression )* ;
	public final List<ParseNode> group_by() throws RecognitionException {
		List<ParseNode> ret = null;


		ParseNode expr =null;

		ret = new ArrayList<ParseNode>();
		try {
			// PhoenixSQL.g:854:5: (expr= expression ( COMMA expr= expression )* )
			// PhoenixSQL.g:854:9: expr= expression ( COMMA expr= expression )*
			{
			pushFollow(FOLLOW_expression_in_group_by5612);
			expr=expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret.add(expr); }
			// PhoenixSQL.g:855:9: ( COMMA expr= expression )*
			loop132:
			while (true) {
				int alt132=2;
				int LA132_0 = input.LA(1);
				if ( (LA132_0==COMMA) ) {
					alt132=1;
				}

				switch (alt132) {
				case 1 :
					// PhoenixSQL.g:855:10: COMMA expr= expression
					{
					match(input,COMMA,FOLLOW_COMMA_in_group_by5625); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_group_by5631);
					expr=expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(expr); }
					}
					break;

				default :
					break loop132;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "group_by"



	// $ANTLR start "order_by"
	// PhoenixSQL.g:859:1: order_by returns [List<OrderByNode> ret] : field= parseOrderByField ( COMMA field= parseOrderByField )* ;
	public final List<OrderByNode> order_by() throws RecognitionException {
		List<OrderByNode> ret = null;


		OrderByNode field =null;

		ret = new ArrayList<OrderByNode>();
		try {
			// PhoenixSQL.g:861:5: (field= parseOrderByField ( COMMA field= parseOrderByField )* )
			// PhoenixSQL.g:861:9: field= parseOrderByField ( COMMA field= parseOrderByField )*
			{
			pushFollow(FOLLOW_parseOrderByField_in_order_by5665);
			field=parseOrderByField();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret.add(field); }
			// PhoenixSQL.g:862:9: ( COMMA field= parseOrderByField )*
			loop133:
			while (true) {
				int alt133=2;
				int LA133_0 = input.LA(1);
				if ( (LA133_0==COMMA) ) {
					alt133=1;
				}

				switch (alt133) {
				case 1 :
					// PhoenixSQL.g:862:10: COMMA field= parseOrderByField
					{
					match(input,COMMA,FOLLOW_COMMA_in_order_by5678); if (state.failed) return ret;
					pushFollow(FOLLOW_parseOrderByField_in_order_by5684);
					field=parseOrderByField();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(field); }
					}
					break;

				default :
					break loop133;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "order_by"



	// $ANTLR start "parseOrderByField"
	// PhoenixSQL.g:866:1: parseOrderByField returns [OrderByNode ret] : (expr= expression ) ( ASC | DESC )? ( NULLS ( FIRST | LAST ) )? ;
	public final OrderByNode parseOrderByField() throws RecognitionException {
		OrderByNode ret = null;


		ParseNode expr =null;

		boolean isAscending = true; boolean nullsLast = false;
		try {
			// PhoenixSQL.g:868:5: ( (expr= expression ) ( ASC | DESC )? ( NULLS ( FIRST | LAST ) )? )
			// PhoenixSQL.g:868:9: (expr= expression ) ( ASC | DESC )? ( NULLS ( FIRST | LAST ) )?
			{
			// PhoenixSQL.g:868:9: (expr= expression )
			// PhoenixSQL.g:868:10: expr= expression
			{
			pushFollow(FOLLOW_expression_in_parseOrderByField5721);
			expr=expression();
			state._fsp--;
			if (state.failed) return ret;
			}

			// PhoenixSQL.g:869:9: ( ASC | DESC )?
			int alt134=3;
			int LA134_0 = input.LA(1);
			if ( (LA134_0==ASC) ) {
				alt134=1;
			}
			else if ( (LA134_0==DESC) ) {
				alt134=2;
			}
			switch (alt134) {
				case 1 :
					// PhoenixSQL.g:869:10: ASC
					{
					match(input,ASC,FOLLOW_ASC_in_parseOrderByField5733); if (state.failed) return ret;
					if ( state.backtracking==0 ) {isAscending = true;}
					}
					break;
				case 2 :
					// PhoenixSQL.g:869:38: DESC
					{
					match(input,DESC,FOLLOW_DESC_in_parseOrderByField5739); if (state.failed) return ret;
					if ( state.backtracking==0 ) {isAscending = false;}
					}
					break;

			}

			// PhoenixSQL.g:870:9: ( NULLS ( FIRST | LAST ) )?
			int alt136=2;
			int LA136_0 = input.LA(1);
			if ( (LA136_0==NULLS) ) {
				alt136=1;
			}
			switch (alt136) {
				case 1 :
					// PhoenixSQL.g:870:10: NULLS ( FIRST | LAST )
					{
					match(input,NULLS,FOLLOW_NULLS_in_parseOrderByField5754); if (state.failed) return ret;
					// PhoenixSQL.g:870:16: ( FIRST | LAST )
					int alt135=2;
					int LA135_0 = input.LA(1);
					if ( (LA135_0==FIRST) ) {
						alt135=1;
					}
					else if ( (LA135_0==LAST) ) {
						alt135=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						NoViableAltException nvae =
							new NoViableAltException("", 135, 0, input);
						throw nvae;
					}

					switch (alt135) {
						case 1 :
							// PhoenixSQL.g:870:17: FIRST
							{
							match(input,FIRST,FOLLOW_FIRST_in_parseOrderByField5757); if (state.failed) return ret;
							if ( state.backtracking==0 ) {nullsLast = false;}
							}
							break;
						case 2 :
							// PhoenixSQL.g:870:46: LAST
							{
							match(input,LAST,FOLLOW_LAST_in_parseOrderByField5763); if (state.failed) return ret;
							if ( state.backtracking==0 ) {nullsLast = true;}
							}
							break;

					}

					}
					break;

			}

			if ( state.backtracking==0 ) { ret = factory.orderBy(expr, nullsLast, isAscending); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "parseOrderByField"



	// $ANTLR start "parseFrom"
	// PhoenixSQL.g:874:1: parseFrom returns [TableNode ret] : t= table_list ;
	public final TableNode parseFrom() throws RecognitionException {
		TableNode ret = null;


		TableNode t =null;

		try {
			// PhoenixSQL.g:875:5: (t= table_list )
			// PhoenixSQL.g:875:9: t= table_list
			{
			pushFollow(FOLLOW_table_list_in_parseFrom5803);
			t=table_list();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = t;}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "parseFrom"



	// $ANTLR start "table_list"
	// PhoenixSQL.g:878:1: table_list returns [TableNode ret] : t= table_ref ( COMMA s= table_ref )* ;
	public final TableNode table_list() throws RecognitionException {
		TableNode ret = null;


		TableNode t =null;
		TableNode s =null;

		try {
			// PhoenixSQL.g:879:5: (t= table_ref ( COMMA s= table_ref )* )
			// PhoenixSQL.g:879:9: t= table_ref ( COMMA s= table_ref )*
			{
			pushFollow(FOLLOW_table_ref_in_table_list5834);
			t=table_ref();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = t;}
			// PhoenixSQL.g:879:33: ( COMMA s= table_ref )*
			loop137:
			while (true) {
				int alt137=2;
				int LA137_0 = input.LA(1);
				if ( (LA137_0==COMMA) ) {
					alt137=1;
				}

				switch (alt137) {
				case 1 :
					// PhoenixSQL.g:879:34: COMMA s= table_ref
					{
					match(input,COMMA,FOLLOW_COMMA_in_table_list5839); if (state.failed) return ret;
					pushFollow(FOLLOW_table_ref_in_table_list5843);
					s=table_ref();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.join(JoinTableNode.JoinType.Inner, ret, s, null, false); }
					}
					break;

				default :
					break loop137;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "table_list"



	// $ANTLR start "table_ref"
	// PhoenixSQL.g:882:1: table_ref returns [TableNode ret] : l= table_factor (j= join_type JOIN r= table_factor ON e= expression )* ;
	public final TableNode table_ref() throws RecognitionException {
		TableNode ret = null;


		TableNode l =null;
		JoinTableNode.JoinType j =null;
		TableNode r =null;
		ParseNode e =null;

		try {
			// PhoenixSQL.g:883:2: (l= table_factor (j= join_type JOIN r= table_factor ON e= expression )* )
			// PhoenixSQL.g:883:4: l= table_factor (j= join_type JOIN r= table_factor ON e= expression )*
			{
			pushFollow(FOLLOW_table_factor_in_table_ref5867);
			l=table_factor();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = l; }
			// PhoenixSQL.g:883:33: (j= join_type JOIN r= table_factor ON e= expression )*
			loop138:
			while (true) {
				int alt138=2;
				int LA138_0 = input.LA(1);
				if ( (LA138_0==FULL||LA138_0==INNER||LA138_0==JOIN||LA138_0==LEFT||LA138_0==RIGHT) ) {
					alt138=1;
				}

				switch (alt138) {
				case 1 :
					// PhoenixSQL.g:883:34: j= join_type JOIN r= table_factor ON e= expression
					{
					pushFollow(FOLLOW_join_type_in_table_ref5874);
					j=join_type();
					state._fsp--;
					if (state.failed) return ret;
					match(input,JOIN,FOLLOW_JOIN_in_table_ref5876); if (state.failed) return ret;
					pushFollow(FOLLOW_table_factor_in_table_ref5880);
					r=table_factor();
					state._fsp--;
					if (state.failed) return ret;
					match(input,ON,FOLLOW_ON_in_table_ref5882); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_table_ref5886);
					e=expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.join(j, ret, r, e, false); }
					}
					break;

				default :
					break loop138;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "table_ref"



	// $ANTLR start "table_factor"
	// PhoenixSQL.g:886:1: table_factor returns [TableNode ret] : ( LPAREN t= table_list RPAREN |n= bind_name ( ( AS )? alias= identifier )? |f= from_table_name ( ( AS )? alias= identifier )? ( LPAREN cdefs= dyn_column_defs RPAREN )? ( TABLESAMPLE LPAREN tableSample= tableSampleNode RPAREN )? | LPAREN s= select_node RPAREN ( ( AS )? alias= identifier )? );
	public final TableNode table_factor() throws RecognitionException {
		TableNode ret = null;


		TableNode t =null;
		String n =null;
		String alias =null;
		TableName f =null;
		List<ColumnDef> cdefs =null;
		LiteralParseNode tableSample =null;
		SelectStatement s =null;

		try {
			// PhoenixSQL.g:887:5: ( LPAREN t= table_list RPAREN |n= bind_name ( ( AS )? alias= identifier )? |f= from_table_name ( ( AS )? alias= identifier )? ( LPAREN cdefs= dyn_column_defs RPAREN )? ( TABLESAMPLE LPAREN tableSample= tableSampleNode RPAREN )? | LPAREN s= select_node RPAREN ( ( AS )? alias= identifier )? )
			int alt147=4;
			switch ( input.LA(1) ) {
			case LPAREN:
				{
				int LA147_1 = input.LA(2);
				if ( (LA147_1==BIND_NAME||LA147_1==LPAREN||LA147_1==NAME||LA147_1==QUESTION) ) {
					alt147=1;
				}
				else if ( (LA147_1==SELECT) ) {
					alt147=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 147, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case BIND_NAME:
			case QUESTION:
				{
				alt147=2;
				}
				break;
			case NAME:
				{
				alt147=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 147, 0, input);
				throw nvae;
			}
			switch (alt147) {
				case 1 :
					// PhoenixSQL.g:887:9: LPAREN t= table_list RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_table_factor5910); if (state.failed) return ret;
					pushFollow(FOLLOW_table_list_in_table_factor5914);
					t=table_list();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_table_factor5916); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = t; }
					}
					break;
				case 2 :
					// PhoenixSQL.g:888:9: n= bind_name ( ( AS )? alias= identifier )?
					{
					pushFollow(FOLLOW_bind_name_in_table_factor5930);
					n=bind_name();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:888:21: ( ( AS )? alias= identifier )?
					int alt140=2;
					int LA140_0 = input.LA(1);
					if ( (LA140_0==AS||LA140_0==NAME) ) {
						alt140=1;
					}
					switch (alt140) {
						case 1 :
							// PhoenixSQL.g:888:22: ( AS )? alias= identifier
							{
							// PhoenixSQL.g:888:22: ( AS )?
							int alt139=2;
							int LA139_0 = input.LA(1);
							if ( (LA139_0==AS) ) {
								alt139=1;
							}
							switch (alt139) {
								case 1 :
									// PhoenixSQL.g:888:23: AS
									{
									match(input,AS,FOLLOW_AS_in_table_factor5934); if (state.failed) return ret;
									}
									break;

							}

							pushFollow(FOLLOW_identifier_in_table_factor5940);
							alias=identifier();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					if ( state.backtracking==0 ) { ret = factory.bindTable(alias, factory.table(null,n)); }
					}
					break;
				case 3 :
					// PhoenixSQL.g:889:9: f= from_table_name ( ( AS )? alias= identifier )? ( LPAREN cdefs= dyn_column_defs RPAREN )? ( TABLESAMPLE LPAREN tableSample= tableSampleNode RPAREN )?
					{
					pushFollow(FOLLOW_from_table_name_in_table_factor5957);
					f=from_table_name();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:889:27: ( ( AS )? alias= identifier )?
					int alt142=2;
					int LA142_0 = input.LA(1);
					if ( (LA142_0==AS||LA142_0==NAME) ) {
						alt142=1;
					}
					switch (alt142) {
						case 1 :
							// PhoenixSQL.g:889:28: ( AS )? alias= identifier
							{
							// PhoenixSQL.g:889:28: ( AS )?
							int alt141=2;
							int LA141_0 = input.LA(1);
							if ( (LA141_0==AS) ) {
								alt141=1;
							}
							switch (alt141) {
								case 1 :
									// PhoenixSQL.g:889:29: AS
									{
									match(input,AS,FOLLOW_AS_in_table_factor5961); if (state.failed) return ret;
									}
									break;

							}

							pushFollow(FOLLOW_identifier_in_table_factor5967);
							alias=identifier();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					// PhoenixSQL.g:889:53: ( LPAREN cdefs= dyn_column_defs RPAREN )?
					int alt143=2;
					int LA143_0 = input.LA(1);
					if ( (LA143_0==LPAREN) ) {
						alt143=1;
					}
					switch (alt143) {
						case 1 :
							// PhoenixSQL.g:889:54: LPAREN cdefs= dyn_column_defs RPAREN
							{
							match(input,LPAREN,FOLLOW_LPAREN_in_table_factor5972); if (state.failed) return ret;
							pushFollow(FOLLOW_dyn_column_defs_in_table_factor5976);
							cdefs=dyn_column_defs();
							state._fsp--;
							if (state.failed) return ret;
							match(input,RPAREN,FOLLOW_RPAREN_in_table_factor5978); if (state.failed) return ret;
							}
							break;

					}

					// PhoenixSQL.g:889:92: ( TABLESAMPLE LPAREN tableSample= tableSampleNode RPAREN )?
					int alt144=2;
					int LA144_0 = input.LA(1);
					if ( (LA144_0==TABLESAMPLE) ) {
						alt144=1;
					}
					switch (alt144) {
						case 1 :
							// PhoenixSQL.g:889:93: TABLESAMPLE LPAREN tableSample= tableSampleNode RPAREN
							{
							match(input,TABLESAMPLE,FOLLOW_TABLESAMPLE_in_table_factor5983); if (state.failed) return ret;
							match(input,LPAREN,FOLLOW_LPAREN_in_table_factor5985); if (state.failed) return ret;
							pushFollow(FOLLOW_tableSampleNode_in_table_factor5989);
							tableSample=tableSampleNode();
							state._fsp--;
							if (state.failed) return ret;
							match(input,RPAREN,FOLLOW_RPAREN_in_table_factor5991); if (state.failed) return ret;
							}
							break;

					}

					if ( state.backtracking==0 ) { ret = factory.namedTable(alias,f,cdefs, tableSample);}
					}
					break;
				case 4 :
					// PhoenixSQL.g:890:9: LPAREN s= select_node RPAREN ( ( AS )? alias= identifier )?
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_table_factor6005); if (state.failed) return ret;
					pushFollow(FOLLOW_select_node_in_table_factor6009);
					s=select_node();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_table_factor6011); if (state.failed) return ret;
					// PhoenixSQL.g:890:37: ( ( AS )? alias= identifier )?
					int alt146=2;
					int LA146_0 = input.LA(1);
					if ( (LA146_0==AS||LA146_0==NAME) ) {
						alt146=1;
					}
					switch (alt146) {
						case 1 :
							// PhoenixSQL.g:890:38: ( AS )? alias= identifier
							{
							// PhoenixSQL.g:890:38: ( AS )?
							int alt145=2;
							int LA145_0 = input.LA(1);
							if ( (LA145_0==AS) ) {
								alt145=1;
							}
							switch (alt145) {
								case 1 :
									// PhoenixSQL.g:890:39: AS
									{
									match(input,AS,FOLLOW_AS_in_table_factor6015); if (state.failed) return ret;
									}
									break;

							}

							pushFollow(FOLLOW_identifier_in_table_factor6021);
							alias=identifier();
							state._fsp--;
							if (state.failed) return ret;
							}
							break;

					}

					if ( state.backtracking==0 ) { ret = factory.derivedTable(alias, s); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "table_factor"



	// $ANTLR start "join_type"
	// PhoenixSQL.g:893:1: join_type returns [JoinTableNode.JoinType ret] : ( ( INNER )? | LEFT ( OUTER )? | RIGHT ( OUTER )? | FULL ( OUTER )? );
	public final JoinTableNode.JoinType join_type() throws RecognitionException {
		JoinTableNode.JoinType ret = null;


		try {
			// PhoenixSQL.g:894:5: ( ( INNER )? | LEFT ( OUTER )? | RIGHT ( OUTER )? | FULL ( OUTER )? )
			int alt152=4;
			switch ( input.LA(1) ) {
			case INNER:
			case JOIN:
				{
				alt152=1;
				}
				break;
			case LEFT:
				{
				alt152=2;
				}
				break;
			case RIGHT:
				{
				alt152=3;
				}
				break;
			case FULL:
				{
				alt152=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 152, 0, input);
				throw nvae;
			}
			switch (alt152) {
				case 1 :
					// PhoenixSQL.g:894:9: ( INNER )?
					{
					// PhoenixSQL.g:894:9: ( INNER )?
					int alt148=2;
					int LA148_0 = input.LA(1);
					if ( (LA148_0==INNER) ) {
						alt148=1;
					}
					switch (alt148) {
						case 1 :
							// PhoenixSQL.g:894:9: INNER
							{
							match(input,INNER,FOLLOW_INNER_in_join_type6048); if (state.failed) return ret;
							}
							break;

					}

					if ( state.backtracking==0 ) { ret = JoinTableNode.JoinType.Inner; }
					}
					break;
				case 2 :
					// PhoenixSQL.g:895:9: LEFT ( OUTER )?
					{
					match(input,LEFT,FOLLOW_LEFT_in_join_type6063); if (state.failed) return ret;
					// PhoenixSQL.g:895:14: ( OUTER )?
					int alt149=2;
					int LA149_0 = input.LA(1);
					if ( (LA149_0==OUTER) ) {
						alt149=1;
					}
					switch (alt149) {
						case 1 :
							// PhoenixSQL.g:895:14: OUTER
							{
							match(input,OUTER,FOLLOW_OUTER_in_join_type6065); if (state.failed) return ret;
							}
							break;

					}

					if ( state.backtracking==0 ) { ret = JoinTableNode.JoinType.Left; }
					}
					break;
				case 3 :
					// PhoenixSQL.g:896:9: RIGHT ( OUTER )?
					{
					match(input,RIGHT,FOLLOW_RIGHT_in_join_type6080); if (state.failed) return ret;
					// PhoenixSQL.g:896:15: ( OUTER )?
					int alt150=2;
					int LA150_0 = input.LA(1);
					if ( (LA150_0==OUTER) ) {
						alt150=1;
					}
					switch (alt150) {
						case 1 :
							// PhoenixSQL.g:896:15: OUTER
							{
							match(input,OUTER,FOLLOW_OUTER_in_join_type6082); if (state.failed) return ret;
							}
							break;

					}

					if ( state.backtracking==0 ) { ret = JoinTableNode.JoinType.Right; }
					}
					break;
				case 4 :
					// PhoenixSQL.g:897:9: FULL ( OUTER )?
					{
					match(input,FULL,FOLLOW_FULL_in_join_type6096); if (state.failed) return ret;
					// PhoenixSQL.g:897:15: ( OUTER )?
					int alt151=2;
					int LA151_0 = input.LA(1);
					if ( (LA151_0==OUTER) ) {
						alt151=1;
					}
					switch (alt151) {
						case 1 :
							// PhoenixSQL.g:897:15: OUTER
							{
							match(input,OUTER,FOLLOW_OUTER_in_join_type6099); if (state.failed) return ret;
							}
							break;

					}

					if ( state.backtracking==0 ) { ret = JoinTableNode.JoinType.Full; }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "join_type"



	// $ANTLR start "parseAlias"
	// PhoenixSQL.g:900:1: parseAlias returns [String ret] : ( AS )? alias= parseNoReserved ;
	public final String parseAlias() throws RecognitionException {
		String ret = null;


		String alias =null;

		try {
			// PhoenixSQL.g:901:5: ( ( AS )? alias= parseNoReserved )
			// PhoenixSQL.g:901:9: ( AS )? alias= parseNoReserved
			{
			// PhoenixSQL.g:901:9: ( AS )?
			int alt153=2;
			int LA153_0 = input.LA(1);
			if ( (LA153_0==AS) ) {
				alt153=1;
			}
			switch (alt153) {
				case 1 :
					// PhoenixSQL.g:901:9: AS
					{
					match(input,AS,FOLLOW_AS_in_parseAlias6130); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_parseNoReserved_in_parseAlias6135);
			alias=parseNoReserved();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = alias; }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "parseAlias"



	// $ANTLR start "expression"
	// PhoenixSQL.g:905:1: expression returns [ParseNode ret] : e= or_expression ;
	public final ParseNode expression() throws RecognitionException {
		ParseNode ret = null;


		ParseNode e =null;

		try {
			// PhoenixSQL.g:906:5: (e= or_expression )
			// PhoenixSQL.g:906:9: e= or_expression
			{
			pushFollow(FOLLOW_or_expression_in_expression6163);
			e=or_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = e; }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "expression"



	// $ANTLR start "or_expression"
	// PhoenixSQL.g:910:1: or_expression returns [ParseNode ret] : i= and_expression ( OR i= and_expression )* ;
	public final ParseNode or_expression() throws RecognitionException {
		ParseNode ret = null;


		ParseNode i =null;

		List<ParseNode> l = new ArrayList<ParseNode>(4); 
		try {
			// PhoenixSQL.g:912:5: (i= and_expression ( OR i= and_expression )* )
			// PhoenixSQL.g:912:9: i= and_expression ( OR i= and_expression )*
			{
			pushFollow(FOLLOW_and_expression_in_or_expression6195);
			i=and_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {l.add(i);}
			// PhoenixSQL.g:912:38: ( OR i= and_expression )*
			loop154:
			while (true) {
				int alt154=2;
				int LA154_0 = input.LA(1);
				if ( (LA154_0==OR) ) {
					alt154=1;
				}

				switch (alt154) {
				case 1 :
					// PhoenixSQL.g:912:39: OR i= and_expression
					{
					match(input,OR,FOLLOW_OR_in_or_expression6200); if (state.failed) return ret;
					pushFollow(FOLLOW_and_expression_in_or_expression6204);
					i=and_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {l.add(i);}
					}
					break;

				default :
					break loop154;
				}
			}

			if ( state.backtracking==0 ) { ret = l.size() == 1 ? l.get(0) : factory.or(l); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "or_expression"



	// $ANTLR start "and_expression"
	// PhoenixSQL.g:916:1: and_expression returns [ParseNode ret] : i= not_expression ( AND i= not_expression )* ;
	public final ParseNode and_expression() throws RecognitionException {
		ParseNode ret = null;


		ParseNode i =null;

		List<ParseNode> l = new ArrayList<ParseNode>(4); 
		try {
			// PhoenixSQL.g:918:5: (i= not_expression ( AND i= not_expression )* )
			// PhoenixSQL.g:918:9: i= not_expression ( AND i= not_expression )*
			{
			pushFollow(FOLLOW_not_expression_in_and_expression6240);
			i=not_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {l.add(i);}
			// PhoenixSQL.g:918:38: ( AND i= not_expression )*
			loop155:
			while (true) {
				int alt155=2;
				int LA155_0 = input.LA(1);
				if ( (LA155_0==AND) ) {
					alt155=1;
				}

				switch (alt155) {
				case 1 :
					// PhoenixSQL.g:918:39: AND i= not_expression
					{
					match(input,AND,FOLLOW_AND_in_and_expression6245); if (state.failed) return ret;
					pushFollow(FOLLOW_not_expression_in_and_expression6249);
					i=not_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {l.add(i);}
					}
					break;

				default :
					break loop155;
				}
			}

			if ( state.backtracking==0 ) { ret = l.size() == 1 ? l.get(0) : factory.and(l); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "and_expression"



	// $ANTLR start "not_expression"
	// PhoenixSQL.g:922:1: not_expression returns [ParseNode ret] : ( ( ( NOT )? boolean_expression )=> (n= NOT )? e= boolean_expression | (n= NOT )? LPAREN e= expression RPAREN );
	public final ParseNode not_expression() throws RecognitionException {
		ParseNode ret = null;


		Token n=null;
		ParseNode e =null;

		try {
			// PhoenixSQL.g:923:5: ( ( ( NOT )? boolean_expression )=> (n= NOT )? e= boolean_expression | (n= NOT )? LPAREN e= expression RPAREN )
			int alt158=2;
			int LA158_0 = input.LA(1);
			if ( (LA158_0==NOT) ) {
				int LA158_1 = input.LA(2);
				if ( (synpred1_PhoenixSQL()) ) {
					alt158=1;
				}
				else if ( (true) ) {
					alt158=2;
				}

			}
			else if ( (LA158_0==MINUS) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==STRING_LITERAL) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==NUMBER) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==DECIMAL) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==DOUBLE) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==NULL) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==TRUE) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==FALSE) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==NAME) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==BIND_NAME) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==QUESTION) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==ARRAY) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==CASE) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==LPAREN) ) {
				int LA158_15 = input.LA(2);
				if ( (synpred1_PhoenixSQL()) ) {
					alt158=1;
				}
				else if ( (true) ) {
					alt158=2;
				}

			}
			else if ( (LA158_0==CAST) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==NEXT) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==CURRENT) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}
			else if ( (LA158_0==EXISTS) && (synpred1_PhoenixSQL())) {
				alt158=1;
			}

			switch (alt158) {
				case 1 :
					// PhoenixSQL.g:923:9: ( ( NOT )? boolean_expression )=> (n= NOT )? e= boolean_expression
					{
					// PhoenixSQL.g:923:40: (n= NOT )?
					int alt156=2;
					int LA156_0 = input.LA(1);
					if ( (LA156_0==NOT) ) {
						alt156=1;
					}
					switch (alt156) {
						case 1 :
							// PhoenixSQL.g:923:40: n= NOT
							{
							n=(Token)match(input,NOT,FOLLOW_NOT_in_not_expression6291); if (state.failed) return ret;
							}
							break;

					}

					pushFollow(FOLLOW_boolean_expression_in_not_expression6296);
					e=boolean_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = n == null ? e : factory.not(e); }
					}
					break;
				case 2 :
					// PhoenixSQL.g:924:9: (n= NOT )? LPAREN e= expression RPAREN
					{
					// PhoenixSQL.g:924:10: (n= NOT )?
					int alt157=2;
					int LA157_0 = input.LA(1);
					if ( (LA157_0==NOT) ) {
						alt157=1;
					}
					switch (alt157) {
						case 1 :
							// PhoenixSQL.g:924:10: n= NOT
							{
							n=(Token)match(input,NOT,FOLLOW_NOT_in_not_expression6310); if (state.failed) return ret;
							}
							break;

					}

					match(input,LPAREN,FOLLOW_LPAREN_in_not_expression6313); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_not_expression6317);
					e=expression();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_not_expression6319); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = n == null ? e : factory.not(e); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "not_expression"



	// $ANTLR start "comparison_op"
	// PhoenixSQL.g:927:1: comparison_op returns [CompareOp ret] : ( EQ | LT | GT | LT EQ | GT EQ | ( NOEQ1 | NOEQ2 ) );
	public final CompareOp comparison_op() throws RecognitionException {
		CompareOp ret = null;


		try {
			// PhoenixSQL.g:928:2: ( EQ | LT | GT | LT EQ | GT EQ | ( NOEQ1 | NOEQ2 ) )
			int alt159=6;
			switch ( input.LA(1) ) {
			case EQ:
				{
				alt159=1;
				}
				break;
			case LT:
				{
				int LA159_2 = input.LA(2);
				if ( (LA159_2==EQ) ) {
					alt159=4;
				}
				else if ( (LA159_2==ALL||(LA159_2 >= ANY && LA159_2 <= ARRAY)||LA159_2==BIND_NAME||(LA159_2 >= CASE && LA159_2 <= CAST)||LA159_2==CURRENT||LA159_2==DECIMAL||LA159_2==DOUBLE||LA159_2==FALSE||LA159_2==LPAREN||LA159_2==MINUS||(LA159_2 >= NAME && LA159_2 <= NEXT)||LA159_2==NULL||LA159_2==NUMBER||LA159_2==QUESTION||LA159_2==STRING_LITERAL||LA159_2==TRUE) ) {
					alt159=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 159, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case GT:
				{
				int LA159_3 = input.LA(2);
				if ( (LA159_3==EQ) ) {
					alt159=5;
				}
				else if ( (LA159_3==ALL||(LA159_3 >= ANY && LA159_3 <= ARRAY)||LA159_3==BIND_NAME||(LA159_3 >= CASE && LA159_3 <= CAST)||LA159_3==CURRENT||LA159_3==DECIMAL||LA159_3==DOUBLE||LA159_3==FALSE||LA159_3==LPAREN||LA159_3==MINUS||(LA159_3 >= NAME && LA159_3 <= NEXT)||LA159_3==NULL||LA159_3==NUMBER||LA159_3==QUESTION||LA159_3==STRING_LITERAL||LA159_3==TRUE) ) {
					alt159=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 159, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case NOEQ1:
			case NOEQ2:
				{
				alt159=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 159, 0, input);
				throw nvae;
			}
			switch (alt159) {
				case 1 :
					// PhoenixSQL.g:928:4: EQ
					{
					match(input,EQ,FOLLOW_EQ_in_comparison_op6339); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = CompareOp.EQUAL; }
					}
					break;
				case 2 :
					// PhoenixSQL.g:929:4: LT
					{
					match(input,LT,FOLLOW_LT_in_comparison_op6346); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = CompareOp.LESS; }
					}
					break;
				case 3 :
					// PhoenixSQL.g:930:4: GT
					{
					match(input,GT,FOLLOW_GT_in_comparison_op6353); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = CompareOp.GREATER; }
					}
					break;
				case 4 :
					// PhoenixSQL.g:931:4: LT EQ
					{
					match(input,LT,FOLLOW_LT_in_comparison_op6360); if (state.failed) return ret;
					match(input,EQ,FOLLOW_EQ_in_comparison_op6362); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = CompareOp.LESS_OR_EQUAL; }
					}
					break;
				case 5 :
					// PhoenixSQL.g:932:4: GT EQ
					{
					match(input,GT,FOLLOW_GT_in_comparison_op6369); if (state.failed) return ret;
					match(input,EQ,FOLLOW_EQ_in_comparison_op6371); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = CompareOp.GREATER_OR_EQUAL; }
					}
					break;
				case 6 :
					// PhoenixSQL.g:933:4: ( NOEQ1 | NOEQ2 )
					{
					if ( (input.LA(1) >= NOEQ1 && input.LA(1) <= NOEQ2) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					if ( state.backtracking==0 ) { ret = CompareOp.NOT_EQUAL; }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "comparison_op"



	// $ANTLR start "boolean_expression"
	// PhoenixSQL.g:936:1: boolean_expression returns [ParseNode ret] : (l= value_expression ( (op= comparison_op (r= value_expression | ( LPAREN r= subquery_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN ) ) ) | ( IS (n= NOT )? NULL ) | ( (n= NOT )? ( ( LIKE r= value_expression ) | ( ILIKE r= value_expression ) | ( BETWEEN r1= value_expression AND r2= value_expression ) | ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) ) ) ) |) | EXISTS LPAREN s= subquery_expression RPAREN );
	public final ParseNode boolean_expression() throws RecognitionException {
		ParseNode ret = null;


		Token all=null;
		Token any=null;
		Token n=null;
		ParseNode l =null;
		CompareOp op =null;
		ParseNode r =null;
		ParseNode r1 =null;
		ParseNode r2 =null;
		List<ParseNode> v =null;
		ParseNode s =null;

		try {
			// PhoenixSQL.g:937:5: (l= value_expression ( (op= comparison_op (r= value_expression | ( LPAREN r= subquery_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN ) ) ) | ( IS (n= NOT )? NULL ) | ( (n= NOT )? ( ( LIKE r= value_expression ) | ( ILIKE r= value_expression ) | ( BETWEEN r1= value_expression AND r2= value_expression ) | ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) ) ) ) |) | EXISTS LPAREN s= subquery_expression RPAREN )
			int alt168=2;
			int LA168_0 = input.LA(1);
			if ( (LA168_0==ARRAY||LA168_0==BIND_NAME||(LA168_0 >= CASE && LA168_0 <= CAST)||LA168_0==CURRENT||LA168_0==DECIMAL||LA168_0==DOUBLE||LA168_0==FALSE||LA168_0==LPAREN||LA168_0==MINUS||(LA168_0 >= NAME && LA168_0 <= NEXT)||LA168_0==NULL||LA168_0==NUMBER||LA168_0==QUESTION||LA168_0==STRING_LITERAL||LA168_0==TRUE) ) {
				alt168=1;
			}
			else if ( (LA168_0==EXISTS) ) {
				alt168=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 168, 0, input);
				throw nvae;
			}

			switch (alt168) {
				case 1 :
					// PhoenixSQL.g:937:9: l= value_expression ( (op= comparison_op (r= value_expression | ( LPAREN r= subquery_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN ) ) ) | ( IS (n= NOT )? NULL ) | ( (n= NOT )? ( ( LIKE r= value_expression ) | ( ILIKE r= value_expression ) | ( BETWEEN r1= value_expression AND r2= value_expression ) | ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) ) ) ) |)
					{
					pushFollow(FOLLOW_value_expression_in_boolean_expression6409);
					l=value_expression();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:937:28: ( (op= comparison_op (r= value_expression | ( LPAREN r= subquery_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN ) ) ) | ( IS (n= NOT )? NULL ) | ( (n= NOT )? ( ( LIKE r= value_expression ) | ( ILIKE r= value_expression ) | ( BETWEEN r1= value_expression AND r2= value_expression ) | ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) ) ) ) |)
					int alt167=4;
					switch ( input.LA(1) ) {
					case EQ:
					case GT:
					case LT:
					case NOEQ1:
					case NOEQ2:
						{
						alt167=1;
						}
						break;
					case IS:
						{
						alt167=2;
						}
						break;
					case BETWEEN:
					case ILIKE:
					case IN:
					case LIKE:
					case NOT:
						{
						alt167=3;
						}
						break;
					case EOF:
					case AND:
					case AS:
					case ASC:
					case COMMA:
					case CONSTRAINT:
					case DESC:
					case ELSE:
					case END:
					case FETCH:
					case FROM:
					case FULL:
					case GROUP:
					case HAVING:
					case INNER:
					case JOIN:
					case LEFT:
					case LIMIT:
					case MAXVALUE:
					case MINVALUE:
					case NAME:
					case NULLS:
					case OFFSET:
					case OR:
					case ORDER:
					case PRIMARY:
					case RIGHT:
					case RPAREN:
					case RSQUARE:
					case SEMICOLON:
					case THEN:
					case UNION:
					case WHEN:
					case WHERE:
						{
						alt167=4;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return ret;}
						NoViableAltException nvae =
							new NoViableAltException("", 167, 0, input);
						throw nvae;
					}
					switch (alt167) {
						case 1 :
							// PhoenixSQL.g:937:29: (op= comparison_op (r= value_expression | ( LPAREN r= subquery_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN ) ) )
							{
							// PhoenixSQL.g:937:29: (op= comparison_op (r= value_expression | ( LPAREN r= subquery_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN ) ) )
							// PhoenixSQL.g:937:30: op= comparison_op (r= value_expression | ( LPAREN r= subquery_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN ) )
							{
							pushFollow(FOLLOW_comparison_op_in_boolean_expression6415);
							op=comparison_op();
							state._fsp--;
							if (state.failed) return ret;
							// PhoenixSQL.g:937:47: (r= value_expression | ( LPAREN r= subquery_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN ) | ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN ) )
							int alt162=4;
							switch ( input.LA(1) ) {
							case ARRAY:
							case BIND_NAME:
							case CASE:
							case CAST:
							case CURRENT:
							case DECIMAL:
							case DOUBLE:
							case FALSE:
							case MINUS:
							case NAME:
							case NEXT:
							case NULL:
							case NUMBER:
							case QUESTION:
							case STRING_LITERAL:
							case TRUE:
								{
								alt162=1;
								}
								break;
							case LPAREN:
								{
								int LA162_2 = input.LA(2);
								if ( (LA162_2==ARRAY||LA162_2==BIND_NAME||(LA162_2 >= CASE && LA162_2 <= CAST)||LA162_2==CURRENT||LA162_2==DECIMAL||LA162_2==DOUBLE||LA162_2==EXISTS||LA162_2==FALSE||LA162_2==LPAREN||LA162_2==MINUS||(LA162_2 >= NAME && LA162_2 <= NEXT)||(LA162_2 >= NOT && LA162_2 <= NULL)||LA162_2==NUMBER||LA162_2==QUESTION||LA162_2==STRING_LITERAL||LA162_2==TRUE) ) {
									alt162=1;
								}
								else if ( (LA162_2==SELECT) ) {
									alt162=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return ret;}
									int nvaeMark = input.mark();
									try {
										input.consume();
										NoViableAltException nvae =
											new NoViableAltException("", 162, 2, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case ALL:
								{
								int LA162_3 = input.LA(2);
								if ( (LA162_3==LPAREN) ) {
									int LA162_6 = input.LA(3);
									if ( (LA162_6==ARRAY||LA162_6==BIND_NAME||(LA162_6 >= CASE && LA162_6 <= CAST)||LA162_6==CURRENT||LA162_6==DECIMAL||LA162_6==DOUBLE||LA162_6==FALSE||LA162_6==LPAREN||LA162_6==MINUS||(LA162_6 >= NAME && LA162_6 <= NEXT)||LA162_6==NULL||LA162_6==NUMBER||LA162_6==QUESTION||LA162_6==STRING_LITERAL||LA162_6==TRUE) ) {
										alt162=3;
									}
									else if ( (LA162_6==SELECT) ) {
										alt162=4;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return ret;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 162, 6, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return ret;}
									int nvaeMark = input.mark();
									try {
										input.consume();
										NoViableAltException nvae =
											new NoViableAltException("", 162, 3, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case ANY:
								{
								int LA162_4 = input.LA(2);
								if ( (LA162_4==LPAREN) ) {
									int LA162_6 = input.LA(3);
									if ( (LA162_6==ARRAY||LA162_6==BIND_NAME||(LA162_6 >= CASE && LA162_6 <= CAST)||LA162_6==CURRENT||LA162_6==DECIMAL||LA162_6==DOUBLE||LA162_6==FALSE||LA162_6==LPAREN||LA162_6==MINUS||(LA162_6 >= NAME && LA162_6 <= NEXT)||LA162_6==NULL||LA162_6==NUMBER||LA162_6==QUESTION||LA162_6==STRING_LITERAL||LA162_6==TRUE) ) {
										alt162=3;
									}
									else if ( (LA162_6==SELECT) ) {
										alt162=4;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return ret;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 162, 6, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return ret;}
									int nvaeMark = input.mark();
									try {
										input.consume();
										NoViableAltException nvae =
											new NoViableAltException("", 162, 4, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return ret;}
								NoViableAltException nvae =
									new NoViableAltException("", 162, 0, input);
								throw nvae;
							}
							switch (alt162) {
								case 1 :
									// PhoenixSQL.g:937:48: r= value_expression
									{
									pushFollow(FOLLOW_value_expression_in_boolean_expression6420);
									r=value_expression();
									state._fsp--;
									if (state.failed) return ret;
									}
									break;
								case 2 :
									// PhoenixSQL.g:937:69: ( LPAREN r= subquery_expression RPAREN )
									{
									// PhoenixSQL.g:937:69: ( LPAREN r= subquery_expression RPAREN )
									// PhoenixSQL.g:937:70: LPAREN r= subquery_expression RPAREN
									{
									match(input,LPAREN,FOLLOW_LPAREN_in_boolean_expression6425); if (state.failed) return ret;
									pushFollow(FOLLOW_subquery_expression_in_boolean_expression6429);
									r=subquery_expression();
									state._fsp--;
									if (state.failed) return ret;
									match(input,RPAREN,FOLLOW_RPAREN_in_boolean_expression6431); if (state.failed) return ret;
									}

									}
									break;
								case 3 :
									// PhoenixSQL.g:937:109: ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN )
									{
									// PhoenixSQL.g:937:109: ( (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN )
									// PhoenixSQL.g:937:110: (all= ALL |any= ANY ) LPAREN r= value_expression RPAREN
									{
									// PhoenixSQL.g:937:110: (all= ALL |any= ANY )
									int alt160=2;
									int LA160_0 = input.LA(1);
									if ( (LA160_0==ALL) ) {
										alt160=1;
									}
									else if ( (LA160_0==ANY) ) {
										alt160=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return ret;}
										NoViableAltException nvae =
											new NoViableAltException("", 160, 0, input);
										throw nvae;
									}

									switch (alt160) {
										case 1 :
											// PhoenixSQL.g:937:111: all= ALL
											{
											all=(Token)match(input,ALL,FOLLOW_ALL_in_boolean_expression6440); if (state.failed) return ret;
											}
											break;
										case 2 :
											// PhoenixSQL.g:937:121: any= ANY
											{
											any=(Token)match(input,ANY,FOLLOW_ANY_in_boolean_expression6446); if (state.failed) return ret;
											}
											break;

									}

									match(input,LPAREN,FOLLOW_LPAREN_in_boolean_expression6449); if (state.failed) return ret;
									pushFollow(FOLLOW_value_expression_in_boolean_expression6453);
									r=value_expression();
									state._fsp--;
									if (state.failed) return ret;
									match(input,RPAREN,FOLLOW_RPAREN_in_boolean_expression6455); if (state.failed) return ret;
									}

									}
									break;
								case 4 :
									// PhoenixSQL.g:937:167: ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN )
									{
									// PhoenixSQL.g:937:167: ( (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN )
									// PhoenixSQL.g:937:168: (all= ALL |any= ANY ) LPAREN r= subquery_expression RPAREN
									{
									// PhoenixSQL.g:937:168: (all= ALL |any= ANY )
									int alt161=2;
									int LA161_0 = input.LA(1);
									if ( (LA161_0==ALL) ) {
										alt161=1;
									}
									else if ( (LA161_0==ANY) ) {
										alt161=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return ret;}
										NoViableAltException nvae =
											new NoViableAltException("", 161, 0, input);
										throw nvae;
									}

									switch (alt161) {
										case 1 :
											// PhoenixSQL.g:937:169: all= ALL
											{
											all=(Token)match(input,ALL,FOLLOW_ALL_in_boolean_expression6465); if (state.failed) return ret;
											}
											break;
										case 2 :
											// PhoenixSQL.g:937:179: any= ANY
											{
											any=(Token)match(input,ANY,FOLLOW_ANY_in_boolean_expression6471); if (state.failed) return ret;
											}
											break;

									}

									match(input,LPAREN,FOLLOW_LPAREN_in_boolean_expression6474); if (state.failed) return ret;
									pushFollow(FOLLOW_subquery_expression_in_boolean_expression6478);
									r=subquery_expression();
									state._fsp--;
									if (state.failed) return ret;
									match(input,RPAREN,FOLLOW_RPAREN_in_boolean_expression6480); if (state.failed) return ret;
									}

									}
									break;

							}

							if ( state.backtracking==0 ) {ret = all != null ? factory.wrapInAll(op, l, r) : any != null ? factory.wrapInAny(op, l, r) : factory.comparison(op,l,r); }
							}

							}
							break;
						case 2 :
							// PhoenixSQL.g:938:22: ( IS (n= NOT )? NULL )
							{
							// PhoenixSQL.g:938:22: ( IS (n= NOT )? NULL )
							// PhoenixSQL.g:938:23: IS (n= NOT )? NULL
							{
							match(input,IS,FOLLOW_IS_in_boolean_expression6510); if (state.failed) return ret;
							// PhoenixSQL.g:938:27: (n= NOT )?
							int alt163=2;
							int LA163_0 = input.LA(1);
							if ( (LA163_0==NOT) ) {
								alt163=1;
							}
							switch (alt163) {
								case 1 :
									// PhoenixSQL.g:938:27: n= NOT
									{
									n=(Token)match(input,NOT,FOLLOW_NOT_in_boolean_expression6514); if (state.failed) return ret;
									}
									break;

							}

							match(input,NULL,FOLLOW_NULL_in_boolean_expression6517); if (state.failed) return ret;
							if ( state.backtracking==0 ) {ret = factory.isNull(l,n!=null); }
							}

							}
							break;
						case 3 :
							// PhoenixSQL.g:939:22: ( (n= NOT )? ( ( LIKE r= value_expression ) | ( ILIKE r= value_expression ) | ( BETWEEN r1= value_expression AND r2= value_expression ) | ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) ) ) )
							{
							// PhoenixSQL.g:939:22: ( (n= NOT )? ( ( LIKE r= value_expression ) | ( ILIKE r= value_expression ) | ( BETWEEN r1= value_expression AND r2= value_expression ) | ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) ) ) )
							// PhoenixSQL.g:939:24: (n= NOT )? ( ( LIKE r= value_expression ) | ( ILIKE r= value_expression ) | ( BETWEEN r1= value_expression AND r2= value_expression ) | ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) ) )
							{
							// PhoenixSQL.g:939:25: (n= NOT )?
							int alt164=2;
							int LA164_0 = input.LA(1);
							if ( (LA164_0==NOT) ) {
								alt164=1;
							}
							switch (alt164) {
								case 1 :
									// PhoenixSQL.g:939:25: n= NOT
									{
									n=(Token)match(input,NOT,FOLLOW_NOT_in_boolean_expression6548); if (state.failed) return ret;
									}
									break;

							}

							// PhoenixSQL.g:939:31: ( ( LIKE r= value_expression ) | ( ILIKE r= value_expression ) | ( BETWEEN r1= value_expression AND r2= value_expression ) | ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) ) )
							int alt166=4;
							switch ( input.LA(1) ) {
							case LIKE:
								{
								alt166=1;
								}
								break;
							case ILIKE:
								{
								alt166=2;
								}
								break;
							case BETWEEN:
								{
								alt166=3;
								}
								break;
							case IN:
								{
								alt166=4;
								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return ret;}
								NoViableAltException nvae =
									new NoViableAltException("", 166, 0, input);
								throw nvae;
							}
							switch (alt166) {
								case 1 :
									// PhoenixSQL.g:939:32: ( LIKE r= value_expression )
									{
									// PhoenixSQL.g:939:32: ( LIKE r= value_expression )
									// PhoenixSQL.g:939:33: LIKE r= value_expression
									{
									match(input,LIKE,FOLLOW_LIKE_in_boolean_expression6553); if (state.failed) return ret;
									pushFollow(FOLLOW_value_expression_in_boolean_expression6557);
									r=value_expression();
									state._fsp--;
									if (state.failed) return ret;
									if ( state.backtracking==0 ) {ret = factory.like(l,r,n!=null,LikeType.CASE_SENSITIVE); }
									}

									}
									break;
								case 2 :
									// PhoenixSQL.g:940:32: ( ILIKE r= value_expression )
									{
									// PhoenixSQL.g:940:32: ( ILIKE r= value_expression )
									// PhoenixSQL.g:940:33: ILIKE r= value_expression
									{
									match(input,ILIKE,FOLLOW_ILIKE_in_boolean_expression6595); if (state.failed) return ret;
									pushFollow(FOLLOW_value_expression_in_boolean_expression6599);
									r=value_expression();
									state._fsp--;
									if (state.failed) return ret;
									if ( state.backtracking==0 ) {ret = factory.like(l,r,n!=null,LikeType.CASE_INSENSITIVE); }
									}

									}
									break;
								case 3 :
									// PhoenixSQL.g:941:32: ( BETWEEN r1= value_expression AND r2= value_expression )
									{
									// PhoenixSQL.g:941:32: ( BETWEEN r1= value_expression AND r2= value_expression )
									// PhoenixSQL.g:941:33: BETWEEN r1= value_expression AND r2= value_expression
									{
									match(input,BETWEEN,FOLLOW_BETWEEN_in_boolean_expression6637); if (state.failed) return ret;
									pushFollow(FOLLOW_value_expression_in_boolean_expression6641);
									r1=value_expression();
									state._fsp--;
									if (state.failed) return ret;
									match(input,AND,FOLLOW_AND_in_boolean_expression6643); if (state.failed) return ret;
									pushFollow(FOLLOW_value_expression_in_boolean_expression6647);
									r2=value_expression();
									state._fsp--;
									if (state.failed) return ret;
									if ( state.backtracking==0 ) {ret = factory.between(l,r1,r2,n!=null); }
									}

									}
									break;
								case 4 :
									// PhoenixSQL.g:942:32: ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) )
									{
									// PhoenixSQL.g:942:32: ( ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) ) )
									// PhoenixSQL.g:942:33: ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) )
									{
									// PhoenixSQL.g:942:33: ( IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) ) )
									// PhoenixSQL.g:942:34: IN ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) )
									{
									match(input,IN,FOLLOW_IN_in_boolean_expression6686); if (state.failed) return ret;
									// PhoenixSQL.g:942:37: ( (r= bind_expression ) | ( LPAREN r= subquery_expression RPAREN ) | ( LPAREN v= one_or_more_expressions RPAREN ) )
									int alt165=3;
									int LA165_0 = input.LA(1);
									if ( (LA165_0==BIND_NAME||LA165_0==QUESTION) ) {
										alt165=1;
									}
									else if ( (LA165_0==LPAREN) ) {
										int LA165_2 = input.LA(2);
										if ( (LA165_2==SELECT) ) {
											alt165=2;
										}
										else if ( (LA165_2==ARRAY||LA165_2==BIND_NAME||(LA165_2 >= CASE && LA165_2 <= CAST)||LA165_2==CURRENT||LA165_2==DECIMAL||LA165_2==DOUBLE||LA165_2==EXISTS||LA165_2==FALSE||LA165_2==LPAREN||LA165_2==MINUS||(LA165_2 >= NAME && LA165_2 <= NEXT)||(LA165_2 >= NOT && LA165_2 <= NULL)||LA165_2==NUMBER||LA165_2==QUESTION||LA165_2==STRING_LITERAL||LA165_2==TRUE) ) {
											alt165=3;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return ret;}
											int nvaeMark = input.mark();
											try {
												input.consume();
												NoViableAltException nvae =
													new NoViableAltException("", 165, 2, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return ret;}
										NoViableAltException nvae =
											new NoViableAltException("", 165, 0, input);
										throw nvae;
									}

									switch (alt165) {
										case 1 :
											// PhoenixSQL.g:942:38: (r= bind_expression )
											{
											// PhoenixSQL.g:942:38: (r= bind_expression )
											// PhoenixSQL.g:942:39: r= bind_expression
											{
											pushFollow(FOLLOW_bind_expression_in_boolean_expression6692);
											r=bind_expression();
											state._fsp--;
											if (state.failed) return ret;
											if ( state.backtracking==0 ) {ret = factory.inList(Arrays.asList(l,r),n!=null);}
											}

											}
											break;
										case 2 :
											// PhoenixSQL.g:943:35: ( LPAREN r= subquery_expression RPAREN )
											{
											// PhoenixSQL.g:943:35: ( LPAREN r= subquery_expression RPAREN )
											// PhoenixSQL.g:943:36: LPAREN r= subquery_expression RPAREN
											{
											match(input,LPAREN,FOLLOW_LPAREN_in_boolean_expression6733); if (state.failed) return ret;
											pushFollow(FOLLOW_subquery_expression_in_boolean_expression6737);
											r=subquery_expression();
											state._fsp--;
											if (state.failed) return ret;
											match(input,RPAREN,FOLLOW_RPAREN_in_boolean_expression6739); if (state.failed) return ret;
											if ( state.backtracking==0 ) {ret = factory.in(l,r,n!=null,false);}
											}

											}
											break;
										case 3 :
											// PhoenixSQL.g:944:35: ( LPAREN v= one_or_more_expressions RPAREN )
											{
											// PhoenixSQL.g:944:35: ( LPAREN v= one_or_more_expressions RPAREN )
											// PhoenixSQL.g:944:36: LPAREN v= one_or_more_expressions RPAREN
											{
											match(input,LPAREN,FOLLOW_LPAREN_in_boolean_expression6780); if (state.failed) return ret;
											pushFollow(FOLLOW_one_or_more_expressions_in_boolean_expression6784);
											v=one_or_more_expressions();
											state._fsp--;
											if (state.failed) return ret;
											match(input,RPAREN,FOLLOW_RPAREN_in_boolean_expression6786); if (state.failed) return ret;
											if ( state.backtracking==0 ) {List<ParseNode> il = new ArrayList<ParseNode>(v.size() + 1); il.add(l); il.addAll(v); ret = factory.inList(il,n!=null);}
											}

											}
											break;

									}

									}

									}

									}
									break;

							}

							}

							}
							break;
						case 4 :
							// PhoenixSQL.g:947:23: 
							{
							if ( state.backtracking==0 ) { ret = l; }
							}
							break;

					}

					}
					break;
				case 2 :
					// PhoenixSQL.g:948:9: EXISTS LPAREN s= subquery_expression RPAREN
					{
					match(input,EXISTS,FOLLOW_EXISTS_in_boolean_expression6886); if (state.failed) return ret;
					match(input,LPAREN,FOLLOW_LPAREN_in_boolean_expression6888); if (state.failed) return ret;
					pushFollow(FOLLOW_subquery_expression_in_boolean_expression6892);
					s=subquery_expression();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_boolean_expression6894); if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.exists(s,false);}
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "boolean_expression"



	// $ANTLR start "bind_expression"
	// PhoenixSQL.g:951:1: bind_expression returns [BindParseNode ret] : b= bind_name ;
	public final BindParseNode bind_expression() throws RecognitionException {
		BindParseNode ret = null;


		String b =null;

		try {
			// PhoenixSQL.g:952:5: (b= bind_name )
			// PhoenixSQL.g:952:9: b= bind_name
			{
			pushFollow(FOLLOW_bind_name_in_bind_expression6922);
			b=bind_name();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = factory.bind(b); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "bind_expression"



	// $ANTLR start "value_expression"
	// PhoenixSQL.g:955:1: value_expression returns [ParseNode ret] : i= add_expression ;
	public final ParseNode value_expression() throws RecognitionException {
		ParseNode ret = null;


		ParseNode i =null;

		try {
			// PhoenixSQL.g:956:5: (i= add_expression )
			// PhoenixSQL.g:956:9: i= add_expression
			{
			pushFollow(FOLLOW_add_expression_in_value_expression6953);
			i=add_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = i; }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "value_expression"



	// $ANTLR start "add_expression"
	// PhoenixSQL.g:959:1: add_expression returns [ParseNode ret] : i= subtract_expression ( PLUS i= subtract_expression )* ;
	public final ParseNode add_expression() throws RecognitionException {
		ParseNode ret = null;


		ParseNode i =null;

		List<ParseNode> l = new ArrayList<ParseNode>(4); 
		try {
			// PhoenixSQL.g:961:5: (i= subtract_expression ( PLUS i= subtract_expression )* )
			// PhoenixSQL.g:961:9: i= subtract_expression ( PLUS i= subtract_expression )*
			{
			pushFollow(FOLLOW_subtract_expression_in_add_expression6984);
			i=subtract_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {l.add(i);}
			// PhoenixSQL.g:961:43: ( PLUS i= subtract_expression )*
			loop169:
			while (true) {
				int alt169=2;
				int LA169_0 = input.LA(1);
				if ( (LA169_0==PLUS) ) {
					alt169=1;
				}

				switch (alt169) {
				case 1 :
					// PhoenixSQL.g:961:44: PLUS i= subtract_expression
					{
					match(input,PLUS,FOLLOW_PLUS_in_add_expression6989); if (state.failed) return ret;
					pushFollow(FOLLOW_subtract_expression_in_add_expression6993);
					i=subtract_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {l.add(i);}
					}
					break;

				default :
					break loop169;
				}
			}

			if ( state.backtracking==0 ) { ret = l.size() == 1 ? l.get(0) : factory.add(l); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "add_expression"



	// $ANTLR start "subtract_expression"
	// PhoenixSQL.g:964:1: subtract_expression returns [ParseNode ret] : i= concat_expression ( MINUS i= concat_expression )* ;
	public final ParseNode subtract_expression() throws RecognitionException {
		ParseNode ret = null;


		ParseNode i =null;

		List<ParseNode> l = new ArrayList<ParseNode>(4); 
		try {
			// PhoenixSQL.g:966:5: (i= concat_expression ( MINUS i= concat_expression )* )
			// PhoenixSQL.g:966:9: i= concat_expression ( MINUS i= concat_expression )*
			{
			pushFollow(FOLLOW_concat_expression_in_subtract_expression7028);
			i=concat_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {l.add(i);}
			// PhoenixSQL.g:966:41: ( MINUS i= concat_expression )*
			loop170:
			while (true) {
				int alt170=2;
				int LA170_0 = input.LA(1);
				if ( (LA170_0==MINUS) ) {
					alt170=1;
				}

				switch (alt170) {
				case 1 :
					// PhoenixSQL.g:966:42: MINUS i= concat_expression
					{
					match(input,MINUS,FOLLOW_MINUS_in_subtract_expression7033); if (state.failed) return ret;
					pushFollow(FOLLOW_concat_expression_in_subtract_expression7037);
					i=concat_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {l.add(i);}
					}
					break;

				default :
					break loop170;
				}
			}

			if ( state.backtracking==0 ) { ret = l.size() == 1 ? l.get(0) : factory.subtract(l); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "subtract_expression"



	// $ANTLR start "concat_expression"
	// PhoenixSQL.g:969:1: concat_expression returns [ParseNode ret] : i= multiply_divide_modulo_expression ( CONCAT i= multiply_divide_modulo_expression )* ;
	public final ParseNode concat_expression() throws RecognitionException {
		ParseNode ret = null;


		ParseNode i =null;

		List<ParseNode> l = new ArrayList<ParseNode>(4); 
		try {
			// PhoenixSQL.g:971:5: (i= multiply_divide_modulo_expression ( CONCAT i= multiply_divide_modulo_expression )* )
			// PhoenixSQL.g:971:9: i= multiply_divide_modulo_expression ( CONCAT i= multiply_divide_modulo_expression )*
			{
			pushFollow(FOLLOW_multiply_divide_modulo_expression_in_concat_expression7072);
			i=multiply_divide_modulo_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {l.add(i);}
			// PhoenixSQL.g:971:57: ( CONCAT i= multiply_divide_modulo_expression )*
			loop171:
			while (true) {
				int alt171=2;
				int LA171_0 = input.LA(1);
				if ( (LA171_0==CONCAT) ) {
					alt171=1;
				}

				switch (alt171) {
				case 1 :
					// PhoenixSQL.g:971:58: CONCAT i= multiply_divide_modulo_expression
					{
					match(input,CONCAT,FOLLOW_CONCAT_in_concat_expression7077); if (state.failed) return ret;
					pushFollow(FOLLOW_multiply_divide_modulo_expression_in_concat_expression7081);
					i=multiply_divide_modulo_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {l.add(i);}
					}
					break;

				default :
					break loop171;
				}
			}

			if ( state.backtracking==0 ) { ret = l.size() == 1 ? l.get(0) : factory.concat(l); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "concat_expression"



	// $ANTLR start "multiply_divide_modulo_expression"
	// PhoenixSQL.g:974:1: multiply_divide_modulo_expression returns [ParseNode ret] : i= negate_expression (op= ( ASTERISK | DIVIDE | PERCENT ) rhs= negate_expression )* ;
	public final ParseNode multiply_divide_modulo_expression() throws RecognitionException {
		ParseNode ret = null;


		Token op=null;
		ParseNode i =null;
		ParseNode rhs =null;

		ParseNode lhs = null; List<ParseNode> l;
		try {
			// PhoenixSQL.g:976:5: (i= negate_expression (op= ( ASTERISK | DIVIDE | PERCENT ) rhs= negate_expression )* )
			// PhoenixSQL.g:976:9: i= negate_expression (op= ( ASTERISK | DIVIDE | PERCENT ) rhs= negate_expression )*
			{
			pushFollow(FOLLOW_negate_expression_in_multiply_divide_modulo_expression7116);
			i=negate_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {lhs = i;}
			// PhoenixSQL.g:977:9: (op= ( ASTERISK | DIVIDE | PERCENT ) rhs= negate_expression )*
			loop172:
			while (true) {
				int alt172=2;
				int LA172_0 = input.LA(1);
				if ( (LA172_0==ASTERISK||LA172_0==DIVIDE||LA172_0==PERCENT) ) {
					alt172=1;
				}

				switch (alt172) {
				case 1 :
					// PhoenixSQL.g:977:10: op= ( ASTERISK | DIVIDE | PERCENT ) rhs= negate_expression
					{
					op=input.LT(1);
					if ( input.LA(1)==ASTERISK||input.LA(1)==DIVIDE||input.LA(1)==PERCENT ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_negate_expression_in_multiply_divide_modulo_expression7146);
					rhs=negate_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {
					            l = Arrays.asList(lhs, rhs); 
					            // determine the expression type based on the operator found
					            lhs = op.getType() == ASTERISK ? factory.multiply(l)
					                : op.getType() == DIVIDE   ? factory.divide(l)
					                : factory.modulus(l);
					            }
					}
					break;

				default :
					break loop172;
				}
			}

			if ( state.backtracking==0 ) { ret = lhs; }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "multiply_divide_modulo_expression"



	// $ANTLR start "use_schema_node"
	// PhoenixSQL.g:988:1: use_schema_node returns [UseSchemaStatement ret] : USE ( DEFAULT |s= identifier ) ;
	public final UseSchemaStatement use_schema_node() throws RecognitionException {
		UseSchemaStatement ret = null;


		String s =null;

		try {
			// PhoenixSQL.g:989:2: ( USE ( DEFAULT |s= identifier ) )
			// PhoenixSQL.g:989:6: USE ( DEFAULT |s= identifier )
			{
			match(input,USE,FOLLOW_USE_in_use_schema_node7189); if (state.failed) return ret;
			// PhoenixSQL.g:989:10: ( DEFAULT |s= identifier )
			int alt173=2;
			int LA173_0 = input.LA(1);
			if ( (LA173_0==DEFAULT) ) {
				alt173=1;
			}
			else if ( (LA173_0==NAME) ) {
				alt173=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 173, 0, input);
				throw nvae;
			}

			switch (alt173) {
				case 1 :
					// PhoenixSQL.g:989:11: DEFAULT
					{
					match(input,DEFAULT,FOLLOW_DEFAULT_in_use_schema_node7192); if (state.failed) return ret;
					}
					break;
				case 2 :
					// PhoenixSQL.g:989:21: s= identifier
					{
					pushFollow(FOLLOW_identifier_in_use_schema_node7198);
					s=identifier();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) {ret = factory.useSchema(s); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "use_schema_node"



	// $ANTLR start "negate_expression"
	// PhoenixSQL.g:993:1: negate_expression returns [ParseNode ret] : (m= MINUS )? e= array_expression ;
	public final ParseNode negate_expression() throws RecognitionException {
		ParseNode ret = null;


		Token m=null;
		ParseNode e =null;

		try {
			// PhoenixSQL.g:994:5: ( (m= MINUS )? e= array_expression )
			// PhoenixSQL.g:994:9: (m= MINUS )? e= array_expression
			{
			// PhoenixSQL.g:994:10: (m= MINUS )?
			int alt174=2;
			int LA174_0 = input.LA(1);
			if ( (LA174_0==MINUS) ) {
				alt174=1;
			}
			switch (alt174) {
				case 1 :
					// PhoenixSQL.g:994:10: m= MINUS
					{
					m=(Token)match(input,MINUS,FOLLOW_MINUS_in_negate_expression7234); if (state.failed) return ret;
					}
					break;

			}

			pushFollow(FOLLOW_array_expression_in_negate_expression7239);
			e=array_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = m==null ? e : factory.negate(e); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "negate_expression"



	// $ANTLR start "array_expression"
	// PhoenixSQL.g:998:1: array_expression returns [ParseNode ret] : e= term ( LSQUARE s= value_expression RSQUARE )? ;
	public final ParseNode array_expression() throws RecognitionException {
		ParseNode ret = null;


		ParseNode e =null;
		ParseNode s =null;

		try {
			// PhoenixSQL.g:999:5: (e= term ( LSQUARE s= value_expression RSQUARE )? )
			// PhoenixSQL.g:999:9: e= term ( LSQUARE s= value_expression RSQUARE )?
			{
			pushFollow(FOLLOW_term_in_array_expression7267);
			e=term();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:999:16: ( LSQUARE s= value_expression RSQUARE )?
			int alt175=2;
			int LA175_0 = input.LA(1);
			if ( (LA175_0==LSQUARE) ) {
				alt175=1;
			}
			switch (alt175) {
				case 1 :
					// PhoenixSQL.g:999:17: LSQUARE s= value_expression RSQUARE
					{
					match(input,LSQUARE,FOLLOW_LSQUARE_in_array_expression7270); if (state.failed) return ret;
					pushFollow(FOLLOW_value_expression_in_array_expression7274);
					s=value_expression();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RSQUARE,FOLLOW_RSQUARE_in_array_expression7276); if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) { if (s == null) { ret = e; } else { ret = factory.arrayElemRef(Arrays.<ParseNode>asList(e,s)); } }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "array_expression"



	// $ANTLR start "term"
	// PhoenixSQL.g:1002:1: term returns [ParseNode ret] : (e= literal_or_bind |field= identifier |ex= ARRAY LSQUARE v= one_or_more_expressions RSQUARE |tableName= table_name DOT field= identifier |field= identifier LPAREN l= zero_or_more_expressions RPAREN wg= ( WITHIN GROUP LPAREN ORDER BY l2= one_or_more_expressions (a= ASC | DESC ) RPAREN )? |field= identifier LPAREN t= ASTERISK RPAREN |field= identifier LPAREN t= DISTINCT l= zero_or_more_expressions RPAREN |e= case_statement | LPAREN l= one_or_more_expressions RPAREN | CAST LPAREN e= expression AS dt= identifier ( LPAREN length= NUMBER ( COMMA scale= NUMBER )? RPAREN )? ar= ( ARRAY | ( LSQUARE RSQUARE ) )? RPAREN | (n= NEXT | CURRENT ) VALUE FOR s= from_table_name | (n= NEXT ) lorb= literal_or_bind VALUES FOR s= from_table_name );
	public final ParseNode term() throws RecognitionException {
		ParseNode ret = null;


		Token ex=null;
		Token a=null;
		Token wg=null;
		Token t=null;
		Token length=null;
		Token scale=null;
		Token ar=null;
		Token n=null;
		ParseNode e =null;
		String field =null;
		List<ParseNode> v =null;
		TableName tableName =null;
		List<ParseNode> l =null;
		List<ParseNode> l2 =null;
		String dt =null;
		TableName s =null;
		ParseNode lorb =null;

		try {
			// PhoenixSQL.g:1003:5: (e= literal_or_bind |field= identifier |ex= ARRAY LSQUARE v= one_or_more_expressions RSQUARE |tableName= table_name DOT field= identifier |field= identifier LPAREN l= zero_or_more_expressions RPAREN wg= ( WITHIN GROUP LPAREN ORDER BY l2= one_or_more_expressions (a= ASC | DESC ) RPAREN )? |field= identifier LPAREN t= ASTERISK RPAREN |field= identifier LPAREN t= DISTINCT l= zero_or_more_expressions RPAREN |e= case_statement | LPAREN l= one_or_more_expressions RPAREN | CAST LPAREN e= expression AS dt= identifier ( LPAREN length= NUMBER ( COMMA scale= NUMBER )? RPAREN )? ar= ( ARRAY | ( LSQUARE RSQUARE ) )? RPAREN | (n= NEXT | CURRENT ) VALUE FOR s= from_table_name | (n= NEXT ) lorb= literal_or_bind VALUES FOR s= from_table_name )
			int alt182=12;
			switch ( input.LA(1) ) {
			case BIND_NAME:
			case DECIMAL:
			case DOUBLE:
			case FALSE:
			case NULL:
			case NUMBER:
			case QUESTION:
			case STRING_LITERAL:
			case TRUE:
				{
				alt182=1;
				}
				break;
			case NAME:
				{
				switch ( input.LA(2) ) {
				case STRING_LITERAL:
					{
					alt182=1;
					}
					break;
				case EOF:
				case AND:
				case AS:
				case ASC:
				case ASTERISK:
				case BETWEEN:
				case CACHE:
				case COMMA:
				case CONCAT:
				case CONSTRAINT:
				case CYCLE:
				case DESC:
				case DIVIDE:
				case ELSE:
				case END:
				case EQ:
				case FETCH:
				case FROM:
				case FULL:
				case GROUP:
				case GT:
				case HAVING:
				case ILIKE:
				case IN:
				case INCREMENT:
				case INNER:
				case IS:
				case JOIN:
				case LEFT:
				case LIKE:
				case LIMIT:
				case LSQUARE:
				case LT:
				case MAXVALUE:
				case MINUS:
				case MINVALUE:
				case NAME:
				case NOEQ1:
				case NOEQ2:
				case NOT:
				case NULLS:
				case OFFSET:
				case OR:
				case ORDER:
				case PERCENT:
				case PLUS:
				case PRIMARY:
				case RIGHT:
				case RPAREN:
				case RSQUARE:
				case SEMICOLON:
				case THEN:
				case UNION:
				case WHEN:
				case WHERE:
					{
					alt182=2;
					}
					break;
				case DOT:
					{
					alt182=4;
					}
					break;
				case LPAREN:
					{
					switch ( input.LA(3) ) {
					case ASTERISK:
						{
						alt182=6;
						}
						break;
					case DISTINCT:
						{
						alt182=7;
						}
						break;
					case ARRAY:
					case BIND_NAME:
					case CASE:
					case CAST:
					case COMMA:
					case CURRENT:
					case DECIMAL:
					case DOUBLE:
					case EXISTS:
					case FALSE:
					case LPAREN:
					case MINUS:
					case NAME:
					case NEXT:
					case NOT:
					case NULL:
					case NUMBER:
					case QUESTION:
					case RPAREN:
					case STRING_LITERAL:
					case TRUE:
						{
						alt182=5;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return ret;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 182, 11, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 182, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case ARRAY:
				{
				alt182=3;
				}
				break;
			case CASE:
				{
				alt182=8;
				}
				break;
			case LPAREN:
				{
				alt182=9;
				}
				break;
			case CAST:
				{
				alt182=10;
				}
				break;
			case NEXT:
				{
				int LA182_7 = input.LA(2);
				if ( (LA182_7==VALUE) ) {
					alt182=11;
				}
				else if ( (LA182_7==BIND_NAME||LA182_7==DECIMAL||LA182_7==DOUBLE||LA182_7==FALSE||LA182_7==NAME||LA182_7==NULL||LA182_7==NUMBER||LA182_7==QUESTION||LA182_7==STRING_LITERAL||LA182_7==TRUE) ) {
					alt182=12;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 182, 7, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case CURRENT:
				{
				alt182=11;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 182, 0, input);
				throw nvae;
			}
			switch (alt182) {
				case 1 :
					// PhoenixSQL.g:1003:9: e= literal_or_bind
					{
					pushFollow(FOLLOW_literal_or_bind_in_term7309);
					e=literal_or_bind();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = e; }
					}
					break;
				case 2 :
					// PhoenixSQL.g:1004:9: field= identifier
					{
					pushFollow(FOLLOW_identifier_in_term7323);
					field=identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.column(null,field,field); }
					}
					break;
				case 3 :
					// PhoenixSQL.g:1005:9: ex= ARRAY LSQUARE v= one_or_more_expressions RSQUARE
					{
					ex=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_term7337); if (state.failed) return ret;
					match(input,LSQUARE,FOLLOW_LSQUARE_in_term7339); if (state.failed) return ret;
					pushFollow(FOLLOW_one_or_more_expressions_in_term7343);
					v=one_or_more_expressions();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RSQUARE,FOLLOW_RSQUARE_in_term7345); if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.upsertStmtArrayNode(v);}
					}
					break;
				case 4 :
					// PhoenixSQL.g:1006:9: tableName= table_name DOT field= identifier
					{
					pushFollow(FOLLOW_table_name_in_term7359);
					tableName=table_name();
					state._fsp--;
					if (state.failed) return ret;
					match(input,DOT,FOLLOW_DOT_in_term7361); if (state.failed) return ret;
					pushFollow(FOLLOW_identifier_in_term7365);
					field=identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.column(tableName, field, field); }
					}
					break;
				case 5 :
					// PhoenixSQL.g:1007:9: field= identifier LPAREN l= zero_or_more_expressions RPAREN wg= ( WITHIN GROUP LPAREN ORDER BY l2= one_or_more_expressions (a= ASC | DESC ) RPAREN )?
					{
					pushFollow(FOLLOW_identifier_in_term7379);
					field=identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,LPAREN,FOLLOW_LPAREN_in_term7381); if (state.failed) return ret;
					pushFollow(FOLLOW_zero_or_more_expressions_in_term7385);
					l=zero_or_more_expressions();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_term7387); if (state.failed) return ret;
					// PhoenixSQL.g:1007:70: ( WITHIN GROUP LPAREN ORDER BY l2= one_or_more_expressions (a= ASC | DESC ) RPAREN )?
					int alt177=2;
					int LA177_0 = input.LA(1);
					if ( (LA177_0==WITHIN) ) {
						alt177=1;
					}
					switch (alt177) {
						case 1 :
							// PhoenixSQL.g:1007:71: WITHIN GROUP LPAREN ORDER BY l2= one_or_more_expressions (a= ASC | DESC ) RPAREN
							{
							wg=(Token)match(input,WITHIN,FOLLOW_WITHIN_in_term7392); if (state.failed) return ret;
							wg=(Token)match(input,GROUP,FOLLOW_GROUP_in_term7394); if (state.failed) return ret;
							wg=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_term7396); if (state.failed) return ret;
							wg=(Token)match(input,ORDER,FOLLOW_ORDER_in_term7398); if (state.failed) return ret;
							wg=(Token)match(input,BY,FOLLOW_BY_in_term7400); if (state.failed) return ret;
							pushFollow(FOLLOW_one_or_more_expressions_in_term7404);
							l2=one_or_more_expressions();
							state._fsp--;
							if (state.failed) return ret;
							// PhoenixSQL.g:1007:127: (a= ASC | DESC )
							int alt176=2;
							int LA176_0 = input.LA(1);
							if ( (LA176_0==ASC) ) {
								alt176=1;
							}
							else if ( (LA176_0==DESC) ) {
								alt176=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return ret;}
								NoViableAltException nvae =
									new NoViableAltException("", 176, 0, input);
								throw nvae;
							}

							switch (alt176) {
								case 1 :
									// PhoenixSQL.g:1007:128: a= ASC
									{
									a=(Token)match(input,ASC,FOLLOW_ASC_in_term7409); if (state.failed) return ret;
									}
									break;
								case 2 :
									// PhoenixSQL.g:1007:136: DESC
									{
									wg=(Token)match(input,DESC,FOLLOW_DESC_in_term7413); if (state.failed) return ret;
									}
									break;

							}

							wg=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_term7416); if (state.failed) return ret;
							}
							break;

					}

					if ( state.backtracking==0 ) {
					            FunctionParseNode f = wg==null ? factory.function(field, l) : factory.function(field,l,l2,a!=null);
					            if (!contextStack.isEmpty()) {
					            	contextStack.peek().setAggregate(f.isAggregate());
					            }
					            if(f instanceof UDFParseNode) udfParseNodes.put(f.getName(),(UDFParseNode)f);
					            ret = f;
					        }
					}
					break;
				case 6 :
					// PhoenixSQL.g:1016:9: field= identifier LPAREN t= ASTERISK RPAREN
					{
					pushFollow(FOLLOW_identifier_in_term7441);
					field=identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,LPAREN,FOLLOW_LPAREN_in_term7443); if (state.failed) return ret;
					t=(Token)match(input,ASTERISK,FOLLOW_ASTERISK_in_term7447); if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_term7449); if (state.failed) return ret;
					if ( state.backtracking==0 ) {
					            if (!isCountFunction(field)) {
					                throwRecognitionException(t);
					            }
					            FunctionParseNode f = factory.function(field, LiteralParseNode.STAR);
					            if (!contextStack.isEmpty()) {
					            	contextStack.peek().setAggregate(f.isAggregate());
					            }
					            if(f instanceof UDFParseNode) udfParseNodes.put(f.getName(),(UDFParseNode)f);
					            ret = f;
					        }
					}
					break;
				case 7 :
					// PhoenixSQL.g:1028:9: field= identifier LPAREN t= DISTINCT l= zero_or_more_expressions RPAREN
					{
					pushFollow(FOLLOW_identifier_in_term7473);
					field=identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,LPAREN,FOLLOW_LPAREN_in_term7475); if (state.failed) return ret;
					t=(Token)match(input,DISTINCT,FOLLOW_DISTINCT_in_term7479); if (state.failed) return ret;
					pushFollow(FOLLOW_zero_or_more_expressions_in_term7483);
					l=zero_or_more_expressions();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_term7485); if (state.failed) return ret;
					if ( state.backtracking==0 ) {
					            FunctionParseNode f = factory.functionDistinct(field, l);
					            if (!contextStack.isEmpty()) {
					            	contextStack.peek().setAggregate(f.isAggregate());
					            }
					            if(f instanceof UDFParseNode) udfParseNodes.put(f.getName(),(UDFParseNode)f);
					            ret = f;
					        }
					}
					break;
				case 8 :
					// PhoenixSQL.g:1037:9: e= case_statement
					{
					pushFollow(FOLLOW_case_statement_in_term7508);
					e=case_statement();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = e; }
					}
					break;
				case 9 :
					// PhoenixSQL.g:1038:9: LPAREN l= one_or_more_expressions RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_term7520); if (state.failed) return ret;
					pushFollow(FOLLOW_one_or_more_expressions_in_term7524);
					l=one_or_more_expressions();
					state._fsp--;
					if (state.failed) return ret;
					match(input,RPAREN,FOLLOW_RPAREN_in_term7526); if (state.failed) return ret;
					if ( state.backtracking==0 ) { 
					    		if(l.size() == 1) {
					    			ret = l.get(0);
					    		}	
					    		else {
					    			ret = factory.rowValueConstructor(l);
					    		}	 
					    	}
					}
					break;
				case 10 :
					// PhoenixSQL.g:1047:9: CAST LPAREN e= expression AS dt= identifier ( LPAREN length= NUMBER ( COMMA scale= NUMBER )? RPAREN )? ar= ( ARRAY | ( LSQUARE RSQUARE ) )? RPAREN
					{
					match(input,CAST,FOLLOW_CAST_in_term7544); if (state.failed) return ret;
					match(input,LPAREN,FOLLOW_LPAREN_in_term7546); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_term7550);
					e=expression();
					state._fsp--;
					if (state.failed) return ret;
					match(input,AS,FOLLOW_AS_in_term7552); if (state.failed) return ret;
					pushFollow(FOLLOW_identifier_in_term7556);
					dt=identifier();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:1047:51: ( LPAREN length= NUMBER ( COMMA scale= NUMBER )? RPAREN )?
					int alt179=2;
					int LA179_0 = input.LA(1);
					if ( (LA179_0==LPAREN) ) {
						alt179=1;
					}
					switch (alt179) {
						case 1 :
							// PhoenixSQL.g:1047:52: LPAREN length= NUMBER ( COMMA scale= NUMBER )? RPAREN
							{
							match(input,LPAREN,FOLLOW_LPAREN_in_term7559); if (state.failed) return ret;
							length=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term7563); if (state.failed) return ret;
							// PhoenixSQL.g:1047:73: ( COMMA scale= NUMBER )?
							int alt178=2;
							int LA178_0 = input.LA(1);
							if ( (LA178_0==COMMA) ) {
								alt178=1;
							}
							switch (alt178) {
								case 1 :
									// PhoenixSQL.g:1047:74: COMMA scale= NUMBER
									{
									match(input,COMMA,FOLLOW_COMMA_in_term7566); if (state.failed) return ret;
									scale=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term7570); if (state.failed) return ret;
									}
									break;

							}

							match(input,RPAREN,FOLLOW_RPAREN_in_term7574); if (state.failed) return ret;
							}
							break;

					}

					// PhoenixSQL.g:1047:107: ( ARRAY | ( LSQUARE RSQUARE ) )?
					int alt180=3;
					int LA180_0 = input.LA(1);
					if ( (LA180_0==ARRAY) ) {
						alt180=1;
					}
					else if ( (LA180_0==LSQUARE) ) {
						alt180=2;
					}
					switch (alt180) {
						case 1 :
							// PhoenixSQL.g:1047:108: ARRAY
							{
							ar=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_term7581); if (state.failed) return ret;
							}
							break;
						case 2 :
							// PhoenixSQL.g:1047:116: ( LSQUARE RSQUARE )
							{
							// PhoenixSQL.g:1047:116: ( LSQUARE RSQUARE )
							// PhoenixSQL.g:1047:117: LSQUARE RSQUARE
							{
							ar=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_term7586); if (state.failed) return ret;
							ar=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_term7588); if (state.failed) return ret;
							}

							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_term7593); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.cast(e, dt,
					                     length == null ? null : Integer.parseInt(length.getText()),
					                     scale == null ? null : Integer.parseInt(scale.getText()),
					                     ar!=null);
					        }
					}
					break;
				case 11 :
					// PhoenixSQL.g:1053:9: (n= NEXT | CURRENT ) VALUE FOR s= from_table_name
					{
					// PhoenixSQL.g:1053:9: (n= NEXT | CURRENT )
					int alt181=2;
					int LA181_0 = input.LA(1);
					if ( (LA181_0==NEXT) ) {
						alt181=1;
					}
					else if ( (LA181_0==CURRENT) ) {
						alt181=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						NoViableAltException nvae =
							new NoViableAltException("", 181, 0, input);
						throw nvae;
					}

					switch (alt181) {
						case 1 :
							// PhoenixSQL.g:1053:10: n= NEXT
							{
							n=(Token)match(input,NEXT,FOLLOW_NEXT_in_term7616); if (state.failed) return ret;
							}
							break;
						case 2 :
							// PhoenixSQL.g:1053:19: CURRENT
							{
							match(input,CURRENT,FOLLOW_CURRENT_in_term7620); if (state.failed) return ret;
							}
							break;

					}

					match(input,VALUE,FOLLOW_VALUE_in_term7623); if (state.failed) return ret;
					match(input,FOR,FOLLOW_FOR_in_term7625); if (state.failed) return ret;
					pushFollow(FOLLOW_from_table_name_in_term7629);
					s=from_table_name();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { contextStack.peek().hasSequences(true);
					          ret = n==null ? factory.currentValueFor(s) : factory.nextValueFor(s, null); }
					}
					break;
				case 12 :
					// PhoenixSQL.g:1056:9: (n= NEXT ) lorb= literal_or_bind VALUES FOR s= from_table_name
					{
					// PhoenixSQL.g:1056:9: (n= NEXT )
					// PhoenixSQL.g:1056:10: n= NEXT
					{
					n=(Token)match(input,NEXT,FOLLOW_NEXT_in_term7657); if (state.failed) return ret;
					}

					pushFollow(FOLLOW_literal_or_bind_in_term7662);
					lorb=literal_or_bind();
					state._fsp--;
					if (state.failed) return ret;
					match(input,VALUES,FOLLOW_VALUES_in_term7664); if (state.failed) return ret;
					match(input,FOR,FOLLOW_FOR_in_term7666); if (state.failed) return ret;
					pushFollow(FOLLOW_from_table_name_in_term7670);
					s=from_table_name();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { contextStack.peek().hasSequences(true);
					          ret = factory.nextValueFor(s, lorb); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "term"



	// $ANTLR start "one_or_more_expressions"
	// PhoenixSQL.g:1061:1: one_or_more_expressions returns [List<ParseNode> ret] : e= expression ( COMMA e= expression )* ;
	public final List<ParseNode> one_or_more_expressions() throws RecognitionException {
		List<ParseNode> ret = null;


		ParseNode e =null;

		ret = new ArrayList<ParseNode>(); 
		try {
			// PhoenixSQL.g:1063:5: (e= expression ( COMMA e= expression )* )
			// PhoenixSQL.g:1063:8: e= expression ( COMMA e= expression )*
			{
			pushFollow(FOLLOW_expression_in_one_or_more_expressions7715);
			e=expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.add(e);}
			// PhoenixSQL.g:1063:39: ( COMMA e= expression )*
			loop183:
			while (true) {
				int alt183=2;
				int LA183_0 = input.LA(1);
				if ( (LA183_0==COMMA) ) {
					alt183=1;
				}

				switch (alt183) {
				case 1 :
					// PhoenixSQL.g:1063:40: COMMA e= expression
					{
					match(input,COMMA,FOLLOW_COMMA_in_one_or_more_expressions7721); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_one_or_more_expressions7727);
					e=expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(e);}
					}
					break;

				default :
					break loop183;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "one_or_more_expressions"



	// $ANTLR start "one_or_more_jarpaths"
	// PhoenixSQL.g:1066:1: one_or_more_jarpaths returns [List<LiteralParseNode> ret] : jarPath= jar_path ( COMMA jarPath= jar_path )* ;
	public final List<LiteralParseNode> one_or_more_jarpaths() throws RecognitionException {
		List<LiteralParseNode> ret = null;


		LiteralParseNode jarPath =null;

		ret = new ArrayList<LiteralParseNode>(); 
		try {
			// PhoenixSQL.g:1068:5: (jarPath= jar_path ( COMMA jarPath= jar_path )* )
			// PhoenixSQL.g:1068:8: jarPath= jar_path ( COMMA jarPath= jar_path )*
			{
			pushFollow(FOLLOW_jar_path_in_one_or_more_jarpaths7758);
			jarPath=jar_path();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.add(jarPath);}
			// PhoenixSQL.g:1068:49: ( COMMA jarPath= jar_path )*
			loop184:
			while (true) {
				int alt184=2;
				int LA184_0 = input.LA(1);
				if ( (LA184_0==COMMA) ) {
					alt184=1;
				}

				switch (alt184) {
				case 1 :
					// PhoenixSQL.g:1068:50: COMMA jarPath= jar_path
					{
					match(input,COMMA,FOLLOW_COMMA_in_one_or_more_jarpaths7764); if (state.failed) return ret;
					pushFollow(FOLLOW_jar_path_in_one_or_more_jarpaths7770);
					jarPath=jar_path();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(jarPath);}
					}
					break;

				default :
					break loop184;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "one_or_more_jarpaths"



	// $ANTLR start "zero_or_more_expressions"
	// PhoenixSQL.g:1071:1: zero_or_more_expressions returns [List<ParseNode> ret] : (v= expression )? ( COMMA v= expression )* ;
	public final List<ParseNode> zero_or_more_expressions() throws RecognitionException {
		List<ParseNode> ret = null;


		ParseNode v =null;

		ret = new ArrayList<ParseNode>(); 
		try {
			// PhoenixSQL.g:1073:5: ( (v= expression )? ( COMMA v= expression )* )
			// PhoenixSQL.g:1073:8: (v= expression )? ( COMMA v= expression )*
			{
			// PhoenixSQL.g:1073:8: (v= expression )?
			int alt185=2;
			int LA185_0 = input.LA(1);
			if ( (LA185_0==ARRAY||LA185_0==BIND_NAME||(LA185_0 >= CASE && LA185_0 <= CAST)||LA185_0==CURRENT||LA185_0==DECIMAL||LA185_0==DOUBLE||LA185_0==EXISTS||LA185_0==FALSE||LA185_0==LPAREN||LA185_0==MINUS||(LA185_0 >= NAME && LA185_0 <= NEXT)||(LA185_0 >= NOT && LA185_0 <= NULL)||LA185_0==NUMBER||LA185_0==QUESTION||LA185_0==STRING_LITERAL||LA185_0==TRUE) ) {
				alt185=1;
			}
			switch (alt185) {
				case 1 :
					// PhoenixSQL.g:1073:9: v= expression
					{
					pushFollow(FOLLOW_expression_in_zero_or_more_expressions7803);
					v=expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(v);}
					}
					break;

			}

			// PhoenixSQL.g:1073:42: ( COMMA v= expression )*
			loop186:
			while (true) {
				int alt186=2;
				int LA186_0 = input.LA(1);
				if ( (LA186_0==COMMA) ) {
					alt186=1;
				}

				switch (alt186) {
				case 1 :
					// PhoenixSQL.g:1073:43: COMMA v= expression
					{
					match(input,COMMA,FOLLOW_COMMA_in_zero_or_more_expressions7811); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_zero_or_more_expressions7817);
					v=expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(v);}
					}
					break;

				default :
					break loop186;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "zero_or_more_expressions"



	// $ANTLR start "zero_or_more_data_types"
	// PhoenixSQL.g:1076:1: zero_or_more_data_types returns [List<FunctionArgument> ret] : (fa= function_argument )? ( COMMA fa= function_argument )* ;
	public final List<FunctionArgument> zero_or_more_data_types() throws RecognitionException {
		List<FunctionArgument> ret = null;


		FunctionArgument fa =null;

		ret = new ArrayList<FunctionArgument>(); 
		try {
			// PhoenixSQL.g:1078:5: ( (fa= function_argument )? ( COMMA fa= function_argument )* )
			// PhoenixSQL.g:1078:7: (fa= function_argument )? ( COMMA fa= function_argument )*
			{
			// PhoenixSQL.g:1078:7: (fa= function_argument )?
			int alt187=2;
			int LA187_0 = input.LA(1);
			if ( (LA187_0==NAME) ) {
				alt187=1;
			}
			switch (alt187) {
				case 1 :
					// PhoenixSQL.g:1078:8: fa= function_argument
					{
					pushFollow(FOLLOW_function_argument_in_zero_or_more_data_types7848);
					fa=function_argument();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(fa);}
					}
					break;

			}

			// PhoenixSQL.g:1078:49: ( COMMA fa= function_argument )*
			loop188:
			while (true) {
				int alt188=2;
				int LA188_0 = input.LA(1);
				if ( (LA188_0==COMMA) ) {
					alt188=1;
				}

				switch (alt188) {
				case 1 :
					// PhoenixSQL.g:1078:50: COMMA fa= function_argument
					{
					match(input,COMMA,FOLLOW_COMMA_in_zero_or_more_data_types7855); if (state.failed) return ret;
					pushFollow(FOLLOW_function_argument_in_zero_or_more_data_types7861);
					fa=function_argument();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(fa);}
					}
					break;

				default :
					break loop188;
				}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "zero_or_more_data_types"



	// $ANTLR start "function_argument"
	// PhoenixSQL.g:1081:1: function_argument returns [FunctionArgument ret] : (dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? (c= CONSTANT )? ( DEFAULTVALUE EQ dv= expression )? ( MINVALUE EQ minv= expression )? ( MAXVALUE EQ maxv= expression )? ) ;
	public final FunctionArgument function_argument() throws RecognitionException {
		FunctionArgument ret = null;


		Token l=null;
		Token s=null;
		Token ar=null;
		Token lsq=null;
		Token a=null;
		Token c=null;
		String dt =null;
		ParseNode dv =null;
		ParseNode minv =null;
		ParseNode maxv =null;

		try {
			// PhoenixSQL.g:1082:2: ( (dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? (c= CONSTANT )? ( DEFAULTVALUE EQ dv= expression )? ( MINVALUE EQ minv= expression )? ( MAXVALUE EQ maxv= expression )? ) )
			// PhoenixSQL.g:1082:4: (dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? (c= CONSTANT )? ( DEFAULTVALUE EQ dv= expression )? ( MINVALUE EQ minv= expression )? ( MAXVALUE EQ maxv= expression )? )
			{
			// PhoenixSQL.g:1082:4: (dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? (c= CONSTANT )? ( DEFAULTVALUE EQ dv= expression )? ( MINVALUE EQ minv= expression )? ( MAXVALUE EQ maxv= expression )? )
			// PhoenixSQL.g:1082:5: dt= identifier ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )? (ar= ARRAY )? (lsq= LSQUARE (a= NUMBER )? RSQUARE )? (c= CONSTANT )? ( DEFAULTVALUE EQ dv= expression )? ( MINVALUE EQ minv= expression )? ( MAXVALUE EQ maxv= expression )?
			{
			pushFollow(FOLLOW_identifier_in_function_argument7886);
			dt=identifier();
			state._fsp--;
			if (state.failed) return ret;
			// PhoenixSQL.g:1082:21: ( LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN )?
			int alt190=2;
			int LA190_0 = input.LA(1);
			if ( (LA190_0==LPAREN) ) {
				alt190=1;
			}
			switch (alt190) {
				case 1 :
					// PhoenixSQL.g:1082:22: LPAREN l= NUMBER ( COMMA s= NUMBER )? RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_function_argument7889); if (state.failed) return ret;
					l=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_function_argument7893); if (state.failed) return ret;
					// PhoenixSQL.g:1082:38: ( COMMA s= NUMBER )?
					int alt189=2;
					int LA189_0 = input.LA(1);
					if ( (LA189_0==COMMA) ) {
						alt189=1;
					}
					switch (alt189) {
						case 1 :
							// PhoenixSQL.g:1082:39: COMMA s= NUMBER
							{
							match(input,COMMA,FOLLOW_COMMA_in_function_argument7896); if (state.failed) return ret;
							s=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_function_argument7900); if (state.failed) return ret;
							}
							break;

					}

					match(input,RPAREN,FOLLOW_RPAREN_in_function_argument7904); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:1082:67: (ar= ARRAY )?
			int alt191=2;
			int LA191_0 = input.LA(1);
			if ( (LA191_0==ARRAY) ) {
				alt191=1;
			}
			switch (alt191) {
				case 1 :
					// PhoenixSQL.g:1082:67: ar= ARRAY
					{
					ar=(Token)match(input,ARRAY,FOLLOW_ARRAY_in_function_argument7910); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:1082:75: (lsq= LSQUARE (a= NUMBER )? RSQUARE )?
			int alt193=2;
			int LA193_0 = input.LA(1);
			if ( (LA193_0==LSQUARE) ) {
				alt193=1;
			}
			switch (alt193) {
				case 1 :
					// PhoenixSQL.g:1082:76: lsq= LSQUARE (a= NUMBER )? RSQUARE
					{
					lsq=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_function_argument7916); if (state.failed) return ret;
					// PhoenixSQL.g:1082:88: (a= NUMBER )?
					int alt192=2;
					int LA192_0 = input.LA(1);
					if ( (LA192_0==NUMBER) ) {
						alt192=1;
					}
					switch (alt192) {
						case 1 :
							// PhoenixSQL.g:1082:89: a= NUMBER
							{
							a=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_function_argument7921); if (state.failed) return ret;
							}
							break;

					}

					match(input,RSQUARE,FOLLOW_RSQUARE_in_function_argument7925); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:1082:110: (c= CONSTANT )?
			int alt194=2;
			int LA194_0 = input.LA(1);
			if ( (LA194_0==CONSTANT) ) {
				alt194=1;
			}
			switch (alt194) {
				case 1 :
					// PhoenixSQL.g:1082:111: c= CONSTANT
					{
					c=(Token)match(input,CONSTANT,FOLLOW_CONSTANT_in_function_argument7934); if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:1082:126: ( DEFAULTVALUE EQ dv= expression )?
			int alt195=2;
			int LA195_0 = input.LA(1);
			if ( (LA195_0==DEFAULTVALUE) ) {
				alt195=1;
			}
			switch (alt195) {
				case 1 :
					// PhoenixSQL.g:1082:127: DEFAULTVALUE EQ dv= expression
					{
					match(input,DEFAULTVALUE,FOLLOW_DEFAULTVALUE_in_function_argument7939); if (state.failed) return ret;
					match(input,EQ,FOLLOW_EQ_in_function_argument7941); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_function_argument7947);
					dv=expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:1082:161: ( MINVALUE EQ minv= expression )?
			int alt196=2;
			int LA196_0 = input.LA(1);
			if ( (LA196_0==MINVALUE) ) {
				alt196=1;
			}
			switch (alt196) {
				case 1 :
					// PhoenixSQL.g:1082:162: MINVALUE EQ minv= expression
					{
					match(input,MINVALUE,FOLLOW_MINVALUE_in_function_argument7952); if (state.failed) return ret;
					match(input,EQ,FOLLOW_EQ_in_function_argument7954); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_function_argument7960);
					minv=expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			// PhoenixSQL.g:1082:195: ( MAXVALUE EQ maxv= expression )?
			int alt197=2;
			int LA197_0 = input.LA(1);
			if ( (LA197_0==MAXVALUE) ) {
				alt197=1;
			}
			switch (alt197) {
				case 1 :
					// PhoenixSQL.g:1082:196: MAXVALUE EQ maxv= expression
					{
					match(input,MAXVALUE,FOLLOW_MAXVALUE_in_function_argument7966); if (state.failed) return ret;
					match(input,EQ,FOLLOW_EQ_in_function_argument7968); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_function_argument7974);
					maxv=expression();
					state._fsp--;
					if (state.failed) return ret;
					}
					break;

			}

			if ( state.backtracking==0 ) { ret = new FunctionArgument(dt,  ar != null || lsq != null, c!=null, 
			    dv == null ? null : LiteralExpression.newConstant(((LiteralParseNode)dv).getValue()), 
			    minv == null ? null : LiteralExpression.newConstant(((LiteralParseNode)minv).getValue()), 
			    maxv == null ? null : LiteralExpression.newConstant(((LiteralParseNode)maxv).getValue()));}
			}

			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "function_argument"



	// $ANTLR start "value_expression_list"
	// PhoenixSQL.g:1089:1: value_expression_list returns [List<ParseNode> ret] : LPAREN e= value_expression ( COMMA e= value_expression )* RPAREN ;
	public final List<ParseNode> value_expression_list() throws RecognitionException {
		List<ParseNode> ret = null;


		ParseNode e =null;

		ret = new ArrayList<ParseNode>(); 
		try {
			// PhoenixSQL.g:1091:5: ( LPAREN e= value_expression ( COMMA e= value_expression )* RPAREN )
			// PhoenixSQL.g:1091:8: LPAREN e= value_expression ( COMMA e= value_expression )* RPAREN
			{
			match(input,LPAREN,FOLLOW_LPAREN_in_value_expression_list8004); if (state.failed) return ret;
			pushFollow(FOLLOW_value_expression_in_value_expression_list8010);
			e=value_expression();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret.add(e);}
			// PhoenixSQL.g:1091:52: ( COMMA e= value_expression )*
			loop198:
			while (true) {
				int alt198=2;
				int LA198_0 = input.LA(1);
				if ( (LA198_0==COMMA) ) {
					alt198=1;
				}

				switch (alt198) {
				case 1 :
					// PhoenixSQL.g:1091:53: COMMA e= value_expression
					{
					match(input,COMMA,FOLLOW_COMMA_in_value_expression_list8016); if (state.failed) return ret;
					pushFollow(FOLLOW_value_expression_in_value_expression_list8022);
					e=value_expression();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret.add(e);}
					}
					break;

				default :
					break loop198;
				}
			}

			match(input,RPAREN,FOLLOW_RPAREN_in_value_expression_list8029); if (state.failed) return ret;
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "value_expression_list"



	// $ANTLR start "index_name"
	// PhoenixSQL.g:1094:1: index_name returns [NamedNode ret] : name= identifier ;
	public final NamedNode index_name() throws RecognitionException {
		NamedNode ret = null;


		String name =null;

		try {
			// PhoenixSQL.g:1095:5: (name= identifier )
			// PhoenixSQL.g:1095:9: name= identifier
			{
			pushFollow(FOLLOW_identifier_in_index_name8050);
			name=identifier();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.indexName(name); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "index_name"



	// $ANTLR start "cursor_name"
	// PhoenixSQL.g:1098:1: cursor_name returns [CursorName ret] : name= identifier ;
	public final CursorName cursor_name() throws RecognitionException {
		CursorName ret = null;


		String name =null;

		try {
			// PhoenixSQL.g:1099:5: (name= identifier )
			// PhoenixSQL.g:1099:9: name= identifier
			{
			pushFollow(FOLLOW_identifier_in_cursor_name8077);
			name=identifier();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {ret = factory.cursorName(name);}
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "cursor_name"



	// $ANTLR start "table_name"
	// PhoenixSQL.g:1103:1: table_name returns [TableName ret] : (t= table_identifier |s= table_identifier DOT t= table_identifier );
	public final TableName table_name() throws RecognitionException {
		TableName ret = null;


		String t =null;
		String s =null;

		try {
			// PhoenixSQL.g:1104:5: (t= table_identifier |s= table_identifier DOT t= table_identifier )
			int alt199=2;
			int LA199_0 = input.LA(1);
			if ( (LA199_0==NAME) ) {
				int LA199_1 = input.LA(2);
				if ( (LA199_1==FROM||LA199_1==TO) ) {
					alt199=1;
				}
				else if ( (LA199_1==DOT) ) {
					int LA199_3 = input.LA(3);
					if ( (LA199_3==NAME) ) {
						switch ( input.LA(4) ) {
						case EOF:
						case AND:
						case AS:
						case ASC:
						case ASTERISK:
						case BETWEEN:
						case CACHE:
						case COMMA:
						case CONCAT:
						case CONSTRAINT:
						case CYCLE:
						case DESC:
						case DIVIDE:
						case ELSE:
						case END:
						case EQ:
						case FETCH:
						case FULL:
						case GROUP:
						case GT:
						case HAVING:
						case ILIKE:
						case IN:
						case INCREMENT:
						case INNER:
						case IS:
						case JOIN:
						case LEFT:
						case LIKE:
						case LIMIT:
						case LSQUARE:
						case LT:
						case MAXVALUE:
						case MINUS:
						case MINVALUE:
						case NAME:
						case NOEQ1:
						case NOEQ2:
						case NOT:
						case NULLS:
						case OFFSET:
						case OR:
						case ORDER:
						case PERCENT:
						case PLUS:
						case PRIMARY:
						case RIGHT:
						case RPAREN:
						case RSQUARE:
						case SEMICOLON:
						case THEN:
						case UNION:
						case WHEN:
						case WHERE:
							{
							alt199=1;
							}
							break;
						case FROM:
							{
							switch ( input.LA(5) ) {
							case BIND_NAME:
							case LPAREN:
							case QUESTION:
								{
								alt199=1;
								}
								break;
							case NAME:
								{
								int LA199_7 = input.LA(6);
								if ( (LA199_7==EOF||LA199_7==AS||LA199_7==COMMA||LA199_7==DOT||LA199_7==FETCH||LA199_7==FULL||LA199_7==GROUP||LA199_7==HAVING||LA199_7==INNER||LA199_7==JOIN||LA199_7==LEFT||LA199_7==LIMIT||LA199_7==LPAREN||LA199_7==NAME||LA199_7==OFFSET||LA199_7==ORDER||LA199_7==RIGHT||LA199_7==RPAREN||LA199_7==SEMICOLON||LA199_7==TABLESAMPLE||LA199_7==UNION||LA199_7==WHERE) ) {
									alt199=1;
								}
								else if ( (LA199_7==STRING_LITERAL) ) {
									alt199=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return ret;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 199, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case DECIMAL:
							case DOUBLE:
							case FALSE:
							case GROUP:
							case NULL:
							case NUMBER:
							case STRING_LITERAL:
							case TRUE:
								{
								alt199=2;
								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return ret;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 199, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
							}
							break;
						case DOT:
						case TO:
							{
							alt199=2;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return ret;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 199, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}

					else {
						if (state.backtracking>0) {state.failed=true; return ret;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 199, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 199, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 199, 0, input);
				throw nvae;
			}

			switch (alt199) {
				case 1 :
					// PhoenixSQL.g:1104:9: t= table_identifier
					{
					pushFollow(FOLLOW_table_identifier_in_table_name8105);
					t=table_identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.table(null, t); }
					}
					break;
				case 2 :
					// PhoenixSQL.g:1105:9: s= table_identifier DOT t= table_identifier
					{
					pushFollow(FOLLOW_table_identifier_in_table_name8119);
					s=table_identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,DOT,FOLLOW_DOT_in_table_name8121); if (state.failed) return ret;
					pushFollow(FOLLOW_table_identifier_in_table_name8125);
					t=table_identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.table(s, t); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "table_name"



	// $ANTLR start "from_table_name"
	// PhoenixSQL.g:1109:1: from_table_name returns [TableName ret] : (t= table_identifier |s= table_identifier DOT t= table_identifier );
	public final TableName from_table_name() throws RecognitionException {
		TableName ret = null;


		String t =null;
		String s =null;

		try {
			// PhoenixSQL.g:1110:5: (t= table_identifier |s= table_identifier DOT t= table_identifier )
			int alt200=2;
			int LA200_0 = input.LA(1);
			if ( (LA200_0==NAME) ) {
				int LA200_1 = input.LA(2);
				if ( (LA200_1==EOF||(LA200_1 >= ACTIVE && LA200_1 <= ALL)||LA200_1==AND||(LA200_1 >= AS && LA200_1 <= ASTERISK)||LA200_1==BETWEEN||(LA200_1 >= CACHE && LA200_1 <= CASCADE)||(LA200_1 >= COLUMNS && LA200_1 <= COMMA)||LA200_1==CONCAT||LA200_1==CONSTRAINT||LA200_1==CYCLE||LA200_1==DESC||LA200_1==DISABLE||LA200_1==DIVIDE||LA200_1==DROP||(LA200_1 >= ELSE && LA200_1 <= END)||LA200_1==EQ||LA200_1==FETCH||(LA200_1 >= FROM && LA200_1 <= FULL)||(LA200_1 >= GROUP && LA200_1 <= HAVING)||LA200_1==ILIKE||LA200_1==IN||(LA200_1 >= INCREMENT && LA200_1 <= INNER)||LA200_1==IS||LA200_1==JOIN||LA200_1==LEFT||(LA200_1 >= LIKE && LA200_1 <= LIMIT)||(LA200_1 >= LPAREN && LA200_1 <= MINVALUE)||LA200_1==NAME||(LA200_1 >= NOEQ1 && LA200_1 <= NOT)||LA200_1==NULLS||(LA200_1 >= OFFSET && LA200_1 <= ON)||(LA200_1 >= OR && LA200_1 <= ORDER)||(LA200_1 >= PERCENT && LA200_1 <= PLUS)||LA200_1==PRIMARY||LA200_1==REBUILD||LA200_1==RIGHT||(LA200_1 >= RPAREN && LA200_1 <= RSQUARE)||(LA200_1 >= SELECT && LA200_1 <= SEMICOLON)||LA200_1==SET||LA200_1==START||LA200_1==TABLESAMPLE||LA200_1==THEN||(LA200_1 >= UNION && LA200_1 <= UNUSABLE)||LA200_1==USABLE||LA200_1==VALUES||(LA200_1 >= WHEN && LA200_1 <= WHERE)) ) {
					alt200=1;
				}
				else if ( (LA200_1==DOT) ) {
					alt200=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 200, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 200, 0, input);
				throw nvae;
			}

			switch (alt200) {
				case 1 :
					// PhoenixSQL.g:1110:9: t= table_identifier
					{
					pushFollow(FOLLOW_table_identifier_in_from_table_name8153);
					t=table_identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.table(null, t); }
					}
					break;
				case 2 :
					// PhoenixSQL.g:1111:9: s= table_identifier DOT t= table_identifier
					{
					pushFollow(FOLLOW_table_identifier_in_from_table_name8167);
					s=table_identifier();
					state._fsp--;
					if (state.failed) return ret;
					match(input,DOT,FOLLOW_DOT_in_from_table_name8169); if (state.failed) return ret;
					pushFollow(FOLLOW_table_identifier_in_from_table_name8173);
					t=table_identifier();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.table(s, t); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "from_table_name"



	// $ANTLR start "table_identifier"
	// PhoenixSQL.g:1114:1: table_identifier returns [String ret] : c= identifier ;
	public final String table_identifier() throws RecognitionException {
		String ret = null;


		String c =null;

		try {
			// PhoenixSQL.g:1115:5: (c= identifier )
			// PhoenixSQL.g:1115:9: c= identifier
			{
			pushFollow(FOLLOW_identifier_in_table_identifier8200);
			c=identifier();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) {
			           if (c.contains(QueryConstants.NAMESPACE_SEPARATOR) ) { throw new RuntimeException("Table or schema name cannot contain colon"); }
			           ret = c;
			    }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "table_identifier"



	// $ANTLR start "literal_or_bind"
	// PhoenixSQL.g:1122:1: literal_or_bind returns [ParseNode ret] : (e= literal |b= bind_name );
	public final ParseNode literal_or_bind() throws RecognitionException {
		ParseNode ret = null;


		LiteralParseNode e =null;
		String b =null;

		try {
			// PhoenixSQL.g:1123:5: (e= literal |b= bind_name )
			int alt201=2;
			int LA201_0 = input.LA(1);
			if ( (LA201_0==DECIMAL||LA201_0==DOUBLE||LA201_0==FALSE||LA201_0==NAME||LA201_0==NULL||LA201_0==NUMBER||LA201_0==STRING_LITERAL||LA201_0==TRUE) ) {
				alt201=1;
			}
			else if ( (LA201_0==BIND_NAME||LA201_0==QUESTION) ) {
				alt201=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 201, 0, input);
				throw nvae;
			}

			switch (alt201) {
				case 1 :
					// PhoenixSQL.g:1123:9: e= literal
					{
					pushFollow(FOLLOW_literal_in_literal_or_bind8232);
					e=literal();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = e; }
					}
					break;
				case 2 :
					// PhoenixSQL.g:1124:9: b= bind_name
					{
					pushFollow(FOLLOW_bind_name_in_literal_or_bind8246);
					b=bind_name();
					state._fsp--;
					if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = factory.bind(b); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "literal_or_bind"



	// $ANTLR start "literal"
	// PhoenixSQL.g:1128:1: literal returns [LiteralParseNode ret] : (s= STRING_LITERAL |n= NUMBER |d= DECIMAL |dbl= DOUBLE | NULL | TRUE | FALSE |dt= identifier t= STRING_LITERAL );
	public final LiteralParseNode literal() throws RecognitionException {
		LiteralParseNode ret = null;


		Token s=null;
		Token n=null;
		Token d=null;
		Token dbl=null;
		Token t=null;
		String dt =null;

		try {
			// PhoenixSQL.g:1129:5: (s= STRING_LITERAL |n= NUMBER |d= DECIMAL |dbl= DOUBLE | NULL | TRUE | FALSE |dt= identifier t= STRING_LITERAL )
			int alt202=8;
			switch ( input.LA(1) ) {
			case STRING_LITERAL:
				{
				alt202=1;
				}
				break;
			case NUMBER:
				{
				alt202=2;
				}
				break;
			case DECIMAL:
				{
				alt202=3;
				}
				break;
			case DOUBLE:
				{
				alt202=4;
				}
				break;
			case NULL:
				{
				alt202=5;
				}
				break;
			case TRUE:
				{
				alt202=6;
				}
				break;
			case FALSE:
				{
				alt202=7;
				}
				break;
			case NAME:
				{
				alt202=8;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 202, 0, input);
				throw nvae;
			}
			switch (alt202) {
				case 1 :
					// PhoenixSQL.g:1129:9: s= STRING_LITERAL
					{
					s=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal8278); if (state.failed) return ret;
					if ( state.backtracking==0 ) {
					            ret = factory.literal(s.getText()); 
					        }
					}
					break;
				case 2 :
					// PhoenixSQL.g:1132:9: n= NUMBER
					{
					n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_literal8292); if (state.failed) return ret;
					if ( state.backtracking==0 ) {
					            ret = factory.wholeNumber(n.getText());
					        }
					}
					break;
				case 3 :
					// PhoenixSQL.g:1135:9: d= DECIMAL
					{
					d=(Token)match(input,DECIMAL,FOLLOW_DECIMAL_in_literal8306); if (state.failed) return ret;
					if ( state.backtracking==0 ) {
					            ret = factory.realNumber(d.getText());
					        }
					}
					break;
				case 4 :
					// PhoenixSQL.g:1138:9: dbl= DOUBLE
					{
					dbl=(Token)match(input,DOUBLE,FOLLOW_DOUBLE_in_literal8321); if (state.failed) return ret;
					if ( state.backtracking==0 ) {
					            ret = factory.literal(Double.valueOf(dbl.getText()));
					        }
					}
					break;
				case 5 :
					// PhoenixSQL.g:1141:9: NULL
					{
					match(input,NULL,FOLLOW_NULL_in_literal8338); if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.literal(null);}
					}
					break;
				case 6 :
					// PhoenixSQL.g:1142:9: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_literal8350); if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.literal(Boolean.TRUE);}
					}
					break;
				case 7 :
					// PhoenixSQL.g:1143:9: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_literal8363); if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.literal(Boolean.FALSE);}
					}
					break;
				case 8 :
					// PhoenixSQL.g:1144:9: dt= identifier t= STRING_LITERAL
					{
					pushFollow(FOLLOW_identifier_in_literal8377);
					dt=identifier();
					state._fsp--;
					if (state.failed) return ret;
					t=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_literal8381); if (state.failed) return ret;
					if ( state.backtracking==0 ) { 
					            try {
					                ret = factory.literal(t.getText(), dt);
					            } catch (SQLException e) {
					                throw new RuntimeException(e);
					            }
					        }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "literal"



	// $ANTLR start "int_or_long_literal"
	// PhoenixSQL.g:1153:1: int_or_long_literal returns [LiteralParseNode ret] : n= NUMBER ;
	public final LiteralParseNode int_or_long_literal() throws RecognitionException {
		LiteralParseNode ret = null;


		Token n=null;

		try {
			// PhoenixSQL.g:1154:5: (n= NUMBER )
			// PhoenixSQL.g:1154:9: n= NUMBER
			{
			n=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_int_or_long_literal8412); if (state.failed) return ret;
			if ( state.backtracking==0 ) {
			            ret = factory.intOrLong(n.getText());
			        }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "int_or_long_literal"



	// $ANTLR start "bind_name"
	// PhoenixSQL.g:1160:1: bind_name returns [String ret] : (n= BIND_NAME | QUESTION );
	public final String bind_name() throws RecognitionException {
		String ret = null;


		Token n=null;

		try {
			// PhoenixSQL.g:1161:5: (n= BIND_NAME | QUESTION )
			int alt203=2;
			int LA203_0 = input.LA(1);
			if ( (LA203_0==BIND_NAME) ) {
				alt203=1;
			}
			else if ( (LA203_0==QUESTION) ) {
				alt203=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 203, 0, input);
				throw nvae;
			}

			switch (alt203) {
				case 1 :
					// PhoenixSQL.g:1161:9: n= BIND_NAME
					{
					n=(Token)match(input,BIND_NAME,FOLLOW_BIND_NAME_in_bind_name8440); if (state.failed) return ret;
					if ( state.backtracking==0 ) { String bind = n.getText().substring(1); updateBind(bind); ret = bind; }
					}
					break;
				case 2 :
					// PhoenixSQL.g:1162:9: QUESTION
					{
					match(input,QUESTION,FOLLOW_QUESTION_in_bind_name8453); if (state.failed) return ret;
					if ( state.backtracking==0 ) { ret = nextBind(); }
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "bind_name"



	// $ANTLR start "identifier"
	// PhoenixSQL.g:1166:1: identifier returns [String ret] : c= parseNoReserved ;
	public final String identifier() throws RecognitionException {
		String ret = null;


		String c =null;

		try {
			// PhoenixSQL.g:1167:5: (c= parseNoReserved )
			// PhoenixSQL.g:1167:9: c= parseNoReserved
			{
			pushFollow(FOLLOW_parseNoReserved_in_identifier8482);
			c=parseNoReserved();
			state._fsp--;
			if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = c; }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "identifier"



	// $ANTLR start "parseNoReserved"
	// PhoenixSQL.g:1170:1: parseNoReserved returns [String ret] : n= NAME ;
	public final String parseNoReserved() throws RecognitionException {
		String ret = null;


		Token n=null;

		try {
			// PhoenixSQL.g:1171:5: (n= NAME )
			// PhoenixSQL.g:1171:9: n= NAME
			{
			n=(Token)match(input,NAME,FOLLOW_NAME_in_parseNoReserved8509); if (state.failed) return ret;
			if ( state.backtracking==0 ) { ret = n.getText(); }
			}

		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "parseNoReserved"



	// $ANTLR start "case_statement"
	// PhoenixSQL.g:1174:1: case_statement returns [ParseNode ret] : ( CASE e1= expression ( WHEN e2= expression THEN t= expression )+ ( ELSE el= expression )? END | CASE ( WHEN c= expression THEN t= expression )+ ( ELSE el= expression )? END );
	public final ParseNode case_statement() throws RecognitionException {
		ParseNode ret = null;


		ParseNode e1 =null;
		ParseNode e2 =null;
		ParseNode t =null;
		ParseNode el =null;
		ParseNode c =null;

		List<ParseNode> w = new ArrayList<ParseNode>(4);
		try {
			// PhoenixSQL.g:1176:5: ( CASE e1= expression ( WHEN e2= expression THEN t= expression )+ ( ELSE el= expression )? END | CASE ( WHEN c= expression THEN t= expression )+ ( ELSE el= expression )? END )
			int alt208=2;
			int LA208_0 = input.LA(1);
			if ( (LA208_0==CASE) ) {
				int LA208_1 = input.LA(2);
				if ( (LA208_1==ARRAY||LA208_1==BIND_NAME||(LA208_1 >= CASE && LA208_1 <= CAST)||LA208_1==CURRENT||LA208_1==DECIMAL||LA208_1==DOUBLE||LA208_1==EXISTS||LA208_1==FALSE||LA208_1==LPAREN||LA208_1==MINUS||(LA208_1 >= NAME && LA208_1 <= NEXT)||(LA208_1 >= NOT && LA208_1 <= NULL)||LA208_1==NUMBER||LA208_1==QUESTION||LA208_1==STRING_LITERAL||LA208_1==TRUE) ) {
					alt208=1;
				}
				else if ( (LA208_1==WHEN) ) {
					alt208=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ret;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 208, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return ret;}
				NoViableAltException nvae =
					new NoViableAltException("", 208, 0, input);
				throw nvae;
			}

			switch (alt208) {
				case 1 :
					// PhoenixSQL.g:1176:7: CASE e1= expression ( WHEN e2= expression THEN t= expression )+ ( ELSE el= expression )? END
					{
					match(input,CASE,FOLLOW_CASE_in_case_statement8536); if (state.failed) return ret;
					pushFollow(FOLLOW_expression_in_case_statement8540);
					e1=expression();
					state._fsp--;
					if (state.failed) return ret;
					// PhoenixSQL.g:1176:26: ( WHEN e2= expression THEN t= expression )+
					int cnt204=0;
					loop204:
					while (true) {
						int alt204=2;
						int LA204_0 = input.LA(1);
						if ( (LA204_0==WHEN) ) {
							alt204=1;
						}

						switch (alt204) {
						case 1 :
							// PhoenixSQL.g:1176:27: WHEN e2= expression THEN t= expression
							{
							match(input,WHEN,FOLLOW_WHEN_in_case_statement8543); if (state.failed) return ret;
							pushFollow(FOLLOW_expression_in_case_statement8547);
							e2=expression();
							state._fsp--;
							if (state.failed) return ret;
							match(input,THEN,FOLLOW_THEN_in_case_statement8549); if (state.failed) return ret;
							pushFollow(FOLLOW_expression_in_case_statement8553);
							t=expression();
							state._fsp--;
							if (state.failed) return ret;
							if ( state.backtracking==0 ) {w.add(t);w.add(factory.equal(e1,e2));}
							}
							break;

						default :
							if ( cnt204 >= 1 ) break loop204;
							if (state.backtracking>0) {state.failed=true; return ret;}
							EarlyExitException eee = new EarlyExitException(204, input);
							throw eee;
						}
						cnt204++;
					}

					// PhoenixSQL.g:1176:106: ( ELSE el= expression )?
					int alt205=2;
					int LA205_0 = input.LA(1);
					if ( (LA205_0==ELSE) ) {
						alt205=1;
					}
					switch (alt205) {
						case 1 :
							// PhoenixSQL.g:1176:107: ELSE el= expression
							{
							match(input,ELSE,FOLLOW_ELSE_in_case_statement8560); if (state.failed) return ret;
							pushFollow(FOLLOW_expression_in_case_statement8564);
							el=expression();
							state._fsp--;
							if (state.failed) return ret;
							if ( state.backtracking==0 ) {w.add(el);}
							}
							break;

					}

					match(input,END,FOLLOW_END_in_case_statement8570); if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.caseWhen(w);}
					}
					break;
				case 2 :
					// PhoenixSQL.g:1177:7: CASE ( WHEN c= expression THEN t= expression )+ ( ELSE el= expression )? END
					{
					match(input,CASE,FOLLOW_CASE_in_case_statement8580); if (state.failed) return ret;
					// PhoenixSQL.g:1177:12: ( WHEN c= expression THEN t= expression )+
					int cnt206=0;
					loop206:
					while (true) {
						int alt206=2;
						int LA206_0 = input.LA(1);
						if ( (LA206_0==WHEN) ) {
							alt206=1;
						}

						switch (alt206) {
						case 1 :
							// PhoenixSQL.g:1177:13: WHEN c= expression THEN t= expression
							{
							match(input,WHEN,FOLLOW_WHEN_in_case_statement8583); if (state.failed) return ret;
							pushFollow(FOLLOW_expression_in_case_statement8587);
							c=expression();
							state._fsp--;
							if (state.failed) return ret;
							match(input,THEN,FOLLOW_THEN_in_case_statement8589); if (state.failed) return ret;
							pushFollow(FOLLOW_expression_in_case_statement8593);
							t=expression();
							state._fsp--;
							if (state.failed) return ret;
							if ( state.backtracking==0 ) {w.add(t);w.add(c);}
							}
							break;

						default :
							if ( cnt206 >= 1 ) break loop206;
							if (state.backtracking>0) {state.failed=true; return ret;}
							EarlyExitException eee = new EarlyExitException(206, input);
							throw eee;
						}
						cnt206++;
					}

					// PhoenixSQL.g:1177:72: ( ELSE el= expression )?
					int alt207=2;
					int LA207_0 = input.LA(1);
					if ( (LA207_0==ELSE) ) {
						alt207=1;
					}
					switch (alt207) {
						case 1 :
							// PhoenixSQL.g:1177:73: ELSE el= expression
							{
							match(input,ELSE,FOLLOW_ELSE_in_case_statement8600); if (state.failed) return ret;
							pushFollow(FOLLOW_expression_in_case_statement8604);
							el=expression();
							state._fsp--;
							if (state.failed) return ret;
							if ( state.backtracking==0 ) {w.add(el);}
							}
							break;

					}

					match(input,END,FOLLOW_END_in_case_statement8610); if (state.failed) return ret;
					if ( state.backtracking==0 ) {ret = factory.caseWhen(w);}
					}
					break;

			}
		}

		    catch (RecognitionException re) {
		        throw re;
		    }

		finally {
			// do for sure before leaving
		}
		return ret;
	}
	// $ANTLR end "case_statement"

	// $ANTLR start synpred1_PhoenixSQL
	public final void synpred1_PhoenixSQL_fragment() throws RecognitionException {
		// PhoenixSQL.g:923:9: ( ( NOT )? boolean_expression )
		// PhoenixSQL.g:923:10: ( NOT )? boolean_expression
		{
		// PhoenixSQL.g:923:10: ( NOT )?
		int alt209=2;
		int LA209_0 = input.LA(1);
		if ( (LA209_0==NOT) ) {
			alt209=1;
		}
		switch (alt209) {
			case 1 :
				// PhoenixSQL.g:923:10: NOT
				{
				match(input,NOT,FOLLOW_NOT_in_synpred1_PhoenixSQL6280); if (state.failed) return;
				}
				break;

		}

		pushFollow(FOLLOW_boolean_expression_in_synpred1_PhoenixSQL6283);
		boolean_expression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred1_PhoenixSQL

	// Delegated rules

	public final boolean synpred1_PhoenixSQL() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_PhoenixSQL_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_oneStatement_in_nextStatement1275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_SEMICOLON_in_nextStatement1279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EOF_in_nextStatement1288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_oneStatement_in_statement1314 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_statement1318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_select_node_in_query1344 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_query1346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_select_node_in_oneStatement1378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_upsert_node_in_oneStatement1388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_delete_node_in_oneStatement1400 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_create_table_node_in_oneStatement1412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_create_schema_node_in_oneStatement1424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_create_view_node_in_oneStatement1436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_create_index_node_in_oneStatement1448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cursor_open_node_in_oneStatement1460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cursor_close_node_in_oneStatement1472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cursor_fetch_node_in_oneStatement1484 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declare_cursor_node_in_oneStatement1496 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_drop_table_node_in_oneStatement1508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_drop_index_node_in_oneStatement1520 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alter_index_node_in_oneStatement1532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alter_table_node_in_oneStatement1544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_trace_node_in_oneStatement1556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_create_function_node_in_oneStatement1568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_drop_function_node_in_oneStatement1580 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_add_jars_node_in_oneStatement1592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_list_jars_node_in_oneStatement1604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_delete_jar_node_in_oneStatement1616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alter_session_node_in_oneStatement1628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_create_sequence_node_in_oneStatement1638 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_grant_permission_node_in_oneStatement1650 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_revoke_permission_node_in_oneStatement1662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_drop_sequence_node_in_oneStatement1672 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_drop_schema_node_in_oneStatement1682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_use_schema_node_in_oneStatement1692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_update_statistics_node_in_oneStatement1704 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_execute_upgrade_node_in_oneStatement1716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_explain_node_in_oneStatement1728 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXPLAIN_in_explain_node1761 = new BitSet(new long[]{0x50401208020000A0L,0x0100000400000102L,0x0000151000010080L});
	public static final BitSet FOLLOW_oneStatement_in_explain_node1765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_table_node1791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L,0x0000000020000000L});
	public static final BitSet FOLLOW_IMMUTABLE_in_create_table_node1796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_TABLE_in_create_table_node1800 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_create_table_node1803 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_NOT_in_create_table_node1805 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_create_table_node1809 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_create_table_node1815 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_create_table_node1827 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_column_defs_in_create_table_node1831 = new BitSet(new long[]{0x0000000420000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_pk_constraint_in_create_table_node1836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_create_table_node1840 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_fam_properties_in_create_table_node1854 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_SPLIT_in_create_table_node1867 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_ON_in_create_table_node1869 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_value_expression_list_in_create_table_node1873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_schema_node1912 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_SCHEMA_in_create_schema_node1914 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_create_schema_node1917 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_NOT_in_create_schema_node1919 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_create_schema_node1923 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_create_schema_node1929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GRANT_in_grant_permission_node1963 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_literal_in_grant_permission_node1967 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_ON_in_grant_permission_node1970 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L,0x0000000020008000L});
	public static final BitSet FOLLOW_TABLE_in_grant_permission_node1974 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_table_name_in_grant_permission_node1980 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_SCHEMA_in_grant_permission_node1986 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_grant_permission_node1990 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_TO_in_grant_permission_node1995 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000201L,0x0000002010000000L});
	public static final BitSet FOLLOW_GROUP_in_grant_permission_node2000 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_literal_in_grant_permission_node2006 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REVOKE_in_revoke_permission_node2040 = new BitSet(new long[]{0x0008010000000000L,0x004A100000000021L,0x0000002010000000L});
	public static final BitSet FOLLOW_literal_in_revoke_permission_node2045 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000020L});
	public static final BitSet FOLLOW_ON_in_revoke_permission_node2050 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L,0x0000000020008000L});
	public static final BitSet FOLLOW_TABLE_in_revoke_permission_node2054 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_table_name_in_revoke_permission_node2060 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_SCHEMA_in_revoke_permission_node2066 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_revoke_permission_node2070 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_FROM_in_revoke_permission_node2075 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000201L,0x0000002010000000L});
	public static final BitSet FOLLOW_GROUP_in_revoke_permission_node2080 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_literal_in_revoke_permission_node2086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_view_node2120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_VIEW_in_create_view_node2122 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_create_view_node2125 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_NOT_in_create_view_node2127 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_create_view_node2131 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_create_view_node2137 = new BitSet(new long[]{0x0000000000000802L,0x0000101000000000L});
	public static final BitSet FOLLOW_LPAREN_in_create_view_node2149 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_column_defs_in_create_view_node2153 = new BitSet(new long[]{0x0000000420000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_pk_constraint_in_create_view_node2158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_create_view_node2162 = new BitSet(new long[]{0x0000000000000802L,0x0000100000000000L});
	public static final BitSet FOLLOW_AS_in_create_view_node2176 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_SELECT_in_create_view_node2178 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ASTERISK_in_create_view_node2180 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_FROM_in_create_view_node2192 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_create_view_node2196 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_WHERE_in_create_view_node2209 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_create_view_node2213 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
	public static final BitSet FOLLOW_fam_properties_in_create_view_node2231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_index_node2267 = new BitSet(new long[]{0x0000000000000000L,0x0000000800100000L});
	public static final BitSet FOLLOW_LOCAL_in_create_index_node2271 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_INDEX_in_create_index_node2274 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_create_index_node2277 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_NOT_in_create_index_node2279 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_create_index_node2283 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_index_name_in_create_index_node2289 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_ON_in_create_index_node2291 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_create_index_node2295 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_create_index_node2306 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_ik_constraint_in_create_index_node2310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_create_index_node2312 = new BitSet(new long[]{0x0000000000004002L,0x0000100000040000L,0x0000000002000000L});
	public static final BitSet FOLLOW_INCLUDE_in_create_index_node2324 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_create_index_node2327 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_column_names_in_create_index_node2331 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_create_index_node2333 = new BitSet(new long[]{0x0000000000004002L,0x0000100000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_ASYNC_in_create_index_node2349 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_fam_properties_in_create_index_node2364 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_SPLIT_in_create_index_node2377 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_ON_in_create_index_node2379 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_value_expression_list_in_create_index_node2383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_sequence_node2419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_SEQUENCE_in_create_sequence_node2421 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_create_sequence_node2425 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_NOT_in_create_sequence_node2427 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_create_sequence_node2431 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_create_sequence_node2437 = new BitSet(new long[]{0x0000004000080002L,0x0000028000080000L,0x0000000004000000L});
	public static final BitSet FOLLOW_START_in_create_sequence_node2448 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0008002010000004L});
	public static final BitSet FOLLOW_WITH_in_create_sequence_node2450 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_create_sequence_node2455 = new BitSet(new long[]{0x0000004000080002L,0x0000028000080000L});
	public static final BitSet FOLLOW_INCREMENT_in_create_sequence_node2468 = new BitSet(new long[]{0x0008011000660400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_BY_in_create_sequence_node2470 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_create_sequence_node2475 = new BitSet(new long[]{0x0000004000080002L,0x0000028000000000L});
	public static final BitSet FOLLOW_MINVALUE_in_create_sequence_node2488 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_create_sequence_node2492 = new BitSet(new long[]{0x0000004000080002L,0x0000008000000000L});
	public static final BitSet FOLLOW_MAXVALUE_in_create_sequence_node2505 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_create_sequence_node2509 = new BitSet(new long[]{0x0000004000080002L});
	public static final BitSet FOLLOW_CYCLE_in_create_sequence_node2524 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_CACHE_in_create_sequence_node2538 = new BitSet(new long[]{0x0000000000020000L,0x0008000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_int_literal_or_bind_in_create_sequence_node2542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_int_or_long_literal_in_int_literal_or_bind2573 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bind_expression_in_int_literal_or_bind2585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_drop_sequence_node2611 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
	public static final BitSet FOLLOW_SEQUENCE_in_drop_sequence_node2613 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_drop_sequence_node2617 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_drop_sequence_node2621 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_drop_sequence_node2627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_pk_constraint2656 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_CONSTRAINT_in_pk_constraint2659 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_pk_constraint2663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_PRIMARY_in_pk_constraint2665 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_KEY_in_pk_constraint2667 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_pk_constraint2669 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_col_name_with_sort_order_rowtimestamp_list_in_pk_constraint2673 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_pk_constraint2675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_col_name_with_sort_order_rowtimestamp_in_col_name_with_sort_order_rowtimestamp_list2706 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_col_name_with_sort_order_rowtimestamp_list2712 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_col_name_with_sort_order_rowtimestamp_in_col_name_with_sort_order_rowtimestamp_list2718 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_identifier_in_col_name_with_sort_order_rowtimestamp2745 = new BitSet(new long[]{0x0000200000001002L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_ASC_in_col_name_with_sort_order_rowtimestamp2750 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_DESC_in_col_name_with_sort_order_rowtimestamp2754 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_ROW_TIMESTAMP_in_col_name_with_sort_order_rowtimestamp2761 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_with_sort_order_list_in_ik_constraint2796 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_with_sort_order_in_expression_with_sort_order_list2823 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_expression_with_sort_order_list2829 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_with_sort_order_in_expression_with_sort_order_list2835 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_expression_in_expression_with_sort_order2862 = new BitSet(new long[]{0x0000200000001002L});
	public static final BitSet FOLLOW_ASC_in_expression_with_sort_order2868 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DESC_in_expression_with_sort_order2872 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fam_prop_name_in_fam_properties2900 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_fam_properties2902 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_prop_value_in_fam_properties2906 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_fam_properties2912 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_fam_prop_name_in_fam_properties2916 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_fam_properties2918 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_prop_value_in_fam_properties2922 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_identifier_in_fam_prop_name2952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_fam_prop_name2966 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_fam_prop_name2968 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_fam_prop_name2972 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_prop_value3003 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_prop_value3017 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_column_name3048 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_column_name3062 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_column_name3064 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_column_name3068 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_name_in_column_names3100 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_column_names3106 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_column_name_in_column_names3112 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_DROP_in_drop_table_node3139 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000020000000L});
	public static final BitSet FOLLOW_VIEW_in_drop_table_node3144 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_TABLE_in_drop_table_node3148 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_drop_table_node3152 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_drop_table_node3156 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_drop_table_node3162 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_CASCADE_in_drop_table_node3167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_drop_schema_node3202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_SCHEMA_in_drop_schema_node3204 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_drop_schema_node3207 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_drop_schema_node3211 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_drop_schema_node3217 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_CASCADE_in_drop_schema_node3222 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_drop_index_node3257 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_INDEX_in_drop_index_node3259 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_drop_index_node3262 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_drop_index_node3266 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_index_name_in_drop_index_node3272 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_ON_in_drop_index_node3274 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_drop_index_node3278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALTER_in_alter_index_node3308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_INDEX_in_alter_index_node3310 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_alter_index_node3313 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_alter_index_node3317 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_index_name_in_alter_index_node3323 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_ON_in_alter_index_node3325 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_alter_index_node3329 = new BitSet(new long[]{0x0000800000000010L,0x0000000000000000L,0x0000088000000010L});
	public static final BitSet FOLLOW_set_in_alter_index_node3341 = new BitSet(new long[]{0x0000000000004002L,0x0000100000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_ASYNC_in_alter_index_node3365 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_SET_in_alter_index_node3371 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_fam_properties_in_alter_index_node3376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRACE_in_trace_node3411 = new BitSet(new long[]{0x0000000000000000L,0x0050000000000000L});
	public static final BitSet FOLLOW_ON_in_trace_node3419 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_WITH_in_trace_node3424 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_SAMPLING_in_trace_node3426 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_sampling_rate_in_trace_node3432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OFF_in_trace_node3443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_in_create_function_node3477 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000080L,0x0000000100000000L});
	public static final BitSet FOLLOW_OR_in_create_function_node3480 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_REPLACE_in_create_function_node3484 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L,0x0000000100000000L});
	public static final BitSet FOLLOW_TEMPORARY_in_create_function_node3491 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_FUNCTION_in_create_function_node3495 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_create_function_node3499 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_create_function_node3510 = new BitSet(new long[]{0x0000000020000000L,0x0000100000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_zero_or_more_data_types_in_create_function_node3514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_create_function_node3516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_RETURNS_in_create_function_node3526 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_create_function_node3530 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_AS_in_create_function_node3532 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_jar_path_in_create_function_node3538 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_USING_in_create_function_node3549 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_JAR_in_create_function_node3551 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_jar_path_in_create_function_node3558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_jar_path3595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_in_drop_function_node3618 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_FUNCTION_in_drop_function_node3620 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_drop_function_node3623 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_drop_function_node3627 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_drop_function_node3633 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_in_add_jars_node3656 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_JARS_in_add_jars_node3658 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_one_or_more_jarpaths_in_add_jars_node3664 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LIST_in_list_jars_node3687 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_JARS_in_list_jars_node3689 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_delete_jar_node3712 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_JAR_in_delete_jar_node3714 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_jar_path_in_delete_jar_node3720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALTER_in_alter_session_node3746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_SESSION_in_alter_session_node3748 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_SET_in_alter_session_node3751 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_properties_in_alter_session_node3755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALTER_in_alter_table_node3789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0001000020000000L});
	public static final BitSet FOLLOW_TABLE_in_alter_table_node3792 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_VIEW_in_alter_table_node3798 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_alter_table_node3803 = new BitSet(new long[]{0x0040000000000020L,0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_DROP_in_alter_table_node3816 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_COLUMN_in_alter_table_node3818 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_alter_table_node3821 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_alter_table_node3825 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_column_names_in_alter_table_node3831 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ADD_in_alter_table_node3837 = new BitSet(new long[]{0x0000000000000000L,0x0000100000002000L});
	public static final BitSet FOLLOW_IF_in_alter_table_node3840 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_NOT_in_alter_table_node3842 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_EXISTS_in_alter_table_node3846 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_column_defs_in_alter_table_node3853 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
	public static final BitSet FOLLOW_fam_properties_in_alter_table_node3859 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_alter_table_node3867 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_fam_properties_in_alter_table_node3872 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_update_statistics_node3906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_STATISTICS_in_update_statistics_node3908 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_update_statistics_node3912 = new BitSet(new long[]{0x0000000010000042L,0x0000000000100000L,0x0000000000100000L});
	public static final BitSet FOLLOW_INDEX_in_update_statistics_node3917 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_ALL_in_update_statistics_node3923 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_COLUMNS_in_update_statistics_node3929 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_SET_in_update_statistics_node3934 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_properties_in_update_statistics_node3939 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXECUTE_in_execute_upgrade_node3963 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_UPGRADE_in_execute_upgrade_node3965 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_prop_name3991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_prop_name_in_properties4025 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_properties4027 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_prop_value_in_properties4031 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_properties4037 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_prop_name_in_properties4041 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_properties4043 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_prop_value_in_properties4047 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_column_def_in_column_defs4082 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_column_defs4088 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_column_def_in_column_defs4094 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_column_name_in_column_def4120 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_column_def4124 = new BitSet(new long[]{0x0000040000000402L,0x0003003000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_column_def4127 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_column_def4131 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_column_def4134 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_column_def4138 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_column_def4142 = new BitSet(new long[]{0x0000040000000402L,0x0003002000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_column_def4148 = new BitSet(new long[]{0x0000040000000002L,0x0003002000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_LSQUARE_in_column_def4154 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_NUMBER_in_column_def4159 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_RSQUARE_in_column_def4163 = new BitSet(new long[]{0x0000040000000002L,0x0003000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_column_def4170 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_NULL_in_column_def4175 = new BitSet(new long[]{0x0000040000000002L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_DEFAULT_in_column_def4180 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_column_def4184 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_PRIMARY_in_column_def4191 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_KEY_in_column_def4193 = new BitSet(new long[]{0x0000200000001002L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_ASC_in_column_def4198 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_DESC_in_column_def4202 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_ROW_TIMESTAMP_in_column_def4208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dyn_column_def_in_dyn_column_defs4251 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_dyn_column_defs4257 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_dyn_column_def_in_dyn_column_defs4263 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_column_name_in_dyn_column_def4289 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_dyn_column_def4293 = new BitSet(new long[]{0x0000000000000402L,0x0000003000000000L});
	public static final BitSet FOLLOW_LPAREN_in_dyn_column_def4296 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_dyn_column_def4300 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_dyn_column_def4303 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_dyn_column_def4307 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_dyn_column_def4311 = new BitSet(new long[]{0x0000000000000402L,0x0000002000000000L});
	public static final BitSet FOLLOW_ARRAY_in_dyn_column_def4317 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
	public static final BitSet FOLLOW_LSQUARE_in_dyn_column_def4323 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_NUMBER_in_dyn_column_def4328 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_RSQUARE_in_dyn_column_def4332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_name_in_dyn_column_name_or_def4369 = new BitSet(new long[]{0x0000000000000002L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_dyn_column_name_or_def4374 = new BitSet(new long[]{0x0000000000000402L,0x0000003000000000L});
	public static final BitSet FOLLOW_LPAREN_in_dyn_column_name_or_def4377 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_dyn_column_name_or_def4381 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_dyn_column_name_or_def4384 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_dyn_column_name_or_def4388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_dyn_column_name_or_def4392 = new BitSet(new long[]{0x0000000000000402L,0x0000002000000000L});
	public static final BitSet FOLLOW_ARRAY_in_dyn_column_name_or_def4398 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
	public static final BitSet FOLLOW_LSQUARE_in_dyn_column_name_or_def4404 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_NUMBER_in_dyn_column_name_or_def4409 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_RSQUARE_in_dyn_column_name_or_def4413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_select_node_in_subquery_expression4453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_single_select4486 = new BitSet(new long[]{0x2009011000622440L,0x000B391000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_hintClause_in_single_select4491 = new BitSet(new long[]{0x2009011000622440L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_DISTINCT_in_single_select4507 = new BitSet(new long[]{0x2008011000622400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_ALL_in_single_select4511 = new BitSet(new long[]{0x2008011000622400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_select_list_in_single_select4517 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000A20L,0x0004000000000000L});
	public static final BitSet FOLLOW_FROM_in_single_select4528 = new BitSet(new long[]{0x0000000000020000L,0x0000101000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_parseFrom_in_single_select4532 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000A00L,0x0004000000000000L});
	public static final BitSet FOLLOW_WHERE_in_single_select4545 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_single_select4549 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000A00L});
	public static final BitSet FOLLOW_GROUP_in_single_select4562 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_BY_in_single_select4564 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_group_by_in_single_select4568 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
	public static final BitSet FOLLOW_HAVING_in_single_select4581 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_single_select4585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_single_select_in_unioned_selects4629 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_UNION_in_unioned_selects4634 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ALL_in_unioned_selects4636 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_single_select_in_unioned_selects4640 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_unioned_selects_in_select_node4678 = new BitSet(new long[]{0x0000000000000002L,0x0420000200000002L});
	public static final BitSet FOLLOW_ORDER_in_select_node4689 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_BY_in_select_node4691 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_order_by_in_select_node4695 = new BitSet(new long[]{0x0000000000000002L,0x0020000200000002L});
	public static final BitSet FOLLOW_LIMIT_in_select_node4708 = new BitSet(new long[]{0x0000000000020000L,0x0008000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_limit_in_select_node4712 = new BitSet(new long[]{0x0000000000000002L,0x0020000000000002L});
	public static final BitSet FOLLOW_OFFSET_in_select_node4725 = new BitSet(new long[]{0x0000000000020000L,0x0008000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_offset_in_select_node4729 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L,0x0000000000000600L});
	public static final BitSet FOLLOW_FETCH_in_select_node4751 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000008L});
	public static final BitSet FOLLOW_set_in_select_node4753 = new BitSet(new long[]{0x0000000000020000L,0x0008000000000000L,0x0000000000000604L});
	public static final BitSet FOLLOW_limit_in_select_node4764 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000600L});
	public static final BitSet FOLLOW_set_in_select_node4768 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_ONLY_in_select_node4776 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPSERT_in_upsert_node4815 = new BitSet(new long[]{0x0000000000000000L,0x0000080000400000L});
	public static final BitSet FOLLOW_hintClause_in_upsert_node4820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_INTO_in_upsert_node4824 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_upsert_node4828 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L,0x0000800000010000L});
	public static final BitSet FOLLOW_LPAREN_in_upsert_node4839 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_upsert_column_refs_in_upsert_node4843 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_upsert_node4845 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000800000010000L});
	public static final BitSet FOLLOW_VALUES_in_upsert_node4859 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_upsert_node4861 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_one_or_more_expressions_in_upsert_node4865 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_upsert_node4867 = new BitSet(new long[]{0x0000000000000002L,0x0040000000000000L});
	public static final BitSet FOLLOW_ON_in_upsert_node4871 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_DUPLICATE_in_upsert_node4873 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_KEY_in_upsert_node4875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L,0x0000010000000000L});
	public static final BitSet FOLLOW_IGNORE_in_upsert_node4881 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_upsert_node4887 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_update_column_pairs_in_upsert_node4891 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_select_node_in_upsert_node4906 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_update_column_pair_in_update_column_pairs4947 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_update_column_pairs4959 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_update_column_pair_in_update_column_pairs4963 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_column_name_in_update_column_pair4988 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_update_column_pair4990 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_update_column_pair4994 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dyn_column_name_or_def_in_upsert_column_refs5023 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_upsert_column_refs5036 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_dyn_column_name_or_def_in_upsert_column_refs5040 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_DECLARE_in_declare_cursor_node5068 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_cursor_name_in_declare_cursor_node5072 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_CURSOR_in_declare_cursor_node5074 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_FOR_in_declare_cursor_node5076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_select_node_in_declare_cursor_node5080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OPEN_in_cursor_open_node5114 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_cursor_name_in_cursor_open_node5118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CLOSE_in_cursor_close_node5145 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_cursor_name_in_cursor_close_node5149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FETCH_in_cursor_fetch_node5175 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_NEXT_in_cursor_fetch_node5177 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000020L,0x0000000000000600L});
	public static final BitSet FOLLOW_NUMBER_in_cursor_fetch_node5182 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L,0x0000000000000600L});
	public static final BitSet FOLLOW_FROM_in_cursor_fetch_node5193 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_cursor_name_in_cursor_fetch_node5197 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DELETE_in_delete_node5223 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000020L});
	public static final BitSet FOLLOW_hintClause_in_delete_node5228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_FROM_in_delete_node5232 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_delete_node5236 = new BitSet(new long[]{0x0000000000000002L,0x0400000200000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_WHERE_in_delete_node5247 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_delete_node5251 = new BitSet(new long[]{0x0000000000000002L,0x0400000200000000L});
	public static final BitSet FOLLOW_ORDER_in_delete_node5264 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_BY_in_delete_node5266 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_order_by_in_delete_node5270 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
	public static final BitSet FOLLOW_LIMIT_in_delete_node5283 = new BitSet(new long[]{0x0000000000020000L,0x0008000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_limit_in_delete_node5287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bind_expression_in_limit5322 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_int_or_long_literal_in_limit5334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bind_expression_in_offset5360 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_int_or_long_literal_in_offset5372 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_sampling_rate5397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_tableSampleNode5422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ML_HINT_in_hintClause5448 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectable_in_select_list5480 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_select_list5485 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_selectable_in_select_list5489 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_ASTERISK_in_select_list5501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_selectable5530 = new BitSet(new long[]{0x0000000000000802L,0x0000100000000000L});
	public static final BitSet FOLLOW_parseAlias_in_selectable5535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_selectable5550 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_selectable5552 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ASTERISK_in_selectable5554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_selectable5569 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_selectable5571 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_selectable5575 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_selectable5577 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ASTERISK_in_selectable5579 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_group_by5612 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_group_by5625 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_group_by5631 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_parseOrderByField_in_order_by5665 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_order_by5678 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_parseOrderByField_in_order_by5684 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_expression_in_parseOrderByField5721 = new BitSet(new long[]{0x0000200000001002L,0x0004000000000000L});
	public static final BitSet FOLLOW_ASC_in_parseOrderByField5733 = new BitSet(new long[]{0x0000000000000002L,0x0004000000000000L});
	public static final BitSet FOLLOW_DESC_in_parseOrderByField5739 = new BitSet(new long[]{0x0000000000000002L,0x0004000000000000L});
	public static final BitSet FOLLOW_NULLS_in_parseOrderByField5754 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000008L});
	public static final BitSet FOLLOW_FIRST_in_parseOrderByField5757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LAST_in_parseOrderByField5763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_list_in_parseFrom5803 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_ref_in_table_list5834 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_table_list5839 = new BitSet(new long[]{0x0000000000020000L,0x0000101000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_table_ref_in_table_list5843 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_table_factor_in_table_ref5867 = new BitSet(new long[]{0x0000000000000002L,0x0000000044200040L,0x0000000000000100L});
	public static final BitSet FOLLOW_join_type_in_table_ref5874 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_JOIN_in_table_ref5876 = new BitSet(new long[]{0x0000000000020000L,0x0000101000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_table_factor_in_table_ref5880 = new BitSet(new long[]{0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_ON_in_table_ref5882 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_table_ref5886 = new BitSet(new long[]{0x0000000000000002L,0x0000000044200040L,0x0000000000000100L});
	public static final BitSet FOLLOW_LPAREN_in_table_factor5910 = new BitSet(new long[]{0x0000000000020000L,0x0000101000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_table_list_in_table_factor5914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_table_factor5916 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bind_name_in_table_factor5930 = new BitSet(new long[]{0x0000000000000802L,0x0000100000000000L});
	public static final BitSet FOLLOW_AS_in_table_factor5934 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_table_factor5940 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_from_table_name_in_table_factor5957 = new BitSet(new long[]{0x0000000000000802L,0x0000101000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_AS_in_table_factor5961 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_table_factor5967 = new BitSet(new long[]{0x0000000000000002L,0x0000001000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_LPAREN_in_table_factor5972 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_dyn_column_defs_in_table_factor5976 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_table_factor5978 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_TABLESAMPLE_in_table_factor5983 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_table_factor5985 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_tableSampleNode_in_table_factor5989 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_table_factor5991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_table_factor6005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_select_node_in_table_factor6009 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_table_factor6011 = new BitSet(new long[]{0x0000000000000802L,0x0000100000000000L});
	public static final BitSet FOLLOW_AS_in_table_factor6015 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_table_factor6021 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INNER_in_join_type6048 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LEFT_in_join_type6063 = new BitSet(new long[]{0x0000000000000002L,0x1000000000000000L});
	public static final BitSet FOLLOW_OUTER_in_join_type6065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RIGHT_in_join_type6080 = new BitSet(new long[]{0x0000000000000002L,0x1000000000000000L});
	public static final BitSet FOLLOW_OUTER_in_join_type6082 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FULL_in_join_type6096 = new BitSet(new long[]{0x0000000000000002L,0x1000000000000000L});
	public static final BitSet FOLLOW_OUTER_in_join_type6099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AS_in_parseAlias6130 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_parseNoReserved_in_parseAlias6135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_or_expression_in_expression6163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_and_expression_in_or_expression6195 = new BitSet(new long[]{0x0000000000000002L,0x0200000000000000L});
	public static final BitSet FOLLOW_OR_in_or_expression6200 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_and_expression_in_or_expression6204 = new BitSet(new long[]{0x0000000000000002L,0x0200000000000000L});
	public static final BitSet FOLLOW_not_expression_in_and_expression6240 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_AND_in_and_expression6245 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_not_expression_in_and_expression6249 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_NOT_in_not_expression6291 = new BitSet(new long[]{0x2008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_boolean_expression_in_not_expression6296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_not_expression6310 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_not_expression6313 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_not_expression6317 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_not_expression6319 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EQ_in_comparison_op6339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LT_in_comparison_op6346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GT_in_comparison_op6353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LT_in_comparison_op6360 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_comparison_op6362 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GT_in_comparison_op6369 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_comparison_op6371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_comparison_op6378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_expression_in_boolean_expression6409 = new BitSet(new long[]{0x0800000000010002L,0x0001C04100828400L});
	public static final BitSet FOLLOW_comparison_op_in_boolean_expression6415 = new BitSet(new long[]{0x0008011000620640L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_boolean_expression6420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_boolean_expression6425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_subquery_expression_in_boolean_expression6429 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_boolean_expression6431 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_boolean_expression6440 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_ANY_in_boolean_expression6446 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_boolean_expression6449 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_boolean_expression6453 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_boolean_expression6455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_boolean_expression6465 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_ANY_in_boolean_expression6471 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_boolean_expression6474 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_subquery_expression_in_boolean_expression6478 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_boolean_expression6480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IS_in_boolean_expression6510 = new BitSet(new long[]{0x0000000000000000L,0x0003000000000000L});
	public static final BitSet FOLLOW_NOT_in_boolean_expression6514 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_NULL_in_boolean_expression6517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_boolean_expression6548 = new BitSet(new long[]{0x0000000000010000L,0x0000000100028000L});
	public static final BitSet FOLLOW_LIKE_in_boolean_expression6553 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_boolean_expression6557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ILIKE_in_boolean_expression6595 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_boolean_expression6599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BETWEEN_in_boolean_expression6637 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_boolean_expression6641 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_AND_in_boolean_expression6643 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_boolean_expression6647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IN_in_boolean_expression6686 = new BitSet(new long[]{0x0000000000020000L,0x0000001000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_bind_expression_in_boolean_expression6692 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_boolean_expression6733 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_subquery_expression_in_boolean_expression6737 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_boolean_expression6739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_boolean_expression6780 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_one_or_more_expressions_in_boolean_expression6784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_boolean_expression6786 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXISTS_in_boolean_expression6886 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_boolean_expression6888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_subquery_expression_in_boolean_expression6892 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_boolean_expression6894 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bind_name_in_bind_expression6922 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_add_expression_in_value_expression6953 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subtract_expression_in_add_expression6984 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
	public static final BitSet FOLLOW_PLUS_in_add_expression6989 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_subtract_expression_in_add_expression6993 = new BitSet(new long[]{0x0000000000000002L,0x8000000000000000L});
	public static final BitSet FOLLOW_concat_expression_in_subtract_expression7028 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
	public static final BitSet FOLLOW_MINUS_in_subtract_expression7033 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_concat_expression_in_subtract_expression7037 = new BitSet(new long[]{0x0000000000000002L,0x0000010000000000L});
	public static final BitSet FOLLOW_multiply_divide_modulo_expression_in_concat_expression7072 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_CONCAT_in_concat_expression7077 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_multiply_divide_modulo_expression_in_concat_expression7081 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_negate_expression_in_multiply_divide_modulo_expression7116 = new BitSet(new long[]{0x0002000000002002L,0x4000000000000000L});
	public static final BitSet FOLLOW_set_in_multiply_divide_modulo_expression7132 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_negate_expression_in_multiply_divide_modulo_expression7146 = new BitSet(new long[]{0x0002000000002002L,0x4000000000000000L});
	public static final BitSet FOLLOW_USE_in_use_schema_node7189 = new BitSet(new long[]{0x0000040000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_DEFAULT_in_use_schema_node7192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_use_schema_node7198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_negate_expression7234 = new BitSet(new long[]{0x0008011000620400L,0x000A301000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_array_expression_in_negate_expression7239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_array_expression7267 = new BitSet(new long[]{0x0000000000000002L,0x0000002000000000L});
	public static final BitSet FOLLOW_LSQUARE_in_array_expression7270 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_array_expression7274 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_RSQUARE_in_array_expression7276 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_or_bind_in_term7309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_term7323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_in_term7337 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_LSQUARE_in_term7339 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_one_or_more_expressions_in_term7343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_RSQUARE_in_term7345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_name_in_term7359 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_term7361 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_term7365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_term7379 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_term7381 = new BitSet(new long[]{0x2008011020620400L,0x000B311000000001L,0x0000002010001004L});
	public static final BitSet FOLLOW_zero_or_more_expressions_in_term7385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_term7387 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_WITHIN_in_term7392 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_GROUP_in_term7394 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_term7396 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_ORDER_in_term7398 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_BY_in_term7400 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_one_or_more_expressions_in_term7404 = new BitSet(new long[]{0x0000200000001000L});
	public static final BitSet FOLLOW_ASC_in_term7409 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_DESC_in_term7413 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_term7416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_term7441 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_term7443 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_ASTERISK_in_term7447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_term7449 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_term7473 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_term7475 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_DISTINCT_in_term7479 = new BitSet(new long[]{0x2008011020620400L,0x000B311000000001L,0x0000002010001004L});
	public static final BitSet FOLLOW_zero_or_more_expressions_in_term7483 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_term7485 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_case_statement_in_term7508 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_term7520 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_one_or_more_expressions_in_term7524 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_term7526 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CAST_in_term7544 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_LPAREN_in_term7546 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_term7550 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_AS_in_term7552 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_identifier_in_term7556 = new BitSet(new long[]{0x0000000000000400L,0x0000003000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_LPAREN_in_term7559 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_term7563 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_term7566 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_term7570 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_term7574 = new BitSet(new long[]{0x0000000000000400L,0x0000002000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_ARRAY_in_term7581 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_LSQUARE_in_term7586 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_RSQUARE_in_term7588 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_term7593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEXT_in_term7616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_CURRENT_in_term7620 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000400000000000L});
	public static final BitSet FOLLOW_VALUE_in_term7623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_FOR_in_term7625 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_term7629 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEXT_in_term7657 = new BitSet(new long[]{0x0008010000020000L,0x000A100000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_literal_or_bind_in_term7662 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_VALUES_in_term7664 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_FOR_in_term7666 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_from_table_name_in_term7670 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_one_or_more_expressions7715 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_one_or_more_expressions7721 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_one_or_more_expressions7727 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_jar_path_in_one_or_more_jarpaths7758 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_one_or_more_jarpaths7764 = new BitSet(new long[]{0x0008010000000000L,0x000A100000000001L,0x0000002010000000L});
	public static final BitSet FOLLOW_jar_path_in_one_or_more_jarpaths7770 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_expression_in_zero_or_more_expressions7803 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_zero_or_more_expressions7811 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_zero_or_more_expressions7817 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_function_argument_in_zero_or_more_data_types7848 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_COMMA_in_zero_or_more_data_types7855 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_function_argument_in_zero_or_more_data_types7861 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_identifier_in_function_argument7886 = new BitSet(new long[]{0x0000080200000402L,0x000002B000000000L});
	public static final BitSet FOLLOW_LPAREN_in_function_argument7889 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_function_argument7893 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_function_argument7896 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_NUMBER_in_function_argument7900 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_function_argument7904 = new BitSet(new long[]{0x0000080200000402L,0x000002A000000000L});
	public static final BitSet FOLLOW_ARRAY_in_function_argument7910 = new BitSet(new long[]{0x0000080200000002L,0x000002A000000000L});
	public static final BitSet FOLLOW_LSQUARE_in_function_argument7916 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_NUMBER_in_function_argument7921 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_RSQUARE_in_function_argument7925 = new BitSet(new long[]{0x0000080200000002L,0x0000028000000000L});
	public static final BitSet FOLLOW_CONSTANT_in_function_argument7934 = new BitSet(new long[]{0x0000080000000002L,0x0000028000000000L});
	public static final BitSet FOLLOW_DEFAULTVALUE_in_function_argument7939 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_function_argument7941 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_function_argument7947 = new BitSet(new long[]{0x0000000000000002L,0x0000028000000000L});
	public static final BitSet FOLLOW_MINVALUE_in_function_argument7952 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_function_argument7954 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_function_argument7960 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
	public static final BitSet FOLLOW_MAXVALUE_in_function_argument7966 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_EQ_in_function_argument7968 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_function_argument7974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_value_expression_list8004 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_value_expression_list8010 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_COMMA_in_value_expression_list8016 = new BitSet(new long[]{0x0008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_value_expression_in_value_expression_list8022 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_RPAREN_in_value_expression_list8029 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_index_name8050 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_cursor_name8077 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_identifier_in_table_name8105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_identifier_in_table_name8119 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_table_name8121 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_table_identifier_in_table_name8125 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_identifier_in_from_table_name8153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_identifier_in_from_table_name8167 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_DOT_in_from_table_name8169 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_table_identifier_in_from_table_name8173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_table_identifier8200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_literal_in_literal_or_bind8232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_bind_name_in_literal_or_bind8246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_literal8278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_literal8292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DECIMAL_in_literal8306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DOUBLE_in_literal8321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NULL_in_literal8338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_literal8350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_literal8363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_literal8377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_literal8381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUMBER_in_int_or_long_literal8412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BIND_NAME_in_bind_name8440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUESTION_in_bind_name8453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_parseNoReserved_in_identifier8482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NAME_in_parseNoReserved8509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CASE_in_case_statement8536 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_case_statement8540 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_WHEN_in_case_statement8543 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_case_statement8547 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_THEN_in_case_statement8549 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_case_statement8553 = new BitSet(new long[]{0x0300000000000000L,0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_ELSE_in_case_statement8560 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_case_statement8564 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_END_in_case_statement8570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CASE_in_case_statement8580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_WHEN_in_case_statement8583 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_case_statement8587 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_THEN_in_case_statement8589 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_case_statement8593 = new BitSet(new long[]{0x0300000000000000L,0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_ELSE_in_case_statement8600 = new BitSet(new long[]{0x2008011000620400L,0x000B311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_expression_in_case_statement8604 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_END_in_case_statement8610 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_synpred1_PhoenixSQL6280 = new BitSet(new long[]{0x2008011000620400L,0x000A311000000001L,0x0000002010000004L});
	public static final BitSet FOLLOW_boolean_expression_in_synpred1_PhoenixSQL6283 = new BitSet(new long[]{0x0000000000000002L});
}
