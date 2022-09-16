package com.example.demo.DTO;

import java.util.List;
import com.example.demo.model.Dog;

public class DogListDto {
private List<Dog> doglist;

public List<Dog> getDoglist() {
	return doglist;
}

public void setDoglist(List<Dog> set) {
	this.doglist = set;
}
}
