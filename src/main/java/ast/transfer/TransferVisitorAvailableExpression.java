package ast.transfer;

import ast.bexpression.BexpressionAexpressionOprAexpression;
import ast.bexpression.BexpressionConst;
import ast.bexpression.BexpressionNot;
import ast.bexpression.BexpressionParenthesis;
import ast.statement.*;

import java.util.Set;

public class TransferVisitorAvailableExpression<T> implements TransferVisitor<T> {


    @Override
    public Object visit(StatementAffectation statementAffectation, Set nodes) {
        return null;
    }

    @Override
    public Object visit(StatementCall statementCall, Set nodes) {
        return null;
    }

    @Override
    public Object visit(StatementIf statementIf, Set nodes) {
        return null;
    }

    @Override
    public Object visit(StatementSkip statementSkip, Set nodes) {
        return null;
    }

    @Override
    public Object visit(StatementWhile statementWhile, Set nodes) {
        return null;
    }
}
