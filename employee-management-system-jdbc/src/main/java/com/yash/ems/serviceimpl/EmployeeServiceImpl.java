package com.yash.ems.serviceimpl;

import java.util.List;

import com.yash.ems.daoimpl.EmployeeDAOImpl;
import com.yash.ems.exception.InvalidDeptException;
import com.yash.ems.exception.InvalidIdException;
import com.yash.ems.exception.InvalidNameException;
import com.yash.ems.exception.NotEnoughRecordsException;
import com.yash.ems.model.Employee;
import com.yash.ems.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAOImpl empdao = new EmployeeDAOImpl(); 

	public Double getCompleteExpenditure() {
		// TODO Auto-generated method stub
		return empdao.getCompleteExpenditure();
	}

	public void getDeptList() {
		// TODO Auto-generated method stub
		empdao.getDeptList();
	}

	public List<Employee> getEmpByDept(String dept) throws InvalidDeptException {
		// TODO Auto-generated method stub
		return empdao.getEmpByDept(dept);
	}

	public Employee getEmpById(int id) throws InvalidIdException {
		// TODO Auto-generated method stub
		return empdao.getEmpById(id);
	}

	public List<Object> getEmpByName(String name) throws InvalidNameException {
		// TODO Auto-generated method stub
		return empdao.getEmpByName(name);
	}

	public List<Employee> getEmpByNameAndSalary(String name, double salary) throws InvalidNameException {
		// TODO Auto-generated method stub
		return empdao.getEmpByNameAndSalary(name, salary);
	}

	public void getLimitedReords(int n) throws NotEnoughRecordsException {
		// TODO Auto-generated method stub
		empdao.getLimitedReords(n);
	}

	public List<Employee> getList() {
		// TODO Auto-generated method stub
		return empdao.getList();
	}

	public void getMaxSalary() {
		// TODO Auto-generated method stub
		empdao.getMaxSalary();
	}

	public Employee getTopEarner() {
		// TODO Auto-generated method stub
		return empdao.getTopEarner();
	}

	public void addEmployee(int id1, String name11, String des, double sal, String dep) {
		// TODO Auto-generated method stub
		empdao.addEmployee(id1, name11, des, sal, dep);
	}

}
