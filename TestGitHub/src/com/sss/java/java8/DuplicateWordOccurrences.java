package com.sss.java.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateWordOccurrences {
    public static void main(String[] args) {
        //Input string
        String inputstring="This is a sample string. It contains some sample words, and some repeated words.";
        System.out.println(inputstring);
        Map<String,Long>  occurrences= findoccurrences(inputstring);
        occurrences.forEach((word, count) -> System.out.println(word + " : " + count));
    }
    public static Map<String,Long> findoccurrences(String str){

        String[] st=str.replaceAll("[.,]","").toLowerCase().split(" ");
        return Arrays.stream(st).collect(Collectors.groupingBy(i->i,Collectors.counting()));
    }
}
