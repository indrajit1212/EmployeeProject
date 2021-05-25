package com.example.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.vo.EmployeeVo;

@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = DepartmentMapper.class)
public interface EmployeeMapper {
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Employee copyDtoToEntityExcludeNull(EmployeeVo employeeVo, @MappingTarget Employee employee);

}
