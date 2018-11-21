package ru.otus.l07hwgruzdev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args){

       CommonATM atm = new CommonATM(new CashBox(Arrays.asList(100, 500, 1000)));
       atm.putCash(100, 100);
       atm.putCash(500, 10);
       atm.putCash(1000, 5);

       String acc1 = "Андрей";
       atm.initAccount(acc1);

       atm.enterAccount(acc1);

       atm.setMoney(1000, 10);
       atm.howMatch();
       atm.getMoney(1700);
       atm.getMoney(1222);

    }
}
