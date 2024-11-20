package inc.bruce.ems.services;

import inc.bruce.ems.models.Employee;
import inc.bruce.ems.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImp implements EmployeeService{
    private final EmployeeRepo repo;

    @Autowired
    public EmployeeServiceImp(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(UUID id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Employee> updateEmployee(Employee updatedEmployee, UUID id) {
        return repo.findById(id).map(employee -> {
            employee.setCompany(updatedEmployee.getCompany());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setName(updatedEmployee.getName());
            employee.setPhone(updatedEmployee.getPhone());
            employee.setSalary(updatedEmployee.getSalary());

            return repo.save(employee);
        });
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public boolean deleteEmployee(UUID id) {
        repo.findById(id).map(employee -> {
            repo.delete(employee);
            return true;
        });
        return false;
    }

    // Optional
    @Override
    public List<Employee> findEmployeesByNameContaining(String string) {
        return repo.findEmployeesByNameContaining(string);
    }

    @Override
    public List<Employee> findEmployeesBySalary(Double salary) {
        return repo.findEmployeesBySalary(salary);
    }

    @Override
    public List<Employee> findEmployeeBySalaryGreaterThan(Double salary) {
        return repo.findEmployeesBySalaryGreaterThan(salary);
    }

    @Override
    public List<Employee> findEmployeesBySalaryLessThan(Double salary) {
        return repo.findEmployeesBySalaryLessThan(salary);
    }

    @Override
    public List<Employee> findEmployeesByPhoneContaining(String phone) {
        return repo.findEmployeesByPhoneContaining(phone);
    }

    @Override
    public List<Employee> findEmployeesByCompany(String company) {
        return repo.findEmployeesByCompanyContaining(company);
    }

    @Override
    public List<Employee> findEmployeesByDepartment(String department) {
        return repo.findEmployeesByDepartmentContaining(department);
    }
}
