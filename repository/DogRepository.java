package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Dog;


@Repository
public interface DogRepository extends JpaRepository<Dog, Long>{
	public List<Dog> findByTrainerId(long Id);


}
