package com.parking.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;

import com.parking.demo.dto.ReservationDto;
import com.parking.demo.model.Parking;
import com.parking.demo.model.ReservationParking;
import com.parking.demo.model.User;
import com.parking.demo.service.ParkingService;
import com.parking.demo.service.ReservationService;
import com.parking.demo.service.UserService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	 @Autowired
	  private ReservationService reservationService;
	  @Autowired
	    private UserService userService;
	  @Autowired
	  private ParkingService parkingService;
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
	    public String  ReservationAdd(@RequestParam  long id, Model model,HttpSession session) {
		String email =SecurityContextHolder.getContext().getAuthentication().getName();
		User user=		userService.findByEmail(email);
		 Optional<Parking> p=  parkingService.findById(id);
		 Parking park= p.get();
		
		ReservationParking res= new ReservationParking(user,park);
		   reservationService.saveNew(res);
		   return "redirect:/reservation";
		 
	 }
	
	 @GetMapping("/delete")
	    public String  ReservationDelete(@RequestParam  long id) {
		 System.out.println(id);
		 reservationService.delete(id);

		  return "redirect:/reservation";
		 
	 }
	
	
}
