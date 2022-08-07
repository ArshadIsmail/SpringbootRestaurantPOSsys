package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.resturantmanagement.resturantmanagement.models.Address;
import com.resturantmanagement.resturantmanagement.repositories.AddressRepository;

public class AddressImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public List<Address> findAll() {
		// TODO Auto-generated method stub
		return addressRepository.findAll();

	}

	public void save(Address theAddress) {
		addressRepository.save(theAddress);

	}

	public Address findById(int theId) {

		Optional<Address> results = addressRepository.findById(theId);
		Address theAddress = null;

		if (results.isPresent()) {
			theAddress = results.get();
		} else {
			throw new RuntimeException("Did not find Address id -" + theId);
		}

		return theAddress;

	}

	public void deleteById(int theId) {

		addressRepository.deleteById(theId);
		Optional<Address> results = addressRepository.findById(theId);

		if (results.isPresent()) {
			addressRepository.deleteById(theId);

		} else {
			// No address found in that number
			throw new RuntimeException("Did not find Address id -" + theId);
		}

	}

}
