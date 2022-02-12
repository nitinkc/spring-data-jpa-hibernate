package com.learningJPA.cPersistenceContext;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EmployeeDAOService {

	@PersistenceContext
	public EntityManager entityManager;

	public long insert(Employee emp) {
		entityManager.persist(emp);
		return emp.getId();	
	}
}
