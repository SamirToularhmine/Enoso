package ast.bexpression;

import ast.Position;
import ast.Visitor;
import analyse.ITransferVisitor;

import java.util.Objects;

public class BexpressionConst extends Bexpression{
        private boolean value;

        public BexpressionConst(Position position, boolean value) {
                this.value = value;
                this.position = position;
        }

        @Override
        public Object accept(Visitor visitor) {
                return visitor.visit(this);
        }

        @Override
        public Object accept(ITransferVisitor visitor) {
                return visitor.visit(this);
        }

        public boolean isValue() {
                return value;
        }

        public void setValue(boolean value) {
                this.value = value;
        }

        @Override
        public int hashCode() {
                return Objects.hash(value);
        }
}
