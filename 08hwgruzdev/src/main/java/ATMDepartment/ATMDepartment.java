package ATMDepartment;

import ATM.CommonATM;
import MementoATM.Caretaker;
import MementoATM.Memento;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ATMDepartment implements DepartmentVisitor, Caretaker {

    private HashMap<CommonATM, Memento> listATM = new HashMap<>();

    @Override
    public void visitSetBasicState(CommonATM terminal) {

        terminal.setState(listATM.get(terminal).getState());
    }

    @Override
    public int visitGetValueAtm(CommonATM terminal) {
        return terminal.getState().getTotalSum();
    }

    void addATM(CommonATM newATM){
        setMemento(newATM.saveState(), newATM);

    }

    int getFullSummOfMoney(){
        int fullSumm = 0;
        for (CommonATM atm : listATM.keySet()){
            fullSumm += atm.acceptGetValue(this);
        }
        return fullSumm;
    }

    void returnBasicState(){
        for (CommonATM atm : listATM.keySet()) {
            atm.acceptSetBasicState(this);
        }
    }

    @Override
    public Memento getMemento() {
        return null;
    }

    @Override
    public void setMemento(Memento memento, CommonATM atm) {
        listATM.put(atm, memento);
    }
}
