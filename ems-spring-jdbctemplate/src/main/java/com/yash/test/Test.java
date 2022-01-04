package com.yash.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.configuration.EmployeeConfiguration;
import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;


public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);

		EmployeeDao employeeDAO = context.getBean(EmployeeDao.class);

		System.out.println("List of employee is:");

		for (Employee p : employeeDAO.getAllEmployees()) {
			System.out.println(p);
		}

//		System.out.println("\nGet employee with ID 2");
//
//		Employee employeeById = employeeDAO.getEmployeeById(2);
//		System.out.println(employeeById);
//
//		System.out.println("\nCreating employee: ");
//		Employee employee = new Employee(4, "Abdeali", 20000, "Trainee", "Indore", "IT");
//		System.out.println(employee);
//		employeeDAO.saveEmployee(employee);
//		System.out.println("\nList of employee is:");
//
//		for (Employee p : employeeDAO.getAllEmployees()) {
//			System.out.println(p);
//		}
//
//		System.out.println("\nDeleting employee with ID 2");
//		employeeDAO.deleteEmployee(employeeDAO.getEmployeeById(4));
//
		System.out.println("\nUpdate employee with ID 4");

		Employee pemployee = employeeDAO.getEmployeeById(4);
		pemployee.setName("CHANGED");
		employeeDAO.updateEmployee(pemployee);

		System.out.println("\nList of employee is:");
		for (Employee p : employeeDAO.getAllEmployees()) {
			System.out.println(p);
		}

		context.close();
	}
}

