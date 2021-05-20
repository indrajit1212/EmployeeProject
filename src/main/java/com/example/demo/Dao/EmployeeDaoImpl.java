package com.example.demo.Dao;

import com.example.demo.VO.EmployeeVo;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
@Autowired
private EmployeeRepository employeeRepository;

@Autowired
private EmployeeMapperDao employeeMapperDao;

@Override
public EmployeeVo insertEmployee( EmployeeVo employeeVo) {


	final Employee employee = employeeMapperDao.toEntity(employeeVo);
    final Employee savedEmployee = employeeRepository.save(employee);

	//Department department=employee.getDepartment();	

	EmployeeVo employeeVo1=employeeMapperDao.toVo(savedEmployee);
	
	//employeeVo1.setDepartId(departId);
	return employeeVo1;
}

@Override
public EmployeeVo getEmployeetbyId(int id) {
	final Employee employee = employeeRepository.findById(id).orElse(null);

	return employeeMapperDao.toVo(employee);

}

@Override
public List<EmployeeVo> getAllEmployee() {
	final List<Employee> employee = employeeRepository.findAll();
    return employeeMapperDao.toVoList(employee);
}

@Override
public EmployeeVo updateEmployee(EmployeeVo employeeVo) {
	final Employee employee = employeeMapperDao.toEntity(employeeVo);

	final Employee existingEmployee = employeeRepository.findById(Integer.valueOf(employee.getId())).orElse(null);

	existingEmployee.setFirstName(employee.getFirstName());
	existingEmployee.setLastName(employee.getLastName());
	existingEmployee.setAddress(employee.getAddress());

	final Employee saveEmployee = employeeRepository.save(employee);

	return employeeMapperDao.toVo(saveEmployee);

}

@Override
public String deleteEmployee(int employeeId) {
	employeeRepository.deleteById(Integer.valueOf(employeeId));
	return "Employee id : " + employeeId + " Removed";

}
}
