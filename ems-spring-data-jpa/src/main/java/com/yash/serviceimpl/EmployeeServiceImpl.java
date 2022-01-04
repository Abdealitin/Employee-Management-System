package com.yash.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.comparators.SalaryComparator;
import com.yash.model.Employee;
import com.yash.repository.EmployeeRepository;
import com.yash.service.EmployeeService;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository<Employee> employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepository.findByName(name);
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.findOne(id);
	}

	@Override
	public void deletEmployee(int id) {
		// TODO Auto-generated method stub
		employeeRepository.delete(id);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee) != null;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee) != null;
	}

	@Override
	public List<Employee> getTopEarner() {
		// TODO Auto-generated method stub
		List<Employee> emps = (List<Employee>) employeeRepository.findAll();
		Collections.sort(emps, new SalaryComparator());
		Collections.reverse(emps);
		List<Employee> emps1 = new ArrayList<>();
		emps1.add(emps.get(0));
		return emps1;
	}

}
