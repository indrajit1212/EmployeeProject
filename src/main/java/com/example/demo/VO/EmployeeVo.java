package com.example.demo.VO;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class EmployeeVo {
	
	
	@Getter
	@Setter
	private int id;
	
	@Getter
	@Setter
	private String firstName;
	
	@Getter
	@Setter
	private String lastName;
	
	@Getter
	@Setter
	private String address;
	
	/*@Getter
	@Setter
	private int departId;*/
	
	@Getter
	@Setter
    private DepartmentVO department;

}
