import analyse.*;
import ast.AstBuilder;
import ast.VisitorFlow;
import ast.VisitorPrint;
import ast.aexpression.Aexpression;
import ast.transfer.ITransferVisitor;
import ast.transfer.TransferVisitorAvailableExpression;
import ast.transfer.TransferVisitorLiveVariables;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.WhileLanguageLexer;
import parser.WhileLanguageParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private enum ErrorCode {
        SUCCESS,
        NO_FILE_NAME,
        FILE_NOT_FOUND,
        SYNTAX_ERROR,
        SEMANTIC_ERROR,
        TRANSLATION_TO_IR_ERROR,
        COMPILATION_ERROR
    }

    private static void exitWithCode(ErrorCode code){
        System.exit(code.ordinal());
    }


    private static ast.Program buildAst(ParseTree parseTree){
        ast.AstBuilder builder = new AstBuilder();
        return (ast.Program) parseTree.accept(builder);
    }

    private static InputStream getInputStream(String fileName){
        try {
            if (fileName != null)
                return new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            exitWithCode(ErrorCode.FILE_NOT_FOUND);
        }
        return System.in;
    }

    private static ParseTree parse(InputStream inputStream) throws IOException {
        CharStream input = CharStreams.fromStream(inputStream);
        // Creation of the lexer for pico programs
        WhileLanguageLexer lexer = new WhileLanguageLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Creation of the parser for pico programs
        WhileLanguageParser parser = new WhileLanguageParser(tokens);
        // Parse the input: the result is a parse tree
        ParseTree tree = parser.program();
        if (parser.getNumberOfSyntaxErrors() != 0)
            exitWithCode(ErrorCode.SYNTAX_ERROR);
        return tree;
    }


    public static void main(String[] arguments) throws IOException {
        if (arguments.length == 0)
            // No name given to the command line
            exitWithCode(ErrorCode.NO_FILE_NAME);
        String fileName = arguments[0];
        InputStream inputStream = getInputStream(fileName);
        ParseTree parseTree = parse(inputStream);
        ast.Program program = buildAst(parseTree);
        //System.out.println(program);
        VisitorPrint visitorPrint = new VisitorPrint();
        //System.out.print(program.accept(visitorPrint));

        VisitorFlow visitorFlow = new VisitorFlow();
        Flow f = (Flow) program.accept(visitorFlow);
        f.prepare();
        f.toDot("test.dot");



        /*MonotoneFramework<Aexpression> monotoneFrameworkAexpression = new MonotoneFramework<>(JoinType.MUST, f, Comparison.SUPSET, null, new HashSet<>(), (currentValue, state, nodes) -> {
            ITransferVisitor<Set<Aexpression>> transferVisitorAvailableExpression = new TransferVisitorAvailableExpression(currentValue, nodes);
            return (Set<Aexpression>) state.getInstruction().accept(transferVisitorAvailableExpression);
        });*/

       MonotoneFramework<String> monotoneFrameworkString = new MonotoneFramework<>(JoinType.MAY, f, Comparison.SUBSET, null, new HashSet<>(), true, (currentValue, state, nodes) -> {
            ITransferVisitor<Set<String>> transferVisitorLiveVariables = new TransferVisitorLiveVariables(currentValue, nodes);
            return (Set<String>) state.getInstruction().accept(transferVisitorLiveVariables);
        });
        monotoneFrameworkString.analyse();
        f.toDot("test.dot");


        //monotoneFrameworkAexpression.analyse();


        exitWithCode(ErrorCode.SUCCESS);
    }
}
