package ru.otus.l07hwgruzdev;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CashBox {

    final private ArrayList<Integer> faceValuesList;
    private HashMap<Integer, Integer> faceValues = new HashMap<>();

    public CashBox(ArrayList<Integer> faceValuesList) {
        this.faceValuesList = faceValuesList;
        faceValuesList.forEach(i -> faceValues.put(i, 0));
    }

    public void putCash(Integer faceValue, int count){
        if (faceValues.containsKey(faceValue) && count > 0) {
            faceValues.put(faceValue, faceValues.get(faceValue) + count);
        }
    }

    private int getTotalSum(){
       return faceValuesList.stream().mapToInt(faceValue -> faceValues.get(faceValue)).sum();
    }


    public HashMap<Integer, Integer> getCash(int summa){
        List<Integer> listValues = faceValuesList;
        Collections.sort(listValues);
        Collections.reverse(listValues);
        int reminder = summa;
        HashMap<Integer, Integer> cash = new HashMap<>();
        if (summa <= getTotalSum() && summa % Collections.min(faceValuesList) == 0) {
            for (Integer faceValue : listValues){
                if(summa > faceValue && faceValues.get(faceValue) > 0){
                    // TODO finish this


                }
            }


        }
        return cash;
    }

}
