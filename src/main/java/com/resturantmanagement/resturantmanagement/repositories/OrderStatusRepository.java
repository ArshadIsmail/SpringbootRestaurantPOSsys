package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.OrderStatus;


public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {

}
