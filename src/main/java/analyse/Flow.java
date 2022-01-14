package analyse;


import ast.VisitorPrint;
import utils.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;
import java.util.stream.Collectors;

public class Flow implements Cloneable {
    private Set<State> head;
    private final Set<State> finals;

    public Flow() {
        this.head = new HashSet<>();
        this.finals = new HashSet<>();
    }

    public Set<State> getHead() {
        return head;
    }

    public int getSize() {
        return getAllNodes().size();
    }

    public Set<State> getFinals() {
        return finals;
    }

    public Set<State> getAllNodes() {
        Set<State> allNodes = new HashSet<>();

        for (State state : this.head) {
            allNodes.addAll(state.getAllNodes(new ArrayList<>()));
        }

        return allNodes;
    }

    public State findByLabel(int label){
        List<State> states = this.getAllNodes().stream().filter(s -> s.getLabel() == label).collect(Collectors.toList());

        if(states.size() > 0){
            return states.get(0);
        }

        return null;
    }

    public void reverseFlow() {
        boolean newFlow = !this.head.iterator().next().isReversed();
        Set<State> newHeads = new HashSet<>();

        for (State state : this.head) { //Pour chacuns des points d'entrés actuels
            newHeads.addAll(state.getLastChildren(new ArrayList<>())); //On récupère ses feuilles (derniers enfants)
        }

        for (State allNode : this.getAllNodes()) {
            allNode.setReversed(newFlow);
        }

        for (State state : this.head) {
            state.setFinal(true);
        }

        this.head = Set.copyOf(newHeads); //Finalement, on change l'attribut head

        for (State state : this.head) {
            state.setFinal(false);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Print du flow : \nEntry(ies) : ");
        for (State state : this.getHead()) {
            res.append(state.getLabel() + " ");
        }

        res.append("\n");

        for (State allNode : this.getAllNodes()) {
            res.append(allNode + "\n");
        }

        return res.toString();
    }

    public void toDot(String name) {
        String str = "digraph G {\n";
        str += "n0 [label= \"\", shape=none,height=.0,width=.0] \n";
        BufferedWriter writer = null;
        VisitorPrint visitorPrint = new VisitorPrint();

        try {
            for (State allNode : this.getAllNodes()) {
                String labelName = " < [" + allNode.getPrefix() + " " + ((String) allNode.getInstruction().accept(visitorPrint)).replaceAll("<", "&lt;").replaceAll(">", "&gt;") + "]<SUP>"+ allNode.getLabel() +"</SUP>  >]";
                if (allNode.isFinal()) {
                    str += "{\n" + allNode.getLabel() + " [shape = doublecircle, style = filled fillcolor = \""+ Utils.formatColor(allNode.getColor()) +"\", label= " + labelName + "\n}\n";
                }
                if (this.head.contains(allNode)) {
                    str += "{\n n0 -> {" + allNode.getLabel() + " [ style = filled fillcolor = \""+ Utils.formatColor(allNode.getColor()) +"\", label = "+ labelName +" }\n}\n";
                }
                if (allNode.getNext().size() > 0) {
                    str += "{"+ allNode.getLabel() + "[style = filled fillcolor = \""+ Utils.formatColor(allNode.getColor()) +"\", label= " + labelName + "} \n";
                    str += allNode.getLabel() +" -> { ";
                    for (int i = 0; i < allNode.getNext().size() - 1; i++) {
                        str += allNode.getNext().get(i).getLabel() + " ";
                    }
                    str += allNode.getNext().get(allNode.getNext().size() - 1).getLabel() + " }";
                }
                str += "\n";
            }
            writer = new BufferedWriter(new FileWriter(name));
            str += "}";
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void prepare() {
        Queue<State> aTraiter = new ArrayDeque<>(this.head);
        Set<State> processed = new HashSet<>();
        int label = 1;

        while (!aTraiter.isEmpty()) {
            State parent = aTraiter.poll();
            if (!processed.contains(parent)) {
                processed.add(parent);
                parent.setLabel(label++);
                for (State child : parent.getChildren()) {
                    child.getParents().add(parent);
                    if (child.getLabel() == -1)
                        aTraiter.add(child);
                }
            }
        }
        this.finals.forEach(state -> state.setFinal(true));
    }

    @Override
    public Flow clone() {
        try {
            return (Flow)super.clone();
        } catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        return null;
    }
}
