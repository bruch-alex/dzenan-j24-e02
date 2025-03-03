package com.dci.exercises.mvcAnnotations.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dci.exercises.mvcAnnotations.domain.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

	private List<Employee> employees = new ArrayList<>(List.of(
			new Employee("1", "Bob", "Smith", 25, "null"),
			new Employee("2", "John", "Doe", 25, "null")));

	@GetMapping({ "", "{limit}" })
	public List<Employee> getEmployees(
			@PathVariable(required = false) Integer limit) {
		if (limit != null) {
			return this.employees.subList(0, limit);
		}
		return this.employees;
	}

	@PostMapping("/add")
	public Employee createEmployee(@RequestBody Employee newEmployee) {
		employees.add(newEmployee);
		return newEmployee;
	}

}
