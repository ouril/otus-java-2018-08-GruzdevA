package ru.otus.gruzdev3;

import java.util.ArrayList;

public class Main {

    static public void main(String[] args){
        MyArrayList<String> myArray = new MyArrayList<>();
        String word = "123456789";
        myArray.add("Hello");
        for (int i = 0; i < word.length(); i++){
            myArray.add(String.valueOf(word.toCharArray()[i]));
        }
        System.out.println(myArray.get(5));
        System.out.println(myArray.remove("2"));

        System.out.println(myArray.get(5));
    }
}
