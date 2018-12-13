package ru.otus.I01hwgruzdev;

import com.google.common.collect.Lists;

import java.util.List;


public class Main {
    public static void main(String[] args){
        List<String> langList = Lists.newArrayList("python", "java", "js");
        for (String lang: langList) {
            System.out.println(lang);
        }
    }
}
