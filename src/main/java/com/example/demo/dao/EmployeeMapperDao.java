package com.example.demo.dao;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.demo.entity.Employee;
import com.example.demo.vo.EmployeeVo;

@Mapper(componentModel = "spring", uses = DepartmentMapper.class)
public interface EmployeeMapperDao {
	EmployeeVo toVo(Employee employee);

	Employee toEntity(EmployeeVo employeeVo);

	List<EmployeeVo> toVoList(List<Employee> entityList);

	List<Employee> toEntityList(List<EmployeeVo> voList);

}
