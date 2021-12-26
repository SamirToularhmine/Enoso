package ast.transfer;

import analyse.State;
import ast.DecVariable;
import ast.FunctionDeclaration.Declaration;
import ast.Position;
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

import java.util.HashSet;
import java.util.Set;

public class TransferVisitorAvailableExpression implements ITransferVisitor<Set<String>> {

    private Set<State> allNodes;
    private Set<Aexpression> currentValue;

    public TransferVisitorAvailableExpression(Set<Aexpression> currentValue, Set<State> allNodes) {
        this.allNodes = allNodes;
        this.currentValue = currentValue;
    }

    @Override
    public Set<String> visit(StatementAffectation statementAffectation) {
        // - Kill + Gen
        //Set<String> result = new HashSet<>(this.currentValue);
        String identifier = statementAffectation.getIdentifier();
        Set<String> gen = (Set<String>) statementAffectation.getAexpression().accept(this);

        return null;
        // return result;
    }

    @Override
    public Set<String> visit(StatementCall statementCall) {
        return null;
    }

    @Override
    public Set<String> visit(StatementIf statementIf) {
        return null;
    }

    @Override
    public Set<String> visit(StatementSkip statementSkip) {
        return null;
    }

    @Override
    public Set<String> visit(StatementWhile statementWhile) {
        return null;
    }

    @Override
    public Set<String> visit(Program program) {
        return null;
    }

    @Override
    public Set<String> visit(DecVariable decVariable) {
        return null;
    }

    @Override
    public Set<String> visit(Declaration declaration) {
        return null;
    }

    @Override
    public Set<String> visit(AexpressionArray aexpressionArray) {
        return null;
        //return new HashSet<>(Set.of(aexpressionArray.getIndex()));
    }

    @Override
    public Set<String> visit(AexpressionBinary aexpressionBinary) {
        Set<String> result = new HashSet<>();

        result.addAll((Set<String>) aexpressionBinary.getLeft().accept(this));
        result.addAll((Set<String>) aexpressionBinary.getRight().accept(this));
        //result.add(aexpressionBinary);

        return result;
    }

    @Override
    public Set<String> visit(AexpressionConstant aexpressionConstant) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visit(AexpressionIdentifier aexpressionIdentifier) {
        return null;
        //return new HashSet<>(Set.of((String) aexpressionIdentifier));
    }

    @Override
    public Set<String> visit(AexpressionNewArray aexpressionNewArray) {
        return (Set<String>) aexpressionNewArray.getValue().accept(this);
    }

    @Override
    public Set<String> visit(AexpressionParenthesis aexpressionParenthesis) {
        return (Set<String>) aexpressionParenthesis.getAexpression().accept(this);
    }

    @Override
    public Set<String> visit(AexpressionNeg aexpressionUnary) {
        return (Set<String>) aexpressionUnary.getValue().accept(this);
    }

    @Override
    public Set<String> visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        Set<String> result = new HashSet<>();

        result.addAll((Set<String>) bexpressionAexpressionOprAexpression.getLeft().accept(this));
        result.addAll((Set<String>) bexpressionAexpressionOprAexpression.getRight().accept(this));

        return result;
    }

    @Override
    public Set<String> visit(BexpressionConst bexpressionConst) {
        return null;
    }

    @Override
    public Set<String> visit(BexpressionNot bexpressionNot) {
        return null;
    }

    @Override
    public Set<String> visit(BexpressionParenthesis bexpressionParenthesis) {
        return null;
    }

    @Override
    public Set<String> visit(BlockStatement blockStatement) {
        return null;
    }

    @Override
    public Set<String> visit(BlockWithinParenthesis blockWithinParenthesis) {
        return null;
    }

    @Override
    public Set<String> visit(OpaValue opaDivision) {
        return null;
    }

    @Override
    public Set<String> visit(OprValue oprValue) {
        return null;
    }

    @Override
    public Set<String> visit(TypeTable typeTable) {
        return null;
    }

    @Override
    public Set<String> visit(TypeType typeType) {
        return null;
    }
}
