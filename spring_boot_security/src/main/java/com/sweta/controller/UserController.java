package com.sweta.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweta.entity.User;
import com.sweta.repository.UserRepository;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/admin")
	public String adminAccess()
	{
		return "Welcome Admin!";
	}
	@GetMapping("/anyone")
	public String anyoneAccess()
	{
		return "Welcome Everyone!";
	}
	@GetMapping("/nonadmin")
	public String userAccess()
	{
		return "Welcome User!";
	}

	
	@PostMapping("/add")
	
	    public User saveUsers(@RequestBody User user) {
	        return userRepository.save(user);
	    }
}
