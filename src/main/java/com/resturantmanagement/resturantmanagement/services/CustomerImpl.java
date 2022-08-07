package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Customer;
import com.resturantmanagement.resturantmanagement.repositories.CustomerRepository;

@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);

	}

	public Customer findById(int theId) {

		Optional<Customer> results = customerRepository.findById(theId);
		Customer theCustomer = null;

		if (results.isPresent()) {
			theCustomer = results.get();
		} else {
			throw new RuntimeException("Did not find Customer id -" + theId);
		}

		return theCustomer;

	}

	public void deleteById(int theId) {

		customerRepository.deleteById(theId);
		Optional<Customer> results = customerRepository.findById(theId);

		if (results.isPresent()) {
			customerRepository.deleteById(theId);

		} else {
			throw new RuntimeException("Did not find Customer id -" + theId);
		}

	}

}
