package com.yash.service;

import java.util.List;

import com.yash.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	List<Employee> findByName(String name);
	Employee getEmployeeById(int id);
	void deletEmployee(int id);
	boolean addEmployee(Employee employee);
	boolean updateEmployee(Employee employee);
	List<Employee> getTopEarner();
}
