package com.learningJPA.eTest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the dept_manager database table.
 * 
 */
@Entity
@Table(name="dept_manager")
@NamedQuery(name="DeptManager.findAll", query="SELECT d FROM DeptManager d")
public class DeptManager implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeptManagerPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="dept_no",insertable = false,updatable = false)
	private Department department;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_no", insertable = false,updatable = false)
	private EmployeeX employee;

	public DeptManager() {
	}

	public DeptManagerPK getId() {
		return this.id;
	}

	public void setId(DeptManagerPK id) {
		this.id = id;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeX getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeX employee) {
		this.employee = employee;
	}

}