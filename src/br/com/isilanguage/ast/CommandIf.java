package br.com.isilanguage.ast;

import java.util.ArrayList;

public class CommandIf extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> listTrue;
    private ArrayList<AbstractCommand> listFalse;

    public CommandIf(String condition){
        this.condition = condition;
    }

    public CommandIf(String condition, ArrayList<AbstractCommand> lt, ArrayList<AbstractCommand> lf){
        this.condition = condition;
        this.listTrue = lt;
        this.listFalse = lf;
    }

    public void setListTrue(ArrayList<AbstractCommand> lt){
        this.listTrue = lt;
    }

    public void setListFalse(ArrayList<AbstractCommand> lf){
        this.listFalse = lf;
    }

    @Override
    public String generateJavaCode() {

        StringBuilder str = new StringBuilder();
        str.append("if(").append(condition).append("){\n");
        for(AbstractCommand cmd: this.listTrue){
            str.append(cmd.generateJavaCode());
        }
        str.append("}");
        if(listFalse.size() > 0){
            str.append("else {\n");
            for(AbstractCommand cmd: this.listFalse){
                str.append(cmd.generateJavaCode());
            }
            str.append("}\n");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return "CommandIf{" +
                "condition='" + condition + '\'' +
                ", listTrue=" + listTrue +
                ", listFalse=" + listFalse +
                '}';
    }
}
