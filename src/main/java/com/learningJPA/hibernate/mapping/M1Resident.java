package com.learningJPA.hibernate.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Resident")
@Getter
@Setter
public class M1Resident {
	
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int resId;
	
	@OneToOne
	@JoinColumn(name="mySSN")
	private M1SSNCard ssn;
}
