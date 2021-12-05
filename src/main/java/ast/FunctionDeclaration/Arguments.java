package ast.FunctionDeclaration;

import ast.type.Type;

import java.util.List;

public class Arguments {
    private Type type;
    private String identifier;

    public Arguments(Type type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
