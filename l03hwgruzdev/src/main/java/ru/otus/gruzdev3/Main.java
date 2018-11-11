package ru.otus.gruzdev3;

import java.util.ArrayList;

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

        myArray.forEach(element -> System.out.println("forEach is ok ->" + element));
        System.out.println("Array before removing ->" + myArray.size());
        System.out.println("Is remove is ok -> " + myArray.remove("2"));

        System.out.println("Array after removing ->" + myArray.size());
    }

    private static void printLengthSize(MyArrayList<String> myArray) {
        System.out.println("Length of array under MyList ->" + myArray.toArray().length);
        System.out.println("Size is ->" + myArray.size());
    }
}
