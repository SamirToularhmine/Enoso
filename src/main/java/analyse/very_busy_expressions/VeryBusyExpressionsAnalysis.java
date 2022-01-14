package analyse.very_busy_expressions;

import analyse.IAnalysis;
import analyse.State;
import ast.VisitorPrint;
import ast.aexpression.Aexpression;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Set;
import java.util.stream.Collectors;

public class VeryBusyExpressionsAnalysis implements IAnalysis<Set<Aexpression>> {

    private final TransferVisitorVeryBusyExpressions transferVisitorVeryBusyExpressions;

    public VeryBusyExpressionsAnalysis(Set<State> allNodes) {
        this.transferVisitorVeryBusyExpressions = new TransferVisitorVeryBusyExpressions(allNodes);
    }

    @Override
    public Set<Aexpression> apply(Set<Aexpression> currentValue, State state) {
        this.transferVisitorVeryBusyExpressions.reset(currentValue);
        return (Set<Aexpression>) state.getInstruction().accept(transferVisitorVeryBusyExpressions);
    }

    @Override
    public String print(Set<Aexpression> obj) {
        if(obj != null){
            VisitorPrint visitorPrint = new VisitorPrint();
            return obj.stream().map(p -> (String) p.accept(visitorPrint) ).collect(Collectors.joining(", "));
        }

        return "";
    }
}
