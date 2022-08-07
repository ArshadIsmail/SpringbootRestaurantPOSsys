package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.Shift;

public interface ShiftService {

	public List<Shift> findAll();

	public void save(Shift theShift);

	public Shift findById(int theId);

	public void deleteById(int theId);

}
