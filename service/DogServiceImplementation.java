package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.DogDto;
import com.example.demo.DTO.DogListDto;
import com.example.demo.DTO.DogTrainerDto;
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

	public List<Dog> getall(Long Id) throws ResourceNotFoundException {
		Trainer optionalTrainer = trainerRepository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("dogs not found for this id :: " + Id));

		DogListDto doglist = new DogListDto();
		doglist.setDoglist(optionalTrainer.getDogs());
		return (doglist.getDoglist());

	}

	public List<Dog> getalldog() {
		DogListDto doglist = new DogListDto();
		doglist.setDoglist(dogrepository.findAll());
		return (doglist.getDoglist());
	}

	public ResponseEntity<DogDto> getdog(long id) throws ResourceNotFoundException {
		Dog dog = dogrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("dog not found for this id :: " + id));
		DogDto dogdto = new DogDto();
		dogdto.setBreed(dog.getBreed());
		dogdto.setName(dog.getName());
		return ResponseEntity.ok().body(dogdto);
	}

	public void postdog(DogTrainerDto dog, Long id) throws ResourceNotFoundException {
		Trainer trainer = trainerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("trainer not found for this id :: " + id));

		Dog dog1 = new Dog();
		dog1.setTrainer(trainer);
		dog1.setBreed(dog.getBreed());
		dog1.setName(dog.getName());
		dogrepository.save(dog1);

	}

	public void putdog(DogDto dog, Long id) throws ResourceNotFoundException {
		if (!dogrepository.existsById(id))
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
