package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.OrderMenu;

public interface OrderMenuRepository extends JpaRepository<OrderMenu, Integer> {

}
