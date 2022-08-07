package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.DineInTable;
import com.resturantmanagement.resturantmanagement.repositories.DineInTableRepository;

@Service
public class DineInTableImpl implements DineInTableService {

	@Autowired
	private DineInTableRepository dineInTableRepository;

	@Override
	public List<DineInTable> findAll() {
		// TODO Auto-generated method stub
		return dineInTableRepository.findAll();

	}

	public void save(DineInTable theDineInTable) {
		dineInTableRepository.save(theDineInTable);

	}

	public DineInTable findById(int theId) {

		Optional<DineInTable> results = dineInTableRepository.findById(theId);
		DineInTable theDineInTable = null;

		if (results.isPresent()) {
			theDineInTable = results.get();
		} else {
			throw new RuntimeException("Did not find DineInTable id -" + theId);
		}

		return theDineInTable;

	}

	public void deleteById(int theId) {

		Optional<DineInTable> results = dineInTableRepository.findById(theId);
		if (results.isPresent()) {
			dineInTableRepository.deleteById(theId);

		} else {
			throw new RuntimeException("Did not find DineInTable id -" + theId);
		}

	}

}
