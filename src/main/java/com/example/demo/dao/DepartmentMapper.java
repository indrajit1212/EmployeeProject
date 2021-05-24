package com.example.demo.dao;

import org.mapstruct.Mapper;

import com.example.demo.entity.Department;
import com.example.demo.vo.DepartmentVO;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
	DepartmentVO toVO(Department department);

	Department toEntity(DepartmentVO departmentVO);

}
