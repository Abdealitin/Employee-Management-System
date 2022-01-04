package com.yash.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.configuration.EmployeeConfiguration;
import com.yash.model.Employee;
import com.yash.service.EmployeeService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmployeeConfiguration.class})
public class TestEmployeeService {
	
	@Autowired
	EmployeeService employeeService;
	
	@Test
	public void testEmployeeByname() {
		List<Employee> e = employeeService.getEmployeeByName("test");
		
		Assert.assertEquals("test", e.get(0).getName());
		
	}
	
	@Test
	public void testTopEarningEmployee() {
		List<Employee> e = employeeService.getTopEarner();
		
		Assert.assertEquals(40000.0, e.get(0).getSalary());
	}
}
