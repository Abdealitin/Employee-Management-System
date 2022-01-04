package com.yash.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yash.model.Employee;
import com.yash.service.EmployeeService;

/**
 * @author Abdeali Tinwala
 * Controller for mapping the requests to the desired services
 */
@Controller
public class EmployeeController {
	
	/**
	 * Injecting the object of the Employee Service
	 */
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * Mapping the add employee request
	 * @param employee A valid object coming with the request URI
	 * @param result It will bind the object 
	 * @param model 
	 * @return ModelAndView object containing data and view name
	 */
	@PostMapping("/addemployee")
	public ModelAndView saveEmployee(@Valid @ModelAttribute ("employee")Employee employee, BindingResult result,ModelMap model) {
		if(result.hasErrors()) {
			ModelAndView mv1 = new ModelAndView("employeeform");
			return mv1;
		}
		employeeService.saveEmployee(employee);
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("success","Dear Admin, your employee has been added successfully");
		return mv;
	}
	
	/**
	 * Mapping the request to fetch the employees list
	 * @return ModelAndView object containing the view name and some extra data
	 */
	@GetMapping("/getemployees")
	public ModelAndView getEmployees() {
		ModelAndView mv = new ModelAndView("employees");
		List<Employee> lists = employeeService.getAllEmployee();
		mv.addObject("heading", "List Of Employees");
		mv.addObject("lists", lists);
		return mv;
	}
	
	/**
	 * Mapping the request for fetching employee by id
	 * @param id Id of employee coming with request URL
	 * @return ModelAndView object containing the view name and some extra data
	 */
	@GetMapping("/getemp")
	public ModelAndView getEmployeeById(@RequestParam("empid") int id) {
		Employee e = employeeService.getEmployeeById(id);
		ModelAndView mv = new ModelAndView("employees");
		mv.addObject("heading", "Employee Corresponding to given ID");
		List<Employee> lists = new ArrayList<>();
		lists.add(e);
		mv.addObject("lists", lists);
		return mv;
		
	}
	
	/**
	 * Mapping the request for deleting an employee
	 * @param id Id of employee coming with request URL
	 * @return ModelAndView object containing the view name and some extra data
	 */
	@GetMapping("/removeemp")
	public ModelAndView deleteEmployee(@RequestParam("id") int id) {
		employeeService.deleteEmployee(id);
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("success" , "Dear Admin, Employee has been deleted successfully.");
		return mv;
	}
	
	/**
	 * Mapping the request for updating employee
	 * @param employee employee A valid object coming with the request URI
	 * @param result It will bind the object 
	 * @param model
	 * @return ModelAndView object containing the view name and some extra data
	 */
	@PostMapping("/updateemp")
	public ModelAndView updateEmployee(@ModelAttribute("employee")Employee employee, BindingResult result, ModelMap model) {
		employeeService.updateEmployee(employee);
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("success" , "Dear Admin, Employee Details has been updated successfully.");
		return mv;
	}
	
	/**
	 * Mapping request for fetching employee by name
	 * @param name Employee name coming with request URL
	 * @return ModelAndView object containing the view name and some extra data
	 */
	@GetMapping("/getempname")
	public ModelAndView getEmployeeByName(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView("employees");
		mv.addObject("heading", "Employee Corresponding to Given Name");
		List<Employee> lists = employeeService.getEmployeeByName(name);
		mv.addObject("lists", lists);
		return mv;
		
	}
	
	/**
	 * Mapping the request for fetching the highest earner 
	 * @return ModelAndView object containing the view name and some extra data
	 */
	@GetMapping("/topearner")
	public ModelAndView getTopEarner() {
		ModelAndView mv = new ModelAndView("employees");
		mv.addObject("heading", "Top Earner Employee");
		mv.addObject("lists", employeeService.getTopEarner());
		
		return mv;
	}
}
