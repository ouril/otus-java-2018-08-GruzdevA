package MementoATM;

import ATM.CashBox;
import ATM.CashManager;

public class Memento {
    private final CashManager state;

    public Memento(CashManager state) {
        this.state = state;
    }

    public CashManager getState() {
        return state;
    }
}
