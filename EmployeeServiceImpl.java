package com.niit.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.erp.dao.EmployeeDAO;
import com.niit.erp.model.Employee;

public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDAO EmployeeDAO;
	
	
	@Transactional
	public List<Employee> getEmployees() {
		return EmployeeDAO.getEmployees();
	}

	
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		EmployeeDAO.saveEmployee(theEmployee);
	}

	
	@Transactional
	public Employee getEmployee(int theId) {
		return EmployeeDAO.getEmployee(theId);
	}

	
	@Transactional
	public void deleteEmployee(int theId) {
		EmployeeDAO.deleteEmployee(theId);
	}
	
}
