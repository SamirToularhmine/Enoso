package ast.opa;

import ast.block.BlockStatement;

public interface VisitorOpa<T> {
    T visit(OpaDivision opaDivision);
    T visit(OpaMinus opaMinus);
    T visit(OpaMultiplication opaMultiplication);
    T visit(OpaPlus opaPlus);

}
