package com.example.demo.vo;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
public class EmployeeVo {
	
	private int id;
	private String firstName;
	private String lastName;
	private String address;
    private DepartmentVO department;

}
