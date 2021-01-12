package com.parking.demo.service;



import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.parking.demo.model.Parking;
import com.parking.demo.model.ReservationParking;
import com.parking.demo.model.User;

public interface ReservationService {
	Collection<ReservationParking> findAllReservation();
	Optional<ReservationParking> findReservationByid(Long id);
	ReservationParking saveNew(ReservationParking parking);
	void delete(Long id);

}
