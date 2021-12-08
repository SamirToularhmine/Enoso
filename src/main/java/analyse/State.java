package analyse;

import ast.Node;

import java.util.List;

public class State {
    private Node instruction;
    private int label;
    private List<State> children;

    public State(Node instruction, int label, List<State> children) {
        this.instruction = instruction;
        this.label = label;
        this.children = children;
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

    public List<State> getChildren() {
        return children;
    }

    public void setChildren(List<State> children) {
        this.children = children;
    }
}
