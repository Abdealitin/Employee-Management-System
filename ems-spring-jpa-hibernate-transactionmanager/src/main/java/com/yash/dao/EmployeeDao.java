package com.yash.dao;

import java.util.List;

import com.yash.model.Employee;

/**
 * @author Abdeali Tinwala
 * Declaring the CRUD methods
 */
public interface EmployeeDao {
	public boolean saveEmployee(Employee employee);
	public List<Employee> getAll();
	public Employee getEmployeeById(int id);
	public boolean updateemployee(Employee employee);
	public boolean deleteemployee(Employee employee);
}
