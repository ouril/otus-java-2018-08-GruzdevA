package ATM;

import java.util.HashMap;

public interface CashManager {
    public HashMap<Integer, Integer> getCash(int summa) throws NoMoneyException;

    public void putCash(Integer faceValue, int count);

    public int getTotalSum();
}
