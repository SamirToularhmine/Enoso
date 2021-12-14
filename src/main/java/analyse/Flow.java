package analyse;

import java.util.ArrayList;
import java.util.List;

public class Flow {
    private List<State> head;
    private List<State> finals;

    public List<State> getHead() {
        return head;
    }

    public void setHead(List<State> head) {
        this.head = head;
    }

    public int getSize(){
        return 0;
        //Todo
    }

    public List<State> getFinals() {
        return finals;
    }

    public void setFinals(List<State> finals) {
        this.finals = finals;
    }

    public void reverseFlow(){
//        List<State> originalHead = head;
//        List<State> newHead = new ArrayList<>();
//        for(int i = 0; i < this.head.size(); i++){
//            newHead.add(head.get(i).getLastChildren());
//        }
//        this.head = newHead;
//        for(int i = 0; i < this.head.size(); i ++){
//
//        }
//
//        this.head = newHead;



    }
}
