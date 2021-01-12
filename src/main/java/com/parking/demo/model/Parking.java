package com.parking.demo.model;

import java.util.HashSet;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Parking {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private String name;
	    private Integer place;
	    private Integer despo;

	    public Parking() {}

	    public Parking(String name,Integer place) {
	        this.name = name;
	        this.place =place;
	        this.despo=place;
	    }
	    public Parking(String name,Integer place,Integer despo) {
	        this.name = name;
	        this.place =place;
	        this.despo=despo;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getPlace() {
			return place;
		}

		public void setPlace(Integer place) {
			this.place = place;
		}

		public Integer getDespo() {
			return despo;
		}

		public void setDespo(Integer despo) {
			this.despo = despo;
		}

	    
		@Override
		public String toString() {
			return "Parking [id=" + id + ", name=" + name + ", place=" + place + ", despo=" + despo + "]";
		}


	  

	   

}
