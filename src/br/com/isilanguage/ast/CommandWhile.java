package br.com.isilanguage.ast;

import java.util.ArrayList;

public class CommandWhile extends AbstractCommand {
    private String condition;
    private ArrayList<AbstractCommand> whileCommands;

    public CommandWhile(String condition, ArrayList<AbstractCommand> whileCommands){
        this.condition = condition;
        this.whileCommands = whileCommands;
    }

    @Override
    public String generateJavaCode() {

        StringBuilder str = new StringBuilder();
        str.append("while(").append(condition).append("){\n");
        for(AbstractCommand cmd: this.whileCommands){
            str.append(cmd.generateJavaCode());
        }
        str.append("}");
        return str.toString();
    }

    @Override
    public String toString() {
        return "CommandWhile{" +
                "condition='" + condition + '\'' +
                ", whileCommands=" + whileCommands +
                '}';
    }
}
