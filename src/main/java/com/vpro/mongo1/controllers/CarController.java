package com.vpro.mongo1.controllers;

import com.vpro.mongo1.dtos.CarDto;
import com.vpro.mongo1.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    private CarService carService;
    public CarController(CarService carService){
        this.carService=carService;
    }
    @PostMapping("/save")
    public ResponseEntity<CarDto> save(CarDto carDto){
        return new ResponseEntity<>(carService.save(carDto), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<CarDto>> getAll(){
        return new ResponseEntity<>(carService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get-newest")// get 10 newly added car
    public ResponseEntity<List<CarDto>> getNewest(){
        return new ResponseEntity<>(carService.getNewest(),HttpStatus.OK);
    }
}
