package ast.aexpression;

import ast.Position;
import ast.Visitor;
import analyse.ITransferVisitor;

import java.util.Objects;

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

    @Override
    public Object accept(ITransferVisitor visitor) {
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

    @Override
    public boolean contains(String identifier) {
        return this.index.contains(identifier) || this.identifier.equals(identifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AexpressionArray that = (AexpressionArray) o;
        return Objects.equals(identifier, that.identifier) && Objects.equals(index, that.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, index.hashCode());
    }

}
