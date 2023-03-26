package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.JWTRequest;
import com.util.JwtUtil;

@RestController
public class JwtController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String welcome()
	{
		return "Welcome to JWT Spring Security";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody JWTRequest jwtRequest) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
	}catch (Exception e) {
		// TODO: handle exception
		throw new Exception("invalid username or password");
	}
		return jwtUtil.generateToken(jwtRequest.getUsername());
	}
}
