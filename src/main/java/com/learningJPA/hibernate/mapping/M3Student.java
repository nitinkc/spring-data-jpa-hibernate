package com.learningJPA.hibernate.mapping;
/*
 * If Only @ManyToMany Annotation is used, there will be multiple tables with the 
 * redundant data consisting foreign keys.
 * 
 * A Solution to this is to use a @JoinTable Annotation with .
 * */

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Student_Lab")
@Getter
@Setter
public class M3Student {
	
	@Id
	@Column(name="Enrollment_No")
	private String enrollId;
	
	@Column(name="Name")
	private String name;
	
	@ManyToMany
	//@Column(name="Assigned_Computer")
	@JoinTable(
			name="Joined_Table",
			// Name in the Student table (Current Table)
			joinColumns=@JoinColumn(name="ENROLL_NO"),
			//Name in the Other Table (Entity)
			inverseJoinColumns=@JoinColumn(name="COMP_ID")
		  )
	private List<M3ComputerLab> AssignedToComp = new ArrayList<M3ComputerLab>();
	//private List<M3ComputerLab> AssignedToComp;
	/* THE ABOVE DECLARATION DOES NOT WORK. FIND OUT WHY */
}
