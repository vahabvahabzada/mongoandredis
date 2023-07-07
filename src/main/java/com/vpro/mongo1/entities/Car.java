package com.vpro.mongo1.entities;

import lombok.AllArgsConstructor;
//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Data
//@Builder
@Document(collection = "car")
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {
    @Id
    private String id;

    private String brand;

    private  String model;

    private  Integer price;

    private LocalDate shipDate;
}
