package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.Gender;

public interface GenderService {

	public List<Gender> findAll();

	public void save(Gender theGender);

	public Gender findById(int theId);

	public void deleteById(int theId);

}
