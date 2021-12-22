package ast.transfer;

import analyse.State;
import ast.DecVariable;
import ast.FunctionDeclaration.Declaration;
import ast.Program;
import ast.Visitor;
import ast.aexpression.*;
import ast.bexpression.BexpressionAexpressionOprAexpression;
import ast.bexpression.BexpressionConst;
import ast.bexpression.BexpressionNot;
import ast.bexpression.BexpressionParenthesis;
import ast.block.BlockStatement;
import ast.block.BlockWithinParenthesis;
import ast.opa.OpaValue;
import ast.opr.OprValue;
import ast.statement.*;
import ast.type.TypeTable;
import ast.type.TypeType;

import java.util.Set;

public class TransferVisitorAvailableExpression implements ITransferVisitor<Set<Aexpression>> {

    private Set<State> allNodes;
    Set<Aexpression> currentValue;

    public TransferVisitorAvailableExpression(Set<Aexpression> currentValue, Set<State> allNodes) {
        this.allNodes = allNodes;
        this.currentValue = currentValue;
    }

    @Override
    public Set<Aexpression> visit(StatementAffectation statementAffectation) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(StatementCall statementCall) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(StatementIf statementIf) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(StatementSkip statementSkip) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(StatementWhile statementWhile) {
        return null;
    }
}
