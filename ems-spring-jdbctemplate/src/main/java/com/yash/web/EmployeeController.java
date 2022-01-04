package com.yash.web;

import static jdk.internal.org.jline.utils.Log.info;

import java.util.ArrayList;
import java.util.List;

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

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employee")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView("adminpage");
		return mv;
	}
	
	@GetMapping("/addemployee")
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView("addemployee","employee", new Employee());
		return mv;
	}
	
	@GetMapping("/adminpage")
	public String adminRedirect() {
		return "adminpage";
	}
	
	@GetMapping("/employeeid")
	public String getEmpIdRedirect() {
		return "employeeid";
	}
	
	@GetMapping("/employeename")
	public String getEmpNameRedirect() {
		return "employeename";
	}
	
	@GetMapping("/deleteemployee")
	public String deleteEmployeeRedirect() {
		return "deleteemployee";
	}
	
	@GetMapping("/updateemployee")
	public ModelAndView updateEmployeeRedirect() {
		ModelAndView mv = new ModelAndView("updateemployee","employee", new Employee());
		return mv;
	}
	
	@GetMapping("/getemployees")
	public ModelAndView getEmployees() {
		ModelAndView mv = new ModelAndView("employees");
		List<Employee> lists = employeeService.getAllEmployees();
		mv.addObject("heading", "List Of Employees");
		mv.addObject("lists", lists);
		return mv;
	}
	
	@PostMapping("/addemployee")
	public ModelAndView saveEmployee(@ModelAttribute ("employee")Employee employee, BindingResult result,ModelMap model) {
		if(result.hasErrors()) {
			ModelAndView mv1 = new ModelAndView("addemployee");
			return mv1;
		}
		employeeService.saveEmployee(employee);
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("success","Dear Admin, your employee has been added successfully");
		return mv;
	}
	
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
	
	@GetMapping("/getempname")
	public ModelAndView getEmployeeByName(@RequestParam("name") String name) {
		ModelAndView mv = new ModelAndView("employees");
		mv.addObject("heading", "Employee Corresponding to Given Name");
		List<Employee> lists = employeeService.getEmployeeByName(name);
		mv.addObject("lists", lists);
		return mv;
		
	}
	
	@GetMapping("/topearner")
	public ModelAndView getTopEarner() {
		ModelAndView mv = new ModelAndView("employees");
		mv.addObject("heading", "Top Earner Employee");
		mv.addObject("lists", employeeService.getTopEarner());
		
		return mv;
	}
	
	@GetMapping("/removeemp")
	public ModelAndView deleteEmployee(@RequestParam("id") int id) {
		employeeService.deleteEmployee(id);
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("success" , "Dear Admin, Employee has been deleted successfully.");
		return mv;
	}
	
	@PostMapping("/updateemp")
	public ModelAndView updateEmployee(@ModelAttribute("employee")Employee employee, BindingResult result, ModelMap model) {
		employeeService.updateEmployee(employee);
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("success" , "Dear Admin, Employee Details has been updated successfully.");
		return mv;
	}
}
