package com.parking.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.demo.model.Parking;
import com.parking.demo.model.Reservation;
import com.parking.demo.model.ReservationInerface;




@Repository
public interface ParkingRepository  extends JpaRepository < Parking, Long > {
	@Query(value = "SELECT * FROM reservation", 
			  nativeQuery = true)
	List<ReservationInerface> findAllReservation();

	
	
}

