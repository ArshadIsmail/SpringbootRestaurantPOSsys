package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.OrderStatus;

public interface OrderStatusService {
	public List<OrderStatus> findAll();

	public void save(OrderStatus theOrderStatus);

	public OrderStatus findById(int theId);

	public void deleteById(int theId);
}
