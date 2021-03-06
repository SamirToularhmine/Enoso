package ast.aexpression;

public interface VisitorAexpression<T> {
    T visit(AexpressionArray aexpressionArray);
    T visit(AexpressionBinary aexpressionBinary);
    T visit(AexpressionConstant aexpressionConstant);
    T visit(AexpressionIdentifier aexpressionIdentifier);
    T visit(AexpressionNewArray aexpressionNewArray);
    T visit(AexpressionParenthesis aexpressionParenthesis);
    T visit(AexpressionNeg aexpressionUnary);


}
