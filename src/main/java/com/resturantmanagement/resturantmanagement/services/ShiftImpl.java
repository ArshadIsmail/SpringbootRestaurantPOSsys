package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Shift;
import com.resturantmanagement.resturantmanagement.repositories.ShiftRepository;

@Service
public class ShiftImpl implements ShiftService {

	@Autowired
	private ShiftRepository shiftRepository;

	@Override
	public List<Shift> findAll() {
		// TODO Auto-generated method stub
		return shiftRepository.findAll();

	}

	public void save(Shift theShift) {
		shiftRepository.save(theShift);

	}

	public Shift findById(int theId) {

		Optional<Shift> results = shiftRepository.findById(theId);
		Shift theShift = null;
		if (results.isPresent()) {
			theShift = results.get();

		} else {

			throw new RuntimeException("Did not find Shift id -" + theId);
		}

		return theShift;

	}

	public void deleteById(int theId) {

		shiftRepository.deleteById(theId);

	}
}
