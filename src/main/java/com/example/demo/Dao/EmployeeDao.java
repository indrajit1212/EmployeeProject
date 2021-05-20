package com.example.demo.Dao;

import java.util.List;

import com.example.demo.VO.EmployeeVo;



public interface EmployeeDao {

	EmployeeVo insertEmployee(EmployeeVo employeeVo);

	EmployeeVo getEmployeetbyId(int id);

	List<EmployeeVo> getAllEmployee();

	EmployeeVo updateEmployee(EmployeeVo employeeVo);

	String deleteEmployee(int employeeId);
	

}
