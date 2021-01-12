package com.parking.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.parking.demo.model.Parking;
import com.parking.demo.model.User;







public interface ParkingService  {
	Collection<Parking> findAllParkings();
	Parking  save(Parking p);
	Optional<Parking>     findById(Long id);
	void deleteById(Long id);

}
