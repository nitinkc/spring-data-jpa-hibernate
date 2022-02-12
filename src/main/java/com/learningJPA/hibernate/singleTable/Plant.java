package com.learningJPA.hibernate.singleTable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "GetNLoad_Example")
@Getter
@Setter
public class Plant {

	@Id
	@Column(name = "Plant_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	@Column(name = "Plant_Name")
	private String pName;
}
