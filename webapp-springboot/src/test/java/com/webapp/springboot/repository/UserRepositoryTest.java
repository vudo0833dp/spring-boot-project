package com.webapp.springboot.repository;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.webapp.springboot.entity.role.Role;
import com.webapp.springboot.entity.role.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	public void testData(){
		Role admin = new Role("ADMIN");
		Role user = new Role("USER");
		
		User user1 = new User("vudo0833dp", bCryptPasswordEncoder.encode("uv#@o@c$"));
		User user2 = new User("user001", bCryptPasswordEncoder.encode("passworduser001"));
		
		// set role
		user1.setRole(admin);
		user1.setRole(user);
		
		user2.setRole(user);
		
		userRepository.save(user1);
		userRepository.save(user2);
		
		Assert.assertNotNull(userRepository.findByUsername("vudo0833dp"));
	}
}
