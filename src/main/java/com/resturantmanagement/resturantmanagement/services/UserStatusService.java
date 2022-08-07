package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.UserStatus;

public interface UserStatusService {

	
	public List<UserStatus> findAll();
	
	public  UserStatus getDefaulUserStatus();

}
