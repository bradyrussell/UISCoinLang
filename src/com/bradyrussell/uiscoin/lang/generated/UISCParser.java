/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.generated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UISCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, CONST=76, ID=77, INT=78, FLOAT=79, HEXSTRING=80, STRING=81, 
		CHAR=82, WS=83, SL_COMMENT=84, ML_COMMENT=85, INVALID=86;
	public static final int
		RULE_file = 0, RULE_pointer = 1, RULE_varDeclaration = 2, RULE_structDeclaration = 3, 
		RULE_type = 4, RULE_primitiveType = 5, RULE_structType = 6, RULE_inferredType = 7, 
		RULE_booleanLiteral = 8, RULE_arrayInitializer = 9, RULE_functionDeclaration = 10, 
		RULE_formalParameters = 11, RULE_formalParameter = 12, RULE_block = 13, 
		RULE_statement = 14, RULE_elseifStatement = 15, RULE_elseStatement = 16, 
		RULE_tryStatement = 17, RULE_catchStatement = 18, RULE_number = 19, RULE_assembly = 20, 
		RULE_assertion = 21, RULE_exception = 22, RULE_include = 23, RULE_flag = 24, 
		RULE_flagData = 25, RULE_structField = 26, RULE_expression = 27, RULE_exprList = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "pointer", "varDeclaration", "structDeclaration", "type", "primitiveType", 
			"structType", "inferredType", "booleanLiteral", "arrayInitializer", "functionDeclaration", 
			"formalParameters", "formalParameter", "block", "statement", "elseifStatement", 
			"elseStatement", "tryStatement", "catchStatement", "number", "assembly", 
			"assertion", "exception", "include", "flag", "flagData", "structField", 
			"expression", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'='", "';'", "'[]'", "'['", "']'", "'struct'", "'{'", "'}'", 
			"'void'", "'byte'", "'int32'", "'int64'", "'float'", "'var'", "'auto'", 
			"'true'", "'false'", "'null'", "'('", "')'", "','", "'if'", "'ufori'", 
			"'as'", "'uforeach'", "'while'", "'for'", "'return'", "'+='", "'-='", 
			"'*='", "'/='", "'%='", "'&='", "'|='", "'^='", "'break'", "'continue'", 
			"'else'", "'try'", "'catch'", "'asm'", "'assert'", "'throw'", "'include'", 
			"'flag'", "'flagdata'", "'.'", "'_'", "'$'", "'#'", "'-'", "'!'", "'--'", 
			"'++'", "'%'", "'*'", "'/'", "'+'", "'&'", "'|'", "'^'", "'~'", "'&&'", 
			"'||'", "'^^'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'?'", 
			"':'", "'const'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "CONST", "ID", "INT", "FLOAT", "HEXSTRING", "STRING", 
			"CHAR", "WS", "SL_COMMENT", "ML_COMMENT", "INVALID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "UISC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UISCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(61);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(58);
					functionDeclaration();
					}
					break;
				case 2:
					{
					setState(59);
					varDeclaration();
					}
					break;
				case 3:
					{
					setState(60);
					statement();
					}
					break;
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (CONST - 76)) | (1L << (ID - 76)) | (1L << (INT - 76)) | (1L << (FLOAT - 76)) | (1L << (STRING - 76)) | (1L << (CHAR - 76)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PointerContext extends ParserRuleContext {
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	 
		public VarDeclarationContext() { }
		public void copyFrom(VarDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarInitializationContext extends VarDeclarationContext {
		public Token constant;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CONST() { return getToken(UISCParser.CONST, 0); }
		public VarInitializationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterVarInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitVarInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitVarInitialization(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAssignmentInitializationContext extends VarDeclarationContext {
		public Token size;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public TerminalNode INT() { return getToken(UISCParser.INT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayAssignmentInitializationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayAssignmentInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayAssignmentInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayAssignmentInitialization(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayStringInitializationContext extends VarDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public ArrayStringInitializationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayStringInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayStringInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayStringInitialization(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayValueInitializationContext extends VarDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayValueInitializationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayValueInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayValueInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayValueInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDeclaration);
		int _la;
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new VarInitializationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST) {
					{
					setState(67);
					((VarInitializationContext)_localctx).constant = match(CONST);
					}
				}

				setState(70);
				type();
				setState(71);
				match(ID);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(72);
					match(T__1);
					setState(73);
					expression(0);
					}
				}

				setState(76);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new ArrayValueInitializationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				type();
				setState(79);
				match(ID);
				setState(80);
				match(T__3);
				setState(81);
				match(T__1);
				setState(82);
				arrayInitializer();
				setState(83);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new ArrayStringInitializationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				type();
				setState(86);
				match(ID);
				setState(87);
				match(T__3);
				setState(88);
				match(T__1);
				setState(89);
				match(STRING);
				setState(90);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new ArrayAssignmentInitializationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				type();
				setState(93);
				match(ID);
				setState(94);
				match(T__4);
				setState(95);
				((ArrayAssignmentInitializationContext)_localctx).size = match(INT);
				setState(96);
				match(T__5);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(97);
					match(T__1);
					setState(98);
					expression(0);
					}
				}

				setState(101);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__6);
			setState(106);
			match(ID);
			setState(107);
			match(T__7);
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				varDeclaration();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0) || _la==CONST || _la==ID );
			setState(113);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public InferredTypeContext inferredType() {
			return getRuleContext(InferredTypeContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				{
				setState(115);
				primitiveType();
				}
				break;
			case ID:
				{
				setState(116);
				structType();
				}
				break;
			case T__14:
			case T__15:
				{
				setState(117);
				inferredType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(120);
				pointer();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public StructTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructTypeContext structType() throws RecognitionException {
		StructTypeContext _localctx = new StructTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InferredTypeContext extends ParserRuleContext {
		public InferredTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inferredType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterInferredType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitInferredType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitInferredType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InferredTypeContext inferredType() throws RecognitionException {
		InferredTypeContext _localctx = new InferredTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_inferredType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__15) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanLiteralContext extends ParserRuleContext {
		public Token trueliteral;
		public Token falseliteral;
		public Token nullliteral;
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_booleanLiteral);
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				((BooleanLiteralContext)_localctx).trueliteral = match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				((BooleanLiteralContext)_localctx).falseliteral = match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				((BooleanLiteralContext)_localctx).nullliteral = match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayInitializerContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__7);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (ID - 77)) | (1L << (INT - 77)) | (1L << (FLOAT - 77)) | (1L << (STRING - 77)) | (1L << (CHAR - 77)))) != 0)) {
				{
				setState(135);
				exprList();
				}
			}

			setState(138);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public Token array;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			type();
			setState(141);
			match(ID);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(142);
				((FunctionDeclarationContext)_localctx).array = match(T__3);
				}
			}

			setState(145);
			match(T__19);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0) || _la==ID) {
				{
				setState(146);
				formalParameters();
				}
			}

			setState(149);
			match(T__20);
			setState(150);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			formalParameter();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(153);
				match(T__21);
				setState(154);
				formalParameter();
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			type();
			setState(161);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__7);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (CONST - 76)) | (1L << (ID - 76)) | (1L << (INT - 76)) | (1L << (FLOAT - 76)) | (1L << (STRING - 76)) | (1L << (CHAR - 76)))) != 0)) {
				{
				{
				setState(164);
				statement();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssertionStatementContext extends StatementContext {
		public AssertionContext assertion() {
			return getRuleContext(AssertionContext.class,0);
		}
		public AssertionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssertionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssertionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssertionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FlagStatementContext extends StatementContext {
		public FlagContext flag() {
			return getRuleContext(FlagContext.class,0);
		}
		public FlagStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFlagStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFlagStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFlagStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UforiStatementContext extends StatementContext {
		public Token iterations;
		public Token iterationsEnd;
		public Token as;
		public StatementContext forbody;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public List<TerminalNode> INT() { return getTokens(UISCParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(UISCParser.INT, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public UforiStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterUforiStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitUforiStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitUforiStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatementContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UforeachStatementContext extends StatementContext {
		public Token arrayToLoop;
		public Token as;
		public StatementContext forbody;
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public UforeachStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterUforeachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitUforeachStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitUforeachStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentStatementContext extends StatementContext {
		public Token lhs;
		public StructFieldContext lhs_struct;
		public ExpressionContext arrayIndex;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public StructFieldContext structField() {
			return getRuleContext(StructFieldContext.class,0);
		}
		public AssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatementContext extends StatementContext {
		public ExpressionContext conditional;
		public StatementContext afterEach;
		public StatementContext forbody;
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStatementContext extends StatementContext {
		public BreakStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public ExpressionContext conditional;
		public StatementContext ifbody;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ElseifStatementContext> elseifStatement() {
			return getRuleContexts(ElseifStatementContext.class);
		}
		public ElseifStatementContext elseifStatement(int i) {
			return getRuleContext(ElseifStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatementContext extends StatementContext {
		public ExpressionContext retval;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FlagDataStatementContext extends StatementContext {
		public FlagDataContext flagData() {
			return getRuleContext(FlagDataContext.class,0);
		}
		public FlagDataStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFlagDataStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFlagDataStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFlagDataStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclarationStatementContext extends StatementContext {
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public VarDeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterVarDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitVarDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitVarDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TryCatchStatementContext extends StatementContext {
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public CatchStatementContext catchStatement() {
			return getRuleContext(CatchStatementContext.class,0);
		}
		public TryCatchStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterTryCatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitTryCatchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitTryCatchStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExceptionStatementContext extends StatementContext {
		public ExceptionContext exception() {
			return getRuleContext(ExceptionContext.class,0);
		}
		public ExceptionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterExceptionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitExceptionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitExceptionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatementContext extends StatementContext {
		public StatementContext whilebody;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpAndAssignmentStatementContext extends StatementContext {
		public Token lhs;
		public StructFieldContext lhs_struct;
		public ExpressionContext arrayIndex;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public StructFieldContext structField() {
			return getRuleContext(StructFieldContext.class,0);
		}
		public OpAndAssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterOpAndAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitOpAndAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitOpAndAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssemblyStatementContext extends StatementContext {
		public AssemblyContext assembly() {
			return getRuleContext(AssemblyContext.class,0);
		}
		public AssemblyStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssemblyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssemblyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssemblyStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncludeStatementContext extends StatementContext {
		public IncludeContext include() {
			return getRuleContext(IncludeContext.class,0);
		}
		public IncludeStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterIncludeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitIncludeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitIncludeStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionCallStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFunctionCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFunctionCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFunctionCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructDeclarationStatementContext extends StatementContext {
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public StructDeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStatementContext extends StatementContext {
		public ContinueStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				block();
				}
				break;
			case 2:
				_localctx = new VarDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				varDeclaration();
				}
				break;
			case 3:
				_localctx = new StructDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				structDeclaration();
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				match(T__22);
				setState(176);
				((IfStatementContext)_localctx).conditional = expression(0);
				setState(177);
				match(T__7);
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178);
					((IfStatementContext)_localctx).ifbody = statement();
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (CONST - 76)) | (1L << (ID - 76)) | (1L << (INT - 76)) | (1L << (FLOAT - 76)) | (1L << (STRING - 76)) | (1L << (CHAR - 76)))) != 0) );
				setState(183);
				match(T__8);
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(184);
						elseifStatement();
						}
						} 
					}
					setState(189);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__39) {
					{
					setState(190);
					elseStatement();
					}
				}

				}
				break;
			case 5:
				_localctx = new UforiStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				match(T__23);
				setState(194);
				match(T__19);
				setState(195);
				((UforiStatementContext)_localctx).iterations = match(INT);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__21) {
					{
					setState(196);
					match(T__21);
					setState(197);
					((UforiStatementContext)_localctx).iterationsEnd = match(INT);
					}
				}

				setState(200);
				((UforiStatementContext)_localctx).as = match(T__24);
				setState(201);
				type();
				setState(202);
				match(ID);
				setState(203);
				match(T__20);
				setState(205); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(204);
						((UforiStatementContext)_localctx).forbody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(207); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 6:
				_localctx = new UforeachStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(209);
				match(T__25);
				setState(210);
				match(T__19);
				setState(211);
				((UforeachStatementContext)_localctx).arrayToLoop = match(ID);
				setState(212);
				((UforeachStatementContext)_localctx).as = match(T__24);
				setState(213);
				varDeclaration();
				setState(214);
				match(T__20);
				setState(216); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(215);
						((UforeachStatementContext)_localctx).forbody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(218); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 7:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(220);
				match(T__26);
				setState(221);
				match(T__19);
				setState(222);
				expression(0);
				setState(223);
				match(T__20);
				setState(225); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(224);
						((WhileStatementContext)_localctx).whilebody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(227); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 8:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(229);
				match(T__27);
				setState(230);
				match(T__19);
				setState(231);
				varDeclaration();
				setState(232);
				((ForStatementContext)_localctx).conditional = expression(0);
				setState(233);
				match(T__2);
				setState(234);
				((ForStatementContext)_localctx).afterEach = statement();
				setState(235);
				match(T__20);
				setState(237); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(236);
						((ForStatementContext)_localctx).forbody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(239); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 9:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(241);
				match(T__28);
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (ID - 77)) | (1L << (INT - 77)) | (1L << (FLOAT - 77)) | (1L << (STRING - 77)) | (1L << (CHAR - 77)))) != 0)) {
					{
					setState(242);
					((ReturnStatementContext)_localctx).retval = expression(0);
					}
				}

				setState(245);
				match(T__2);
				}
				break;
			case 10:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(248);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(246);
					((AssignmentStatementContext)_localctx).lhs = match(ID);
					}
					break;
				case 2:
					{
					setState(247);
					((AssignmentStatementContext)_localctx).lhs_struct = structField();
					}
					break;
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(250);
					match(T__4);
					setState(251);
					((AssignmentStatementContext)_localctx).arrayIndex = expression(0);
					setState(252);
					match(T__5);
					}
				}

				setState(256);
				match(T__1);
				setState(257);
				((AssignmentStatementContext)_localctx).rhs = expression(0);
				setState(258);
				match(T__2);
				}
				break;
			case 11:
				_localctx = new OpAndAssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(262);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(260);
					((OpAndAssignmentStatementContext)_localctx).lhs = match(ID);
					}
					break;
				case 2:
					{
					setState(261);
					((OpAndAssignmentStatementContext)_localctx).lhs_struct = structField();
					}
					break;
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(264);
					match(T__4);
					setState(265);
					((OpAndAssignmentStatementContext)_localctx).arrayIndex = expression(0);
					setState(266);
					match(T__5);
					}
				}

				setState(270);
				((OpAndAssignmentStatementContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
					((OpAndAssignmentStatementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(271);
				((OpAndAssignmentStatementContext)_localctx).rhs = expression(0);
				setState(272);
				match(T__2);
				}
				break;
			case 12:
				_localctx = new TryCatchStatementContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(274);
				tryStatement();
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__41) {
					{
					setState(275);
					catchStatement();
					}
				}

				}
				break;
			case 13:
				_localctx = new FunctionCallStatementContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(278);
				expression(0);
				setState(279);
				match(T__2);
				}
				break;
			case 14:
				_localctx = new AssemblyStatementContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(281);
				assembly();
				}
				break;
			case 15:
				_localctx = new AssertionStatementContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(282);
				assertion();
				}
				break;
			case 16:
				_localctx = new ExceptionStatementContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(283);
				exception();
				}
				break;
			case 17:
				_localctx = new IncludeStatementContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(284);
				include();
				}
				break;
			case 18:
				_localctx = new FlagStatementContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(285);
				flag();
				}
				break;
			case 19:
				_localctx = new FlagDataStatementContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(286);
				flagData();
				}
				break;
			case 20:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(287);
				match(T__37);
				setState(288);
				match(T__2);
				}
				break;
			case 21:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(289);
				match(T__38);
				setState(290);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseifStatementContext extends ParserRuleContext {
		public ExpressionContext conditional;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterElseifStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitElseifStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitElseifStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifStatementContext elseifStatement() throws RecognitionException {
		ElseifStatementContext _localctx = new ElseifStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_elseifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(T__39);
			setState(294);
			match(T__22);
			setState(295);
			match(T__19);
			setState(296);
			((ElseifStatementContext)_localctx).conditional = expression(0);
			setState(297);
			match(T__20);
			setState(298);
			match(T__7);
			setState(300); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(299);
				statement();
				}
				}
				setState(302); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (CONST - 76)) | (1L << (ID - 76)) | (1L << (INT - 76)) | (1L << (FLOAT - 76)) | (1L << (STRING - 76)) | (1L << (CHAR - 76)))) != 0) );
			setState(304);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(T__39);
			setState(307);
			match(T__7);
			setState(309); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(308);
				statement();
				}
				}
				setState(311); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (CONST - 76)) | (1L << (ID - 76)) | (1L << (INT - 76)) | (1L << (FLOAT - 76)) | (1L << (STRING - 76)) | (1L << (CHAR - 76)))) != 0) );
			setState(313);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitTryStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitTryStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_tryStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(T__40);
			setState(316);
			match(T__7);
			setState(318); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(317);
				statement();
				}
				}
				setState(320); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (CONST - 76)) | (1L << (ID - 76)) | (1L << (INT - 76)) | (1L << (FLOAT - 76)) | (1L << (STRING - 76)) | (1L << (CHAR - 76)))) != 0) );
			setState(322);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchStatementContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CatchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterCatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitCatchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitCatchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchStatementContext catchStatement() throws RecognitionException {
		CatchStatementContext _localctx = new CatchStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_catchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(T__41);
			setState(325);
			match(T__19);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (ID - 77)) | (1L << (INT - 77)) | (1L << (FLOAT - 77)) | (1L << (STRING - 77)) | (1L << (CHAR - 77)))) != 0)) {
				{
				setState(326);
				exprList();
				}
			}

			setState(329);
			match(T__20);
			setState(330);
			match(T__7);
			setState(332); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(331);
				statement();
				}
				}
				setState(334); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__22) | (1L << T__23) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__37) | (1L << T__38) | (1L << T__40) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (CONST - 76)) | (1L << (ID - 76)) | (1L << (INT - 76)) | (1L << (FLOAT - 76)) | (1L << (STRING - 76)) | (1L << (CHAR - 76)))) != 0) );
			setState(336);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(UISCParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(UISCParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssemblyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssembly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assembly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(T__42);
			setState(341);
			match(T__19);
			setState(342);
			match(STRING);
			setState(343);
			match(T__20);
			setState(344);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssertionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssertion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssertion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertionContext assertion() throws RecognitionException {
		AssertionContext _localctx = new AssertionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(T__43);
			setState(347);
			match(T__19);
			setState(348);
			expression(0);
			setState(349);
			match(T__20);
			setState(350);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExceptionContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ExceptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exception; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterException(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitException(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitException(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptionContext exception() throws RecognitionException {
		ExceptionContext _localctx = new ExceptionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_exception);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(T__44);
			setState(353);
			match(T__19);
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (ID - 77)) | (1L << (INT - 77)) | (1L << (FLOAT - 77)) | (1L << (STRING - 77)) | (1L << (CHAR - 77)))) != 0)) {
				{
				setState(354);
				exprList();
				}
			}

			setState(357);
			match(T__20);
			setState(358);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitInclude(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitInclude(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(T__45);
			setState(361);
			match(T__19);
			setState(362);
			match(STRING);
			setState(363);
			match(T__20);
			setState(364);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlagContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(UISCParser.INT, 0); }
		public FlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFlag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFlag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFlag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlagContext flag() throws RecognitionException {
		FlagContext _localctx = new FlagContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_flag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(T__46);
			setState(367);
			match(T__19);
			setState(368);
			match(INT);
			setState(369);
			match(T__20);
			setState(370);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlagDataContext extends ParserRuleContext {
		public List<TerminalNode> HEXSTRING() { return getTokens(UISCParser.HEXSTRING); }
		public TerminalNode HEXSTRING(int i) {
			return getToken(UISCParser.HEXSTRING, i);
		}
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public FlagDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flagData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFlagData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFlagData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFlagData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlagDataContext flagData() throws RecognitionException {
		FlagDataContext _localctx = new FlagDataContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_flagData);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			match(T__47);
			setState(373);
			match(T__19);
			setState(374);
			match(HEXSTRING);
			setState(375);
			match(T__21);
			setState(376);
			_la = _input.LA(1);
			if ( !(_la==HEXSTRING || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(377);
			match(T__20);
			setState(378);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StructFieldContext extends ParserRuleContext {
		public Token structname;
		public ExpressionContext structArrayIndex;
		public Token fieldname;
		public ExpressionContext fieldArrayIndex;
		public List<TerminalNode> ID() { return getTokens(UISCParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UISCParser.ID, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_structField);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			((StructFieldContext)_localctx).structname = match(ID);
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(381);
				match(T__4);
				setState(382);
				((StructFieldContext)_localctx).structArrayIndex = expression(0);
				setState(383);
				match(T__5);
				}
			}

			setState(395); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(387);
					match(T__48);
					setState(388);
					((StructFieldContext)_localctx).fieldname = match(ID);
					setState(393);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						setState(389);
						match(T__4);
						setState(390);
						((StructFieldContext)_localctx).fieldArrayIndex = expression(0);
						setState(391);
						match(T__5);
						}
						break;
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(397); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PostfixOpExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PostfixOpExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterPostfixOpExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitPostfixOpExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitPostfixOpExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModuloExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ModuloExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterModuloExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitModuloExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitModuloExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultDivExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterMultDivExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitMultDivExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitMultDivExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixOpExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixOpExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterPrefixOpExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitPrefixOpExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitPrefixOpExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralExpressionContext extends ExpressionContext {
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public BooleanLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBooleanLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBooleanLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBooleanLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberLiteralExpressionContext extends ExpressionContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNumberLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNumberLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNumberLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueAtVariableExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ValueAtVariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterValueAtVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitValueAtVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitValueAtVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastExpressionContext extends ExpressionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NativeCallExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public NativeCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNativeCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNativeCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNativeCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SizeOfExpressionContext extends ExpressionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SizeOfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterSizeOfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitSizeOfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitSizeOfExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFunctionCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BitwiseExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBitwiseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBitwiseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBitwiseExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegateExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegateExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNegateExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNegateExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNegateExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddressOfVariableExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public AddressOfVariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAddressOfVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAddressOfVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAddressOfVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LengthOfExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LengthOfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterLengthOfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitLengthOfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitLengthOfExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructFieldReferenceExpressionContext extends ExpressionContext {
		public StructFieldContext structField() {
			return getRuleContext(StructFieldContext.class,0);
		}
		public StructFieldReferenceExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructFieldReferenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructFieldReferenceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructFieldReferenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralExpressionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public StringLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStringLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStringLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStringLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAccessExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayAccessExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableReferenceExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public VariableReferenceExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterVariableReferenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitVariableReferenceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitVariableReferenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddSubExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAddSubExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAddSubExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAddSubExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndOrXorExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndOrXorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAndOrXorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAndOrXorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAndOrXorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiteralExpressionContext extends ExpressionContext {
		public TerminalNode CHAR() { return getToken(UISCParser.CHAR, 0); }
		public CharLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterCharLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitCharLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitCharLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExpressionContext extends ExpressionContext {
		public ExpressionContext condition;
		public ExpressionContext iftrue;
		public ExpressionContext iffalse;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				_localctx = new CastExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(400);
				match(T__19);
				setState(401);
				type();
				setState(402);
				match(T__20);
				setState(403);
				expression(27);
				}
				break;
			case 2:
				{
				_localctx = new NativeCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(405);
				match(T__49);
				setState(406);
				match(ID);
				setState(407);
				match(T__19);
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (ID - 77)) | (1L << (INT - 77)) | (1L << (FLOAT - 77)) | (1L << (STRING - 77)) | (1L << (CHAR - 77)))) != 0)) {
					{
					setState(408);
					exprList();
					}
				}

				setState(411);
				match(T__20);
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(412);
				match(ID);
				setState(413);
				match(T__19);
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & ((1L << (ID - 77)) | (1L << (INT - 77)) | (1L << (FLOAT - 77)) | (1L << (STRING - 77)) | (1L << (CHAR - 77)))) != 0)) {
					{
					setState(414);
					exprList();
					}
				}

				setState(417);
				match(T__20);
				}
				break;
			case 4:
				{
				_localctx = new ArrayAccessExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(418);
				match(ID);
				setState(419);
				match(T__4);
				setState(420);
				expression(0);
				setState(421);
				match(T__5);
				}
				break;
			case 5:
				{
				_localctx = new AddressOfVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(423);
				match(T__50);
				setState(424);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new ValueAtVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(425);
				match(T__0);
				setState(426);
				expression(22);
				}
				break;
			case 7:
				{
				_localctx = new LengthOfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(427);
				match(T__51);
				setState(428);
				expression(21);
				}
				break;
			case 8:
				{
				_localctx = new SizeOfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(429);
				match(T__51);
				setState(430);
				type();
				}
				break;
			case 9:
				{
				_localctx = new NegateExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(431);
				match(T__52);
				setState(432);
				expression(19);
				}
				break;
			case 10:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(433);
				match(T__53);
				setState(434);
				expression(18);
				}
				break;
			case 11:
				{
				_localctx = new PrefixOpExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(435);
				((PrefixOpExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__54 || _la==T__55) ) {
					((PrefixOpExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(436);
				expression(17);
				}
				break;
			case 12:
				{
				_localctx = new VariableReferenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(437);
				match(ID);
				}
				break;
			case 13:
				{
				_localctx = new StructFieldReferenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(438);
				structField();
				}
				break;
			case 14:
				{
				_localctx = new NumberLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(439);
				number();
				}
				break;
			case 15:
				{
				_localctx = new BooleanLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(440);
				booleanLiteral();
				}
				break;
			case 16:
				{
				_localctx = new StringLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(441);
				match(STRING);
				}
				break;
			case 17:
				{
				_localctx = new CharLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(442);
				match(CHAR);
				}
				break;
			case 18:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(443);
				match(T__19);
				setState(444);
				expression(0);
				setState(445);
				match(T__20);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(480);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(478);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						_localctx = new ModuloExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ModuloExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(449);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						{
						setState(450);
						match(T__56);
						}
						setState(451);
						((ModuloExpressionContext)_localctx).rhs = expression(16);
						}
						break;
					case 2:
						{
						_localctx = new MultDivExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((MultDivExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(452);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(453);
						((MultDivExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__57 || _la==T__58) ) {
							((MultDivExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(454);
						((MultDivExpressionContext)_localctx).rhs = expression(15);
						}
						break;
					case 3:
						{
						_localctx = new AddSubExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(455);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(456);
						((AddSubExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__52 || _la==T__59) ) {
							((AddSubExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(457);
						((AddSubExpressionContext)_localctx).rhs = expression(14);
						}
						break;
					case 4:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((BitwiseExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(458);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(459);
						((BitwiseExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & ((1L << (T__60 - 61)) | (1L << (T__61 - 61)) | (1L << (T__62 - 61)) | (1L << (T__63 - 61)))) != 0)) ) {
							((BitwiseExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(460);
						((BitwiseExpressionContext)_localctx).rhs = expression(13);
						}
						break;
					case 5:
						{
						_localctx = new AndOrXorExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AndOrXorExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(461);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(462);
						((AndOrXorExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (T__64 - 65)) | (1L << (T__65 - 65)) | (1L << (T__66 - 65)))) != 0)) ) {
							((AndOrXorExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(463);
						((AndOrXorExpressionContext)_localctx).rhs = expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(464);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(465);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & ((1L << (T__67 - 68)) | (1L << (T__68 - 68)) | (1L << (T__69 - 68)) | (1L << (T__70 - 68)))) != 0)) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(466);
						((ComparisonExpressionContext)_localctx).rhs = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((EqualityExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(467);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(468);
						((EqualityExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__71 || _la==T__72) ) {
							((EqualityExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(469);
						((EqualityExpressionContext)_localctx).rhs = expression(10);
						}
						break;
					case 8:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((TernaryExpressionContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(470);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(471);
						match(T__73);
						setState(472);
						((TernaryExpressionContext)_localctx).iftrue = expression(0);
						setState(473);
						match(T__74);
						setState(474);
						((TernaryExpressionContext)_localctx).iffalse = expression(2);
						}
						break;
					case 9:
						{
						_localctx = new PostfixOpExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(476);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(477);
						((PostfixOpExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__54 || _la==T__55) ) {
							((PostfixOpExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(482);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			expression(0);
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__21) {
				{
				{
				setState(484);
				match(T__21);
				setState(485);
				expression(0);
				}
				}
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 27:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3X\u01ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\6\2@\n"+
		"\2\r\2\16\2A\3\3\3\3\3\4\5\4G\n\4\3\4\3\4\3\4\3\4\5\4M\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4f\n\4\3\4\3\4\5\4j\n\4\3\5\3\5\3\5\3\5\6\5p\n\5\r\5\16\5"+
		"q\3\5\3\5\3\6\3\6\3\6\5\6y\n\6\3\6\5\6|\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\n\5\n\u0087\n\n\3\13\3\13\5\13\u008b\n\13\3\13\3\13\3\f\3\f\3"+
		"\f\5\f\u0092\n\f\3\f\3\f\5\f\u0096\n\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u009e"+
		"\n\r\f\r\16\r\u00a1\13\r\3\16\3\16\3\16\3\17\3\17\7\17\u00a8\n\17\f\17"+
		"\16\17\u00ab\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\6\20\u00b6"+
		"\n\20\r\20\16\20\u00b7\3\20\3\20\7\20\u00bc\n\20\f\20\16\20\u00bf\13\20"+
		"\3\20\5\20\u00c2\n\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c9\n\20\3\20\3"+
		"\20\3\20\3\20\3\20\6\20\u00d0\n\20\r\20\16\20\u00d1\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\6\20\u00db\n\20\r\20\16\20\u00dc\3\20\3\20\3\20\3\20\3"+
		"\20\6\20\u00e4\n\20\r\20\16\20\u00e5\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\6\20\u00f0\n\20\r\20\16\20\u00f1\3\20\3\20\5\20\u00f6\n\20\3\20"+
		"\3\20\3\20\5\20\u00fb\n\20\3\20\3\20\3\20\3\20\5\20\u0101\n\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\5\20\u0109\n\20\3\20\3\20\3\20\3\20\5\20\u010f"+
		"\n\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0117\n\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0126\n\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\6\21\u012f\n\21\r\21\16\21\u0130\3\21\3\21\3"+
		"\22\3\22\3\22\6\22\u0138\n\22\r\22\16\22\u0139\3\22\3\22\3\23\3\23\3\23"+
		"\6\23\u0141\n\23\r\23\16\23\u0142\3\23\3\23\3\24\3\24\3\24\5\24\u014a"+
		"\n\24\3\24\3\24\3\24\6\24\u014f\n\24\r\24\16\24\u0150\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\5\30\u0166\n\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u0184\n\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u018c\n\34\6\34\u018e\n\34\r\34\16\34\u018f\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u019c\n\35\3\35\3\35\3\35\3\35\5\35"+
		"\u01a2\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\5\35\u01c2\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u01e1\n\35\f\35\16\35\u01e4"+
		"\13\35\3\36\3\36\3\36\7\36\u01e9\n\36\f\36\16\36\u01ec\13\36\3\36\2\3"+
		"8\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\16"+
		"\3\2\f\20\3\2\21\22\3\2 \'\3\2PQ\3\2RS\3\29:\3\2<=\4\2\67\67>>\3\2?B\3"+
		"\2CE\3\2FI\3\2JK\2\u022c\2?\3\2\2\2\4C\3\2\2\2\6i\3\2\2\2\bk\3\2\2\2\n"+
		"x\3\2\2\2\f}\3\2\2\2\16\177\3\2\2\2\20\u0081\3\2\2\2\22\u0086\3\2\2\2"+
		"\24\u0088\3\2\2\2\26\u008e\3\2\2\2\30\u009a\3\2\2\2\32\u00a2\3\2\2\2\34"+
		"\u00a5\3\2\2\2\36\u0125\3\2\2\2 \u0127\3\2\2\2\"\u0134\3\2\2\2$\u013d"+
		"\3\2\2\2&\u0146\3\2\2\2(\u0154\3\2\2\2*\u0156\3\2\2\2,\u015c\3\2\2\2."+
		"\u0162\3\2\2\2\60\u016a\3\2\2\2\62\u0170\3\2\2\2\64\u0176\3\2\2\2\66\u017e"+
		"\3\2\2\28\u01c1\3\2\2\2:\u01e5\3\2\2\2<@\5\26\f\2=@\5\6\4\2>@\5\36\20"+
		"\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\3\3\2"+
		"\2\2CD\7\3\2\2D\5\3\2\2\2EG\7N\2\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\5\n"+
		"\6\2IL\7O\2\2JK\7\4\2\2KM\58\35\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\5"+
		"\2\2Oj\3\2\2\2PQ\5\n\6\2QR\7O\2\2RS\7\6\2\2ST\7\4\2\2TU\5\24\13\2UV\7"+
		"\5\2\2Vj\3\2\2\2WX\5\n\6\2XY\7O\2\2YZ\7\6\2\2Z[\7\4\2\2[\\\7S\2\2\\]\7"+
		"\5\2\2]j\3\2\2\2^_\5\n\6\2_`\7O\2\2`a\7\7\2\2ab\7P\2\2be\7\b\2\2cd\7\4"+
		"\2\2df\58\35\2ec\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\7\5\2\2hj\3\2\2\2iF\3\2"+
		"\2\2iP\3\2\2\2iW\3\2\2\2i^\3\2\2\2j\7\3\2\2\2kl\7\t\2\2lm\7O\2\2mo\7\n"+
		"\2\2np\5\6\4\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\13"+
		"\2\2t\t\3\2\2\2uy\5\f\7\2vy\5\16\b\2wy\5\20\t\2xu\3\2\2\2xv\3\2\2\2xw"+
		"\3\2\2\2y{\3\2\2\2z|\5\4\3\2{z\3\2\2\2{|\3\2\2\2|\13\3\2\2\2}~\t\2\2\2"+
		"~\r\3\2\2\2\177\u0080\7O\2\2\u0080\17\3\2\2\2\u0081\u0082\t\3\2\2\u0082"+
		"\21\3\2\2\2\u0083\u0087\7\23\2\2\u0084\u0087\7\24\2\2\u0085\u0087\7\25"+
		"\2\2\u0086\u0083\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087"+
		"\23\3\2\2\2\u0088\u008a\7\n\2\2\u0089\u008b\5:\36\2\u008a\u0089\3\2\2"+
		"\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7\13\2\2\u008d"+
		"\25\3\2\2\2\u008e\u008f\5\n\6\2\u008f\u0091\7O\2\2\u0090\u0092\7\6\2\2"+
		"\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095"+
		"\7\26\2\2\u0094\u0096\5\30\r\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\u0098\7\27\2\2\u0098\u0099\5\34\17\2\u0099"+
		"\27\3\2\2\2\u009a\u009f\5\32\16\2\u009b\u009c\7\30\2\2\u009c\u009e\5\32"+
		"\16\2\u009d\u009b\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\31\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3\5\n\6"+
		"\2\u00a3\u00a4\7O\2\2\u00a4\33\3\2\2\2\u00a5\u00a9\7\n\2\2\u00a6\u00a8"+
		"\5\36\20\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2"+
		"\u00a9\u00aa\3\2\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad"+
		"\7\13\2\2\u00ad\35\3\2\2\2\u00ae\u0126\5\34\17\2\u00af\u0126\5\6\4\2\u00b0"+
		"\u0126\5\b\5\2\u00b1\u00b2\7\31\2\2\u00b2\u00b3\58\35\2\u00b3\u00b5\7"+
		"\n\2\2\u00b4\u00b6\5\36\20\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bd\7\13"+
		"\2\2\u00ba\u00bc\5 \21\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2"+
		"\2\2\u00c0\u00c2\5\"\22\2\u00c1\u00c0\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u0126\3\2\2\2\u00c3\u00c4\7\32\2\2\u00c4\u00c5\7\26\2\2\u00c5\u00c8\7"+
		"P\2\2\u00c6\u00c7\7\30\2\2\u00c7\u00c9\7P\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\7\33\2\2\u00cb\u00cc\5"+
		"\n\6\2\u00cc\u00cd\7O\2\2\u00cd\u00cf\7\27\2\2\u00ce\u00d0\5\36\20\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u0126\3\2\2\2\u00d3\u00d4\7\34\2\2\u00d4\u00d5\7\26\2\2\u00d5"+
		"\u00d6\7O\2\2\u00d6\u00d7\7\33\2\2\u00d7\u00d8\5\6\4\2\u00d8\u00da\7\27"+
		"\2\2\u00d9\u00db\5\36\20\2\u00da\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u0126\3\2\2\2\u00de\u00df\7\35"+
		"\2\2\u00df\u00e0\7\26\2\2\u00e0\u00e1\58\35\2\u00e1\u00e3\7\27\2\2\u00e2"+
		"\u00e4\5\36\20\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3"+
		"\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u0126\3\2\2\2\u00e7\u00e8\7\36\2\2\u00e8"+
		"\u00e9\7\26\2\2\u00e9\u00ea\5\6\4\2\u00ea\u00eb\58\35\2\u00eb\u00ec\7"+
		"\5\2\2\u00ec\u00ed\5\36\20\2\u00ed\u00ef\7\27\2\2\u00ee\u00f0\5\36\20"+
		"\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2"+
		"\3\2\2\2\u00f2\u0126\3\2\2\2\u00f3\u00f5\7\37\2\2\u00f4\u00f6\58\35\2"+
		"\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u0126"+
		"\7\5\2\2\u00f8\u00fb\7O\2\2\u00f9\u00fb\5\66\34\2\u00fa\u00f8\3\2\2\2"+
		"\u00fa\u00f9\3\2\2\2\u00fb\u0100\3\2\2\2\u00fc\u00fd\7\7\2\2\u00fd\u00fe"+
		"\58\35\2\u00fe\u00ff\7\b\2\2\u00ff\u0101\3\2\2\2\u0100\u00fc\3\2\2\2\u0100"+
		"\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7\4\2\2\u0103\u0104\58"+
		"\35\2\u0104\u0105\7\5\2\2\u0105\u0126\3\2\2\2\u0106\u0109\7O\2\2\u0107"+
		"\u0109\5\66\34\2\u0108\u0106\3\2\2\2\u0108\u0107\3\2\2\2\u0109\u010e\3"+
		"\2\2\2\u010a\u010b\7\7\2\2\u010b\u010c\58\35\2\u010c\u010d\7\b\2\2\u010d"+
		"\u010f\3\2\2\2\u010e\u010a\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110\3\2"+
		"\2\2\u0110\u0111\t\4\2\2\u0111\u0112\58\35\2\u0112\u0113\7\5\2\2\u0113"+
		"\u0126\3\2\2\2\u0114\u0116\5$\23\2\u0115\u0117\5&\24\2\u0116\u0115\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0126\3\2\2\2\u0118\u0119\58\35\2\u0119"+
		"\u011a\7\5\2\2\u011a\u0126\3\2\2\2\u011b\u0126\5*\26\2\u011c\u0126\5,"+
		"\27\2\u011d\u0126\5.\30\2\u011e\u0126\5\60\31\2\u011f\u0126\5\62\32\2"+
		"\u0120\u0126\5\64\33\2\u0121\u0122\7(\2\2\u0122\u0126\7\5\2\2\u0123\u0124"+
		"\7)\2\2\u0124\u0126\7\5\2\2\u0125\u00ae\3\2\2\2\u0125\u00af\3\2\2\2\u0125"+
		"\u00b0\3\2\2\2\u0125\u00b1\3\2\2\2\u0125\u00c3\3\2\2\2\u0125\u00d3\3\2"+
		"\2\2\u0125\u00de\3\2\2\2\u0125\u00e7\3\2\2\2\u0125\u00f3\3\2\2\2\u0125"+
		"\u00fa\3\2\2\2\u0125\u0108\3\2\2\2\u0125\u0114\3\2\2\2\u0125\u0118\3\2"+
		"\2\2\u0125\u011b\3\2\2\2\u0125\u011c\3\2\2\2\u0125\u011d\3\2\2\2\u0125"+
		"\u011e\3\2\2\2\u0125\u011f\3\2\2\2\u0125\u0120\3\2\2\2\u0125\u0121\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0126\37\3\2\2\2\u0127\u0128\7*\2\2\u0128\u0129"+
		"\7\31\2\2\u0129\u012a\7\26\2\2\u012a\u012b\58\35\2\u012b\u012c\7\27\2"+
		"\2\u012c\u012e\7\n\2\2\u012d\u012f\5\36\20\2\u012e\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u0132\3\2"+
		"\2\2\u0132\u0133\7\13\2\2\u0133!\3\2\2\2\u0134\u0135\7*\2\2\u0135\u0137"+
		"\7\n\2\2\u0136\u0138\5\36\20\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2"+
		"\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c"+
		"\7\13\2\2\u013c#\3\2\2\2\u013d\u013e\7+\2\2\u013e\u0140\7\n\2\2\u013f"+
		"\u0141\5\36\20\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140\3"+
		"\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\7\13\2\2\u0145"+
		"%\3\2\2\2\u0146\u0147\7,\2\2\u0147\u0149\7\26\2\2\u0148\u014a\5:\36\2"+
		"\u0149\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u014c"+
		"\7\27\2\2\u014c\u014e\7\n\2\2\u014d\u014f\5\36\20\2\u014e\u014d\3\2\2"+
		"\2\u014f\u0150\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152"+
		"\3\2\2\2\u0152\u0153\7\13\2\2\u0153\'\3\2\2\2\u0154\u0155\t\5\2\2\u0155"+
		")\3\2\2\2\u0156\u0157\7-\2\2\u0157\u0158\7\26\2\2\u0158\u0159\7S\2\2\u0159"+
		"\u015a\7\27\2\2\u015a\u015b\7\5\2\2\u015b+\3\2\2\2\u015c\u015d\7.\2\2"+
		"\u015d\u015e\7\26\2\2\u015e\u015f\58\35\2\u015f\u0160\7\27\2\2\u0160\u0161"+
		"\7\5\2\2\u0161-\3\2\2\2\u0162\u0163\7/\2\2\u0163\u0165\7\26\2\2\u0164"+
		"\u0166\5:\36\2\u0165\u0164\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0167\3\2"+
		"\2\2\u0167\u0168\7\27\2\2\u0168\u0169\7\5\2\2\u0169/\3\2\2\2\u016a\u016b"+
		"\7\60\2\2\u016b\u016c\7\26\2\2\u016c\u016d\7S\2\2\u016d\u016e\7\27\2\2"+
		"\u016e\u016f\7\5\2\2\u016f\61\3\2\2\2\u0170\u0171\7\61\2\2\u0171\u0172"+
		"\7\26\2\2\u0172\u0173\7P\2\2\u0173\u0174\7\27\2\2\u0174\u0175\7\5\2\2"+
		"\u0175\63\3\2\2\2\u0176\u0177\7\62\2\2\u0177\u0178\7\26\2\2\u0178\u0179"+
		"\7R\2\2\u0179\u017a\7\30\2\2\u017a\u017b\t\6\2\2\u017b\u017c\7\27\2\2"+
		"\u017c\u017d\7\5\2\2\u017d\65\3\2\2\2\u017e\u0183\7O\2\2\u017f\u0180\7"+
		"\7\2\2\u0180\u0181\58\35\2\u0181\u0182\7\b\2\2\u0182\u0184\3\2\2\2\u0183"+
		"\u017f\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u018d\3\2\2\2\u0185\u0186\7\63"+
		"\2\2\u0186\u018b\7O\2\2\u0187\u0188\7\7\2\2\u0188\u0189\58\35\2\u0189"+
		"\u018a\7\b\2\2\u018a\u018c\3\2\2\2\u018b\u0187\3\2\2\2\u018b\u018c\3\2"+
		"\2\2\u018c\u018e\3\2\2\2\u018d\u0185\3\2\2\2\u018e\u018f\3\2\2\2\u018f"+
		"\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\67\3\2\2\2\u0191\u0192\b\35\1"+
		"\2\u0192\u0193\7\26\2\2\u0193\u0194\5\n\6\2\u0194\u0195\7\27\2\2\u0195"+
		"\u0196\58\35\35\u0196\u01c2\3\2\2\2\u0197\u0198\7\64\2\2\u0198\u0199\7"+
		"O\2\2\u0199\u019b\7\26\2\2\u019a\u019c\5:\36\2\u019b\u019a\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01c2\7\27\2\2\u019e\u019f\7"+
		"O\2\2\u019f\u01a1\7\26\2\2\u01a0\u01a2\5:\36\2\u01a1\u01a0\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01c2\7\27\2\2\u01a4\u01a5\7"+
		"O\2\2\u01a5\u01a6\7\7\2\2\u01a6\u01a7\58\35\2\u01a7\u01a8\7\b\2\2\u01a8"+
		"\u01c2\3\2\2\2\u01a9\u01aa\7\65\2\2\u01aa\u01c2\7O\2\2\u01ab\u01ac\7\3"+
		"\2\2\u01ac\u01c2\58\35\30\u01ad\u01ae\7\66\2\2\u01ae\u01c2\58\35\27\u01af"+
		"\u01b0\7\66\2\2\u01b0\u01c2\5\n\6\2\u01b1\u01b2\7\67\2\2\u01b2\u01c2\5"+
		"8\35\25\u01b3\u01b4\78\2\2\u01b4\u01c2\58\35\24\u01b5\u01b6\t\7\2\2\u01b6"+
		"\u01c2\58\35\23\u01b7\u01c2\7O\2\2\u01b8\u01c2\5\66\34\2\u01b9\u01c2\5"+
		"(\25\2\u01ba\u01c2\5\22\n\2\u01bb\u01c2\7S\2\2\u01bc\u01c2\7T\2\2\u01bd"+
		"\u01be\7\26\2\2\u01be\u01bf\58\35\2\u01bf\u01c0\7\27\2\2\u01c0\u01c2\3"+
		"\2\2\2\u01c1\u0191\3\2\2\2\u01c1\u0197\3\2\2\2\u01c1\u019e\3\2\2\2\u01c1"+
		"\u01a4\3\2\2\2\u01c1\u01a9\3\2\2\2\u01c1\u01ab\3\2\2\2\u01c1\u01ad\3\2"+
		"\2\2\u01c1\u01af\3\2\2\2\u01c1\u01b1\3\2\2\2\u01c1\u01b3\3\2\2\2\u01c1"+
		"\u01b5\3\2\2\2\u01c1\u01b7\3\2\2\2\u01c1\u01b8\3\2\2\2\u01c1\u01b9\3\2"+
		"\2\2\u01c1\u01ba\3\2\2\2\u01c1\u01bb\3\2\2\2\u01c1\u01bc\3\2\2\2\u01c1"+
		"\u01bd\3\2\2\2\u01c2\u01e2\3\2\2\2\u01c3\u01c4\f\21\2\2\u01c4\u01c5\7"+
		";\2\2\u01c5\u01e1\58\35\22\u01c6\u01c7\f\20\2\2\u01c7\u01c8\t\b\2\2\u01c8"+
		"\u01e1\58\35\21\u01c9\u01ca\f\17\2\2\u01ca\u01cb\t\t\2\2\u01cb\u01e1\5"+
		"8\35\20\u01cc\u01cd\f\16\2\2\u01cd\u01ce\t\n\2\2\u01ce\u01e1\58\35\17"+
		"\u01cf\u01d0\f\r\2\2\u01d0\u01d1\t\13\2\2\u01d1\u01e1\58\35\16\u01d2\u01d3"+
		"\f\f\2\2\u01d3\u01d4\t\f\2\2\u01d4\u01e1\58\35\r\u01d5\u01d6\f\13\2\2"+
		"\u01d6\u01d7\t\r\2\2\u01d7\u01e1\58\35\f\u01d8\u01d9\f\3\2\2\u01d9\u01da"+
		"\7L\2\2\u01da\u01db\58\35\2\u01db\u01dc\7M\2\2\u01dc\u01dd\58\35\4\u01dd"+
		"\u01e1\3\2\2\2\u01de\u01df\f\22\2\2\u01df\u01e1\t\7\2\2\u01e0\u01c3\3"+
		"\2\2\2\u01e0\u01c6\3\2\2\2\u01e0\u01c9\3\2\2\2\u01e0\u01cc\3\2\2\2\u01e0"+
		"\u01cf\3\2\2\2\u01e0\u01d2\3\2\2\2\u01e0\u01d5\3\2\2\2\u01e0\u01d8\3\2"+
		"\2\2\u01e0\u01de\3\2\2\2\u01e1\u01e4\3\2\2\2\u01e2\u01e0\3\2\2\2\u01e2"+
		"\u01e3\3\2\2\2\u01e39\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e5\u01ea\58\35\2"+
		"\u01e6\u01e7\7\30\2\2\u01e7\u01e9\58\35\2\u01e8\u01e6\3\2\2\2\u01e9\u01ec"+
		"\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2\2\2\u01eb;\3\2\2\2\u01ec"+
		"\u01ea\3\2\2\2/?AFLeiqx{\u0086\u008a\u0091\u0095\u009f\u00a9\u00b7\u00bd"+
		"\u00c1\u00c8\u00d1\u00dc\u00e5\u00f1\u00f5\u00fa\u0100\u0108\u010e\u0116"+
		"\u0125\u0130\u0139\u0142\u0149\u0150\u0165\u0183\u018b\u018f\u019b\u01a1"+
		"\u01c1\u01e0\u01e2\u01ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}