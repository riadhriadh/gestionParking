package com.parking.demo.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.demo.model.Parking;
import com.parking.demo.model.ReservationParking;
@Repository
public interface ReservationRepository  extends JpaRepository < ReservationParking, Long > {

	

	
}
