package com.yash.test;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.configuration.EmployeeConfiguration;
import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmployeeConfiguration.class})
public class EmployeeDAOTest {

	@Autowired
	EmployeeDao employeeDao;
	
	static Logger logger = Logger.getLogger(EmployeeDAOTest.class);

//	@Test
//	@Rollback(true)
//	public void testAddEmployee() {
//		Employee emp = new Employee(9, "test3", 40000,"TT", "MP","IT");
//
//		employeeDao.saveEmployee(emp);
//		List<Employee> emps = employeeDao.getAllEmployees();
//		logger.info(emps.size());
//		//Assert.assertEquals(8, emps.size());
//
//		Assert.assertEquals(emp.getName(), emps.get(8).getName());
//	}

	@Test
	@Rollback(true)
	public void testUpdateEmployee() {
		Employee emp = new Employee(2, "testing", 40000,"TT", "MP","IT");

		employeeDao.updateemployee(emp);
		List<Employee> emps = employeeDao.getAll();
		
		Assert.assertEquals(emp.getName(), emps.get(1).getName());
	}
	
//	@Test
//	public void testEmployeeById() {
//		Employee e = employeeDao.getEmployeeById(1);
//		logger.info("Employee By Id - "+e);
//		
//		Assert.assertEquals(1, e.getId());
//	}
	
	

}
