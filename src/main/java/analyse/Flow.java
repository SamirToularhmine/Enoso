package analyse;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Flow {
    private List<State> head;

    public List<State> getHead() {
        return head;
    }

    public void setHead(List<State> head) {
        this.head = head;
    }

    public int getSize(){
        return getAllNodes().size();
    }

    public Set<State> getAllNodes(){
        Set<State> allNodes = new HashSet<>();
        for (State state : this.head) {
            allNodes.addAll(state.getAllNodes(new ArrayList<Integer>()));
        }
        return allNodes;
    }

    public void reverseFlow(){
        boolean newFlow = !this.head.get(0).isReversed();
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
        this.head = List.copyOf(newHeads); //Finalement, on change l'attribut head
        for (State state : this.head) {
            state.setFinal(false);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Print du flow : \nEntry(ies) : ");
        for (State state : this.getHead()) {
            res.append(state.getLabel()+" ");
        }
        res.append("\n");
        for (State allNode : this.getAllNodes()) {
            res.append(allNode + "\n");
        }
        return res.toString();
    }
    public void toDot(String name){
        String str = "digraph G {\n";
        BufferedWriter writer = null;
        try {
            for (State allNode : this.getAllNodes()) {
                if(allNode.isFinal()){
                    str += "{\n"+allNode.getLabel()+" [shape = doublecircle]\n}\n";
                }
                if(this.head.contains(allNode)){
                    str += "{\n"+allNode.getLabel()+" [style = filled fillcolor = green]\n}\n";
                }
                if(allNode.getNext().size() > 0){
                    str += allNode.getLabel() + " -> { ";
                    for (int i = 0; i < allNode.getNext().size() - 1; i++) {
                        str += allNode.getNext().get(i).getLabel() + ", ";
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
}
