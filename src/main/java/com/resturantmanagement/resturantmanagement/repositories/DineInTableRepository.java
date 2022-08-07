package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.DineInTable;

public interface DineInTableRepository extends JpaRepository<DineInTable, Integer> {

}
