package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.User;


public interface UserService {
	
	
	public void save(User user);
	
	public List<User> findAll();
	
     public User findById(int theId);
	
	public void deleteById(int theId);
 

	
	

}
