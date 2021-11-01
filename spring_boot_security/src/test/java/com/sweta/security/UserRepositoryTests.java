package com.sweta.security;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sweta.entity.User;
import com.sweta.repository.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository userrepo;
    
    //testmethods
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setUsername("Anil");
        user.setPassword("anil109");
        user.setEnabled(true);
        User savedUser = userrepo.save(user);
         
        User existUser = entityManager.find(User.class, savedUser.getId());
         
        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());
         
    }
}
