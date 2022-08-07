package com.resturantmanagement.resturantmanagement.services;

import java.util.List;

import com.resturantmanagement.resturantmanagement.models.DeliveryStatus;

public interface DeliveryStatusService {

	public List<DeliveryStatus> findAll();

	public void save(DeliveryStatus theDeliveryStatus);

	public DeliveryStatus findById(int theId);

	public void deleteById(int theId);

}
