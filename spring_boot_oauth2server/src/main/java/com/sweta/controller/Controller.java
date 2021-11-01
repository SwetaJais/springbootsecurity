package com.sweta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweta.entity.User;
import com.sweta.repository.UserDetailRepository;

@RestController
@RequestMapping("/users")
public class Controller {
	
	@Autowired
	UserDetailRepository userDetailRepository;

	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome! to OAUTH 2 Authorization Server and Resourse Server World";
	}
	
	@GetMapping("/get")
	public List<User> getAllStudent() {
		return userDetailRepository.findAll();
	}
	
}
