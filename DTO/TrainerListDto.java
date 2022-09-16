package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.Trainer;

public class TrainerListDto {
private List<Trainer> trainerlist;
	
	public List<Trainer> getTrainerlist() {
		return trainerlist;
	}

	public void setTrainerlist(List<Trainer> trainerlist) {
		this.trainerlist = trainerlist;
	}
}
