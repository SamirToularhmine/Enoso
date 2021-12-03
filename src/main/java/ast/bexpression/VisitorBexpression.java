package ast.bexpression;


public interface VisitorBexpression<T> {
    T visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression);
    T visit(BexpressionFalse bexpressionFalse);
    T visit(BexpressionNot bexpressionNot);
    T visit(BexpressionParenthesis bexpressionParenthesis);
    T visit(BexpressionTrue bexpressionTrue);

}
