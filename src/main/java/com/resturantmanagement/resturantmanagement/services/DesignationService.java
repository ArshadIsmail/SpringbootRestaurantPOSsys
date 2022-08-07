package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.Designation;

public interface DesignationService {

	public List<Designation> findAll();

	public void save(Designation theDesignation);

	public Designation findById(int theId);

	public void deleteById(int theId);

}
