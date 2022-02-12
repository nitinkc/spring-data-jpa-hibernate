package com.learningJPA.hibernate.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class M2CellPhone {
	
	/* In this example the primary key is not declared to be int
	 * String type is set and manually set. It works*/
	
	//Testing the String primary Key
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String modelNo;
	
	private String model;
	
	@ManyToOne
	@JoinTable(name="COMMON_NAME")
	private M2CellUser user;
}
