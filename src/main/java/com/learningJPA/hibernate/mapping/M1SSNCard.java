package com.learningJPA.hibernate.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="SSN_Table")
@Getter
@Setter
public class M1SSNCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int ssn;
	private String issuedBy;
}
