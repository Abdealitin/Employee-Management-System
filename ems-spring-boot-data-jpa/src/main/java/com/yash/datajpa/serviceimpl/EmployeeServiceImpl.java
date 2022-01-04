package com.yash.datajpa.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.datajpa.model.Employee;
import com.yash.datajpa.repository.EmployeeRepository;
import com.yash.datajpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmpByName(String name) {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		employeeRepository.findByName(name).forEach(employees::add);
		return employees;
	}

	@Override
	public Optional<Employee> getEmpById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> batchInsert(List<Employee> employees) {
		// TODO Auto-generated method stub
		employeeRepository.saveAll(employees);
		return employeeRepository.findAll();
	}

}
