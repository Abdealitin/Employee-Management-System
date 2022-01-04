package com.yash.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yash.model.Employee;

/**
 * @author Abdeali Tinwala
 * Controller for redirecting the request for jsp files
 */
@Controller
public class WebController {
	
	@GetMapping("/adminpage")
	public String  adminRedirect() {
		return "adminpage";
	}
	
	
	@GetMapping("addemployee")
	public ModelAndView formRedirect() {
		ModelAndView mv = new ModelAndView("employeeform","employee",new Employee());
		return mv;
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
	
}
