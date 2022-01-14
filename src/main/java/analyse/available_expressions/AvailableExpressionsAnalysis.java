package analyse.available_expressions;

import analyse.IAnalysis;
import analyse.State;
import ast.VisitorPrint;
import ast.aexpression.Aexpression;

import java.util.Set;
import java.util.stream.Collectors;

public class AvailableExpressionsAnalysis implements IAnalysis<Set<Aexpression>> {

    private final TransferVisitorAvailableExpression transferVisitorAvailableExpression;
    private final VisitorPrint visitorPrint;

    public AvailableExpressionsAnalysis(Set<State> allNodes) {
        this.transferVisitorAvailableExpression = new TransferVisitorAvailableExpression(allNodes);
        this.visitorPrint = new VisitorPrint();
    }

    @Override
    public Set<Aexpression> apply(Set<Aexpression> currentValue, State state) {
        this.transferVisitorAvailableExpression.reset(currentValue);
        return (Set<Aexpression>) state.getInstruction().accept(transferVisitorAvailableExpression);
    }

    @Override
    public String print(Set<Aexpression> obj) {
        return obj.stream().map(a -> (String) a.accept(this.visitorPrint)).collect(Collectors.joining(", "));
    }
}
