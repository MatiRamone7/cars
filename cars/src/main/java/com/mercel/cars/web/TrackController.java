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

import com.mercel.cars.model.Track;
import com.mercel.cars.services.TrackService;

@RestController
@RequestMapping(path = "/tracks")
public class TrackController {
	@Autowired
	private TrackService trackService;

	@GetMapping
	public Iterable<Track> all() {
		return trackService.all();
	}

	@GetMapping("/{id}")
	public Optional<Track> get(@PathVariable Integer id) {
		return trackService.getById(id);
	}

	@PostMapping
	public Track create(@RequestBody Track track) {
		return trackService.create(track);
	}

	@PutMapping("/{id}")
	public Track update(@RequestBody Track track, @PathVariable Integer id) {
		return trackService.update(track);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		trackService.delete(id);
	}
}
