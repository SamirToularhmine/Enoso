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
import ast.opa.OpaValue;
import ast.opr.OprValue;
import ast.statement.*;
import ast.type.TypeTable;
import ast.type.TypeType;

import java.util.List;

public class VisitorPrint implements Visitor<String> {
    private int tabulation;

    @Override
    public String visit(Program program) {
        StringBuilder res = new StringBuilder("program");
        tabulation = 0;
        if (program.getProgramName() != null) {
            res.append(" " + program.getProgramName());
        }
        res.append("\n");
        for (Declaration declaration : program.getDeclarationList()) {
            res.append((String) declaration.accept(this));
        }
        res.append("begin \n");
        tabulation++;
        for (DecVariable getlDeclVariable : program.getlDeclVariables()) {
            res.append((String) getlDeclVariable.accept(this));
        }
        List<Statement> statements = program.getStatements();
        for (int i = 0; i < statements.size(); i++) {
            Statement statement = statements.get(i);
            res.append((String) statement.accept(this));
            if (i != statements.size() - 1) {
                res.append(";\n");
            }else{
                res.append("\n");
            }
        }
        res.append("end");
        tabulation = 0;
        return res.toString();
    }

    @Override
    public String visit(DecVariable decVariable) {
        StringBuilder str = new StringBuilder();
        str.append("\t".repeat(Math.max(0, this.tabulation)));
        str.append(decVariable.getType().accept(this) + " ");
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
            str.append(argument.getType().accept(this) + " " + argument.getIdentifier());
            if (i != declaration.getArguments().size() - 1) {
                str.append(", ");
            }
        }
        if (declaration.getReturnType() != null) {
            str.append(", res " + (String) declaration.getReturnType().b.accept(this) + " " + declaration.getReturnType().a);
        }
        tabulation++;
        str.append(")\nbegin\n");

        for (int i = 0; i < declaration.getBody().size(); i++) {
            str.append(declaration.getBody().get(i).accept(this));
        }
        tabulation = 0;
        return str.append("end\n").toString();
    }

    @Override
    public String visit(AexpressionArray aexpressionArray) {
        return aexpressionArray.getIdentifier() + "[" + aexpressionArray.getIndex().accept(this) + "]";
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
        return "new " + aexpressionNewArray.getType().accept(this) + "[" + aexpressionNewArray.getValue().accept(this) + "]";
    }

    @Override
    public String visit(AexpressionParenthesis aexpressionParenthesis) {
        return "(" + aexpressionParenthesis.getAexpression().accept(this) + ")";
    }

    @Override
    public String visit(AexpressionNeg aexpressionNeg) {
        return "-" + aexpressionNeg.getValue().accept(this);
    }

    @Override
    public String visit(BexpressionAexpressionOprAexpression bexpressionAexpressionOprAexpression) {
        return (String) bexpressionAexpressionOprAexpression.getLeft().accept(this) + bexpressionAexpressionOprAexpression.getOpr().accept(this) + bexpressionAexpressionOprAexpression.getRight().accept(this);
    }

    @Override
    public String visit(BexpressionConst bexpressionConst) {
        return Boolean.toString(bexpressionConst.isValue());
    }

    @Override
    public String visit(BexpressionNot bexpressionNot) {
        return "not " + bexpressionNot.getValue().accept(this);
    }

    @Override
    public String visit(BexpressionParenthesis bexpressionParenthesis) {
        return "(" + bexpressionParenthesis.getValue().accept(this) + ")";
    }

    @Override
    public String visit(BlockStatement blockStatement) {
        return (String) blockStatement.getStatement().accept(this) + "\n";
    }

    @Override
    public String visit(BlockWithinParenthesis blockWithinParenthesis) {
        String tab = "\t".repeat(Math.max(0, this.tabulation - 1));

        StringBuilder str = new StringBuilder(" (\n");
        for (int i = 0; i < blockWithinParenthesis.getStatements().size(); i++) {
            str.append(blockWithinParenthesis.getStatements().get(i).accept(this));
            if (i != blockWithinParenthesis.getStatements().size() - 1) {
                str.append(";\n");
            }
        }
        return str.append("\n" + tab + ")").toString();
    }

    @Override
    public String visit(OpaValue opaValue) {
        return " " + opaValue.getCaracter() + " ";
    }

    @Override
    public String visit(OprValue oprValue) {
        return " " + oprValue.getCaracter() + " ";
    }

    @Override
    public String visit(StatementAffectation statementAffectation) {
        StringBuilder str = new StringBuilder();
        str.append("\t".repeat(Math.max(0, this.tabulation)));
        return str.append(statementAffectation.getIdentifier() + " := " + statementAffectation.getAexpression().accept(this)).toString();
    }

    @Override
    public String visit(StatementCall statementCall) {
        StringBuilder str = new StringBuilder();
        List<Aexpression> statementCallParameters = statementCall.getParameters();
        for (int i = 0; i < statementCallParameters.size(); i++) {
            Aexpression parameter = statementCallParameters.get(i);
            str.append((String) parameter.accept(this));
            if (i != statementCallParameters.size() - 1) {
                str.append(", ");
            }
        }
        String tab = "\t".repeat(Math.max(0, this.tabulation));

        return tab + "call " + statementCall.getIdentifier() + "(" + str + ")";
    }

    @Override
    public String visit(StatementIf statementIf) {
        String tab = "\t".repeat(Math.max(0, this.tabulation));
        tabulation++;
        String ifBlock = (String) statementIf.getIfBlock().accept(this);
        tabulation--;
        if (premierVraiChar(ifBlock) != '(') {
            ifBlock = "\n" + ifBlock;
        }
        String result = tab + "if " + statementIf.getCondition().accept(this) + " then" + ifBlock;
        String elseString = "";


        if (statementIf.getElseBlock() != null) {
            elseString = "else";
            tab = "\t".repeat(Math.max(0, this.tabulation));
            String lastChar = ifBlock.substring(ifBlock.length() - 1);
            if (!lastChar.equals(")"))
                elseString = tab + elseString;
            tabulation++;
            String elseBlock = (String) statementIf.getElseBlock().accept(this);
            tabulation--;
            if (premierVraiChar(elseBlock) != '(') {
                elseString+= "\n";
            }
            elseString += elseBlock;
        }

        result += elseString;
        return result;
    }

    @Override
    public String visit(StatementSkip statementSkip) {
        return "\t".repeat(Math.max(0, this.tabulation)) + "skip";
    }

    @Override
    public String visit(StatementWhile statementWhile) {
        String tab = "\t".repeat(Math.max(0, this.tabulation));
        String result = tab + "while " + statementWhile.getCondition().accept(this) + " do ";
        tabulation++;
        result += statementWhile.getBlock().accept(this);
        tabulation--;
        return result;
    }

    @Override
    public String visit(TypeTable typeTable) {
        return typeTable.getType().accept(this) + "[]";
    }

    @Override
    public String visit(TypeType typeType) {
        return typeType.getType();
    }

    private char premierVraiChar(String string) {
        string = string.replaceAll("[\\n\\t ]", "");
        return string.charAt(0);
    }
}
