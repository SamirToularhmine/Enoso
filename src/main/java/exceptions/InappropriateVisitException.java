package exceptions;

import ast.Node;

public class InappropriateVisitException extends RuntimeException {

    public InappropriateVisitException(Node node) {
        super("Could not visit " + node);
    }
}
