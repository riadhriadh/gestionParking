package com.parking.demo.service;



import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import  com.parking.demo.model.User;
import  com.parking.demo.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	Collection<User> findAllUsers();
    User findByEmail(String email);
    Optional<User> findById(Long id);
    User UpdateUser(User user);
    User save(UserRegistrationDto registration);
    User saveNew(User user);
    void deleteById(Long id);
}