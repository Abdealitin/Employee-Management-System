package com.yash.test;

import static org.junit.Assert.assertEquals;

//import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.yash.configuration.EmployeeConfiguration;
import com.yash.model.Employee;
import com.yash.repository.EmployeeRepository;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmployeeConfiguration.class},loader = AnnotationConfigContextLoader.class)
@Transactional
public class EmployeeRepositoryTest {
	
//	@Resource
	private EmployeeRepository employeeRepository;
	
	@Test
	public void givenStudent_whenSave_thenGetOk() {
		Employee e = new Employee(7,"Test",0,"Test","Test","Test");
		employeeRepository.save(e);
		
		Employee e1 = (Employee) employeeRepository.findOne(7);
		log.info("Test Ran Successfully!");
		assertEquals("Test",e1.getName());
		
	}
	
}
