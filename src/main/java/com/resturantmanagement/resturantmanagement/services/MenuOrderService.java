package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.MenuOrder;

public interface MenuOrderService {

	public List<MenuOrder> findAll();

	public void save(MenuOrder theMenuOrder);

	public MenuOrder findById(int theId);

	public void deleteById(int theId);

}
