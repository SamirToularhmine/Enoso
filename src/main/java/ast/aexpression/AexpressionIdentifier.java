package ast.aexpression;

import ast.Position;
import ast.Visitor;

public class AexpressionIdentifier extends Aexpression {
    private String identifier;

    public AexpressionIdentifier(Position position, String identifier) {
        this.identifier = identifier;
        this.position = position;
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

}
