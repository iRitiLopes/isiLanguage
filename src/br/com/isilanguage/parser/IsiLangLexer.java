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

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		ACH=10, FCH=11, OPREL=12, VIR=13, AP=14, FP=15, SC=16, OP=17, ATTR=18, 
		ID=19, NUMBER=20, STR=21, QUOTE=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"ACH", "FCH", "OPREL", "VIR", "AP", "FP", "SC", "OP", "ATTR", "ID", "NUMBER", 
		"STR", "QUOTE", "WS"
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



	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00a9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\5\ry\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\7\24\u0089\n\24\f\24\16\24\u008c\13\24\3\25\6\25\u008f\n\25"+
		"\r\25\16\25\u0090\3\25\3\25\6\25\u0095\n\25\r\25\16\25\u0096\5\25\u0099"+
		"\n\25\3\26\3\26\7\26\u009d\n\26\f\26\16\26\u00a0\13\26\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\3\2\b\4\2>>@@\5\2,-//\61\61\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17"+
		"\"\"\2\u00b1\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\3\61\3\2\2\2\5:\3\2\2\2\7B\3\2\2\2\tI\3\2\2\2\13O\3\2\2"+
		"\2\rT\3\2\2\2\17\\\3\2\2\2\21_\3\2\2\2\23e\3\2\2\2\25k\3\2\2\2\27m\3\2"+
		"\2\2\31x\3\2\2\2\33z\3\2\2\2\35|\3\2\2\2\37~\3\2\2\2!\u0080\3\2\2\2#\u0082"+
		"\3\2\2\2%\u0084\3\2\2\2\'\u0086\3\2\2\2)\u008e\3\2\2\2+\u009a\3\2\2\2"+
		"-\u00a3\3\2\2\2/\u00a5\3\2\2\2\61\62\7r\2\2\62\63\7t\2\2\63\64\7q\2\2"+
		"\64\65\7i\2\2\65\66\7t\2\2\66\67\7c\2\2\678\7o\2\289\7c\2\29\4\3\2\2\2"+
		":;\7h\2\2;<\7k\2\2<=\7o\2\2=>\7r\2\2>?\7t\2\2?@\7q\2\2@A\7i\2\2A\6\3\2"+
		"\2\2BC\7p\2\2CD\7w\2\2DE\7o\2\2EF\7g\2\2FG\7t\2\2GH\7q\2\2H\b\3\2\2\2"+
		"IJ\7v\2\2JK\7g\2\2KL\7z\2\2LM\7v\2\2MN\7q\2\2N\n\3\2\2\2OP\7n\2\2PQ\7"+
		"g\2\2QR\7k\2\2RS\7c\2\2S\f\3\2\2\2TU\7g\2\2UV\7u\2\2VW\7e\2\2WX\7t\2\2"+
		"XY\7g\2\2YZ\7x\2\2Z[\7c\2\2[\16\3\2\2\2\\]\7u\2\2]^\7g\2\2^\20\3\2\2\2"+
		"_`\7u\2\2`a\7g\2\2ab\7p\2\2bc\7c\2\2cd\7q\2\2d\22\3\2\2\2ef\7y\2\2fg\7"+
		"j\2\2gh\7k\2\2hi\7n\2\2ij\7g\2\2j\24\3\2\2\2kl\7}\2\2l\26\3\2\2\2mn\7"+
		"\177\2\2n\30\3\2\2\2oy\t\2\2\2pq\7@\2\2qy\7?\2\2rs\7>\2\2sy\7?\2\2tu\7"+
		"?\2\2uy\7?\2\2vw\7#\2\2wy\7?\2\2xo\3\2\2\2xp\3\2\2\2xr\3\2\2\2xt\3\2\2"+
		"\2xv\3\2\2\2y\32\3\2\2\2z{\7.\2\2{\34\3\2\2\2|}\7*\2\2}\36\3\2\2\2~\177"+
		"\7+\2\2\177 \3\2\2\2\u0080\u0081\7=\2\2\u0081\"\3\2\2\2\u0082\u0083\t"+
		"\3\2\2\u0083$\3\2\2\2\u0084\u0085\7?\2\2\u0085&\3\2\2\2\u0086\u008a\t"+
		"\4\2\2\u0087\u0089\t\5\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b(\3\2\2\2\u008c\u008a\3\2\2\2"+
		"\u008d\u008f\t\6\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u008e"+
		"\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0098\3\2\2\2\u0092\u0094\7\60\2\2"+
		"\u0093\u0095\t\6\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094"+
		"\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0092\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099*\3\2\2\2\u009a\u009e\5-\27\2\u009b\u009d\t\5\2\2"+
		"\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\5-\27\2\u00a2"+
		",\3\2\2\2\u00a3\u00a4\7$\2\2\u00a4.\3\2\2\2\u00a5\u00a6\t\7\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\b\30\2\2\u00a8\60\3\2\2\2\13\2x\u0088\u008a"+
		"\u0090\u0096\u0098\u009c\u009e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}