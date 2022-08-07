package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
