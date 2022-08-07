package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.MenuCategory;

public interface MenuCategoryService {

	public List<MenuCategory> findAll();

	public void save(MenuCategory theMenuCategory);

	public MenuCategory findById(int theId);

	public void deleteById(int theId);

}
