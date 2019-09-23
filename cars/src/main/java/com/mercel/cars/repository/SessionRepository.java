package com.mercel.cars.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercel.cars.model.Session;

public interface SessionRepository extends CrudRepository<Session, Integer> {

}