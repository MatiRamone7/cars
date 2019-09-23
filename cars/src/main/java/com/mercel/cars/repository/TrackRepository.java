package com.mercel.cars.repository;

import org.springframework.data.repository.CrudRepository;

import com.mercel.cars.model.Track;

public interface TrackRepository extends CrudRepository<Track, Integer> {

}