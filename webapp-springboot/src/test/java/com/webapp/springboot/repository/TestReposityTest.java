package com.webapp.springboot.repository;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.webapp.springboot.model.dummy.TestModel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestReposityTest {

	@Autowired
	private TestRepository testRepository;
	
	@Before
	public void prepareData() {
		TestModel testModel = new TestModel();
		testModel.setName("Do Minh Cao Vu");
		testModel.setAddress("CMT8");
		testRepository.save(testModel);
	}
	
	@Test
	public void testData() {
		TestModel td = testRepository.findByName("Do Minh Cao Vu");
		Assert.assertNotNull(td);
	}
}
