package com.yash.test;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ViewResolver;

import com.yash.configuration.EmployeeConfiguration;
import com.yash.configuration.EmployeeIntializer;
import com.yash.dao.EmployeeDao;
import com.yash.service.EmployeeService;
import com.yash.web.EmployeeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmployeeConfiguration.class, EmployeeIntializer.class})
public class DependencyTest {
	
	@Autowired
	Environment environment;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	ViewResolver viewResolver;
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeController employeeController;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Test
	public void checkInjectedDependenciesAreNotNull() {
//		assertNotNull(environment);
//		assertNotNull(dataSource);
//		assertNotNull(viewResolver);
//		assertNotNull(employeeDao);
//		assertNotNull(employeeService);
//		assertNotNull(employeeController);
		assertNotNull(applicationContext);
	}
}
