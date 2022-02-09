package com.learningJPA.eTest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dept_emp_latest_date database table.
 * 
 */
@Entity
@Table(name="dept_emp_latest_date")
@NamedQuery(name="DeptEmpLatestDate.findAll", query="SELECT d FROM DeptEmpLatestDate d")
@Data
@RequiredArgsConstructor
public class DeptEmpLatestDate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name="emp_no")
	private int empNo;

	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;
}