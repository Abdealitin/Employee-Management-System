package com.yash.web;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yash.model.Employee;
import com.yash.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(value = "employees" , produces = "text/plain")
	public String getAllEmployees(){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    List list = Stream.of(employeeService.getAllEmployees()).collect(Collectors.toList());
	    String json = gson.toJson(list);
		return json;
	}
	
	@GetMapping("employees")
	public String getEmployeeById(@RequestParam("id") int id) {
		Employee e = employeeService.getEmployeeById(id);
		return new Gson().toJson(e);
	}
	
	@GetMapping("employees1")
	public String getEmployeeByName(@RequestParam("name") String name) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    List list = Stream.of(employeeService.getAllEmployees()).collect(Collectors.toList());
	    String json = gson.toJson(list);
		return json;
	}
}
