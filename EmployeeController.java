package com.niit.erp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.erp.model.Employee;
import com.niit.erp.service.EmployeeService;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	private EmployeeService EmployeeService;
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = EmployeeService.getEmployees();
		theModel.addAttribute("Employees", theEmployees);
		return "list-Employees";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		theModel.addAttribute("Employee", theEmployee);
		return "Employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("Employee") Employee theEmployee) {
		EmployeeService.saveEmployee(theEmployee);	
		return "redirect:/Employee/list";
	}
	
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("EmployeeId") int theId,
									Model theModel) {
		Employee theEmployee = EmployeeService.getEmployee(theId);	
		theModel.addAttribute("Employee", theEmployee);
		return "Employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("EmployeeId") int theId) {
		EmployeeService.deleteEmployee(theId);
		return "redirect:/Employee/list";
	}
}