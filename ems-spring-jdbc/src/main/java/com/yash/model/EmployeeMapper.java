package com.yash.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Abdeali Tinwala
 * Mapper class for mapping the employees from the Result Set
 */
public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setSalary(rs.getDouble("salary"));
		employee.setDesignation(rs.getString("designation"));
		employee.setDepartment(rs.getString("department"));
		employee.setCity(rs.getString("city"));
		return employee;
	}

}
