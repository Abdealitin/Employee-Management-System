package com.yash.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yash.model.Employee;

public interface EmployeeRepository<E> extends CrudRepository<Employee, Integer>{

	List<Employee> findByName(String name);

}
