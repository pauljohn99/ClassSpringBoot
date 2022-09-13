package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Dog;
import com.example.demo.repository.DogRepository;

@Service
public class DogService {

	@Autowired
	private DogRepository dogrepository;

	public List<Dog> getall(long trainerId) {
		return dogrepository.findByTrainerId(trainerId);
	}

	public ResponseEntity<Dog> getdog(long id) 
			throws ResourceNotFoundException {
		Dog dog=dogrepository.findById(id)
				 .orElseThrow(() -> new ResourceNotFoundException("dog not found for this id :: " + id));
        return ResponseEntity.ok().body(dog);
	}

	public void postdog(Dog dog) {
		dogrepository.save(dog);

	}

	public void putdog(Dog dog,Long id) {
		Dog newdog=dogrepository.findById(id).get();
		newdog.setName(dog.getName());
		newdog.setBreed(dog.getBreed());
		dogrepository.save(newdog);
	}

	public void deletedog(Long id) {
		dogrepository.deleteById(id);
		
	}
	
	
}
