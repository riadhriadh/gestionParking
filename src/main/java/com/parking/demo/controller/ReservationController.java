package com.parking.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parking.demo.dto.ReservationDto;
import com.parking.demo.model.Parking;
import com.parking.demo.model.ReservationParking;
import com.parking.demo.model.User;
import com.parking.demo.service.ParkingService;
import com.parking.demo.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	 @Autowired
	  private ReservationService reservationService;
	 @GetMapping("")
	    public String  ReservationIndex(Model model) {
		
	
		
		 reservationService.findAllReservation();
		 List<ReservationDto> listResevation =  new ArrayList<ReservationDto>();
			reservationService.findAllReservation().stream().forEach(acc -> {

				ReservationDto p = new ReservationDto(acc.getId(),acc.getUser(),acc.getParking());
				
				listResevation.add(p);
			});
			
			
			 model.addAttribute("parkings", listResevation);
		 //	 model.addAttribute("parkings", parkingService.findAllParkings());
		 System.out.println(listResevation);
	        return "reservation/index";
	    }
	 
	 @GetMapping("/edit")
	    public String  ReservationEdit(Model model) {
		 Long l=(long) 2;
		 System.out.println(reservationService.findReservationByid(l));
		 model.addAttribute("reservation", reservationService.findReservationByid(l));
		 

		 return "reservation/edit";
		 
	 }
	 @GetMapping("/add")
	    public String  ReservationAdd(@RequestParam  long id, Model model) {
		

		 return "reservation/add";
		 
	 }
	 
	
}
