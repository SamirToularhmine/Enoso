package ast.statement;

import ast.Position;
import ast.Visitor;
import ast.bexpression.Bexpression;
import ast.block.Block;

import java.util.Set;

public class StatementWhile extends Statement{
    private Bexpression condition;
    private Block block;

    public StatementWhile(Position position, Bexpression condition, Block block) {
        this.position = position;
        this.condition = condition;
        this.block = block;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public Bexpression getCondition() {
        return condition;
    }

    public void setCondition(Bexpression condition) {
        this.condition = condition;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
