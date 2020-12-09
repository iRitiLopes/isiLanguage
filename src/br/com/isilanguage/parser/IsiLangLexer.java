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
		ID=19, NUMBER=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"ACH", "FCH", "OPREL", "VIR", "AP", "FP", "SC", "OP", "ATTR", "ID", "NUMBER", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'senao'", "'while'", "'{'", "'}'", null, "','", "'('", "')'", 
		"';'", null, "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "ACH", "FCH", 
		"OPREL", "VIR", "AP", "FP", "SC", "OP", "ATTR", "ID", "NUMBER", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u009a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\ru\n\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\7\24\u0085"+
		"\n\24\f\24\16\24\u0088\13\24\3\25\6\25\u008b\n\25\r\25\16\25\u008c\3\25"+
		"\3\25\6\25\u0091\n\25\r\25\16\25\u0092\5\25\u0095\n\25\3\26\3\26\3\26"+
		"\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27\3\2\b\4\2>>@@\5\2,-//\61\61"+
		"\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00a1\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\66\3\2\2\2\7>\3\2\2\2\t"+
		"E\3\2\2\2\13K\3\2\2\2\rP\3\2\2\2\17X\3\2\2\2\21[\3\2\2\2\23a\3\2\2\2\25"+
		"g\3\2\2\2\27i\3\2\2\2\31t\3\2\2\2\33v\3\2\2\2\35x\3\2\2\2\37z\3\2\2\2"+
		"!|\3\2\2\2#~\3\2\2\2%\u0080\3\2\2\2\'\u0082\3\2\2\2)\u008a\3\2\2\2+\u0096"+
		"\3\2\2\2-.\7r\2\2./\7t\2\2/\60\7q\2\2\60\61\7i\2\2\61\62\7t\2\2\62\63"+
		"\7c\2\2\63\64\7o\2\2\64\65\7c\2\2\65\4\3\2\2\2\66\67\7h\2\2\678\7k\2\2"+
		"89\7o\2\29:\7r\2\2:;\7t\2\2;<\7q\2\2<=\7i\2\2=\6\3\2\2\2>?\7p\2\2?@\7"+
		"w\2\2@A\7o\2\2AB\7g\2\2BC\7t\2\2CD\7q\2\2D\b\3\2\2\2EF\7v\2\2FG\7g\2\2"+
		"GH\7z\2\2HI\7v\2\2IJ\7q\2\2J\n\3\2\2\2KL\7n\2\2LM\7g\2\2MN\7k\2\2NO\7"+
		"c\2\2O\f\3\2\2\2PQ\7g\2\2QR\7u\2\2RS\7e\2\2ST\7t\2\2TU\7g\2\2UV\7x\2\2"+
		"VW\7c\2\2W\16\3\2\2\2XY\7u\2\2YZ\7g\2\2Z\20\3\2\2\2[\\\7u\2\2\\]\7g\2"+
		"\2]^\7p\2\2^_\7c\2\2_`\7q\2\2`\22\3\2\2\2ab\7y\2\2bc\7j\2\2cd\7k\2\2d"+
		"e\7n\2\2ef\7g\2\2f\24\3\2\2\2gh\7}\2\2h\26\3\2\2\2ij\7\177\2\2j\30\3\2"+
		"\2\2ku\t\2\2\2lm\7@\2\2mu\7?\2\2no\7>\2\2ou\7?\2\2pq\7?\2\2qu\7?\2\2r"+
		"s\7#\2\2su\7?\2\2tk\3\2\2\2tl\3\2\2\2tn\3\2\2\2tp\3\2\2\2tr\3\2\2\2u\32"+
		"\3\2\2\2vw\7.\2\2w\34\3\2\2\2xy\7*\2\2y\36\3\2\2\2z{\7+\2\2{ \3\2\2\2"+
		"|}\7=\2\2}\"\3\2\2\2~\177\t\3\2\2\177$\3\2\2\2\u0080\u0081\7?\2\2\u0081"+
		"&\3\2\2\2\u0082\u0086\t\4\2\2\u0083\u0085\t\5\2\2\u0084\u0083\3\2\2\2"+
		"\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087(\3"+
		"\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\t\6\2\2\u008a\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u0094\3\2"+
		"\2\2\u008e\u0090\7\60\2\2\u008f\u0091\t\6\2\2\u0090\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2"+
		"\2\2\u0094\u008e\3\2\2\2\u0094\u0095\3\2\2\2\u0095*\3\2\2\2\u0096\u0097"+
		"\t\7\2\2\u0097\u0098\3\2\2\2\u0098\u0099\b\26\2\2\u0099,\3\2\2\2\t\2t"+
		"\u0084\u0086\u008c\u0092\u0094\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}