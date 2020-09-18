package com.dogs.dogs.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dogs.dogs.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findUserByUserName(String userName);
	
	boolean existsByUserName(String userName);
	
	boolean existsByEmail(String email);
	

}
