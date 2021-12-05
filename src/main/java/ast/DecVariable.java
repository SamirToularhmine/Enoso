package ast;

import ast.type.Type;

import java.util.List;

public class DecVariable extends Node{

    private Type type;
    private List<String> identifiers;

    public DecVariable(Position position,Type type, List<String>  identifiers) {
        this.position = position;
        this.type = type;
        this.identifiers = identifiers;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<String> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<String> identifiers) {
        this.identifiers = identifiers;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
