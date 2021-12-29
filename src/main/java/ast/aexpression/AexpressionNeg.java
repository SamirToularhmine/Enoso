package ast.aexpression;

import ast.Position;
import ast.Visitor;
import analyse.ITransferVisitor;

import java.util.Objects;

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

    @Override
    public Object accept(ITransferVisitor visitor) {
        return visitor.visit(this);
    }

    public Aexpression getValue() {
        return value;
    }

    public void setValue(Aexpression value) {
        this.value = value;
    }

    @Override
    public boolean contains(String identifier) {
        return this.value.contains(identifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AexpressionNeg that = (AexpressionNeg) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
