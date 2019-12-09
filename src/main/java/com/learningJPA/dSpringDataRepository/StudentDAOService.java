package com.learningJPA.dSpringDataRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentDAOService{

	private static List<Student> student = new ArrayList<>();

	// Retrieve all users
	public List<Student> findAll() {
		return getStudent();
	}

	// Retrieve users by Id
	public Student findById(int id) {
		if(getStudent().get(id) == null) {
			return null;
		}
		
		return getStudent().get(id);
	}

	public static List<Student> getStudent() {
		return student;
	}

	public static void setStudent(List<Student> student) {
		StudentDAOService.student = student;
	}


}
