package ast.transfer;

import ast.Visitor;
import ast.bexpression.VisitorBexpression;
import ast.statement.VisitorStatement;

public interface ITransferVisitor<T> extends Visitor<T> {

}
