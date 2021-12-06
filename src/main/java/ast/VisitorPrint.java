package ast;

import ast.FunctionDeclaration.Arguments;
import ast.FunctionDeclaration.Declaration;
import ast.aexpression.*;
import ast.bexpression.BexpressionAexpressionOprAexpression;
import ast.bexpression.BexpressionConst;
import ast.bexpression.BexpressionNot;
import ast.bexpression.BexpressionParenthesis;
import ast.block.BlockStatement;
import ast.block.BlockWithinParenthesis;
import ast.opa.*;
import ast.opr.*;
import ast.statement.*;
import ast.type.TypeTable;
import ast.type.TypeType;

public class VisitorPrint implements Visitor<String> {
    @Override
    public String visit(Program program) {
        StringBuilder res = new StringBuilder("program ");
        if (program.getProgramName() != null){
            res.append(program.getProgramName());
        }
        for (Declaration declaration : program.getDeclarationList()) {
            res.append((String) declaration.accept(this));
        }
        res.append("\nbegin \n");
        for (DecVariable getlDeclVariable : program.getlDeclVariables()) {
            res.append((String) getlDeclVariable.accept(this));
        }
        for (Statement statement : program.getStatements()) {
            res.append((String) statement.accept(this));
        }
        res.deleteCharAt(res.length()-2);
        res.append("\nend");
        return res.toString();
    }

    @Override
    public String visit(DecVariable decVariable) {
        StringBuilder str = new StringBuilder(decVariable.getType().accept(this)+ " ");
        for (int i = 0; i < decVariable.getIdentifiers().size(); i++) {
            str.append(decVariable.getIdentifiers().get(i));
            if (i != decVariable.getIdentifiers().size() - 1)
                str.append(", ");
        }
        str.append(";\n");
        return str.toString();
    }

    @Override
    public String visit(Declaration declaration) {
        StringBuilder str = new StringBuilder("proc " + declaration.getProcName() + "(");
        for (int i = 0; i < declaration.getArguments().size(); i++) {
            Arguments argument = declaration.getArguments().get(i);
            str.append((String) argument.getType().accept(this) + " " + argument.getIdentifier());
            if (i != declaration.getArguments().size()-1){
                str.append(", ");
            }
        }
        if (declaration.getReturnType() != null){
            str.append(", " + (String) declaration.getReturnType().b.accept(this) + " " + declaration.getReturnType().a);
        }
        str.append(" )\nbegin\n");

        for (int i = 0; i < declaration.getBody().size(); i++) {
            str.append(declaration.getBody().get(i).accept(this));
        }
        return str.append("\nend\n").toString();
    }

    @Override
    public String visit(AexpressionArray aexpressionArray) {
        return aexpressionArray.getIdentifier() + " [" + aexpressionArray.getIndex().accept(this) + "]";
    }

    @Override
    public String visit(AexpressionBinary aexpressionBinary) {
        return (String) aexpressionBinary.getLeft().accept(this) + aexpressionBinary.getOperator().accept(this) + aexpressionBinary.getRight().accept(this);
    }

    @Override
    public String visit(AexpressionConstant aexpressionConstant) {
        return Integer.toString(aexpressionConstant.getValue());
    }

    @Override
    public String visit(AexpressionIdentifier aexpressionIdentifier) {
        return aexpressionIdentifier.getIdentifier();
    }

    @Override
    public String visit(AexpressionNewArray aexpressionNewArray) {
        return "new " + aexpressionNewArray.getType().accept(this) + " [" + aexpressionNewArray.getValue().accept(this)+ "]";
    }

    @Override
    public String visit(AexpressionParenthesis aexpressionParenthesis) {
        return "(" + aexpressionParenthesis.getAexpression().accept(this) +")";
    }

    @Override
    public String visit(AexpressionNeg aexpressionNeg) {
        return "-" + aexpressionNeg.getValue().accept(this);
    }

    @Override
    public String visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        return (String) bexpressionAexpressionOprAexpression.getLeft().accept(this) + " " + bexpressionAexpressionOprAexpression.getOpr().accept(this) + " " + bexpressionAexpressionOprAexpression.getRight().accept(this);
    }

    @Override
    public String visit(BexpressionConst bexpressionConst) {
        return Boolean.toString(bexpressionConst.isValue());
    }

    @Override
    public String visit(BexpressionNot bexpressionNot) {
        return "not " + bexpressionNot.getValue().accept(this) ;
    }

    @Override
    public String visit(BexpressionParenthesis bexpressionParenthesis) {
        return "(" + bexpressionParenthesis.getValue().accept(this) +")";
    }

    @Override
    public String visit(BlockStatement blockStatement) {
        return (String) blockStatement.getStatement().accept(this);
    }

    @Override
    public String visit(BlockWithinParenthesis blockWithinParenthesis) {
        StringBuilder str = new StringBuilder("(\n");
        for (int i = 0; i < blockWithinParenthesis.getStatements().size(); i++) {
            str.append(blockWithinParenthesis.getStatements().get(i).accept(this));
        }
        return str.append("\n);").toString();
    }

    @Override
    public String visit(OpaValue opaValue) {
        return opaValue.getCaracter();
    }

    @Override
    public String visit(OprValue oprValue) {
        return oprValue.getCaracter();
    }

    @Override
    public String visit(StatementAffectation statementAffectation) {
        return statementAffectation.getIdentifier() + " := " + statementAffectation.getAexpression().accept(this) + "; ";
    }

    @Override
    public String visit(StatementCall statementCall) {
        String parameters = "";
        for (Aexpression parameter : statementCall.getParameters()) {
            parameters = (String) parameter.accept(this);
        }
        return "call " + statementCall.getIdentifier() + "(" + parameters + ")";
    }

    @Override
    public String visit(StatementIf statementIf) {
        String elseString = "";
        if (statementIf.getElseBlock()!= null){
            elseString = " else \n " + statementIf.getElseBlock().accept(this);
        }
        return "if " + statementIf.getCondition().accept(this)+ " then \n " + statementIf.getIfBlock().accept(this) + elseString;
    }

    @Override
    public String visit(StatementSkip statementSkip) {
        return "skip";
    }

    @Override
    public String visit(StatementWhile statementWhile) {
        return "\nwhile " +  statementWhile.getCondition().accept(this) + " do " + statementWhile.getBlock().accept(this) + "\n";
    }

    @Override
    public String visit(TypeTable typeTable) {
        return typeTable.getType().accept(this) + "[]";
    }

    @Override
    public String visit(TypeType typeType) {
        return typeType.getType();
    }
}
