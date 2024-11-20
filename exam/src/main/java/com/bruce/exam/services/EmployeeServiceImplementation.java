package com.bruce.exam.services;

import com.bruce.exam.exceptions.EmployeeNotFoundException;
import com.bruce.exam.models.Employee;
import com.bruce.exam.repos.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImplementation(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        return repository.findById(id).map(updatedEmployee ->{
            updatedEmployee.setFirstname(employee.getFirstname());
            updatedEmployee.setLastname(employee.getLastname());
            updatedEmployee.setInstitution(employee.getInstitution());
            updatedEmployee.setPosition(employee.getPosition());

            return repository.save(updatedEmployee);
        }).orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id " + id + " not found");
        }
        repository.deleteById(id);
    }
}
