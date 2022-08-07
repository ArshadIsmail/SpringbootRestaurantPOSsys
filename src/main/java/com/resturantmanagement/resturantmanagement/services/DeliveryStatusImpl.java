package com.resturantmanagement.resturantmanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resturantmanagement.resturantmanagement.models.DeliveryStatus;
import com.resturantmanagement.resturantmanagement.repositories.DeliveryStatusRepository;

@Service
public class DeliveryStatusImpl implements DeliveryStatusService {

	@Autowired
	private DeliveryStatusRepository deliveryStatusRepository;

	@Override
	public List<DeliveryStatus> findAll() {
		// TODO Auto-generated method stub
		return deliveryStatusRepository.findAll();

	}

	public void save(DeliveryStatus theDeliveryStatus) {
		deliveryStatusRepository.save(theDeliveryStatus);

	}

	public DeliveryStatus findById(int theId) {

		Optional<DeliveryStatus> results = deliveryStatusRepository.findById(theId);
		DeliveryStatus theDeliveryStatus = null;

		if (results.isPresent()) {
			theDeliveryStatus = results.get();
		} else {
			throw new RuntimeException("Did not find DeliveryStatus id -" + theId);
		}

		return theDeliveryStatus;

	}

	public void deleteById(int theId) {

		Optional<DeliveryStatus> results = deliveryStatusRepository.findById(theId);
		if (results.isPresent()) {
			deliveryStatusRepository.deleteById(theId);
		} else {
			throw new RuntimeException("No id -" + theId);
		}

	}

}
