package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Address;

@Service
public interface AddressService {

	public List<Address> findAll();

	public void save(Address theAddress);

	public Address findById(int theId);

	public void deleteById(int theId);

}
