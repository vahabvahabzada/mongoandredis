package com.vpro.mongo1.mappers;

import com.vpro.mongo1.dtos.CarDto;
import com.vpro.mongo1.entities.Car;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class CarMapper {
    public CarDto entityToDto(Car car){
        return new CarDto(car.getId(),car.getBrand(),car.getModel(),car.getPrice(),car.getShipDate());
    }

    public Car dtoToEntity(CarDto carDto){
        Car car=new Car();
        if(carDto.getId()!=null){
            car.setId(carDto.getId());
        }
        car.setId(carDto.getId());
        car.setModel(carDto.getModel());
        car.setBrand(carDto.getBrand());
        car.setPrice(carDto.getPrice());
        car.setShipDate(LocalDate.now());
        return car;
    }
}
