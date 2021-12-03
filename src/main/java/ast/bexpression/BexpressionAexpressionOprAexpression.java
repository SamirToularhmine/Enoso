package ast.bexpression;

import ast.Visitor;

public class BexpressionAexpressionOprAexpression extends Bexpression{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
