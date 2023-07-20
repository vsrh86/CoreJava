package com.sss.java.java8;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCheck {
    public static void main(String[] args) {
        String str = "Hello, World!";
        Map<Character, Long> duplicateChars = str.replaceAll("[.,!]","").chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Duplicate characters:");
        duplicateChars.forEach((character, count) -> System.out.println(character + ": " + count));
    }
}






