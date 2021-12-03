// Generated from C:/Users/ionas/Desktop/Cours/M2/S1/Analyse_Statique/Enoso/src/main/java/antlr\WhileLanguage.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WhileLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Pos=1, New=2, Skip=3, Plus=4, Minus=5, Multiplication=6, Division=7, True=8, 
		False=9, Lower=10, LowerOrEqual=11, Greater=12, GreaterOrEqual=13, Equal=14, 
		Different=15, Not=16, OpeningParenthesis=17, ClosingParenthesis=18, OpeningBracket=19, 
		ClosingBracket=20, Coma=21, Semicolon=22, Affectation=23, Program=24, 
		Proc=25, Begin=26, End=27, Res=28, Call=29, If=30, Then=31, Else=32, While=33, 
		Do=34, Type=35, Table=36, Boolean=37, Int=38, Identifier=39, WS=40;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Pos", "New", "Skip", "Plus", "Minus", "Multiplication", "Division", 
			"True", "False", "Lower", "LowerOrEqual", "Greater", "GreaterOrEqual", 
			"Equal", "Different", "Not", "OpeningParenthesis", "ClosingParenthesis", 
			"OpeningBracket", "ClosingBracket", "Coma", "Semicolon", "Affectation", 
			"Program", "Proc", "Begin", "End", "Res", "Call", "If", "Then", "Else", 
			"While", "Do", "Type", "Table", "Boolean", "Int", "Identifier", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'new'", "'skip'", "'+'", "'-'", "'*'", "'/'", "'true'", 
			"'false'", "'<'", "'<='", "'>'", "'>='", "'='", "'<>'", "'not'", "'('", 
			"')'", "'['", "']'", "','", "';'", "':='", "'program'", "'proc'", "'begin'", 
			"'end'", "'res'", "'call'", "'if'", "'then'", "'else'", "'while'", "'do'", 
			null, null, "'boolean'", "'int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Pos", "New", "Skip", "Plus", "Minus", "Multiplication", "Division", 
			"True", "False", "Lower", "LowerOrEqual", "Greater", "GreaterOrEqual", 
			"Equal", "Different", "Not", "OpeningParenthesis", "ClosingParenthesis", 
			"OpeningBracket", "ClosingBracket", "Coma", "Semicolon", "Affectation", 
			"Program", "Proc", "Begin", "End", "Res", "Call", "If", "Then", "Else", 
			"While", "Do", "Type", "Table", "Boolean", "Int", "Identifier", "WS"
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


	public WhileLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "WhileLanguage.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u00ee\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\6\2U\n\2\r"+
		"\2\16\2V\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\5$\u00cf\n$\3%\3%\3%\3%\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\7(\u00e3\n(\f(\16(\u00e6\13"+
		"(\3)\6)\u00e9\n)\r)\16)\u00ea\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3\2\6"+
		"\3\2\62;\3\2c|\5\2\62;aac|\5\2\13\f\17\17\"\"\2\u00f1\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\3T\3\2\2\2\5X\3\2\2\2\7\\\3"+
		"\2\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2\2\17g\3\2\2\2\21i\3\2\2\2\23n\3"+
		"\2\2\2\25t\3\2\2\2\27v\3\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35~\3\2\2\2\37"+
		"\u0080\3\2\2\2!\u0083\3\2\2\2#\u0087\3\2\2\2%\u0089\3\2\2\2\'\u008b\3"+
		"\2\2\2)\u008d\3\2\2\2+\u008f\3\2\2\2-\u0091\3\2\2\2/\u0093\3\2\2\2\61"+
		"\u0096\3\2\2\2\63\u009e\3\2\2\2\65\u00a3\3\2\2\2\67\u00a9\3\2\2\29\u00ad"+
		"\3\2\2\2;\u00b1\3\2\2\2=\u00b6\3\2\2\2?\u00b9\3\2\2\2A\u00be\3\2\2\2C"+
		"\u00c3\3\2\2\2E\u00c9\3\2\2\2G\u00ce\3\2\2\2I\u00d0\3\2\2\2K\u00d4\3\2"+
		"\2\2M\u00dc\3\2\2\2O\u00e0\3\2\2\2Q\u00e8\3\2\2\2SU\t\2\2\2TS\3\2\2\2"+
		"UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\4\3\2\2\2XY\7p\2\2YZ\7g\2\2Z[\7y\2\2["+
		"\6\3\2\2\2\\]\7u\2\2]^\7m\2\2^_\7k\2\2_`\7r\2\2`\b\3\2\2\2ab\7-\2\2b\n"+
		"\3\2\2\2cd\7/\2\2d\f\3\2\2\2ef\7,\2\2f\16\3\2\2\2gh\7\61\2\2h\20\3\2\2"+
		"\2ij\7v\2\2jk\7t\2\2kl\7w\2\2lm\7g\2\2m\22\3\2\2\2no\7h\2\2op\7c\2\2p"+
		"q\7n\2\2qr\7u\2\2rs\7g\2\2s\24\3\2\2\2tu\7>\2\2u\26\3\2\2\2vw\7>\2\2w"+
		"x\7?\2\2x\30\3\2\2\2yz\7@\2\2z\32\3\2\2\2{|\7@\2\2|}\7?\2\2}\34\3\2\2"+
		"\2~\177\7?\2\2\177\36\3\2\2\2\u0080\u0081\7>\2\2\u0081\u0082\7@\2\2\u0082"+
		" \3\2\2\2\u0083\u0084\7p\2\2\u0084\u0085\7q\2\2\u0085\u0086\7v\2\2\u0086"+
		"\"\3\2\2\2\u0087\u0088\7*\2\2\u0088$\3\2\2\2\u0089\u008a\7+\2\2\u008a"+
		"&\3\2\2\2\u008b\u008c\7]\2\2\u008c(\3\2\2\2\u008d\u008e\7_\2\2\u008e*"+
		"\3\2\2\2\u008f\u0090\7.\2\2\u0090,\3\2\2\2\u0091\u0092\7=\2\2\u0092.\3"+
		"\2\2\2\u0093\u0094\7<\2\2\u0094\u0095\7?\2\2\u0095\60\3\2\2\2\u0096\u0097"+
		"\7r\2\2\u0097\u0098\7t\2\2\u0098\u0099\7q\2\2\u0099\u009a\7i\2\2\u009a"+
		"\u009b\7t\2\2\u009b\u009c\7c\2\2\u009c\u009d\7o\2\2\u009d\62\3\2\2\2\u009e"+
		"\u009f\7r\2\2\u009f\u00a0\7t\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7e\2\2"+
		"\u00a2\64\3\2\2\2\u00a3\u00a4\7d\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7"+
		"i\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8\7p\2\2\u00a8\66\3\2\2\2\u00a9\u00aa"+
		"\7g\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7f\2\2\u00ac8\3\2\2\2\u00ad\u00ae"+
		"\7t\2\2\u00ae\u00af\7g\2\2\u00af\u00b0\7u\2\2\u00b0:\3\2\2\2\u00b1\u00b2"+
		"\7e\2\2\u00b2\u00b3\7c\2\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7n\2\2\u00b5"+
		"<\3\2\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7h\2\2\u00b8>\3\2\2\2\u00b9\u00ba"+
		"\7v\2\2\u00ba\u00bb\7j\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7p\2\2\u00bd"+
		"@\3\2\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7u\2\2\u00c1"+
		"\u00c2\7g\2\2\u00c2B\3\2\2\2\u00c3\u00c4\7y\2\2\u00c4\u00c5\7j\2\2\u00c5"+
		"\u00c6\7k\2\2\u00c6\u00c7\7n\2\2\u00c7\u00c8\7g\2\2\u00c8D\3\2\2\2\u00c9"+
		"\u00ca\7f\2\2\u00ca\u00cb\7q\2\2\u00cbF\3\2\2\2\u00cc\u00cf\5K&\2\u00cd"+
		"\u00cf\5M\'\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cfH\3\2\2\2\u00d0"+
		"\u00d1\5G$\2\u00d1\u00d2\5\'\24\2\u00d2\u00d3\5)\25\2\u00d3J\3\2\2\2\u00d4"+
		"\u00d5\7d\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7n\2\2"+
		"\u00d8\u00d9\7g\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7p\2\2\u00dbL\3\2\2"+
		"\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7v\2\2\u00dfN\3\2"+
		"\2\2\u00e0\u00e4\t\3\2\2\u00e1\u00e3\t\4\2\2\u00e2\u00e1\3\2\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5P\3\2\2\2"+
		"\u00e6\u00e4\3\2\2\2\u00e7\u00e9\t\5\2\2\u00e8\u00e7\3\2\2\2\u00e9\u00ea"+
		"\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec"+
		"\u00ed\b)\2\2\u00edR\3\2\2\2\7\2V\u00ce\u00e4\u00ea\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}