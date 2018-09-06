package com.webapp.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapp.springboot.model.dummy.TestModel;

@Repository
public interface TestRepository extends CrudRepository<TestModel, Long>{

	TestModel findByName(String name);
}
