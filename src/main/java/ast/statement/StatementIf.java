package ast.statement;

import ast.Position;
import ast.Visitor;
import ast.bexpression.Bexpression;
import ast.block.Block;

import java.util.HashSet;
import java.util.Set;

public class StatementIf extends Statement{
    private Bexpression condition;
    private Block ifBlock;
    private Block elseBlock;

    public StatementIf(Position position, Bexpression condition, Block ifBlock, Block elseBlock) {
        this.position = position;
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
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

    public Block getIfBlock() {
        return ifBlock;
    }

    public void setIfBlock(Block ifBlock) {
        this.ifBlock = ifBlock;
    }

    public Block getElseBlock() {
        return elseBlock;
    }

    public void setElseBlock(Block elseBlock) {
        this.elseBlock = elseBlock;
    }
}
