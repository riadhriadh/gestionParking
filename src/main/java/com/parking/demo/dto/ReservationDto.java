package com.parking.demo.dto;

import javax.validation.constraints.NotEmpty;

import com.parking.demo.model.Parking;
import com.parking.demo.model.User;

public class ReservationDto {
	 private Long id;

	  
	    private User user;
	    private Parking parking;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public Parking getParking() {
			return parking;
		}
		public void setParking(Parking parking) {
			this.parking = parking;
		}
		public ReservationDto(Long id, User user, Parking parking) {
			
			this.id = id;
			this.user = user;
			this.parking = parking;
		}
	    

}
