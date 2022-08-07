package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.MenuItem;
import com.resturantmanagement.resturantmanagement.repositories.MenuItemRepository;

@Service
public class MenuItemImpl implements MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	@Override
	public List<MenuItem> findAll() {
		// TODO Auto-generated method stub
		return menuItemRepository.findAll();

	}

	public void save(MenuItem theMenuItem) {
		menuItemRepository.save(theMenuItem);

	}

	public MenuItem findById(int theId) {

		Optional<MenuItem> results = menuItemRepository.findById(theId);
		MenuItem theMenuItem = null;

		if (results.isPresent()) {
			theMenuItem = results.get();

		} else {

			throw new RuntimeException("Did not find MenuItem id -" + theId);
		}

		return theMenuItem;

	}

	public void deleteById(int theId) {

		Optional<MenuItem> results = menuItemRepository.findById(theId);
		if (results.isPresent()) {
			menuItemRepository.deleteById(theId);
		} else {
			throw new RuntimeException("Did not find MenuItem id -" + theId);
		}

	}

}
