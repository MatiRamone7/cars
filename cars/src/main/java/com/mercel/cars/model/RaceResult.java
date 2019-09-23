package com.mercel.cars.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "race_result")
public class RaceResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Float time;

	@ManyToOne
	@JoinColumn(name = "race_id")
	@JsonIgnore
	private Race race;

	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
