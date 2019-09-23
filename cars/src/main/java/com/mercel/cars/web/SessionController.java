package com.mercel.cars.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercel.cars.dto.DriverScoreDTO;
import com.mercel.cars.model.Session;
import com.mercel.cars.services.SessionService;

@RestController
@RequestMapping(path = "/sessions")
public class SessionController {
	@Autowired
	private SessionService sessionService;

	@GetMapping
	public Iterable<Session> all() {
		return sessionService.all();
	}

	@GetMapping("/{id}")
	public Optional<Session> get(@PathVariable Integer id) {
		return sessionService.getById(id);
	}

	@PostMapping
	public Session create(@RequestBody Session session) {
		return sessionService.create(session);
	}

	@PutMapping("/{id}")
	public Session update(@RequestBody Session session, @PathVariable Integer id) {
		return sessionService.update(session);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		sessionService.delete(id);
	}

	@GetMapping("/{id}/scores")
	public List<DriverScoreDTO> getScoresBySession(@PathVariable Integer id) {
		return sessionService.getScoresBySession(id);
	}
}
