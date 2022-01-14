package analyse.live_variables;

import analyse.IAnalysis;
import analyse.State;

import java.util.Set;
import java.util.stream.Collectors;

public class LiveVariablesAnalysis implements IAnalysis<Set<String>> {

    private final TransferVisitorLiveVariables transferVisitorLiveVariables;

    public LiveVariablesAnalysis() {
        this.transferVisitorLiveVariables = new TransferVisitorLiveVariables();
    }

    @Override
    public Set<String> apply(Set<String> currentValue, State state) {
        this.transferVisitorLiveVariables.reset(currentValue);
        return (Set<String>) state.getInstruction().accept(transferVisitorLiveVariables);
    }

    @Override
    public String print(Set<String> obj) {
        return obj.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
