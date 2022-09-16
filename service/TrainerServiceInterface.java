package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.DTO.TrainerDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Trainer;

public interface TrainerServiceInterface {
	public List<Trainer> getall();

	public ResponseEntity<TrainerDto> getTrainer(Long id) throws ResourceNotFoundException;

	public Trainer postTrainer(TrainerDto trainer);

	public void updateTrainer(TrainerDto trainer, Long id) throws ResourceNotFoundException;

	public void deleteTrainer(Long id) throws ResourceNotFoundException;

}
