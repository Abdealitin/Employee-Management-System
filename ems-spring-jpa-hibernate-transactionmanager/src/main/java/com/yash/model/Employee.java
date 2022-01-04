package com.yash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Abdeali Tinwala
 * POJO of Employee 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empoyee1")
public class Employee {
	/**
	 * id of the Employee
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	/**
	 * Name of the Employee
	 */
	@Size(max = 30, min = 3)
	String name;
	
	/**
	 * Salary of the Employee
	 */
	@NotNull
	double salary;
	
	/**
	 * Designation of the Employee
	 */
	@NotEmpty
	String designation;
	
	/**
	 * Location of the Employee
	 */
	@NotEmpty
	String city;
	
	/**
	 * Department of the Employee
	 */
	@NotEmpty
	String department;
}
