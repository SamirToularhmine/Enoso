package ast.opa;

import ast.Position;
import ast.Visitor;

import java.util.Objects;

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

    public int hashCode() {
        return Objects.hash(caracter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpaValue opaValue = (OpaValue) o;
        return caracter.equals(opaValue.caracter);
    }
}
