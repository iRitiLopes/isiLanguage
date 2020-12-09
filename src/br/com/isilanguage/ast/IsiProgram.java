package br.com.isilanguage.ast;

import br.com.isilanguage.datastructures.IsiSymbolTable;
import br.com.isilanguage.datastructures.IsiVariable;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class IsiProgram {
    private IsiSymbolTable varTable;
    private ArrayList<AbstractCommand> commands;
    private String programName;

    public void generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("public class MainClass{ \n");
        str.append("  public static void main(String args[]){\n ");
        str.append("      Scanner _key = new Scanner(System.in);\n");
        for (IsiVariable symbol: varTable.getAll()) {
            str.append(symbol.generateJavaCode()).append("\n");
        }
        for (AbstractCommand command: commands) {
            str.append(command.generateJavaCode()).append("\n");
        }
        str.append("  }");
        str.append("}");

        try {
            FileWriter fr = new FileWriter(new File("MainClass.java"));
            fr.write(str.toString());
            fr.close();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    public IsiSymbolTable getVarTable() {
        return varTable;
    }

    public void setVarTable(IsiSymbolTable varTable) {
        this.varTable = varTable;
    }

    public ArrayList<AbstractCommand> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<AbstractCommand> commands) {
        this.commands = commands;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
