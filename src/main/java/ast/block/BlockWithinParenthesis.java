package ast.block;

import ast.Visitor;

public class BlockWithinParenthesis extends Block{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
