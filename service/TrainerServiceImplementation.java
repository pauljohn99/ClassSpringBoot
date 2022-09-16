package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.TrainerDto;
import com.example.demo.DTO.TrainerListDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Trainer;
import com.example.demo.repository.TrainerRepository;

@Service
public class TrainerServiceImplementation implements TrainerServiceInterface {

	@Autowired
	private TrainerRepository trainerrepository;

	public List<Trainer> getall() {
		TrainerListDto trainerdto = new TrainerListDto();
		trainerdto.setTrainerlist(trainerrepository.findAll());
		return (trainerdto.getTrainerlist());
	}

	public ResponseEntity<TrainerDto> getTrainer(Long id) throws ResourceNotFoundException {
		Trainer trainer = trainerrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Trainer not found for this id :: " + id));
		TrainerDto trainer1 = new TrainerDto();
		trainer1.setName(trainer.getName());
		trainer1.setGrade(trainer.getGrade());
		return ResponseEntity.ok().body(trainer1);
	}

	public Trainer postTrainer(TrainerDto trainer) {
		Trainer trainer1 = new Trainer();
		trainer1.setName(trainer.getName());
		trainer1.setGrade(trainer.getGrade());
		return trainerrepository.save(trainer1);
	}

	public void updateTrainer(TrainerDto trainer, Long id) throws ResourceNotFoundException {
		if (!trainerrepository.existsById(id))
			throw new ResourceNotFoundException("Trainer not found for this id :: " + id);

		Trainer newtrainer = trainerrepository.findById(id).get();
		newtrainer.setName(trainer.getName());
		newtrainer.setGrade(trainer.getGrade());
		trainerrepository.save(newtrainer);

	}

	public void deleteTrainer(Long id) throws ResourceNotFoundException {
		Trainer trainer = trainerrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Trainer not found for this id :: " + id));
		trainerrepository.delete(trainer);

	}

}
