package dSpringDataRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

// Entity that needs to be managed is Student given in <>
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
