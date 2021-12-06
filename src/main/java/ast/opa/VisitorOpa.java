package ast.opa;

import ast.block.BlockStatement;

public interface VisitorOpa<T> {
    T visit(OpaValue opaDivision);
}
