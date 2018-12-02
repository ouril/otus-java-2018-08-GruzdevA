package MementoATM;

import ATM.CashBox;
import ATM.CashManager;

public interface Originator {

    public void setState(CashManager state);

    public CashManager getState();

    public Memento saveState();

    public void restoreState(Memento memento);
}
