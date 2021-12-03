package ast.statement;

import ast.Visitor;

public class StatementWhile extends Statement{
    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
