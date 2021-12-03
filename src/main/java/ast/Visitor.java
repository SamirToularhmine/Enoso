package ast;

import ast.aexpression.VisitorAexpression;
import ast.bexpression.VisitorBexpression;
import ast.block.VisitorBlock;
import ast.opa.VisitorOpa;
import ast.opr.VisitorOpr;
import ast.statement.VisitorStatement;
import ast.type.VisitorType;

public interface Visitor<T> extends VisitorBlock<T>, VisitorStatement<T>, VisitorType<T>, VisitorAexpression<T>,
                                    VisitorOpa<T>, VisitorBexpression<T>, VisitorOpr<T> {
    T visit(Program program);

}
