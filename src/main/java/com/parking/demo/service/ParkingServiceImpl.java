package com.parking.demo.service;



import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.demo.model.Parking;
import com.parking.demo.model.Reservation;
import com.parking.demo.model.ReservationInerface;
import com.parking.demo.repository.ParkingRepository;
@Service
public class ParkingServiceImpl  implements ParkingService {
	 @Autowired
	    private ParkingRepository parkingRepository;

	public Collection<Parking> findAllParkings(){
		return parkingRepository.findAll();
	}
	public	List<Reservation> findAllReservation(){
	
		List<Reservation> reserva = parkingRepository.findAllReservation().stream()
                .map(res ->
                new Reservation(res.getParking_id(), res.getUser_id()))
                .collect(Collectors.toList());
                
	//	List<ReservationInerface> Res=parkingRepository.findAllReservation();
		
		//List<Reservation> l=Res;
		return reserva;
	}

}
