package com.bruce.exam.controller;

import com.bruce.exam.models.Employee;
import com.bruce.exam.services.EmployeeServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeServiceImplementation service;

    public EmployeeController(EmployeeServiceImplementation service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(service.createEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable Long id){
        return ResponseEntity.ok(service.updateEmployee(id,employee));
    }

    @DeleteMapping("/{id}")
    public Void deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return null;
    }
}
