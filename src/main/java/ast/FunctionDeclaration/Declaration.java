package ast.FunctionDeclaration;

import ast.Node;
import ast.Position;
import ast.Visitor;
import ast.statement.Statement;
import ast.type.Type;
import org.antlr.v4.runtime.misc.Pair;

import java.util.List;

public class Declaration extends Node {

    private String procName;
    private List<Arguments> arguments;
    private Pair<String, Type> returnType;
    private List<Statement> body;

    public Declaration(Position position, String procName, List<Arguments> arguments, Pair<String, Type> returnType, List<Statement> body) {
        this.position = position;
        this.procName = procName;
        this.arguments = arguments;
        this.returnType = returnType;
        this.body = body;
    }

    public String getProcName() {
        return procName;
    }

    public void setProcName(String procName) {
        this.procName = procName;
    }

    public List<Arguments> getArguments() {
        return arguments;
    }

    public void setArguments(List<Arguments> arguments) {
        this.arguments = arguments;
    }

    public Pair<String, Type> getReturnType() {
        return returnType;
    }

    public void setReturnType(Pair<String, Type> returnType) {
        this.returnType = returnType;
    }

    public List<Statement> getBody() {
        return body;
    }

    public void setBody(List<Statement> body) {
        this.body = body;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
