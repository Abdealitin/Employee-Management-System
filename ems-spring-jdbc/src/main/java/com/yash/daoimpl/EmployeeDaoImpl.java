package com.yash.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;

import lombok.SneakyThrows;

/**
 * @author Abdeali Tinwala
 * Implementation of Employee Dao interface
 */
@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	
	@Autowired
	Connection con;
	
	/**
	 * Declaring the sql queries for executing statement in Jdbc Operations
	 */
	private final String SQL_FIND_EMPLOYEE = "select * from employee where id = ?";
	private final String SQL_DELETE_EMPLOYEE = "delete from employee where id = ?";
	private final String SQL_UPDATE_EMPLOYEE = "update employee set name = ?, salary = ?, designation  = ?, city = ?, department = ? where id = ?";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_INSERT_EMPLOYEE = "insert into employee(id, name, salary, designation, city, department) values(?,?,?,?,?,?)";

	
	/**
	 *@param id
	 *@return Employee Object fetched from the database for the given id 
	 */
	@SneakyThrows
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		PreparedStatement stmt=con.prepareStatement(SQL_FIND_EMPLOYEE);
		stmt.setInt(1, id);
		ResultSet rs=stmt.executeQuery();
		rs.next();
		
		Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6));
		System.out.println(e);
		return e;
	}

	/**
	 *@return List of all employees
	 */
	@SneakyThrows
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> emp = new ArrayList<>();
		PreparedStatement stmt=con.prepareStatement(SQL_GET_ALL);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			Employee e = new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6));
			emp.add(e);
		}
		return emp;
	}

	/**
	 *@param Object of Employee
	 *@return boolean value as per the command executed or not
	 *Method to insert an Employee
	 */
	@SneakyThrows
	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		PreparedStatement stmt=con.prepareStatement(SQL_INSERT_EMPLOYEE);
		stmt.setInt(1, employee.getId());
		stmt.setString(2, employee.getName());
		stmt.setDouble(3, employee.getSalary());
		stmt.setString(4, employee.getDesignation());
		stmt.setString(5, employee.getCity());
		stmt.setString(6, employee.getDepartment());
		if(stmt.executeUpdate() > 0)
			return true;
		return false;
	}

	/**
	 *@param Object of Employee
	 *@return boolean value as per the command executed or not
	 *Method to delete an Employee
	 */
	@SneakyThrows
	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = con.prepareStatement(SQL_DELETE_EMPLOYEE);
		stmt.setInt(1, employee.getId());
		if(stmt.executeUpdate() > 0)
			return true;
		return false;
	}

	/**
	 *@param Object of Employee
	 *@return boolean value as per the command executed or not
	 *Method to update an Employee
	 */
	@SneakyThrows
	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		PreparedStatement stmt = con.prepareStatement(SQL_UPDATE_EMPLOYEE);
		stmt.setString(1, employee.getName());
		stmt.setDouble(2, employee.getSalary());
		stmt.setString(3, employee.getDesignation());
		stmt.setString(4, employee.getCity());
		stmt.setString(5, employee.getDepartment());
		stmt.setInt(6, employee.getId());
		if(stmt.executeUpdate() > 0)
			return true;
		return false;
	}

}
