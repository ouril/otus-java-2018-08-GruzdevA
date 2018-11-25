package ATM;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CashBox implements CashManager {

    final private List<Integer> faceValuesList;
    private HashMap<Integer, Integer> faceValues = new HashMap<>();

    public CashBox(List<Integer> faceValuesList) {
        this.faceValuesList = faceValuesList;
        faceValuesList.forEach(i -> faceValues.put(i, 0));
    }

    @Override
    public void putCash(Integer faceValue, int count){
        if (faceValues.containsKey(faceValue) && count > 0) {
            faceValues.put(faceValue, faceValues.get(faceValue) + count);
        }
    }

    @Override
    public int getTotalSum(){
       return faceValuesList.stream().mapToInt(faceValue -> faceValues.get(faceValue) * faceValue).sum();
    }

    @Override
    public HashMap<Integer, Integer> getCash(int summa) throws NoMoneyException{
        List<Integer> listValues = faceValuesList;
        Collections.sort(listValues);
        Collections.reverse(listValues);
        int reminder = summa;

        HashMap<Integer, Integer> cash = new HashMap<>();
        if (reminder <= getTotalSum() && reminder % Collections.min(faceValuesList) == 0) {
            for (Integer faceValue : listValues){
                int countOfFaceValueInAtm = faceValues.get(faceValue);
                if(reminder > faceValue &&  countOfFaceValueInAtm > 0){
                    int countOfFaceValue = reminder / faceValue;
                    if (countOfFaceValueInAtm >= countOfFaceValue){
                        try {
                            faceValues.put(faceValue, countOfFaceValueInAtm - countOfFaceValue);
                        } finally {
                            cash.put(faceValue, countOfFaceValue);
                            reminder -= faceValue * countOfFaceValue;
                        }
                    } else {
                        try {
                            faceValues.put(faceValue, 0);
                        } finally {
                            cash.put(faceValue, countOfFaceValueInAtm);
                            reminder -= faceValue * countOfFaceValueInAtm;
                        }
                    }


                }
            }
            return cash;

        } throw new NoMoneyException("Нет денег в кассе, требуте размена!!!");

    }

}
