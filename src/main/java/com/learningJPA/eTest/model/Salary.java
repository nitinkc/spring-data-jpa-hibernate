package com.learningJPA.eTest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the salaries database table.
 * 
 */
@Entity
@Table(name="salaries")
@NamedQuery(name="Salary.findAll", query="SELECT s FROM Salary s")
public class Salary implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SalaryPK id;

	private int salary;

	@Temporal(TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_no",insertable = false,updatable = false)
	private EmployeeX employee;

	public Salary() {
	}

	public SalaryPK getId() {
		return this.id;
	}

	public void setId(SalaryPK id) {
		this.id = id;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public EmployeeX getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeX employee) {
		this.employee = employee;
	}

}