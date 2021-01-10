package com.parking.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class ParkingDto {
	@NotEmpty
    private String firstName;

    @NotEmpty
    private String name;

    @NotEmpty
    private String place;

    private Integer despo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getDespo() {
		return despo;
	}

	public void setDespo(Integer despo) {
		this.despo = despo;
	}
    
}
