package com.yash.datajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yash.datajpa.model.Employee;
import com.yash.datajpa.repository.EmployeeRepository;
import com.yash.datajpa.service.EmployeeService;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SpringCrud1ApplicationTests {
	
	@Autowired
	EmployeeRepository employeeRepository; 
	
	@Autowired
	EmployeeService employeeService; 
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ApplicationContext applicationContext;

	
	@Test
	public void check_InjectedComponentsAreNotNull() {
		Assert.assertNotNull(employeeRepository);
		Assert.assertNotNull(employeeService);
		Assert.assertNotNull(dataSource);
		Assert.assertNotNull(applicationContext);
	}
	
	@Test
	public void whenSave_thenFindById() {
		Employee e = new Employee(8,"Test",20,"Test","Test","Test");
		
		employeeRepository.save(e);
		log.info("Test Ran Successfully");
		assertEquals(e.getName(),employeeRepository.findById(8).get().getName());
	}
	
	
	
}
