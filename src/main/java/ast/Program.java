package ast;

import ast.statement.Statement;

import java.util.List;

public class Program extends Node{
    private String programName;
    private List<Declaration> declarationList;
    private List<DecVariable> lDeclVariables;
    private List<Statement> statements;

    public Program(Position position,String programName, List<Declaration> declarationList, List<DecVariable> lDeclVariables, List<Statement> statements) {
        this.position = position;
        this.programName = programName;
        this.declarationList = declarationList;
        this.lDeclVariables = lDeclVariables;
        this.statements = statements;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<Declaration> getDeclarationList() {
        return declarationList;
    }

    public void setDeclarationList(List<Declaration> declarationList) {
        this.declarationList = declarationList;
    }

    public List<DecVariable> getlDeclVariables() {
        return lDeclVariables;
    }

    public void setlDeclVariables(List<DecVariable> lDeclVariables) {
        this.lDeclVariables = lDeclVariables;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}