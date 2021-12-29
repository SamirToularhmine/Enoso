package analyse.reaching_definition;

import analyse.IAnalysis;
import analyse.State;
import org.antlr.v4.runtime.misc.Pair;

import java.util.Set;
import java.util.stream.Collectors;

public class ReachingDefinitionAnalysis implements IAnalysis<Set<Pair<String, Integer>>> {

    private TransferVisitorReachingDefinition transferVisitorReachingDefinition;

    public ReachingDefinitionAnalysis(Set<State> allNodes) {
        this.transferVisitorReachingDefinition = new TransferVisitorReachingDefinition(allNodes);
    }

    @Override
    public Set<Pair<String, Integer>> apply(Set<Pair<String, Integer>> currentValue, State state) {
        this.transferVisitorReachingDefinition.reset(state, currentValue);
        return (Set<Pair<String, Integer>>) state.getInstruction().accept(transferVisitorReachingDefinition);
    }

    @Override
    public String print(Set<Pair<String, Integer>> obj) {
        return obj.stream().map(p -> "(" + p.a + "," + p.b + ")").collect(Collectors.joining(", "));
    }
}
