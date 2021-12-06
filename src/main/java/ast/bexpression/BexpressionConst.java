package ast.bexpression;

import ast.Position;
import ast.Visitor;

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

        public boolean isValue() {
                return value;
        }

        public void setValue(boolean value) {
                this.value = value;
        }


}
