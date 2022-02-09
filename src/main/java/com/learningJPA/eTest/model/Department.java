package com.learningJPA.eTest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departments database table.
 * 
 */
@Entity
@Table(name="departments")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
@Data
@RequiredArgsConstructor
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="dept_no")
	private String deptNo;

	@Column(name="dept_name")
	private String deptName;

	//bi-directional many-to-one association to DeptEmp
	@OneToMany(mappedBy="department")
	private List<DeptEmp> deptEmps;

	//bi-directional many-to-one association to DeptManager
	@OneToMany(mappedBy="department")
	private List<DeptManager> deptManagers;

	public DeptEmp addDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().add(deptEmp);
		deptEmp.setDepartment(this);

		return deptEmp;
	}

	public DeptEmp removeDeptEmp(DeptEmp deptEmp) {
		getDeptEmps().remove(deptEmp);
		deptEmp.setDepartment(null);

		return deptEmp;
	}

	public DeptManager addDeptManager(DeptManager deptManager) {
		getDeptManagers().add(deptManager);
		deptManager.setDepartment(this);

		return deptManager;
	}

	public DeptManager removeDeptManager(DeptManager deptManager) {
		getDeptManagers().remove(deptManager);
		deptManager.setDepartment(null);

		return deptManager;
	}

}