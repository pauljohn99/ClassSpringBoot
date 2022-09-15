package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Dog;
import com.example.demo.model.Trainer;
import com.example.demo.repository.DogRepository;
import com.example.demo.repository.TrainerRepository;

@Service
public class DogServiceImplementation implements DogServiceInterface {

	@Autowired
	private DogRepository dogrepository;

	@Autowired
	private TrainerRepository trainerRepository;

	Trainer trainer;

	public Set<Dog> getall(long trainerId) {
//		return dogrepository.findByTrainerId(trainerId);
		Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
		if (optionalTrainer.isPresent()) {
			return optionalTrainer.get().getDogs();
		}
		return null;
		
	}
	
	public  List<Dog> getalldog() {
		return  (List<Dog>) dogrepository.findAll(); 
	}

	public ResponseEntity<Dog> getdog(long id) throws ResourceNotFoundException {
		Dog dog = dogrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("dog not found for this id :: " + id));
		return ResponseEntity.ok().body(dog);
	}

	public void postdog(Dog dog, Long id) {
		dogrepository.save(dog);

	}

	public void putdog(Dog dog, Long id) throws ResourceNotFoundException {
		if(!dogrepository.existsById(id))
			throw new ResourceNotFoundException("dog not found for this id :: " + id);
		Dog newdog = dogrepository.findById(id).get();
		newdog.setName(dog.getName());
		newdog.setBreed(dog.getBreed());
		dogrepository.save(newdog);
	}

	public void deletedog(Long id) throws ResourceNotFoundException {
		Dog dog = dogrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("dog not found for this id :: " + id));
		dogrepository.delete(dog);

	}

}
