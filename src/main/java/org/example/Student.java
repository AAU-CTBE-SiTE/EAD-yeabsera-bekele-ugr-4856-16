package org.example;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int age;

    public Student() {
        System.out.println("Empty Constructor...");
    }
}