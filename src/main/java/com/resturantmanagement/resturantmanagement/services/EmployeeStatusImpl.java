package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.EmployeeStatus;
import com.resturantmanagement.resturantmanagement.repositories.EmployeeStatusRepository;

@Service
public class EmployeeStatusImpl implements EmployeeStatusService {

	@Autowired
	private EmployeeStatusRepository employeeStatusRepository;

	@Override
	public List<EmployeeStatus> findAll() {
		// TODO Auto-generated method stub
		return employeeStatusRepository.findAll();

	}

	public void save(EmployeeStatus theEmployeeStatus) {
		employeeStatusRepository.save(theEmployeeStatus);

	}

	public EmployeeStatus findById(int theId) {

		Optional<EmployeeStatus> results = employeeStatusRepository.findById(theId);
		EmployeeStatus theEmployeeStatus = null;

		if (results.isPresent()) {
			theEmployeeStatus = results.get();
		} else {
			throw new RuntimeException("Did not find EmployeeStatus id -" + theId);
		}

		return theEmployeeStatus;

	}

	public void deleteById(int theId) {

		Optional<EmployeeStatus> results = employeeStatusRepository.findById(theId);
		if (results.isPresent()) {
			employeeStatusRepository.deleteById(theId);

		} else {
			throw new RuntimeException("Did not find EmpStatus id -" + theId);
		}

	}

}
