package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.EmployeeStatus;

public interface EmployeeStatusService {

	public List<EmployeeStatus> findAll();

	public void save(EmployeeStatus theEmployeeStatus);

	public EmployeeStatus findById(int theId);

	public void deleteById(int theId);

}
