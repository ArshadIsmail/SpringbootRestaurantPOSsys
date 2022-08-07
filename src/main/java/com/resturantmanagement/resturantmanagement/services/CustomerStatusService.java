package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.CustomerStatus;

public interface CustomerStatusService {

	public List<CustomerStatus> findAll();

	public void save(CustomerStatus theCustomerStatus);

	public CustomerStatus findById(int theId);

	public void deleteById(int theId);

}
