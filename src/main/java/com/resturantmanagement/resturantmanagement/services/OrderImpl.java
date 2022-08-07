package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Order;
import com.resturantmanagement.resturantmanagement.repositories.OrderRepository;

@Service
public class OrderImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();

	}

	public Order save(Order theOrder) {

		return orderRepository.save(theOrder);

	}

	public Order findById(int theId) {

		Optional<Order> results = orderRepository.findById(theId);
		Order theOrder = null;

		if (results.isPresent()) {
			theOrder = results.get();

		} else {

			throw new RuntimeException("Did not find Order id -" + theId);
		}

		return theOrder;

	}

	public void deleteById(int theId) {

		orderRepository.deleteById(theId);
		Optional<Order> results = orderRepository.findById(theId);

		if (results.isPresent()) {
			orderRepository.deleteById(theId);

		} else {
			throw new RuntimeException("Did not find Order id -" + theId);
		}

	}

}
