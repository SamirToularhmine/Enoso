import analyse.*;
import analyse.reaching_definition.ReachingDefinitionAnalysis;
import analyse.reaching_definition.VisitorGenFreeVariables;
import ast.AstBuilder;
import ast.DecVariable;
import ast.VisitorFlow;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.WhileLanguageLexer;
import parser.WhileLanguageParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
        //System.out.print(program.accept(visitorPrint));

        VisitorFlow visitorFlow = new VisitorFlow();
        Flow f = (Flow) program.accept(visitorFlow);
        f.prepare();

        f.toDot(outNameFromFileName(fileName));
/*
       MonotoneFramework<Aexpression> monotoneFrameworkAexpression = new MonotoneFramework<>(JoinType.MUST, f, Comparison.SUPSET, null, new HashSet<>(), false, new AvailableExpressionsAnalysis(f.getAllNodes()));
        monotoneFrameworkAexpression.analyse();

        MonotoneFramework<String> monotoneFrameworkString = new MonotoneFramework<>(JoinType.MAY, f, Comparison.SUBSET, null, new HashSet<>(), true, new LiveVariablesAnalysis());

        monotoneFrameworkString.analyse();

*/


        Set<Pair<String, Integer>> iota = new HashSet<>();
        /*for (DecVariable v : program.getlDeclVariables()) {
            iota.addAll(v.getIdentifiers().stream().map(i -> new Pair<>(i, -1)).collect(Collectors.toSet()));
        }

         */

        VisitorGenFreeVariables visitorGenFreeVariables = new VisitorGenFreeVariables();
        iota.addAll((Set<Pair<String, Integer>>) program.accept(visitorGenFreeVariables));

        MonotoneFramework<Pair<String, Integer>> monotoneFrameworkPair = new MonotoneFramework<>(
                JoinType.MAY,
                f,
                Comparison.SUBSET,
                null,
                iota,
                false,
                new ReachingDefinitionAnalysis(f.getAllNodes()));
        monotoneFrameworkPair.analyse();
/*
        MonotoneFramework<Aexpression> monotoneFrameworkVb = new MonotoneFramework<>(
                JoinType.MUST,
                f,
                Comparison.SUPSET,
                null,
                new HashSet<>(),
                true,
                new VeryBusyExpressionsAnalysis(f.getAllNodes()));
        monotoneFrameworkVb.analyse();

        //monotoneFrameworkAexpression.analyse();

*/

        exitWithCode(ErrorCode.SUCCESS);
    }

    private static String outNameFromFileName(String fileName) {
        String total = fileName.replaceAll("src/main/resources", "src/main/out/");
        String[] splitted = total.split("/");
        StringBuilder directoryName = new StringBuilder();
        for (int i = 0; i < splitted.length - 1; i++) {
            directoryName.append(splitted[i]).append("/");
        }
        try {
            Files.createDirectories(Paths.get(directoryName.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return total.split("\\.")[0] + ".dot";
    }
}
