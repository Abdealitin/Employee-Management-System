package com.yash.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.comparators.SalaryComparator;
import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;
import com.yash.service.EmployeeService;

import lombok.extern.log4j.Log4j;

/**
 * @author Abdeali Tinwala
 * Implementation of Employee Service
 */
@Log4j
@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		log.info(employee+" added successfully!");
		return employeeDao.saveEmployee(employee);
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAll();
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		log.info("Employee fetched with Id: "+id);
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.updateemployee(employee);
		log.info("Employee updated successfully!");
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		employeeDao.deleteemployee(employeeDao.getEmployeeById(id));
		log.info("Employee deleted with Id: "+id);
	}
	
	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		List<Employee> emps = employeeDao.getAll();
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
		List<Employee> emps = employeeDao.getAll();
		Collections.sort(emps, new SalaryComparator());
		Collections.reverse(emps);
		List<Employee> emps1 = new ArrayList<>();
		emps1.add(emps.get(0));
		return emps1;
	}

}
