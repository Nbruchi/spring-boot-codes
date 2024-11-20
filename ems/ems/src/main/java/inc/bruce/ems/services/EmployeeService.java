package inc.bruce.ems.services;

import inc.bruce.ems.models.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeService {
    Optional<Employee> getEmployeeById(UUID id);
    Optional<Employee> updateEmployee(Employee updatedEmployee, UUID id);
    Employee createEmployee(Employee employee);
    boolean deleteEmployee(UUID id);

    List<Employee> getAllEmployees();

    // Optional
    List<Employee> findEmployeesByNameContaining(String string);
    List<Employee> findEmployeesBySalary(Double salary);
    List<Employee> findEmployeeBySalaryGreaterThan(Double salary);
    List<Employee> findEmployeesBySalaryLessThan(Double salary);
    List<Employee> findEmployeesByPhoneContaining(String phone);
    List<Employee> findEmployeesByCompany(String company);
    List<Employee> findEmployeesByDepartment(String  department);
}
