package ast;

import java.util.List;

public class Declaration extends Node{

    private String procName;
    private List<String> arguments;


    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
