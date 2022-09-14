package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Trainer;

public interface TrainerServiceInterface {
	public List<Trainer> getall();

	public ResponseEntity<Trainer> getTrainer(Long id) throws ResourceNotFoundException;

	public Trainer postTrainer(Trainer trainer);

	public void updateTrainer(Trainer trainer, Long id);

	public void deleteTrainer(Long id);

}
