package com.sweta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sweta.entity.User;
import com.sweta.repository.UserRepository;


@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
	//	MyUserDetails myUserDetails = null;
		if(user == null)
		{
				throw new UsernameNotFoundException("User not found");
		}
		return new MyUserDetails(user);  
	}

}
