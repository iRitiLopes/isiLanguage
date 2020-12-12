package br.com.isilanguage.main;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.com.isilanguage.parser.IsiLangLexer;
import br.com.isilanguage.parser.IsiLangParser;
import org.antlr.v4.runtime.Parser;
import br.com.isilanguage.listeners.DescriptiveErrorListener;

/* esta é a classe que é responsável por criar a interação com o usuário
 * instanciando nosso parser e apontando para o arquivo fonte
 * 
 * Arquivo fonte: extensao .isi
 * 
 */
public class Main {
	public static void main(String[] args) {

		try {
            IsiLangLexer lexer;

            IsiLangParser parser;
			// leio o arquivo "input.isi" e isso é entrada para o Analisador Lexico
			lexer = new IsiLangLexer(CharStreams.fromFileName("input.isi"));
			lexer.removeErrorListeners();
			lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);

			// crio um "fluxo de tokens" para passar para o PARSER
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);

			// crio meu parser a partir desse tokenStream
			parser = new IsiLangParser(tokenStream);
			parser.removeErrorListeners();
			parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
			parser.prog();
			//parser.showCommands();
			parser.generateJavaCode();

			System.out.println("Compilation Successful");
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.err.println("ERROR "+ex.getMessage());
            //System.err.println("At line:col " + parser.getCurrentToken().getLine() + ":" + parser.getCurrentToken().getCharPositionInLine());
		}
		
	}

}
