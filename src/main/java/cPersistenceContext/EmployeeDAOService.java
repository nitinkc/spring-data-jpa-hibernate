package cPersistenceContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
