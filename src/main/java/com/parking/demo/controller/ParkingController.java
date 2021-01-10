package com.parking.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parking.demo.model.Parking;
import com.parking.demo.service.ParkingService;



@Controller
@RequestMapping("/parking")
public class ParkingController {
	 @Autowired
	  private ParkingService parkingService;
	 
	 @GetMapping("")
	    public String  PakingC(Model model) {
	    	 model.addAttribute("parkings", parkingService.findAllParkings());
		 System.out.println( parkingService.findAllParkings());
	        return "parking/index";
	    }
	 @PostMapping("/{email}/{id}")
	 public String  PakingReserver() {
    	
	 System.out.println( parkingService.findAllParkings());
        return "reservation/index";
    }
	 @GetMapping("/add")
	    public String  PakingAdd() {
	    	
	        return "parking/add";
	    }
	 @PostMapping("/add")
	    public String  PakingAddNEW( Parking parking) {
	    	System.out.println(parking);
	         parking.setDespo(parking.getPlace());
	    	parkingService.save(parking);
		 return "redirect:/parking";
	    }
	  @GetMapping("/delete")
	    public String showUpdateForm(@RequestParam  long id) {
		  parkingService.deleteById(id);
	        
	        return "redirect:/parking";
	    }
	 
	 

}
