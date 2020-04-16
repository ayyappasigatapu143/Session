package com.info.beans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.info.beans.model.Employee;
import com.info.beans.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@PostMapping("/addEmployee")
	public String addEmployee(@RequestBody Employee eployee) {
		empService.saveEmployee(eployee);
		return "employee saved";
	}
	/*
	 * @GetMapping("/getAll") public List<Employee> getAllUsers(){ return empList; }
	 * 
	 * @DeleteMapping("/delete/{id}") public String
	 * deleteEmployee(@PathVariable("id") String id){
	 * empList.remove(Integer.parseInt(id)); return "emp removed"; }
	 */

	@GetMapping("/getAll")
	public List<Employee> getAllUsers() {
		return empService.getAllEmployees();
	}
	
	@GetMapping("/authenticate")
	public String  isAppAuthenticated() {
	
		return "hello";
	}
	
	@GetMapping("/saf")
	public String  isAppAuthenticate() {
			return "hello";
	}
}
