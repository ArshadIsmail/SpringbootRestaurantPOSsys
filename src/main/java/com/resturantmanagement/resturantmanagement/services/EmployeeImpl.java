package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Employee;
import com.resturantmanagement.resturantmanagement.models.Employee;
import com.resturantmanagement.resturantmanagement.repositories.EmployeeRepository;

@Service
public class EmployeeImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
		
	}

	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	public Employee findById(int theId) {

		Optional<Employee> results = employeeRepository.findById(theId);
		Employee theEmployee = null;

		if (results.isPresent()) {
			theEmployee = results.get();
		} else {
			throw new RuntimeException("Did not find Employee id -" + theId);
		}

		return theEmployee;

	}

	public void deleteById(int theId) {

		Optional<Employee> results = employeeRepository.findById(theId);

		if (results.isPresent()) {
			employeeRepository.deleteById(theId);
		} else {
			throw new RuntimeException("Did not find Employee id -" + theId);
		}

	}

}
