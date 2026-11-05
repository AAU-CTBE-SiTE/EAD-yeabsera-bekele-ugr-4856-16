package org.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Student {

    private int id;
    private String name;
    private int age;
    private Address address;

    @Autowired // tells spring to resolve the constructor dependency
    public Student(
            @Value("101") int id,
            @Value("John Doe") String name,
            @Value("20") int age,
            Address address) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
}