package com.niit.erp.service;

import java.util.List;

import com.niit.erp.model.Employee;

public interface EmployeeService {

	public List <Employee> getEmployees();
	public void saveEmployee(Employee theEmployee);
	public Employee getEmployee(int theId);
	public void deleteEmployee(int theId);
}
