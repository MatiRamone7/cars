package com.mercel.cars.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercel.cars.model.Track;
import com.mercel.cars.repository.TrackRepository;

/**
 * Servicios de tracks.
 * 
 * @author Matías Fida
 * @see Track
 * @see TrackRepository
 */
@Service
public class TrackService {
	@Autowired
	private TrackRepository repository;

	/**
	 * Retorna la lista de tracks.
	 * 
	 * @return lista de tracks
	 */
	public Iterable<Track> all() {
		return repository.findAll();
	}

	/**
	 * Busca un track por Id.
	 * 
	 * @param id id de track a buscar
	 * @return track existente
	 */
	public Optional<Track> getById(Integer id) {

		Optional<Track> trackOptional = this.repository.findById(id);

		if (trackOptional.isPresent()) {
			return trackOptional;
		} else {
			return Optional.empty();
		}

	}

	/**
	 * Crea un nuevo track.
	 * 
	 * @param track track a crear
	 * @return nuevo track
	 */
	public Track create(Track track) {
		return repository.save(track);

	}

	/**
	 * Actualiza track existente.
	 * 
	 * @param track track a actualizar
	 * @return track actualizado
	 */
	public Track update(Track track) {
		return repository.save(track);
	}

	/**
	 * Borra track existente.
	 * 
	 * @param id id de track a eliminar
	 */
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}