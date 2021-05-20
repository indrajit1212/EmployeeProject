package com.example.demo.Dao;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.VO.EmployeeVo;

import com.example.demo.entity.Employee;

@Mapper(componentModel = "spring",uses=DepartmentMapper.class)
public interface EmployeeMapperDao {

	EmployeeVo toVo(Employee employee);
	Employee toEntity(EmployeeVo employeeVo);
	
	List<EmployeeVo> toVoList(List<Employee> entityList);
	List<Employee> toEntityList(List<EmployeeVo> voList);
	

}
