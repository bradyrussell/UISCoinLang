/* (C) Brady Russell 2021 */
package com.bradyrussell.uiscoin.lang.generated;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UISCLexer extends Lexer {
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
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, CONST=73, 
		ID=74, INT=75, FLOAT=76, STRING=77, CHAR=78, WS=79, SL_COMMENT=80, ML_COMMENT=81, 
		INVALID=82;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
			"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "T__63", "T__64", 
			"T__65", "T__66", "T__67", "T__68", "T__69", "T__70", "T__71", "CONST", 
			"ID", "LETTER", "INT", "HEXDIGIT", "EXPONENT", "FLOAT", "STRING", "CHAR", 
			"StringCharSequence", "StringChar", "WS", "SL_COMMENT", "ML_COMMENT", 
			"INVALID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'='", "';'", "'[]'", "'['", "']'", "'struct'", "'{'", "'}'", 
			"'void'", "'byte'", "'int32'", "'int64'", "'float'", "'true'", "'false'", 
			"'null'", "'('", "')'", "','", "'if'", "'ufori'", "'as'", "'uforeach'", 
			"'while'", "'for'", "'return'", "'+='", "'-='", "'*='", "'/='", "'%='", 
			"'&='", "'|='", "'^='", "'break'", "'continue'", "'else'", "'try'", "'catch'", 
			"'asm'", "'assert'", "'throw'", "'include'", "'flag'", "'flagdata'", 
			"'.'", "'_'", "'$'", "'#'", "'-'", "'!'", "'--'", "'++'", "'%'", "'*'", 
			"'/'", "'+'", "'&'", "'|'", "'^'", "'~'", "'&&'", "'||'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'?'", "':'", "'const'"
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
			null, "CONST", "ID", "INT", "FLOAT", "STRING", "CHAR", "WS", "SL_COMMENT", 
			"ML_COMMENT", "INVALID"
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


	    //private static final int WHITESPACE = 1;
	    //private static final int COMMENTS = 2;


	public UISCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "UISC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2T\u0220\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3"+
		"#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3"+
		"+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3"+
		"=\3>\3>\3?\3?\3@\3@\3@\3A\3A\3A\3B\3B\3C\3C\3C\3D\3D\3E\3E\3E\3F\3F\3"+
		"F\3G\3G\3G\3H\3H\3I\3I\3J\3J\3J\3J\3J\3J\3K\3K\3K\7K\u01c4\nK\fK\16K\u01c7"+
		"\13K\3L\3L\3M\6M\u01cc\nM\rM\16M\u01cd\3N\5N\u01d1\nN\3O\3O\5O\u01d5\n"+
		"O\3O\6O\u01d8\nO\rO\16O\u01d9\3P\3P\3P\5P\u01df\nP\3P\5P\u01e2\nP\3Q\3"+
		"Q\5Q\u01e6\nQ\3Q\3Q\3R\3R\3R\3R\3S\6S\u01ef\nS\rS\16S\u01f0\3T\3T\3T\3"+
		"T\3T\3T\5T\u01f9\nT\3U\6U\u01fc\nU\rU\16U\u01fd\3U\3U\3V\3V\3V\3V\7V\u0206"+
		"\nV\fV\16V\u0209\13V\3V\3V\3V\3V\3W\3W\3W\3W\7W\u0213\nW\fW\16W\u0216"+
		"\13W\3W\3W\3W\3W\3W\3X\3X\3X\3X\4\u0207\u0214\2Y\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081"+
		"B\u0083C\u0085D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095"+
		"L\u0097\2\u0099M\u009b\2\u009d\2\u009fN\u00a1O\u00a3P\u00a5\2\u00a7\2"+
		"\u00a9Q\u00abR\u00adS\u00afT\3\2\n\4\2\62;aa\4\2C\\c|\3\2\62;\5\2\62;"+
		"CHch\4\2GGgg\4\2--//\6\2\f\f\17\17$$^^\5\2\13\f\17\17\"\"\2\u0228\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3"+
		"\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0099"+
		"\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a9\3\2\2"+
		"\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\3\u00b1\3\2\2\2\5\u00b3"+
		"\3\2\2\2\7\u00b5\3\2\2\2\t\u00b7\3\2\2\2\13\u00ba\3\2\2\2\r\u00bc\3\2"+
		"\2\2\17\u00be\3\2\2\2\21\u00c5\3\2\2\2\23\u00c7\3\2\2\2\25\u00c9\3\2\2"+
		"\2\27\u00ce\3\2\2\2\31\u00d3\3\2\2\2\33\u00d9\3\2\2\2\35\u00df\3\2\2\2"+
		"\37\u00e5\3\2\2\2!\u00ea\3\2\2\2#\u00f0\3\2\2\2%\u00f5\3\2\2\2\'\u00f7"+
		"\3\2\2\2)\u00f9\3\2\2\2+\u00fb\3\2\2\2-\u00fe\3\2\2\2/\u0104\3\2\2\2\61"+
		"\u0107\3\2\2\2\63\u0110\3\2\2\2\65\u0116\3\2\2\2\67\u011a\3\2\2\29\u0121"+
		"\3\2\2\2;\u0124\3\2\2\2=\u0127\3\2\2\2?\u012a\3\2\2\2A\u012d\3\2\2\2C"+
		"\u0130\3\2\2\2E\u0133\3\2\2\2G\u0136\3\2\2\2I\u0139\3\2\2\2K\u013f\3\2"+
		"\2\2M\u0148\3\2\2\2O\u014d\3\2\2\2Q\u0151\3\2\2\2S\u0157\3\2\2\2U\u015b"+
		"\3\2\2\2W\u0162\3\2\2\2Y\u0168\3\2\2\2[\u0170\3\2\2\2]\u0175\3\2\2\2_"+
		"\u017e\3\2\2\2a\u0180\3\2\2\2c\u0182\3\2\2\2e\u0184\3\2\2\2g\u0186\3\2"+
		"\2\2i\u0188\3\2\2\2k\u018a\3\2\2\2m\u018d\3\2\2\2o\u0190\3\2\2\2q\u0192"+
		"\3\2\2\2s\u0194\3\2\2\2u\u0196\3\2\2\2w\u0198\3\2\2\2y\u019a\3\2\2\2{"+
		"\u019c\3\2\2\2}\u019e\3\2\2\2\177\u01a0\3\2\2\2\u0081\u01a3\3\2\2\2\u0083"+
		"\u01a6\3\2\2\2\u0085\u01a8\3\2\2\2\u0087\u01ab\3\2\2\2\u0089\u01ad\3\2"+
		"\2\2\u008b\u01b0\3\2\2\2\u008d\u01b3\3\2\2\2\u008f\u01b6\3\2\2\2\u0091"+
		"\u01b8\3\2\2\2\u0093\u01ba\3\2\2\2\u0095\u01c0\3\2\2\2\u0097\u01c8\3\2"+
		"\2\2\u0099\u01cb\3\2\2\2\u009b\u01d0\3\2\2\2\u009d\u01d2\3\2\2\2\u009f"+
		"\u01db\3\2\2\2\u00a1\u01e3\3\2\2\2\u00a3\u01e9\3\2\2\2\u00a5\u01ee\3\2"+
		"\2\2\u00a7\u01f8\3\2\2\2\u00a9\u01fb\3\2\2\2\u00ab\u0201\3\2\2\2\u00ad"+
		"\u020e\3\2\2\2\u00af\u021c\3\2\2\2\u00b1\u00b2\7B\2\2\u00b2\4\3\2\2\2"+
		"\u00b3\u00b4\7?\2\2\u00b4\6\3\2\2\2\u00b5\u00b6\7=\2\2\u00b6\b\3\2\2\2"+
		"\u00b7\u00b8\7]\2\2\u00b8\u00b9\7_\2\2\u00b9\n\3\2\2\2\u00ba\u00bb\7]"+
		"\2\2\u00bb\f\3\2\2\2\u00bc\u00bd\7_\2\2\u00bd\16\3\2\2\2\u00be\u00bf\7"+
		"u\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3"+
		"\7e\2\2\u00c3\u00c4\7v\2\2\u00c4\20\3\2\2\2\u00c5\u00c6\7}\2\2\u00c6\22"+
		"\3\2\2\2\u00c7\u00c8\7\177\2\2\u00c8\24\3\2\2\2\u00c9\u00ca\7x\2\2\u00ca"+
		"\u00cb\7q\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7f\2\2\u00cd\26\3\2\2\2\u00ce"+
		"\u00cf\7d\2\2\u00cf\u00d0\7{\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7g\2\2"+
		"\u00d2\30\3\2\2\2\u00d3\u00d4\7k\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7"+
		"v\2\2\u00d6\u00d7\7\65\2\2\u00d7\u00d8\7\64\2\2\u00d8\32\3\2\2\2\u00d9"+
		"\u00da\7k\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\78\2\2"+
		"\u00dd\u00de\7\66\2\2\u00de\34\3\2\2\2\u00df\u00e0\7h\2\2\u00e0\u00e1"+
		"\7n\2\2\u00e1\u00e2\7q\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7v\2\2\u00e4"+
		"\36\3\2\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8\7w\2\2\u00e8"+
		"\u00e9\7g\2\2\u00e9 \3\2\2\2\u00ea\u00eb\7h\2\2\u00eb\u00ec\7c\2\2\u00ec"+
		"\u00ed\7n\2\2\u00ed\u00ee\7u\2\2\u00ee\u00ef\7g\2\2\u00ef\"\3\2\2\2\u00f0"+
		"\u00f1\7p\2\2\u00f1\u00f2\7w\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7n\2\2"+
		"\u00f4$\3\2\2\2\u00f5\u00f6\7*\2\2\u00f6&\3\2\2\2\u00f7\u00f8\7+\2\2\u00f8"+
		"(\3\2\2\2\u00f9\u00fa\7.\2\2\u00fa*\3\2\2\2\u00fb\u00fc\7k\2\2\u00fc\u00fd"+
		"\7h\2\2\u00fd,\3\2\2\2\u00fe\u00ff\7w\2\2\u00ff\u0100\7h\2\2\u0100\u0101"+
		"\7q\2\2\u0101\u0102\7t\2\2\u0102\u0103\7k\2\2\u0103.\3\2\2\2\u0104\u0105"+
		"\7c\2\2\u0105\u0106\7u\2\2\u0106\60\3\2\2\2\u0107\u0108\7w\2\2\u0108\u0109"+
		"\7h\2\2\u0109\u010a\7q\2\2\u010a\u010b\7t\2\2\u010b\u010c\7g\2\2\u010c"+
		"\u010d\7c\2\2\u010d\u010e\7e\2\2\u010e\u010f\7j\2\2\u010f\62\3\2\2\2\u0110"+
		"\u0111\7y\2\2\u0111\u0112\7j\2\2\u0112\u0113\7k\2\2\u0113\u0114\7n\2\2"+
		"\u0114\u0115\7g\2\2\u0115\64\3\2\2\2\u0116\u0117\7h\2\2\u0117\u0118\7"+
		"q\2\2\u0118\u0119\7t\2\2\u0119\66\3\2\2\2\u011a\u011b\7t\2\2\u011b\u011c"+
		"\7g\2\2\u011c\u011d\7v\2\2\u011d\u011e\7w\2\2\u011e\u011f\7t\2\2\u011f"+
		"\u0120\7p\2\2\u01208\3\2\2\2\u0121\u0122\7-\2\2\u0122\u0123\7?\2\2\u0123"+
		":\3\2\2\2\u0124\u0125\7/\2\2\u0125\u0126\7?\2\2\u0126<\3\2\2\2\u0127\u0128"+
		"\7,\2\2\u0128\u0129\7?\2\2\u0129>\3\2\2\2\u012a\u012b\7\61\2\2\u012b\u012c"+
		"\7?\2\2\u012c@\3\2\2\2\u012d\u012e\7\'\2\2\u012e\u012f\7?\2\2\u012fB\3"+
		"\2\2\2\u0130\u0131\7(\2\2\u0131\u0132\7?\2\2\u0132D\3\2\2\2\u0133\u0134"+
		"\7~\2\2\u0134\u0135\7?\2\2\u0135F\3\2\2\2\u0136\u0137\7`\2\2\u0137\u0138"+
		"\7?\2\2\u0138H\3\2\2\2\u0139\u013a\7d\2\2\u013a\u013b\7t\2\2\u013b\u013c"+
		"\7g\2\2\u013c\u013d\7c\2\2\u013d\u013e\7m\2\2\u013eJ\3\2\2\2\u013f\u0140"+
		"\7e\2\2\u0140\u0141\7q\2\2\u0141\u0142\7p\2\2\u0142\u0143\7v\2\2\u0143"+
		"\u0144\7k\2\2\u0144\u0145\7p\2\2\u0145\u0146\7w\2\2\u0146\u0147\7g\2\2"+
		"\u0147L\3\2\2\2\u0148\u0149\7g\2\2\u0149\u014a\7n\2\2\u014a\u014b\7u\2"+
		"\2\u014b\u014c\7g\2\2\u014cN\3\2\2\2\u014d\u014e\7v\2\2\u014e\u014f\7"+
		"t\2\2\u014f\u0150\7{\2\2\u0150P\3\2\2\2\u0151\u0152\7e\2\2\u0152\u0153"+
		"\7c\2\2\u0153\u0154\7v\2\2\u0154\u0155\7e\2\2\u0155\u0156\7j\2\2\u0156"+
		"R\3\2\2\2\u0157\u0158\7c\2\2\u0158\u0159\7u\2\2\u0159\u015a\7o\2\2\u015a"+
		"T\3\2\2\2\u015b\u015c\7c\2\2\u015c\u015d\7u\2\2\u015d\u015e\7u\2\2\u015e"+
		"\u015f\7g\2\2\u015f\u0160\7t\2\2\u0160\u0161\7v\2\2\u0161V\3\2\2\2\u0162"+
		"\u0163\7v\2\2\u0163\u0164\7j\2\2\u0164\u0165\7t\2\2\u0165\u0166\7q\2\2"+
		"\u0166\u0167\7y\2\2\u0167X\3\2\2\2\u0168\u0169\7k\2\2\u0169\u016a\7p\2"+
		"\2\u016a\u016b\7e\2\2\u016b\u016c\7n\2\2\u016c\u016d\7w\2\2\u016d\u016e"+
		"\7f\2\2\u016e\u016f\7g\2\2\u016fZ\3\2\2\2\u0170\u0171\7h\2\2\u0171\u0172"+
		"\7n\2\2\u0172\u0173\7c\2\2\u0173\u0174\7i\2\2\u0174\\\3\2\2\2\u0175\u0176"+
		"\7h\2\2\u0176\u0177\7n\2\2\u0177\u0178\7c\2\2\u0178\u0179\7i\2\2\u0179"+
		"\u017a\7f\2\2\u017a\u017b\7c\2\2\u017b\u017c\7v\2\2\u017c\u017d\7c\2\2"+
		"\u017d^\3\2\2\2\u017e\u017f\7\60\2\2\u017f`\3\2\2\2\u0180\u0181\7a\2\2"+
		"\u0181b\3\2\2\2\u0182\u0183\7&\2\2\u0183d\3\2\2\2\u0184\u0185\7%\2\2\u0185"+
		"f\3\2\2\2\u0186\u0187\7/\2\2\u0187h\3\2\2\2\u0188\u0189\7#\2\2\u0189j"+
		"\3\2\2\2\u018a\u018b\7/\2\2\u018b\u018c\7/\2\2\u018cl\3\2\2\2\u018d\u018e"+
		"\7-\2\2\u018e\u018f\7-\2\2\u018fn\3\2\2\2\u0190\u0191\7\'\2\2\u0191p\3"+
		"\2\2\2\u0192\u0193\7,\2\2\u0193r\3\2\2\2\u0194\u0195\7\61\2\2\u0195t\3"+
		"\2\2\2\u0196\u0197\7-\2\2\u0197v\3\2\2\2\u0198\u0199\7(\2\2\u0199x\3\2"+
		"\2\2\u019a\u019b\7~\2\2\u019bz\3\2\2\2\u019c\u019d\7`\2\2\u019d|\3\2\2"+
		"\2\u019e\u019f\7\u0080\2\2\u019f~\3\2\2\2\u01a0\u01a1\7(\2\2\u01a1\u01a2"+
		"\7(\2\2\u01a2\u0080\3\2\2\2\u01a3\u01a4\7~\2\2\u01a4\u01a5\7~\2\2\u01a5"+
		"\u0082\3\2\2\2\u01a6\u01a7\7>\2\2\u01a7\u0084\3\2\2\2\u01a8\u01a9\7>\2"+
		"\2\u01a9\u01aa\7?\2\2\u01aa\u0086\3\2\2\2\u01ab\u01ac\7@\2\2\u01ac\u0088"+
		"\3\2\2\2\u01ad\u01ae\7@\2\2\u01ae\u01af\7?\2\2\u01af\u008a\3\2\2\2\u01b0"+
		"\u01b1\7?\2\2\u01b1\u01b2\7?\2\2\u01b2\u008c\3\2\2\2\u01b3\u01b4\7#\2"+
		"\2\u01b4\u01b5\7?\2\2\u01b5\u008e\3\2\2\2\u01b6\u01b7\7A\2\2\u01b7\u0090"+
		"\3\2\2\2\u01b8\u01b9\7<\2\2\u01b9\u0092\3\2\2\2\u01ba\u01bb\7e\2\2\u01bb"+
		"\u01bc\7q\2\2\u01bc\u01bd\7p\2\2\u01bd\u01be\7u\2\2\u01be\u01bf\7v\2\2"+
		"\u01bf\u0094\3\2\2\2\u01c0\u01c5\5\u0097L\2\u01c1\u01c4\5\u0097L\2\u01c2"+
		"\u01c4\t\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c2\3\2\2\2\u01c4\u01c7\3\2"+
		"\2\2\u01c5\u01c3\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u0096\3\2\2\2\u01c7"+
		"\u01c5\3\2\2\2\u01c8\u01c9\t\3\2\2\u01c9\u0098\3\2\2\2\u01ca\u01cc\t\4"+
		"\2\2\u01cb\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cb\3\2\2\2\u01cd"+
		"\u01ce\3\2\2\2\u01ce\u009a\3\2\2\2\u01cf\u01d1\t\5\2\2\u01d0\u01cf\3\2"+
		"\2\2\u01d1\u009c\3\2\2\2\u01d2\u01d4\t\6\2\2\u01d3\u01d5\t\7\2\2\u01d4"+
		"\u01d3\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d7\3\2\2\2\u01d6\u01d8\t\4"+
		"\2\2\u01d7\u01d6\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9"+
		"\u01da\3\2\2\2\u01da\u009e\3\2\2\2\u01db\u01dc\5\u0099M\2\u01dc\u01de"+
		"\7\60\2\2\u01dd\u01df\5\u0099M\2\u01de\u01dd\3\2\2\2\u01de\u01df\3\2\2"+
		"\2\u01df\u01e1\3\2\2\2\u01e0\u01e2\5\u009dO\2\u01e1\u01e0\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u00a0\3\2\2\2\u01e3\u01e5\7$\2\2\u01e4\u01e6\5\u00a5"+
		"S\2\u01e5\u01e4\3\2\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7"+
		"\u01e8\7$\2\2\u01e8\u00a2\3\2\2\2\u01e9\u01ea\7)\2\2\u01ea\u01eb\5\u00a7"+
		"T\2\u01eb\u01ec\7)\2\2\u01ec\u00a4\3\2\2\2\u01ed\u01ef\5\u00a7T\2\u01ee"+
		"\u01ed\3\2\2\2\u01ef\u01f0\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01f1\3\2"+
		"\2\2\u01f1\u00a6\3\2\2\2\u01f2\u01f9\n\b\2\2\u01f3\u01f4\7^\2\2\u01f4"+
		"\u01f9\7\f\2\2\u01f5\u01f6\7^\2\2\u01f6\u01f7\7\17\2\2\u01f7\u01f9\7\f"+
		"\2\2\u01f8\u01f2\3\2\2\2\u01f8\u01f3\3\2\2\2\u01f8\u01f5\3\2\2\2\u01f9"+
		"\u00a8\3\2\2\2\u01fa\u01fc\t\t\2\2\u01fb\u01fa\3\2\2\2\u01fc\u01fd\3\2"+
		"\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff"+
		"\u0200\bU\2\2\u0200\u00aa\3\2\2\2\u0201\u0202\7\61\2\2\u0202\u0203\7\61"+
		"\2\2\u0203\u0207\3\2\2\2\u0204\u0206\13\2\2\2\u0205\u0204\3\2\2\2\u0206"+
		"\u0209\3\2\2\2\u0207\u0208\3\2\2\2\u0207\u0205\3\2\2\2\u0208\u020a\3\2"+
		"\2\2\u0209\u0207\3\2\2\2\u020a\u020b\7\f\2\2\u020b\u020c\3\2\2\2\u020c"+
		"\u020d\bV\3\2\u020d\u00ac\3\2\2\2\u020e\u020f\7\61\2\2\u020f\u0210\7,"+
		"\2\2\u0210\u0214\3\2\2\2\u0211\u0213\13\2\2\2\u0212\u0211\3\2\2\2\u0213"+
		"\u0216\3\2\2\2\u0214\u0215\3\2\2\2\u0214\u0212\3\2\2\2\u0215\u0217\3\2"+
		"\2\2\u0216\u0214\3\2\2\2\u0217\u0218\7,\2\2\u0218\u0219\7\61\2\2\u0219"+
		"\u021a\3\2\2\2\u021a\u021b\bW\3\2\u021b\u00ae\3\2\2\2\u021c\u021d\13\2"+
		"\2\2\u021d\u021e\3\2\2\2\u021e\u021f\bX\3\2\u021f\u00b0\3\2\2\2\21\2\u01c3"+
		"\u01c5\u01cd\u01d0\u01d4\u01d9\u01de\u01e1\u01e5\u01f0\u01f8\u01fd\u0207"+
		"\u0214\4\2\3\2\2\4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}