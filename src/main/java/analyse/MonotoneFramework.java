package analyse;

import ast.VisitorPrint;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class MonotoneFramework<T> {
    private JoinType joinType;
    private Flow flow;
    private Set<T> domain;
    private Comparison comparison;
    private T bottom;
    private Set<T> iota;
    private boolean reversed;
    private IAnalysis<Set<T>> analysis;

    public MonotoneFramework(JoinType joinType, Flow flow, Comparison comparison, T bottom, Set<T> iota, boolean reversed, IAnalysis<Set<T>> analysis) {
        this.joinType = joinType;
        this.flow = flow;
        this.iota = new HashSet<>(iota);
        this.domain = new HashSet<>();
        this.domain.addAll(iota);
        this.comparison = comparison;
        this.bottom = bottom;
        this.reversed = reversed;
        this.analysis = analysis;
    }

    public void analyse() {
        // Analyse MFP
        if (this.reversed && !flow.isBackward())
            flow.reverseFlow();

        Set<State> entries = this.flow.getHead();
        Set<State> nodes = this.flow.getAllNodes();
        Map<Integer, Set<T>> currentMfp = new HashMap<>();
        Queue<Pair<State, State>> workQueue = new ArrayDeque<>();

        nodes.forEach(n -> currentMfp.put(n.getLabel(), null));
        entries.forEach(s -> {
            currentMfp.put(s.getLabel(), new HashSet<>(this.iota));
            s.getNext().forEach(c -> workQueue.add(new Pair<>(s, c)));
        });

        System.out.println();
        while(!workQueue.isEmpty()){
            Pair<State, State> current = workQueue.poll();
            Set<T> result = this.analysis.apply(currentMfp.get(current.a.getLabel()), current.a);
            System.out.println("On traite l'arc : (" + (current.a.getLabel() + 0) + "," + (current.b.getLabel() + 0) + ")" + " -> " + this.analysis.print(result));
            Set<T> calculatedEntry = new HashSet<>(result);
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
                current.b.getNext().forEach(s -> {
                    workQueue.add(new Pair<>(current.b, s));
                });
            }
        }

        Map<Integer, Set<T>> currentMfpExit = new HashMap<>(currentMfp);
        for(Integer key : currentMfpExit.keySet()){
            Set<T> entry = currentMfpExit.get(key);
            currentMfpExit.put(key, this.analysis.apply(entry, this.flow.findByLabel(key)));
        }

        System.out.println();
        VisitorPrint visitorPrint = new VisitorPrint();

        for(Integer i : currentMfp.keySet()){
            if(currentMfp.get(i) != null){
                Set<T> res = currentMfp.get(i);
                System.out.print("Entry [" + this.flow.findByLabel(i).getInstruction().accept(visitorPrint) + "] (" + (i+1) +") = ");

                if(res == null || res.size() == 0){
                    System.out.println("∅");
                }else{
                    System.out.println("{ " + this.analysis.print(res) + " }");
                }
            }

            if(currentMfpExit.get(i) != null){
                Set<T> res = currentMfpExit.get(i);

                System.out.print("Exit [" + this.flow.findByLabel(i).getInstruction().accept(visitorPrint) + "] (" + (i+1) +")  = ");
                if(res == null || res.size() == 0){
                    System.out.println("∅");
                }else{
                    System.out.println("{ " + this.analysis.print(res) + " }");
                }
            }

            System.out.println();
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
}
