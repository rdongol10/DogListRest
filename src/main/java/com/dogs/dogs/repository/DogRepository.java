package com.dogs.dogs.repository;

import org.springframework.data.repository.CrudRepository;

import com.dogs.dogs.model.Dog;

public interface DogRepository extends CrudRepository<Dog, Long> {

}
