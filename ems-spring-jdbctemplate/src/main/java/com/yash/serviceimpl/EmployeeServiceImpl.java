package com.yash.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yash.comparators.SalaryComparator;
import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;
import com.yash.service.EmployeeService;

/**
 * @author Abdeali Tinwala
 * Implementation class of services
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDAO;

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.saveEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		List<Employee> emps = employeeDAO.getAllEmployees();
		List<Employee> emps1 = new ArrayList<>();
		for(Employee e:emps) {
			if(e.getName().equals(name)) {
				emps1.add(e);
			}
		}
		return emps1;
	}

	@Override
	public List<Employee> getTopEarner() {
		// TODO Auto-generated method stub
		List<Employee> emps = employeeDAO.getAllEmployees();
		Collections.sort(emps, new SalaryComparator());
		Collections.reverse(emps);
		List<Employee> emps1 = new ArrayList<>();
		emps1.add(emps.get(0));
		return emps1;
	}

}
