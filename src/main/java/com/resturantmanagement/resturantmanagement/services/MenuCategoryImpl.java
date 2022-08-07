package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.MenuCategory;
import com.resturantmanagement.resturantmanagement.repositories.MenuCategoryRepository;

@Service
public class MenuCategoryImpl implements MenuCategoryService {

	@Autowired
	private MenuCategoryRepository menuCategoryRepository;

	public List<MenuCategory> findAll() {
		// TODO Auto-generated method stub
		return menuCategoryRepository.findAll();
		
	}

	public void save(MenuCategory theMenuCategory) {
		menuCategoryRepository.save(theMenuCategory);

	}

	public MenuCategory findById(int theId) {

		Optional<MenuCategory> results = menuCategoryRepository.findById(theId);
		MenuCategory theMenuCategory = null;

		if (results.isPresent()) {
			theMenuCategory = results.get();
		} else {
			throw new RuntimeException("Did not find MenuCategory id -" + theId);
		}

		return theMenuCategory;

	}

	public void deleteById(int theId) {

		Optional<MenuCategory> results = menuCategoryRepository.findById(theId);

		if (results.isPresent()) {
			menuCategoryRepository.deleteById(theId);

		} else {
			throw new RuntimeException("Did not find MenuCategory id -" + theId);
		}

	}

}
