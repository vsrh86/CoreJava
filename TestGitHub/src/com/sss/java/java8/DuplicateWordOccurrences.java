package com.sss.java.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateWordOccurrences {
    public static void main(String[] args) {
        //Input string
        String inputstring = "This is a sample string. It contains some sample words, and some repeated words.";
        System.out.println(inputstring);
        Map<String, Long> occurrences = findoccurrences(inputstring);
        occurrences.forEach((word, count) -> System.out.println(word + " : " + count));
        System.out.println("Sorting================");
        Map<String, Long> sortoccurrences = findsortoccurrences(inputstring);
        sortoccurrences.forEach((word, count) -> System.out.println(word + " : " + count));

    }

    private static Map<String, Long> findsortoccurrences(String inputstring) {

        String[] words = inputstring.trim().replaceAll("[,.]", " ").toLowerCase().split(" ");
        return Arrays.stream(words).collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

    }

    public static Map<String, Long> findoccurrences(String str) {
        String[] st = str.replaceAll("[.,]", "").toLowerCase().split(" ");
        return Arrays.stream(st).collect(Collectors.groupingBy(i -> i, Collectors.counting()));

    }

}
