package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.Resturant;

public interface ResturantService {

	public List<Resturant> findAll();

	public void save(Resturant theResturant);

	public Resturant findById(int theId);

	public void deleteById(int theId);

}
