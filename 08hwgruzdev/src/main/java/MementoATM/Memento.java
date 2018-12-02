package MementoATM;

import ATM.CashBox;
import ATM.CashManager;

public class Memento {
    private final CashManager state;

    public String getIdATM() {
        return idATM;
    }

    private final String idATM;

    public Memento(CashManager state, String id) {
        this.state = state;
        idATM = id;
    }

    public CashManager getState() {
        return state;
    }
}
