package MementoATM;

import java.util.HashMap;
import java.util.Objects;

public class State {
    private final HashMap<Integer, Integer> money;

    public State(HashMap<Integer, Integer> money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(money, state.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
