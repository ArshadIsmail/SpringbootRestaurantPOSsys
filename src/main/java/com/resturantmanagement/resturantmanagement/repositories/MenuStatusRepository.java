package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.MenuStatus;

public interface MenuStatusRepository extends JpaRepository<MenuStatus, Integer> {

}
