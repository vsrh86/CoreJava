package com.sss.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAverage {
    public static void main(String[] args) {
             //
              List<Integer> numlist= Arrays.asList(10,20,30,40,50);
              List<Integer> greaterlist= numlist.stream().map(n->n*n).filter(i->i>500).collect(Collectors.toList());
              var average=  greaterlist.stream().mapToInt(Integer::intValue).average();
              System.out.println(average);
    }
}
