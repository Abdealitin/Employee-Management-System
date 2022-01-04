package com.yash.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.datajpa.model.Employee;

/**
 * @author Abdeali Tinwala
 *	Employee Repository implementing JPA Repository to provide methods for CRUD operations
 */
@SuppressWarnings("hiding")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	/**
	 * @param name
	 * @return List of Employee
	 */
	List<Employee> findByName(String name);
}
