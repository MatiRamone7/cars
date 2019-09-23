package com.mercel.cars.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import com.mercel.cars.model.Permit;
import com.mercel.cars.services.PermitService;

@RestController
@RequestMapping(path = "/permits")
public class PermitController {
	@Autowired
	private PermitService permitService;

	@GetMapping
	public Iterable<Permit> all() {
		return permitService.all();
	}

	@GetMapping("/{id}")
	public Optional<Permit> get(@PathVariable Integer id) {
		return permitService.getById(id);
	}

	@PostMapping
	public Permit create(@RequestBody Permit permit) {
		return permitService.create(permit);
	}

	@PutMapping("/{id}")
	public Permit update(@RequestBody Permit permit, @PathVariable Integer id) {
		return permitService.update(permit);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		permitService.delete(id);
	}
}
