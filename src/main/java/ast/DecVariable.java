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

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
