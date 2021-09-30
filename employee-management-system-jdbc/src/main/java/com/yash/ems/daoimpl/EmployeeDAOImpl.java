package com.yash.ems.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yash.ems.dao.EmployeeDAO;
import com.yash.ems.exception.InvalidDeptException;
import com.yash.ems.exception.InvalidIdException;
import com.yash.ems.exception.InvalidNameException;
import com.yash.ems.exception.NotEnoughRecordsException;
import com.yash.ems.model.Employee;
import com.yash.ems.util.DataUtility;

import lombok.SneakyThrows;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	@SneakyThrows
	public Employee getEmpById(int id) throws InvalidIdException {
		// TODO Auto-generated method stub
		Connection con = DataUtility.connect();
		String sql = "select * from employee1 WHERE id=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs=stmt.executeQuery();
		rs.next();
		Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
		return e;
	}
	
	@SneakyThrows
	public List<Object> getEmpByName(String name) throws InvalidNameException {
		// TODO Auto-generated method stub
		List<Object> emps = new ArrayList<Object>();
		Connection con = DataUtility.connect();
		String sql = "select * from employee1 WHERE name=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, name);
		ResultSet rs=stmt.executeQuery();
		rs.next();
		Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
		emps.add(e);
		return emps;
	}

	@SneakyThrows
	public List<Employee> getEmpByDept(String dept) throws InvalidDeptException {
		// TODO Auto-generated method stub
		List<Employee> emp = new ArrayList<Employee>();
		Connection con = DataUtility.connect();
		String sql = "select * from employee1 WHERE department=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, dept);
		ResultSet rs=stmt.executeQuery();
		rs.next();
		Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
		emp.add(e);
		return emp;
	}

	@SneakyThrows
	public Employee getTopEarner() {
		// TODO Auto-generated method stub
		Connection con = DataUtility.connect();
		String sql = "select * from employee1 WHERE salary=(select max(salary) from employee1)";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		rs.next();
		Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
		return e;
	}

	@SneakyThrows
	public List<Employee> getEmpByNameAndSalary(String name, double salary) throws InvalidNameException {
		// TODO Auto-generated method stub
		List<Employee> emp = new ArrayList<Employee>();
		Connection con = DataUtility.connect();
		String sql = "select * from employee1 WHERE name=? and salary=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1, name);
		stmt.setDouble(2, salary);
		ResultSet rs=stmt.executeQuery();
		rs.next();
		Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
		emp.add(e);
		return emp;
	}

	@SneakyThrows
	public void getDeptList() {
		// TODO Auto-generated method stub
		Connection con = DataUtility.connect();
		String sql = "select distinct(department) from employee1";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
	}

	@SneakyThrows
	public void getMaxSalary() {
		// TODO Auto-generated method stub
		Connection con = DataUtility.connect();
		String sql = "select max(salary) from employee1";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		rs.next();
		System.out.println(rs.getDouble(1));
	}

	@SneakyThrows
	public void getLimitedReords(int hasNextInt) throws NotEnoughRecordsException {
		// TODO Auto-generated method stub
		List<Employee> emp = new ArrayList<Employee>();
		Connection con = DataUtility.connect();
		String sql = "select * from employee1 limit ?";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, hasNextInt);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
			emp.add(e);
		}
		System.out.println(emp);
	}

	@SneakyThrows
	public Double getCompleteExpenditure() {
		// TODO Auto-generated method stub
		List<Employee> emp = new ArrayList<Employee>();
		Connection con = DataUtility.connect();
		String sql = "select sum(salary) from employee1";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		rs.next();
		double maxSalary = rs.getDouble(1);
		return maxSalary;
	}
	
	@SneakyThrows
	public List<Employee> getList() {
		// TODO Auto-generated method stub
		List<Employee> emp = new ArrayList<Employee>();
		Connection con = DataUtility.connect();
		String sql = "select * from employee1";
		PreparedStatement stmt=con.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
			emp.add(e);
		}
		return emp;
	}

	@SneakyThrows
	public void addEmployee(int id1, String name11, String des, double sal, String dep) {
		// TODO Auto-generated method stub
		Connection con = DataUtility.connect();
		String sql = "insert into employee1 values(?,?,?,?,?)";
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, id1);
		stmt.setString(2, name11);
		stmt.setString(3, des);
		stmt.setDouble(4, sal);
		stmt.setString(5, dep);
		stmt.executeUpdate();
		
		System.out.println("1 Employee Added!");
	}

}
