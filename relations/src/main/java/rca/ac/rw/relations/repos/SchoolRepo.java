package rca.ac.rw.relations.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import rca.ac.rw.relations.models.School;

public interface SchoolRepo extends JpaRepository<School,Integer> {
}
