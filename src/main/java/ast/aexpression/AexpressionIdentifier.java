package ast.aexpression;

import ast.Position;
import ast.Visitor;
import ast.transfer.ITransferVisitor;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AexpressionIdentifier that = (AexpressionIdentifier) o;
        return Objects.equals(identifier, that.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
