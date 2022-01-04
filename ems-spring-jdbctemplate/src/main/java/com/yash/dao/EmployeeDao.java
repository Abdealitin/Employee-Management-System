package com.yash.dao;

import java.util.List;

import com.yash.model.Employee;

/**
 * @author Abdeali Tinwala
 * Employee Dao layer interface
 */
public interface EmployeeDao {
	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	public boolean saveEmployee(Employee employee);
	public boolean deleteEmployee(int id);
	public boolean updateEmployee(Employee employee);
}
