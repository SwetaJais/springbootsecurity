package com.sweta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweta.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// @Query("SELECT u FROM User u WHERE u.username = :username")
	// public User getUserByUsername(@Param("username") String username);
	 
	 User findByUsername(String username);
}
