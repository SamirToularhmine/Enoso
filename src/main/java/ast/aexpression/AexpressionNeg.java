package ast.aexpression;

import ast.Position;
import ast.Visitor;

public class AexpressionNeg extends Aexpression {
    private Aexpression value;

    public AexpressionNeg(Position position, Aexpression value) {
        this.value = value;
        this.position = position;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public Aexpression getValue() {
        return value;
    }

    public void setValue(Aexpression value) {
        this.value = value;
    }
}
