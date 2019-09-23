package com.mercel.cars.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercel.cars.dto.DriverScoreDTO;
import com.mercel.cars.model.Driver;
import com.mercel.cars.model.Race;
import com.mercel.cars.model.RaceResult;
import com.mercel.cars.model.Session;
import com.mercel.cars.repository.SessionRepository;

/**
 * Servicios de sesiones.
 * 
 * @author Matías Fida
 * @see Session
 * @see SessionRepository
 */
@Service
public class SessionService {
	private final static Integer SCORES[] = { 10, 5 };

	@Autowired
	private SessionRepository repository;

	/**
	 * Retorna la lista de sesiones.
	 * 
	 * @return lista de sesiones
	 */
	public Iterable<Session> all() {
		return repository.findAll();
	}

	/**
	 * Busca una sesión por id.
	 * 
	 * @param id id de sesión a buscar
	 * @return sesión existente
	 */
	public Optional<Session> getById(Integer id) {

		Optional<Session> sessionOptional = this.repository.findById(id);

		if (sessionOptional.isPresent()) {
			return sessionOptional;
		} else {
			return Optional.empty();
		}

	}

	/**
	 * Crea una nueva sesión.
	 * 
	 * @param session sesión a crear
	 * @return nueva sesión
	 */
	public Session create(Session session) {
		return repository.save(session);
	}

	/**
	 * Actualiza una sesión.
	 * 
	 * @param session sesión a actualizar
	 * @return sesión actualizada
	 */
	public Session update(Session session) {
		return repository.save(session);
	}

	/**
	 * Elimina una sesión.
	 * 
	 * @param id id de la sesión a eliminar
	 */
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	/**
	 * Retorna una lista con el puntaje acumulado de cada piloto en las carreras de
	 * una sesión.
	 * 
	 * @param id id de la sesión
	 * @return lista con el puntaje obtenido para cada piloto
	 */
	public List<DriverScoreDTO> getScoresBySession(Integer id) {

		Map<Driver, Integer> map = new HashMap<Driver, Integer>();

		Optional<Session> session = getById(id);

		if (session.isPresent()) {
			for (Race race : session.get().getRaces()) {
				List<RaceResult> results = race.getResults();

				results.sort(Comparator.comparing(RaceResult::getTime));

				for (int i = 0; i < SCORES.length; i++) {
					if (i < results.size()) {
						addScore(map, results.get(i).getDriver(), SCORES[i]);
					}
				}
			}
		}

		List<DriverScoreDTO> scores = new ArrayList<DriverScoreDTO>();

		for (Driver driver : map.keySet()) {
			scores.add(new DriverScoreDTO(driver, map.get(driver)));
		}

		scores.sort(Comparator.comparing(DriverScoreDTO::getScore).reversed());

		return scores;
	}

	/**
	 * Suma puntaje a un driver.
	 * 
	 * @param map    mapa de drivers con sus puntajes
	 * @param driver driver a sumar puntaje
	 * @param score  puntaje a sumar
	 */
	private void addScore(Map<Driver, Integer> map, Driver driver, Integer score) {
		if (!map.containsKey(driver)) {
			map.put(driver, 0);
		}

		map.put(driver, map.get(driver) + score);
	}
}