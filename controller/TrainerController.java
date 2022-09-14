package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Trainer;
import com.example.demo.service.TrainerServiceImplementation;

@RestController
public class TrainerController {

	@Autowired
	private TrainerServiceImplementation Trainerservice;

	@RequestMapping("/trainer")
	public List<Trainer> getall() {
		return Trainerservice.getall();
	}

	@RequestMapping("/trainer/{id}")
	public ResponseEntity<Trainer> getTrainer(@PathVariable Long id) throws ResourceNotFoundException {
		return Trainerservice.getTrainer(id);
	}

	@RequestMapping(value = "/trainer", method = RequestMethod.POST)
	public void postTrainer(@RequestBody Trainer trainer) {
		Trainerservice.postTrainer(trainer);
	}

	@RequestMapping(value = "/trainer/{id}", method = RequestMethod.PUT)
	public void updateTrainer(@RequestBody Trainer trainer,@PathVariable Long id) {
		Trainerservice.updateTrainer(trainer,id);
	}
	@RequestMapping(value = "/trainer/{id}", method = RequestMethod.DELETE)
	public void deleteTrainer(@PathVariable Long id) {
		Trainerservice.deleteTrainer(id);
	}
}
