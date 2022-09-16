package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trainers")
public class Trainer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String grade;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trainer")
	private List<Dog> dogs = new ArrayList<>();

	public List<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
	}

	public Trainer() {
		super();
	}

	public Trainer(Long id) {
		this.id = id;

	}

	public Trainer(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}

	public Trainer(Long id, String name, String grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
