package com.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Employee;
import com.springboot.service.EmployeeService;

@RestController
public class HomeController 
{
	private EmployeeService employeeService;
	
	public HomeController(EmployeeService employeeService)
	{
		this.employeeService=employeeService;
	}
	
	@PostMapping("/insertEmployee")
	public Employee createEmployee(
		@RequestParam(name="ename")	String ename,
		@RequestParam(name="dept")  String dept,
		@RequestParam(name="salary") float salary)
	{
		Employee employee = employeeService.saveEmployee(ename, dept, salary);
		return employee;
	}
	
	@GetMapping("/readEmployee")
	public Employee readEmployee(@RequestParam(name="eid") int eid)
	{
		Employee employee = employeeService.readEmployee(eid);
		return employee;
	}
	
	@GetMapping("/readAllEmployees")
	public List<Employee> readAllEmployees()
	{
		List<Employee> allEmployees = employeeService.readAllEmployees();
		return allEmployees;
	}
	
	@GetMapping("/findByIdAndName")
	public Employee findByIdName(@RequestParam(name="eid") int eid,
			@RequestParam(name="ename") String ename)
	{
		Employee employee = employeeService.updateEmployee(eid, ename);
		return employee;
	}
	
	@GetMapping("/findByEname")
	public List<Employee> findByEname(@RequestParam(name="ename") String ename)
	{
		List<Employee> list = employeeService.findByEmpName(ename);
		return list;
	}
	
	@GetMapping("/findByEnameContains")
	public List<Employee> findByEnameContains(String ename)
	{
		List<Employee> list = employeeService.findByEnameContains(ename);
		return list;
	}
	
	@PutMapping("/updatingEmp")
	public Employee updateEmploy(@RequestParam(name="eid")int eid,
			@RequestParam(name="salary") float salary)
	{
		Employee employee = employeeService.updatingEmployee(eid, salary);
		return employee;
	}
	
	@DeleteMapping("/deleteEmployee")
	public Employee deleteEmpWithId(@RequestParam(name="eid") int eid)
	{
		Employee employee = employeeService.deleteEmployee(eid);
		return employee;
	}
	
	@DeleteMapping("/deleteAllEmployees")
	public List<Employee> deleteAllEmployees()
	{
		List<Employee> employees = employeeService.deleteAllEmployees();
		return employees;
	}
}
