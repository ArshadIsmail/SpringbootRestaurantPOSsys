package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.MenuOrder;
import com.resturantmanagement.resturantmanagement.repositories.MenuOrderRepository;

@Service
public class MenuOrderImpl implements MenuOrderService {

	@Autowired
	private MenuOrderRepository menuOrderRepository;

	@Override
	public List<MenuOrder> findAll() {
		// TODO Auto-generated method stub
		return menuOrderRepository.findAll();
		
	}

	public void save(MenuOrder theMenuOrder) {
		menuOrderRepository.save(theMenuOrder);

	}

	public MenuOrder findById(int theId) {

		Optional<MenuOrder> results = menuOrderRepository.findById(theId);
		MenuOrder theMenuOrder = null;

		if (results.isPresent()) {
			theMenuOrder = results.get();

		} else {
			throw new RuntimeException("Did not find MenuOrder id -" + theId);
		}

		return theMenuOrder;

	}

	public void deleteById(int theId) {

		Optional<MenuOrder> results = menuOrderRepository.findById(theId);

		if (results.isPresent()) {
			menuOrderRepository.deleteById(theId);

		} else {
			throw new RuntimeException("Did not find MenuOrder id -" + theId);
		}

	}

}
