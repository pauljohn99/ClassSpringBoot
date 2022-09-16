package com.example.demo.DTO;

import com.example.demo.model.Trainer;

public class DogTrainerDto {
	private Trainer trainer;
	private String name;
	private String breed;

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
}
