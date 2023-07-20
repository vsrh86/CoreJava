package com.sss.java.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Findevenoddnumber {
    public static void main(String[] args) {
        //even number
        List<Integer> numlist = Arrays.asList(2, 3, 4, 6, 8, 11, 13, 15);
        List<Integer> signlist = Arrays.asList(-2, -3, 4, 6, 8, -11, 13, -15);
                System.out.println("Even numbers===");
        numlist.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
        System.out.println("odd numbers===");
        numlist.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
        int sum = numlist.stream().filter(n -> n % 2 == 0).mapToInt(x -> x).sum();
        System.out.println("sum of even numbers===" + sum);
        int odd = numlist.stream().filter(n -> n % 2 != 0).mapToInt(x -> x).sum();
        System.out.println("sum of odd numbers===" + odd);
        System.out.println("negative numbers==>");
        signlist.stream().filter(n -> n < 0).forEach(System.out::println);
        System.out.println("positive numbers==>");
        signlist.stream().filter(n -> n > 0).forEach(System.out::println);

        int max=numlist.stream().sorted().max(Integer::
                compare).get();
        System.out.println("max number-->"+max);
    }
}
