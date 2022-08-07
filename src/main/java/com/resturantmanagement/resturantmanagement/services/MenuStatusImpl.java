package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.MenuStatus;
import com.resturantmanagement.resturantmanagement.repositories.MenuStatusRepository;

@Service
public class MenuStatusImpl implements MenuStatusService {

	@Autowired
	private MenuStatusRepository menuStatusRepository;

	@Override
	public List<MenuStatus> findAll() {
		// TODO Auto-generated method stub
		return menuStatusRepository.findAll();

	}

	public void save(MenuStatus theMenuStatus) {
		menuStatusRepository.save(theMenuStatus);

	}

	public MenuStatus findById(int theId) {

		Optional<MenuStatus> results = menuStatusRepository.findById(theId);
		MenuStatus theMenuStatus = null;

		if (results.isPresent()) {

			theMenuStatus = results.get();

		} else {

			throw new RuntimeException("Did not find MenuStatus id -" + theId);
		}

		return theMenuStatus;

	}

	public void deleteById(int theId) {

		Optional<MenuStatus> results = menuStatusRepository.findById(theId);
		MenuStatus theMenuStatus = null;

		if (results.isPresent()) {
			menuStatusRepository.deleteById(theId);

		} else {

			throw new RuntimeException("Did not find Menu Status id -" + theId);
		}

	}

}
