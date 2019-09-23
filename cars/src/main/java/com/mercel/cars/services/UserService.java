package com.mercel.cars.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mercel.cars.model.User;
import com.mercel.cars.repository.UserRepository;

/**
 * Servicios de users.
 * 
 * @author Matías Fida
 * @see User
 * @see UserRepository
 */
@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Retorna la lista de users.
	 * 
	 * @return lista de users
	 */
	public Iterable<User> all() {
		return repository.findAll();
	}

	/**
	 * Busca un user por Id.
	 * 
	 * @param id id de user a buscar
	 * @return user existente
	 */
	public Optional<User> getById(Integer id) {

		Optional<User> userOptional = this.repository.findById(id);

		if (userOptional.isPresent()) {
			return userOptional;
		} else {
			return Optional.empty();
		}

	}

	/**
	 * Crea un nuevo user.
	 * 
	 * @param user user a crear
	 * @return nuevo user
	 */
	public User create(User user) {

		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		return repository.save(user);
	}

	/**
	 * Actualiza user existente.
	 * 
	 * @param user user a actualizar
	 * @return user actualizado
	 */
	public User update(User user) {
		return repository.save(user);
	}

	/**
	 * Borra user existente.
	 * 
	 * @param id id de user a eliminar
	 */
	public void delete(Integer id) {
		repository.deleteById(id);
	}

	/**
	 * Buscar user existente por username
	 * 
	 * @param username username a buscar
	 * @return username
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByUsername(username);
	}
}