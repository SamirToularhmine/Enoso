package analyse.reaching_definition;

import analyse.ITransferVisitor;
import analyse.State;
import analyse.available_expressions.VisitorGenAeStar;
import ast.DecVariable;
import ast.FunctionDeclaration.Declaration;
import ast.Program;
import ast.VisitorPrint;
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
import exceptions.InappropriateVisitException;
import org.antlr.v4.runtime.misc.Pair;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TransferVisitorReachingDefinition implements ITransferVisitor<Set<Pair<String, Integer>>> {

    private Set<State> allNodes;
    private Set<Pair<String, Integer>> currentValue;
    private State currentState;
    private Set<Aexpression> aeStar;

    public TransferVisitorReachingDefinition(Set<State> allNodes) {
        this.allNodes = new HashSet<>(allNodes);
        this.currentValue = new HashSet<>();
        this.aeStar = new HashSet<>();

        // On crée toutes les expressions et sous expressions du programme
        VisitorGenAeStar visitorGenAeStar = new VisitorGenAeStar();
        VisitorPrint visitorPrint = new VisitorPrint();
        this.allNodes.forEach(n -> aeStar.addAll((Set<Aexpression>) n.getInstruction().accept(visitorGenAeStar)));
        aeStar.forEach(a -> System.out.println(a.accept(visitorPrint)));
    }

    public void reset(State currentState, Set<Pair<String, Integer>> currentValue){
        this.currentValue = currentValue;
        this.currentState = currentState;
    }


    @Override
    public Set<Pair<String, Integer>> visit(Program program) {
        throw new InappropriateVisitException(program);
    }

    @Override
    public Set<Pair<String, Integer>> visit(DecVariable decVariable) {
        throw new InappropriateVisitException(decVariable);
    }

    @Override
    public Set<Pair<String, Integer>> visit(Declaration declaration) {
        throw new InappropriateVisitException(declaration);
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionArray aexpressionArray) {
        throw new InappropriateVisitException(aexpressionArray);
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionBinary aexpressionBinary) {
        throw new InappropriateVisitException(aexpressionBinary);
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionConstant aexpressionConstant) {
        throw new InappropriateVisitException(aexpressionConstant);
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionIdentifier aexpressionIdentifier) {
        throw new InappropriateVisitException(aexpressionIdentifier);
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionNewArray aexpressionNewArray) {
        throw new InappropriateVisitException(aexpressionNewArray);
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionParenthesis aexpressionParenthesis) {
        throw new InappropriateVisitException(aexpressionParenthesis);
    }

    @Override
    public Set<Pair<String, Integer>> visit(AexpressionNeg aexpressionUnary) {
        throw new InappropriateVisitException(aexpressionUnary);
    }

    @Override
    public Set<Pair<String, Integer>> visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        return new HashSet<>(this.currentValue);
    }

    @Override
    public Set<Pair<String, Integer>> visit(BexpressionConst bexpressionConst) {
        throw new InappropriateVisitException(bexpressionConst);
    }

    @Override
    public Set<Pair<String, Integer>> visit(BexpressionNot bexpressionNot) {
        throw new InappropriateVisitException(bexpressionNot);
    }

    @Override
    public Set<Pair<String, Integer>> visit(BexpressionParenthesis bexpressionParenthesis) {
        throw new InappropriateVisitException(bexpressionParenthesis);
    }

    @Override
    public Set<Pair<String, Integer>> visit(BlockStatement blockStatement) {
        throw new InappropriateVisitException(blockStatement);
    }

    @Override
    public Set<Pair<String, Integer>> visit(BlockWithinParenthesis blockWithinParenthesis) {
        throw new InappropriateVisitException(blockWithinParenthesis);
    }

    @Override
    public Set<Pair<String, Integer>> visit(OpaValue opaDivision) {
        throw new InappropriateVisitException(opaDivision);
    }

    @Override
    public Set<Pair<String, Integer>> visit(OprValue oprValue) {
        throw new InappropriateVisitException(oprValue);
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementAffectation statementAffectation) {
        Set<Pair<String, Integer>> result = this.currentValue == null ? new HashSet<>() : new HashSet<>(this.currentValue);
        Set<Pair<String, Integer>> kill = new HashSet<>();
        Set<Pair<String, Integer>> gen = new HashSet<>();

        // All affectations
        Set<State> allAffectations = this.allNodes.stream().filter(n -> n.getInstruction() instanceof StatementAffectation).collect(Collectors.toSet());

        // Kill
        kill.add(new Pair<>(statementAffectation.getIdentifier(), -1));
        kill.addAll(
                allAffectations
                        .stream()
                        .filter(s -> ((StatementAffectation)s.getInstruction()).getIdentifier().equals(statementAffectation.getIdentifier()))
                        .map(s -> new Pair<>(statementAffectation.getIdentifier(), s.getLabel()))
                        .collect(Collectors.toSet()));

        // Gen
        gen.add(new Pair<>(statementAffectation.getIdentifier(), this.currentState.getLabel()));

        // Result - Kill
        result.removeAll(kill);

        // + Gen
        result.addAll(gen);

        return result;
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementCall statementCall) {
        throw new InappropriateVisitException(statementCall);
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementIf statementIf) {
        throw new InappropriateVisitException(statementIf);
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementSkip statementSkip) {
        throw new InappropriateVisitException(statementSkip);
    }

    @Override
    public Set<Pair<String, Integer>> visit(StatementWhile statementWhile) {
        throw new InappropriateVisitException(statementWhile);
    }

    @Override
    public Set<Pair<String, Integer>> visit(TypeTable typeTable) {
        throw new InappropriateVisitException(typeTable);
    }

    @Override
    public Set<Pair<String, Integer>> visit(TypeType typeType) {
        throw new InappropriateVisitException(typeType);
    }
}