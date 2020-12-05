package br.com.isilanguage.exceptions;
import java.lang.RuntimeException;

public class IsiSemanticException extends RuntimeException {
    public IsiSemanticException(String msg){
        super("SEMANTIC ERROR - " + msg);
    }
}
