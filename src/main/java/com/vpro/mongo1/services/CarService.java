package com.vpro.mongo1.services;

import com.vpro.mongo1.dtos.CarDto;
import com.vpro.mongo1.entities.Car;
import com.vpro.mongo1.mappers.CarMapper;
import com.vpro.mongo1.repositories.CarRedisRepository;
import com.vpro.mongo1.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final CarRedisRepository carRedisRepository;
    public CarService(final CarRepository carRepository,final CarMapper carMapper,final CarRedisRepository carRedisRepository){
        this.carRepository=carRepository;
        this.carMapper=carMapper;
        this.carRedisRepository=carRedisRepository;
    }
    public CarDto save(CarDto carDto){
        addLastTenToCache();
        return carMapper.entityToDto(carRepository.save(carMapper.dtoToEntity(carDto)));
    }

    public List<CarDto> getAll(){
        return carRepository.findAll().stream().map(car->carMapper.entityToDto(car)).toList();
    }

    public List<CarDto> getNewest(){// get 10 newly added car
        return carRedisRepository.findAll().stream().map(car->carMapper.entityToDto(car)).toList();
    }

    public List<CarDto> addLastTenToCache(){
        List<Car> all=carRepository.findAll();
        List<Car> lastTen;
        if(all.size()<10){
            lastTen=all;
        }
        else {
            lastTen = all.subList(all.size() - 10, all.size());
        }

        lastTen.forEach(car->carRedisRepository.save(car));
        return lastTen.stream().map(car->carMapper.entityToDto(car)).toList();
    }
}
