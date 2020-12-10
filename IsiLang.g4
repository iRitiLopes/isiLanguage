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
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _writeID  + "` not initialized");
                    }
                  }
               FP
               SC
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

cmdif  :  'se' AP
               ID {
                    if(!isIDDeclared(_input.LT(-1).getText())){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT declared");
                    }
                    if(!isVarInitialized(_input.LT(-1).getText())){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` not initialized");
                    }
               }
               OPREL {  }
               (
                   ID {
                        if(!isIDDeclared(_input.LT(-1).getText())){
                            throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` NOT declared");
                        }
                        if(!isVarInitialized(_input.LT(-1).getText())){
                            throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _input.LT(-1).getText()  + "` not initialized");
                        }
                   }
                   |
                   NUMBER
               ) { }
               FP
               ACH { }
               (cmd)+
               FCH { }
               ('senao'
                   ACH { }
                   (cmd+)
                   FCH { }
               )?
      ;

cmdwhile    : 'while' AP termo OPREL termo FP ACH (cmd)+ FCH
            ;
			
expr		:  termo
               (
                 OP { _exprContent += _input.LT(-1).getText(); }
                 termo
               )*
			;
			
termo		: ID {
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
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, not a 'texto' type");
                    }
                    _exprContent += _input.LT(-1).getText();

              }
            | NUMBER  {
                    if(!isNumber(_exprID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'texto' type, not a 'number' type");
                    }
                    _exprContent += _input.LT(-1).getText();
            }
            | STR {
                    if(isNumber(_exprID)){
                        throw new IsiSemanticException(getCurrentToken().getLine(), getCurrentToken().getCharPositionInLine(), "Symbol `" + _exprID  + "` expectating a 'number' type, not a 'texto' type");
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