package com.deqode.backend2.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.deqode.backend2.Model.Employee;
import com.deqode.backend2.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public List<Employee> findAll() {
		logger.info("Into the Service");
		List<Employee> emp = employeeRepository.findAll();
		return emp;
	}

	public Employee create(Employee emp) {
		logger.info("Into the Service");
		Employee employee = employeeRepository.save(emp);
		return employee;
	}

	public Optional<Employee> findEmployeeById(String id) {
		logger.info("Into the Service");
		Optional<Employee> employeeById = employeeRepository.findById(id);
//		if (employeeById.isPresent()) {
//			logger.info(name);
//			return new ResponseEntity<>(employeeById.get(), HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
		return employeeById;
	}

	public ResponseEntity<Employee> updateEmp(String id, Employee emp) {
		logger.info("Into the Service");
		Optional<Employee> employeeData = employeeRepository.findById(id);

		if (employeeData.isPresent()) {
			Employee _emp = employeeData.get();
			_emp.setName(emp.getName());
			_emp.setDept(emp.getDept());
			_emp.setGender(emp.getGender());
			_emp.setLocation(emp.getLocation());
			return new ResponseEntity<>(employeeRepository.save(_emp), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//Delete Employee
	public ResponseEntity<Employee> deleteEmployee(String id) {
		logger.info("Into the deleteEmployee Service");
		try {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
