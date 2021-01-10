package com.parking.demo.service;

import java.util.Collection;
import java.util.List;

import com.parking.demo.model.Parking;
import com.parking.demo.model.Reservation;
import com.parking.demo.model.ReservationInerface;







public interface ParkingService  {
	Collection<Parking> findAllParkings();
	List<Reservation> findAllReservation();

}
