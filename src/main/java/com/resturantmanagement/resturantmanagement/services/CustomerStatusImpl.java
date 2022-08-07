package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.CustomerStatus;
import com.resturantmanagement.resturantmanagement.repositories.CustomerStatusRepository;

@Service
public class CustomerStatusImpl implements CustomerStatusService {

	@Autowired
	private CustomerStatusRepository customerStatusRepository;

	public List<CustomerStatus> findAll() {
		// TODO Auto-generated method stub
		return customerStatusRepository.findAll();

	}

	public void save(CustomerStatus theCustomerStatus) {
		customerStatusRepository.save(theCustomerStatus);

	}

	public CustomerStatus findById(int theId) {

		Optional<CustomerStatus> results = customerStatusRepository.findById(theId);
		CustomerStatus theCustomerStatus = null;

		if (results.isPresent()) {
			theCustomerStatus = results.get();
		} else {
			throw new RuntimeException("Did not find CustomerStatus id -" + theId);
		}

		return theCustomerStatus;

	}

	public void deleteById(int theId) {

		Optional<CustomerStatus> results = customerStatusRepository.findById(theId);
		if (results.isPresent()) {
			customerStatusRepository.deleteById(theId);
		} else {
			throw new RuntimeException("Did not find status id -" + theId);
		}

	}

}
