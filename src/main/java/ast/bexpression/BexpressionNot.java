package ast.bexpression;

import ast.Position;
import ast.Visitor;
import analyse.ITransferVisitor;

public class BexpressionNot extends Bexpression{
    private Bexpression value;

    public BexpressionNot(Position position, Bexpression value) {
        this.position = position;
        this.value = value;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public Object accept(ITransferVisitor visitor) {
        return visitor.visit(this);
    }

    public Bexpression getValue() {
        return value;
    }

    public void setValue(Bexpression value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
