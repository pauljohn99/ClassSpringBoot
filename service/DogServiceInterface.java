package com.example.demo.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.example.demo.DTO.DogDto;
import com.example.demo.DTO.DogTrainerDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Dog;

public interface DogServiceInterface {
	public List<Dog> getall(Long Id) throws ResourceNotFoundException;

	public ResponseEntity<DogDto> getdog(long id) throws ResourceNotFoundException;

	public void putdog(DogDto dog, Long id) throws ResourceNotFoundException;

	public void deletedog(Long id) throws ResourceNotFoundException;

	public List<Dog> getalldog();

	public void postdog(DogTrainerDto dog);
}
