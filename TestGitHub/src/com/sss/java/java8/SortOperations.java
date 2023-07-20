package com.sss.java.java8;

import com.sss.java.java8.Employee;

import java.util.*;

public class SortOperations {
    public static void main(String[] args) {
        List<Employee> emplist= new ArrayList();
        emplist.add(new Employee("Aarya",1));
        emplist.add(new Employee("vinod",2));
        emplist.add(new Employee("surya",3));

        emplist.add(new Employee("Chary",4));
        System.out.println("Before sorting:");
        emplist.forEach(emp->System.out.println(emp.getName()+"-"+emp.getId()));
        System.out.println("After sorting:");
        emplist.sort(Comparator.comparing(Employee::getName));
        emplist.forEach(emp->System.out.println(emp.getName()+"-"+emp.getId()));
    }
}
