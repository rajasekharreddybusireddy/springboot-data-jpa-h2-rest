package com.example.demo.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();

	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		return employeeRepository.getOne(id);

	}

	@DeleteMapping(value = "/{id}")
	public String u(@PathVariable("id") Integer id) {
		employeeRepository.deleteById(id);
		return "employee deleted";

	}

	@PostMapping(value = "/saveemployee")
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);

	}

	@PutMapping(value = "/{id}")
	public Employee update(@PathVariable("id") Integer id, Employee employee) {
		return employeeRepository.save(employee);

	}
}
