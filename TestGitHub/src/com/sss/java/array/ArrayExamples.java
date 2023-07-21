package com.sss.java.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.stream.IntStream;

public class ArrayExamples {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 1, 4, 5, 6, 7, 8};
        Integer[] arr1 = {1, 2, -1, -2, -3, 4, 0, -1, 10};
        //Peak element to findout
        int peakElement = findPeakElement(arr);
        System.out.println("peakElement=" + peakElement);
        //Find the sum of integers
        double sumofvalues = sumofvalues(arr1);
        System.out.println("sumofvalues==" + sumofvalues);
    }

    public static int findPeakElement(Integer[] arr) {
        return IntStream.range(1, arr.length - 1)
                .filter(i -> arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                .mapToObj(i -> arr[i])
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No peak element found."));
    }

    public static double sumofvalues(Integer[] arr1) {
        List<Integer> arrlist = Arrays.asList(arr1);
        return arrlist.stream().filter(i -> i > 0).mapToInt(n -> n).sum();
    }


}
