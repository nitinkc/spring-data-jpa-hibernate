package com.learningJPA.eTest.repository;

import com.learningJPA.eTest.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
