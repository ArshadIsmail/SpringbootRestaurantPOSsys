package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.Order;

public interface OrderService {

	public List<Order> findAll();

	public Order save(Order theOrder);

	public Order findById(int theId);

	public void deleteById(int theId);

}
