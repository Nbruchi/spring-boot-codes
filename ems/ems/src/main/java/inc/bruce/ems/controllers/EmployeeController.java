package inc.bruce.ems.controllers;

import inc.bruce.ems.models.Employee;
import inc.bruce.ems.services.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeController {
    private final EmployeeServiceImp employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImp employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.createEmployee(employee),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Employee>> updateEmployee(
            @RequestBody Employee employee,
            @PathVariable UUID id
    ) {
        Optional<Employee> updatedEmployee = employeeService.updateEmployee(employee, id);
        if (updatedEmployee.isPresent()) {
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable UUID id){
        return new ResponseEntity<>(employeeService.deleteEmployee(id),HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable UUID id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    // Optional
    @GetMapping("/search/names/{name}")
    public ResponseEntity<List<Employee>> getAllEmployeesByName(@PathVariable String name){
        return new ResponseEntity<>(employeeService.findEmployeesByNameContaining(name),HttpStatus.OK);
    }

    @GetMapping("/search/salaries/{salary}")
    public ResponseEntity<List<Employee>> getAllEmployeesBySalary(@PathVariable Double salary){
        return new ResponseEntity<>(employeeService.findEmployeesBySalary(salary),HttpStatus.OK);
    }

    @GetMapping("/salaries/above/{salary}")
    public ResponseEntity<List<Employee>> getAllEmployeesBySalaryGreaterThan(@PathVariable Double salary){
        return new ResponseEntity<>(employeeService.findEmployeeBySalaryGreaterThan(salary),HttpStatus.OK);
    }

    @GetMapping("/salaries/less/{salary}")
    public ResponseEntity<List<Employee>> getAllEmployeesBySalaryLessThan(@PathVariable Double salary){
        return new ResponseEntity<>(employeeService.findEmployeesBySalaryLessThan(salary),HttpStatus.OK);
    }

    @GetMapping("/search/phones/{phone}")
    public ResponseEntity<List<Employee>> getAllEmployeesByPhoneContaining(@PathVariable String phone){
        return new ResponseEntity<>(employeeService.findEmployeesByPhoneContaining(phone),HttpStatus.OK);
    }

    @GetMapping("/search/companies/{company}")
    public ResponseEntity<List<Employee>> getAllEmployeesByCompany(@PathVariable String company){
        return new ResponseEntity<>(employeeService.findEmployeesByCompany(company),HttpStatus.OK);
    }

    @GetMapping("/search/deps/{department}")
    public ResponseEntity<List<Employee>> getAllEmployeesByDepartment(@PathVariable String department){
        return new ResponseEntity<>(employeeService.findEmployeesByDepartment(department),HttpStatus.OK);
    }
}
