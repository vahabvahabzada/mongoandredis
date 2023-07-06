package com.vpro.mongo1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CarDto {
    @Id
    private Long id;

    private String brand;
    private String model;
    private Integer price;
    private LocalDate shipDate;
}
