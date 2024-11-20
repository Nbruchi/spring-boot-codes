package rca.ac.home.work.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.ac.home.work.models.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {
}
