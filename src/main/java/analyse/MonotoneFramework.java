package analyse;

import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class MonotoneFramework<T> {
    private JoinType joinType;
    private Flow flow;
    private Set<T> domain;
    private Comparison comparison;
    private T bottom;
    private Set<T> iota;
    private ITransferFunction<Set<T>> transferFunction;

    public MonotoneFramework(JoinType joinType, Flow flow, Comparison comparison, T bottom, Set<T> iota, ITransferFunction<Set<T>> transferFunction) {
        this.joinType = joinType;
        this.flow = flow;
        this.iota = new HashSet<>(iota);
        this.domain = new HashSet<>();
        this.domain.addAll(iota);
        this.comparison = comparison;
        this.bottom = bottom;
        this.transferFunction = transferFunction;
    }

    public void analyse() {
        // Analyse MFP
        Set<State> entries = this.flow.getHead();
        Set<State> nodes = this.flow.getAllNodes();
        Map<Integer, Set<T>> currentMfp = new HashMap<>();
        Queue<Pair<State, State>> workQueue = new ArrayDeque<>();

        nodes.forEach(n -> currentMfp.put(n.getLabel(), null));
        entries.forEach(s -> {
            currentMfp.put(s.getLabel(), new HashSet<>(this.iota));
            s.getChildren().forEach(c -> workQueue.add(new Pair<>(s, c)));
        });

        while(!workQueue.isEmpty()){
            Pair<State, State> current = workQueue.poll();
            Set<T> calculatedEntry = new HashSet<>(this.transferFunction.apply(currentMfp.get(current.a.getLabel()), current.a, nodes));
            boolean modified;

            if(currentMfp.get(current.b.getLabel()) == null){
                modified = true;
                currentMfp.put(current.b.getLabel(), new HashSet<>(calculatedEntry));
            }else{
                if(this.joinType == JoinType.MAY){
                    modified = currentMfp.get(current.b.getLabel()).addAll(calculatedEntry);
                }else{
                    modified = currentMfp.get(current.b.getLabel()).retainAll(calculatedEntry);
                }
            }

            if(modified){
                current.b.getChildren().forEach(s -> {
                    s.getChildren().forEach(c -> workQueue.add(new Pair<>(s, c)));
                });
            }
        }
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }


    public Comparison getComparison() {
        return comparison;
    }

    public void setComparison(Comparison comparison) {
        this.comparison = comparison;
    }

    public T getBottom() {
        return bottom;
    }

    public void setBottom(T bottom) {
        this.bottom = bottom;
    }

    public ITransferFunction<Set<T>> getTransferFunction() {
        return transferFunction;
    }

    public void setTransferFunction(ITransferFunction<Set<T>> transferFunction) {
        this.transferFunction = transferFunction;
    }
}
