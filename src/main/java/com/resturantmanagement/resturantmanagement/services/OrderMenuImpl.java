package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.OrderMenu;
import com.resturantmanagement.resturantmanagement.models.OrderMenu;
import com.resturantmanagement.resturantmanagement.repositories.OrderMenuRepository;

@Service
public class OrderMenuImpl implements OrderMenuService {

	@Autowired
	private OrderMenuRepository orderMenuRepository;

	@Override
	public List<OrderMenu> findAll() {
		// TODO Auto-generated method stub
		return orderMenuRepository.findAll();

	}

	public void save(OrderMenu theOrderMenu) {
		orderMenuRepository.save(theOrderMenu);

	}

	public OrderMenu findById(int theId) {

		Optional<OrderMenu> results = orderMenuRepository.findById(theId);
		OrderMenu theOrderMenu = null;

		if (results.isPresent()) {
			theOrderMenu = results.get();

		} else {
			throw new RuntimeException("Did not find OrderMenu id -" + theId);
		}

		return theOrderMenu;

	}

	public void deleteById(int theId) {

		orderMenuRepository.deleteById(theId);
		Optional<OrderMenu> results = orderMenuRepository.findById(theId);

		if (results.isPresent()) {

			orderMenuRepository.deleteById(theId);

		} else {
			
			throw new RuntimeException("Did not find OrderMenu id -" + theId);
		}

	}

}
