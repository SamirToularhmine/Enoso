package analyse;

import java.util.Set;

public interface ITransferFunction<T> {

    T apply(T currentValue, State state, Set<State> flow);
}
