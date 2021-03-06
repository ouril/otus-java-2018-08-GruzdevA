package ru.otus.l07hwgruzdev;

import java.util.*;

public class CommonATM extends ATM {
    private Set<ClientAccount> accounts = new HashSet<>();
    private ClientAccount currentAccount = null;

    CommonATM(CashManager cashBox) {
        super(cashBox);
    }

    @Override
    boolean getMoney(int summa) {
        try {
            HashMap<Integer, Integer> money = currentAccount.getCash(summa);
            message(currentAccount.name, "выдано:");
            money.forEach((faceValue, count) -> {
                String faceValueMessage = new StringBuffer("Выдано : ")
                        .append(count)
                        .append(" по ")
                        .append(faceValue)
                        .toString();

                System.out.println(faceValueMessage);

            });
            howMatch();

            return true;
        } catch (NoMoneyException e) {
            message(currentAccount.name, e.getMessage());
            return false;
        }

    }

    @Override
    void setMoney(Integer faceValue, int count) {
            currentAccount.putCash(faceValue, count);
            howMatch();

    }

    @Override
    boolean initAccount(String name) {
        ClientAccount newAccount = new ClientAccount(this.cashBox, name);
        if(!accounts.contains(newAccount)) {
            accounts.add(newAccount);
            message(name, "Ваш аккаунт создан!");
            return true;
        }
        message(name, "Ваш аккаунт уже создан!");
        return false;
    }

    @Override
    boolean enterAccount(String name) {
        accounts.forEach(account -> {
            if (account.name.equals(name)) {
                currentAccount = account;
                message(name, "добрый день!");
            }
        });
        return false;
    }

    void howMatch(){
        message(currentAccount.name, String.valueOf(currentAccount.getTotalSum()));

    }

    public void putCash(Integer faceValue, int count){
        cashBox.putCash(faceValue, count);
    }

    private void message(String name, String msg) {
        String message = new StringBuffer("Уважаемый ")
                .append(name)
                .append(" ")
                .append(msg)
                .toString();
        System.out.println(message);
    }

    @Override
    void exit() {
        message(currentAccount.name, "до свиданья");
        currentAccount = null;

    }

}
