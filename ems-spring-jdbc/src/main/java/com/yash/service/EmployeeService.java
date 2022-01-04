package com.yash.service;

import java.util.List;

import com.yash.model.Employee;

/**
 * @author Abdeali Tinwala
 * Service interface for declaring the methods
 */
public interface EmployeeService {
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	public boolean saveEmployee(Employee employee);
	public boolean deleteEmployee(int id);
	public boolean updateEmployee(Employee employee);
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getTopEarner();
}	
