package com.mercel.cars.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mercel.cars.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("from User u " + " join fetch u.permits " + "where u.username = :username")
	User findByUsername(String username);

	@Query("select u from User u where u.username = ?1")
	User findByNameWithQuery(String name);
}