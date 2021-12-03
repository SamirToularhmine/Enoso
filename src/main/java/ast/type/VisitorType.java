package ast.type;


public interface VisitorType<T> {
    T visit(TypeTable typeTable);
    T visit(TypeType typeType);

}
