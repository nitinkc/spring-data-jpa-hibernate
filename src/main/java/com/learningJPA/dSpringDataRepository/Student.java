package com.learningJPA.dSpringDataRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	@Size(min=2,message = "Names should be atleast characters long")
	private String name;
	@Past(message = "DOB Cannot be in the Future")
	private Date dob;

//	@OneToMany(mappedBy="student")
//	private List<Post> posts;

}
