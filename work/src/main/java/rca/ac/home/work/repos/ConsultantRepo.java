package rca.ac.home.work.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.ac.home.work.models.Consultant;

@Repository
public interface ConsultantRepo extends JpaRepository<Consultant, String> {
}
