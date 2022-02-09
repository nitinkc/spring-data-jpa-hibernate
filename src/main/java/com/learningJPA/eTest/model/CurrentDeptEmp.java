package com.learningJPA.eTest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the current_dept_emp database table.
 * 
 */
@Entity
@Table(name="current_dept_emp")
@NamedQuery(name="CurrentDeptEmp.findAll", query="SELECT c FROM CurrentDeptEmp c")
@Data
@RequiredArgsConstructor
public class CurrentDeptEmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name="dept_num")
	private String deptNo;

	@Column(name="emp_no")
	private int empNo;

	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;
}