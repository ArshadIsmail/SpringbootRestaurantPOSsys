package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Designation;
import com.resturantmanagement.resturantmanagement.repositories.DesignationRepository;

@Service
public class DesignationImpl implements DesignationService {

	@Autowired
	private DesignationRepository designationRepository;

	public List<Designation> findAll() {
		// TODO Auto-generated method stub
		return designationRepository.findAll();

	}

	public void save(Designation theDesignation) {
		designationRepository.save(theDesignation);

	}

	public Designation findById(int theId) {

		Optional<Designation> results = designationRepository.findById(theId);
		Designation theDesignation = null;
		if (results.isPresent()) {
			theDesignation = results.get();
		} else {
			throw new RuntimeException("Did not find Designation id -" + theId);
		}

		return theDesignation;

	}

	public void deleteById(int theId) {

		Optional<Designation> results = designationRepository.findById(theId);
		if (results.isPresent()) {
			designationRepository.deleteById(theId);
		} else {
			throw new RuntimeException("No id found -" + theId);
		}

	}

}
