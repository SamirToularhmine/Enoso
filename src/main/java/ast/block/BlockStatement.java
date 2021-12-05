package ast.block;

import ast.Position;
import ast.Visitor;
import ast.statement.Statement;

public class BlockStatement extends Block{
    private Statement statement;

    public BlockStatement(Position position, Statement statement) {
        this.position =  position;
        this.statement = statement;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}
