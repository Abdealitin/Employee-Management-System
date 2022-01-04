package com.yash.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;
import com.yash.model.EmployeeMapper;

/**
 * @author Abdeali Tinwala
 * Implementation of Employee Dao interface
 */
@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	/**
	 * Declaring variable of JdbcTempelate
	 */
	JdbcTemplate jdbcTemplate;
	
	
	/**
	 * Declaring the sql queries for executing statement in JdbcTempelate
	 */
	private final String SQL_FIND_EMPLOYEE = "select * from employee where id = ?";
	private final String SQL_DELETE_EMPLOYEE = "delete from employee where id = ?";
	private final String SQL_UPDATE_EMPLOYEE = "update employee set name = ?, salary = ?, designation  = ?, city = ?, department = ? where id = ?";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_INSERT_EMPLOYEE = "insert into employee(id, name, salary, designation, city, department) values(?,?,?,?,?,?)";

	
	/**
	 * @param dataSource
	 * Injecting the bean of jdbcTempelate to establish the connection with parameter of dataSource
	 */
	@Autowired
	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 *@param id
	 *@return Employee Object fetched from the database for the given id 
	 */
	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[] { id }, new EmployeeMapper());
	}

	/**
	 *@return List of all employees
	 */
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}

	/**
	 *@param Object of Employee
	 *@return boolean value as per the command executed or not
	 *Method to insert an Employee
	 */
	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getId(), employee.getName(), employee.getSalary(), employee.getDesignation(),
				employee.getCity(),employee.getDepartment()) > 0;
	}

	/**
	 *@param Object of Employee
	 *@return boolean value as per the command executed or not
	 *Method to delete an Employee
	 */
	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, id) > 0;
	}

	/**
	 *@param Object of Employee
	 *@return boolean value as per the command executed or not
	 *Method to update an Employee
	 */
	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getName(), employee.getSalary(), employee.getDesignation(),
				employee.getCity(),employee.getDepartment(),employee.getId()) > 0;
	}

}
