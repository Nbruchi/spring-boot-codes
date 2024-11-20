package inc.bruce.ems.repos;

import inc.bruce.ems.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, UUID> {
    List<Employee> findEmployeesByNameContaining(String string);

    List<Employee> findEmployeesBySalary(Double salary);

    List<Employee> findEmployeesBySalaryGreaterThan(Double salary);

    List<Employee> findEmployeesBySalaryLessThan(Double salary);

    List<Employee> findEmployeesByCompanyContaining(String string);

    List<Employee> findEmployeesByDepartmentContaining(String string);

    List<Employee> findEmployeesByPhoneContaining(String phone);
}
