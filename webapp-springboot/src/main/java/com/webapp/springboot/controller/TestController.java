package com.webapp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.springboot.entity.role.Role;
import com.webapp.springboot.entity.role.User;
import com.webapp.springboot.repository.UserRepository;

@RestController
public class TestController {

	@Autowired
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@GetMapping(value = "/test")
	public String test() {
		return "Success";
	}
	
	@GetMapping(value = "/init")
	public User createDataUser() {
		Role admin = new Role("ADMIN");
		Role user = new Role("USER");
		
		User user1 = new User("vudo0833dp", bCryptPasswordEncoder.encode("uv#@o@c$"));
		User user2 = new User("user001", bCryptPasswordEncoder.encode("passworduser001"));
		
		// set role
		user1.setRole(admin);
		user1.setRole(user);
		
		user2.setRole(user);
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		return userRepository.findByUsername("vudo0833dp");
	}
	
	@GetMapping(value = "/getUser")
	public User getUser() {
		return userRepository.findByUsername("vudo0833dp");
	}
	
	
	
}
