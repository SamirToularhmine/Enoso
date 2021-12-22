package ast.aexpression;

import ast.Position;
import ast.Visitor;
import ast.transfer.ITransferVisitor;

import java.util.Objects;

public class AexpressionConstant extends Aexpression {

    private final int value;

    public AexpressionConstant(Position position, int valeur){
        this.value = valeur;
        this.position = position;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public Object accept(ITransferVisitor visitor) {
        return visitor.visit(this);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AexpressionConstant that = (AexpressionConstant) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
