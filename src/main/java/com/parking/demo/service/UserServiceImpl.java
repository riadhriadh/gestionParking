package com.parking.demo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.parking.demo.model.Role;
import com.parking.demo.model.User;
import com.parking.demo.repository.UserRepository;
import com.parking.demo.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }
    
    public   User saveNew(User use) {
    	 User user = new User();
         user.setFirstName(use.getFirstName());
         user.setLastName(use.getLastName());
         user.setEmail(use.getEmail());
         user.setPassword(passwordEncoder.encode(use.getPassword()));
         user.setRoles(Arrays.asList(new Role("ROLE_USER")));
         return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }
    
    public	Collection<User> findAllUsers(){
		return userRepository.findAll();
		
    }
    public Optional<User> findById(Long id) {
    	
    		return userRepository.findById(id);
    	
    }
    public User UpdateUser(User user) {
    	
    	
    	return userRepository.save(user);
    }
    public void deleteById(Long id) {
 
    	 userRepository.deleteById(id);
    }
    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
    	
    	
    	return roles.stream()
    			.map( role ->
            new SimpleGrantedAuthority(role.getName())
          
            )
            .collect(Collectors.toList());
    }
}