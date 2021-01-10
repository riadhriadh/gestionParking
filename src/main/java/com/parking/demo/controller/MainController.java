package com.parking.demo.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parking.demo.model.User;
import com.parking.demo.service.UserService;

@Controller
public class MainController {
	  @Autowired
	    private UserService userService;
    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    

    @GetMapping("/user/all")
    public String userIndex(Model model) {
    	 model.addAttribute("users", userService.findAllUsers());
    	
        return "user/index";
    }
    @GetMapping("/user/edit")
    public String showUpdateForm(@RequestParam  long id, Model model) {
        User user = userService.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
       
        model.addAttribute("user", user);
        return "user/edit";
    }
    @GetMapping("/user/delete")
    public String showUpdateForm(@RequestParam  long id) {
    	userService.deleteById(id);
        
        return "redirect:/user/all";
    }
    @GetMapping("/user/add")
    public String addUser(Model model) {
    	
        
    	 return "user/add";
    }
    @PostMapping("/user/add")
    public String addUserNew(User user) {
    	userService.saveNew(user);
        System.out.println(user);
    	 return "/user/all";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, 
  
    		BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            
            return "update-user";
        }
     
     
    
   Optional<User> u=  userService.findById(id);
    
            user.setPassword(u.get().getPassword());
        userService.UpdateUser(user);
        return "redirect:/user/all";
    }
 
    
}