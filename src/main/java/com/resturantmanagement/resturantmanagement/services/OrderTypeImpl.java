package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.OrderType;
import com.resturantmanagement.resturantmanagement.repositories.OrderTypeRepository;

@Service
public class OrderTypeImpl implements OrderTypeService {

	@Autowired
	private OrderTypeRepository orderTypeRepository;

	@Override
	public List<OrderType> findAll() {
		// TODO Auto-generated method stub
		return orderTypeRepository.findAll();

	}

	public void save(OrderType theOrderType) {
		orderTypeRepository.save(theOrderType);

	}

	public OrderType findById(int theId) {

		Optional<OrderType> results = orderTypeRepository.findById(theId);
		OrderType theOrderType = null;

		if (results.isPresent()) {
			theOrderType = results.get();

		} else {
			throw new RuntimeException("Did not find OrderType id -" + theId);
		}

		return theOrderType;

	}

	public void deleteById(int theId) {

		orderTypeRepository.deleteById(theId);
		Optional<OrderType> results = orderTypeRepository.findById(theId);

		if (results.isPresent()) {
			orderTypeRepository.deleteById(theId);

		} else {
			throw new RuntimeException("Id not found -" + theId);
		}

	}

}
