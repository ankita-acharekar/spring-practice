package com.deqode.backend2.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deqode.backend2.Model.Employee;
import com.deqode.backend2.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	// Get all Employees
	@RequestMapping(value = "/api/getEmployees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> getEmployeeDetails() {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the EmployeeController");
		List<Employee> empResponse = employeeService.findAll();

		return empResponse;
	}

	// Get Employee by id
	@RequestMapping(value = "/api/getEmployeeById/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Employee> getEmployeeById(@PathVariable String id) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the EmployeeController");
		Optional<Employee> employeeById = employeeService.findEmployeeById(id);
		return employeeById;
	}

	// Create employee
	@RequestMapping(value = "/api/create", method = RequestMethod.POST, produces = "application/json")
	public Employee addNewEmp(@RequestBody Employee emp) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the EmployeeController");
		Employee employee = employeeService.create(emp);
		logger.info("Saving user....");
		return employee;
	}

	// Update Employee
	@RequestMapping(value = "/api/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Employee> updateEmp(@PathVariable("id") String id, @RequestBody Employee emp) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the EmployeeController");
		ResponseEntity<Employee> employee = employeeService.updateEmp(id, emp);
		logger.info("Saving updated user....");
		return employee;
	}

	// Delete Employee
	@RequestMapping(value = "/api/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String id) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		logger.info("Into the EmployeeController");
		ResponseEntity<Employee> employee = employeeService.deleteEmployee(id);
		logger.info("Deleting user....");
		return employee;
	}
	
	//Docker
	@RequestMapping(value = "/api/docker-message", method = RequestMethod.GET, produces = "application/json")
	public String getMessage() {
		return "Welcome to Docker-Spring-Application..!!";
	}
}
