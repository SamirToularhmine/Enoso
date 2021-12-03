package ast.aexpression;

import ast.Position;
import ast.Visitor;

public class AexpressionConstant extends Aexpression {

    private final int value;

    public AexpressionConstant(Position position, int valeur){
        this.value = valeur;
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
