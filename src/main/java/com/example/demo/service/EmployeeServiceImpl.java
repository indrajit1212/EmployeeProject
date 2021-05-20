package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Dao.EmployeeDao;
import com.example.demo.VO.EmployeeVo;
import com.example.demo.aspect.LogExecutionTime;
import com.example.demo.exceptions.CustomRequestException;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;
	
   @LogExecutionTime
   @Override
	public EmployeeVo creatEmployee(final EmployeeVo employeeVo) {
       System.out.println("changing");
		return employeeDao.insertEmployee(employeeVo);
	}

   @Override
	public List<EmployeeVo> getAllEmployees() {
		return employeeDao.getAllEmployee();
	}

   @Override
	public EmployeeVo updateEmployee(final EmployeeVo employeeVo) {

		final EmployeeVo oldEmployee = employeeDao.getEmployeetbyId(employeeVo.getId());

		if (oldEmployee != null) {

			return employeeDao.updateEmployee(employeeVo);
		}

		return null;
	}

   @Override
	public String deleteEmployee(final int EmployeeId) {
	   if(EmployeeId<=0) 
	   {
		   throw new CustomRequestException("employee id cant be null");
	   }

		return employeeDao.deleteEmployee(EmployeeId);

	}

}
