package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Trainer;
import com.example.demo.repository.TrainerRepository;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepository trainerrepository;

	public List<Trainer> getall() {
		return trainerrepository.findAll();
	}

	public Optional<Trainer> getTrainer(Long id) {
		return trainerrepository.findById(id);
	}

	public Trainer postTrainer(Trainer trainer) {
		return trainerrepository.save(trainer);

	}

	public void updateTrainer(Trainer trainer,Long id) {
		Trainer newtrainer=trainerrepository.findById(id).get();
		newtrainer.setName(trainer.getName());
		newtrainer.setGrade(trainer.getGrade());
		trainerrepository.save(newtrainer);
		
	}

	public void deleteTrainer(Long id) {
		trainerrepository.deleteById(id);

	}

}
