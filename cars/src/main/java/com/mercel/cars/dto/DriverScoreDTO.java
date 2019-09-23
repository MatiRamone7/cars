package com.mercel.cars.dto;

import com.mercel.cars.model.Driver;

public class DriverScoreDTO {
	private Driver driver;
	private Integer score;

	public DriverScoreDTO() {

	}

	public DriverScoreDTO(Driver driver, Integer score) {
		this.driver = driver;
		this.score = score;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
