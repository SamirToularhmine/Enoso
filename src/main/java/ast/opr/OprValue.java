package ast.opr;

import ast.Position;
import ast.Visitor;

public class OprValue extends Opr {
    private String caracter;

    public OprValue(Position position, String caracter) {
        this.position = position;
        this.caracter = caracter;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public String getCaracter() {
        return caracter;
    }

    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }
}
