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

import com.sweta.entity.Student;
import com.sweta.repository.StudentRepository;



@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;


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

}
