package MementoATM;

public interface Originator {

    public void setState(State state);

    public String getState();

    public Memento saveState();

    public void restoreState(Memento memento);
}
