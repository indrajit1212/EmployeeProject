package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VO.EmployeeVo;
import com.example.demo.exceptions.CustomRequestException;
import com.example.demo.service.EmployeeService;



@RequestMapping("/employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public EmployeeVo creatEmployee(@RequestBody final EmployeeVo employeeVo) {

		System.out.println(employeeVo);
		EmployeeVo employeeVo1=employeeService.creatEmployee(employeeVo);
		
		System.out.println("employeeController  "+employeeVo1);
		return  employeeVo1;
	}

	@PutMapping
	public EmployeeVo updateEmployee(@RequestBody final EmployeeVo employeeVo) {

		return employeeService.updateEmployee(employeeVo);
	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable final int id) {
		return employeeService.deleteEmployee(id);
	}

	@GetMapping("")
	public List<EmployeeVo> displayEmployee() {
		
        return employeeService.getAllEmployees();
	}
}
