package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public void save(Customer theCustomer);

	public Customer findById(int theId);

	public void deleteById(int theId);

}
