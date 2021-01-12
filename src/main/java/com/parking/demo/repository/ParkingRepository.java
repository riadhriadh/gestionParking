package com.parking.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.demo.model.Parking;





@Repository
public interface ParkingRepository  extends JpaRepository < Parking, Long > {
	
	
	
}

