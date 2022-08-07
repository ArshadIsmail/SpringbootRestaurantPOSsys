package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String Username);

}
