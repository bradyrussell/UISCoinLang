/* (C) Brady Russell 2022 */
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
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, CONST=76, ID=77, INT=78, FLOAT=79, HEXSTRING=80, STRING=81, 
		CHAR=82, WS=83, SL_COMMENT=84, ML_COMMENT=85, INVALID=86;
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
			"T__65", "T__66", "T__67", "T__68", "T__69", "T__70", "T__71", "T__72", 
			"T__73", "T__74", "CONST", "ID", "LETTER", "INT", "HEXDIGIT", "EXPONENT", 
			"FLOAT", "HEXSTRING", "STRING", "CHAR", "StringCharSequence", "StringChar", 
			"WS", "SL_COMMENT", "ML_COMMENT", "INVALID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'='", "';'", "'[]'", "'['", "']'", "'struct'", "'{'", "'}'", 
			"'void'", "'byte'", "'int32'", "'int64'", "'float'", "'('", "','", "')'", 
			"'var'", "'auto'", "'true'", "'false'", "'null'", "'if'", "'ufori'", 
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


	    private static final int WHITESPACE = 1;
	    private static final int COMMENTS = 2;


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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2X\u0243\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3"+
		"*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3.\3"+
		".\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\66\3\66\3\67\3\67\38\38\38\39\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3"+
		">\3>\3?\3?\3@\3@\3A\3A\3B\3B\3B\3C\3C\3C\3D\3D\3D\3E\3E\3F\3F\3F\3G\3"+
		"G\3H\3H\3H\3I\3I\3I\3J\3J\3J\3K\3K\3L\3L\3M\3M\3M\3M\3M\3M\3N\3N\3N\7"+
		"N\u01d8\nN\fN\16N\u01db\13N\3O\3O\3P\6P\u01e0\nP\rP\16P\u01e1\3Q\5Q\u01e5"+
		"\nQ\3R\3R\5R\u01e9\nR\3R\6R\u01ec\nR\rR\16R\u01ed\3S\3S\3S\5S\u01f3\n"+
		"S\3S\5S\u01f6\nS\3S\3S\3S\5S\u01fb\nS\3T\3T\3T\3T\3T\7T\u0202\nT\fT\16"+
		"T\u0205\13T\3U\3U\5U\u0209\nU\3U\3U\3V\3V\3V\3V\3W\6W\u0212\nW\rW\16W"+
		"\u0213\3X\3X\3X\3X\3X\3X\5X\u021c\nX\3Y\6Y\u021f\nY\rY\16Y\u0220\3Y\3"+
		"Y\3Z\3Z\3Z\3Z\7Z\u0229\nZ\fZ\16Z\u022c\13Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\7["+
		"\u0236\n[\f[\16[\u0239\13[\3[\3[\3[\3[\3[\3\\\3\\\3\\\3\\\4\u022a\u0237"+
		"\2]\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087E\u0089F\u008bG\u008d"+
		"H\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009bO\u009d\2\u009fP\u00a1"+
		"\2\u00a3\2\u00a5Q\u00a7R\u00a9S\u00abT\u00ad\2\u00af\2\u00b1U\u00b3V\u00b5"+
		"W\u00b7X\3\2\n\4\2\62;aa\4\2C\\c|\3\2\62;\5\2\62;CHch\4\2GGgg\4\2--//"+
		"\6\2\f\f\17\17$$^^\5\2\13\f\17\17\"\"\2\u024d\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2"+
		"\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2"+
		"\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009f\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9"+
		"\3\2\2\2\2\u00ab\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2"+
		"\2\2\u00b7\3\2\2\2\3\u00b9\3\2\2\2\5\u00bb\3\2\2\2\7\u00bd\3\2\2\2\t\u00bf"+
		"\3\2\2\2\13\u00c2\3\2\2\2\r\u00c4\3\2\2\2\17\u00c6\3\2\2\2\21\u00cd\3"+
		"\2\2\2\23\u00cf\3\2\2\2\25\u00d1\3\2\2\2\27\u00d6\3\2\2\2\31\u00db\3\2"+
		"\2\2\33\u00e1\3\2\2\2\35\u00e7\3\2\2\2\37\u00ed\3\2\2\2!\u00ef\3\2\2\2"+
		"#\u00f1\3\2\2\2%\u00f3\3\2\2\2\'\u00f7\3\2\2\2)\u00fc\3\2\2\2+\u0101\3"+
		"\2\2\2-\u0107\3\2\2\2/\u010c\3\2\2\2\61\u010f\3\2\2\2\63\u0115\3\2\2\2"+
		"\65\u0118\3\2\2\2\67\u0121\3\2\2\29\u0127\3\2\2\2;\u012b\3\2\2\2=\u0132"+
		"\3\2\2\2?\u0135\3\2\2\2A\u0138\3\2\2\2C\u013b\3\2\2\2E\u013e\3\2\2\2G"+
		"\u0141\3\2\2\2I\u0144\3\2\2\2K\u0147\3\2\2\2M\u014a\3\2\2\2O\u0150\3\2"+
		"\2\2Q\u0159\3\2\2\2S\u015e\3\2\2\2U\u0162\3\2\2\2W\u0168\3\2\2\2Y\u016c"+
		"\3\2\2\2[\u0173\3\2\2\2]\u0179\3\2\2\2_\u0181\3\2\2\2a\u0186\3\2\2\2c"+
		"\u018f\3\2\2\2e\u0191\3\2\2\2g\u0193\3\2\2\2i\u0195\3\2\2\2k\u0197\3\2"+
		"\2\2m\u0199\3\2\2\2o\u019b\3\2\2\2q\u019e\3\2\2\2s\u01a1\3\2\2\2u\u01a3"+
		"\3\2\2\2w\u01a5\3\2\2\2y\u01a7\3\2\2\2{\u01a9\3\2\2\2}\u01ab\3\2\2\2\177"+
		"\u01ad\3\2\2\2\u0081\u01af\3\2\2\2\u0083\u01b1\3\2\2\2\u0085\u01b4\3\2"+
		"\2\2\u0087\u01b7\3\2\2\2\u0089\u01ba\3\2\2\2\u008b\u01bc\3\2\2\2\u008d"+
		"\u01bf\3\2\2\2\u008f\u01c1\3\2\2\2\u0091\u01c4\3\2\2\2\u0093\u01c7\3\2"+
		"\2\2\u0095\u01ca\3\2\2\2\u0097\u01cc\3\2\2\2\u0099\u01ce\3\2\2\2\u009b"+
		"\u01d4\3\2\2\2\u009d\u01dc\3\2\2\2\u009f\u01df\3\2\2\2\u00a1\u01e4\3\2"+
		"\2\2\u00a3\u01e6\3\2\2\2\u00a5\u01fa\3\2\2\2\u00a7\u01fc\3\2\2\2\u00a9"+
		"\u0206\3\2\2\2\u00ab\u020c\3\2\2\2\u00ad\u0211\3\2\2\2\u00af\u021b\3\2"+
		"\2\2\u00b1\u021e\3\2\2\2\u00b3\u0224\3\2\2\2\u00b5\u0231\3\2\2\2\u00b7"+
		"\u023f\3\2\2\2\u00b9\u00ba\7B\2\2\u00ba\4\3\2\2\2\u00bb\u00bc\7?\2\2\u00bc"+
		"\6\3\2\2\2\u00bd\u00be\7=\2\2\u00be\b\3\2\2\2\u00bf\u00c0\7]\2\2\u00c0"+
		"\u00c1\7_\2\2\u00c1\n\3\2\2\2\u00c2\u00c3\7]\2\2\u00c3\f\3\2\2\2\u00c4"+
		"\u00c5\7_\2\2\u00c5\16\3\2\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7v\2\2\u00c8"+
		"\u00c9\7t\2\2\u00c9\u00ca\7w\2\2\u00ca\u00cb\7e\2\2\u00cb\u00cc\7v\2\2"+
		"\u00cc\20\3\2\2\2\u00cd\u00ce\7}\2\2\u00ce\22\3\2\2\2\u00cf\u00d0\7\177"+
		"\2\2\u00d0\24\3\2\2\2\u00d1\u00d2\7x\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4"+
		"\7k\2\2\u00d4\u00d5\7f\2\2\u00d5\26\3\2\2\2\u00d6\u00d7\7d\2\2\u00d7\u00d8"+
		"\7{\2\2\u00d8\u00d9\7v\2\2\u00d9\u00da\7g\2\2\u00da\30\3\2\2\2\u00db\u00dc"+
		"\7k\2\2\u00dc\u00dd\7p\2\2\u00dd\u00de\7v\2\2\u00de\u00df\7\65\2\2\u00df"+
		"\u00e0\7\64\2\2\u00e0\32\3\2\2\2\u00e1\u00e2\7k\2\2\u00e2\u00e3\7p\2\2"+
		"\u00e3\u00e4\7v\2\2\u00e4\u00e5\78\2\2\u00e5\u00e6\7\66\2\2\u00e6\34\3"+
		"\2\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9\7n\2\2\u00e9\u00ea\7q\2\2\u00ea"+
		"\u00eb\7c\2\2\u00eb\u00ec\7v\2\2\u00ec\36\3\2\2\2\u00ed\u00ee\7*\2\2\u00ee"+
		" \3\2\2\2\u00ef\u00f0\7.\2\2\u00f0\"\3\2\2\2\u00f1\u00f2\7+\2\2\u00f2"+
		"$\3\2\2\2\u00f3\u00f4\7x\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7t\2\2\u00f6"+
		"&\3\2\2\2\u00f7\u00f8\7c\2\2\u00f8\u00f9\7w\2\2\u00f9\u00fa\7v\2\2\u00fa"+
		"\u00fb\7q\2\2\u00fb(\3\2\2\2\u00fc\u00fd\7v\2\2\u00fd\u00fe\7t\2\2\u00fe"+
		"\u00ff\7w\2\2\u00ff\u0100\7g\2\2\u0100*\3\2\2\2\u0101\u0102\7h\2\2\u0102"+
		"\u0103\7c\2\2\u0103\u0104\7n\2\2\u0104\u0105\7u\2\2\u0105\u0106\7g\2\2"+
		"\u0106,\3\2\2\2\u0107\u0108\7p\2\2\u0108\u0109\7w\2\2\u0109\u010a\7n\2"+
		"\2\u010a\u010b\7n\2\2\u010b.\3\2\2\2\u010c\u010d\7k\2\2\u010d\u010e\7"+
		"h\2\2\u010e\60\3\2\2\2\u010f\u0110\7w\2\2\u0110\u0111\7h\2\2\u0111\u0112"+
		"\7q\2\2\u0112\u0113\7t\2\2\u0113\u0114\7k\2\2\u0114\62\3\2\2\2\u0115\u0116"+
		"\7c\2\2\u0116\u0117\7u\2\2\u0117\64\3\2\2\2\u0118\u0119\7w\2\2\u0119\u011a"+
		"\7h\2\2\u011a\u011b\7q\2\2\u011b\u011c\7t\2\2\u011c\u011d\7g\2\2\u011d"+
		"\u011e\7c\2\2\u011e\u011f\7e\2\2\u011f\u0120\7j\2\2\u0120\66\3\2\2\2\u0121"+
		"\u0122\7y\2\2\u0122\u0123\7j\2\2\u0123\u0124\7k\2\2\u0124\u0125\7n\2\2"+
		"\u0125\u0126\7g\2\2\u01268\3\2\2\2\u0127\u0128\7h\2\2\u0128\u0129\7q\2"+
		"\2\u0129\u012a\7t\2\2\u012a:\3\2\2\2\u012b\u012c\7t\2\2\u012c\u012d\7"+
		"g\2\2\u012d\u012e\7v\2\2\u012e\u012f\7w\2\2\u012f\u0130\7t\2\2\u0130\u0131"+
		"\7p\2\2\u0131<\3\2\2\2\u0132\u0133\7-\2\2\u0133\u0134\7?\2\2\u0134>\3"+
		"\2\2\2\u0135\u0136\7/\2\2\u0136\u0137\7?\2\2\u0137@\3\2\2\2\u0138\u0139"+
		"\7,\2\2\u0139\u013a\7?\2\2\u013aB\3\2\2\2\u013b\u013c\7\61\2\2\u013c\u013d"+
		"\7?\2\2\u013dD\3\2\2\2\u013e\u013f\7\'\2\2\u013f\u0140\7?\2\2\u0140F\3"+
		"\2\2\2\u0141\u0142\7(\2\2\u0142\u0143\7?\2\2\u0143H\3\2\2\2\u0144\u0145"+
		"\7~\2\2\u0145\u0146\7?\2\2\u0146J\3\2\2\2\u0147\u0148\7`\2\2\u0148\u0149"+
		"\7?\2\2\u0149L\3\2\2\2\u014a\u014b\7d\2\2\u014b\u014c\7t\2\2\u014c\u014d"+
		"\7g\2\2\u014d\u014e\7c\2\2\u014e\u014f\7m\2\2\u014fN\3\2\2\2\u0150\u0151"+
		"\7e\2\2\u0151\u0152\7q\2\2\u0152\u0153\7p\2\2\u0153\u0154\7v\2\2\u0154"+
		"\u0155\7k\2\2\u0155\u0156\7p\2\2\u0156\u0157\7w\2\2\u0157\u0158\7g\2\2"+
		"\u0158P\3\2\2\2\u0159\u015a\7g\2\2\u015a\u015b\7n\2\2\u015b\u015c\7u\2"+
		"\2\u015c\u015d\7g\2\2\u015dR\3\2\2\2\u015e\u015f\7v\2\2\u015f\u0160\7"+
		"t\2\2\u0160\u0161\7{\2\2\u0161T\3\2\2\2\u0162\u0163\7e\2\2\u0163\u0164"+
		"\7c\2\2\u0164\u0165\7v\2\2\u0165\u0166\7e\2\2\u0166\u0167\7j\2\2\u0167"+
		"V\3\2\2\2\u0168\u0169\7c\2\2\u0169\u016a\7u\2\2\u016a\u016b\7o\2\2\u016b"+
		"X\3\2\2\2\u016c\u016d\7c\2\2\u016d\u016e\7u\2\2\u016e\u016f\7u\2\2\u016f"+
		"\u0170\7g\2\2\u0170\u0171\7t\2\2\u0171\u0172\7v\2\2\u0172Z\3\2\2\2\u0173"+
		"\u0174\7v\2\2\u0174\u0175\7j\2\2\u0175\u0176\7t\2\2\u0176\u0177\7q\2\2"+
		"\u0177\u0178\7y\2\2\u0178\\\3\2\2\2\u0179\u017a\7k\2\2\u017a\u017b\7p"+
		"\2\2\u017b\u017c\7e\2\2\u017c\u017d\7n\2\2\u017d\u017e\7w\2\2\u017e\u017f"+
		"\7f\2\2\u017f\u0180\7g\2\2\u0180^\3\2\2\2\u0181\u0182\7h\2\2\u0182\u0183"+
		"\7n\2\2\u0183\u0184\7c\2\2\u0184\u0185\7i\2\2\u0185`\3\2\2\2\u0186\u0187"+
		"\7h\2\2\u0187\u0188\7n\2\2\u0188\u0189\7c\2\2\u0189\u018a\7i\2\2\u018a"+
		"\u018b\7f\2\2\u018b\u018c\7c\2\2\u018c\u018d\7v\2\2\u018d\u018e\7c\2\2"+
		"\u018eb\3\2\2\2\u018f\u0190\7\60\2\2\u0190d\3\2\2\2\u0191\u0192\7a\2\2"+
		"\u0192f\3\2\2\2\u0193\u0194\7&\2\2\u0194h\3\2\2\2\u0195\u0196\7%\2\2\u0196"+
		"j\3\2\2\2\u0197\u0198\7/\2\2\u0198l\3\2\2\2\u0199\u019a\7#\2\2\u019an"+
		"\3\2\2\2\u019b\u019c\7/\2\2\u019c\u019d\7/\2\2\u019dp\3\2\2\2\u019e\u019f"+
		"\7-\2\2\u019f\u01a0\7-\2\2\u01a0r\3\2\2\2\u01a1\u01a2\7\'\2\2\u01a2t\3"+
		"\2\2\2\u01a3\u01a4\7,\2\2\u01a4v\3\2\2\2\u01a5\u01a6\7\61\2\2\u01a6x\3"+
		"\2\2\2\u01a7\u01a8\7-\2\2\u01a8z\3\2\2\2\u01a9\u01aa\7(\2\2\u01aa|\3\2"+
		"\2\2\u01ab\u01ac\7~\2\2\u01ac~\3\2\2\2\u01ad\u01ae\7`\2\2\u01ae\u0080"+
		"\3\2\2\2\u01af\u01b0\7\u0080\2\2\u01b0\u0082\3\2\2\2\u01b1\u01b2\7(\2"+
		"\2\u01b2\u01b3\7(\2\2\u01b3\u0084\3\2\2\2\u01b4\u01b5\7~\2\2\u01b5\u01b6"+
		"\7~\2\2\u01b6\u0086\3\2\2\2\u01b7\u01b8\7`\2\2\u01b8\u01b9\7`\2\2\u01b9"+
		"\u0088\3\2\2\2\u01ba\u01bb\7>\2\2\u01bb\u008a\3\2\2\2\u01bc\u01bd\7>\2"+
		"\2\u01bd\u01be\7?\2\2\u01be\u008c\3\2\2\2\u01bf\u01c0\7@\2\2\u01c0\u008e"+
		"\3\2\2\2\u01c1\u01c2\7@\2\2\u01c2\u01c3\7?\2\2\u01c3\u0090\3\2\2\2\u01c4"+
		"\u01c5\7?\2\2\u01c5\u01c6\7?\2\2\u01c6\u0092\3\2\2\2\u01c7\u01c8\7#\2"+
		"\2\u01c8\u01c9\7?\2\2\u01c9\u0094\3\2\2\2\u01ca\u01cb\7A\2\2\u01cb\u0096"+
		"\3\2\2\2\u01cc\u01cd\7<\2\2\u01cd\u0098\3\2\2\2\u01ce\u01cf\7e\2\2\u01cf"+
		"\u01d0\7q\2\2\u01d0\u01d1\7p\2\2\u01d1\u01d2\7u\2\2\u01d2\u01d3\7v\2\2"+
		"\u01d3\u009a\3\2\2\2\u01d4\u01d9\5\u009dO\2\u01d5\u01d8\5\u009dO\2\u01d6"+
		"\u01d8\t\2\2\2\u01d7\u01d5\3\2\2\2\u01d7\u01d6\3\2\2\2\u01d8\u01db\3\2"+
		"\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u009c\3\2\2\2\u01db"+
		"\u01d9\3\2\2\2\u01dc\u01dd\t\3\2\2\u01dd\u009e\3\2\2\2\u01de\u01e0\t\4"+
		"\2\2\u01df\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01df\3\2\2\2\u01e1"+
		"\u01e2\3\2\2\2\u01e2\u00a0\3\2\2\2\u01e3\u01e5\t\5\2\2\u01e4\u01e3\3\2"+
		"\2\2\u01e5\u00a2\3\2\2\2\u01e6\u01e8\t\6\2\2\u01e7\u01e9\t\7\2\2\u01e8"+
		"\u01e7\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01ec\t\4"+
		"\2\2\u01eb\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ed"+
		"\u01ee\3\2\2\2\u01ee\u00a4\3\2\2\2\u01ef\u01f0\5\u009fP\2\u01f0\u01f2"+
		"\7\60\2\2\u01f1\u01f3\5\u009fP\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3\3\2\2"+
		"\2\u01f3\u01f5\3\2\2\2\u01f4\u01f6\5\u00a3R\2\u01f5\u01f4\3\2\2\2\u01f5"+
		"\u01f6\3\2\2\2\u01f6\u01fb\3\2\2\2\u01f7\u01f8\5\u009fP\2\u01f8\u01f9"+
		"\5\u00a3R\2\u01f9\u01fb\3\2\2\2\u01fa\u01ef\3\2\2\2\u01fa\u01f7\3\2\2"+
		"\2\u01fb\u00a6\3\2\2\2\u01fc\u01fd\7\62\2\2\u01fd\u01fe\7z\2\2\u01fe\u01ff"+
		"\3\2\2\2\u01ff\u0203\5\u00a1Q\2\u0200\u0202\5\u00a1Q\2\u0201\u0200\3\2"+
		"\2\2\u0202\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203\u0204\3\2\2\2\u0204"+
		"\u00a8\3\2\2\2\u0205\u0203\3\2\2\2\u0206\u0208\7$\2\2\u0207\u0209\5\u00ad"+
		"W\2\u0208\u0207\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u020a\3\2\2\2\u020a"+
		"\u020b\7$\2\2\u020b\u00aa\3\2\2\2\u020c\u020d\7)\2\2\u020d\u020e\5\u00af"+
		"X\2\u020e\u020f\7)\2\2\u020f\u00ac\3\2\2\2\u0210\u0212\5\u00afX\2\u0211"+
		"\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2"+
		"\2\2\u0214\u00ae\3\2\2\2\u0215\u021c\n\b\2\2\u0216\u0217\7^\2\2\u0217"+
		"\u021c\7\f\2\2\u0218\u0219\7^\2\2\u0219\u021a\7\17\2\2\u021a\u021c\7\f"+
		"\2\2\u021b\u0215\3\2\2\2\u021b\u0216\3\2\2\2\u021b\u0218\3\2\2\2\u021c"+
		"\u00b0\3\2\2\2\u021d\u021f\t\t\2\2\u021e\u021d\3\2\2\2\u021f\u0220\3\2"+
		"\2\2\u0220\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0222\3\2\2\2\u0222"+
		"\u0223\bY\2\2\u0223\u00b2\3\2\2\2\u0224\u0225\7\61\2\2\u0225\u0226\7\61"+
		"\2\2\u0226\u022a\3\2\2\2\u0227\u0229\13\2\2\2\u0228\u0227\3\2\2\2\u0229"+
		"\u022c\3\2\2\2\u022a\u022b\3\2\2\2\u022a\u0228\3\2\2\2\u022b\u022d\3\2"+
		"\2\2\u022c\u022a\3\2\2\2\u022d\u022e\7\f\2\2\u022e\u022f\3\2\2\2\u022f"+
		"\u0230\bZ\3\2\u0230\u00b4\3\2\2\2\u0231\u0232\7\61\2\2\u0232\u0233\7,"+
		"\2\2\u0233\u0237\3\2\2\2\u0234\u0236\13\2\2\2\u0235\u0234\3\2\2\2\u0236"+
		"\u0239\3\2\2\2\u0237\u0238\3\2\2\2\u0237\u0235\3\2\2\2\u0238\u023a\3\2"+
		"\2\2\u0239\u0237\3\2\2\2\u023a\u023b\7,\2\2\u023b\u023c\7\61\2\2\u023c"+
		"\u023d\3\2\2\2\u023d\u023e\b[\3\2\u023e\u00b6\3\2\2\2\u023f\u0240\13\2"+
		"\2\2\u0240\u0241\3\2\2\2\u0241\u0242\b\\\3\2\u0242\u00b8\3\2\2\2\23\2"+
		"\u01d7\u01d9\u01e1\u01e4\u01e8\u01ed\u01f2\u01f5\u01fa\u0203\u0208\u0213"+
		"\u021b\u0220\u022a\u0237\4\2\3\2\2\4\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}