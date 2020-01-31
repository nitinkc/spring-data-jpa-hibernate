package com.learningJPA.dSpringDataRepository;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/jpa")
public class StudentController {
	/*@Autowired
	private StudentDAOService studentDAOService;*/

	//Constructor Injection, NO NEED FOR @AUTOWIRED Annotation
	private StudentService studentService;
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// Retrieve all users
	@GetMapping(path = "/students")
	public List<Student> retrieveAllUsers() {
		log.trace("######################### Retrieving All Users ##########################################");
		return studentService.retrieveAllUsers();
	}

	// Retrieve all users page by page
	@GetMapping(path = "/students/pagination")
	public List<Student> retrieveAllUsersPagination(@RequestParam(defaultValue = "0") Integer pageNo,
													@RequestParam(defaultValue = "10") Integer pageSize,
													@RequestParam(defaultValue = "id") String sortBy) {
		log.trace("############################# Retrieving All Users Pagination ###########################");
		log.trace("Page No : "+pageNo + "---"+ "Page Size: "+ pageSize + "---" + "sort by "+ sortBy);

		return studentService.retrieveAllUsersPagination(pageNo,pageSize,sortBy);
	}

	// Retrieve specific users
	@GetMapping(path = "/student/{id}")
	public Student retrieveStudentById(@PathVariable("id") @NotBlank Long id) {
		log.trace("Inside Controller : retrieveStudentById");
		return studentService.retrieveStudentById(id);
	}

	// Retrieve students by City
	@GetMapping(path = "/students/from/{city}")
	public List<Student> retrieveStudentByCity(@PathVariable("city") String city) {
		log.trace("Inside Controller : retrieveStudentByCity");
		log.trace("Entered City is: " + city);
		return studentService.retrieveStudentByCityOfBirth(city);
	}

	// Retrieve students by Year
	@GetMapping(path = "/students/dob/{year}")
	public List<Student> retrieveStudentByYear(@PathVariable("year") int year) {
		log.trace("Inside Controller : retrieveStudentByYear");
		log.trace("Entered year is: " + year);
		List<Student> returnedStudents = studentService.retrieveStudentByYearOfBirth(year);
		log.trace("Students Returned: " + returnedStudents.size());
		return returnedStudents;
	}

	// Retrieve students by gender and City
	@GetMapping(path = "/students/of/{gender}/from/{city}")
	public List<Student> retrieveStudentByGenderAndCity(@PathVariable("gender") @NotNull String gender, @PathVariable("city") @NotNull String city) {
		log.trace("Inside Controller : retrieveStudentByGenderAndCity");
		log.trace("Entered values are : " + gender +", "+ city);
		List<Student> returnedStudents = studentService.findByGenderAndAndCityOfBirth(gender,city);
		log.trace("Students Returned: " + returnedStudents.size());
		return returnedStudents;
	}

	@DeleteMapping("/student/{id}")
	public Student deleteStudent(@PathVariable Long id) {
		log.trace("Inside Controller : deleteStudent");
		return studentService.deleteStudent(id);
	}

	@PostMapping("/student")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student){
		log.trace("Inside Controller : createStudent");
		return studentService.createStudent(student);
	}

	@PutMapping("/student/{id}")
	public Student modifyValue(@RequestBody Student newStudent, @PathVariable Long id){
		log.trace("Inside Controller : modifyValue");
		return studentService.modifyValue(newStudent,id);
	}
}

