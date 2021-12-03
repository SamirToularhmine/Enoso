package ast.aexpression;

import ast.Position;
import ast.Visitor;

public class AexpressionParenthesis extends Aexpression {
    private Aexpression aexpression;

    public AexpressionParenthesis(Position position, Aexpression aexpression) {
        this.aexpression = aexpression;
        this.position = position;
    }

    public Aexpression getAexpression() {
        return aexpression;
    }

    public void setAexpression(Aexpression aexpression) {
        this.aexpression = aexpression;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
