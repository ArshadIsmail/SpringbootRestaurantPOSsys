package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.Delivery;

public interface DeliveryService {

	public List<Delivery> findAll();

	public void save(Delivery theDelivery);

	public Delivery findById(int theId);

	public void deleteById(int theId);

}
