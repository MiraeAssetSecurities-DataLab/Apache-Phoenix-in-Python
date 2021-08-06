// $ANTLR 3.5.2 PhoenixSQL.g 2021-06-29 11:06:46

/**
 * Copyright 2010 The Apache Software Foundation
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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PhoenixSQLLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public PhoenixSQLLexer() {} 
	public PhoenixSQLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public PhoenixSQLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "PhoenixSQL.g"; }

	// $ANTLR start "ACTIVE"
	public final void mACTIVE() throws RecognitionException {
		try {
			int _type = ACTIVE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:29:8: ( 'active' )
			// PhoenixSQL.g:29:10: 'active'
			{
			match("active"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ACTIVE"

	// $ANTLR start "ADD"
	public final void mADD() throws RecognitionException {
		try {
			int _type = ADD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:30:5: ( 'add' )
			// PhoenixSQL.g:30:7: 'add'
			{
			match("add"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ADD"

	// $ANTLR start "ALL"
	public final void mALL() throws RecognitionException {
		try {
			int _type = ALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:31:5: ( 'all' )
			// PhoenixSQL.g:31:7: 'all'
			{
			match("all"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALL"

	// $ANTLR start "ALTER"
	public final void mALTER() throws RecognitionException {
		try {
			int _type = ALTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:32:7: ( 'alter' )
			// PhoenixSQL.g:32:9: 'alter'
			{
			match("alter"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALTER"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:33:5: ( 'and' )
			// PhoenixSQL.g:33:7: 'and'
			{
			match("and"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "ANY"
	public final void mANY() throws RecognitionException {
		try {
			int _type = ANY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:34:5: ( 'any' )
			// PhoenixSQL.g:34:7: 'any'
			{
			match("any"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ANY"

	// $ANTLR start "ARRAY"
	public final void mARRAY() throws RecognitionException {
		try {
			int _type = ARRAY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:35:7: ( 'array' )
			// PhoenixSQL.g:35:9: 'array'
			{
			match("array"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARRAY"

	// $ANTLR start "AS"
	public final void mAS() throws RecognitionException {
		try {
			int _type = AS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:36:4: ( 'as' )
			// PhoenixSQL.g:36:6: 'as'
			{
			match("as"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AS"

	// $ANTLR start "ASC"
	public final void mASC() throws RecognitionException {
		try {
			int _type = ASC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:37:5: ( 'asc' )
			// PhoenixSQL.g:37:7: 'asc'
			{
			match("asc"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASC"

	// $ANTLR start "ASYNC"
	public final void mASYNC() throws RecognitionException {
		try {
			int _type = ASYNC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:38:7: ( 'async' )
			// PhoenixSQL.g:38:9: 'async'
			{
			match("async"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASYNC"

	// $ANTLR start "BETWEEN"
	public final void mBETWEEN() throws RecognitionException {
		try {
			int _type = BETWEEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:39:9: ( 'between' )
			// PhoenixSQL.g:39:11: 'between'
			{
			match("between"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BETWEEN"

	// $ANTLR start "BY"
	public final void mBY() throws RecognitionException {
		try {
			int _type = BY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:40:4: ( 'by' )
			// PhoenixSQL.g:40:6: 'by'
			{
			match("by"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BY"

	// $ANTLR start "CACHE"
	public final void mCACHE() throws RecognitionException {
		try {
			int _type = CACHE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:41:7: ( 'cache' )
			// PhoenixSQL.g:41:9: 'cache'
			{
			match("cache"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CACHE"

	// $ANTLR start "CASCADE"
	public final void mCASCADE() throws RecognitionException {
		try {
			int _type = CASCADE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:42:9: ( 'cascade' )
			// PhoenixSQL.g:42:11: 'cascade'
			{
			match("cascade"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CASCADE"

	// $ANTLR start "CASE"
	public final void mCASE() throws RecognitionException {
		try {
			int _type = CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:43:6: ( 'case' )
			// PhoenixSQL.g:43:8: 'case'
			{
			match("case"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CASE"

	// $ANTLR start "CAST"
	public final void mCAST() throws RecognitionException {
		try {
			int _type = CAST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:44:6: ( 'cast' )
			// PhoenixSQL.g:44:8: 'cast'
			{
			match("cast"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CAST"

	// $ANTLR start "CLOSE"
	public final void mCLOSE() throws RecognitionException {
		try {
			int _type = CLOSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:45:7: ( 'close' )
			// PhoenixSQL.g:45:9: 'close'
			{
			match("close"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSE"

	// $ANTLR start "COLUMN"
	public final void mCOLUMN() throws RecognitionException {
		try {
			int _type = COLUMN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:46:8: ( 'column' )
			// PhoenixSQL.g:46:10: 'column'
			{
			match("column"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLUMN"

	// $ANTLR start "COLUMNS"
	public final void mCOLUMNS() throws RecognitionException {
		try {
			int _type = COLUMNS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:47:9: ( 'columns' )
			// PhoenixSQL.g:47:11: 'columns'
			{
			match("columns"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLUMNS"

	// $ANTLR start "CONSTANT"
	public final void mCONSTANT() throws RecognitionException {
		try {
			int _type = CONSTANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:48:10: ( 'constant' )
			// PhoenixSQL.g:48:12: 'constant'
			{
			match("constant"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONSTANT"

	// $ANTLR start "CONSTRAINT"
	public final void mCONSTRAINT() throws RecognitionException {
		try {
			int _type = CONSTRAINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:49:12: ( 'constraint' )
			// PhoenixSQL.g:49:14: 'constraint'
			{
			match("constraint"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONSTRAINT"

	// $ANTLR start "CREATE"
	public final void mCREATE() throws RecognitionException {
		try {
			int _type = CREATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:50:8: ( 'create' )
			// PhoenixSQL.g:50:10: 'create'
			{
			match("create"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CREATE"

	// $ANTLR start "CURRENT"
	public final void mCURRENT() throws RecognitionException {
		try {
			int _type = CURRENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:51:9: ( 'current' )
			// PhoenixSQL.g:51:11: 'current'
			{
			match("current"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURRENT"

	// $ANTLR start "CURSOR"
	public final void mCURSOR() throws RecognitionException {
		try {
			int _type = CURSOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:52:8: ( 'cursor' )
			// PhoenixSQL.g:52:10: 'cursor'
			{
			match("cursor"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CURSOR"

	// $ANTLR start "CYCLE"
	public final void mCYCLE() throws RecognitionException {
		try {
			int _type = CYCLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:53:7: ( 'cycle' )
			// PhoenixSQL.g:53:9: 'cycle'
			{
			match("cycle"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CYCLE"

	// $ANTLR start "DECLARE"
	public final void mDECLARE() throws RecognitionException {
		try {
			int _type = DECLARE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:54:9: ( 'declare' )
			// PhoenixSQL.g:54:11: 'declare'
			{
			match("declare"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECLARE"

	// $ANTLR start "DEFAULT"
	public final void mDEFAULT() throws RecognitionException {
		try {
			int _type = DEFAULT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:55:9: ( 'default' )
			// PhoenixSQL.g:55:11: 'default'
			{
			match("default"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULT"

	// $ANTLR start "DEFAULTVALUE"
	public final void mDEFAULTVALUE() throws RecognitionException {
		try {
			int _type = DEFAULTVALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:56:14: ( 'defaultvalue' )
			// PhoenixSQL.g:56:16: 'defaultvalue'
			{
			match("defaultvalue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DEFAULTVALUE"

	// $ANTLR start "DELETE"
	public final void mDELETE() throws RecognitionException {
		try {
			int _type = DELETE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:57:8: ( 'delete' )
			// PhoenixSQL.g:57:10: 'delete'
			{
			match("delete"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DELETE"

	// $ANTLR start "DESC"
	public final void mDESC() throws RecognitionException {
		try {
			int _type = DESC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:58:6: ( 'desc' )
			// PhoenixSQL.g:58:8: 'desc'
			{
			match("desc"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DESC"

	// $ANTLR start "DISABLE"
	public final void mDISABLE() throws RecognitionException {
		try {
			int _type = DISABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:59:9: ( 'disable' )
			// PhoenixSQL.g:59:11: 'disable'
			{
			match("disable"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DISABLE"

	// $ANTLR start "DISTINCT"
	public final void mDISTINCT() throws RecognitionException {
		try {
			int _type = DISTINCT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:60:10: ( 'distinct' )
			// PhoenixSQL.g:60:12: 'distinct'
			{
			match("distinct"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DISTINCT"

	// $ANTLR start "DROP"
	public final void mDROP() throws RecognitionException {
		try {
			int _type = DROP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:61:6: ( 'drop' )
			// PhoenixSQL.g:61:8: 'drop'
			{
			match("drop"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DROP"

	// $ANTLR start "DUPLICATE"
	public final void mDUPLICATE() throws RecognitionException {
		try {
			int _type = DUPLICATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:62:11: ( 'duplicate' )
			// PhoenixSQL.g:62:13: 'duplicate'
			{
			match("duplicate"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DUPLICATE"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:63:6: ( 'else' )
			// PhoenixSQL.g:63:8: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "END"
	public final void mEND() throws RecognitionException {
		try {
			int _type = END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:64:5: ( 'end' )
			// PhoenixSQL.g:64:7: 'end'
			{
			match("end"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "END"

	// $ANTLR start "EXECUTE"
	public final void mEXECUTE() throws RecognitionException {
		try {
			int _type = EXECUTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:65:9: ( 'execute' )
			// PhoenixSQL.g:65:11: 'execute'
			{
			match("execute"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXECUTE"

	// $ANTLR start "EXISTS"
	public final void mEXISTS() throws RecognitionException {
		try {
			int _type = EXISTS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:66:8: ( 'exists' )
			// PhoenixSQL.g:66:10: 'exists'
			{
			match("exists"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXISTS"

	// $ANTLR start "EXPLAIN"
	public final void mEXPLAIN() throws RecognitionException {
		try {
			int _type = EXPLAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:67:9: ( 'explain' )
			// PhoenixSQL.g:67:11: 'explain'
			{
			match("explain"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPLAIN"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:68:7: ( 'false' )
			// PhoenixSQL.g:68:9: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "FETCH"
	public final void mFETCH() throws RecognitionException {
		try {
			int _type = FETCH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:69:7: ( 'fetch' )
			// PhoenixSQL.g:69:9: 'fetch'
			{
			match("fetch"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FETCH"

	// $ANTLR start "FIRST"
	public final void mFIRST() throws RecognitionException {
		try {
			int _type = FIRST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:70:7: ( 'first' )
			// PhoenixSQL.g:70:9: 'first'
			{
			match("first"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIRST"

	// $ANTLR start "FOR"
	public final void mFOR() throws RecognitionException {
		try {
			int _type = FOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:71:5: ( 'for' )
			// PhoenixSQL.g:71:7: 'for'
			{
			match("for"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOR"

	// $ANTLR start "FROM"
	public final void mFROM() throws RecognitionException {
		try {
			int _type = FROM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:72:6: ( 'from' )
			// PhoenixSQL.g:72:8: 'from'
			{
			match("from"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FROM"

	// $ANTLR start "FULL"
	public final void mFULL() throws RecognitionException {
		try {
			int _type = FULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:73:6: ( 'full' )
			// PhoenixSQL.g:73:8: 'full'
			{
			match("full"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FULL"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:74:10: ( 'function' )
			// PhoenixSQL.g:74:12: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNCTION"

	// $ANTLR start "GRANT"
	public final void mGRANT() throws RecognitionException {
		try {
			int _type = GRANT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:75:7: ( 'grant' )
			// PhoenixSQL.g:75:9: 'grant'
			{
			match("grant"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GRANT"

	// $ANTLR start "GROUP"
	public final void mGROUP() throws RecognitionException {
		try {
			int _type = GROUP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:76:7: ( 'group' )
			// PhoenixSQL.g:76:9: 'group'
			{
			match("group"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GROUP"

	// $ANTLR start "HAVING"
	public final void mHAVING() throws RecognitionException {
		try {
			int _type = HAVING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:77:8: ( 'having' )
			// PhoenixSQL.g:77:10: 'having'
			{
			match("having"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HAVING"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:78:4: ( 'if' )
			// PhoenixSQL.g:78:6: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "IGNORE"
	public final void mIGNORE() throws RecognitionException {
		try {
			int _type = IGNORE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:79:8: ( 'ignore' )
			// PhoenixSQL.g:79:10: 'ignore'
			{
			match("ignore"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IGNORE"

	// $ANTLR start "ILIKE"
	public final void mILIKE() throws RecognitionException {
		try {
			int _type = ILIKE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:80:7: ( 'ilike' )
			// PhoenixSQL.g:80:9: 'ilike'
			{
			match("ilike"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ILIKE"

	// $ANTLR start "IMMUTABLE"
	public final void mIMMUTABLE() throws RecognitionException {
		try {
			int _type = IMMUTABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:81:11: ( 'immutable' )
			// PhoenixSQL.g:81:13: 'immutable'
			{
			match("immutable"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMMUTABLE"

	// $ANTLR start "IN"
	public final void mIN() throws RecognitionException {
		try {
			int _type = IN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:82:4: ( 'in' )
			// PhoenixSQL.g:82:6: 'in'
			{
			match("in"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IN"

	// $ANTLR start "INCLUDE"
	public final void mINCLUDE() throws RecognitionException {
		try {
			int _type = INCLUDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:83:9: ( 'include' )
			// PhoenixSQL.g:83:11: 'include'
			{
			match("include"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INCLUDE"

	// $ANTLR start "INCREMENT"
	public final void mINCREMENT() throws RecognitionException {
		try {
			int _type = INCREMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:84:11: ( 'increment' )
			// PhoenixSQL.g:84:13: 'increment'
			{
			match("increment"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INCREMENT"

	// $ANTLR start "INDEX"
	public final void mINDEX() throws RecognitionException {
		try {
			int _type = INDEX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:85:7: ( 'index' )
			// PhoenixSQL.g:85:9: 'index'
			{
			match("index"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INDEX"

	// $ANTLR start "INNER"
	public final void mINNER() throws RecognitionException {
		try {
			int _type = INNER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:86:7: ( 'inner' )
			// PhoenixSQL.g:86:9: 'inner'
			{
			match("inner"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INNER"

	// $ANTLR start "INTO"
	public final void mINTO() throws RecognitionException {
		try {
			int _type = INTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:87:6: ( 'into' )
			// PhoenixSQL.g:87:8: 'into'
			{
			match("into"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTO"

	// $ANTLR start "IS"
	public final void mIS() throws RecognitionException {
		try {
			int _type = IS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:88:4: ( 'is' )
			// PhoenixSQL.g:88:6: 'is'
			{
			match("is"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IS"

	// $ANTLR start "JAR"
	public final void mJAR() throws RecognitionException {
		try {
			int _type = JAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:89:5: ( 'jar' )
			// PhoenixSQL.g:89:7: 'jar'
			{
			match("jar"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JAR"

	// $ANTLR start "JARS"
	public final void mJARS() throws RecognitionException {
		try {
			int _type = JARS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:90:6: ( 'jars' )
			// PhoenixSQL.g:90:8: 'jars'
			{
			match("jars"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JARS"

	// $ANTLR start "JOIN"
	public final void mJOIN() throws RecognitionException {
		try {
			int _type = JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:91:6: ( 'join' )
			// PhoenixSQL.g:91:8: 'join'
			{
			match("join"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JOIN"

	// $ANTLR start "KEY"
	public final void mKEY() throws RecognitionException {
		try {
			int _type = KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:92:5: ( 'key' )
			// PhoenixSQL.g:92:7: 'key'
			{
			match("key"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "KEY"

	// $ANTLR start "LAST"
	public final void mLAST() throws RecognitionException {
		try {
			int _type = LAST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:93:6: ( 'last' )
			// PhoenixSQL.g:93:8: 'last'
			{
			match("last"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LAST"

	// $ANTLR start "LEFT"
	public final void mLEFT() throws RecognitionException {
		try {
			int _type = LEFT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:94:6: ( 'left' )
			// PhoenixSQL.g:94:8: 'left'
			{
			match("left"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT"

	// $ANTLR start "LIKE"
	public final void mLIKE() throws RecognitionException {
		try {
			int _type = LIKE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:95:6: ( 'like' )
			// PhoenixSQL.g:95:8: 'like'
			{
			match("like"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIKE"

	// $ANTLR start "LIMIT"
	public final void mLIMIT() throws RecognitionException {
		try {
			int _type = LIMIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:96:7: ( 'limit' )
			// PhoenixSQL.g:96:9: 'limit'
			{
			match("limit"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIMIT"

	// $ANTLR start "LIST"
	public final void mLIST() throws RecognitionException {
		try {
			int _type = LIST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:97:6: ( 'list' )
			// PhoenixSQL.g:97:8: 'list'
			{
			match("list"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LIST"

	// $ANTLR start "LOCAL"
	public final void mLOCAL() throws RecognitionException {
		try {
			int _type = LOCAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:98:7: ( 'local' )
			// PhoenixSQL.g:98:9: 'local'
			{
			match("local"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOCAL"

	// $ANTLR start "MAXVALUE"
	public final void mMAXVALUE() throws RecognitionException {
		try {
			int _type = MAXVALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:99:10: ( 'maxvalue' )
			// PhoenixSQL.g:99:12: 'maxvalue'
			{
			match("maxvalue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAXVALUE"

	// $ANTLR start "MINVALUE"
	public final void mMINVALUE() throws RecognitionException {
		try {
			int _type = MINVALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:100:10: ( 'minvalue' )
			// PhoenixSQL.g:100:12: 'minvalue'
			{
			match("minvalue"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINVALUE"

	// $ANTLR start "NEXT"
	public final void mNEXT() throws RecognitionException {
		try {
			int _type = NEXT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:101:6: ( 'next' )
			// PhoenixSQL.g:101:8: 'next'
			{
			match("next"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEXT"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:102:5: ( 'not' )
			// PhoenixSQL.g:102:7: 'not'
			{
			match("not"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "NULL"
	public final void mNULL() throws RecognitionException {
		try {
			int _type = NULL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:103:6: ( 'null' )
			// PhoenixSQL.g:103:8: 'null'
			{
			match("null"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULL"

	// $ANTLR start "NULLS"
	public final void mNULLS() throws RecognitionException {
		try {
			int _type = NULLS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:104:7: ( 'nulls' )
			// PhoenixSQL.g:104:9: 'nulls'
			{
			match("nulls"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NULLS"

	// $ANTLR start "OFF"
	public final void mOFF() throws RecognitionException {
		try {
			int _type = OFF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:105:5: ( 'off' )
			// PhoenixSQL.g:105:7: 'off'
			{
			match("off"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OFF"

	// $ANTLR start "OFFSET"
	public final void mOFFSET() throws RecognitionException {
		try {
			int _type = OFFSET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:106:8: ( 'offset' )
			// PhoenixSQL.g:106:10: 'offset'
			{
			match("offset"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OFFSET"

	// $ANTLR start "ON"
	public final void mON() throws RecognitionException {
		try {
			int _type = ON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:107:4: ( 'on' )
			// PhoenixSQL.g:107:6: 'on'
			{
			match("on"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ON"

	// $ANTLR start "ONLY"
	public final void mONLY() throws RecognitionException {
		try {
			int _type = ONLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:108:6: ( 'only' )
			// PhoenixSQL.g:108:8: 'only'
			{
			match("only"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ONLY"

	// $ANTLR start "OPEN"
	public final void mOPEN() throws RecognitionException {
		try {
			int _type = OPEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:109:6: ( 'open' )
			// PhoenixSQL.g:109:8: 'open'
			{
			match("open"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPEN"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:110:4: ( 'or' )
			// PhoenixSQL.g:110:6: 'or'
			{
			match("or"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "ORDER"
	public final void mORDER() throws RecognitionException {
		try {
			int _type = ORDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:111:7: ( 'order' )
			// PhoenixSQL.g:111:9: 'order'
			{
			match("order"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ORDER"

	// $ANTLR start "OUTER"
	public final void mOUTER() throws RecognitionException {
		try {
			int _type = OUTER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:112:7: ( 'outer' )
			// PhoenixSQL.g:112:9: 'outer'
			{
			match("outer"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTER"

	// $ANTLR start "PRIMARY"
	public final void mPRIMARY() throws RecognitionException {
		try {
			int _type = PRIMARY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:113:9: ( 'primary' )
			// PhoenixSQL.g:113:11: 'primary'
			{
			match("primary"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRIMARY"

	// $ANTLR start "REBUILD"
	public final void mREBUILD() throws RecognitionException {
		try {
			int _type = REBUILD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:114:9: ( 'rebuild' )
			// PhoenixSQL.g:114:11: 'rebuild'
			{
			match("rebuild"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REBUILD"

	// $ANTLR start "REPLACE"
	public final void mREPLACE() throws RecognitionException {
		try {
			int _type = REPLACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:115:9: ( 'replace' )
			// PhoenixSQL.g:115:11: 'replace'
			{
			match("replace"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REPLACE"

	// $ANTLR start "RETURNS"
	public final void mRETURNS() throws RecognitionException {
		try {
			int _type = RETURNS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:116:9: ( 'returns' )
			// PhoenixSQL.g:116:11: 'returns'
			{
			match("returns"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURNS"

	// $ANTLR start "REVOKE"
	public final void mREVOKE() throws RecognitionException {
		try {
			int _type = REVOKE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:117:8: ( 'revoke' )
			// PhoenixSQL.g:117:10: 'revoke'
			{
			match("revoke"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REVOKE"

	// $ANTLR start "RIGHT"
	public final void mRIGHT() throws RecognitionException {
		try {
			int _type = RIGHT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:118:7: ( 'right' )
			// PhoenixSQL.g:118:9: 'right'
			{
			match("right"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT"

	// $ANTLR start "ROW"
	public final void mROW() throws RecognitionException {
		try {
			int _type = ROW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:119:5: ( 'row' )
			// PhoenixSQL.g:119:7: 'row'
			{
			match("row"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ROW"

	// $ANTLR start "ROWS"
	public final void mROWS() throws RecognitionException {
		try {
			int _type = ROWS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:120:6: ( 'rows' )
			// PhoenixSQL.g:120:8: 'rows'
			{
			match("rows"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ROWS"

	// $ANTLR start "ROW_TIMESTAMP"
	public final void mROW_TIMESTAMP() throws RecognitionException {
		try {
			int _type = ROW_TIMESTAMP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:121:15: ( 'row_timestamp' )
			// PhoenixSQL.g:121:17: 'row_timestamp'
			{
			match("row_timestamp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ROW_TIMESTAMP"

	// $ANTLR start "SAMPLING"
	public final void mSAMPLING() throws RecognitionException {
		try {
			int _type = SAMPLING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:122:10: ( 'sampling' )
			// PhoenixSQL.g:122:12: 'sampling'
			{
			match("sampling"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SAMPLING"

	// $ANTLR start "SCHEMA"
	public final void mSCHEMA() throws RecognitionException {
		try {
			int _type = SCHEMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:123:8: ( 'schema' )
			// PhoenixSQL.g:123:10: 'schema'
			{
			match("schema"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SCHEMA"

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:124:8: ( 'select' )
			// PhoenixSQL.g:124:10: 'select'
			{
			match("select"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SELECT"

	// $ANTLR start "SEQUENCE"
	public final void mSEQUENCE() throws RecognitionException {
		try {
			int _type = SEQUENCE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:125:10: ( 'sequence' )
			// PhoenixSQL.g:125:12: 'sequence'
			{
			match("sequence"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEQUENCE"

	// $ANTLR start "SESSION"
	public final void mSESSION() throws RecognitionException {
		try {
			int _type = SESSION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:126:9: ( 'session' )
			// PhoenixSQL.g:126:11: 'session'
			{
			match("session"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SESSION"

	// $ANTLR start "SET"
	public final void mSET() throws RecognitionException {
		try {
			int _type = SET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:127:5: ( 'set' )
			// PhoenixSQL.g:127:7: 'set'
			{
			match("set"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET"

	// $ANTLR start "SOME"
	public final void mSOME() throws RecognitionException {
		try {
			int _type = SOME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:128:6: ( 'some' )
			// PhoenixSQL.g:128:8: 'some'
			{
			match("some"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SOME"

	// $ANTLR start "SPLIT"
	public final void mSPLIT() throws RecognitionException {
		try {
			int _type = SPLIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:129:7: ( 'split' )
			// PhoenixSQL.g:129:9: 'split'
			{
			match("split"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SPLIT"

	// $ANTLR start "START"
	public final void mSTART() throws RecognitionException {
		try {
			int _type = START;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:130:7: ( 'start' )
			// PhoenixSQL.g:130:9: 'start'
			{
			match("start"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "START"

	// $ANTLR start "STATISTICS"
	public final void mSTATISTICS() throws RecognitionException {
		try {
			int _type = STATISTICS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:131:12: ( 'statistics' )
			// PhoenixSQL.g:131:14: 'statistics'
			{
			match("statistics"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STATISTICS"

	// $ANTLR start "TABLE"
	public final void mTABLE() throws RecognitionException {
		try {
			int _type = TABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:132:7: ( 'table' )
			// PhoenixSQL.g:132:9: 'table'
			{
			match("table"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TABLE"

	// $ANTLR start "TABLES"
	public final void mTABLES() throws RecognitionException {
		try {
			int _type = TABLES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:133:8: ( 'tables' )
			// PhoenixSQL.g:133:10: 'tables'
			{
			match("tables"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TABLES"

	// $ANTLR start "TABLESAMPLE"
	public final void mTABLESAMPLE() throws RecognitionException {
		try {
			int _type = TABLESAMPLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:134:13: ( 'tablesample' )
			// PhoenixSQL.g:134:15: 'tablesample'
			{
			match("tablesample"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TABLESAMPLE"

	// $ANTLR start "TEMPORARY"
	public final void mTEMPORARY() throws RecognitionException {
		try {
			int _type = TEMPORARY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:135:11: ( 'temporary' )
			// PhoenixSQL.g:135:13: 'temporary'
			{
			match("temporary"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TEMPORARY"

	// $ANTLR start "THEN"
	public final void mTHEN() throws RecognitionException {
		try {
			int _type = THEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:136:6: ( 'then' )
			// PhoenixSQL.g:136:8: 'then'
			{
			match("then"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "THEN"

	// $ANTLR start "TO"
	public final void mTO() throws RecognitionException {
		try {
			int _type = TO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:137:4: ( 'to' )
			// PhoenixSQL.g:137:6: 'to'
			{
			match("to"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TO"

	// $ANTLR start "TRACE"
	public final void mTRACE() throws RecognitionException {
		try {
			int _type = TRACE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:138:7: ( 'trace' )
			// PhoenixSQL.g:138:9: 'trace'
			{
			match("trace"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRACE"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:139:6: ( 'true' )
			// PhoenixSQL.g:139:8: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "UNION"
	public final void mUNION() throws RecognitionException {
		try {
			int _type = UNION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:140:7: ( 'union' )
			// PhoenixSQL.g:140:9: 'union'
			{
			match("union"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNION"

	// $ANTLR start "UNUSABLE"
	public final void mUNUSABLE() throws RecognitionException {
		try {
			int _type = UNUSABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:141:10: ( 'unusable' )
			// PhoenixSQL.g:141:12: 'unusable'
			{
			match("unusable"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNUSABLE"

	// $ANTLR start "UPDATE"
	public final void mUPDATE() throws RecognitionException {
		try {
			int _type = UPDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:142:8: ( 'update' )
			// PhoenixSQL.g:142:10: 'update'
			{
			match("update"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPDATE"

	// $ANTLR start "UPGRADE"
	public final void mUPGRADE() throws RecognitionException {
		try {
			int _type = UPGRADE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:143:9: ( 'upgrade' )
			// PhoenixSQL.g:143:11: 'upgrade'
			{
			match("upgrade"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPGRADE"

	// $ANTLR start "UPSERT"
	public final void mUPSERT() throws RecognitionException {
		try {
			int _type = UPSERT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:144:8: ( 'upsert' )
			// PhoenixSQL.g:144:10: 'upsert'
			{
			match("upsert"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPSERT"

	// $ANTLR start "USABLE"
	public final void mUSABLE() throws RecognitionException {
		try {
			int _type = USABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:145:8: ( 'usable' )
			// PhoenixSQL.g:145:10: 'usable'
			{
			match("usable"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "USABLE"

	// $ANTLR start "USE"
	public final void mUSE() throws RecognitionException {
		try {
			int _type = USE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:146:5: ( 'use' )
			// PhoenixSQL.g:146:7: 'use'
			{
			match("use"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "USE"

	// $ANTLR start "USING"
	public final void mUSING() throws RecognitionException {
		try {
			int _type = USING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:147:7: ( 'using' )
			// PhoenixSQL.g:147:9: 'using'
			{
			match("using"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "USING"

	// $ANTLR start "VALUE"
	public final void mVALUE() throws RecognitionException {
		try {
			int _type = VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:148:7: ( 'value' )
			// PhoenixSQL.g:148:9: 'value'
			{
			match("value"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALUE"

	// $ANTLR start "VALUES"
	public final void mVALUES() throws RecognitionException {
		try {
			int _type = VALUES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:149:8: ( 'values' )
			// PhoenixSQL.g:149:10: 'values'
			{
			match("values"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALUES"

	// $ANTLR start "VIEW"
	public final void mVIEW() throws RecognitionException {
		try {
			int _type = VIEW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:150:6: ( 'view' )
			// PhoenixSQL.g:150:8: 'view'
			{
			match("view"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VIEW"

	// $ANTLR start "WHEN"
	public final void mWHEN() throws RecognitionException {
		try {
			int _type = WHEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:151:6: ( 'when' )
			// PhoenixSQL.g:151:8: 'when'
			{
			match("when"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHEN"

	// $ANTLR start "WHERE"
	public final void mWHERE() throws RecognitionException {
		try {
			int _type = WHERE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:152:7: ( 'where' )
			// PhoenixSQL.g:152:9: 'where'
			{
			match("where"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHERE"

	// $ANTLR start "WITH"
	public final void mWITH() throws RecognitionException {
		try {
			int _type = WITH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:153:6: ( 'with' )
			// PhoenixSQL.g:153:8: 'with'
			{
			match("with"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WITH"

	// $ANTLR start "WITHIN"
	public final void mWITHIN() throws RecognitionException {
		try {
			int _type = WITHIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:154:8: ( 'within' )
			// PhoenixSQL.g:154:10: 'within'
			{
			match("within"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WITHIN"

	// $ANTLR start "HINT_START"
	public final void mHINT_START() throws RecognitionException {
		try {
			int _type = HINT_START;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1183:11: ( '/*+' )
			// PhoenixSQL.g:1183:13: '/*+'
			{
			match("/*+"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HINT_START"

	// $ANTLR start "COMMENT_START"
	public final void mCOMMENT_START() throws RecognitionException {
		try {
			int _type = COMMENT_START;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1184:14: ( '/*' )
			// PhoenixSQL.g:1184:16: '/*'
			{
			match("/*"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT_START"

	// $ANTLR start "COMMENT_AND_HINT_END"
	public final void mCOMMENT_AND_HINT_END() throws RecognitionException {
		try {
			int _type = COMMENT_AND_HINT_END;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1185:21: ( '*/' )
			// PhoenixSQL.g:1185:23: '*/'
			{
			match("*/"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT_AND_HINT_END"

	// $ANTLR start "SL_COMMENT1"
	public final void mSL_COMMENT1() throws RecognitionException {
		try {
			int _type = SL_COMMENT1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1186:12: ( '//' )
			// PhoenixSQL.g:1186:14: '//'
			{
			match("//"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SL_COMMENT1"

	// $ANTLR start "SL_COMMENT2"
	public final void mSL_COMMENT2() throws RecognitionException {
		try {
			int _type = SL_COMMENT2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1187:12: ( '--' )
			// PhoenixSQL.g:1187:14: '--'
			{
			match("--"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SL_COMMENT2"

	// $ANTLR start "BIND_NAME"
	public final void mBIND_NAME() throws RecognitionException {
		try {
			int _type = BIND_NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1191:5: ( COLON ( DIGIT )+ )
			// PhoenixSQL.g:1191:7: COLON ( DIGIT )+
			{
			mCOLON(); 

			// PhoenixSQL.g:1191:13: ( DIGIT )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// PhoenixSQL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BIND_NAME"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1195:5: ( LETTER ( FIELDCHAR )* | '\\\"' ( DBL_QUOTE_CHAR )* '\\\"' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
				alt4=1;
			}
			else if ( (LA4_0=='\"') ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// PhoenixSQL.g:1195:10: LETTER ( FIELDCHAR )*
					{
					mLETTER(); 

					// PhoenixSQL.g:1195:17: ( FIELDCHAR )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')||(LA2_0 >= '\u0080' && LA2_0 <= '\u2001')||(LA2_0 >= '\u2003' && LA2_0 <= '\uFFFE')) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// PhoenixSQL.g:
							{
							if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u0080' && input.LA(1) <= '\u2001')||(input.LA(1) >= '\u2003' && input.LA(1) <= '\uFFFE') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop2;
						}
					}

					}
					break;
				case 2 :
					// PhoenixSQL.g:1196:10: '\\\"' ( DBL_QUOTE_CHAR )* '\\\"'
					{
					match('\"'); 
					// PhoenixSQL.g:1196:15: ( DBL_QUOTE_CHAR )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '\u0000' && LA3_0 <= '!')||(LA3_0 >= '#' && LA3_0 <= '\uFFFF')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// PhoenixSQL.g:1196:16: DBL_QUOTE_CHAR
							{
							mDBL_QUOTE_CHAR(); 

							}
							break;

						default :
							break loop3;
						}
					}

					match('\"'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1201:5: ( POSINTEGER )
			// PhoenixSQL.g:1201:9: POSINTEGER
			{
			mPOSINTEGER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NUMBER"

	// $ANTLR start "DECIMAL"
	public final void mDECIMAL() throws RecognitionException {
		try {
			int _type = DECIMAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1205:2: ( ( POSINTEGER )? '.' POSINTEGER )
			// PhoenixSQL.g:1205:4: ( POSINTEGER )? '.' POSINTEGER
			{
			// PhoenixSQL.g:1205:4: ( POSINTEGER )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// PhoenixSQL.g:1205:4: POSINTEGER
					{
					mPOSINTEGER(); 

					}
					break;

			}

			match('.'); 
			mPOSINTEGER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECIMAL"

	// $ANTLR start "DOUBLE"
	public final void mDOUBLE() throws RecognitionException {
		try {
			int _type = DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1209:5: ( '.' POSINTEGER Exponent | POSINTEGER '.' Exponent | POSINTEGER ( '.' ( POSINTEGER ( Exponent )? )? | Exponent ) )
			int alt9=3;
			alt9 = dfa9.predict(input);
			switch (alt9) {
				case 1 :
					// PhoenixSQL.g:1209:9: '.' POSINTEGER Exponent
					{
					match('.'); 
					mPOSINTEGER(); 

					mExponent(); 

					}
					break;
				case 2 :
					// PhoenixSQL.g:1210:9: POSINTEGER '.' Exponent
					{
					mPOSINTEGER(); 

					match('.'); 
					mExponent(); 

					}
					break;
				case 3 :
					// PhoenixSQL.g:1211:9: POSINTEGER ( '.' ( POSINTEGER ( Exponent )? )? | Exponent )
					{
					mPOSINTEGER(); 

					// PhoenixSQL.g:1211:20: ( '.' ( POSINTEGER ( Exponent )? )? | Exponent )
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0=='.') ) {
						alt8=1;
					}
					else if ( (LA8_0=='E'||LA8_0=='e') ) {
						alt8=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}

					switch (alt8) {
						case 1 :
							// PhoenixSQL.g:1211:21: '.' ( POSINTEGER ( Exponent )? )?
							{
							match('.'); 
							// PhoenixSQL.g:1211:25: ( POSINTEGER ( Exponent )? )?
							int alt7=2;
							int LA7_0 = input.LA(1);
							if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
								alt7=1;
							}
							switch (alt7) {
								case 1 :
									// PhoenixSQL.g:1211:26: POSINTEGER ( Exponent )?
									{
									mPOSINTEGER(); 

									// PhoenixSQL.g:1211:37: ( Exponent )?
									int alt6=2;
									int LA6_0 = input.LA(1);
									if ( (LA6_0=='E'||LA6_0=='e') ) {
										alt6=1;
									}
									switch (alt6) {
										case 1 :
											// PhoenixSQL.g:1211:38: Exponent
											{
											mExponent(); 

											}
											break;

									}

									}
									break;

							}

							}
							break;
						case 2 :
							// PhoenixSQL.g:1211:53: Exponent
							{
							mExponent(); 

							}
							break;

					}

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE"

	// $ANTLR start "Exponent"
	public final void mExponent() throws RecognitionException {
		try {
			int _type = Exponent;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1215:5: ( ( 'e' | 'E' ) ( PLUS | MINUS )? POSINTEGER )
			// PhoenixSQL.g:1215:10: ( 'e' | 'E' ) ( PLUS | MINUS )? POSINTEGER
			{
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// PhoenixSQL.g:1215:22: ( PLUS | MINUS )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='+'||LA10_0=='-') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// PhoenixSQL.g:
					{
					if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}

			mPOSINTEGER(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "Exponent"

	// $ANTLR start "DOUBLE_QUOTE"
	public final void mDOUBLE_QUOTE() throws RecognitionException {
		try {
			int _type = DOUBLE_QUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1219:5: ( '\"' )
			// PhoenixSQL.g:1219:9: '\"'
			{
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE_QUOTE"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1223:5: ( '=' )
			// PhoenixSQL.g:1223:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "LT"
	public final void mLT() throws RecognitionException {
		try {
			int _type = LT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1227:5: ( '<' )
			// PhoenixSQL.g:1227:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LT"

	// $ANTLR start "GT"
	public final void mGT() throws RecognitionException {
		try {
			int _type = GT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1231:5: ( '>' )
			// PhoenixSQL.g:1231:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GT"

	// $ANTLR start "DOUBLE_EQ"
	public final void mDOUBLE_EQ() throws RecognitionException {
		try {
			int _type = DOUBLE_EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1235:5: ( '=' '=' )
			// PhoenixSQL.g:1235:9: '=' '='
			{
			match('='); 
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE_EQ"

	// $ANTLR start "NOEQ1"
	public final void mNOEQ1() throws RecognitionException {
		try {
			int _type = NOEQ1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1239:5: ( '!' '=' )
			// PhoenixSQL.g:1239:9: '!' '='
			{
			match('!'); 
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOEQ1"

	// $ANTLR start "NOEQ2"
	public final void mNOEQ2() throws RecognitionException {
		try {
			int _type = NOEQ2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1243:5: ( '<' '>' )
			// PhoenixSQL.g:1243:9: '<' '>'
			{
			match('<'); 
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOEQ2"

	// $ANTLR start "CONCAT"
	public final void mCONCAT() throws RecognitionException {
		try {
			int _type = CONCAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1247:5: ( '|' '|' )
			// PhoenixSQL.g:1247:9: '|' '|'
			{
			match('|'); 
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONCAT"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1251:5: ( ',' )
			// PhoenixSQL.g:1251:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1255:5: ( '(' )
			// PhoenixSQL.g:1255:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1259:5: ( ')' )
			// PhoenixSQL.g:1259:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1263:5: ( ';' )
			// PhoenixSQL.g:1263:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COLON"
	public final void mCOLON() throws RecognitionException {
		try {
			int _type = COLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1267:5: ( ':' )
			// PhoenixSQL.g:1267:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COLON"

	// $ANTLR start "QUESTION"
	public final void mQUESTION() throws RecognitionException {
		try {
			int _type = QUESTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1271:5: ( '?' )
			// PhoenixSQL.g:1271:9: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUESTION"

	// $ANTLR start "LSQUARE"
	public final void mLSQUARE() throws RecognitionException {
		try {
			int _type = LSQUARE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1275:5: ( '[' )
			// PhoenixSQL.g:1275:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LSQUARE"

	// $ANTLR start "RSQUARE"
	public final void mRSQUARE() throws RecognitionException {
		try {
			int _type = RSQUARE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1279:5: ( ']' )
			// PhoenixSQL.g:1279:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RSQUARE"

	// $ANTLR start "LCURLY"
	public final void mLCURLY() throws RecognitionException {
		try {
			int _type = LCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1283:5: ( '{' )
			// PhoenixSQL.g:1283:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LCURLY"

	// $ANTLR start "RCURLY"
	public final void mRCURLY() throws RecognitionException {
		try {
			int _type = RCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1287:5: ( '}' )
			// PhoenixSQL.g:1287:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RCURLY"

	// $ANTLR start "AT"
	public final void mAT() throws RecognitionException {
		try {
			int _type = AT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1291:5: ( '@' )
			// PhoenixSQL.g:1291:9: '@'
			{
			match('@'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AT"

	// $ANTLR start "TILDE"
	public final void mTILDE() throws RecognitionException {
		try {
			int _type = TILDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1295:5: ( '~' )
			// PhoenixSQL.g:1295:9: '~'
			{
			match('~'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TILDE"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1299:5: ( '+' )
			// PhoenixSQL.g:1299:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1303:5: ( '-' )
			// PhoenixSQL.g:1303:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "ASTERISK"
	public final void mASTERISK() throws RecognitionException {
		try {
			int _type = ASTERISK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1307:5: ( '*' )
			// PhoenixSQL.g:1307:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASTERISK"

	// $ANTLR start "DIVIDE"
	public final void mDIVIDE() throws RecognitionException {
		try {
			int _type = DIVIDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1311:5: ( '/' )
			// PhoenixSQL.g:1311:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIVIDE"

	// $ANTLR start "PERCENT"
	public final void mPERCENT() throws RecognitionException {
		try {
			int _type = PERCENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1315:5: ( '%' )
			// PhoenixSQL.g:1315:9: '%'
			{
			match('%'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PERCENT"

	// $ANTLR start "OUTER_JOIN"
	public final void mOUTER_JOIN() throws RecognitionException {
		try {
			int _type = OUTER_JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1319:5: ( '(' '+' ')' )
			// PhoenixSQL.g:1319:7: '(' '+' ')'
			{
			match('('); 
			match('+'); 
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTER_JOIN"

	// $ANTLR start "FIELDCHAR"
	public final void mFIELDCHAR() throws RecognitionException {
		try {
			// PhoenixSQL.g:1325:5: ( LETTER | DIGIT | '_' | '\\u0080' .. '\\u2001' | '\\u2003' .. '\\ufffe' )
			// PhoenixSQL.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u0080' && input.LA(1) <= '\u2001')||(input.LA(1) >= '\u2003' && input.LA(1) <= '\uFFFE') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FIELDCHAR"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// PhoenixSQL.g:1335:5: ( 'a' .. 'z' | 'A' .. 'Z' )
			// PhoenixSQL.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "POSINTEGER"
	public final void mPOSINTEGER() throws RecognitionException {
		try {
			// PhoenixSQL.g:1341:5: ( ( DIGIT )+ )
			// PhoenixSQL.g:1341:9: ( DIGIT )+
			{
			// PhoenixSQL.g:1341:9: ( DIGIT )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '0' && LA11_0 <= '9')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// PhoenixSQL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POSINTEGER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// PhoenixSQL.g:1346:5: ( '0' .. '9' )
			// PhoenixSQL.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken t=null;

			 StringBuilder sb = new StringBuilder(); 
			// PhoenixSQL.g:1351:5: ( '\\'' (t= CHAR |t= CHAR_ESC )* '\\'' )
			// PhoenixSQL.g:1351:9: '\\'' (t= CHAR |t= CHAR_ESC )* '\\''
			{
			match('\''); 
			// PhoenixSQL.g:1352:5: (t= CHAR |t= CHAR_ESC )*
			loop12:
			while (true) {
				int alt12=3;
				int LA12_0 = input.LA(1);
				if ( (LA12_0=='\'') ) {
					int LA12_1 = input.LA(2);
					if ( (LA12_1=='\'') ) {
						alt12=2;
					}

				}
				else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '&')||(LA12_0 >= '(' && LA12_0 <= '[')||(LA12_0 >= ']' && LA12_0 <= '\uFFFF')) ) {
					alt12=1;
				}
				else if ( (LA12_0=='\\') ) {
					alt12=2;
				}

				switch (alt12) {
				case 1 :
					// PhoenixSQL.g:1352:7: t= CHAR
					{
					int tStart1905 = getCharIndex();
					int tStartLine1905 = getLine();
					int tStartCharPos1905 = getCharPositionInLine();
					mCHAR(); 
					t = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, tStart1905, getCharIndex()-1);
					t.setLine(tStartLine1905);
					t.setCharPositionInLine(tStartCharPos1905);

					 sb.append(t.getText()); 
					}
					break;
				case 2 :
					// PhoenixSQL.g:1353:7: t= CHAR_ESC
					{
					int tStart1918 = getCharIndex();
					int tStartLine1918 = getLine();
					int tStartCharPos1918 = getCharPositionInLine();
					mCHAR_ESC(); 
					t = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, tStart1918, getCharIndex()-1);
					t.setLine(tStartLine1918);
					t.setCharPositionInLine(tStartCharPos1918);

					 sb.append(getText()); 
					}
					break;

				default :
					break loop12;
				}
			}

			match('\''); 
			 setText(sb.toString()); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			// PhoenixSQL.g:1360:5: ( (~ ( '\\'' | '\\\\' ) ) )
			// PhoenixSQL.g:
			{
			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "DBL_QUOTE_CHAR"
	public final void mDBL_QUOTE_CHAR() throws RecognitionException {
		try {
			// PhoenixSQL.g:1365:5: ( (~ ( '\\\"' ) )+ )
			// PhoenixSQL.g:1365:9: (~ ( '\\\"' ) )+
			{
			// PhoenixSQL.g:1365:9: (~ ( '\\\"' ) )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '\u0000' && LA13_0 <= '!')||(LA13_0 >= '#' && LA13_0 <= '\uFFFF')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// PhoenixSQL.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DBL_QUOTE_CHAR"

	// $ANTLR start "CHAR_ESC"
	public final void mCHAR_ESC() throws RecognitionException {
		try {
			// PhoenixSQL.g:1371:5: ( '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\\\"' | '\\'' | '\\\\' | '_' | '%' |) | '\\'\\'' )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0=='\\') ) {
				alt15=1;
			}
			else if ( (LA15_0=='\'') ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// PhoenixSQL.g:1371:9: '\\\\' ( 'n' | 'r' | 't' | 'b' | 'f' | '\\\"' | '\\'' | '\\\\' | '_' | '%' |)
					{
					match('\\'); 
					// PhoenixSQL.g:1372:9: ( 'n' | 'r' | 't' | 'b' | 'f' | '\\\"' | '\\'' | '\\\\' | '_' | '%' |)
					int alt14=11;
					switch ( input.LA(1) ) {
					case 'n':
						{
						alt14=1;
						}
						break;
					case 'r':
						{
						alt14=2;
						}
						break;
					case 't':
						{
						alt14=3;
						}
						break;
					case 'b':
						{
						alt14=4;
						}
						break;
					case 'f':
						{
						alt14=5;
						}
						break;
					case '\"':
						{
						alt14=6;
						}
						break;
					case '\'':
						{
						alt14=7;
						}
						break;
					case '\\':
						{
						alt14=8;
						}
						break;
					case '_':
						{
						alt14=9;
						}
						break;
					case '%':
						{
						alt14=10;
						}
						break;
					default:
						alt14=11;
					}
					switch (alt14) {
						case 1 :
							// PhoenixSQL.g:1372:11: 'n'
							{
							match('n'); 
							 setText("\n"); 
							}
							break;
						case 2 :
							// PhoenixSQL.g:1373:11: 'r'
							{
							match('r'); 
							 setText("\r"); 
							}
							break;
						case 3 :
							// PhoenixSQL.g:1374:11: 't'
							{
							match('t'); 
							 setText("\t"); 
							}
							break;
						case 4 :
							// PhoenixSQL.g:1375:11: 'b'
							{
							match('b'); 
							 setText("\b"); 
							}
							break;
						case 5 :
							// PhoenixSQL.g:1376:11: 'f'
							{
							match('f'); 
							 setText("\f"); 
							}
							break;
						case 6 :
							// PhoenixSQL.g:1377:11: '\\\"'
							{
							match('\"'); 
							 setText("\""); 
							}
							break;
						case 7 :
							// PhoenixSQL.g:1378:11: '\\''
							{
							match('\''); 
							 setText("\'"); 
							}
							break;
						case 8 :
							// PhoenixSQL.g:1379:11: '\\\\'
							{
							match('\\'); 
							 setText("\\"); 
							}
							break;
						case 9 :
							// PhoenixSQL.g:1380:11: '_'
							{
							match('_'); 
							 setText("\\_"); 
							}
							break;
						case 10 :
							// PhoenixSQL.g:1381:11: '%'
							{
							match('%'); 
							 setText("\\%"); 
							}
							break;
						case 11 :
							// PhoenixSQL.g:1382:17: 
							{
							 setText("\\"); 
							}
							break;

					}

					}
					break;
				case 2 :
					// PhoenixSQL.g:1384:9: '\\'\\''
					{
					match("''"); 

					 setText("\'"); 
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR_ESC"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1388:5: ( ( ' ' | '\\t' | '\\u2002' ) )
			// PhoenixSQL.g:1388:9: ( ' ' | '\\t' | '\\u2002' )
			{
			if ( input.LA(1)=='\t'||input.LA(1)==' '||input.LA(1)=='\u2002' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel=HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "EOL"
	public final void mEOL() throws RecognitionException {
		try {
			int _type = EOL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1392:5: ( ( '\\r' | '\\n' ) )
			// PhoenixSQL.g:1392:8: ( '\\r' | '\\n' )
			{
			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EOL"

	// $ANTLR start "ML_HINT"
	public final void mML_HINT() throws RecognitionException {
		try {
			int _type = ML_HINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			CommonToken h=null;
			int t;

			 StringBuilder sb = new StringBuilder(); 
			// PhoenixSQL.g:1399:5: (h= HINT_START ( options {greedy=false; } :t= . )* COMMENT_AND_HINT_END )
			// PhoenixSQL.g:1399:7: h= HINT_START ( options {greedy=false; } :t= . )* COMMENT_AND_HINT_END
			{
			int hStart2291 = getCharIndex();
			int hStartLine2291 = getLine();
			int hStartCharPos2291 = getCharPositionInLine();
			mHINT_START(); 
			h = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, hStart2291, getCharIndex()-1);
			h.setLine(hStartLine2291);
			h.setCharPositionInLine(hStartCharPos2291);

			// PhoenixSQL.g:1399:20: ( options {greedy=false; } :t= . )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0=='*') ) {
					int LA16_1 = input.LA(2);
					if ( (LA16_1=='/') ) {
						alt16=2;
					}
					else if ( ((LA16_1 >= '\u0000' && LA16_1 <= '.')||(LA16_1 >= '0' && LA16_1 <= '\uFFFF')) ) {
						alt16=1;
					}

				}
				else if ( ((LA16_0 >= '\u0000' && LA16_0 <= ')')||(LA16_0 >= '+' && LA16_0 <= '\uFFFF')) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// PhoenixSQL.g:1399:48: t= .
					{
					t = input.LA(1);
					matchAny(); 
					}
					break;

				default :
					break loop16;
				}
			}

			 sb.append(getText()); 
			mCOMMENT_AND_HINT_END(); 

			 setText(sb.substring(h.getText().length())); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ML_HINT"

	// $ANTLR start "ML_COMMENT"
	public final void mML_COMMENT() throws RecognitionException {
		try {
			int _type = ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1404:5: ( COMMENT_START (~ PLUS ) ( options {greedy=false; } : . )* COMMENT_AND_HINT_END )
			// PhoenixSQL.g:1404:7: COMMENT_START (~ PLUS ) ( options {greedy=false; } : . )* COMMENT_AND_HINT_END
			{
			mCOMMENT_START(); 

			if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '*')||(input.LA(1) >= ',' && input.LA(1) <= '\uFFFF') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// PhoenixSQL.g:1404:29: ( options {greedy=false; } : . )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0=='*') ) {
					int LA17_1 = input.LA(2);
					if ( (LA17_1=='/') ) {
						alt17=2;
					}
					else if ( ((LA17_1 >= '\u0000' && LA17_1 <= '.')||(LA17_1 >= '0' && LA17_1 <= '\uFFFF')) ) {
						alt17=1;
					}

				}
				else if ( ((LA17_0 >= '\u0000' && LA17_0 <= ')')||(LA17_0 >= '+' && LA17_0 <= '\uFFFF')) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// PhoenixSQL.g:1404:57: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop17;
				}
			}

			mCOMMENT_AND_HINT_END(); 

			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ML_COMMENT"

	// $ANTLR start "SL_COMMENT"
	public final void mSL_COMMENT() throws RecognitionException {
		try {
			int _type = SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1409:5: ( ( SL_COMMENT1 | SL_COMMENT2 ) ( options {greedy=false; } : . )* EOL )
			// PhoenixSQL.g:1409:7: ( SL_COMMENT1 | SL_COMMENT2 ) ( options {greedy=false; } : . )* EOL
			{
			// PhoenixSQL.g:1409:7: ( SL_COMMENT1 | SL_COMMENT2 )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0=='/') ) {
				alt18=1;
			}
			else if ( (LA18_0=='-') ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// PhoenixSQL.g:1409:8: SL_COMMENT1
					{
					mSL_COMMENT1(); 

					}
					break;
				case 2 :
					// PhoenixSQL.g:1409:22: SL_COMMENT2
					{
					mSL_COMMENT2(); 

					}
					break;

			}

			// PhoenixSQL.g:1409:35: ( options {greedy=false; } : . )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0=='\n'||LA19_0=='\r') ) {
					alt19=2;
				}
				else if ( ((LA19_0 >= '\u0000' && LA19_0 <= '\t')||(LA19_0 >= '\u000B' && LA19_0 <= '\f')||(LA19_0 >= '\u000E' && LA19_0 <= '\uFFFF')) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// PhoenixSQL.g:1409:63: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop19;
				}
			}

			mEOL(); 

			 skip(); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SL_COMMENT"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1414:5: ( '.' )
			// PhoenixSQL.g:1414:7: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "OTHER"
	public final void mOTHER() throws RecognitionException {
		try {
			int _type = OTHER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// PhoenixSQL.g:1418:5: ( . )
			// PhoenixSQL.g:1418:7: .
			{
			matchAny(); 
			 if (true) // to prevent compile error
			              throw new RuntimeException("Unexpected char: '" + getText() + "'"); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OTHER"

	@Override
	public void mTokens() throws RecognitionException {
		// PhoenixSQL.g:1:8: ( ACTIVE | ADD | ALL | ALTER | AND | ANY | ARRAY | AS | ASC | ASYNC | BETWEEN | BY | CACHE | CASCADE | CASE | CAST | CLOSE | COLUMN | COLUMNS | CONSTANT | CONSTRAINT | CREATE | CURRENT | CURSOR | CYCLE | DECLARE | DEFAULT | DEFAULTVALUE | DELETE | DESC | DISABLE | DISTINCT | DROP | DUPLICATE | ELSE | END | EXECUTE | EXISTS | EXPLAIN | FALSE | FETCH | FIRST | FOR | FROM | FULL | FUNCTION | GRANT | GROUP | HAVING | IF | IGNORE | ILIKE | IMMUTABLE | IN | INCLUDE | INCREMENT | INDEX | INNER | INTO | IS | JAR | JARS | JOIN | KEY | LAST | LEFT | LIKE | LIMIT | LIST | LOCAL | MAXVALUE | MINVALUE | NEXT | NOT | NULL | NULLS | OFF | OFFSET | ON | ONLY | OPEN | OR | ORDER | OUTER | PRIMARY | REBUILD | REPLACE | RETURNS | REVOKE | RIGHT | ROW | ROWS | ROW_TIMESTAMP | SAMPLING | SCHEMA | SELECT | SEQUENCE | SESSION | SET | SOME | SPLIT | START | STATISTICS | TABLE | TABLES | TABLESAMPLE | TEMPORARY | THEN | TO | TRACE | TRUE | UNION | UNUSABLE | UPDATE | UPGRADE | UPSERT | USABLE | USE | USING | VALUE | VALUES | VIEW | WHEN | WHERE | WITH | WITHIN | HINT_START | COMMENT_START | COMMENT_AND_HINT_END | SL_COMMENT1 | SL_COMMENT2 | BIND_NAME | NAME | NUMBER | DECIMAL | DOUBLE | Exponent | DOUBLE_QUOTE | EQ | LT | GT | DOUBLE_EQ | NOEQ1 | NOEQ2 | CONCAT | COMMA | LPAREN | RPAREN | SEMICOLON | COLON | QUESTION | LSQUARE | RSQUARE | LCURLY | RCURLY | AT | TILDE | PLUS | MINUS | ASTERISK | DIVIDE | PERCENT | OUTER_JOIN | STRING_LITERAL | WS | EOL | ML_HINT | ML_COMMENT | SL_COMMENT | DOT | OTHER )
		int alt20=171;
		alt20 = dfa20.predict(input);
		switch (alt20) {
			case 1 :
				// PhoenixSQL.g:1:10: ACTIVE
				{
				mACTIVE(); 

				}
				break;
			case 2 :
				// PhoenixSQL.g:1:17: ADD
				{
				mADD(); 

				}
				break;
			case 3 :
				// PhoenixSQL.g:1:21: ALL
				{
				mALL(); 

				}
				break;
			case 4 :
				// PhoenixSQL.g:1:25: ALTER
				{
				mALTER(); 

				}
				break;
			case 5 :
				// PhoenixSQL.g:1:31: AND
				{
				mAND(); 

				}
				break;
			case 6 :
				// PhoenixSQL.g:1:35: ANY
				{
				mANY(); 

				}
				break;
			case 7 :
				// PhoenixSQL.g:1:39: ARRAY
				{
				mARRAY(); 

				}
				break;
			case 8 :
				// PhoenixSQL.g:1:45: AS
				{
				mAS(); 

				}
				break;
			case 9 :
				// PhoenixSQL.g:1:48: ASC
				{
				mASC(); 

				}
				break;
			case 10 :
				// PhoenixSQL.g:1:52: ASYNC
				{
				mASYNC(); 

				}
				break;
			case 11 :
				// PhoenixSQL.g:1:58: BETWEEN
				{
				mBETWEEN(); 

				}
				break;
			case 12 :
				// PhoenixSQL.g:1:66: BY
				{
				mBY(); 

				}
				break;
			case 13 :
				// PhoenixSQL.g:1:69: CACHE
				{
				mCACHE(); 

				}
				break;
			case 14 :
				// PhoenixSQL.g:1:75: CASCADE
				{
				mCASCADE(); 

				}
				break;
			case 15 :
				// PhoenixSQL.g:1:83: CASE
				{
				mCASE(); 

				}
				break;
			case 16 :
				// PhoenixSQL.g:1:88: CAST
				{
				mCAST(); 

				}
				break;
			case 17 :
				// PhoenixSQL.g:1:93: CLOSE
				{
				mCLOSE(); 

				}
				break;
			case 18 :
				// PhoenixSQL.g:1:99: COLUMN
				{
				mCOLUMN(); 

				}
				break;
			case 19 :
				// PhoenixSQL.g:1:106: COLUMNS
				{
				mCOLUMNS(); 

				}
				break;
			case 20 :
				// PhoenixSQL.g:1:114: CONSTANT
				{
				mCONSTANT(); 

				}
				break;
			case 21 :
				// PhoenixSQL.g:1:123: CONSTRAINT
				{
				mCONSTRAINT(); 

				}
				break;
			case 22 :
				// PhoenixSQL.g:1:134: CREATE
				{
				mCREATE(); 

				}
				break;
			case 23 :
				// PhoenixSQL.g:1:141: CURRENT
				{
				mCURRENT(); 

				}
				break;
			case 24 :
				// PhoenixSQL.g:1:149: CURSOR
				{
				mCURSOR(); 

				}
				break;
			case 25 :
				// PhoenixSQL.g:1:156: CYCLE
				{
				mCYCLE(); 

				}
				break;
			case 26 :
				// PhoenixSQL.g:1:162: DECLARE
				{
				mDECLARE(); 

				}
				break;
			case 27 :
				// PhoenixSQL.g:1:170: DEFAULT
				{
				mDEFAULT(); 

				}
				break;
			case 28 :
				// PhoenixSQL.g:1:178: DEFAULTVALUE
				{
				mDEFAULTVALUE(); 

				}
				break;
			case 29 :
				// PhoenixSQL.g:1:191: DELETE
				{
				mDELETE(); 

				}
				break;
			case 30 :
				// PhoenixSQL.g:1:198: DESC
				{
				mDESC(); 

				}
				break;
			case 31 :
				// PhoenixSQL.g:1:203: DISABLE
				{
				mDISABLE(); 

				}
				break;
			case 32 :
				// PhoenixSQL.g:1:211: DISTINCT
				{
				mDISTINCT(); 

				}
				break;
			case 33 :
				// PhoenixSQL.g:1:220: DROP
				{
				mDROP(); 

				}
				break;
			case 34 :
				// PhoenixSQL.g:1:225: DUPLICATE
				{
				mDUPLICATE(); 

				}
				break;
			case 35 :
				// PhoenixSQL.g:1:235: ELSE
				{
				mELSE(); 

				}
				break;
			case 36 :
				// PhoenixSQL.g:1:240: END
				{
				mEND(); 

				}
				break;
			case 37 :
				// PhoenixSQL.g:1:244: EXECUTE
				{
				mEXECUTE(); 

				}
				break;
			case 38 :
				// PhoenixSQL.g:1:252: EXISTS
				{
				mEXISTS(); 

				}
				break;
			case 39 :
				// PhoenixSQL.g:1:259: EXPLAIN
				{
				mEXPLAIN(); 

				}
				break;
			case 40 :
				// PhoenixSQL.g:1:267: FALSE
				{
				mFALSE(); 

				}
				break;
			case 41 :
				// PhoenixSQL.g:1:273: FETCH
				{
				mFETCH(); 

				}
				break;
			case 42 :
				// PhoenixSQL.g:1:279: FIRST
				{
				mFIRST(); 

				}
				break;
			case 43 :
				// PhoenixSQL.g:1:285: FOR
				{
				mFOR(); 

				}
				break;
			case 44 :
				// PhoenixSQL.g:1:289: FROM
				{
				mFROM(); 

				}
				break;
			case 45 :
				// PhoenixSQL.g:1:294: FULL
				{
				mFULL(); 

				}
				break;
			case 46 :
				// PhoenixSQL.g:1:299: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 47 :
				// PhoenixSQL.g:1:308: GRANT
				{
				mGRANT(); 

				}
				break;
			case 48 :
				// PhoenixSQL.g:1:314: GROUP
				{
				mGROUP(); 

				}
				break;
			case 49 :
				// PhoenixSQL.g:1:320: HAVING
				{
				mHAVING(); 

				}
				break;
			case 50 :
				// PhoenixSQL.g:1:327: IF
				{
				mIF(); 

				}
				break;
			case 51 :
				// PhoenixSQL.g:1:330: IGNORE
				{
				mIGNORE(); 

				}
				break;
			case 52 :
				// PhoenixSQL.g:1:337: ILIKE
				{
				mILIKE(); 

				}
				break;
			case 53 :
				// PhoenixSQL.g:1:343: IMMUTABLE
				{
				mIMMUTABLE(); 

				}
				break;
			case 54 :
				// PhoenixSQL.g:1:353: IN
				{
				mIN(); 

				}
				break;
			case 55 :
				// PhoenixSQL.g:1:356: INCLUDE
				{
				mINCLUDE(); 

				}
				break;
			case 56 :
				// PhoenixSQL.g:1:364: INCREMENT
				{
				mINCREMENT(); 

				}
				break;
			case 57 :
				// PhoenixSQL.g:1:374: INDEX
				{
				mINDEX(); 

				}
				break;
			case 58 :
				// PhoenixSQL.g:1:380: INNER
				{
				mINNER(); 

				}
				break;
			case 59 :
				// PhoenixSQL.g:1:386: INTO
				{
				mINTO(); 

				}
				break;
			case 60 :
				// PhoenixSQL.g:1:391: IS
				{
				mIS(); 

				}
				break;
			case 61 :
				// PhoenixSQL.g:1:394: JAR
				{
				mJAR(); 

				}
				break;
			case 62 :
				// PhoenixSQL.g:1:398: JARS
				{
				mJARS(); 

				}
				break;
			case 63 :
				// PhoenixSQL.g:1:403: JOIN
				{
				mJOIN(); 

				}
				break;
			case 64 :
				// PhoenixSQL.g:1:408: KEY
				{
				mKEY(); 

				}
				break;
			case 65 :
				// PhoenixSQL.g:1:412: LAST
				{
				mLAST(); 

				}
				break;
			case 66 :
				// PhoenixSQL.g:1:417: LEFT
				{
				mLEFT(); 

				}
				break;
			case 67 :
				// PhoenixSQL.g:1:422: LIKE
				{
				mLIKE(); 

				}
				break;
			case 68 :
				// PhoenixSQL.g:1:427: LIMIT
				{
				mLIMIT(); 

				}
				break;
			case 69 :
				// PhoenixSQL.g:1:433: LIST
				{
				mLIST(); 

				}
				break;
			case 70 :
				// PhoenixSQL.g:1:438: LOCAL
				{
				mLOCAL(); 

				}
				break;
			case 71 :
				// PhoenixSQL.g:1:444: MAXVALUE
				{
				mMAXVALUE(); 

				}
				break;
			case 72 :
				// PhoenixSQL.g:1:453: MINVALUE
				{
				mMINVALUE(); 

				}
				break;
			case 73 :
				// PhoenixSQL.g:1:462: NEXT
				{
				mNEXT(); 

				}
				break;
			case 74 :
				// PhoenixSQL.g:1:467: NOT
				{
				mNOT(); 

				}
				break;
			case 75 :
				// PhoenixSQL.g:1:471: NULL
				{
				mNULL(); 

				}
				break;
			case 76 :
				// PhoenixSQL.g:1:476: NULLS
				{
				mNULLS(); 

				}
				break;
			case 77 :
				// PhoenixSQL.g:1:482: OFF
				{
				mOFF(); 

				}
				break;
			case 78 :
				// PhoenixSQL.g:1:486: OFFSET
				{
				mOFFSET(); 

				}
				break;
			case 79 :
				// PhoenixSQL.g:1:493: ON
				{
				mON(); 

				}
				break;
			case 80 :
				// PhoenixSQL.g:1:496: ONLY
				{
				mONLY(); 

				}
				break;
			case 81 :
				// PhoenixSQL.g:1:501: OPEN
				{
				mOPEN(); 

				}
				break;
			case 82 :
				// PhoenixSQL.g:1:506: OR
				{
				mOR(); 

				}
				break;
			case 83 :
				// PhoenixSQL.g:1:509: ORDER
				{
				mORDER(); 

				}
				break;
			case 84 :
				// PhoenixSQL.g:1:515: OUTER
				{
				mOUTER(); 

				}
				break;
			case 85 :
				// PhoenixSQL.g:1:521: PRIMARY
				{
				mPRIMARY(); 

				}
				break;
			case 86 :
				// PhoenixSQL.g:1:529: REBUILD
				{
				mREBUILD(); 

				}
				break;
			case 87 :
				// PhoenixSQL.g:1:537: REPLACE
				{
				mREPLACE(); 

				}
				break;
			case 88 :
				// PhoenixSQL.g:1:545: RETURNS
				{
				mRETURNS(); 

				}
				break;
			case 89 :
				// PhoenixSQL.g:1:553: REVOKE
				{
				mREVOKE(); 

				}
				break;
			case 90 :
				// PhoenixSQL.g:1:560: RIGHT
				{
				mRIGHT(); 

				}
				break;
			case 91 :
				// PhoenixSQL.g:1:566: ROW
				{
				mROW(); 

				}
				break;
			case 92 :
				// PhoenixSQL.g:1:570: ROWS
				{
				mROWS(); 

				}
				break;
			case 93 :
				// PhoenixSQL.g:1:575: ROW_TIMESTAMP
				{
				mROW_TIMESTAMP(); 

				}
				break;
			case 94 :
				// PhoenixSQL.g:1:589: SAMPLING
				{
				mSAMPLING(); 

				}
				break;
			case 95 :
				// PhoenixSQL.g:1:598: SCHEMA
				{
				mSCHEMA(); 

				}
				break;
			case 96 :
				// PhoenixSQL.g:1:605: SELECT
				{
				mSELECT(); 

				}
				break;
			case 97 :
				// PhoenixSQL.g:1:612: SEQUENCE
				{
				mSEQUENCE(); 

				}
				break;
			case 98 :
				// PhoenixSQL.g:1:621: SESSION
				{
				mSESSION(); 

				}
				break;
			case 99 :
				// PhoenixSQL.g:1:629: SET
				{
				mSET(); 

				}
				break;
			case 100 :
				// PhoenixSQL.g:1:633: SOME
				{
				mSOME(); 

				}
				break;
			case 101 :
				// PhoenixSQL.g:1:638: SPLIT
				{
				mSPLIT(); 

				}
				break;
			case 102 :
				// PhoenixSQL.g:1:644: START
				{
				mSTART(); 

				}
				break;
			case 103 :
				// PhoenixSQL.g:1:650: STATISTICS
				{
				mSTATISTICS(); 

				}
				break;
			case 104 :
				// PhoenixSQL.g:1:661: TABLE
				{
				mTABLE(); 

				}
				break;
			case 105 :
				// PhoenixSQL.g:1:667: TABLES
				{
				mTABLES(); 

				}
				break;
			case 106 :
				// PhoenixSQL.g:1:674: TABLESAMPLE
				{
				mTABLESAMPLE(); 

				}
				break;
			case 107 :
				// PhoenixSQL.g:1:686: TEMPORARY
				{
				mTEMPORARY(); 

				}
				break;
			case 108 :
				// PhoenixSQL.g:1:696: THEN
				{
				mTHEN(); 

				}
				break;
			case 109 :
				// PhoenixSQL.g:1:701: TO
				{
				mTO(); 

				}
				break;
			case 110 :
				// PhoenixSQL.g:1:704: TRACE
				{
				mTRACE(); 

				}
				break;
			case 111 :
				// PhoenixSQL.g:1:710: TRUE
				{
				mTRUE(); 

				}
				break;
			case 112 :
				// PhoenixSQL.g:1:715: UNION
				{
				mUNION(); 

				}
				break;
			case 113 :
				// PhoenixSQL.g:1:721: UNUSABLE
				{
				mUNUSABLE(); 

				}
				break;
			case 114 :
				// PhoenixSQL.g:1:730: UPDATE
				{
				mUPDATE(); 

				}
				break;
			case 115 :
				// PhoenixSQL.g:1:737: UPGRADE
				{
				mUPGRADE(); 

				}
				break;
			case 116 :
				// PhoenixSQL.g:1:745: UPSERT
				{
				mUPSERT(); 

				}
				break;
			case 117 :
				// PhoenixSQL.g:1:752: USABLE
				{
				mUSABLE(); 

				}
				break;
			case 118 :
				// PhoenixSQL.g:1:759: USE
				{
				mUSE(); 

				}
				break;
			case 119 :
				// PhoenixSQL.g:1:763: USING
				{
				mUSING(); 

				}
				break;
			case 120 :
				// PhoenixSQL.g:1:769: VALUE
				{
				mVALUE(); 

				}
				break;
			case 121 :
				// PhoenixSQL.g:1:775: VALUES
				{
				mVALUES(); 

				}
				break;
			case 122 :
				// PhoenixSQL.g:1:782: VIEW
				{
				mVIEW(); 

				}
				break;
			case 123 :
				// PhoenixSQL.g:1:787: WHEN
				{
				mWHEN(); 

				}
				break;
			case 124 :
				// PhoenixSQL.g:1:792: WHERE
				{
				mWHERE(); 

				}
				break;
			case 125 :
				// PhoenixSQL.g:1:798: WITH
				{
				mWITH(); 

				}
				break;
			case 126 :
				// PhoenixSQL.g:1:803: WITHIN
				{
				mWITHIN(); 

				}
				break;
			case 127 :
				// PhoenixSQL.g:1:810: HINT_START
				{
				mHINT_START(); 

				}
				break;
			case 128 :
				// PhoenixSQL.g:1:821: COMMENT_START
				{
				mCOMMENT_START(); 

				}
				break;
			case 129 :
				// PhoenixSQL.g:1:835: COMMENT_AND_HINT_END
				{
				mCOMMENT_AND_HINT_END(); 

				}
				break;
			case 130 :
				// PhoenixSQL.g:1:856: SL_COMMENT1
				{
				mSL_COMMENT1(); 

				}
				break;
			case 131 :
				// PhoenixSQL.g:1:868: SL_COMMENT2
				{
				mSL_COMMENT2(); 

				}
				break;
			case 132 :
				// PhoenixSQL.g:1:880: BIND_NAME
				{
				mBIND_NAME(); 

				}
				break;
			case 133 :
				// PhoenixSQL.g:1:890: NAME
				{
				mNAME(); 

				}
				break;
			case 134 :
				// PhoenixSQL.g:1:895: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 135 :
				// PhoenixSQL.g:1:902: DECIMAL
				{
				mDECIMAL(); 

				}
				break;
			case 136 :
				// PhoenixSQL.g:1:910: DOUBLE
				{
				mDOUBLE(); 

				}
				break;
			case 137 :
				// PhoenixSQL.g:1:917: Exponent
				{
				mExponent(); 

				}
				break;
			case 138 :
				// PhoenixSQL.g:1:926: DOUBLE_QUOTE
				{
				mDOUBLE_QUOTE(); 

				}
				break;
			case 139 :
				// PhoenixSQL.g:1:939: EQ
				{
				mEQ(); 

				}
				break;
			case 140 :
				// PhoenixSQL.g:1:942: LT
				{
				mLT(); 

				}
				break;
			case 141 :
				// PhoenixSQL.g:1:945: GT
				{
				mGT(); 

				}
				break;
			case 142 :
				// PhoenixSQL.g:1:948: DOUBLE_EQ
				{
				mDOUBLE_EQ(); 

				}
				break;
			case 143 :
				// PhoenixSQL.g:1:958: NOEQ1
				{
				mNOEQ1(); 

				}
				break;
			case 144 :
				// PhoenixSQL.g:1:964: NOEQ2
				{
				mNOEQ2(); 

				}
				break;
			case 145 :
				// PhoenixSQL.g:1:970: CONCAT
				{
				mCONCAT(); 

				}
				break;
			case 146 :
				// PhoenixSQL.g:1:977: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 147 :
				// PhoenixSQL.g:1:983: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 148 :
				// PhoenixSQL.g:1:990: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 149 :
				// PhoenixSQL.g:1:997: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 150 :
				// PhoenixSQL.g:1:1007: COLON
				{
				mCOLON(); 

				}
				break;
			case 151 :
				// PhoenixSQL.g:1:1013: QUESTION
				{
				mQUESTION(); 

				}
				break;
			case 152 :
				// PhoenixSQL.g:1:1022: LSQUARE
				{
				mLSQUARE(); 

				}
				break;
			case 153 :
				// PhoenixSQL.g:1:1030: RSQUARE
				{
				mRSQUARE(); 

				}
				break;
			case 154 :
				// PhoenixSQL.g:1:1038: LCURLY
				{
				mLCURLY(); 

				}
				break;
			case 155 :
				// PhoenixSQL.g:1:1045: RCURLY
				{
				mRCURLY(); 

				}
				break;
			case 156 :
				// PhoenixSQL.g:1:1052: AT
				{
				mAT(); 

				}
				break;
			case 157 :
				// PhoenixSQL.g:1:1055: TILDE
				{
				mTILDE(); 

				}
				break;
			case 158 :
				// PhoenixSQL.g:1:1061: PLUS
				{
				mPLUS(); 

				}
				break;
			case 159 :
				// PhoenixSQL.g:1:1066: MINUS
				{
				mMINUS(); 

				}
				break;
			case 160 :
				// PhoenixSQL.g:1:1072: ASTERISK
				{
				mASTERISK(); 

				}
				break;
			case 161 :
				// PhoenixSQL.g:1:1081: DIVIDE
				{
				mDIVIDE(); 

				}
				break;
			case 162 :
				// PhoenixSQL.g:1:1088: PERCENT
				{
				mPERCENT(); 

				}
				break;
			case 163 :
				// PhoenixSQL.g:1:1096: OUTER_JOIN
				{
				mOUTER_JOIN(); 

				}
				break;
			case 164 :
				// PhoenixSQL.g:1:1107: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;
			case 165 :
				// PhoenixSQL.g:1:1122: WS
				{
				mWS(); 

				}
				break;
			case 166 :
				// PhoenixSQL.g:1:1125: EOL
				{
				mEOL(); 

				}
				break;
			case 167 :
				// PhoenixSQL.g:1:1129: ML_HINT
				{
				mML_HINT(); 

				}
				break;
			case 168 :
				// PhoenixSQL.g:1:1137: ML_COMMENT
				{
				mML_COMMENT(); 

				}
				break;
			case 169 :
				// PhoenixSQL.g:1:1148: SL_COMMENT
				{
				mSL_COMMENT(); 

				}
				break;
			case 170 :
				// PhoenixSQL.g:1:1159: DOT
				{
				mDOT(); 

				}
				break;
			case 171 :
				// PhoenixSQL.g:1:1163: OTHER
				{
				mOTHER(); 

				}
				break;

		}
	}


	protected DFA9 dfa9 = new DFA9(this);
	protected DFA20 dfa20 = new DFA20(this);
	static final String DFA9_eotS =
		"\3\uffff\1\4\2\uffff";
	static final String DFA9_eofS =
		"\6\uffff";
	static final String DFA9_minS =
		"\1\56\1\uffff\1\56\1\105\2\uffff";
	static final String DFA9_maxS =
		"\1\71\1\uffff\2\145\2\uffff";
	static final String DFA9_acceptS =
		"\1\uffff\1\1\2\uffff\1\3\1\2";
	static final String DFA9_specialS =
		"\6\uffff}>";
	static final String[] DFA9_transitionS = {
			"\1\1\1\uffff\12\2",
			"",
			"\1\3\1\uffff\12\2\13\uffff\1\4\37\uffff\1\4",
			"\1\5\37\uffff\1\5",
			"",
			""
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "1208:1: DOUBLE : ( '.' POSINTEGER Exponent | POSINTEGER '.' Exponent | POSINTEGER ( '.' ( POSINTEGER ( Exponent )? )? | Exponent ) );";
		}
	}

	static final String DFA20_eotS =
		"\1\uffff\26\74\1\u0085\1\u0087\1\u0089\1\u008a\1\74\1\u008c\1\u008d\1"+
		"\u0092\1\uffff\1\u0094\1\u0096\1\uffff\2\65\1\uffff\1\u009c\13\uffff\1"+
		"\65\3\uffff\5\74\1\u00b4\1\uffff\1\74\1\u00b6\16\74\1\uffff\10\74\1\u00d5"+
		"\3\74\1\u00dd\1\u00de\15\74\1\u00ef\1\74\1\u00f2\16\74\1\u0107\10\74\1"+
		"\u0117\1\u0119\3\uffff\1\u011b\5\uffff\1\u008d\1\u0090\1\uffff\1\u011d"+
		"\31\uffff\1\74\1\u011f\1\u0120\1\74\1\u0122\1\u0123\1\74\1\u0125\1\74"+
		"\1\uffff\1\74\1\uffff\20\74\1\u013c\6\74\1\u0143\6\74\1\uffff\7\74\2\uffff"+
		"\1\u0153\1\74\1\u0155\11\74\1\u015f\1\74\1\u0162\1\74\1\uffff\2\74\1\uffff"+
		"\7\74\1\u016f\5\74\1\u0175\6\74\1\uffff\10\74\1\u0185\5\74\1\u018c\5\uffff"+
		"\1\u011d\1\uffff\1\74\2\uffff\1\74\2\uffff\1\74\1\uffff\4\74\1\u0195\1"+
		"\u0196\12\74\1\u01a1\2\74\1\u01a4\1\74\1\u01a6\1\uffff\6\74\1\uffff\1"+
		"\u01ad\1\u01ae\13\74\1\u01ba\1\u01bb\1\uffff\1\u01bc\1\uffff\1\u01bd\1"+
		"\u01be\1\u01bf\1\74\1\u01c1\3\74\1\u01c5\1\uffff\1\u01c7\1\74\1\uffff"+
		"\1\u01c9\1\u01ca\10\74\1\u01d3\1\74\1\uffff\5\74\1\uffff\1\u01da\5\74"+
		"\1\u01e0\1\74\1\u01e2\6\74\1\uffff\2\74\1\u01eb\1\u01ec\1\74\1\u01ef\2"+
		"\uffff\1\74\1\u01f1\1\u01f2\1\u01f3\1\74\1\u01f5\1\74\2\uffff\1\u01f7"+
		"\5\74\1\u01fe\3\74\1\uffff\2\74\1\uffff\1\74\1\uffff\3\74\1\u0208\1\u0209"+
		"\1\u020a\2\uffff\1\74\1\u020c\1\u020d\2\74\1\u0210\3\74\1\u0214\1\u0215"+
		"\6\uffff\1\u0216\1\uffff\1\u0217\2\74\1\uffff\1\u021a\1\uffff\1\74\2\uffff"+
		"\1\u021c\1\u021d\5\74\1\u0223\1\uffff\6\74\1\uffff\1\u022a\1\u022b\1\74"+
		"\1\u022e\1\74\1\uffff\1\u0230\1\uffff\1\u0231\5\74\1\u0237\1\u0239\2\uffff"+
		"\1\u023a\1\74\1\uffff\1\u023c\3\uffff\1\74\1\uffff\1\74\1\uffff\1\u0240"+
		"\2\74\1\u0243\1\74\1\u0245\1\uffff\2\74\1\u0248\4\74\1\u024d\1\74\3\uffff"+
		"\1\74\2\uffff\1\u0250\1\u0251\1\uffff\3\74\4\uffff\2\74\1\uffff\1\u0257"+
		"\2\uffff\4\74\1\u025c\1\uffff\2\74\1\u025f\1\u0260\2\74\2\uffff\1\74\1"+
		"\u0265\1\uffff\1\74\2\uffff\1\74\1\u0268\1\74\1\u026a\1\u026b\1\uffff"+
		"\1\u026c\2\uffff\1\u026d\1\uffff\1\u026e\1\u026f\1\u0270\1\uffff\2\74"+
		"\1\uffff\1\u0273\1\uffff\1\u0274\1\u0276\1\uffff\1\u0277\2\74\1\u027a"+
		"\1\uffff\1\u027b\1\74\2\uffff\1\74\1\u027e\3\74\1\uffff\1\u0282\1\u0283"+
		"\1\u0284\1\u0285\1\uffff\2\74\2\uffff\1\74\1\u0289\2\74\1\uffff\2\74\1"+
		"\uffff\1\u028e\7\uffff\1\u028f\1\74\2\uffff\1\74\2\uffff\1\u0292\1\74"+
		"\2\uffff\1\u0294\1\74\1\uffff\1\74\1\u0297\1\u0298\4\uffff\1\74\1\u029a"+
		"\1\u029b\1\uffff\3\74\1\u029f\2\uffff\2\74\1\uffff\1\u02a2\1\uffff\1\u02a3"+
		"\1\u02a4\2\uffff\1\74\2\uffff\2\74\1\u02a8\1\uffff\1\u02a9\1\74\3\uffff"+
		"\1\74\1\u02ac\1\74\2\uffff\2\74\1\uffff\1\u02b0\1\u02b1\1\74\2\uffff\1"+
		"\u02b3\1\uffff";
	static final String DFA20_eofS =
		"\u02b4\uffff";
	static final String DFA20_minS =
		"\1\0\1\143\1\145\1\141\1\145\1\53\1\141\1\162\1\141\1\146\1\141\1\145"+
		"\2\141\1\145\1\146\1\162\1\145\2\141\1\156\1\141\1\150\1\52\1\57\1\55"+
		"\1\60\1\53\1\0\1\56\1\60\1\uffff\1\75\1\76\1\uffff\1\75\1\174\1\uffff"+
		"\1\53\13\uffff\1\0\3\uffff\1\164\1\144\1\154\1\144\1\162\1\60\1\uffff"+
		"\1\164\1\60\1\143\1\157\1\154\1\145\1\162\2\143\1\163\1\157\1\160\1\163"+
		"\1\144\1\145\1\60\1\uffff\1\154\1\164\2\162\1\157\1\154\1\141\1\166\1"+
		"\60\1\156\1\151\1\155\2\60\1\162\1\151\1\171\1\163\1\146\1\153\1\143\1"+
		"\170\1\156\1\170\1\164\1\154\1\146\1\60\1\145\1\60\1\164\1\151\1\142\1"+
		"\147\1\167\1\155\1\150\1\154\1\155\1\154\1\141\1\142\1\155\1\145\1\60"+
		"\1\141\1\151\1\144\1\141\1\154\2\145\1\164\2\0\3\uffff\1\0\5\uffff\1\56"+
		"\1\60\1\uffff\1\60\31\uffff\1\151\2\60\1\145\2\60\1\141\1\60\1\156\1\uffff"+
		"\1\167\1\uffff\1\150\1\143\1\163\1\165\1\163\1\141\1\162\2\154\1\141\1"+
		"\145\1\143\1\141\1\160\1\154\1\145\1\60\1\143\1\163\1\154\1\163\1\143"+
		"\1\163\1\60\1\155\1\154\1\143\1\156\1\165\1\151\1\uffff\1\157\1\153\1"+
		"\165\1\154\2\145\1\157\2\uffff\1\60\1\156\1\60\2\164\1\145\1\151\1\164"+
		"\1\141\2\166\1\164\1\60\1\154\1\60\1\171\1\uffff\1\156\1\145\1\uffff\1"+
		"\145\1\155\1\165\1\154\1\165\1\157\1\150\1\60\1\160\2\145\1\165\1\163"+
		"\1\60\1\145\1\151\1\162\1\154\1\160\1\156\1\uffff\1\143\1\145\1\157\1"+
		"\163\1\141\1\162\1\145\1\142\1\60\1\156\1\165\1\167\1\156\1\150\1\0\5"+
		"\uffff\1\60\1\uffff\1\166\2\uffff\1\162\2\uffff\1\171\1\uffff\1\143\2"+
		"\145\1\141\2\60\1\145\1\155\2\164\1\145\1\157\1\145\1\141\1\165\1\164"+
		"\1\60\1\142\1\151\1\60\1\151\1\60\1\uffff\1\165\1\164\1\141\1\145\1\150"+
		"\1\164\1\uffff\2\60\2\164\1\160\1\156\1\162\1\145\1\164\1\165\1\145\1"+
		"\170\1\162\2\60\1\uffff\1\60\1\uffff\3\60\1\164\1\60\1\154\2\141\1\60"+
		"\1\uffff\1\60\1\145\1\uffff\2\60\2\162\1\141\1\151\1\141\1\162\1\153\1"+
		"\164\1\60\1\164\1\uffff\1\154\1\155\1\143\1\145\1\151\1\uffff\1\60\2\164"+
		"\1\151\1\145\1\157\1\60\1\145\1\60\1\156\1\141\1\164\1\141\1\162\1\154"+
		"\1\uffff\1\147\1\145\2\60\1\145\1\60\2\uffff\1\145\3\60\1\145\1\60\1\144"+
		"\2\uffff\1\60\1\156\1\141\1\145\1\156\1\162\1\60\1\162\1\154\1\145\1\uffff"+
		"\1\154\1\156\1\uffff\1\143\1\uffff\1\164\1\163\1\151\3\60\2\uffff\1\151"+
		"\2\60\1\147\1\145\1\60\1\141\1\144\1\155\2\60\6\uffff\1\60\1\uffff\1\60"+
		"\2\154\1\uffff\1\60\1\uffff\1\164\2\uffff\2\60\1\162\1\154\1\143\1\156"+
		"\1\145\1\60\1\uffff\2\151\1\141\1\164\1\156\1\157\1\uffff\2\60\1\163\1"+
		"\60\1\162\1\uffff\1\60\1\uffff\1\60\1\142\1\145\1\144\1\164\1\145\2\60"+
		"\2\uffff\1\60\1\156\1\uffff\1\60\3\uffff\1\156\1\uffff\1\145\1\uffff\1"+
		"\60\1\156\1\141\1\60\1\164\1\60\1\uffff\1\145\1\164\1\60\1\145\1\143\1"+
		"\141\1\145\1\60\1\156\3\uffff\1\157\2\uffff\2\60\1\uffff\1\142\2\145\4"+
		"\uffff\2\165\1\uffff\1\60\2\uffff\1\171\1\144\1\145\1\163\1\60\1\uffff"+
		"\1\155\1\156\2\60\1\143\1\156\2\uffff\1\164\1\60\1\uffff\1\141\2\uffff"+
		"\1\154\1\60\1\145\2\60\1\uffff\1\60\2\uffff\1\60\1\uffff\3\60\1\uffff"+
		"\1\164\1\151\1\uffff\1\60\1\uffff\2\60\1\uffff\1\60\2\164\1\60\1\uffff"+
		"\1\60\1\156\2\uffff\1\154\1\60\1\156\2\145\1\uffff\4\60\1\uffff\1\145"+
		"\1\147\2\uffff\1\145\1\60\1\151\1\155\1\uffff\1\162\1\145\1\uffff\1\60"+
		"\7\uffff\1\60\1\156\2\uffff\1\141\2\uffff\1\60\1\145\2\uffff\1\60\1\145"+
		"\1\uffff\1\164\2\60\4\uffff\1\163\2\60\1\uffff\1\143\1\160\1\171\1\60"+
		"\2\uffff\1\164\1\154\1\uffff\1\60\1\uffff\2\60\2\uffff\1\164\2\uffff\1"+
		"\163\1\154\1\60\1\uffff\1\60\1\165\3\uffff\1\141\1\60\1\145\2\uffff\1"+
		"\145\1\155\1\uffff\2\60\1\160\2\uffff\1\60\1\uffff";
	static final String DFA20_maxS =
		"\1\uffff\1\163\2\171\1\165\1\170\1\165\1\162\1\141\1\163\1\157\1\145\1"+
		"\157\1\151\2\165\1\162\1\157\1\164\1\162\1\163\2\151\2\57\1\55\2\71\1"+
		"\uffff\1\145\1\71\1\uffff\1\75\1\76\1\uffff\1\75\1\174\1\uffff\1\53\13"+
		"\uffff\1\uffff\3\uffff\1\164\1\144\1\164\1\171\1\162\1\ufffe\1\uffff\1"+
		"\164\1\ufffe\1\163\1\157\1\156\1\145\1\162\1\143\2\163\1\157\1\160\1\163"+
		"\1\144\1\160\1\71\1\uffff\1\154\1\164\2\162\1\157\1\156\1\157\1\166\1"+
		"\ufffe\1\156\1\151\1\155\2\ufffe\1\162\1\151\1\171\1\163\1\146\1\163\1"+
		"\143\1\170\1\156\1\170\1\164\1\154\1\146\1\ufffe\1\145\1\ufffe\1\164\1"+
		"\151\1\166\1\147\1\167\1\155\1\150\1\164\1\155\1\154\1\141\1\142\1\155"+
		"\1\145\1\ufffe\2\165\1\163\1\151\1\154\2\145\1\164\2\uffff\3\uffff\1\uffff"+
		"\5\uffff\1\145\1\71\1\uffff\1\145\31\uffff\1\151\2\ufffe\1\145\2\ufffe"+
		"\1\141\1\ufffe\1\156\1\uffff\1\167\1\uffff\1\150\1\164\1\163\1\165\1\163"+
		"\1\141\1\163\2\154\1\141\1\145\1\143\1\164\1\160\1\154\1\145\1\ufffe\1"+
		"\143\1\163\1\154\1\163\1\143\1\163\1\ufffe\1\155\1\154\1\143\1\156\1\165"+
		"\1\151\1\uffff\1\157\1\153\1\165\1\162\2\145\1\157\2\uffff\1\ufffe\1\156"+
		"\1\ufffe\2\164\1\145\1\151\1\164\1\141\2\166\1\164\1\ufffe\1\154\1\ufffe"+
		"\1\171\1\uffff\1\156\1\145\1\uffff\1\145\1\155\1\165\1\154\1\165\1\157"+
		"\1\150\1\ufffe\1\160\2\145\1\165\1\163\1\ufffe\1\145\1\151\1\164\1\154"+
		"\1\160\1\156\1\uffff\1\143\1\145\1\157\1\163\1\141\1\162\1\145\1\142\1"+
		"\ufffe\1\156\1\165\1\167\1\162\1\150\1\uffff\5\uffff\1\145\1\uffff\1\166"+
		"\2\uffff\1\162\2\uffff\1\171\1\uffff\1\143\2\145\1\141\2\ufffe\1\145\1"+
		"\155\2\164\1\145\1\157\1\145\1\141\1\165\1\164\1\ufffe\1\142\1\151\1\ufffe"+
		"\1\151\1\ufffe\1\uffff\1\165\1\164\1\141\1\145\1\150\1\164\1\uffff\2\ufffe"+
		"\2\164\1\160\1\156\1\162\1\145\1\164\1\165\1\145\1\170\1\162\2\ufffe\1"+
		"\uffff\1\ufffe\1\uffff\3\ufffe\1\164\1\ufffe\1\154\2\141\1\ufffe\1\uffff"+
		"\1\ufffe\1\145\1\uffff\2\ufffe\2\162\1\141\1\151\1\141\1\162\1\153\1\164"+
		"\1\ufffe\1\164\1\uffff\1\154\1\155\1\143\1\145\1\151\1\uffff\1\ufffe\2"+
		"\164\1\151\1\145\1\157\1\ufffe\1\145\1\ufffe\1\156\1\141\1\164\1\141\1"+
		"\162\1\154\1\uffff\1\147\1\145\2\ufffe\1\145\1\ufffe\2\uffff\1\145\3\ufffe"+
		"\1\145\1\ufffe\1\144\2\uffff\1\ufffe\1\156\1\162\1\145\1\156\1\162\1\ufffe"+
		"\1\162\1\154\1\145\1\uffff\1\154\1\156\1\uffff\1\143\1\uffff\1\164\1\163"+
		"\1\151\3\ufffe\2\uffff\1\151\2\ufffe\1\147\1\145\1\ufffe\1\141\1\144\1"+
		"\155\2\ufffe\6\uffff\1\ufffe\1\uffff\1\ufffe\2\154\1\uffff\1\ufffe\1\uffff"+
		"\1\164\2\uffff\2\ufffe\1\162\1\154\1\143\1\156\1\145\1\ufffe\1\uffff\2"+
		"\151\1\141\1\164\1\156\1\157\1\uffff\2\ufffe\1\163\1\ufffe\1\162\1\uffff"+
		"\1\ufffe\1\uffff\1\ufffe\1\142\1\145\1\144\1\164\1\145\2\ufffe\2\uffff"+
		"\1\ufffe\1\156\1\uffff\1\ufffe\3\uffff\1\156\1\uffff\1\145\1\uffff\1\ufffe"+
		"\1\156\1\141\1\ufffe\1\164\1\ufffe\1\uffff\1\145\1\164\1\ufffe\1\145\1"+
		"\143\1\141\1\145\1\ufffe\1\156\3\uffff\1\157\2\uffff\2\ufffe\1\uffff\1"+
		"\142\2\145\4\uffff\2\165\1\uffff\1\ufffe\2\uffff\1\171\1\144\1\145\1\163"+
		"\1\ufffe\1\uffff\1\155\1\156\2\ufffe\1\143\1\156\2\uffff\1\164\1\ufffe"+
		"\1\uffff\1\141\2\uffff\1\154\1\ufffe\1\145\2\ufffe\1\uffff\1\ufffe\2\uffff"+
		"\1\ufffe\1\uffff\3\ufffe\1\uffff\1\164\1\151\1\uffff\1\ufffe\1\uffff\2"+
		"\ufffe\1\uffff\1\ufffe\2\164\1\ufffe\1\uffff\1\ufffe\1\156\2\uffff\1\154"+
		"\1\ufffe\1\156\2\145\1\uffff\4\ufffe\1\uffff\1\145\1\147\2\uffff\1\145"+
		"\1\ufffe\1\151\1\155\1\uffff\1\162\1\145\1\uffff\1\ufffe\7\uffff\1\ufffe"+
		"\1\156\2\uffff\1\141\2\uffff\1\ufffe\1\145\2\uffff\1\ufffe\1\145\1\uffff"+
		"\1\164\2\ufffe\4\uffff\1\163\2\ufffe\1\uffff\1\143\1\160\1\171\1\ufffe"+
		"\2\uffff\1\164\1\154\1\uffff\1\ufffe\1\uffff\2\ufffe\2\uffff\1\164\2\uffff"+
		"\1\163\1\154\1\ufffe\1\uffff\1\ufffe\1\165\3\uffff\1\141\1\ufffe\1\145"+
		"\2\uffff\1\145\1\155\1\uffff\2\ufffe\1\160\2\uffff\1\ufffe\1\uffff";
	static final String DFA20_acceptS =
		"\37\uffff\1\u0085\2\uffff\1\u008d\2\uffff\1\u0092\1\uffff\1\u0094\1\u0095"+
		"\1\u0097\1\u0098\1\u0099\1\u009a\1\u009b\1\u009c\1\u009d\1\u009e\1\u00a2"+
		"\1\uffff\1\u00a5\1\u00a6\1\u00ab\6\uffff\1\u0085\20\uffff\1\u0089\67\uffff"+
		"\1\u00a1\1\u0081\1\u00a0\1\uffff\1\u009f\1\u0096\1\u0084\1\u008a\1\u0086"+
		"\2\uffff\1\u0088\1\uffff\1\u00aa\1\u008e\1\u008b\1\u0090\1\u008c\1\u008d"+
		"\1\u008f\1\u0091\1\u0092\1\u00a3\1\u0093\1\u0094\1\u0095\1\u0097\1\u0098"+
		"\1\u0099\1\u009a\1\u009b\1\u009c\1\u009d\1\u009e\1\u00a2\1\u00a4\1\u00a5"+
		"\1\u00a6\11\uffff\1\10\1\uffff\1\14\36\uffff\1\62\7\uffff\1\66\1\74\20"+
		"\uffff\1\117\2\uffff\1\122\24\uffff\1\155\17\uffff\1\u0080\1\u00a8\1\u0082"+
		"\1\u00a9\1\u0083\1\uffff\1\u0087\1\uffff\1\2\1\3\1\uffff\1\5\1\6\1\uffff"+
		"\1\11\26\uffff\1\44\6\uffff\1\53\17\uffff\1\75\1\uffff\1\100\11\uffff"+
		"\1\112\2\uffff\1\115\14\uffff\1\133\5\uffff\1\143\17\uffff\1\166\6\uffff"+
		"\1\177\1\u00a7\7\uffff\1\17\1\20\12\uffff\1\36\2\uffff\1\41\1\uffff\1"+
		"\43\6\uffff\1\54\1\55\13\uffff\1\73\1\76\1\77\1\101\1\102\1\103\1\uffff"+
		"\1\105\3\uffff\1\111\1\uffff\1\113\1\uffff\1\120\1\121\10\uffff\1\134"+
		"\6\uffff\1\144\5\uffff\1\154\1\uffff\1\157\10\uffff\1\172\1\173\2\uffff"+
		"\1\175\1\uffff\1\4\1\7\1\12\1\uffff\1\15\1\uffff\1\21\6\uffff\1\31\11"+
		"\uffff\1\50\1\51\1\52\1\uffff\1\57\1\60\2\uffff\1\64\3\uffff\1\71\1\72"+
		"\1\104\1\106\2\uffff\1\114\1\uffff\1\123\1\124\5\uffff\1\132\6\uffff\1"+
		"\145\1\146\2\uffff\1\150\1\uffff\1\156\1\160\5\uffff\1\167\1\uffff\1\170"+
		"\1\174\1\uffff\1\1\3\uffff\1\22\2\uffff\1\26\1\uffff\1\30\2\uffff\1\35"+
		"\4\uffff\1\46\2\uffff\1\61\1\63\5\uffff\1\116\4\uffff\1\131\2\uffff\1"+
		"\137\1\140\4\uffff\1\151\2\uffff\1\162\1\uffff\1\164\1\165\1\171\1\176"+
		"\1\13\1\16\1\23\2\uffff\1\27\1\32\1\uffff\1\33\1\37\2\uffff\1\45\1\47"+
		"\2\uffff\1\67\3\uffff\1\125\1\126\1\127\1\130\3\uffff\1\142\4\uffff\1"+
		"\163\1\24\2\uffff\1\40\1\uffff\1\56\2\uffff\1\107\1\110\1\uffff\1\136"+
		"\1\141\3\uffff\1\161\2\uffff\1\42\1\65\1\70\3\uffff\1\153\1\25\2\uffff"+
		"\1\147\3\uffff\1\152\1\34\1\uffff\1\135";
	static final String DFA20_specialS =
		"\1\0\33\uffff\1\5\25\uffff\1\6\120\uffff\1\4\1\1\3\uffff\1\3\u008d\uffff"+
		"\1\2\u019d\uffff}>";
	static final String[] DFA20_transitionS = {
			"\11\65\1\63\1\64\2\65\1\64\22\65\1\63\1\43\1\34\2\65\1\61\1\65\1\62\1"+
			"\46\1\47\1\30\1\60\1\45\1\31\1\36\1\27\12\35\1\32\1\50\1\41\1\40\1\42"+
			"\1\51\1\56\4\37\1\33\25\37\1\52\1\65\1\53\3\65\1\1\1\2\1\3\1\4\1\5\1"+
			"\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\37\1\21\1\22\1"+
			"\23\1\24\1\25\1\26\3\37\1\54\1\44\1\55\1\57\u1f83\65\1\63\udffd\65",
			"\1\66\1\67\7\uffff\1\70\1\uffff\1\71\3\uffff\1\72\1\73",
			"\1\75\23\uffff\1\76",
			"\1\77\12\uffff\1\100\2\uffff\1\101\2\uffff\1\102\2\uffff\1\103\3\uffff"+
			"\1\104",
			"\1\105\3\uffff\1\106\10\uffff\1\107\2\uffff\1\110",
			"\1\115\1\uffff\1\115\2\uffff\12\114\62\uffff\1\111\1\uffff\1\112\11"+
			"\uffff\1\113",
			"\1\116\3\uffff\1\117\3\uffff\1\120\5\uffff\1\121\2\uffff\1\122\2\uffff"+
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126\1\127\4\uffff\1\130\1\131\1\132\4\uffff\1\133",
			"\1\134\15\uffff\1\135",
			"\1\136",
			"\1\137\3\uffff\1\140\3\uffff\1\141\5\uffff\1\142",
			"\1\143\7\uffff\1\144",
			"\1\145\11\uffff\1\146\5\uffff\1\147",
			"\1\150\7\uffff\1\151\1\uffff\1\152\1\uffff\1\153\2\uffff\1\154",
			"\1\155",
			"\1\156\3\uffff\1\157\5\uffff\1\160",
			"\1\161\1\uffff\1\162\1\uffff\1\163\11\uffff\1\164\1\165\3\uffff\1\166",
			"\1\167\3\uffff\1\170\2\uffff\1\171\6\uffff\1\172\2\uffff\1\173",
			"\1\174\1\uffff\1\175\2\uffff\1\176",
			"\1\177\7\uffff\1\u0080",
			"\1\u0081\1\u0082",
			"\1\u0083\4\uffff\1\u0084",
			"\1\u0086",
			"\1\u0088",
			"\12\u008b",
			"\1\115\1\uffff\1\115\2\uffff\12\114",
			"\0\74",
			"\1\u008f\1\uffff\12\u008e\13\uffff\1\u0090\37\uffff\1\u0090",
			"\12\u0091",
			"",
			"\1\u0093",
			"\1\u0095",
			"",
			"\1\u0098",
			"\1\u0099",
			"",
			"\1\u009b",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\0\u00a8",
			"",
			"",
			"",
			"\1\u00ab",
			"\1\u00ac",
			"\1\u00ad\7\uffff\1\u00ae",
			"\1\u00af\24\uffff\1\u00b0",
			"\1\u00b1",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\2\74\1\u00b2\25\74\1\u00b3"+
			"\1\74\5\uffff\u1f82\74\1\uffff\udffc\74",
			"",
			"\1\u00b5",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u00b7\17\uffff\1\u00b8",
			"\1\u00b9",
			"\1\u00ba\1\uffff\1\u00bb",
			"\1\u00bc",
			"\1\u00bd",
			"\1\u00be",
			"\1\u00bf\2\uffff\1\u00c0\5\uffff\1\u00c1\6\uffff\1\u00c2",
			"\1\u00c3",
			"\1\u00c4",
			"\1\u00c5",
			"\1\u00c6",
			"\1\u00c7",
			"\1\u00c8\3\uffff\1\u00c9\6\uffff\1\u00ca",
			"\12\114",
			"",
			"\1\u00cb",
			"\1\u00cc",
			"\1\u00cd",
			"\1\u00ce",
			"\1\u00cf",
			"\1\u00d0\1\uffff\1\u00d1",
			"\1\u00d2\15\uffff\1\u00d3",
			"\1\u00d4",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u00d6",
			"\1\u00d7",
			"\1\u00d8",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\2\74\1\u00d9\1\u00da\11\74"+
			"\1\u00db\5\74\1\u00dc\6\74\5\uffff\u1f82\74\1\uffff\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u00df",
			"\1\u00e0",
			"\1\u00e1",
			"\1\u00e2",
			"\1\u00e3",
			"\1\u00e4\1\uffff\1\u00e5\5\uffff\1\u00e6",
			"\1\u00e7",
			"\1\u00e8",
			"\1\u00e9",
			"\1\u00ea",
			"\1\u00eb",
			"\1\u00ec",
			"\1\u00ed",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\13\74\1\u00ee\16\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"\1\u00f0",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\3\74\1\u00f1\26\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"\1\u00f3",
			"\1\u00f4",
			"\1\u00f5\15\uffff\1\u00f6\3\uffff\1\u00f7\1\uffff\1\u00f8",
			"\1\u00f9",
			"\1\u00fa",
			"\1\u00fb",
			"\1\u00fc",
			"\1\u00fd\4\uffff\1\u00fe\1\uffff\1\u00ff\1\u0100",
			"\1\u0101",
			"\1\u0102",
			"\1\u0103",
			"\1\u0104",
			"\1\u0105",
			"\1\u0106",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0108\23\uffff\1\u0109",
			"\1\u010a\13\uffff\1\u010b",
			"\1\u010c\2\uffff\1\u010d\13\uffff\1\u010e",
			"\1\u010f\3\uffff\1\u0110\3\uffff\1\u0111",
			"\1\u0112",
			"\1\u0113",
			"\1\u0114",
			"\1\u0115",
			"\53\u0118\1\u0116\uffd4\u0118",
			"\0\u011a",
			"",
			"",
			"",
			"\0\u011a",
			"",
			"",
			"",
			"",
			"",
			"\1\u008f\1\uffff\12\u008e\13\uffff\1\u0090\37\uffff\1\u0090",
			"\12\u011c",
			"",
			"\12\u0091\13\uffff\1\u0090\37\uffff\1\u0090",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u011e",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0121",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0124",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0126",
			"",
			"\1\u0127",
			"",
			"\1\u0128",
			"\1\u0129\1\uffff\1\u012a\16\uffff\1\u012b",
			"\1\u012c",
			"\1\u012d",
			"\1\u012e",
			"\1\u012f",
			"\1\u0130\1\u0131",
			"\1\u0132",
			"\1\u0133",
			"\1\u0134",
			"\1\u0135",
			"\1\u0136",
			"\1\u0137\22\uffff\1\u0138",
			"\1\u0139",
			"\1\u013a",
			"\1\u013b",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u013d",
			"\1\u013e",
			"\1\u013f",
			"\1\u0140",
			"\1\u0141",
			"\1\u0142",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0144",
			"\1\u0145",
			"\1\u0146",
			"\1\u0147",
			"\1\u0148",
			"\1\u0149",
			"",
			"\1\u014a",
			"\1\u014b",
			"\1\u014c",
			"\1\u014d\5\uffff\1\u014e",
			"\1\u014f",
			"\1\u0150",
			"\1\u0151",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\22\74\1\u0152\7\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"\1\u0154",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0156",
			"\1\u0157",
			"\1\u0158",
			"\1\u0159",
			"\1\u015a",
			"\1\u015b",
			"\1\u015c",
			"\1\u015d",
			"\1\u015e",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0160",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\22\74\1\u0161\7\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"\1\u0163",
			"",
			"\1\u0164",
			"\1\u0165",
			"",
			"\1\u0166",
			"\1\u0167",
			"\1\u0168",
			"\1\u0169",
			"\1\u016a",
			"\1\u016b",
			"\1\u016c",
			"\12\74\7\uffff\32\74\4\uffff\1\u016e\1\uffff\22\74\1\u016d\7\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"\1\u0170",
			"\1\u0171",
			"\1\u0172",
			"\1\u0173",
			"\1\u0174",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0176",
			"\1\u0177",
			"\1\u0178\1\uffff\1\u0179",
			"\1\u017a",
			"\1\u017b",
			"\1\u017c",
			"",
			"\1\u017d",
			"\1\u017e",
			"\1\u017f",
			"\1\u0180",
			"\1\u0181",
			"\1\u0182",
			"\1\u0183",
			"\1\u0184",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0186",
			"\1\u0187",
			"\1\u0188",
			"\1\u0189\3\uffff\1\u018a",
			"\1\u018b",
			"\0\u018d",
			"",
			"",
			"",
			"",
			"",
			"\12\u011c\13\uffff\1\u0090\37\uffff\1\u0090",
			"",
			"\1\u018e",
			"",
			"",
			"\1\u018f",
			"",
			"",
			"\1\u0190",
			"",
			"\1\u0191",
			"\1\u0192",
			"\1\u0193",
			"\1\u0194",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0197",
			"\1\u0198",
			"\1\u0199",
			"\1\u019a",
			"\1\u019b",
			"\1\u019c",
			"\1\u019d",
			"\1\u019e",
			"\1\u019f",
			"\1\u01a0",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01a2",
			"\1\u01a3",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01a5",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\1\u01a7",
			"\1\u01a8",
			"\1\u01a9",
			"\1\u01aa",
			"\1\u01ab",
			"\1\u01ac",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01af",
			"\1\u01b0",
			"\1\u01b1",
			"\1\u01b2",
			"\1\u01b3",
			"\1\u01b4",
			"\1\u01b5",
			"\1\u01b6",
			"\1\u01b7",
			"\1\u01b8",
			"\1\u01b9",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01c0",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01c2",
			"\1\u01c3",
			"\1\u01c4",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\22\74\1\u01c6\7\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"\1\u01c8",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01cb",
			"\1\u01cc",
			"\1\u01cd",
			"\1\u01ce",
			"\1\u01cf",
			"\1\u01d0",
			"\1\u01d1",
			"\1\u01d2",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01d4",
			"",
			"\1\u01d5",
			"\1\u01d6",
			"\1\u01d7",
			"\1\u01d8",
			"\1\u01d9",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01db",
			"\1\u01dc",
			"\1\u01dd",
			"\1\u01de",
			"\1\u01df",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01e1",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01e3",
			"\1\u01e4",
			"\1\u01e5",
			"\1\u01e6",
			"\1\u01e7",
			"\1\u01e8",
			"",
			"\1\u01e9",
			"\1\u01ea",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01ed",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\10\74\1\u01ee\21\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"",
			"",
			"\1\u01f0",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01f4",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01f6",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01f8",
			"\1\u01f9\20\uffff\1\u01fa",
			"\1\u01fb",
			"\1\u01fc",
			"\1\u01fd",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u01ff",
			"\1\u0200",
			"\1\u0201",
			"",
			"\1\u0202",
			"\1\u0203",
			"",
			"\1\u0204",
			"",
			"\1\u0205",
			"\1\u0206",
			"\1\u0207",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"",
			"\1\u020b",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u020e",
			"\1\u020f",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0211",
			"\1\u0212",
			"\1\u0213",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0218",
			"\1\u0219",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\1\u021b",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u021e",
			"\1\u021f",
			"\1\u0220",
			"\1\u0221",
			"\1\u0222",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\1\u0224",
			"\1\u0225",
			"\1\u0226",
			"\1\u0227",
			"\1\u0228",
			"\1\u0229",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u022c",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\22\74\1\u022d\7\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"\1\u022f",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0232",
			"\1\u0233",
			"\1\u0234",
			"\1\u0235",
			"\1\u0236",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\22\74\1\u0238\7\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u023b",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"",
			"",
			"\1\u023d",
			"",
			"\1\u023e",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\22\74\1\u023f\7\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"\1\u0241",
			"\1\u0242",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0244",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\1\u0246",
			"\1\u0247",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0249",
			"\1\u024a",
			"\1\u024b",
			"\1\u024c",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u024e",
			"",
			"",
			"",
			"\1\u024f",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\1\u0252",
			"\1\u0253",
			"\1\u0254",
			"",
			"",
			"",
			"",
			"\1\u0255",
			"\1\u0256",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"",
			"\1\u0258",
			"\1\u0259",
			"\1\u025a",
			"\1\u025b",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\1\u025d",
			"\1\u025e",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0261",
			"\1\u0262",
			"",
			"",
			"\1\u0263",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\1\u0264\31\74\5\uffff\u1f82"+
			"\74\1\uffff\udffc\74",
			"",
			"\1\u0266",
			"",
			"",
			"\1\u0267",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0269",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\1\u0271",
			"\1\u0272",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\25\74\1\u0275\4\74\5\uffff"+
			"\u1f82\74\1\uffff\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0278",
			"\1\u0279",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u027c",
			"",
			"",
			"\1\u027d",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u027f",
			"\1\u0280",
			"\1\u0281",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\1\u0286",
			"\1\u0287",
			"",
			"",
			"\1\u0288",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u028a",
			"\1\u028b",
			"",
			"\1\u028c",
			"\1\u028d",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0290",
			"",
			"",
			"\1\u0291",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0293",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u0295",
			"",
			"\1\u0296",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"",
			"",
			"",
			"\1\u0299",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\1\u029c",
			"\1\u029d",
			"\1\u029e",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"",
			"\1\u02a0",
			"\1\u02a1",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"",
			"\1\u02a5",
			"",
			"",
			"\1\u02a6",
			"\1\u02a7",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u02aa",
			"",
			"",
			"",
			"\1\u02ab",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u02ad",
			"",
			"",
			"\1\u02ae",
			"\1\u02af",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			"\1\u02b2",
			"",
			"",
			"\12\74\7\uffff\32\74\4\uffff\1\74\1\uffff\32\74\5\uffff\u1f82\74\1\uffff"+
			"\udffc\74",
			""
	};

	static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
	static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
	static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
	static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
	static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
	static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
	static final short[][] DFA20_transition;

	static {
		int numStates = DFA20_transitionS.length;
		DFA20_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
		}
	}

	protected class DFA20 extends DFA {

		public DFA20(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 20;
			this.eot = DFA20_eot;
			this.eof = DFA20_eof;
			this.min = DFA20_min;
			this.max = DFA20_max;
			this.accept = DFA20_accept;
			this.special = DFA20_special;
			this.transition = DFA20_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( ACTIVE | ADD | ALL | ALTER | AND | ANY | ARRAY | AS | ASC | ASYNC | BETWEEN | BY | CACHE | CASCADE | CASE | CAST | CLOSE | COLUMN | COLUMNS | CONSTANT | CONSTRAINT | CREATE | CURRENT | CURSOR | CYCLE | DECLARE | DEFAULT | DEFAULTVALUE | DELETE | DESC | DISABLE | DISTINCT | DROP | DUPLICATE | ELSE | END | EXECUTE | EXISTS | EXPLAIN | FALSE | FETCH | FIRST | FOR | FROM | FULL | FUNCTION | GRANT | GROUP | HAVING | IF | IGNORE | ILIKE | IMMUTABLE | IN | INCLUDE | INCREMENT | INDEX | INNER | INTO | IS | JAR | JARS | JOIN | KEY | LAST | LEFT | LIKE | LIMIT | LIST | LOCAL | MAXVALUE | MINVALUE | NEXT | NOT | NULL | NULLS | OFF | OFFSET | ON | ONLY | OPEN | OR | ORDER | OUTER | PRIMARY | REBUILD | REPLACE | RETURNS | REVOKE | RIGHT | ROW | ROWS | ROW_TIMESTAMP | SAMPLING | SCHEMA | SELECT | SEQUENCE | SESSION | SET | SOME | SPLIT | START | STATISTICS | TABLE | TABLES | TABLESAMPLE | TEMPORARY | THEN | TO | TRACE | TRUE | UNION | UNUSABLE | UPDATE | UPGRADE | UPSERT | USABLE | USE | USING | VALUE | VALUES | VIEW | WHEN | WHERE | WITH | WITHIN | HINT_START | COMMENT_START | COMMENT_AND_HINT_END | SL_COMMENT1 | SL_COMMENT2 | BIND_NAME | NAME | NUMBER | DECIMAL | DOUBLE | Exponent | DOUBLE_QUOTE | EQ | LT | GT | DOUBLE_EQ | NOEQ1 | NOEQ2 | CONCAT | COMMA | LPAREN | RPAREN | SEMICOLON | COLON | QUESTION | LSQUARE | RSQUARE | LCURLY | RCURLY | AT | TILDE | PLUS | MINUS | ASTERISK | DIVIDE | PERCENT | OUTER_JOIN | STRING_LITERAL | WS | EOL | ML_HINT | ML_COMMENT | SL_COMMENT | DOT | OTHER );";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			IntStream input = _input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA20_0 = input.LA(1);
						s = -1;
						if ( (LA20_0=='a') ) {s = 1;}
						else if ( (LA20_0=='b') ) {s = 2;}
						else if ( (LA20_0=='c') ) {s = 3;}
						else if ( (LA20_0=='d') ) {s = 4;}
						else if ( (LA20_0=='e') ) {s = 5;}
						else if ( (LA20_0=='f') ) {s = 6;}
						else if ( (LA20_0=='g') ) {s = 7;}
						else if ( (LA20_0=='h') ) {s = 8;}
						else if ( (LA20_0=='i') ) {s = 9;}
						else if ( (LA20_0=='j') ) {s = 10;}
						else if ( (LA20_0=='k') ) {s = 11;}
						else if ( (LA20_0=='l') ) {s = 12;}
						else if ( (LA20_0=='m') ) {s = 13;}
						else if ( (LA20_0=='n') ) {s = 14;}
						else if ( (LA20_0=='o') ) {s = 15;}
						else if ( (LA20_0=='p') ) {s = 16;}
						else if ( (LA20_0=='r') ) {s = 17;}
						else if ( (LA20_0=='s') ) {s = 18;}
						else if ( (LA20_0=='t') ) {s = 19;}
						else if ( (LA20_0=='u') ) {s = 20;}
						else if ( (LA20_0=='v') ) {s = 21;}
						else if ( (LA20_0=='w') ) {s = 22;}
						else if ( (LA20_0=='/') ) {s = 23;}
						else if ( (LA20_0=='*') ) {s = 24;}
						else if ( (LA20_0=='-') ) {s = 25;}
						else if ( (LA20_0==':') ) {s = 26;}
						else if ( (LA20_0=='E') ) {s = 27;}
						else if ( (LA20_0=='\"') ) {s = 28;}
						else if ( ((LA20_0 >= '0' && LA20_0 <= '9')) ) {s = 29;}
						else if ( (LA20_0=='.') ) {s = 30;}
						else if ( ((LA20_0 >= 'A' && LA20_0 <= 'D')||(LA20_0 >= 'F' && LA20_0 <= 'Z')||LA20_0=='q'||(LA20_0 >= 'x' && LA20_0 <= 'z')) ) {s = 31;}
						else if ( (LA20_0=='=') ) {s = 32;}
						else if ( (LA20_0=='<') ) {s = 33;}
						else if ( (LA20_0=='>') ) {s = 34;}
						else if ( (LA20_0=='!') ) {s = 35;}
						else if ( (LA20_0=='|') ) {s = 36;}
						else if ( (LA20_0==',') ) {s = 37;}
						else if ( (LA20_0=='(') ) {s = 38;}
						else if ( (LA20_0==')') ) {s = 39;}
						else if ( (LA20_0==';') ) {s = 40;}
						else if ( (LA20_0=='?') ) {s = 41;}
						else if ( (LA20_0=='[') ) {s = 42;}
						else if ( (LA20_0==']') ) {s = 43;}
						else if ( (LA20_0=='{') ) {s = 44;}
						else if ( (LA20_0=='}') ) {s = 45;}
						else if ( (LA20_0=='@') ) {s = 46;}
						else if ( (LA20_0=='~') ) {s = 47;}
						else if ( (LA20_0=='+') ) {s = 48;}
						else if ( (LA20_0=='%') ) {s = 49;}
						else if ( (LA20_0=='\'') ) {s = 50;}
						else if ( (LA20_0=='\t'||LA20_0==' '||LA20_0=='\u2002') ) {s = 51;}
						else if ( (LA20_0=='\n'||LA20_0=='\r') ) {s = 52;}
						else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '\b')||(LA20_0 >= '\u000B' && LA20_0 <= '\f')||(LA20_0 >= '\u000E' && LA20_0 <= '\u001F')||(LA20_0 >= '#' && LA20_0 <= '$')||LA20_0=='&'||LA20_0=='\\'||(LA20_0 >= '^' && LA20_0 <= '`')||(LA20_0 >= '\u007F' && LA20_0 <= '\u2001')||(LA20_0 >= '\u2003' && LA20_0 <= '\uFFFF')) ) {s = 53;}
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA20_132 = input.LA(1);
						s = -1;
						if ( ((LA20_132 >= '\u0000' && LA20_132 <= '\uFFFF')) ) {s = 282;}
						else s = 281;
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA20_278 = input.LA(1);
						s = -1;
						if ( ((LA20_278 >= '\u0000' && LA20_278 <= '\uFFFF')) ) {s = 397;}
						else s = 396;
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA20_136 = input.LA(1);
						s = -1;
						if ( ((LA20_136 >= '\u0000' && LA20_136 <= '\uFFFF')) ) {s = 282;}
						else s = 283;
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA20_131 = input.LA(1);
						s = -1;
						if ( (LA20_131=='+') ) {s = 278;}
						else if ( ((LA20_131 >= '\u0000' && LA20_131 <= '*')||(LA20_131 >= ',' && LA20_131 <= '\uFFFF')) ) {s = 280;}
						else s = 279;
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA20_28 = input.LA(1);
						s = -1;
						if ( ((LA20_28 >= '\u0000' && LA20_28 <= '\uFFFF')) ) {s = 60;}
						else s = 140;
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA20_50 = input.LA(1);
						s = -1;
						if ( ((LA20_50 >= '\u0000' && LA20_50 <= '\uFFFF')) ) {s = 168;}
						else s = 53;
						if ( s>=0 ) return s;
						break;
			}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 20, _s, input);
			error(nvae);
			throw nvae;
		}
	}

}
