package com.yash.datajpa.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yash.datajpa.model.Employee;
import com.yash.datajpa.repository.EmployeeRepository;
import com.yash.datajpa.service.EmployeeService;

/**
 * @author Abdeali Tinwala
 * Controller for mapping the request
 */
@RestController
@RequestMapping("/api1")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * Returning the List of Employees
	 * @param name
	 * @return Response Entity List
	 */
	@GetMapping("/employee")
	 public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String name) {
	        try {
	          List<Employee> employees = new ArrayList<Employee>();

	 

	          if (name == null)
	            employees = employeeService.getAllEmployees();
	          else
	              employees = employeeService.getEmpByName(name);

	 

	          if (employees.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	          }

	 

	          return new ResponseEntity<>(employees, HttpStatus.OK);
	        } catch (Exception e) {
	          return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	      }
	
	/**
	 * Adding the employee and returning the updated list
	 * @param employee
	 * @return List of Response Entity
	 */
	@PostMapping("/add")
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee employee){
		List<Employee> employees = employeeService.addEmployee(employee);
		if(employees != null) {
			return new ResponseEntity<>(employees,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Updating the employee data and returning the updated list.
	 * @param employee
	 * @return List of Response Entity
	 */
	@PutMapping("/update")
	public ResponseEntity<List<Employee>> updateEmployee(@RequestBody Employee employee){
		List<Employee> employees = employeeService.updateEmployee(employee);
		if(employees != null) {
			return new ResponseEntity<>(employees,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Deleting the Employee data ad returning the updated list
	 * @param id
	 * @return List of Response Entity
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<List<Employee>> deleteEmployee(@RequestParam("id")int id){
		List<Employee> employees = employeeService.deleteEmployee(id);
		if(employees != null) {
			return new ResponseEntity<>(employees,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Getting Employee By Id
	 * @param id
	 * @return Employee Object Corresponding to request parameter id.
	 */
	@GetMapping("/byid")
	public Optional<Employee> getEmpById(@RequestParam("id") int id){
		return employeeService.getEmpById(id);
	}
	
	@PostMapping("/batch")
	public ResponseEntity<List<Employee>> batchInsertion(@RequestBody List<Employee> employees){
		List<Employee> employee = employeeService.batchInsert(employees);
		if(employee != null) {
			return new ResponseEntity<>(employee,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
