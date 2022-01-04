package com.yash.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;

/**
 * @author Abdeali Tinwala
 * Implementation of Employee CRUD Operations
 */
@Repository
@Transactional                                        //This defines the transaction attributes
public class EmployeeDaoImpl implements EmployeeDao { 	
	
	@PersistenceContext	                              //JPA API for dependency injection.
	private EntityManager entityManager;
	
	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
		return true;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return (List<Employee>) entityManager.createQuery("from Employee").getResultList();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, id);
	}


	@Override
	public boolean deleteemployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.remove(employee);
		return false;
	}
	

	@Override
	public boolean updateemployee(Employee employee) {
		// TODO Auto-generated method stub
//		Session session = entityManager.unwrap(Session.class);
//		session.update(employee);
		entityManager.merge(employee);
		return true;
	}


	
}
