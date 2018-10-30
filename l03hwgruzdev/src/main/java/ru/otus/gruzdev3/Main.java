package ru.otus.gruzdev3;

import java.util.ArrayList;

public class Main {

    static public void main(String[] args){
        MyArrayList<String> myArray = new MyArrayList<>();
        String word = "Hello world, Hello World";
        myArray.add("Hello");
        for (int i = 0; i < word.length(); i++){
            myArray.add(String.valueOf(word.toCharArray()[i]));
        }
        System.out.println(myArray.get(11));
    }
}
