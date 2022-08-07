package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.DineInTable;

public interface DineInTableService {

	public List<DineInTable> findAll();

	public DineInTable findById(int theId);

	public void save(DineInTable theDineInTable);

	public void deleteById(int theId);

}
