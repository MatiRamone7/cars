package com.mercel.cars.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercel.cars.model.Permit;

public interface PermitRepository extends CrudRepository<Permit, Integer> {

}