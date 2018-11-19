package ru.otus.l07hwgruzdev;

import java.util.HashMap;

public class ATM {
    private HashMap<ClientAccount, Integer> clientBase;
    final private ClientAccount clientSecurity;
    final private CashBox cashBox;


    public ATM(ClientAccount clientSecurity, CashBox cashBox) {
        this.clientSecurity = clientSecurity;
        this.cashBox = cashBox;
    }
}
