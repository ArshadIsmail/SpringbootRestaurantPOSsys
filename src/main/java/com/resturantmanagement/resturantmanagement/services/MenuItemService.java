package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.MenuItem;

public interface MenuItemService {

	public List<MenuItem> findAll();

	public void save(MenuItem theMenuItem);

	public MenuItem findById(int theId);

	public void deleteById(int theId);

}
