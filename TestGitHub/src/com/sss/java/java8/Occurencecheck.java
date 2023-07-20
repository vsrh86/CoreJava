package com.sss.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Occurencecheck {

    public static void main(String[] args) {

        List<String> inputlist= Arrays.asList("This","this","is","is","done","by","Saket","Saket");

        Map<String,Long> occurrence=inputlist.stream().collect(Collectors.groupingBy(i->i,Collectors.counting()));

        System.out.println("occurrence"+occurrence);
    }
}
