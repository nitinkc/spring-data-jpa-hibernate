package com.learningJPA.hibernate.singleTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/* POJO class to hold the data
 *  In relation to a database , an entity is a single person, place, or thing about which data can be stored.
 * */

//@Entity cannot be removed.
@Entity
//@Table to give user desired table name
@Table(name = "student")
@Getter
@Setter
public class StudentHibernate {
	@Id
	@Column(name = "Student_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Student_Name")
	private String name;
}
