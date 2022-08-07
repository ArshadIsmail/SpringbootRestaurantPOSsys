package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.OrderStatus;
import com.resturantmanagement.resturantmanagement.repositories.OrderStatusRepository;

@Service
public class OrderStatusImpl implements OrderStatusService {

	@Autowired
	private OrderStatusRepository orderStatusRepository;

	@Override
	public List<OrderStatus> findAll() {
		// TODO Auto-generated method stub
		return orderStatusRepository.findAll();
		
	}

	public void save(OrderStatus theOrderStatus) {
		orderStatusRepository.save(theOrderStatus);

	}

	public OrderStatus findById(int theId) {

		Optional<OrderStatus> results = orderStatusRepository.findById(theId);
		OrderStatus theOrderStatus = null;

		if (results.isPresent()) {
			theOrderStatus = results.get();

		} else {
			throw new RuntimeException("Did not find OrderStatus id -" + theId);
		}

		return theOrderStatus;

	}

	public void deleteById(int theId) {

		Optional<OrderStatus> results = orderStatusRepository.findById(theId);
		if (results.isPresent()) {
			orderStatusRepository.deleteById(theId);
		} else {
			throw new RuntimeException("id not found  -" + theId);
		}

	}

}
