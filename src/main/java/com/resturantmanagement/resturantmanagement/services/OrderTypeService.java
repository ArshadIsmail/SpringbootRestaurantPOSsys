package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.OrderType;

public interface OrderTypeService {

	public List<OrderType> findAll();

	public void save(OrderType theOrderType);

	public OrderType findById(int theId);

	public void deleteById(int theId);
}
