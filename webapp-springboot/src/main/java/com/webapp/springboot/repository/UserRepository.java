package com.webapp.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapp.springboot.entity.role.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String name);
}
