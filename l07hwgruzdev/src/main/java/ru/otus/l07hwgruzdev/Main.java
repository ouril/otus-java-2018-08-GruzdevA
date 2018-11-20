package ru.otus.l07hwgruzdev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args){

        ArrayList<Integer> listOfCurrensy = new ArrayList<>();
        listOfCurrensy.add(100);
        listOfCurrensy.add(500);
        listOfCurrensy.add(1000);
        CashBox cash = new CashBox(listOfCurrensy);
        cash.putCash(100, 12);
        cash.putCash(1000, 10);
        cash.putCash(500, 2);
        System.out.println(cash.getTotalSum());

        HashMap<Integer, Integer> faceVulue = null;
        try {
            faceVulue = cash.getCash(1701);
            faceVulue.forEach((key, value) -> {
                System.out.println(key + " -> " + value);
            });
        } catch (NoMoneyException e) {
            System.out.println("No money((((");
        }

        System.out.println(cash.getTotalSum());
    }
}
