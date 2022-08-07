package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.resturantmanagement.resturantmanagement.models.OrderDineIn;
import com.resturantmanagement.resturantmanagement.repositories.OrderDineInRepository;

public class OrderDineInImpl implements OrderDineInService {

	@Autowired
	private OrderDineInRepository orderDineInRepository;

	@Override
	public List<OrderDineIn> findAll() {
		// TODO Auto-generated method stub
		return orderDineInRepository.findAll();
		
	}

	public void save(OrderDineIn theOrderDineIn) {
		orderDineInRepository.save(theOrderDineIn);

	}

	public OrderDineIn findById(int theId) {

		Optional<OrderDineIn> results = orderDineInRepository.findById(theId);
		OrderDineIn theOrderDineIn = null;

		if (results.isPresent()) {
			theOrderDineIn = results.get();

		} else {

			throw new RuntimeException("Did not find OrderDineIn id -" + theId);
		}

		return theOrderDineIn;

	}

	public void deleteById(int theId) {

		Optional<OrderDineIn> results = orderDineInRepository.findById(theId);
		if (results.isPresent()) {
               orderDineInRepository.deleteById(theId);

		} else {
			throw new RuntimeException("Did not find OrderDineIn id -" + theId);
		}

	}

}
