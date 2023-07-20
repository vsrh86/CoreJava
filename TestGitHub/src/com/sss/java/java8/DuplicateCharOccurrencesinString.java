package com.sss.java.java8;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCharOccurrencesinString {
    public static void main(String[] args) {

        String inputString = "Everyonesthere";
        char[] charArray = inputString.toCharArray();
        // Use Java 8 Streams to find character occurrences
        //new String
        /*        Map<Character, Long> occurrence = new String(charArray).chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/

        Map<Character, Long> occurrence = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        // Display the character occurrences
        occurrence.forEach((character, count) -> System.out.println(character + " : " + count));
    }
}



