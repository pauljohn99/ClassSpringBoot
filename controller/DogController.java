package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Dog;
import com.example.demo.model.Trainer;
import com.example.demo.service.DogServiceImplementation;

@RestController
public class DogController {

	@Autowired
	private DogServiceImplementation dogservice;

	@RequestMapping("/trainer/{id}/dog")
	public Set<Dog> getall(@PathVariable long id) {
		return dogservice.getall(id);	 	
	}

	@RequestMapping("/dog/{id}")
	public ResponseEntity<Dog> getdog(@PathVariable Long id) throws ResourceNotFoundException {
		return dogservice.getdog(id);
	}

	@RequestMapping(value = "/trainer/{id}/dog", method = RequestMethod.POST)
	public void postdog(@RequestBody Dog dog,@PathVariable Long id) {
		dog.setTrainer( new Trainer(id));
		dogservice.postdog(dog,id);
	}

	@RequestMapping(value = "/trainer/{trainerid}/dog/{id}", method = RequestMethod.PUT)
	public void updatedog(@RequestBody Dog dog,@PathVariable Long id,@PathVariable Long trainerid) {
		dog.setTrainer(new Trainer(trainerid));
		dogservice.putdog(dog,id);
	}
	@RequestMapping(value = "/trainer/{trainerid}/dog/{id}", method = RequestMethod.DELETE)
	public void deletedog(@PathVariable Long id) {
		dogservice.deletedog(id);
	}
}
