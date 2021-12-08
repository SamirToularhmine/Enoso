package analyse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MonotoneFramework<T> {
    private JoinType joinType;
    private Flow flow;
    private Set<T> domain;
    private Comparison comparison;
    private T bottom;
    private Set<T> iota;

    public MonotoneFramework(JoinType joinType, Flow flow, Comparison comparison, T bottom, Set<T> iota) {
        this.joinType = joinType;
        this.flow = flow;
        this.domain = new HashSet<>();
        this.domain.addAll(iota);
        this.comparison = comparison;
        this.bottom = bottom;
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
