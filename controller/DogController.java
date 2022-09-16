package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.DogDto;
import com.example.demo.DTO.DogTrainerDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Dog;
import com.example.demo.service.DogServiceInterface;

@RestController
public class DogController {

	@Autowired
	private DogServiceInterface dogservice;

	@RequestMapping("/trainer/{id}/dog")
	public List<Dog> getall(@PathVariable long id) throws ResourceNotFoundException {
		return dogservice.getall(id);
	}

	@RequestMapping("/dog")
	public List<Dog> getdog() {
		return (List<Dog>) dogservice.getalldog();
	}

	@RequestMapping("/dog/{id}")
	public ResponseEntity<DogDto> getdog(@PathVariable Long id) throws ResourceNotFoundException {
		return dogservice.getdog(id);
	}

	@RequestMapping(value = "/trainer/{id}/dog", method = RequestMethod.POST)
	public void postdog(@RequestBody DogTrainerDto dog, @PathVariable Long id) throws ResourceNotFoundException {
		
		dogservice.postdog(dog,id);
	}

	@RequestMapping(value = "/dog/{id}", method = RequestMethod.PUT)
	public void updatedog(@RequestBody DogDto dog, @PathVariable Long id) throws ResourceNotFoundException {

		dogservice.putdog(dog, id);
	}

	@RequestMapping(value = "/dog/{id}", method = RequestMethod.DELETE)
	public void deletedog(@PathVariable Long id) throws ResourceNotFoundException {
		dogservice.deletedog(id);
	}
}
