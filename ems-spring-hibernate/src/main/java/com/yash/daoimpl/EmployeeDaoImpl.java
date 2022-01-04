package com.yash.daoimpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.dao.EmployeeDao;
import com.yash.model.Employee;

/**
 * @author Abdeali Tinwala
 * Implementation of Employee CRUD Operations
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	
	@Autowired
	Session session;

	@Override
	public boolean saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		session.save(employee);
		return true;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		TypedQuery<Employee> query = session.createQuery("from Employee");
		return query.getResultList();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return session.get(Employee.class, id);
	}

	@Override
	public boolean updateemployee(Employee employee) {
		// TODO Auto-generated method stub
		session.update(employee);
		return true;
	}

	@Override
	public boolean deleteemployee(Employee employee) {
		// TODO Auto-generated method stub
		session.delete(employee);
		return true;
	}
}
