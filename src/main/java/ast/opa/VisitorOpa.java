package ast.opa;

import ast.block.BlockStatement;

public interface VisitorOpa<T> {
    T visit(OpaValue opaDivision);


    //TODO à supprimer ainsi que les classes ???
    T visit(OpaMinus opaMinus);
    T visit(OpaMultiplication opaMultiplication);
    T visit(OpaDivision opaDivision);
    T visit(OpaPlus opaPlus);

}
