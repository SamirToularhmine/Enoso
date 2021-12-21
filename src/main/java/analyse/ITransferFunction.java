package analyse;

import java.util.Set;

public interface ITransferFunction<T> {

    T apply(State state, Set<State> flow);
}
