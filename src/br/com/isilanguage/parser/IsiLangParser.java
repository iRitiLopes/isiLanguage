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
		T__9=10, T__10=11, ACH=12, FCH=13, OPREL=14, VIR=15, AP=16, FP=17, SC=18, 
		OP=19, ATTR=20, ID=21, NUMBER=22, STR=23, WS=24;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_tipo = 2, RULE_bloco = 3, RULE_cmd = 4, 
		RULE_cmdleitura = 5, RULE_cmdescrita = 6, RULE_cmdattrib = 7, RULE_cmdif = 8, 
		RULE_cmdwhile = 9, RULE_boolExpr = 10, RULE_boolTermo = 11, RULE_expr = 12, 
		RULE_exprTermo = 13;
	public static final String[] ruleNames = {
		"prog", "decl", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", "cmdattrib", 
		"cmdif", "cmdwhile", "boolExpr", "boolTermo", "expr", "exprTermo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'senao'", "'enquanto'", "'&&'", "'||'", "'{'", "'}'", null, "','", 
		"'('", "')'", "';'", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ACH", "FCH", "OPREL", "VIR", "AP", "FP", "SC", "OP", "ATTR", "ID", "NUMBER", 
		"STR", "WS"
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
			setState(28);
			match(T__0);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				{
				setState(29);
				decl();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			bloco();
			setState(36);
			match(T__1);
			setState(37);
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
			setState(40);
			tipo();
			setState(41);
			match(ID);

			                _varName = _input.LT(-1).getText();
			                _varValue = null;
			                variable = new IsiVariable(_varName, _type, _varValue);
			                if(!isIDDeclared(_varName)){
			                    symbolTable.add(variable);
			                }else{
			                    throw new IsiSemanticException("Symbol "+_varName+" already declared");
			                }
			             
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(43);
				match(VIR);
				setState(44);
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
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
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
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(T__2);
				 _type = IsiVariable.NUMBER;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
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
			           
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				cmd();
				}
				}
				setState(63); 
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
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				cmdattrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				cmdif();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(69);
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
			setState(72);
			match(T__4);
			setState(73);
			match(AP);
			setState(74);
			match(ID);

			                    _readID = _input.LT(-1).getText();
			                    if(!isIDDeclared(_readID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _readID  + "` NOT declared");
			                    }

			               
			setState(76);
			match(FP);
			setState(77);
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
			setState(80);
			match(T__5);
			setState(81);
			match(AP);
			setState(82);
			match(ID);

			                    _writeID = _input.LT(-1).getText();
			                    if(!isIDDeclared(_writeID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _writeID  + "` NOT declared");
			                    }
			                    if(!isVarInitialized(_writeID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _writeID  + "` NOT initialized");
			                    }
			                  
			setState(84);
			match(FP);
			setState(85);
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
			setState(88);
			match(ID);

			                    _exprID = _input.LT(-1).getText();
			                    if(!isIDDeclared(_exprID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` NOT declared");
			                    }
			               
			setState(90);
			match(ATTR);
			 _exprContent = ""; 
			setState(92);
			expr();
			setState(93);
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
			setState(96);
			match(T__6);
			setState(97);
			match(AP);

			                    ArrayList<AbstractCommand> trueThread = new ArrayList<AbstractCommand>();
			                    ArrayList<AbstractCommand> falseThread = new ArrayList<AbstractCommand>();
			                    ArrayList<AbstractCommand> listTrue = new ArrayList<AbstractCommand>();
			                    ArrayList<AbstractCommand> listFalse = new ArrayList<AbstractCommand>();
			               
			setState(99);
			boolExpr();
			setState(100);
			match(FP);
			setState(101);
			match(ACH);

			                    trueThread = new ArrayList<AbstractCommand>();
			                    stack.push(trueThread);
			               
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				cmd();
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(108);
			match(FCH);


			                    listTrue = stack.pop();
			               
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(110);
				match(T__7);
				setState(111);
				match(ACH);

				                            falseThread = new ArrayList<AbstractCommand>();
				                            stack.push(falseThread);
				                   
				{
				setState(114); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(113);
					cmd();
					}
					}
					setState(116); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
				}
				setState(118);
				match(FCH);

				                            listFalse = stack.pop();
				                   
				}
			}


			                    CommandIf cmd = new CommandIf(_exprDecision, listTrue, listFalse);
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
			setState(125);
			match(T__8);
			setState(126);
			match(AP);

			                ArrayList<AbstractCommand> whileThread = new ArrayList<AbstractCommand>();
			                ArrayList<AbstractCommand> whileList = new ArrayList<AbstractCommand>();
			              
			setState(128);
			boolExpr();
			setState(129);
			match(FP);
			setState(130);
			match(ACH);

			                        whileThread = new ArrayList<AbstractCommand>();
			                        stack.push(whileThread);
			              
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				cmd();
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(137);
			match(FCH);

			                        whileList = stack.pop();
			                        CommandWhile cmd = new CommandWhile(_exprDecision, whileList);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			boolTermo();
			 _exprDecision = _input.LT(-1).getText(); 
			setState(142);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(144);
			boolTermo();
			 _exprDecision += _input.LT(-1).getText(); 
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9 || _la==T__10) {
				{
				{
				setState(146);
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
				setState(148);
				boolTermo();
				 _exprDecision += _input.LT(-1).getText(); 
				setState(150);
				match(OPREL);
				 _exprDecision += _input.LT(-1).getText(); 
				setState(152);
				boolTermo();
				 _exprDecision += _input.LT(-1).getText(); 
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
		enterRule(_localctx, 22, RULE_boolTermo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(160);
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
				setState(162);
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
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			exprTermo();
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(166);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(168);
				exprTermo();
				}
				}
				setState(173);
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
		enterRule(_localctx, 26, RULE_exprTermo);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
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
				setState(176);
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
				setState(178);
				match(STR);

				                    if(isNumber(_exprID)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, NOT a 'texto' type");
				                    }
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u00b9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\7\2!\n\2\f\2\16\2$\13"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3\61\n\3\f\3\16\3\64"+
		"\13\3\3\3\3\3\3\4\3\4\3\4\3\4\5\4<\n\4\3\5\3\5\6\5@\n\5\r\5\16\5A\3\6"+
		"\3\6\3\6\3\6\3\6\5\6I\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\6\nk\n\n\r\n\16\nl\3\n\3\n\3\n\3\n\3\n\3\n\6\nu\n\n\r\n"+
		"\16\nv\3\n\3\n\3\n\5\n|\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\6\13\u0088\n\13\r\13\16\13\u0089\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u009e\n\f\f\f\16\f\u00a1"+
		"\13\f\3\r\3\r\3\r\5\r\u00a6\n\r\3\16\3\16\3\16\3\16\7\16\u00ac\n\16\f"+
		"\16\16\16\u00af\13\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b7\n\17\3"+
		"\17\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\3\3\2\f\r\2\u00bb\2\36"+
		"\3\2\2\2\4*\3\2\2\2\6;\3\2\2\2\b=\3\2\2\2\nH\3\2\2\2\fJ\3\2\2\2\16R\3"+
		"\2\2\2\20Z\3\2\2\2\22b\3\2\2\2\24\177\3\2\2\2\26\u008e\3\2\2\2\30\u00a5"+
		"\3\2\2\2\32\u00a7\3\2\2\2\34\u00b6\3\2\2\2\36\"\7\3\2\2\37!\5\4\3\2 \37"+
		"\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\5\b\5"+
		"\2&\'\7\4\2\2\'(\7\24\2\2()\b\2\1\2)\3\3\2\2\2*+\5\6\4\2+,\7\27\2\2,\62"+
		"\b\3\1\2-.\7\21\2\2./\7\27\2\2/\61\b\3\1\2\60-\3\2\2\2\61\64\3\2\2\2\62"+
		"\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62\3\2\2\2\65\66\7\24\2\2\66"+
		"\5\3\2\2\2\678\7\5\2\28<\b\4\1\29:\7\6\2\2:<\b\4\1\2;\67\3\2\2\2;9\3\2"+
		"\2\2<\7\3\2\2\2=?\b\5\1\2>@\5\n\6\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3"+
		"\2\2\2B\t\3\2\2\2CI\5\f\7\2DI\5\16\b\2EI\5\20\t\2FI\5\22\n\2GI\5\24\13"+
		"\2HC\3\2\2\2HD\3\2\2\2HE\3\2\2\2HF\3\2\2\2HG\3\2\2\2I\13\3\2\2\2JK\7\7"+
		"\2\2KL\7\22\2\2LM\7\27\2\2MN\b\7\1\2NO\7\23\2\2OP\7\24\2\2PQ\b\7\1\2Q"+
		"\r\3\2\2\2RS\7\b\2\2ST\7\22\2\2TU\7\27\2\2UV\b\b\1\2VW\7\23\2\2WX\7\24"+
		"\2\2XY\b\b\1\2Y\17\3\2\2\2Z[\7\27\2\2[\\\b\t\1\2\\]\7\26\2\2]^\b\t\1\2"+
		"^_\5\32\16\2_`\7\24\2\2`a\b\t\1\2a\21\3\2\2\2bc\7\t\2\2cd\7\22\2\2de\b"+
		"\n\1\2ef\5\26\f\2fg\7\23\2\2gh\7\16\2\2hj\b\n\1\2ik\5\n\6\2ji\3\2\2\2"+
		"kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mn\3\2\2\2no\7\17\2\2o{\b\n\1\2pq\7\n\2"+
		"\2qr\7\16\2\2rt\b\n\1\2su\5\n\6\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2"+
		"\2\2wx\3\2\2\2xy\7\17\2\2yz\b\n\1\2z|\3\2\2\2{p\3\2\2\2{|\3\2\2\2|}\3"+
		"\2\2\2}~\b\n\1\2~\23\3\2\2\2\177\u0080\7\13\2\2\u0080\u0081\7\22\2\2\u0081"+
		"\u0082\b\13\1\2\u0082\u0083\5\26\f\2\u0083\u0084\7\23\2\2\u0084\u0085"+
		"\7\16\2\2\u0085\u0087\b\13\1\2\u0086\u0088\5\n\6\2\u0087\u0086\3\2\2\2"+
		"\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\u008c\7\17\2\2\u008c\u008d\b\13\1\2\u008d\25\3\2\2\2\u008e"+
		"\u008f\5\30\r\2\u008f\u0090\b\f\1\2\u0090\u0091\7\20\2\2\u0091\u0092\b"+
		"\f\1\2\u0092\u0093\5\30\r\2\u0093\u009f\b\f\1\2\u0094\u0095\t\2\2\2\u0095"+
		"\u0096\b\f\1\2\u0096\u0097\5\30\r\2\u0097\u0098\b\f\1\2\u0098\u0099\7"+
		"\20\2\2\u0099\u009a\b\f\1\2\u009a\u009b\5\30\r\2\u009b\u009c\b\f\1\2\u009c"+
		"\u009e\3\2\2\2\u009d\u0094\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\27\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a3"+
		"\7\27\2\2\u00a3\u00a6\b\r\1\2\u00a4\u00a6\7\30\2\2\u00a5\u00a2\3\2\2\2"+
		"\u00a5\u00a4\3\2\2\2\u00a6\31\3\2\2\2\u00a7\u00ad\5\34\17\2\u00a8\u00a9"+
		"\7\25\2\2\u00a9\u00aa\b\16\1\2\u00aa\u00ac\5\34\17\2\u00ab\u00a8\3\2\2"+
		"\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\33"+
		"\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7\27\2\2\u00b1\u00b7\b\17\1\2"+
		"\u00b2\u00b3\7\30\2\2\u00b3\u00b7\b\17\1\2\u00b4\u00b5\7\31\2\2\u00b5"+
		"\u00b7\b\17\1\2\u00b6\u00b0\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b6\u00b4\3"+
		"\2\2\2\u00b7\35\3\2\2\2\17\"\62;AHlv{\u0089\u009f\u00a5\u00ad\u00b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}