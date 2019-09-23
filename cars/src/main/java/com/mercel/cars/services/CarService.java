package com.mercel.cars.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercel.cars.model.Car;
import com.mercel.cars.repository.CarRepository;

/**
 * Servicios de cars.
 * 
 * @author Matías Fida
 * @see Car
 * @see CarRepository
 */
@Service
public class CarService {
	@Autowired
	private CarRepository repository;

	/**
	 * Retorna la lista de cars.
	 * 
	 * @return lista de cars
	 */
	public Iterable<Car> all() {
		return repository.findAll();
	}

	/**
	 * Busca un car por Id.
	 * 
	 * @param id id de car a buscar
	 * @return car existente
	 */
	public Optional<Car> getById(Integer id) {

		Optional<Car> carOptional = this.repository.findById(id);

		if (carOptional.isPresent()) {
			return carOptional;
		} else {
			return Optional.empty();
		}

	}

	/**
	 * Crea un nuevo car.
	 * 
	 * @param car car a crear
	 * @return nuevo car
	 */
	public Car create(Car car) {
		return repository.save(car);
	}

	/**
	 * Actualiza car existente.
	 * 
	 * @param car car a actualizar
	 * @return car actualizado
	 */
	public Car update(Car car) {
		return repository.save(car);
	}

	/**
	 * Borra car existente.
	 * 
	 * @param id id de car a eliminar
	 */
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}