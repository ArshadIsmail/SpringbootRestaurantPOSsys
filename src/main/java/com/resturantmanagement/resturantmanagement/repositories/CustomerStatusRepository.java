package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.CustomerStatus;

public interface CustomerStatusRepository extends JpaRepository<CustomerStatus, Integer> {

}
