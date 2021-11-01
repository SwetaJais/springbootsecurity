package com.sweta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sweta.config.MyUserDetailsService;
import com.sweta.entity.Student;
import com.sweta.model.JWTRequest;
import com.sweta.model.JWTResponse;
import com.sweta.repository.StudentRepository;
import com.sweta.utility.JWTUtility;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

//to add Student
	@PostMapping("/add")
	public Student saveStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}


//get All Student
	@GetMapping("/get")
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

//get Student by id
	@GetMapping("/getById/{id}")
	public Optional<Student> findStudentById(@PathVariable("id") long id) {
		return studentRepository.findById(id);
	}

//For JWT
	@PostMapping("/authenticate")
	public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

		final String token = jwtUtility.generateToken(userDetails);

		return new JWTResponse(token);

	}

}
