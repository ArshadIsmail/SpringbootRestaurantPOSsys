package com.resturantmanagement.resturantmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resturantmanagement.resturantmanagement.models.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

}
