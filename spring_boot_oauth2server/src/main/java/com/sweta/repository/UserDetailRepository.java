package com.sweta.repository;

import java.util.Optional;
import com.sweta.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String name);
}
