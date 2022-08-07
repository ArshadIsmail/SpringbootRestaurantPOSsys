package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Resturant;
import com.resturantmanagement.resturantmanagement.repositories.ResturantRepository;

@Service
public class ResturantImpl implements ResturantService {

	@Autowired
	private ResturantRepository resturantRepository;

	@Override
	public List<Resturant> findAll() {
		// TODO Auto-generated method stub
		return resturantRepository.findAll();
		// return null;
	}

	public void save(Resturant theResturant) {
		resturantRepository.save(theResturant);

	}

	public Resturant findById(int theId) {

		Optional<Resturant> results = resturantRepository.findById(theId);
		Resturant theResturant = null;

		if (results.isPresent()) {

			theResturant = results.get();

		} else {

			throw new RuntimeException("Did not find Resturant id -" + theId);
		}

		return theResturant;

	}

	public void deleteById(int theId) {

		Optional<Resturant> results = resturantRepository.findById(theId);
		if (results.isPresent()) {
			resturantRepository.deleteById(theId);
		} else {

			throw new RuntimeException("Did not find Resturant id -" + theId);
		}

	}
}
