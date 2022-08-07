package com.resturantmanagement.resturantmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.OrderType;
import com.resturantmanagement.resturantmanagement.models.UserStatus;


public interface UserStatusRepository extends JpaRepository<UserStatus, Integer> {

	

}
