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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(IsiLangParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(IsiLangParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void enterCmdif(IsiLangParser.CmdifContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void exitCmdif(IsiLangParser.CmdifContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdwhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdwhile(IsiLangParser.CmdwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdwhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdwhile(IsiLangParser.CmdwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(IsiLangParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#boolExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(IsiLangParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#boolTermo}.
	 * @param ctx the parse tree
	 */
	void enterBoolTermo(IsiLangParser.BoolTermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#boolTermo}.
	 * @param ctx the parse tree
	 */
	void exitBoolTermo(IsiLangParser.BoolTermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#exprTermo}.
	 * @param ctx the parse tree
	 */
	void enterExprTermo(IsiLangParser.ExprTermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#exprTermo}.
	 * @param ctx the parse tree
	 */
	void exitExprTermo(IsiLangParser.ExprTermoContext ctx);
}