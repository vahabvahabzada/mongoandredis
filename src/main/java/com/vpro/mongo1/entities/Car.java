package com.vpro.mongo1.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collation = "Car")
public class Car {
    @Id
    private  Long id;

    private String brand;
    private  String model;
    private  Integer price;
    private LocalDate shipDate;
}
