package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.User;
import com.resturantmanagement.resturantmanagement.models.User;
import com.resturantmanagement.resturantmanagement.repositories.UserRepository;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);

	}

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User findById(int theId) {

		Optional<User> results = userRepository.findById(theId);

		User theUser = null;

		if (results.isPresent()) {
			theUser = results.get();
		} else {
			throw new RuntimeException("Did not find User id -" + theId);
		}

		return theUser;

	}

	public void deleteById(int theId) {

		userRepository.deleteById(theId);

	}

}
