package com.yash.datajpa.service;

import java.util.List;
import java.util.Optional;

import com.yash.datajpa.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	List<Employee> addEmployee(Employee employee);
	List<Employee> updateEmployee(Employee employee);
	List<Employee> deleteEmployee(int id);
	List<Employee> getEmpByName(String name);
	Optional<Employee> getEmpById(int id);
	List<Employee> batchInsert(List<Employee> employees);
}
