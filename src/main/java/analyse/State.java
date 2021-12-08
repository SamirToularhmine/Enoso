package analyse;

import ast.Node;

import java.util.*;

public class State {
    private Node instruction;
    private List<State> children;
    private List<State> parents;
    private boolean isReversed;
    private int label;

    public State(Node instruction, int label, List<State> children, List<State> parents) {
        this.instruction = instruction;
        this.label = label;
        this.children = children;
        this.parents = parents;
        this.isReversed = false;
    }

    public Node getInstruction() {
        return instruction;
    }

    public void setInstruction(Node instruction) {
        this.instruction = instruction;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public List<State> getNext() {
        if (isReversed) {
            return this.parents;
        } else {
            return this.children;
        }
    }

    public List<State> getParents() {
        if(isReversed){
            return this.children;
        }else{
            return this.parents;
        }
    }

    public void setChildren(List<State> children) {
        this.children = children;
    }


    public boolean isReversed() {
        return isReversed;
    }

    public void setReversed(boolean reversed) {
        isReversed = reversed;
    }

    public Set<State> getLastChildren(List<Integer> alreadySeen) {
        alreadySeen.add(this.label);
        Set<State> res = new HashSet<>();
        for (State state : this.getNext()) {
            if(state.getLabel() == -1){
                res.add(this);
            }else {
                for (State next : this.getNext()) {
                    if(!alreadySeen.contains(next.getLabel())){
                        res.addAll(next.getLastChildren(alreadySeen));
                    }
                }
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "State{" +
                "instruction=" + instruction +
                ", isReversed=" + isReversed +
                " Next="+ this.getNext().stream().map(em->String.valueOf(em.getLabel()+" ")).reduce("",String::concat) +
                " Parents="+ this.getParents().stream().map(em->String.valueOf(em.getLabel()+" ")).reduce("",String::concat) +
                ", label=" + label +
                '}';
    }

    public void setParents(List<State> parents) {
        this.parents = parents;
    }

    public Set<State> getAllNodes(ArrayList<Integer> alreadySeen) {
        alreadySeen.add(this.label);
        Set<State> res = new HashSet<>();
        if (this.label != -1){
            res.add(this);
        }
        for (State state : this.getNext()) {
            if (!alreadySeen.contains(state.getLabel())){
                res.addAll(state.getAllNodes(alreadySeen));
            }
        }
        return res;
    }
}
