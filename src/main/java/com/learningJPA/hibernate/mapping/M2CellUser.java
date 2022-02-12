package com.learningJPA.hibernate.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Mobile_user")
@Getter
@Setter
public class M2CellUser {
	
	@Column(name="User_Name")
	private String user;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_Id")
	private int id;
	
	/* The list is One to Many
	 * If join table is not used, then the Column cannot be customized */
	@OneToMany
	@JoinColumn(name="COMMON_ID")
	private List<M2CellPhone> cells;
}