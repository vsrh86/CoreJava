package com.sss.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Duplicateoccurrence {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 1, 2, 2, 5, 4, 5);
        Map<Integer, Long> occurrences = numbers.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
                 occurrences.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("<" + entry.getKey() + ", " + entry.getValue() + ">"));
    }
    }

