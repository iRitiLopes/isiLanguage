// Generated from IsiLang.g4 by ANTLR 4.7.1
package br.com.isilanguage.parser;

    import br.com.isilanguage.exceptions.IsiSemanticException;
    import br.com.isilanguage.datastructures.IsiSymbolTable;
    import br.com.isilanguage.datastructures.IsiVariable;
    import br.com.isilanguage.datastructures.IsiSymbol;

    import br.com.isilanguage.ast.IsiProgram;
    import br.com.isilanguage.ast.AbstractCommand;

    import br.com.isilanguage.ast.CommandAttribution;
    import br.com.isilanguage.ast.CommandRead;
    import br.com.isilanguage.ast.CommandWrite;
    import br.com.isilanguage.ast.CommandIf;
    import br.com.isilanguage.ast.CommandWhile;

    import java.util.ArrayList;
    import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, ACH=12, FCH=13, OPREL=14, NOT=15, VIR=16, AP=17, FP=18, 
		SC=19, OP=20, ATTR=21, ID=22, NUMBER=23, STR=24, WS=25;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_tipo = 2, RULE_bloco = 3, RULE_cmd = 4, 
		RULE_cmdleitura = 5, RULE_cmdescrita = 6, RULE_cmdattrib = 7, RULE_cmdif = 8, 
		RULE_cmdwhile = 9, RULE_boolExpr = 10, RULE_boolExprChild = 11, RULE_boolExprChildChild = 12, 
		RULE_boolTermo = 13, RULE_expr = 14, RULE_exprTermo = 15;
	public static final String[] ruleNames = {
		"prog", "decl", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", "cmdattrib", 
		"cmdif", "cmdwhile", "boolExpr", "boolExprChild", "boolExprChildChild", 
		"boolTermo", "expr", "exprTermo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'senao'", "'enquanto'", "'&&'", "'||'", "'{'", "'}'", null, "'!'", 
		"','", "'('", "')'", "';'", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ACH", "FCH", "OPREL", "NOT", "VIR", "AP", "FP", "SC", "OP", "ATTR", "ID", 
		"NUMBER", "STR", "WS"
	};
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
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int _type;
	    private String _varName;
	    private String _varValue;
	    private IsiSymbolTable symbolTable = new IsiSymbolTable();
	    private IsiSymbol symbol;
	    private IsiVariable variable;
	    private String _exprContent;
	    private String _readID;
	    private String _writeID;

	    private String _exprDecision;

	    private String _exprID;

	    private IsiProgram program = new IsiProgram();
	    private ArrayList<AbstractCommand> curThread;
	    private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();

	    private ArrayList<AbstractCommand> listTrue;
	    private ArrayList<AbstractCommand> listFalse;

	    public boolean isIDDeclared(String id){
	        return symbolTable.exists(id);
	    }

	    public void initializeVar(String id) {
	        if(isIDDeclared(id)){
	            IsiVariable var = symbolTable.get(id);
	            var.setInitialized(true);
	            symbolTable.replace(id, var);
	        }
	    }

	    public boolean isVarInitialized(String id) {
	        if(isIDDeclared(id)){
	            return symbolTable.get(id).isInitialized();
	        }
	        return false;
	    }

	    public void showCommands(){
	    		for (AbstractCommand c: program.getCommands()){
	    			System.out.println(c);
	    		}
	    	}

	    public boolean isNumber(String id){
	        if(isIDDeclared(id)){
	            IsiVariable var = symbolTable.get(id);
	            if(var.getType() == IsiVariable.NUMBER)
	                return true;
	            return false;
	        }
	        return false;
	    }

	    public void generateJavaCode(){
	        program.generateTarget();
	    }


	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				{
				setState(33);
				decl();
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			bloco();
			setState(40);
			match(T__1);
			setState(41);
			match(SC);

			              program.setVarTable(symbolTable);
			              program.setCommands(stack.pop());
			          
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

	public static class DeclContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			tipo();
			setState(45);
			match(ID);

			                _varName = _input.LT(-1).getText();
			                _varValue = null;
			                variable = new IsiVariable(_varName, _type, _varValue);
			                if(!isIDDeclared(_varName)){
			                    symbolTable.add(variable);
			                }else{
			                    throw new IsiSemanticException("Symbol "+_varName+" already declared");
			                }
			             
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(47);
				match(VIR);
				setState(48);
				match(ID);

				               _varName = _input.LT(-1).getText();
				               _varValue = null;
				               variable = new IsiVariable(_varName, _type, _varValue);
				               if(!isIDDeclared(_varName)){
				                   symbolTable.add(variable);
				               }else{
				                   throw new IsiSemanticException("Symbol "+_varName+" already declared");
				               }
				            
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(SC);
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tipo);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(T__2);
				 _type = IsiVariable.NUMBER;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				match(T__3);
				 _type = IsiVariable.TEXT;
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

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			            curThread = new ArrayList<AbstractCommand>();
			            stack.push(curThread);
			           
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(64);
				cmd();
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
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

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdifContext cmdif() {
			return getRuleContext(CmdifContext.class,0);
		}
		public CmdwhileContext cmdwhile() {
			return getRuleContext(CmdwhileContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmd);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
				cmdattrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				cmdif();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(73);
				cmdwhile();
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

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__4);
			setState(77);
			match(AP);
			setState(78);
			match(ID);

			                    _readID = _input.LT(-1).getText();
			                    if(!isIDDeclared(_readID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _readID  + "` NOT declared");
			                    }

			               
			setState(80);
			match(FP);
			setState(81);
			match(SC);

			                    initializeVar(_readID);
			                    IsiVariable var = symbolTable.get(_readID);
			                    CommandRead cmd = new CommandRead(_readID, var);
			                    stack.peek().add(cmd);
			               
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

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__5);
			setState(85);
			match(AP);
			setState(86);
			match(ID);

			                    _writeID = _input.LT(-1).getText();
			                    if(!isIDDeclared(_writeID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _writeID  + "` NOT declared");
			                    }
			                    if(!isVarInitialized(_writeID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _writeID  + "` NOT initialized");
			                    }
			                  
			setState(88);
			match(FP);
			setState(89);
			match(SC);

			                    CommandWrite cmd = new CommandWrite(_writeID);
			                    stack.peek().add(cmd);
			               
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

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ID);

			                    _exprID = _input.LT(-1).getText();
			                    if(!isIDDeclared(_exprID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` NOT declared");
			                    }
			               
			setState(94);
			match(ATTR);
			 _exprContent = ""; 
			setState(96);
			expr();
			setState(97);
			match(SC);

			                     initializeVar(_exprID);
			                     CommandAttribution cmd = new CommandAttribution(_exprID, _exprContent);
			                     stack.peek().add(cmd);
			               
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

	public static class CmdifContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdif(this);
		}
	}

	public final CmdifContext cmdif() throws RecognitionException {
		CmdifContext _localctx = new CmdifContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__6);
			setState(101);
			match(AP);

			                    ArrayList<AbstractCommand> trueThread = new ArrayList<AbstractCommand>();
			                    ArrayList<AbstractCommand> falseThread = new ArrayList<AbstractCommand>();
			                    ArrayList<AbstractCommand> listTrue = new ArrayList<AbstractCommand>();
			                    ArrayList<AbstractCommand> listFalse = new ArrayList<AbstractCommand>();
			               
			setState(103);
			boolExpr();
			setState(104);
			match(FP);
			 CommandIf cmd = new CommandIf(_exprDecision);
			setState(106);
			match(ACH);

			                    trueThread = new ArrayList<AbstractCommand>();
			                    stack.push(trueThread);
			               
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				cmd();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(113);
			match(FCH);


			                    listTrue = stack.pop();
			               
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(115);
				match(T__7);
				setState(116);
				match(ACH);

				                            falseThread = new ArrayList<AbstractCommand>();
				                            stack.push(falseThread);
				                   
				{
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(118);
					cmd();
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
				}
				setState(123);
				match(FCH);

				                            listFalse = stack.pop();
				                   
				}
			}


			                    cmd.setListTrue(listTrue);
			                    cmd.setListFalse(listFalse);
			                    stack.peek().add(cmd);
			               
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

	public static class CmdwhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public BoolExprContext boolExpr() {
			return getRuleContext(BoolExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdwhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdwhile(this);
		}
	}

	public final CmdwhileContext cmdwhile() throws RecognitionException {
		CmdwhileContext _localctx = new CmdwhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdwhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__8);
			setState(131);
			match(AP);

			                ArrayList<AbstractCommand> whileThread = new ArrayList<AbstractCommand>();
			                ArrayList<AbstractCommand> whileList = new ArrayList<AbstractCommand>();
			              
			setState(133);
			boolExpr();
			setState(134);
			match(FP);
			 CommandWhile cmd = new CommandWhile(_exprDecision);
			setState(136);
			match(ACH);

			                        whileThread = new ArrayList<AbstractCommand>();
			                        stack.push(whileThread);
			              
			setState(139); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(138);
				cmd();
				}
				}
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(143);
			match(FCH);

			                        whileList = stack.pop();
			                        cmd.setWhileCommands(whileList);
			                        stack.peek().add(cmd);
			              
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

	public static class BoolExprContext extends ParserRuleContext {
		public BoolExprChildContext boolExprChild() {
			return getRuleContext(BoolExprChildContext.class,0);
		}
		public BoolExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolExpr(this);
		}
	}

	public final BoolExprContext boolExpr() throws RecognitionException {
		BoolExprContext _localctx = new BoolExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_boolExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 _exprDecision = "";
			setState(147);
			boolExprChild();
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

	public static class BoolExprChildContext extends ParserRuleContext {
		public List<BoolExprChildChildContext> boolExprChildChild() {
			return getRuleContexts(BoolExprChildChildContext.class);
		}
		public BoolExprChildChildContext boolExprChildChild(int i) {
			return getRuleContext(BoolExprChildChildContext.class,i);
		}
		public List<TerminalNode> AP() { return getTokens(IsiLangParser.AP); }
		public TerminalNode AP(int i) {
			return getToken(IsiLangParser.AP, i);
		}
		public List<BoolExprChildContext> boolExprChild() {
			return getRuleContexts(BoolExprChildContext.class);
		}
		public BoolExprChildContext boolExprChild(int i) {
			return getRuleContext(BoolExprChildContext.class,i);
		}
		public List<TerminalNode> FP() { return getTokens(IsiLangParser.FP); }
		public TerminalNode FP(int i) {
			return getToken(IsiLangParser.FP, i);
		}
		public List<TerminalNode> NOT() { return getTokens(IsiLangParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(IsiLangParser.NOT, i);
		}
		public BoolExprChildContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExprChild; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolExprChild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolExprChild(this);
		}
	}

	public final BoolExprChildContext boolExprChild() throws RecognitionException {
		BoolExprChildContext _localctx = new BoolExprChildContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_boolExprChild);
		int _la;
		try {
			int _alt;
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				boolExprChildChild();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(154);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==ID || _la==NUMBER) {
							{
							setState(150);
							boolExprChildChild();
							setState(151);
							_la = _input.LA(1);
							if ( !(_la==T__9 || _la==T__10) ) {
							_errHandler.recoverInline(this);
							}
							else {
								if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
								_errHandler.reportMatch(this);
								consume();
							}
							 _exprDecision += _input.LT(-1).getText();
							}
						}

						setState(157);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==NOT) {
							{
							setState(156);
							match(NOT);
							}
						}

						 _exprDecision += _input.LT(-1).getText();
						setState(160);
						match(AP);
						 _exprDecision += _input.LT(-1).getText();
						setState(162);
						boolExprChild();
						setState(163);
						match(FP);
						 _exprDecision += _input.LT(-1).getText();
						setState(170);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(165);
								_la = _input.LA(1);
								if ( !(_la==T__9 || _la==T__10) ) {
								_errHandler.recoverInline(this);
								}
								else {
									if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
									_errHandler.reportMatch(this);
									consume();
								}
								 _exprDecision += _input.LT(-1).getText();
								setState(167);
								boolExprChild();
								}
								} 
							}
							setState(172);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
						}
						}
						} 
					}
					setState(177);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				}
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

	public static class BoolExprChildChildContext extends ParserRuleContext {
		public List<BoolTermoContext> boolTermo() {
			return getRuleContexts(BoolTermoContext.class);
		}
		public BoolTermoContext boolTermo(int i) {
			return getRuleContext(BoolTermoContext.class,i);
		}
		public List<TerminalNode> OPREL() { return getTokens(IsiLangParser.OPREL); }
		public TerminalNode OPREL(int i) {
			return getToken(IsiLangParser.OPREL, i);
		}
		public BoolExprChildChildContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExprChildChild; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolExprChildChild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolExprChildChild(this);
		}
	}

	public final BoolExprChildChildContext boolExprChildChild() throws RecognitionException {
		BoolExprChildChildContext _localctx = new BoolExprChildChildContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_boolExprChildChild);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			boolTermo();
			 _exprDecision += _input.LT(-1).getText(); 
			setState(182);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(184);
			boolTermo();
			 _exprDecision += _input.LT(-1).getText(); 
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(186);
					_la = _input.LA(1);
					if ( !(_la==T__9 || _la==T__10) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					 _exprDecision += _input.LT(-1).getText(); 
					setState(188);
					boolTermo();
					 _exprDecision += _input.LT(-1).getText(); 
					setState(190);
					match(OPREL);
					 _exprDecision += _input.LT(-1).getText(); 
					setState(192);
					boolTermo();
					 _exprDecision += _input.LT(-1).getText(); 
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class BoolTermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public BoolTermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolTermo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBoolTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBoolTermo(this);
		}
	}

	public final BoolTermoContext boolTermo() throws RecognitionException {
		BoolTermoContext _localctx = new BoolTermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_boolTermo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(200);
				match(ID);


				                    if(!isIDDeclared(_input.LT(-1).getText())){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT declared");
				                    }
				                    if(!isVarInitialized(_input.LT(-1).getText())){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT initialized");
				                    }
				                    if(!isNumber(_input.LT(-1).getText())){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Comparsion operations are expectating a 'number' type, NOT a 'text' type");
				                    }
				               
				}
				break;
			case NUMBER:
				{
				setState(202);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExprContext extends ParserRuleContext {
		public List<ExprTermoContext> exprTermo() {
			return getRuleContexts(ExprTermoContext.class);
		}
		public ExprTermoContext exprTermo(int i) {
			return getRuleContext(ExprTermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			exprTermo();
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(206);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(208);
				exprTermo();
				}
				}
				setState(213);
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

	public static class ExprTermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode STR() { return getToken(IsiLangParser.STR, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public ExprTermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprTermo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExprTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExprTermo(this);
		}
	}

	public final ExprTermoContext exprTermo() throws RecognitionException {
		ExprTermoContext _localctx = new ExprTermoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_exprTermo);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(ID);

				                    String id = _input.LT(-1).getText();
				                    if(!isIDDeclared(id)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + id  + "` NOT declared");
				                    }
				                    if(!isVarInitialized(id)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + id  + "` NOT initialized");
				                    }
				                    if(!isNumber(_exprID) && isNumber(id)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'texto' type, NOT a 'number' type");
				                    }
				                    if(isNumber(_exprID) && !isNumber(id)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, NOT a 'texto' type");
				                    }
				                    _exprContent += _input.LT(-1).getText();

				              
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(NUMBER);

				                    if(!isNumber(_exprID)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'texto' type, NOT a 'number' type");
				                    }
				                    _exprContent += _input.LT(-1).getText();
				            
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				match(STR);

				                    if(isNumber(_exprID)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, NOT a 'texto' type");
				                    }
				                    _exprContent += _input.LT(-1).getText();
				            
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				match(AP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(222);
				expr();
				setState(223);
				match(FP);
				 _exprContent += _input.LT(-1).getText(); 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00e7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7"+
		"\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4@\n\4\3\5\3\5\6\5"+
		"D\n\5\r\5\16\5E\3\6\3\6\3\6\3\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\np\n\n\r\n\16\nq\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\6\nz\n\n\r\n\16\n{\3\n\3\n\3\n\5\n\u0081\n\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u008e\n\13\r\13\16\13\u008f"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u009d\n\r\3\r\5\r"+
		"\u00a0\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ab\n\r\f\r\16\r"+
		"\u00ae\13\r\7\r\u00b0\n\r\f\r\16\r\u00b3\13\r\5\r\u00b5\n\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u00c6\n\16\f\16\16\16\u00c9\13\16\3\17\3\17\3\17\5\17\u00ce\n\17\3\20"+
		"\3\20\3\20\3\20\7\20\u00d4\n\20\f\20\16\20\u00d7\13\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e5\n\21\3\21\2\2"+
		"\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\f\r\2\u00ed\2\"\3"+
		"\2\2\2\4.\3\2\2\2\6?\3\2\2\2\bA\3\2\2\2\nL\3\2\2\2\fN\3\2\2\2\16V\3\2"+
		"\2\2\20^\3\2\2\2\22f\3\2\2\2\24\u0084\3\2\2\2\26\u0094\3\2\2\2\30\u00b4"+
		"\3\2\2\2\32\u00b6\3\2\2\2\34\u00cd\3\2\2\2\36\u00cf\3\2\2\2 \u00e4\3\2"+
		"\2\2\"&\7\3\2\2#%\5\4\3\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')"+
		"\3\2\2\2(&\3\2\2\2)*\5\b\5\2*+\7\4\2\2+,\7\25\2\2,-\b\2\1\2-\3\3\2\2\2"+
		"./\5\6\4\2/\60\7\30\2\2\60\66\b\3\1\2\61\62\7\22\2\2\62\63\7\30\2\2\63"+
		"\65\b\3\1\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679"+
		"\3\2\2\28\66\3\2\2\29:\7\25\2\2:\5\3\2\2\2;<\7\5\2\2<@\b\4\1\2=>\7\6\2"+
		"\2>@\b\4\1\2?;\3\2\2\2?=\3\2\2\2@\7\3\2\2\2AC\b\5\1\2BD\5\n\6\2CB\3\2"+
		"\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GM\5\f\7\2HM\5\16\b\2IM\5"+
		"\20\t\2JM\5\22\n\2KM\5\24\13\2LG\3\2\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2"+
		"LK\3\2\2\2M\13\3\2\2\2NO\7\7\2\2OP\7\23\2\2PQ\7\30\2\2QR\b\7\1\2RS\7\24"+
		"\2\2ST\7\25\2\2TU\b\7\1\2U\r\3\2\2\2VW\7\b\2\2WX\7\23\2\2XY\7\30\2\2Y"+
		"Z\b\b\1\2Z[\7\24\2\2[\\\7\25\2\2\\]\b\b\1\2]\17\3\2\2\2^_\7\30\2\2_`\b"+
		"\t\1\2`a\7\27\2\2ab\b\t\1\2bc\5\36\20\2cd\7\25\2\2de\b\t\1\2e\21\3\2\2"+
		"\2fg\7\t\2\2gh\7\23\2\2hi\b\n\1\2ij\5\26\f\2jk\7\24\2\2kl\b\n\1\2lm\7"+
		"\16\2\2mo\b\n\1\2np\5\n\6\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs"+
		"\3\2\2\2st\7\17\2\2t\u0080\b\n\1\2uv\7\n\2\2vw\7\16\2\2wy\b\n\1\2xz\5"+
		"\n\6\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\7\17\2\2~\177"+
		"\b\n\1\2\177\u0081\3\2\2\2\u0080u\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\b\n\1\2\u0083\23\3\2\2\2\u0084\u0085\7\13\2\2\u0085"+
		"\u0086\7\23\2\2\u0086\u0087\b\13\1\2\u0087\u0088\5\26\f\2\u0088\u0089"+
		"\7\24\2\2\u0089\u008a\b\13\1\2\u008a\u008b\7\16\2\2\u008b\u008d\b\13\1"+
		"\2\u008c\u008e\5\n\6\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\17\2\2"+
		"\u0092\u0093\b\13\1\2\u0093\25\3\2\2\2\u0094\u0095\b\f\1\2\u0095\u0096"+
		"\5\30\r\2\u0096\27\3\2\2\2\u0097\u00b5\5\32\16\2\u0098\u0099\5\32\16\2"+
		"\u0099\u009a\t\2\2\2\u009a\u009b\b\r\1\2\u009b\u009d\3\2\2\2\u009c\u0098"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u00a0\7\21\2\2"+
		"\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2"+
		"\b\r\1\2\u00a2\u00a3\7\23\2\2\u00a3\u00a4\b\r\1\2\u00a4\u00a5\5\30\r\2"+
		"\u00a5\u00a6\7\24\2\2\u00a6\u00ac\b\r\1\2\u00a7\u00a8\t\2\2\2\u00a8\u00a9"+
		"\b\r\1\2\u00a9\u00ab\5\30\r\2\u00aa\u00a7\3\2\2\2\u00ab\u00ae\3\2\2\2"+
		"\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00af\u009c\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u0097\3\2"+
		"\2\2\u00b4\u00b1\3\2\2\2\u00b5\31\3\2\2\2\u00b6\u00b7\5\34\17\2\u00b7"+
		"\u00b8\b\16\1\2\u00b8\u00b9\7\20\2\2\u00b9\u00ba\b\16\1\2\u00ba\u00bb"+
		"\5\34\17\2\u00bb\u00c7\b\16\1\2\u00bc\u00bd\t\2\2\2\u00bd\u00be\b\16\1"+
		"\2\u00be\u00bf\5\34\17\2\u00bf\u00c0\b\16\1\2\u00c0\u00c1\7\20\2\2\u00c1"+
		"\u00c2\b\16\1\2\u00c2\u00c3\5\34\17\2\u00c3\u00c4\b\16\1\2\u00c4\u00c6"+
		"\3\2\2\2\u00c5\u00bc\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\33\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cb\7\30\2"+
		"\2\u00cb\u00ce\b\17\1\2\u00cc\u00ce\7\31\2\2\u00cd\u00ca\3\2\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce\35\3\2\2\2\u00cf\u00d5\5 \21\2\u00d0\u00d1\7\26\2"+
		"\2\u00d1\u00d2\b\20\1\2\u00d2\u00d4\5 \21\2\u00d3\u00d0\3\2\2\2\u00d4"+
		"\u00d7\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\37\3\2\2"+
		"\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\7\30\2\2\u00d9\u00e5\b\21\1\2\u00da"+
		"\u00db\7\31\2\2\u00db\u00e5\b\21\1\2\u00dc\u00dd\7\32\2\2\u00dd\u00e5"+
		"\b\21\1\2\u00de\u00df\7\23\2\2\u00df\u00e0\b\21\1\2\u00e0\u00e1\5\36\20"+
		"\2\u00e1\u00e2\7\24\2\2\u00e2\u00e3\b\21\1\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00d8\3\2\2\2\u00e4\u00da\3\2\2\2\u00e4\u00dc\3\2\2\2\u00e4\u00de\3\2"+
		"\2\2\u00e5!\3\2\2\2\24&\66?ELq{\u0080\u008f\u009c\u009f\u00ac\u00b1\u00b4"+
		"\u00c7\u00cd\u00d5\u00e4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}