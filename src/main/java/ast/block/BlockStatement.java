package ast.block;

import ast.Visitor;

public class BlockStatement extends Block{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
