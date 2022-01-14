package ast;

import analyse.Flow;
import analyse.State;
import ast.FunctionDeclaration.Declaration;
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
import utils.Utils;

import java.awt.*;
import java.sql.Array;
import java.util.*;
import java.util.List;

public class VisitorFlow implements Visitor<Flow>{

    private final Map<String, Flow> proceduresMap;
    private final Map<String, List<State>> entryState; // proc1, [S1,S2,S3]
    private final Map<String, List<State>> exitState; // proc2, [S1,S2,S3]

    public VisitorFlow(){
        this.proceduresMap = new HashMap<>();
        this.entryState = new HashMap<>();
        this.exitState = new HashMap<>();
    }

    @Override
    public Flow visit(Program program) {
        List<Statement> statements = program.getStatements();

        for (Declaration declaration : program.getDeclarationList()) {
            Flow flowDeclFinal = getFlowStatements(declaration.getBody());
            proceduresMap.put(declaration.getProcName(), flowDeclFinal);
        }
        Flow flowFinal = getFlowStatements(statements);

        for (String nomProc : proceduresMap.keySet()) {
            List<State> entrees = entryState.get(nomProc);
            List<State> exits = exitState.get(nomProc);

            entrees.forEach(s -> s.getChildren().addAll(proceduresMap.get(nomProc).getHead()));
            List<State> finals = new ArrayList<>(proceduresMap.get(nomProc).getFinals());
            proceduresMap.get(nomProc).getFinals().clear();
            finals.forEach(s -> s.getChildren().addAll(exits));
        }
        return flowFinal;
    }

    @Override
    public Flow visit(DecVariable decVariable) {
        throw new InappropriateVisitException(decVariable);
    }

    @Override
    public Flow visit(Declaration declaration) {
        return null;
    }

    @Override
    public Flow visit(AexpressionArray aexpressionArray) {
        throw new InappropriateVisitException(aexpressionArray);
    }

    @Override
    public Flow visit(AexpressionBinary aexpressionBinary) {
        throw new InappropriateVisitException(aexpressionBinary);
    }

    @Override
    public Flow visit(AexpressionConstant aexpressionConstant) {
        throw new InappropriateVisitException(aexpressionConstant);
    }

    @Override
    public Flow visit(AexpressionIdentifier aexpressionIdentifier) {
        throw new InappropriateVisitException(aexpressionIdentifier);
    }

    @Override
    public Flow visit(AexpressionNewArray aexpressionNewArray) {
        throw new InappropriateVisitException(aexpressionNewArray);
    }

    @Override
    public Flow visit(AexpressionParenthesis aexpressionParenthesis) {
        throw new InappropriateVisitException(aexpressionParenthesis);
    }

    @Override
    public Flow visit(AexpressionNeg aexpressionUnary) {
        throw new InappropriateVisitException(aexpressionUnary);
    }

    @Override
    public Flow visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        Flow flowFinal = new Flow();

        State state = new State(bexpressionAexpressionOprAexpression, -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(BexpressionConst bexpressionConst) {
        Flow flowFinal = new Flow();

        State state = new State(bexpressionConst, -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(BexpressionNot bexpressionNot) {
        Flow flowFinal = new Flow();

        State state = new State(bexpressionNot, -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(BexpressionParenthesis bexpressionParenthesis) {
        return (Flow) bexpressionParenthesis.getValue().accept(this);
    }

    @Override
    public Flow visit(BlockStatement blockStatement) {
        Flow flowFinal = new Flow();

        State state = new State(blockStatement.getStatement(), -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(BlockWithinParenthesis blockWithinParenthesis) {
        List<Statement> statements = blockWithinParenthesis.getStatements();
        return getFlowStatements(statements);
    }

    @Override
    public Flow visit(OpaValue opaDivision) {
        throw new InappropriateVisitException(opaDivision);
    }

    @Override
    public Flow visit(OprValue oprValue) {
        throw new InappropriateVisitException(oprValue);
    }

    @Override
    public Flow visit(StatementAffectation statementAffectation) {
        Flow flowFinal = new Flow();

        State state = new State(statementAffectation, -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(StatementCall statementCall) {
        Flow flowfinal = new Flow();
        State entree = new State(statementCall); // entry Call

        Color color = Utils.createRandomColor();
        entree.setPrefix("Entry");
        entree.setColor(color);
        State sortie = new State(statementCall); // exit Call
        sortie.setPrefix("Exit");
        sortie.setColor(color);

        if (this.entryState.containsKey(statementCall.getIdentifier())){
            this.entryState.get(statementCall.getIdentifier()).add(entree);
            this.exitState.get(statementCall.getIdentifier()).add(sortie);
        }else {

            this.entryState.put(statementCall.getIdentifier(), new ArrayList<>(List.of(entree)));
            this.exitState.put(statementCall.getIdentifier(), new ArrayList<>(List.of(sortie)));
        }
        flowfinal.getHead().add(entree);
        flowfinal.getFinals().add(sortie);


        return flowfinal;
    }

    @Override
    public Flow visit(StatementIf statementIf) {
        Flow flowFinal = new Flow();

        Flow flowCond = (Flow) statementIf.getCondition().accept(this);
        Flow flowIfBlock = (Flow) statementIf.getIfBlock().accept(this);
        Flow flowElseBlock;

        flowFinal.getHead().addAll(flowCond.getHead());
        flowFinal.getFinals().addAll(flowIfBlock.getFinals());
        flowFinal.getHead().iterator().next().getChildren().addAll(flowIfBlock.getHead());

        // Il peut ne pas y avoir de else block
        if(statementIf.getElseBlock() != null){
            flowElseBlock = (Flow) statementIf.getElseBlock().accept(this);
            flowFinal.getFinals().addAll(flowElseBlock.getFinals());
            flowFinal.getHead().iterator().next().getChildren().addAll(flowElseBlock.getHead());
        }else{
            flowFinal.getFinals().add(flowFinal.getHead().iterator().next());
        }

        return flowFinal;
    }

    @Override
    public Flow visit(StatementSkip statementSkip) {
        Flow flowFinal = new Flow();

        State state = new State(statementSkip, -1, new ArrayList<>(), new ArrayList<>());
        flowFinal.getHead().add(state);
        flowFinal.getFinals().add(state);

        return flowFinal;
    }

    @Override
    public Flow visit(StatementWhile statementWhile) {
        Flow flowFinal = new Flow();

        Flow fbexp = (Flow) statementWhile.getCondition().accept(this);
        Flow fblock = (Flow) statementWhile.getBlock().accept(this);

        flowFinal.getHead().addAll(fbexp.getHead());
        fblock.getFinals().forEach(s -> s.getChildren().addAll(flowFinal.getHead()));
        flowFinal.getHead().iterator().next().getChildren().add(fblock.getHead().iterator().next());
        flowFinal.getFinals().addAll(fbexp.getHead());

        return flowFinal;
    }

    @Override
    public Flow visit(TypeTable typeTable) {
        throw new InappropriateVisitException(typeTable);
    }

    @Override
    public Flow visit(TypeType typeType) {
        throw new InappropriateVisitException(typeType);
    }


    private Flow getFlowStatements(List<Statement> body) {
        Flow flowDeclFinal = (Flow) body.get(0).accept(this);
        for (int i = 1; i < body.size(); i++) {
            Flow flowState = (Flow) body.get(i).accept(this);

            flowDeclFinal.getFinals().forEach(s -> s.getChildren().addAll(flowState.getHead()));
            flowDeclFinal.getFinals().clear();
            flowDeclFinal.getFinals().addAll(flowState.getFinals());
        }
        return flowDeclFinal;
    }
}
