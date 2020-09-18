package com.dogs.dogs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogs.dogs.model.Dog;
import com.dogs.dogs.repository.DogRepository;

@RestController
@RequestMapping("/api/dogs")
public class DogController {

	@Autowired
	private DogRepository dogRepo;

	@GetMapping
	public ResponseEntity<List<Dog>> getDogs() {
		return ResponseEntity.ok((List<Dog>) dogRepo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Dog> getDog(@PathVariable long id) {
		java.util.Optional<Dog> dog = dogRepo.findById(id);
		if (!dog.isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(dog.get());
	}

	@PostMapping
	public ResponseEntity<Dog> create(@RequestBody Dog dog) {
		dog = dogRepo.save(dog);
		return ResponseEntity.ok(dog);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Dog> updateDog(@PathVariable long id, @RequestBody Dog dog) {

		if (!dogRepo.findById(id).isPresent()) {
			return ResponseEntity.badRequest().build();
		}
		Dog currentDog = dogRepo.findById(id).get();
		currentDog.setOwner(dog.getOwner());
		currentDog.setAddress(dog.getAddress());
		currentDog.setBreed(dog.getBreed());
		currentDog.setName(dog.getName());
		currentDog.setAge(dog.getAge());
		return ResponseEntity.ok(dogRepo.save(currentDog));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteDog(@PathVariable long id) {
		if (!dogRepo.findById(id).isPresent()) {
			return ResponseEntity.badRequest().build();
		}

		dogRepo.deleteById(id);

		return ResponseEntity.ok(true);
	}
}
