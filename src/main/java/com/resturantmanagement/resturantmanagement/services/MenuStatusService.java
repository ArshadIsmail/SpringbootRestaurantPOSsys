package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.MenuStatus;

public interface MenuStatusService {

	public List<MenuStatus> findAll();

	public void save(MenuStatus theMenuType);

	public MenuStatus findById(int theId);

	public void deleteById(int theId);

}
