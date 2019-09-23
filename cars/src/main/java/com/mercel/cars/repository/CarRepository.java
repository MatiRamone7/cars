package com.mercel.cars.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercel.cars.model.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {

}
