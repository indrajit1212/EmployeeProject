package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.demo.audit.Audit;
import com.example.demo.audit.AuditImpl;
import com.example.demo.audit.Auditing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EntityListeners(AuditImpl.class)
@Table(name="Department")
public class Department implements Auditing{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="department_Id")
	private int departId;
	
	@Column(name="department_Name")
    private String departName;
	
	@Embedded
	private Audit audit;

	@OneToMany(mappedBy="department",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Employee> employees;
}
