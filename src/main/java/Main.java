import analyse.Comparison;
import analyse.Flow;
import analyse.JoinType;
import analyse.MonotoneFramework;
import ast.AstBuilder;
import ast.VisitorPrint;
import ast.aexpression.Aexpression;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    private static void testState(){
        //Test des fonctions d'analyse

        State etat1 = new State(null, 1, new ArrayList<>(), new ArrayList<>());
        State etat2 = new State(null, 2, new ArrayList<>(), new ArrayList<>());
        State etat3 = new State(null, 3, new ArrayList<>(), new ArrayList<>(), true);
        State etat4 = new State(null, 4, new ArrayList<>(), new ArrayList<>(), true);
        State etat5 = new State(null, 5, new ArrayList<>(), new ArrayList<>(), true);
        State etat6 = new State(null, 6, new ArrayList<>(), new ArrayList<>());
        State etat7 = new State(null, 7, new ArrayList<>(), new ArrayList<>(), true);

        etat1.setChildren(List.of(etat2));
        etat1.setParents(List.of(etat2));
        etat2.setParents(List.of(etat1));

        etat2.setChildren(List.of(etat3, etat1, etat4));
        etat3.setParents(List.of(etat2));
        etat3.setChildren(List.of(etat5));

        etat4.setParents(List.of(etat2));
        etat4.setChildren(List.of(etat5));

        etat5.setParents(List.of(etat4, etat3));

        etat6.setChildren(List.of(etat7));
        etat7.setParents(List.of(etat6));

        Flow flow = new Flow();
        flow.setHead(List.of(etat1, etat6));
        System.out.println(flow);
        flow.toDot("flow.dot");
        flow.reverseFlow();
        flow.toDot("flowReverse.dot");

        System.out.println("After reverse \n");
        System.out.println(flow);
        flow.reverseFlow();
        System.out.println("After reverse \n");
        System.out.println(flow);
    }

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
        System.out.println(program);
        VisitorPrint visitorPrint = new VisitorPrint();
        System.out.print(program.accept(visitorPrint));
        testState();

        Flow flow = new Flow();
        MonotoneFramework<Aexpression> monotoneFrameworkAexpression = new MonotoneFramework<>(JoinType.MUST, flow ,  Comparison.SUPSET, null, null);

        exitWithCode(ErrorCode.SUCCESS);
    }
}
