package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Gender;
import com.resturantmanagement.resturantmanagement.repositories.GenderRepository;

@Service
public class GenderImpl implements GenderService {

	@Autowired
	private GenderRepository genderRepository;

	@Override
	public List<Gender> findAll() {
		// TODO Auto-generated method stub
		return genderRepository.findAll();
		
	}

	public void save(Gender theGender) {
		genderRepository.save(theGender);

	}

	public Gender findById(int theId) {

		Optional<Gender> results = genderRepository.findById(theId);
		Gender theGender = null;

		if (results.isPresent()) {

			theGender = results.get();

		} else {

			throw new RuntimeException("Did not find Gender id -" + theId);
		}

		return theGender;

	}

	public void deleteById(int theId) {

		Optional<Gender> results = genderRepository.findById(theId);

		if (results.isPresent()) {
			genderRepository.deleteById(theId);

		} else {
			throw new RuntimeException("Did not find Gender id -" + theId);
		}

	}

}
