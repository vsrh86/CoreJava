package com.sss.java.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayExamples {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 6, 7, 8};
        List<Integer> peaklist = Arrays.asList(1, 2, 3, 1, 4, 5, 6, 7, 8);
        int peakElement = findPeakElement(arr);

        System.out.println("Peak Element: " + peakElement);
    }

    public static int findPeakElement(int[] arr) {
        return IntStream.range(1, arr.length - 1)
                .filter(i -> arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                .mapToObj(i -> arr[i])
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No peak element found."));
    }

}
