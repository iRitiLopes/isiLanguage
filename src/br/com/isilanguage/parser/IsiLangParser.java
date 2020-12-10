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
		ACH=10, FCH=11, OPREL=12, VIR=13, AP=14, FP=15, SC=16, OP=17, ATTR=18, 
		ID=19, NUMBER=20, STR=21, QUOTE=22, WS=23;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_tipo = 2, RULE_bloco = 3, RULE_cmd = 4, 
		RULE_cmdleitura = 5, RULE_cmdescrita = 6, RULE_cmdattrib = 7, RULE_cmdif = 8, 
		RULE_cmdwhile = 9, RULE_expr = 10, RULE_termo = 11;
	public static final String[] ruleNames = {
		"prog", "decl", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", "cmdattrib", 
		"cmdif", "cmdwhile", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'senao'", "'while'", "'{'", "'}'", null, "','", "'('", "')'", 
		"';'", null, "'='", null, null, null, "'\"'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "ACH", "FCH", 
		"OPREL", "VIR", "AP", "FP", "SC", "OP", "ATTR", "ID", "NUMBER", "STR", 
		"QUOTE", "WS"
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
	    private String _readID;
	    private String _writeID;
	    private String _exprContent;
	    private String _exprID;

	    private IsiProgram program = new IsiProgram();
	    private ArrayList<AbstractCommand> curThread;
	    private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();

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
			setState(24);
			match(T__0);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2 || _la==T__3) {
				{
				{
				setState(25);
				decl();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
			bloco();
			setState(32);
			match(T__1);
			setState(33);
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
			setState(36);
			tipo();
			setState(37);
			match(ID);

			                _varName = _input.LT(-1).getText();
			                _varValue = null;
			                variable = new IsiVariable(_varName, _type, _varValue);
			                if(!isIDDeclared(_varName)){
			                    symbolTable.add(variable);
			                }
			             
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(39);
				match(VIR);
				setState(40);
				match(ID);

				               _varName = _input.LT(-1).getText();
				               _varValue = null;
				               variable = new IsiVariable(_varName, _type, _varValue);
				               if(!isIDDeclared(_varName)){
				                   symbolTable.add(variable);
				               }
				            
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
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
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(T__2);
				 _type = IsiVariable.NUMBER;
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
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
			           
			setState(57); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(56);
				cmd();
				}
				}
				setState(59); 
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
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				cmdattrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				cmdif();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(65);
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
			setState(68);
			match(T__4);
			setState(69);
			match(AP);
			setState(70);
			match(ID);

			                    _readID = _input.LT(-1).getText();
			                    if(!isIDDeclared(_readID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _readID  + "` NOT declared");
			                    }

			               
			setState(72);
			match(FP);
			setState(73);
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
			setState(76);
			match(T__5);
			setState(77);
			match(AP);
			setState(78);
			match(ID);

			                    _writeID = _input.LT(-1).getText();
			                    if(!isIDDeclared(_writeID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _writeID  + "` NOT declared");
			                    }
			                    if(!isVarInitialized(_writeID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _writeID  + "` not initialized");
			                    }
			                  
			setState(80);
			match(FP);
			setState(81);
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
			setState(83);
			match(ID);

			                    _exprID = _input.LT(-1).getText();
			                    if(!isIDDeclared(_exprID)){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` NOT declared");
			                    }
			               
			setState(85);
			match(ATTR);
			 _exprContent = ""; 
			setState(87);
			expr();
			setState(88);
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
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
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
			setState(91);
			match(T__6);
			setState(92);
			match(AP);
			setState(93);
			match(ID);

			                    if(!isIDDeclared(_input.LT(-1).getText())){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT declared");
			                    }
			                    if(!isVarInitialized(_input.LT(-1).getText())){
			                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` not initialized");
			                    }
			               
			setState(95);
			match(OPREL);
			  
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(97);
				match(ID);

				                        if(!isIDDeclared(_input.LT(-1).getText())){
				                            throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT declared");
				                        }
				                        if(!isVarInitialized(_input.LT(-1).getText())){
				                            throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` not initialized");
				                        }
				                   
				}
				break;
			case NUMBER:
				{
				setState(99);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 
			setState(103);
			match(FP);
			setState(104);
			match(ACH);
			 
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				cmd();
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(111);
			match(FCH);
			 
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(113);
				match(T__7);
				setState(114);
				match(ACH);
				 
				{
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(116);
					cmd();
					}
					}
					setState(119); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
				}
				setState(121);
				match(FCH);
				 
				}
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

	public static class CmdwhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
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
			setState(126);
			match(T__8);
			setState(127);
			match(AP);
			setState(128);
			termo();
			setState(129);
			match(OPREL);
			setState(130);
			termo();
			setState(131);
			match(FP);
			setState(132);
			match(ACH);
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				cmd();
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << ID))) != 0) );
			setState(138);
			match(FCH);
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
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
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
		enterRule(_localctx, 20, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			termo();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(141);
				match(OP);
				 _exprContent += _input.LT(-1).getText(); 
				setState(143);
				termo();
				}
				}
				setState(148);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode STR() { return getToken(IsiLangParser.STR, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(ID);

				                    String id = _input.LT(-1).getText();
				                    if(!isIDDeclared(id)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + id  + "` NOT declared");
				                    }
				                    if(!isVarInitialized(id)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + id  + "` not initialized");
				                    }
				                    if(!isNumber(_exprID) && isNumber(id)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'texto' type, not a 'number' type");
				                    }
				                    if(isNumber(_exprID) && !isNumber(id)){
				                        System.out.println(_exprID + id + "meajuda");
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, not a 'texto' type");
				                    }
				                    _exprContent += _input.LT(-1).getText();

				              
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(NUMBER);

				                    if(!isNumber(_exprID)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'texto' type, not a 'number' type");
				                    }
				                    _exprContent += _input.LT(-1).getText();
				            
				}
				break;
			case STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				match(STR);

				                    if(isNumber(_exprID)){
				                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, not a 'texto' type");
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00a0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\5\48\n\4\3\5\3\5\6\5<\n\5\r\5\16\5=\3\6\3\6\3\6\3\6\3\6\5\6"+
		"E\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\ng"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\6\nn\n\n\r\n\16\no\3\n\3\n\3\n\3\n\3\n\3\n\6"+
		"\nx\n\n\r\n\16\ny\3\n\3\n\3\n\5\n\177\n\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\6\13\u0089\n\13\r\13\16\13\u008a\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\7\f\u0093\n\f\f\f\16\f\u0096\13\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009e\n"+
		"\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u00a3\2\32\3\2\2\2\4"+
		"&\3\2\2\2\6\67\3\2\2\2\b9\3\2\2\2\nD\3\2\2\2\fF\3\2\2\2\16N\3\2\2\2\20"+
		"U\3\2\2\2\22]\3\2\2\2\24\u0080\3\2\2\2\26\u008e\3\2\2\2\30\u009d\3\2\2"+
		"\2\32\36\7\3\2\2\33\35\5\4\3\2\34\33\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2"+
		"\36\37\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!\"\5\b\5\2\"#\7\4\2\2#$\7\22\2"+
		"\2$%\b\2\1\2%\3\3\2\2\2&\'\5\6\4\2\'(\7\25\2\2(.\b\3\1\2)*\7\17\2\2*+"+
		"\7\25\2\2+-\b\3\1\2,)\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\61\3\2"+
		"\2\2\60.\3\2\2\2\61\62\7\22\2\2\62\5\3\2\2\2\63\64\7\5\2\2\648\b\4\1\2"+
		"\65\66\7\6\2\2\668\b\4\1\2\67\63\3\2\2\2\67\65\3\2\2\28\7\3\2\2\29;\b"+
		"\5\1\2:<\5\n\6\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\t\3\2\2\2?E"+
		"\5\f\7\2@E\5\16\b\2AE\5\20\t\2BE\5\22\n\2CE\5\24\13\2D?\3\2\2\2D@\3\2"+
		"\2\2DA\3\2\2\2DB\3\2\2\2DC\3\2\2\2E\13\3\2\2\2FG\7\7\2\2GH\7\20\2\2HI"+
		"\7\25\2\2IJ\b\7\1\2JK\7\21\2\2KL\7\22\2\2LM\b\7\1\2M\r\3\2\2\2NO\7\b\2"+
		"\2OP\7\20\2\2PQ\7\25\2\2QR\b\b\1\2RS\7\21\2\2ST\7\22\2\2T\17\3\2\2\2U"+
		"V\7\25\2\2VW\b\t\1\2WX\7\24\2\2XY\b\t\1\2YZ\5\26\f\2Z[\7\22\2\2[\\\b\t"+
		"\1\2\\\21\3\2\2\2]^\7\t\2\2^_\7\20\2\2_`\7\25\2\2`a\b\n\1\2ab\7\16\2\2"+
		"bf\b\n\1\2cd\7\25\2\2dg\b\n\1\2eg\7\26\2\2fc\3\2\2\2fe\3\2\2\2gh\3\2\2"+
		"\2hi\b\n\1\2ij\7\21\2\2jk\7\f\2\2km\b\n\1\2ln\5\n\6\2ml\3\2\2\2no\3\2"+
		"\2\2om\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\7\r\2\2r~\b\n\1\2st\7\n\2\2tu\7\f"+
		"\2\2uw\b\n\1\2vx\5\n\6\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2"+
		"\2\2{|\7\r\2\2|}\b\n\1\2}\177\3\2\2\2~s\3\2\2\2~\177\3\2\2\2\177\23\3"+
		"\2\2\2\u0080\u0081\7\13\2\2\u0081\u0082\7\20\2\2\u0082\u0083\5\30\r\2"+
		"\u0083\u0084\7\16\2\2\u0084\u0085\5\30\r\2\u0085\u0086\7\21\2\2\u0086"+
		"\u0088\7\f\2\2\u0087\u0089\5\n\6\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\7\r\2\2\u008d\25\3\2\2\2\u008e\u0094\5\30\r\2\u008f\u0090\7\23"+
		"\2\2\u0090\u0091\b\f\1\2\u0091\u0093\5\30\r\2\u0092\u008f\3\2\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\27\3\2\2"+
		"\2\u0096\u0094\3\2\2\2\u0097\u0098\7\25\2\2\u0098\u009e\b\r\1\2\u0099"+
		"\u009a\7\26\2\2\u009a\u009e\b\r\1\2\u009b\u009c\7\27\2\2\u009c\u009e\b"+
		"\r\1\2\u009d\u0097\3\2\2\2\u009d\u0099\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\31\3\2\2\2\16\36.\67=Dfoy~\u008a\u0094\u009d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}