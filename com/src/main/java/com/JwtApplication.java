package com;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.User;
import com.repository.UserRepository;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class JwtApplication {

	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void initUsers()
	{
		List<User> users = Stream.of(new User(101,"user1","pwd1","user1@gmail.com")).collect(Collectors.toList());
		userRepository.saveAll(users);
	}
    
	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
