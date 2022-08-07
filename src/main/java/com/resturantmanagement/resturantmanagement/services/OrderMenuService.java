package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.OrderMenu;

public interface OrderMenuService {

	public List<OrderMenu> findAll();

	public void save(OrderMenu theOrderMenu);

	public OrderMenu findById(int theId);

	public void deleteById(int theId);

}
