package org.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component // tells spring to manage this class as a spring
public class Address {

    @Value("Addis")
    private String city;

    @Value("Ethiopia")
    private String country;
}