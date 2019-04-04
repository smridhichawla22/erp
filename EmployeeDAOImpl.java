package com.niit.erp.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.erp.model.Employee;

public class EmployeeDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<Employee> getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	
	public void deleteEmployee(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee book = session.byId(Employee.class).load(id);
		session.delete(book);
	}

	
	public void saveEmployee(Employee theEmployee) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theEmployee);
	}

	
	public Employee getEmployee(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Employee theEmployee = currentSession.get(Employee.class, theId);
		return theEmployee;
	}
	
}
