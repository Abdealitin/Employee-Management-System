package com.yash.comparators;

import java.util.Comparator;

import com.yash.model.Employee;


/**
 * @author Abdeali Tinwala
 * Comparator for Comparing the salary of employee
 */
public class SalaryComparator implements Comparator<Employee> {

	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		if(o1.getSalary()<o2.getSalary())
			return -1;
		if(o1.getSalary()>o2.getSalary())
			return 1;
		return 0;
	}
	
}
