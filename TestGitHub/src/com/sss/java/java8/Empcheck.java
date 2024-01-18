package com.sss.java.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Empcheck {
    public static void main(String[] args) {
        List<Employee> emplist = new ArrayList<Employee>();
        emplist.add(new Employee("kumar", 101));
        emplist.add(new Employee("abay", 100));
        emplist.add(new Employee("vinay", 102));
        emplist.sort(Comparator.comparing(Employee::getName));
        emplist.forEach(emp->System.out.println(emp.getName()+"-"+emp.getId()));

    }
}
