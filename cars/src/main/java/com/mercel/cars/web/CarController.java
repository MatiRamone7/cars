package com.mercel.cars.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercel.cars.model.Car;
import com.mercel.cars.services.CarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Car Controller")
@RestController
@RequestMapping(path = "/cars")
public class CarController {
	@Autowired
	private CarService carService;
	
	@ApiOperation(value = "Muestra la lista de cars", response = List.class)
	@GetMapping
	public Iterable<Car> all() {
		return carService.all();
	}

	@GetMapping("/{id}")
	public Optional<Car> get(@PathVariable Integer id) {
		return carService.getById(id);
	}

	@PostMapping
	public Car create(@Valid @RequestBody Car car) {
		return carService.create(car);
	}

	@PutMapping("/{id}")
	public Car update(@RequestBody Car car, @PathVariable Integer id) {
		return carService.update(car);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		carService.delete(id);
	}
}
