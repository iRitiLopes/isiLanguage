package br.com.isilanguage.datastructures;

        import java.util.HashMap;

public class IsiSymbolTable {

    private HashMap<String, IsiVariable> map;

    public IsiSymbolTable(){
        map = new HashMap<String, IsiVariable>();
    }

    public void add(IsiVariable symbol){
        map.put(symbol.getName(), symbol);
    }

    public boolean exists(String symbolName){
        return map.get(symbolName) != null;
    }

    public IsiVariable get(String symbolName){
        return map.get(symbolName);
    }

    public void replace(String id, IsiVariable newSymbol){
        map.replace(id, newSymbol);
    }

}
