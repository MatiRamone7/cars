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

import com.mercel.cars.model.User;
import com.mercel.cars.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public Iterable<User> all() {
		return userService.all();
	}

	@GetMapping("/{id}")
	public Optional<User> get(@PathVariable Integer id) {
		return userService.getById(id);
	}

	@PostMapping
	public User create(@RequestBody User user) {
		return userService.create(user);
	}

	@PutMapping("/{id}")
	public User update(@RequestBody User user, @PathVariable Integer id) {
		return userService.update(user);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		userService.delete(id);
	}

}
