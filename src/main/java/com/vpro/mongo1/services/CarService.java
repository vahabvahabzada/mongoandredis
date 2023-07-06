package com.vpro.mongo1.services;

import com.vpro.mongo1.dtos.CarDto;
import com.vpro.mongo1.mappers.CarMapper;
import com.vpro.mongo1.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    public CarService(final CarRepository carRepository,final CarMapper carMapper){
        this.carRepository=carRepository;
        this.carMapper=carMapper;
    }
    public CarDto save(CarDto carDto){
        return carMapper.entityToDto(carRepository.save(carMapper.dtoToEntity(carDto)));
    }

    public List<CarDto> getAll(){
        return carRepository.findAll().stream().map(car->carMapper.entityToDto(car)).toList();
    }

    public List<CarDto> getNewest(){// get 10 newly added card
        return null;// helelik yazmisam
    }
}
