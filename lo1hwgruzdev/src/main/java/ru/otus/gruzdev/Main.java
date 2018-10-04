package ru.otus.gruzdev;

import com.google.common.collect.Lists;

import java.util.List;

public class Main {
    public static void main(String[] args){

        List<String> listOfLangs = Lists.newArrayList("python", "java", "js");

        listOfLangs.forEach(s -> System.out.println(s));
    }
}
