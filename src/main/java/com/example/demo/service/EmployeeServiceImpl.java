package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.Dao.EmployeeDao;
import com.example.demo.VO.EmployeeVo;
import com.example.demo.aspect.LogExecutionTime;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDao employeeDao;
	
   @LogExecutionTime
   @Override
	public EmployeeVo creatEmployee(final EmployeeVo employeeVo) {

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

		return employeeDao.deleteEmployee(EmployeeId);

	}

}
