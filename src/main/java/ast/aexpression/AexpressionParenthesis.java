package ast.aexpression;

import ast.Position;
import ast.Visitor;
import analyse.ITransferVisitor;

import java.util.Objects;

public class AexpressionParenthesis extends Aexpression {
    private Aexpression aexpression;

    public AexpressionParenthesis(Position position, Aexpression aexpression) {
        this.aexpression = aexpression;
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

    public Aexpression getAexpression() {
        return aexpression;
    }

    public void setAexpression(Aexpression aexpression) {
        this.aexpression = aexpression;
    }

    @Override
    public boolean contains(String identifier) {
        return this.aexpression.contains(identifier);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AexpressionParenthesis that = (AexpressionParenthesis) o;
        return Objects.equals(aexpression, that.aexpression);
    }

    @Override
    public int hashCode() {
        return aexpression.hashCode();
    }
}
