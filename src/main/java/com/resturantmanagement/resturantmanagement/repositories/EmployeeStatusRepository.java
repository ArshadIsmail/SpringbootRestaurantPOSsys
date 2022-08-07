package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.EmployeeStatus;

public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatus, Integer> {

}
