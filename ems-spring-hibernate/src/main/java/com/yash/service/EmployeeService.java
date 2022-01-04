package com.yash.service;

import java.util.List;

import com.yash.model.Employee;

/**
 * @author Abdeali Tinwala
 * Decalring the service methods
 */
public interface EmployeeService {
	public boolean saveEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int id);
	public List<Employee> getEmployeeByName(String name);
	public List<Employee> getTopEarner();
}
