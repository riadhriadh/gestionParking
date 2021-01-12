package com.parking.demo.service;



import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.demo.model.Parking;
import com.parking.demo.repository.ParkingRepository;
@Service
public class ParkingServiceImpl  implements ParkingService {
	 @Autowired
	    private ParkingRepository parkingRepository;

	public Collection<Parking> findAllParkings(){
		return parkingRepository.findAll();
	}
	
	public	Parking  save(Parking p) {
		return parkingRepository.save(p);
		
	}
	public	void deleteById(Long id) {
		parkingRepository.deleteById(id);
		
	}
	public	Optional<Parking>  findById(Long id) {
		return parkingRepository.findById(id);
		
		
	}
	
	
}
