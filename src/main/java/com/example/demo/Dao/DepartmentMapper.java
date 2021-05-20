package com.example.demo.Dao;

import org.mapstruct.Mapper;

import com.example.demo.VO.DepartmentVO;

import com.example.demo.entity.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
	DepartmentVO toVO(Department department);
	Department toEntity(DepartmentVO departmentVO);

}
