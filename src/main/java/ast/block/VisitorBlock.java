package ast.block;

import ast.aexpression.AexpressionArray;

public interface VisitorBlock<T>{
    T visit(BlockStatement blockStatement);
    T visit(BlockWithinParenthesis blockWithinParenthesis);

}
