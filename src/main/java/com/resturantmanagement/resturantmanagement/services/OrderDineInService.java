package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.OrderDineIn;

public interface OrderDineInService {

	public List<OrderDineIn> findAll();

	public void save(OrderDineIn theOrderDineIn);

	public OrderDineIn findById(int theId);

	public void deleteById(int theId);

}
