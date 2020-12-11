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
		T__9=10, T__10=11, ACH=12, FCH=13, OPREL=14, VIR=15, AP=16, FP=17, SC=18, 
		OP=19, ATTR=20, ID=21, NUMBER=22, STR=23, WS=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "ACH", "FCH", "OPREL", "VIR", "AP", "FP", "SC", "OP", 
		"ATTR", "ID", "NUMBER", "STR", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\32\u00b4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0084"+
		"\n\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\7\26\u0094\n\26\f\26\16\26\u0097\13\26\3\27\6\27\u009a\n\27\r\27"+
		"\16\27\u009b\3\27\3\27\6\27\u00a0\n\27\r\27\16\27\u00a1\5\27\u00a4\n\27"+
		"\3\30\3\30\3\30\3\30\7\30\u00aa\n\30\f\30\16\30\u00ad\13\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\u00ab\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\3\2\b\4\2>>@@\5\2,-//\61\61\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f"+
		"\17\17\"\"\2\u00bd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\3\63\3\2\2\2\5<\3\2\2\2\7D\3\2\2\2\tK\3"+
		"\2\2\2\13Q\3\2\2\2\rV\3\2\2\2\17^\3\2\2\2\21a\3\2\2\2\23g\3\2\2\2\25p"+
		"\3\2\2\2\27s\3\2\2\2\31v\3\2\2\2\33x\3\2\2\2\35\u0083\3\2\2\2\37\u0085"+
		"\3\2\2\2!\u0087\3\2\2\2#\u0089\3\2\2\2%\u008b\3\2\2\2\'\u008d\3\2\2\2"+
		")\u008f\3\2\2\2+\u0091\3\2\2\2-\u0099\3\2\2\2/\u00a5\3\2\2\2\61\u00b0"+
		"\3\2\2\2\63\64\7r\2\2\64\65\7t\2\2\65\66\7q\2\2\66\67\7i\2\2\678\7t\2"+
		"\289\7c\2\29:\7o\2\2:;\7c\2\2;\4\3\2\2\2<=\7h\2\2=>\7k\2\2>?\7o\2\2?@"+
		"\7r\2\2@A\7t\2\2AB\7q\2\2BC\7i\2\2C\6\3\2\2\2DE\7p\2\2EF\7w\2\2FG\7o\2"+
		"\2GH\7g\2\2HI\7t\2\2IJ\7q\2\2J\b\3\2\2\2KL\7v\2\2LM\7g\2\2MN\7z\2\2NO"+
		"\7v\2\2OP\7q\2\2P\n\3\2\2\2QR\7n\2\2RS\7g\2\2ST\7k\2\2TU\7c\2\2U\f\3\2"+
		"\2\2VW\7g\2\2WX\7u\2\2XY\7e\2\2YZ\7t\2\2Z[\7g\2\2[\\\7x\2\2\\]\7c\2\2"+
		"]\16\3\2\2\2^_\7u\2\2_`\7g\2\2`\20\3\2\2\2ab\7u\2\2bc\7g\2\2cd\7p\2\2"+
		"de\7c\2\2ef\7q\2\2f\22\3\2\2\2gh\7g\2\2hi\7p\2\2ij\7s\2\2jk\7w\2\2kl\7"+
		"c\2\2lm\7p\2\2mn\7v\2\2no\7q\2\2o\24\3\2\2\2pq\7(\2\2qr\7(\2\2r\26\3\2"+
		"\2\2st\7~\2\2tu\7~\2\2u\30\3\2\2\2vw\7}\2\2w\32\3\2\2\2xy\7\177\2\2y\34"+
		"\3\2\2\2z\u0084\t\2\2\2{|\7@\2\2|\u0084\7?\2\2}~\7>\2\2~\u0084\7?\2\2"+
		"\177\u0080\7?\2\2\u0080\u0084\7?\2\2\u0081\u0082\7#\2\2\u0082\u0084\7"+
		"?\2\2\u0083z\3\2\2\2\u0083{\3\2\2\2\u0083}\3\2\2\2\u0083\177\3\2\2\2\u0083"+
		"\u0081\3\2\2\2\u0084\36\3\2\2\2\u0085\u0086\7.\2\2\u0086 \3\2\2\2\u0087"+
		"\u0088\7*\2\2\u0088\"\3\2\2\2\u0089\u008a\7+\2\2\u008a$\3\2\2\2\u008b"+
		"\u008c\7=\2\2\u008c&\3\2\2\2\u008d\u008e\t\3\2\2\u008e(\3\2\2\2\u008f"+
		"\u0090\7?\2\2\u0090*\3\2\2\2\u0091\u0095\t\4\2\2\u0092\u0094\t\5\2\2\u0093"+
		"\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096,\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\t\6\2\2\u0099\u0098"+
		"\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u00a3\3\2\2\2\u009d\u009f\7\60\2\2\u009e\u00a0\t\6\2\2\u009f\u009e\3"+
		"\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a4\3\2\2\2\u00a3\u009d\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4.\3\2\2\2"+
		"\u00a5\u00ab\7$\2\2\u00a6\u00a7\7^\2\2\u00a7\u00aa\7$\2\2\u00a8\u00aa"+
		"\13\2\2\2\u00a9\u00a6\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2"+
		"\u00ab\u00ac\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab"+
		"\3\2\2\2\u00ae\u00af\7$\2\2\u00af\60\3\2\2\2\u00b0\u00b1\t\7\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\b\31\2\2\u00b3\62\3\2\2\2\13\2\u0083\u0093"+
		"\u0095\u009b\u00a1\u00a3\u00a9\u00ab\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}