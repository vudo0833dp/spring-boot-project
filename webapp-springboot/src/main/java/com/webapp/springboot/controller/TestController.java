package com.webapp.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.springboot.model.dummy.TestModel;
import com.webapp.springboot.repository.TestRepository;

@RestController
public class TestController {

	@Autowired
	private TestRepository testRepository;
	
	@GetMapping(value = "/test")
	public String test() {
		return "Success";
	}
	
	@GetMapping(value = "/data")
	public TestModel getTestModel() {
		TestModel testModel = new TestModel();
		testModel.setName("Do Minh Cao Vu");
		testModel.setAddress("CMT8");
		return testRepository.save(testModel);
	}
}
