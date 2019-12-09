package com.learningJPA.dSpringDataRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	private Date dob;
	
//	@OneToMany(mappedBy="student")
//	private List<Post> posts;

}
