package analyse.live_variables;

import ast.DecVariable;
import ast.FunctionDeclaration.Declaration;
import ast.Program;
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
import analyse.ITransferVisitor;
import ast.type.TypeTable;
import ast.type.TypeType;
import exceptions.InappropriateVisitException;

import java.util.HashSet;
import java.util.Set;

public class TransferVisitorLiveVariables implements ITransferVisitor<Set<String>> {

    private Set<String> currentValue;

    public TransferVisitorLiveVariables() {
        this.currentValue = new HashSet<>();
    }

    public void reset(Set<String> currentValue){
        this.currentValue = new HashSet<>(currentValue);
    }

    @Override
    public Set<String> visit(Program program) {
        throw new InappropriateVisitException(program);
    }

    @Override
    public Set<String> visit(DecVariable decVariable) {
        throw new InappropriateVisitException(decVariable);
    }

    @Override
    public Set<String> visit(Declaration declaration) {
        throw new InappropriateVisitException(declaration);
    }

    @Override
    public Set<String> visit(AexpressionArray aexpressionArray) {
        Set<String> set = new HashSet<>();
        set.add(aexpressionArray.getIdentifier());
        set.addAll((Set<String>) aexpressionArray.getIndex().accept(this));
        return set;
    }

    @Override
    public Set<String> visit(AexpressionBinary aexpressionBinary) {
        Set<String> set = new HashSet<>();
        set.addAll((Set<String>) aexpressionBinary.getLeft().accept(this));
        set.addAll((Set<String>) aexpressionBinary.getRight().accept(this));
        return set;
    }

    @Override
    public Set<String> visit(AexpressionConstant aexpressionConstant) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visit(AexpressionIdentifier aexpressionIdentifier) {
        Set<String> set = new HashSet<>();
        set.add(aexpressionIdentifier.getIdentifier());
        return set;
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
        Set<String> gen = new HashSet<>();
        gen.addAll((Set<String>) bexpressionAexpressionOprAexpression.getLeft().accept(this));
        gen.addAll((Set<String>)bexpressionAexpressionOprAexpression.getRight().accept(this));
        return this.killGen(null, gen);
    }

    @Override
    public Set<String> visit(BexpressionConst bexpressionConst) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visit(BexpressionNot bexpressionNot) {
        return (Set<String>) bexpressionNot.getValue().accept(this);
    }

    @Override
    public Set<String> visit(BexpressionParenthesis bexpressionParenthesis) {
        return (Set<String>) bexpressionParenthesis.getValue().accept(this);
    }

    @Override
    public Set<String> visit(BlockStatement blockStatement) {
        throw new InappropriateVisitException(blockStatement);
    }

    @Override
    public Set<String> visit(BlockWithinParenthesis blockWithinParenthesis) {
        throw new InappropriateVisitException(blockWithinParenthesis);
    }

    @Override
    public Set<String> visit(OpaValue opaDivision) {
        throw new InappropriateVisitException(opaDivision);
    }

    @Override
    public Set<String> visit(OprValue oprValue) {
        throw new InappropriateVisitException(oprValue);
    }

    @Override
    public Set<String> visit(StatementAffectation statementAffectation) {
        Set<String> aexpression = (Set<String>) statementAffectation.getAexpression().accept(this);

        return killGen(new HashSet<>(Set.of(statementAffectation.getIdentifier())), aexpression);
    }

    private Set<String> killGen(Set<String> kill, Set<String> gen) {
        if(this.currentValue != null){
            if(kill != null)
                this.currentValue.removeAll(kill);

            if (gen != null)
                this.currentValue.addAll(gen);
        }

        return currentValue;
    }

    @Override
    public Set<String> visit(StatementCall statementCall) {
        throw new InappropriateVisitException(statementCall);
    }

    @Override
    public Set<String> visit(StatementIf statementIf) {
        throw new InappropriateVisitException(statementIf);
    }

    @Override
    public Set<String> visit(StatementSkip statementSkip) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visit(StatementWhile statementWhile) {
        throw new InappropriateVisitException(statementWhile);
    }

    @Override
    public Set<String> visit(TypeTable typeTable) {
        throw new InappropriateVisitException(typeTable);
    }

    @Override
    public Set<String> visit(TypeType typeType) {
        throw new InappropriateVisitException(typeType);
    }
}
