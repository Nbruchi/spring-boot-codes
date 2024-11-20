package rca.ac.rw.relations.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import rca.ac.rw.relations.models.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
