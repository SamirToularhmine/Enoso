import analyse.Comparison;
import analyse.Flow;
import analyse.JoinType;
import analyse.MonotoneFramework;
import analyse.available_expressions.AvailableExpressionsAnalysis;
import analyse.live_variables.LiveVariablesAnalysis;
import analyse.reaching_definition.ReachingDefinitionAnalysis;
import analyse.reaching_definition.VisitorGenFreeVariables;
import analyse.very_busy_expressions.VeryBusyExpressionsAnalysis;
import ast.AstBuilder;
import ast.VisitorFlow;
import ast.VisitorPrint;
import ast.aexpression.Aexpression;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.WhileLanguageLexer;
import parser.WhileLanguageParser;
import utils.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    private static void exitWithCode(ErrorCode code) {
        System.exit(code.ordinal());
    }


    private static ast.Program buildAst(ParseTree parseTree) {
        ast.AstBuilder builder = new AstBuilder();
        return (ast.Program) parseTree.accept(builder);
    }

    private static InputStream getInputStream(String fileName) {
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
        List<String> allAnalysis = List.of(
                "Very Busy Expressions",
                "Reaching Definition",
                "Available Expressions",
                "Live Variables"
        );

        if (arguments.length == 0)
            // No name given to the command line
            exitWithCode(ErrorCode.NO_FILE_NAME);
        if (arguments.length == 2 && arguments[0].equals("getDotName")) {
            System.out.println(Utils.outNameFromFileName(arguments[1]));
            return;
        }
        if (arguments.length == 1 && arguments[0].equals("showAnalyses")) {
            System.out.print(String.join(System.lineSeparator(), allAnalysis));
            return;
        }
        if (arguments.length == 2) {
            String fileName = arguments[0];
            String analyse = arguments[1];
            InputStream inputStream = getInputStream(fileName);
            ParseTree parseTree = parse(inputStream);
            ast.Program program = buildAst(parseTree);
            VisitorPrint visitorPrint = new VisitorPrint();

            System.out.println(program.accept(visitorPrint));

            VisitorFlow visitorFlow = new VisitorFlow();
            Flow f = (Flow) program.accept(visitorFlow);
            f.prepare();
            f.toDot(Utils.outNameFromFileName(fileName));
            switch (analyse) {
                case ("0") -> {
                    MonotoneFramework<Aexpression> monotoneFrameworkVb = new MonotoneFramework<>(
                            JoinType.MUST,
                            f,
                            Comparison.SUPSET,
                            null,
                            new HashSet<>(),
                            true,
                            new VeryBusyExpressionsAnalysis(f.getAllNodes()));
                    monotoneFrameworkVb.analyse();
                }
                case ("1") -> {
                    MonotoneFramework<Pair<String, Integer>> monotoneFrameworkPair = new MonotoneFramework<>(
                            JoinType.MAY,
                            f,
                            Comparison.SUBSET,
                            null,
                            (Set<Pair<String, Integer>>) program.accept(new VisitorGenFreeVariables()), // iota
                            false,
                            new ReachingDefinitionAnalysis(f.getAllNodes()));
                    monotoneFrameworkPair.analyse();
                }
                case ("2") -> {
                    MonotoneFramework<Aexpression> monotoneFrameworkAexpression = new MonotoneFramework<>(
                            JoinType.MUST,
                            f,
                            Comparison.SUPSET,
                            null,
                            new HashSet<>(),
                            false,
                            new AvailableExpressionsAnalysis(f.getAllNodes()));
                    monotoneFrameworkAexpression.analyse();
                }
                case ("3") -> {
                    MonotoneFramework<String> monotoneFrameworkString = new MonotoneFramework<>(
                            JoinType.MAY,
                            f,
                            Comparison.SUBSET,
                            null,
                            new HashSet<>(),
                            true,
                            new LiveVariablesAnalysis());
                    monotoneFrameworkString.analyse();
                }
            }
        }
    }


}
