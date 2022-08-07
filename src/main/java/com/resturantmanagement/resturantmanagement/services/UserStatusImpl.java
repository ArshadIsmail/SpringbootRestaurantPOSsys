package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.UserStatus;
import com.resturantmanagement.resturantmanagement.repositories.UserStatusRepository;

@Service
public class UserStatusImpl implements UserStatusService {

	@Autowired
	UserStatusRepository userStatusRepository;

	public List<UserStatus> findAll() {
		return userStatusRepository.findAll();
	}

	@Override
	public UserStatus getDefaulUserStatus() {

		int theDefaultUserStatus = 1;// USER

		Optional<UserStatus> userStatusOptional = userStatusRepository.findById(theDefaultUserStatus);
		UserStatus userStatus = null;

		if (userStatusOptional.isPresent()) {

			userStatus = userStatusOptional.get();

		} else {

			throw new RuntimeException("Did not find theDefaultUserStatus id -" + theDefaultUserStatus);
		}

		return userStatus;
	}

}
