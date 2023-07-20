package com.sss.java.array;

import java.util.List;

public class Person {
    String fname;
    String lname;
    List<ArrayExamples> alist;

    public Person(String fname, String lname, List<ArrayExamples> alist) {
        this.fname = fname;
        this.lname = lname;
        this.alist = alist;
    }

    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

}
