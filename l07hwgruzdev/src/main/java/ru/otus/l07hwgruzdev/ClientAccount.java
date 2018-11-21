package ru.otus.l07hwgruzdev;

import java.util.HashMap;

public class ClientAccount extends Account implements CashManager{
    final private CashManager cashManager;
    private int account = 0;

    public ClientAccount(CashManager cashManager, String name) {
        super(name);
        this.cashManager = cashManager;
    }

    @Override
    public HashMap<Integer, Integer> getCash(int summa) throws NoMoneyException {
        if (summa <= account){
            account -= summa;
            return cashManager.getCash(summa);
        }
        throw new NoMoneyException("У вас недостаточно средств! Мухахаха!!!");
    }

    @Override
    public void putCash(Integer faceValue, int count) {
        account += faceValue * count;
        cashManager.putCash(faceValue, count);
    }

    @Override
    public int getTotalSum() {
        return account;
    }
}
