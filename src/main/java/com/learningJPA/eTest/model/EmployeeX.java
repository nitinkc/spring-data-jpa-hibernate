package com.learningJPA.eTest.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Data
@Table(name="employees_x")
public class EmployeeX implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_no")
	private int empNo;

	private String address;

	@Lob
	private byte[] attachments;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

	@Column(name="business_phone")
	private String businessPhone;

	private String city;

	private String company;

	@Column(name="country_region")
	private String countryRegion;

	private String email;

	@Column(name="email_address")
	private String emailAddress;

	private int employeeNumber;

	private String extension;

	@Column(name="fax_number")
	private String faxNumber;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Temporal(TemporalType.DATE)
	@Column(name="hire_date")
	private Date hireDate;

	@Column(name="home_phone")
	private String homePhone;

	private int id;

	@Column(name="job_title")
	private String jobTitle;

	@Column(name="last_name")
	private String lastName;

	@Column(name="mobile_phone")
	private String mobilePhone;

	private String notes;

	private String officeCode;

	@Column(name="state_province")
	private String stateProvince;

	@Column(name="web_page")
	private String webPage;

	@Column(name="zip_postal_code")
	private String zipPostalCode;

	//bi-directional many-to-one association to DeptEmp
	@OneToMany(mappedBy="employee")
	private List<DeptEmp> deptEmps;

	//bi-directional many-to-one association to DeptManager
	@OneToMany(mappedBy="employee")
	private List<DeptManager> deptManagers;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="reportsTo")
	private EmployeeX employee;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employee")
	private List<EmployeeX> employees;

	//bi-directional many-to-one association to Salary
	@OneToMany(mappedBy="employee")
	private List<Salary> salaries;

	//bi-directional many-to-one association to Title
	@OneToMany(mappedBy="employee")
	private List<Title> titles;


	public DeptEmp addDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().add(deptEmp);
		deptEmp.setEmployee(this);

		return deptEmp;
	}

	public DeptEmp removeDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().remove(deptEmp);
		deptEmp.setEmployee(null);

		return deptEmp;
	}

	public List<DeptManager> getDeptManagers() {
		return this.deptManagers;
	}

	public void setDeptManagers(List<DeptManager> deptManagers) {
		this.deptManagers = deptManagers;
	}

	public DeptManager addDeptManager(DeptManager deptManager) {
		getDeptManagers().add(deptManager);
		deptManager.setEmployee(this);

		return deptManager;
	}

	public DeptManager removeDeptManager(DeptManager deptManager) {
		getDeptManagers().remove(deptManager);
		deptManager.setEmployee(null);

		return deptManager;
	}

	public EmployeeX getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeX employee) {
		this.employee = employee;
	}

	public List<EmployeeX> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeX> employees) {
		this.employees = employees;
	}

	public EmployeeX addEmployee(EmployeeX employee) {
		getEmployees().add(employee);
		employee.setEmployee(this);

		return employee;
	}

	public EmployeeX removeEmployee(EmployeeX employee) {
		getEmployees().remove(employee);
		employee.setEmployee(null);

		return employee;
	}

	public List<Salary> getSalaries() {
		return this.salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public Salary addSalary(Salary salary) {
		getSalaries().add(salary);
		salary.setEmployee(this);

		return salary;
	}

	public Salary removeSalary(Salary salary) {
		getSalaries().remove(salary);
		salary.setEmployee(null);

		return salary;
	}

	public List<Title> getTitles() {
		return this.titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	public Title addTitle(Title title) {
		getTitles().add(title);
		title.setEmployee(this);

		return title;
	}

	public Title removeTitle(Title title) {
		getTitles().remove(title);
		title.setEmployee(null);

		return title;
	}
}