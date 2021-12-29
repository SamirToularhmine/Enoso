package analyse.very_busy_expressions;

import analyse.ITransferVisitor;
import analyse.State;
import analyse.available_expressions.VisitorGenAeStar;
import ast.DecVariable;
import ast.FunctionDeclaration.Declaration;
import ast.Program;
import ast.VisitorPrint;
import ast.aexpression.*;
import ast.bexpression.*;
import ast.block.BlockStatement;
import ast.block.BlockWithinParenthesis;
import ast.opa.OpaValue;
import ast.opr.OprValue;
import ast.statement.*;
import ast.type.TypeTable;
import ast.type.TypeType;
import exceptions.InappropriateVisitException;
import org.antlr.v4.runtime.misc.Pair;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TransferVisitorVeryBusyExpressions implements ITransferVisitor<Set<Aexpression>> {

    private Set<State> allNodes;
    private Set<Aexpression> currentValue;
    private State currentState;
    private Set<Aexpression> aeStar;

    public TransferVisitorVeryBusyExpressions(Set<State> allNodes) {
        this.allNodes = new HashSet<>(allNodes);
        this.currentValue = new HashSet<>();
        this.aeStar = new HashSet<>();

        // On crée toutes les expressions et sous expressions du programme
        VisitorGenAeStar visitorGenAeStar = new VisitorGenAeStar();
        VisitorPrint visitorPrint = new VisitorPrint();
        this.allNodes.forEach(n -> aeStar.addAll((Set<Aexpression>) n.getInstruction().accept(visitorGenAeStar)));
        aeStar.forEach(a -> System.out.println(a.accept(visitorPrint)));
    }

    public void reset(State currentState, Set<Aexpression> currentValue){
        this.currentValue = currentValue;
        this.currentState = currentState;
    }

    @Override
    public Set<Aexpression> visit(Program program) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(DecVariable decVariable) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(Declaration declaration) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(AexpressionArray aexpressionArray) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(AexpressionBinary aexpressionBinary) {
        Set<Aexpression> result = new HashSet<>();

        Set<Aexpression> left = (Set<Aexpression>)aexpressionBinary.getLeft().accept(this);
        if(left != null){
            result.addAll(left);
        }

        Set<Aexpression> right = (Set<Aexpression>)aexpressionBinary.getRight().accept(this);
        if(right != null){
            result.addAll(right);
        }

        return result;
    }

    @Override
    public Set<Aexpression> visit(AexpressionConstant aexpressionConstant) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(AexpressionIdentifier aexpressionIdentifier) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(AexpressionNewArray aexpressionNewArray) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(AexpressionParenthesis aexpressionParenthesis) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(AexpressionNeg aexpressionUnary) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        Set<Aexpression> result = new HashSet<>(this.currentValue != null ? this.currentValue : new HashSet<>());

        Set<Aexpression> left = (Set<Aexpression>)bexpressionAexpressionOprAexpression.getLeft().accept(this);
        if(left != null){
            result.addAll(left);
        }

        Set<Aexpression> right = (Set<Aexpression>)bexpressionAexpressionOprAexpression.getRight().accept(this);
        if(right != null){
            result.addAll(right);
        }

        return result;
    }

    @Override
    public Set<Aexpression> visit(BexpressionConst bexpressionConst) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(BexpressionNot bexpressionNot) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(BexpressionParenthesis bexpressionParenthesis) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(BlockStatement blockStatement) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(BlockWithinParenthesis blockWithinParenthesis) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(OpaValue opaDivision) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(OprValue oprValue) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(StatementAffectation statementAffectation) {
        Set<Aexpression> result = new HashSet<>(this.currentValue != null ? this.currentValue : new HashSet<>());
        Set<Aexpression> kill = new HashSet<>(this.aeStar.stream().filter(a -> a.contains(statementAffectation.getIdentifier())).collect(Collectors.toSet()));
        Set<Aexpression> gen = new HashSet<>(Set.of(statementAffectation.getAexpression()));

        // Result - Kill
        result.removeAll(kill);

        Set<Aexpression> aexpa = (Set<Aexpression>) statementAffectation.getAexpression().accept(this);
        if(aexpa != null){
            gen.addAll(aexpa);
        }

        // + Gen
        result.addAll(gen);

        return result;
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

    @Override
    public Set<Aexpression> visit(TypeTable typeTable) {
        return null;
    }

    @Override
    public Set<Aexpression> visit(TypeType typeType) {
        return null;
    }
}
