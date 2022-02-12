package com.learningJPA.hibernate.singleTable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "H1USER")
@Getter
@Setter
@RequiredArgsConstructor
public class H1User {
	@Id
	@Column(name="User_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uId;
	@Column(name="User_Name")
	private String uName;
	@Embedded
	private H1Address uAddress;
}
