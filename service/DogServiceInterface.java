package com.example.demo.service;

import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Dog;

public interface DogServiceInterface {
	public Set<Dog> getall(long trainerId);

	public ResponseEntity<Dog> getdog(long id) throws ResourceNotFoundException;

	public void postdog(Dog dog, Long id);

	public void putdog(Dog dog, Long id);

	public void deletedog(Long id);

}
