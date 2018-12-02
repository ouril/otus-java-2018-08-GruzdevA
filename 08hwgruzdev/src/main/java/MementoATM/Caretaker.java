package MementoATM;

import ATM.CommonATM;

public interface Caretaker {
    public Memento getMemento();

    public void setMemento(Memento memento, CommonATM atm);
}
