package com.learningJPA.hibernate.mapping;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Computer_Lab")
@Getter
@Setter
public class M3ComputerLab {
	
	@Id
	@Column(name="Comp_ID")
	private String computerId;
	
	@Column(name="Ip_Address")
	private String networkId;
	
	@ManyToMany(mappedBy="AssignedToComp")
	private List<M3Student> studentAssigned = new ArrayList<M3Student>();

	
	//private List<M3Student> studentAssigned ;
	/* The above declaration does not work FIND WHY*/
}
