package ast.aexpression;

import ast.Position;
import ast.Visitor;
import analyse.ITransferVisitor;
import ast.type.Type;

import java.util.Objects;

public class AexpressionNewArray extends Aexpression {
    private Type type;
    private Aexpression value;

    public AexpressionNewArray(Position position, Type type, Aexpression value) {
        this.position = position;
        this.type = type;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
        AexpressionNewArray that = (AexpressionNewArray) o;
        return Objects.equals(type, that.type) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value.hashCode());
    }
}
