package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.OrderDineIn;

public interface OrderDineInRepository extends JpaRepository<OrderDineIn, Integer> {

}
