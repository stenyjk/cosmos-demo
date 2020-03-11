package com.example.cosmos.cosmosdemo.controller;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cosmos.cosmosdemo.model.Employee;
import com.example.cosmos.cosmosdemo.repo.EmployeeRepository;

import reactor.core.publisher.Flux;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	
	@Autowired
	private EmployeeRepository repo;
	
	@PostMapping("/employees/add")
	public String addEmployee(Employee inputEmployee) {
		
		LOGGER.info("addEmployee :: START inputEmployee details :: {}",inputEmployee);
		Employee emp = new Employee();
		
		
		emp.setId(UUID.randomUUID().toString());
		emp.setDepartment(inputEmployee.getDepartment());
		emp.setFirstName(inputEmployee.getFirstName());
		emp.setLastName(inputEmployee.getLastName());
		emp.setPhone(inputEmployee.getPhone());
		LOGGER.info("addEmployee :: START Employee details :: {}",emp);
		Employee savedEmp = repo.save(emp);
		LOGGER.info("addEmployee :: END, saved Employee id :: {}",savedEmp.getId());
		return savedEmp.getId();
		

	}

	@GetMapping("/employees/{id}")
	public Employee retriveEmployee(@PathVariable("id") String id) {
		
		LOGGER.info("retriveEmployee :: START id :: {}",id);
		return repo.findById(id).get();

	}

	@GetMapping(value = "/employees")
	public List<Employee> retriveAll() {
		
		LOGGER.info("retriveAllEmployees :: START ");
		//Flux<Employee> employees = repo.findAll();
		List<Employee> employees = (List<Employee>) repo.findAll();
		LOGGER.info("All Employees retrived :: ",employees);
		return employees;

	}
	
}
