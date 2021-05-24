package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.exceptions.CustomExceptionConstants;
import com.example.demo.exceptions.CustomRequestException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.vo.EmployeeVo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapperDao employeeMapperDao;

	@Override
	public EmployeeVo insertEmployee(final EmployeeVo employeeVo) {

		final Employee employee = employeeMapperDao.toEntity(employeeVo);
		final Employee savedEmployee = employeeRepository.save(employee);
		final EmployeeVo employeeVo1 = employeeMapperDao.toVo(savedEmployee);
		return employeeVo1;
	}

	@Override
	public EmployeeVo getEmployeetbyId(final int id) {
		/*
		 * try { final int a = 4 / 0; } catch (final ArithmeticException e) {
		 * log.error("Division by zero", e); throw new
		 * CustomRequestException(CustomExceptionConstants.DIVISION_BY_ZERO, e); }
		 */

		final Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new CustomRequestException(CustomExceptionConstants.Employee_NOT_FOUND));
		return employeeMapperDao.toVo(employee);

	}

	@Override
	public List<EmployeeVo> getAllEmployee() {

		final List<Employee> employee = employeeRepository.findAll();
		return employeeMapperDao.toVoList(employee);
	}

	@Override
	public EmployeeVo updateEmployee(final EmployeeVo employeeVo) {

		final Employee employee = employeeMapperDao.toEntity(employeeVo);
		final Employee existingEmployee = employeeRepository.findById(Integer.valueOf(employee.getId())).orElse(null);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setAddress(employee.getAddress());
		final Employee saveEmployee = employeeRepository.save(employee);
		return employeeMapperDao.toVo(saveEmployee);
	}

	@Override
	public String deleteEmployee(final int employeeId) {

		employeeRepository.deleteById(Integer.valueOf(employeeId));
		return "Employee id : " + employeeId + " Removed";

	}
}
