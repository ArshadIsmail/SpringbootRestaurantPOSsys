package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.MenuOrder;

public interface MenuOrderRepository extends JpaRepository<MenuOrder, Integer> {

}
