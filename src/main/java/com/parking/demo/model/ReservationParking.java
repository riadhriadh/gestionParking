package com.parking.demo.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ReservationParking  {
	public ReservationParking(){}
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "user_id")
	    private User user;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "parking_id")
	    private Parking parking;

	    private Date reservationDate;

	    public ReservationParking(User user, Date reservationDate) {
	        this.user = user;
	        this.reservationDate = reservationDate;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof ReservationParking)) return false;
	        ReservationParking that = (ReservationParking) o;
	        return Objects.equals(user.getFirstName(), that.user.getFirstName()) &&
	                Objects.equals(parking.getName(), that.parking.getName()) &&
	                Objects.equals(reservationDate, that.reservationDate);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(user.getEmail(), parking.getName(), reservationDate);
	    }

		public ReservationParking(Long id, User user, Parking parking, Date reservationDate) {
			super();
			this.id = id;
			this.user = user;
			this.parking = parking;
			this.reservationDate = reservationDate;
		}

		public ReservationParking(Long id, User user, Parking parking) {
			super();
			this.id = id;
			this.user = user;
			this.parking = parking;
			
		}
		public ReservationParking(User user, Parking parking, Date reservationDate) {
			super();
			this.user = user;
			this.parking = parking;
			this.reservationDate = reservationDate;
		}

		public ReservationParking(User user, Parking parking) {
			super();
			this.user = user;
			this.parking = parking;
		}

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

		public Date getReservationDate() {
			return reservationDate;
		}

		public void setReservationDate(Date reservationDate) {
			this.reservationDate = reservationDate;
		}

}

