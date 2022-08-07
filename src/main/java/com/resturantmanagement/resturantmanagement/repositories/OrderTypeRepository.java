package com.resturantmanagement.resturantmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.OrderType;

public interface OrderTypeRepository extends JpaRepository<OrderType, Integer> {
	
	
	
	
}
