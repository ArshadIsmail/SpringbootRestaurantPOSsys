package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.Delivery;
import com.resturantmanagement.resturantmanagement.repositories.DeliveryRepository;

@Service
public class DeliveryImpl implements DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;

	@Override
	public List<Delivery> findAll() {
		// TODO Auto-generated method stub
		return deliveryRepository.findAll();

	}

	public void save(Delivery theDelivery) {
		deliveryRepository.save(theDelivery);

	}

	public Delivery findById(int theId) {

		Optional<Delivery> results = deliveryRepository.findById(theId);
		Delivery theDelivery = null;

		if (results.isPresent()) {
			theDelivery = results.get();
		} else {
			throw new RuntimeException("Did not find Delivery id -" + theId);
		}

		return theDelivery;

	}

	public void deleteById(int theId) {

		Optional<Delivery> results = deliveryRepository.findById(theId);
		if (results.isPresent()) {
			deliveryRepository.deleteById(theId);
		} else {
			throw new RuntimeException("Did not find Delivery id -" + theId);
		}

	}

}
