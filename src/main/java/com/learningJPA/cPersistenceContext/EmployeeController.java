package com.learningJPA.cPersistenceContext;

import com.learningJPA.bHardCodedData.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	private static final Logger log = LoggerFactory.getLogger(UserDAOService.class);
		
	@Autowired
	private EmployeeDAOService employeeDAOService;
	
	@RequestMapping(value = "/addEmp", method = RequestMethod.PUT) 
	void addEmployee(){
		Employee emp  = new Employee("Nitin", "Engineer");
		
		long insert = employeeDAOService.insert(emp);
		log.info("New User id = " + insert + " with this data : " + emp);
	}
}
