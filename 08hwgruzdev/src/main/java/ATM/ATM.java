package ATM;

public abstract class ATM {
    protected CashManager cashBox;

    protected ATM(CashManager cashBox) {
        this.cashBox = cashBox;
    }

    abstract boolean getMoney(int summa);

    abstract void setMoney(Integer faceValue, int count);

    abstract boolean initAccount(String name);

    abstract boolean enterAccount(String name);

    abstract void exit();


}
