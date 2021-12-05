// Generated from E:/Enoso/src/main/java/antlr\WhileLanguage.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WhileLanguageParser extends Parser {
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
		Do=34, Type=35, Boolean=36, Int=37, Identifier=38, WS=39;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_lDeclIdent = 2, RULE_lDeclVariables = 3, 
		RULE_declVariables = 4, RULE_lIdentifier = 5, RULE_type = 6, RULE_block = 7, 
		RULE_statements = 8, RULE_statement = 9, RULE_lAexpression = 10, RULE_aexpression = 11, 
		RULE_opa = 12, RULE_bexpression = 13, RULE_opr = 14, RULE_constant = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "lDeclIdent", "lDeclVariables", "declVariables", 
			"lIdentifier", "type", "block", "statements", "statement", "lAexpression", 
			"aexpression", "opa", "bexpression", "opr", "constant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'new'", "'skip'", "'+'", "'-'", "'*'", "'/'", "'true'", 
			"'false'", "'<'", "'<='", "'>'", "'>='", "'='", "'<>'", "'not'", "'('", 
			"')'", "'['", "']'", "','", "';'", "':='", "'program'", "'proc'", "'begin'", 
			"'end'", "'res'", "'call'", "'if'", "'then'", "'else'", "'while'", "'do'", 
			null, "'boolean'", "'int'"
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
			"While", "Do", "Type", "Boolean", "Int", "Identifier", "WS"
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
	public String getGrammarFileName() { return "WhileLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WhileLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode Program() { return getToken(WhileLanguageParser.Program, 0); }
		public TerminalNode Begin() { return getToken(WhileLanguageParser.Begin, 0); }
		public LDeclVariablesContext lDeclVariables() {
			return getRuleContext(LDeclVariablesContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode End() { return getToken(WhileLanguageParser.End, 0); }
		public TerminalNode Identifier() { return getToken(WhileLanguageParser.Identifier, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor) return ((WhileLanguageVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(Program);
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(33);
				match(Identifier);
				}
			}

			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Proc) {
				{
				{
				setState(36);
				declaration();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			match(Begin);
			setState(43);
			lDeclVariables();
			setState(44);
			statements();
			setState(45);
			match(End);
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

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode Proc() { return getToken(WhileLanguageParser.Proc, 0); }
		public List<TerminalNode> Identifier() { return getTokens(WhileLanguageParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(WhileLanguageParser.Identifier, i);
		}
		public TerminalNode OpeningParenthesis() { return getToken(WhileLanguageParser.OpeningParenthesis, 0); }
		public LDeclIdentContext lDeclIdent() {
			return getRuleContext(LDeclIdentContext.class,0);
		}
		public TerminalNode ClosingParenthesis() { return getToken(WhileLanguageParser.ClosingParenthesis, 0); }
		public TerminalNode Begin() { return getToken(WhileLanguageParser.Begin, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode End() { return getToken(WhileLanguageParser.End, 0); }
		public TerminalNode Coma() { return getToken(WhileLanguageParser.Coma, 0); }
		public TerminalNode Res() { return getToken(WhileLanguageParser.Res, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(Proc);
			setState(48);
			match(Identifier);
			setState(49);
			match(OpeningParenthesis);
			setState(50);
			lDeclIdent();
			{
			setState(51);
			match(Coma);
			setState(52);
			match(Res);
			setState(53);
			type();
			setState(54);
			match(Identifier);
			}
			setState(56);
			match(ClosingParenthesis);
			setState(57);
			match(Begin);
			setState(58);
			statements();
			setState(59);
			match(End);
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

	public static class LDeclIdentContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(WhileLanguageParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(WhileLanguageParser.Identifier, i);
		}
		public List<TerminalNode> Coma() { return getTokens(WhileLanguageParser.Coma); }
		public TerminalNode Coma(int i) {
			return getToken(WhileLanguageParser.Coma, i);
		}
		public LDeclIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lDeclIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterLDeclIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitLDeclIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitLDeclIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LDeclIdentContext lDeclIdent() throws RecognitionException {
		LDeclIdentContext _localctx = new LDeclIdentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lDeclIdent);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			type();
			setState(62);
			match(Identifier);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(63);
					match(Coma);
					setState(64);
					type();
					setState(65);
					match(Identifier);
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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

	public static class LDeclVariablesContext extends ParserRuleContext {
		public DeclVariablesContext declVariables() {
			return getRuleContext(DeclVariablesContext.class,0);
		}
		public List<LDeclVariablesContext> lDeclVariables() {
			return getRuleContexts(LDeclVariablesContext.class);
		}
		public LDeclVariablesContext lDeclVariables(int i) {
			return getRuleContext(LDeclVariablesContext.class,i);
		}
		public LDeclVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lDeclVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterLDeclVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitLDeclVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitLDeclVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LDeclVariablesContext lDeclVariables() throws RecognitionException {
		LDeclVariablesContext _localctx = new LDeclVariablesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_lDeclVariables);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			declVariables();
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(73);
					lDeclVariables();
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class DeclVariablesContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public LIdentifierContext lIdentifier() {
			return getRuleContext(LIdentifierContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(WhileLanguageParser.Semicolon, 0); }
		public DeclVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterDeclVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitDeclVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitDeclVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclVariablesContext declVariables() throws RecognitionException {
		DeclVariablesContext _localctx = new DeclVariablesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declVariables);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			type();
			setState(80);
			lIdentifier();
			setState(81);
			match(Semicolon);
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

	public static class LIdentifierContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(WhileLanguageParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(WhileLanguageParser.Identifier, i);
		}
		public List<TerminalNode> Coma() { return getTokens(WhileLanguageParser.Coma); }
		public TerminalNode Coma(int i) {
			return getToken(WhileLanguageParser.Coma, i);
		}
		public LIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterLIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitLIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitLIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LIdentifierContext lIdentifier() throws RecognitionException {
		LIdentifierContext _localctx = new LIdentifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_lIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(Identifier);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Coma) {
				{
				{
				setState(84);
				match(Coma);
				setState(85);
				match(Identifier);
				}
				}
				setState(90);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeTableContext extends TypeContext {
		public TerminalNode Type() { return getToken(WhileLanguageParser.Type, 0); }
		public TerminalNode OpeningBracket() { return getToken(WhileLanguageParser.OpeningBracket, 0); }
		public TerminalNode ClosingBracket() { return getToken(WhileLanguageParser.ClosingBracket, 0); }
		public TypeTableContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterTypeTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitTypeTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitTypeTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeTypeContext extends TypeContext {
		public TerminalNode Type() { return getToken(WhileLanguageParser.Type, 0); }
		public TypeTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitTypeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitTypeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new TypeTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(Type);
				}
				break;
			case 2:
				_localctx = new TypeTableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(Type);
				setState(93);
				match(OpeningBracket);
				setState(94);
				match(ClosingBracket);
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

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockWithinParenthesisContext extends BlockContext {
		public TerminalNode OpeningParenthesis() { return getToken(WhileLanguageParser.OpeningParenthesis, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode ClosingParenthesis() { return getToken(WhileLanguageParser.ClosingParenthesis, 0); }
		public BlockWithinParenthesisContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterBlockWithinParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitBlockWithinParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitBlockWithinParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatementContext extends BlockContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_block);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Skip:
			case Call:
			case If:
			case While:
			case Identifier:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				statement();
				}
				break;
			case OpeningParenthesis:
				_localctx = new BlockWithinParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(OpeningParenthesis);
				setState(99);
				statements();
				setState(100);
				match(ClosingParenthesis);
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<TerminalNode> Semicolon() { return getTokens(WhileLanguageParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(WhileLanguageParser.Semicolon, i);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			statement();
			setState(109);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(105);
					match(Semicolon);
					setState(106);
					statements();
					}
					} 
				}
				setState(111);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
	public static class StatementIfContext extends StatementContext {
		public TerminalNode If() { return getToken(WhileLanguageParser.If, 0); }
		public BexpressionContext bexpression() {
			return getRuleContext(BexpressionContext.class,0);
		}
		public TerminalNode Then() { return getToken(WhileLanguageParser.Then, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Else() { return getToken(WhileLanguageParser.Else, 0); }
		public StatementIfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterStatementIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitStatementIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitStatementIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementSkipContext extends StatementContext {
		public TerminalNode Skip() { return getToken(WhileLanguageParser.Skip, 0); }
		public StatementSkipContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterStatementSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitStatementSkip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitStatementSkip(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementWhileContext extends StatementContext {
		public TerminalNode While() { return getToken(WhileLanguageParser.While, 0); }
		public BexpressionContext bexpression() {
			return getRuleContext(BexpressionContext.class,0);
		}
		public TerminalNode Do() { return getToken(WhileLanguageParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterStatementWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitStatementWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitStatementWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementCallContext extends StatementContext {
		public TerminalNode Call() { return getToken(WhileLanguageParser.Call, 0); }
		public TerminalNode Identifier() { return getToken(WhileLanguageParser.Identifier, 0); }
		public TerminalNode OpeningParenthesis() { return getToken(WhileLanguageParser.OpeningParenthesis, 0); }
		public LAexpressionContext lAexpression() {
			return getRuleContext(LAexpressionContext.class,0);
		}
		public TerminalNode ClosingParenthesis() { return getToken(WhileLanguageParser.ClosingParenthesis, 0); }
		public StatementCallContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterStatementCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitStatementCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitStatementCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatementAffectationContext extends StatementContext {
		public TerminalNode Identifier() { return getToken(WhileLanguageParser.Identifier, 0); }
		public TerminalNode Affectation() { return getToken(WhileLanguageParser.Affectation, 0); }
		public AexpressionContext aexpression() {
			return getRuleContext(AexpressionContext.class,0);
		}
		public StatementAffectationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterStatementAffectation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitStatementAffectation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitStatementAffectation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Skip:
				_localctx = new StatementSkipContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(Skip);
				}
				break;
			case Identifier:
				_localctx = new StatementAffectationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				match(Identifier);
				setState(114);
				match(Affectation);
				setState(115);
				aexpression(0);
				}
				break;
			case If:
				_localctx = new StatementIfContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(If);
				setState(117);
				bexpression();
				setState(118);
				match(Then);
				setState(119);
				block();
				setState(122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(120);
					match(Else);
					setState(121);
					block();
					}
					break;
				}
				}
				break;
			case While:
				_localctx = new StatementWhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				match(While);
				setState(125);
				bexpression();
				setState(126);
				match(Do);
				setState(127);
				block();
				}
				break;
			case Call:
				_localctx = new StatementCallContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(129);
				match(Call);
				setState(130);
				match(Identifier);
				setState(131);
				match(OpeningParenthesis);
				setState(132);
				lAexpression();
				setState(133);
				match(ClosingParenthesis);
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

	public static class LAexpressionContext extends ParserRuleContext {
		public List<AexpressionContext> aexpression() {
			return getRuleContexts(AexpressionContext.class);
		}
		public AexpressionContext aexpression(int i) {
			return getRuleContext(AexpressionContext.class,i);
		}
		public List<TerminalNode> Coma() { return getTokens(WhileLanguageParser.Coma); }
		public TerminalNode Coma(int i) {
			return getToken(WhileLanguageParser.Coma, i);
		}
		public LAexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lAexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterLAexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitLAexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitLAexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LAexpressionContext lAexpression() throws RecognitionException {
		LAexpressionContext _localctx = new LAexpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lAexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			aexpression(0);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Coma) {
				{
				{
				setState(138);
				match(Coma);
				setState(139);
				aexpression(0);
				}
				}
				setState(144);
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

	public static class AexpressionContext extends ParserRuleContext {
		public AexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aexpression; }
	 
		public AexpressionContext() { }
		public void copyFrom(AexpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AexpressionArrayContext extends AexpressionContext {
		public TerminalNode Identifier() { return getToken(WhileLanguageParser.Identifier, 0); }
		public TerminalNode OpeningBracket() { return getToken(WhileLanguageParser.OpeningBracket, 0); }
		public AexpressionContext aexpression() {
			return getRuleContext(AexpressionContext.class,0);
		}
		public TerminalNode ClosingBracket() { return getToken(WhileLanguageParser.ClosingBracket, 0); }
		public AexpressionArrayContext(AexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterAexpressionArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitAexpressionArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitAexpressionArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AexpressionParenthesisContext extends AexpressionContext {
		public TerminalNode OpeningParenthesis() { return getToken(WhileLanguageParser.OpeningParenthesis, 0); }
		public AexpressionContext aexpression() {
			return getRuleContext(AexpressionContext.class,0);
		}
		public TerminalNode ClosingParenthesis() { return getToken(WhileLanguageParser.ClosingParenthesis, 0); }
		public AexpressionParenthesisContext(AexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterAexpressionParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitAexpressionParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitAexpressionParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AexpressionIdentifierContext extends AexpressionContext {
		public TerminalNode Identifier() { return getToken(WhileLanguageParser.Identifier, 0); }
		public AexpressionIdentifierContext(AexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterAexpressionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitAexpressionIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitAexpressionIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AexpressionConstantContext extends AexpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public AexpressionConstantContext(AexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterAexpressionConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitAexpressionConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitAexpressionConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AexpressionNegContext extends AexpressionContext {
		public TerminalNode Minus() { return getToken(WhileLanguageParser.Minus, 0); }
		public AexpressionContext aexpression() {
			return getRuleContext(AexpressionContext.class,0);
		}
		public AexpressionNegContext(AexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterAexpressionNeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitAexpressionNeg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitAexpressionNeg(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AexpressionNewContext extends AexpressionContext {
		public TerminalNode New() { return getToken(WhileLanguageParser.New, 0); }
		public TerminalNode Type() { return getToken(WhileLanguageParser.Type, 0); }
		public TerminalNode OpeningBracket() { return getToken(WhileLanguageParser.OpeningBracket, 0); }
		public AexpressionContext aexpression() {
			return getRuleContext(AexpressionContext.class,0);
		}
		public TerminalNode ClosingBracket() { return getToken(WhileLanguageParser.ClosingBracket, 0); }
		public AexpressionNewContext(AexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterAexpressionNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitAexpressionNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitAexpressionNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AexpressionBinaryContext extends AexpressionContext {
		public List<AexpressionContext> aexpression() {
			return getRuleContexts(AexpressionContext.class);
		}
		public AexpressionContext aexpression(int i) {
			return getRuleContext(AexpressionContext.class,i);
		}
		public OpaContext opa() {
			return getRuleContext(OpaContext.class,0);
		}
		public AexpressionBinaryContext(AexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterAexpressionBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitAexpressionBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitAexpressionBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AexpressionContext aexpression() throws RecognitionException {
		return aexpression(0);
	}

	private AexpressionContext aexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AexpressionContext _localctx = new AexpressionContext(_ctx, _parentState);
		AexpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_aexpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new AexpressionIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(146);
				match(Identifier);
				}
				break;
			case 2:
				{
				_localctx = new AexpressionConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				constant();
				}
				break;
			case 3:
				{
				_localctx = new AexpressionNegContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				match(Minus);
				setState(149);
				aexpression(4);
				}
				break;
			case 4:
				{
				_localctx = new AexpressionParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150);
				match(OpeningParenthesis);
				setState(151);
				aexpression(0);
				setState(152);
				match(ClosingParenthesis);
				}
				break;
			case 5:
				{
				_localctx = new AexpressionArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154);
				match(Identifier);
				setState(155);
				match(OpeningBracket);
				setState(156);
				aexpression(0);
				setState(157);
				match(ClosingBracket);
				}
				break;
			case 6:
				{
				_localctx = new AexpressionNewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				match(New);
				setState(160);
				match(Type);
				setState(161);
				match(OpeningBracket);
				setState(162);
				aexpression(0);
				setState(163);
				match(ClosingBracket);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AexpressionBinaryContext(new AexpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_aexpression);
					setState(167);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(168);
					opa();
					setState(169);
					aexpression(6);
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class OpaContext extends ParserRuleContext {
		public OpaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opa; }
	 
		public OpaContext() { }
		public void copyFrom(OpaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OpaMultiplicationContext extends OpaContext {
		public TerminalNode Multiplication() { return getToken(WhileLanguageParser.Multiplication, 0); }
		public OpaMultiplicationContext(OpaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOpaMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOpaMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOpaMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpaDivisionContext extends OpaContext {
		public TerminalNode Division() { return getToken(WhileLanguageParser.Division, 0); }
		public OpaDivisionContext(OpaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOpaDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOpaDivision(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOpaDivision(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpaMinusContext extends OpaContext {
		public TerminalNode Minus() { return getToken(WhileLanguageParser.Minus, 0); }
		public OpaMinusContext(OpaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOpaMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOpaMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOpaMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpaPlusContext extends OpaContext {
		public TerminalNode Plus() { return getToken(WhileLanguageParser.Plus, 0); }
		public OpaPlusContext(OpaContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOpaPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOpaPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOpaPlus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpaContext opa() throws RecognitionException {
		OpaContext _localctx = new OpaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_opa);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Plus:
				_localctx = new OpaPlusContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(Plus);
				}
				break;
			case Minus:
				_localctx = new OpaMinusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(Minus);
				}
				break;
			case Multiplication:
				_localctx = new OpaMultiplicationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(Multiplication);
				}
				break;
			case Division:
				_localctx = new OpaDivisionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				match(Division);
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

	public static class BexpressionContext extends ParserRuleContext {
		public BexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bexpression; }
	 
		public BexpressionContext() { }
		public void copyFrom(BexpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BexpressionTrueContext extends BexpressionContext {
		public TerminalNode True() { return getToken(WhileLanguageParser.True, 0); }
		public BexpressionTrueContext(BexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterBexpressionTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitBexpressionTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitBexpressionTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BexpressionParenthesisContext extends BexpressionContext {
		public TerminalNode OpeningParenthesis() { return getToken(WhileLanguageParser.OpeningParenthesis, 0); }
		public BexpressionContext bexpression() {
			return getRuleContext(BexpressionContext.class,0);
		}
		public TerminalNode ClosingParenthesis() { return getToken(WhileLanguageParser.ClosingParenthesis, 0); }
		public BexpressionParenthesisContext(BexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterBexpressionParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitBexpressionParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitBexpressionParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BexpressionFalseContext extends BexpressionContext {
		public TerminalNode False() { return getToken(WhileLanguageParser.False, 0); }
		public BexpressionFalseContext(BexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterBexpressionFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitBexpressionFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitBexpressionFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BexpressionAexpressionOprAexpressionContext extends BexpressionContext {
		public List<AexpressionContext> aexpression() {
			return getRuleContexts(AexpressionContext.class);
		}
		public AexpressionContext aexpression(int i) {
			return getRuleContext(AexpressionContext.class,i);
		}
		public OprContext opr() {
			return getRuleContext(OprContext.class,0);
		}
		public BexpressionAexpressionOprAexpressionContext(BexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterBexpressionAexpressionOprAexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitBexpressionAexpressionOprAexpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitBexpressionAexpressionOprAexpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BexpressionNotContext extends BexpressionContext {
		public TerminalNode Not() { return getToken(WhileLanguageParser.Not, 0); }
		public BexpressionContext bexpression() {
			return getRuleContext(BexpressionContext.class,0);
		}
		public BexpressionNotContext(BexpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterBexpressionNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitBexpressionNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitBexpressionNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BexpressionContext bexpression() throws RecognitionException {
		BexpressionContext _localctx = new BexpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_bexpression);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new BexpressionTrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(True);
				}
				break;
			case 2:
				_localctx = new BexpressionFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(False);
				}
				break;
			case 3:
				_localctx = new BexpressionAexpressionOprAexpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				aexpression(0);
				setState(185);
				opr();
				setState(186);
				aexpression(0);
				}
				break;
			case 4:
				_localctx = new BexpressionNotContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
				match(Not);
				setState(189);
				bexpression();
				}
				break;
			case 5:
				_localctx = new BexpressionParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(190);
				match(OpeningParenthesis);
				setState(191);
				bexpression();
				setState(192);
				match(ClosingParenthesis);
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

	public static class OprContext extends ParserRuleContext {
		public OprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opr; }
	 
		public OprContext() { }
		public void copyFrom(OprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class OprLowerContext extends OprContext {
		public TerminalNode Lower() { return getToken(WhileLanguageParser.Lower, 0); }
		public OprLowerContext(OprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOprLower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOprLower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOprLower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OprEqualContext extends OprContext {
		public TerminalNode Equal() { return getToken(WhileLanguageParser.Equal, 0); }
		public OprEqualContext(OprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOprEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOprEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOprEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OprDifferentContext extends OprContext {
		public TerminalNode Different() { return getToken(WhileLanguageParser.Different, 0); }
		public OprDifferentContext(OprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOprDifferent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOprDifferent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOprDifferent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OprGreaterOrEqualContext extends OprContext {
		public TerminalNode GreaterOrEqual() { return getToken(WhileLanguageParser.GreaterOrEqual, 0); }
		public OprGreaterOrEqualContext(OprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOprGreaterOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOprGreaterOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOprGreaterOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OprGreaterContext extends OprContext {
		public TerminalNode Greater() { return getToken(WhileLanguageParser.Greater, 0); }
		public OprGreaterContext(OprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOprGreater(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOprGreater(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOprGreater(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OprLowerOrEqualContext extends OprContext {
		public TerminalNode LowerOrEqual() { return getToken(WhileLanguageParser.LowerOrEqual, 0); }
		public OprLowerOrEqualContext(OprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterOprLowerOrEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitOprLowerOrEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitOprLowerOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OprContext opr() throws RecognitionException {
		OprContext _localctx = new OprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_opr);
		try {
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Lower:
				_localctx = new OprLowerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(Lower);
				}
				break;
			case LowerOrEqual:
				_localctx = new OprLowerOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(LowerOrEqual);
				}
				break;
			case Greater:
				_localctx = new OprGreaterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				match(Greater);
				}
				break;
			case GreaterOrEqual:
				_localctx = new OprGreaterOrEqualContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				match(GreaterOrEqual);
				}
				break;
			case Equal:
				_localctx = new OprEqualContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(200);
				match(Equal);
				}
				break;
			case Different:
				_localctx = new OprDifferentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(201);
				match(Different);
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode Pos() { return getToken(WhileLanguageParser.Pos, 0); }
		public TerminalNode Minus() { return getToken(WhileLanguageParser.Minus, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof WhileLanguageListener ) ((WhileLanguageListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileLanguageVisitor ) return ((WhileLanguageVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Minus) {
				{
				setState(204);
				match(Minus);
				}
			}

			setState(207);
			match(Pos);
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
		case 11:
			return aexpression_sempred((AexpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean aexpression_sempred(AexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00d4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\5"+
		"\2%\n\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4"+
		"F\n\4\f\4\16\4I\13\4\3\5\3\5\7\5M\n\5\f\5\16\5P\13\5\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\b\3\b\5\bb\n\b\3\t\3\t\3"+
		"\t\3\t\3\t\5\ti\n\t\3\n\3\n\3\n\7\nn\n\n\f\n\16\nq\13\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13}\n\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008a\n\13\3\f\3\f\3\f\7\f\u008f\n"+
		"\f\f\f\16\f\u0092\13\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a8\n\r\3\r\3\r\3\r\3\r\7\r\u00ae"+
		"\n\r\f\r\16\r\u00b1\13\r\3\16\3\16\3\16\3\16\5\16\u00b7\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c5\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00cd\n\20\3\21\5\21\u00d0\n\21\3\21\3"+
		"\21\3\21\2\3\30\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u00e4"+
		"\2\"\3\2\2\2\4\61\3\2\2\2\6?\3\2\2\2\bJ\3\2\2\2\nQ\3\2\2\2\fU\3\2\2\2"+
		"\16a\3\2\2\2\20h\3\2\2\2\22j\3\2\2\2\24\u0089\3\2\2\2\26\u008b\3\2\2\2"+
		"\30\u00a7\3\2\2\2\32\u00b6\3\2\2\2\34\u00c4\3\2\2\2\36\u00cc\3\2\2\2 "+
		"\u00cf\3\2\2\2\"$\7\32\2\2#%\7(\2\2$#\3\2\2\2$%\3\2\2\2%)\3\2\2\2&(\5"+
		"\4\3\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,"+
		"-\7\34\2\2-.\5\b\5\2./\5\22\n\2/\60\7\35\2\2\60\3\3\2\2\2\61\62\7\33\2"+
		"\2\62\63\7(\2\2\63\64\7\23\2\2\64\65\5\6\4\2\65\66\7\27\2\2\66\67\7\36"+
		"\2\2\678\5\16\b\289\7(\2\29:\3\2\2\2:;\7\24\2\2;<\7\34\2\2<=\5\22\n\2"+
		"=>\7\35\2\2>\5\3\2\2\2?@\5\16\b\2@G\7(\2\2AB\7\27\2\2BC\5\16\b\2CD\7("+
		"\2\2DF\3\2\2\2EA\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\7\3\2\2\2IG\3"+
		"\2\2\2JN\5\n\6\2KM\5\b\5\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\t"+
		"\3\2\2\2PN\3\2\2\2QR\5\16\b\2RS\5\f\7\2ST\7\30\2\2T\13\3\2\2\2UZ\7(\2"+
		"\2VW\7\27\2\2WY\7(\2\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\r\3\2"+
		"\2\2\\Z\3\2\2\2]b\7%\2\2^_\7%\2\2_`\7\25\2\2`b\7\26\2\2a]\3\2\2\2a^\3"+
		"\2\2\2b\17\3\2\2\2ci\5\24\13\2de\7\23\2\2ef\5\22\n\2fg\7\24\2\2gi\3\2"+
		"\2\2hc\3\2\2\2hd\3\2\2\2i\21\3\2\2\2jo\5\24\13\2kl\7\30\2\2ln\5\22\n\2"+
		"mk\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\23\3\2\2\2qo\3\2\2\2r\u008a"+
		"\7\5\2\2st\7(\2\2tu\7\31\2\2u\u008a\5\30\r\2vw\7 \2\2wx\5\34\17\2xy\7"+
		"!\2\2y|\5\20\t\2z{\7\"\2\2{}\5\20\t\2|z\3\2\2\2|}\3\2\2\2}\u008a\3\2\2"+
		"\2~\177\7#\2\2\177\u0080\5\34\17\2\u0080\u0081\7$\2\2\u0081\u0082\5\20"+
		"\t\2\u0082\u008a\3\2\2\2\u0083\u0084\7\37\2\2\u0084\u0085\7(\2\2\u0085"+
		"\u0086\7\23\2\2\u0086\u0087\5\26\f\2\u0087\u0088\7\24\2\2\u0088\u008a"+
		"\3\2\2\2\u0089r\3\2\2\2\u0089s\3\2\2\2\u0089v\3\2\2\2\u0089~\3\2\2\2\u0089"+
		"\u0083\3\2\2\2\u008a\25\3\2\2\2\u008b\u0090\5\30\r\2\u008c\u008d\7\27"+
		"\2\2\u008d\u008f\5\30\r\2\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\27\3\2\2\2\u0092\u0090\3\2\2"+
		"\2\u0093\u0094\b\r\1\2\u0094\u00a8\7(\2\2\u0095\u00a8\5 \21\2\u0096\u0097"+
		"\7\7\2\2\u0097\u00a8\5\30\r\6\u0098\u0099\7\23\2\2\u0099\u009a\5\30\r"+
		"\2\u009a\u009b\7\24\2\2\u009b\u00a8\3\2\2\2\u009c\u009d\7(\2\2\u009d\u009e"+
		"\7\25\2\2\u009e\u009f\5\30\r\2\u009f\u00a0\7\26\2\2\u00a0\u00a8\3\2\2"+
		"\2\u00a1\u00a2\7\4\2\2\u00a2\u00a3\7%\2\2\u00a3\u00a4\7\25\2\2\u00a4\u00a5"+
		"\5\30\r\2\u00a5\u00a6\7\26\2\2\u00a6\u00a8\3\2\2\2\u00a7\u0093\3\2\2\2"+
		"\u00a7\u0095\3\2\2\2\u00a7\u0096\3\2\2\2\u00a7\u0098\3\2\2\2\u00a7\u009c"+
		"\3\2\2\2\u00a7\u00a1\3\2\2\2\u00a8\u00af\3\2\2\2\u00a9\u00aa\f\7\2\2\u00aa"+
		"\u00ab\5\32\16\2\u00ab\u00ac\5\30\r\b\u00ac\u00ae\3\2\2\2\u00ad\u00a9"+
		"\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\31\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b7\7\6\2\2\u00b3\u00b7\7\7\2"+
		"\2\u00b4\u00b7\7\b\2\2\u00b5\u00b7\7\t\2\2\u00b6\u00b2\3\2\2\2\u00b6\u00b3"+
		"\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7\33\3\2\2\2\u00b8"+
		"\u00c5\7\n\2\2\u00b9\u00c5\7\13\2\2\u00ba\u00bb\5\30\r\2\u00bb\u00bc\5"+
		"\36\20\2\u00bc\u00bd\5\30\r\2\u00bd\u00c5\3\2\2\2\u00be\u00bf\7\22\2\2"+
		"\u00bf\u00c5\5\34\17\2\u00c0\u00c1\7\23\2\2\u00c1\u00c2\5\34\17\2\u00c2"+
		"\u00c3\7\24\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00b8\3\2\2\2\u00c4\u00b9\3"+
		"\2\2\2\u00c4\u00ba\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c5"+
		"\35\3\2\2\2\u00c6\u00cd\7\f\2\2\u00c7\u00cd\7\r\2\2\u00c8\u00cd\7\16\2"+
		"\2\u00c9\u00cd\7\17\2\2\u00ca\u00cd\7\20\2\2\u00cb\u00cd\7\21\2\2\u00cc"+
		"\u00c6\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc\u00c8\3\2\2\2\u00cc\u00c9\3\2"+
		"\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd\37\3\2\2\2\u00ce\u00d0"+
		"\7\7\2\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d2\7\3\2\2\u00d2!\3\2\2\2\23$)GNZaho|\u0089\u0090\u00a7\u00af\u00b6"+
		"\u00c4\u00cc\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}