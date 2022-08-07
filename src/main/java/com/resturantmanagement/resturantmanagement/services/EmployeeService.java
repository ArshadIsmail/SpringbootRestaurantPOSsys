package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public void save(Employee theEmployee);

	public Employee findById(int theId);

	public void deleteById(int theId);

}
