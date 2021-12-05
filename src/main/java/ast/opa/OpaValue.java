package ast.opa;

import ast.Position;
import ast.Visitor;

public class OpaValue extends Opa {
    private String caracter;

    public OpaValue(Position position, String caracter) {
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
