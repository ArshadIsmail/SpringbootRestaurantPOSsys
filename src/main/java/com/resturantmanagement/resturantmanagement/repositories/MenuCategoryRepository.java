package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.MenuCategory;

public interface MenuCategoryRepository extends JpaRepository<MenuCategory, Integer> {

}
