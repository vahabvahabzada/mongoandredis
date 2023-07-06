package com.vpro.mongo1.repositories;

import com.vpro.mongo1.entities.Car;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CarRedisRepository {
    public static final String HASH_KEY = "Car";
    private RedisTemplate<String,Object> redisTemplate;

    public CarRedisRepository(RedisTemplate<String,Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Car save(Car car) {
        redisTemplate.opsForHash().put(HASH_KEY, car.getId(), car);
        return car;
    }

    public List<Car> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY).stream().map(car->(Car) car).toList();
    }
}
