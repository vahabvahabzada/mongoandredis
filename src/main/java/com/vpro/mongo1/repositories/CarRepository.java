package com.vpro.mongo1.repositories;

import com.vpro.mongo1.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends MongoRepository<Car,String> {
}
