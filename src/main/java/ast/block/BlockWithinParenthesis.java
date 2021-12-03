package ast.block;

import ast.Position;
import ast.Visitor;
import ast.statement.Statement;

public class BlockWithinParenthesis extends Block{
    private Statement[] statements;

    public BlockWithinParenthesis(Position position, Statement[] statements) {
        this.position = position;
        this.statements = statements;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public Statement[] getStatements() {
        return statements;
    }

    public void setStatements(Statement[] statements) {
        this.statements = statements;
    }
}
