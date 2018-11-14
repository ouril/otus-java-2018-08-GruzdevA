package ru.otus.gruzdev3;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    static public void main(String[] args){
        MyArrayList<String> myArray = new MyArrayList<>();

        printLengthSize(myArray);

        String word = "12345678987654321";

        myArray.add("0");

        for (int i = 0; i < word.length(); i++){
            myArray.add(String.valueOf(word.toCharArray()[i]));
        }

        printLengthSize(myArray);

        ArrayList<String> array2 = new ArrayList<>();

        array2.add("8");
        array2.add("4");


        myArray.forEach(element -> System.out.println("forEach is ok -> " + element));
        Iterator<String> itr = myArray.iterator();
        while(itr.hasNext()){
            System.out.println("Iterator onNext result -> " + itr.next());
        }
        System.out.println("Array before removing -> " + myArray.size());
        System.out.println("Is remove is ok -> " + myArray.remove("2"));

        System.out.println("Array after removing -> " + myArray.size());

        myArray.retainAll(array2);
        myArray.forEach(obj -> System.out.println("After retainAll -> " + obj));

    }

    private static void printLengthSize(MyArrayList<String> myArray) {
        System.out.println("Length of array under MyList ->" + myArray.toArray().length);
        System.out.println("Size is ->" + myArray.size());
    }


}
