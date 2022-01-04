package com.yash.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abdeali Tinwala
 * POJO for Employee
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	/**
	 * id of employee
	 */
	int id;
	
	/**
	 * name of the employee
	 */
	String name;
	/**
	 * salary of the employee
	 */
	double salary;
	
	/**
	 * designation of employee
	 */
	String designation;
	/**
	 * location of employee
	 */
	String city;
	/**
	 * department of employee
	 */
	String department;
	
}
