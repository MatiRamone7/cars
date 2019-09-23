package com.mercel.cars.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercel.cars.model.Permit;
import com.mercel.cars.repository.PermitRepository;

/**
 * Servicios de permisos.
 * 
 * @author Matías Fida
 * @see Permit
 * @see PermitRepository
 */
@Service
public class PermitService {
	@Autowired
	private PermitRepository repository;

	/**
	 * Retorna la lista de permisos.
	 * 
	 * @return lista de permisos
	 */
	public Iterable<Permit> all() {
		return repository.findAll();
	}

	/**
	 * Busca un permiso por Id.
	 * 
	 * @param id id de permiso a buscar
	 * @return permiso existente
	 */
	public Optional<Permit> getById(Integer id) {

		Optional<Permit> permitOptional = this.repository.findById(id);

		if (permitOptional.isPresent()) {
			return permitOptional;
		} else {
			return Optional.empty();
		}

	}

	/**
	 * Crea un nuevo permiso.
	 * 
	 * @param permit permiso a crear
	 * @return nuevo permiso
	 */
	public Permit create(Permit permit) {
		return repository.save(permit);
	}

	/**
	 * Actualiza permiso existente.
	 * 
	 * @param permit permiso a actualizar
	 * @return permiso actualizado
	 */
	public Permit update(Permit permit) {
		return repository.save(permit);
	}

	/**
	 * Borra permiso existente.
	 * 
	 * @param id id de permiso a eliminar
	 */
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}