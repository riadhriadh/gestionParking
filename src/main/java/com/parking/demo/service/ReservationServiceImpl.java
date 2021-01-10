package com.parking.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.demo.model.ReservationParking;
import com.parking.demo.repository.ReservationRepository;
import com.parking.demo.repository.UserRepository;

@Service
public class ReservationServiceImpl  implements ReservationService{
	  @Autowired
	    private ReservationRepository reservationRepository;
	  public Collection<ReservationParking> findAllReservation(){
		return  reservationRepository.findAll();
	}
	  public  Optional<ReservationParking> findReservationByid(Long id) {
		  return  reservationRepository.findById(id);
	  }
	
}
