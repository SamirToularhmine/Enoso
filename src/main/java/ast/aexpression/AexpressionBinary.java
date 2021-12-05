package ast.aexpression;

import ast.Position;
import ast.Visitor;
import ast.opa.Opa;

public class AexpressionBinary extends Aexpression {
    private Aexpression left, right;
    private Opa operator;

    public AexpressionBinary(Position position, Aexpression left, Aexpression right, Opa operator) {
        this.position = position;
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public Aexpression getLeft() {
        return left;
    }

    public void setLeft(Aexpression left) {
        this.left = left;
    }

    public Aexpression getRight() {
        return right;
    }

    public void setRight(Aexpression right) {
        this.right = right;
    }

    public Opa getOperator() {
        return operator;
    }

    public void setOperator(Opa operator) {
        this.operator = operator;
    }
}
