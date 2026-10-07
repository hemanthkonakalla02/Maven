package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.dao.EmployeeRepository;
import com.springboot.model.Employee;

@Service
public class EmployeeService 
{
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository)
	{
		this.employeeRepository=employeeRepository;
	}
	
	
	public Employee saveEmployee(String ename,String dept,float salary)
	{
		Employee emp = new Employee(ename, dept, salary);
		Employee employee = employeeRepository.save(emp);
		return employee;
	}
	
	public Employee readEmployee(int eid)
	{
		Optional<Employee> byId = employeeRepository.findById(eid);
		Employee employee = byId.get();
		return employee;
	}
	
	public List<Employee> readAllEmployees()
	{
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
	

	
	public Employee updateEmployee(int eid,String ename)
	{
		Employee employee = employeeRepository.findByEidAndEname(eid, ename);
		return employee;
	}
	
	public List<Employee> findByEmpName(String ename)
	{
		List<Employee> list = employeeRepository.findByEname(ename);
		return list;
	}
	
	public List<Employee> findByEnameContains(String ename)
	{
		List<Employee> list = employeeRepository.findByEnameContains(ename);
		return list;
	}
	
	
	
	public Employee updatingEmployee(int eid,float salary)
	{
		Optional<Employee> id = employeeRepository.findById(eid);
		Employee employee = id.get();
		employee.setSalary(salary);
		Employee employee2 = employeeRepository.save(employee);
		return employee2;
	}
	
	public Employee deleteEmployee(int eid)
	{
		Optional<Employee> id = employeeRepository.findById(eid);
		Employee employee = id.get();
		employeeRepository.delete(employee);
		return employee;
	}
	
	public List<Employee> deleteAllEmployees()
	{
		List<Employee> list = employeeRepository.findAll();
		employeeRepository.deleteAll(list);
		return list;
		
	}
	
	
}
