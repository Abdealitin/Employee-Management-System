package com.yash.datajpa;

import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yash.datajpa.model.Employee;
import com.yash.datajpa.repository.EmployeeRepository;
import com.yash.datajpa.service.EmployeeService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

	@Autowired
	EmployeeService employeeService;
	
	@MockBean
	EmployeeRepository employeeRepoditory;
	
	public void test_addEmployee() {
		Employee e = new Employee();
		when(employeeRepoditory.save(null)).thenReturn(employeeRepoditory);
	}
}
