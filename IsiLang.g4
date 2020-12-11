grammar IsiLang;

@header{
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
}
@members {
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

}

prog	: 'programa'  decl* bloco  'fimprog' SC
          {
              program.setVarTable(symbolTable);
              program.setCommands(stack.pop());
          }
		;

decl    : tipo
          ID {
                _varName = _input.LT(-1).getText();
                _varValue = null;
                variable = new IsiVariable(_varName, _type, _varValue);
                if(!isIDDeclared(_varName)){
                    symbolTable.add(variable);
                }else{
                    throw new IsiSemanticException("Symbol "+_varName+" already declared");
                }
             }
          (
            VIR
            ID {
               _varName = _input.LT(-1).getText();
               _varValue = null;
               variable = new IsiVariable(_varName, _type, _varValue);
               if(!isIDDeclared(_varName)){
                   symbolTable.add(variable);
               }else{
                   throw new IsiSemanticException("Symbol "+_varName+" already declared");
               }
            }
          )*
          SC
        ;

tipo    : 'numero' { _type = IsiVariable.NUMBER;}
        | 'texto'  { _type = IsiVariable.TEXT;}
        ;
		
bloco	: {
            curThread = new ArrayList<AbstractCommand>();
            stack.push(curThread);
           }
          (cmd)+
		;
		

cmd		:  cmdleitura
 		|  cmdescrita
 		|  cmdattrib
 		|  cmdif
 		|  cmdwhile
		;
		
cmdleitura	: 'leia'
               AP
               ID {
                    _readID = _input.LT(-1).getText();
                    if(!isIDDeclared(_readID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _readID  + "` NOT declared");
                    }

               }
               FP
               SC {
                    initializeVar(_readID);
                    IsiVariable var = symbolTable.get(_readID);
                    CommandRead cmd = new CommandRead(_readID, var);
                    stack.peek().add(cmd);
               }
			;
			
cmdescrita	: 'escreva'
               AP
               ID {
                    _writeID = _input.LT(-1).getText();
                    if(!isIDDeclared(_writeID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _writeID  + "` NOT declared");
                    }
                    if(!isVarInitialized(_writeID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _writeID  + "` NOT initialized");
                    }
                  }
               FP
               SC {
                    CommandWrite cmd = new CommandWrite(_writeID);
                    stack.peek().add(cmd);
               }
			;

cmdattrib	:  ID {
                    _exprID = _input.LT(-1).getText();
                    if(!isIDDeclared(_exprID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` NOT declared");
                    }
               }
               ATTR { _exprContent = ""; }
               expr
               SC {
                     initializeVar(_exprID);
                     CommandAttribution cmd = new CommandAttribution(_exprID, _exprContent);
                     stack.peek().add(cmd);
               }
			;

cmdif  :  'se' AP {
                    ArrayList<AbstractCommand> trueThread = new ArrayList<AbstractCommand>();
                    ArrayList<AbstractCommand> falseThread = new ArrayList<AbstractCommand>();
                    ArrayList<AbstractCommand> listTrue = new ArrayList<AbstractCommand>();
                    ArrayList<AbstractCommand> listFalse = new ArrayList<AbstractCommand>();
               }
               boolExpr
               FP
               ACH {
                    trueThread = new ArrayList<AbstractCommand>();
                    stack.push(trueThread);
               }
               (cmd)+
               FCH {

                    listTrue = stack.pop();
               }
               ('senao'
                   ACH {
                            falseThread = new ArrayList<AbstractCommand>();
                            stack.push(falseThread);
                   }
                   (cmd+)
                   FCH {
                            listFalse = stack.pop();
                   }
               )? {
                    CommandIf cmd = new CommandIf(_exprDecision, listTrue, listFalse);
                    stack.peek().add(cmd);
               }
      ;

cmdwhile    : 'enquanto' AP {
                ArrayList<AbstractCommand> whileThread = new ArrayList<AbstractCommand>();
                ArrayList<AbstractCommand> whileList = new ArrayList<AbstractCommand>();
              }
              boolExpr
              FP
              ACH   {
                        whileThread = new ArrayList<AbstractCommand>();
                        stack.push(whileThread);
              }
              (cmd)+
              FCH   {
                        whileList = stack.pop();
                        CommandWhile cmd = new CommandWhile(_exprDecision, whileList);
                        stack.peek().add(cmd);
              }
            ;
boolExpr      : { _exprDecision = ""; } boolExprChild ;
boolExprChild      : boolExprChildChild
              |
              (
                (
                    boolExprChildChild
                    ('&&'| '||') { _exprDecision += _input.LT(-1).getText();}
                )?
                NOT? { _exprDecision += _input.LT(-1).getText();}
                AP { _exprDecision += _input.LT(-1).getText();}
                boolExprChild
                FP { _exprDecision += _input.LT(-1).getText();}
                (
                    ('&&'| '||') { _exprDecision += _input.LT(-1).getText();}
                    boolExprChild
                )*
              )*
            ;


boolExprChildChild    : boolTermo { _exprDecision += _input.LT(-1).getText(); }
              OPREL     { _exprDecision += _input.LT(-1).getText(); }
              boolTermo { _exprDecision += _input.LT(-1).getText(); }
              (
                ('&&'| '||') { _exprDecision += _input.LT(-1).getText(); }
                boolTermo { _exprDecision += _input.LT(-1).getText(); }
                OPREL { _exprDecision += _input.LT(-1).getText(); }
                boolTermo { _exprDecision += _input.LT(-1).getText(); }
              )*
            ;


boolTermo   : (
               ID {

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
               |
               NUMBER
            )
            ;


expr        : exprChild
              |
              (
                (
                    exprChild
                    OP { _exprContent += _input.LT(-1).getText(); }
                )?
                AP { _exprContent += _input.LT(-1).getText(); }
                expr
                FP { _exprContent += _input.LT(-1).getText(); }
                (
                    OP { _exprContent += _input.LT(-1).getText(); }
                    expr
                )*
              )*
            ;

exprChild   :  exprTermo
               (
                 OP { _exprContent += _input.LT(-1).getText(); }
                 exprTermo
               )*
			;
			
exprTermo		: ID {
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
            | NUMBER  {
                    if(!isNumber(_exprID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'texto' type, NOT a 'number' type");
                    }
                    _exprContent += _input.LT(-1).getText();
            }
            | STR {
                    if(isNumber(_exprID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, NOT a 'texto' type");
                    }
                    _exprContent += _input.LT(-1).getText();
            }
			;

ACH : '{'
    ;
FCH : '}'
    ;
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;

NOT   : '!'
      ;

VIR : ','
    ;

AP	: '('
	;
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
	 ;
	 
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
		;

STR     : '"' ( '\\"' | . )*? '"'
        ;

		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;