package com.yash.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;

import lombok.extern.log4j.Log4j;

/**
 * @author Abdeali Tinwala
 * Implementation of Employee CRUD Operations
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}
	
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		TypedQuery<Employee> query = sessionFactory.getCurrentSession().createQuery("from Employee");
		//log.info("Employee List Fetched..");
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@Override
	public boolean updateemployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(employee);
		return true;
	}

	@Override
	public boolean deleteemployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(employee);
		return true;
	}
	
	
}
