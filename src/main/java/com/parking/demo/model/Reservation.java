package com.parking.demo.model;

public class Reservation  implements ReservationInerface{
	 private Long parking_id;
	private Long user_id;
	public Long getParking_id() {
		return parking_id;
	}
	public void setParking_id(Long parking_id) {
		this.parking_id = parking_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Reservation(Long parking_id, Long user_id) {
		super();
		this.parking_id = parking_id;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Reservation [parking_id=" + parking_id + ", user_id=" + user_id + "]";
	}
	
	
}
