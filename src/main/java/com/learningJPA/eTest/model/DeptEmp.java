package com.learningJPA.eTest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the dept_emp database table.
 * 
 */
@Entity
@Table(name="dept_emp")
@NamedQuery(name="DeptEmp.findAll", query="SELECT d FROM DeptEmp d")
@Data
@RequiredArgsConstructor
public class DeptEmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeptEmpPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="dept_no", insertable = false,updatable = false)
	private Department department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_no", insertable = false,updatable = false)
	private EmployeeX employee;
}