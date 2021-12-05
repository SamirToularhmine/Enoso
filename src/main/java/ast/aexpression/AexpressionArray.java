package ast.aexpression;

import ast.Position;
import ast.Visitor;

public class AexpressionArray extends Aexpression {
    private String identifier;
    private Aexpression index;

    public AexpressionArray(Position position, String identifier, Aexpression index) {
        this.position = position;
        this.identifier = identifier;
        this.index = index;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Aexpression getIndex() {
        return index;
    }

    public void setIndex(Aexpression index) {
        this.index = index;
    }

}
