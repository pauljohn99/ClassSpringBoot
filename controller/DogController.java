package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dog;
import com.example.demo.model.Trainer;
import com.example.demo.service.DogService;

@RestController
public class DogController {

	@Autowired
	private DogService dogservice;

	@RequestMapping("/trainer/{id}/dog")
	public List<Dog> getall(@PathVariable long id) {
		return dogservice.getall(id);
	}

	@RequestMapping("/dog/{id}")
	public Optional<Dog> getdog(@PathVariable Long id) {
		return dogservice.getdog(id);
	}

	@RequestMapping(value = "/trainer/{id}/dog", method = RequestMethod.POST)
	public void postdog(@RequestBody Dog dog,@PathVariable Long id) {
		dog.setTrainer( new Trainer(id,"",""));
		dogservice.postdog(dog);
	}

	@RequestMapping(value = "/trainer/{trainerid}/dog/{id}", method = RequestMethod.PUT)
	public void updatedog(@RequestBody Dog dog,@PathVariable Long id,@PathVariable Long trainerid) {
		dog.setTrainer(new Trainer(trainerid,"",""));
		dogservice.putdog(dog,id);
	}
	@RequestMapping(value = "/trainer/{trainerid}/dog/{id}", method = RequestMethod.DELETE)
	public void deletedog(@PathVariable Long id) {
		dogservice.deletedog(id);
	}
}
