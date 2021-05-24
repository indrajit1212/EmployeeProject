package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.aspect.LogExecutionTime;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.vo.EmployeeVo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@LogExecutionTime
	@Override
	public EmployeeVo creatEmployee(final EmployeeVo employeeVo) {

		return employeeDao.insertEmployee(employeeVo);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
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

	@Override
	public EmployeeVo getEmployeeById(final int id) {
		return employeeDao.getEmployeetbyId(id);
	}

}
