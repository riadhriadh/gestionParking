package com.parking.demo.service;

import java.util.Collection;
import java.util.List;

import com.parking.demo.model.Parking;
import com.parking.demo.model.Reservation;
import com.parking.demo.model.ReservationInerface;
import com.parking.demo.model.User;







public interface ParkingService  {
	Collection<Parking> findAllParkings();
	Parking  save(Parking p);
	List<Reservation> findAllReservation();
	void deleteById(Long id);

}
