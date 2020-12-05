grammar IsiLang;

@header{
    import br.com.isilanguage.exceptions.IsiSemanticException;
    import br.com.isilanguage.datastructures.IsiSymbolTable;
    import br.com.isilanguage.datastructures.IsiVariable;
    import br.com.isilanguage.datastructures.IsiSymbol;
    import java.util.ArrayList;
}
@members {
    private int _type;
    private String _varName;
    private String _varValue;
    private IsiSymbolTable symbolTable = new IsiSymbolTable();
    private IsiSymbol symbol;
    private IsiVariable variable;

    public boolean checkID(String id){
        return symbolTable.exists(id);
    }

    public void checkIDDeclared(String id){
        if(checkID(id))
            return;
        throw new IsiSemanticException("Symbol `" + id  + "` NOT declared");
    }

    public void checkIDNotDeclared(String id){
        if(!checkID(id))
            return;
        throw new IsiSemanticException("Symbol `" + id  + "` already declared");
    }

}

prog	: 'programa'  (decl* bloco)*  'fimprog;'
		;

decl    : tipo
          ID {
                _varName = _input.LT(-1).getText();
                _varValue = null;
                symbol = new IsiVariable(_varName, _type, _varValue);
                checkIDNotDeclared(_varName);
                symbolTable.add(symbol);
             }
          (
            VIR
            ID {
               _varName = _input.LT(-1).getText();
               _varValue = null;
               symbol = new IsiVariable(_varName, _type, _varValue);
               checkIDNotDeclared(_varName);
               symbolTable.add(symbol);
            }
          )*
          SC
        ;

tipo    : 'numero' { _type = IsiVariable.NUMBER;}
        | 'texto'  { _type = IsiVariable.TEXT;}
        ;
		
bloco	: (cmd)+
		;
		

cmd		:  cmdleitura
 		|  cmdescrita
 		|  cmdattrib
		;
		
cmdleitura	: 'leia'
               AP
               ID {
                    checkIDDeclared(_input.LT(-1).getText());
               }
               FP
               SC
			;
			
cmdescrita	: 'escreva'
               AP
               ID { checkIDDeclared(_input.LT(-1).getText()); }
               FP
               SC
			;
			
cmdattrib	:  ID { checkIDDeclared(_input.LT(-1).getText()); }
               ATTR
               expr
               SC
			;
			
expr		:  termo ( OP termo )*
			;
			
termo		: ID {
                    checkIDDeclared(_input.LT(-1).getText());
              }
            | NUMBER
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
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;