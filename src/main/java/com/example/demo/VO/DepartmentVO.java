package com.example.demo.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@ToString
@NoArgsConstructor
public class DepartmentVO {
	@Getter
	@Setter
	private int departId;
	
	@Getter
	@Setter
	private String departName;
	
	

}
