package com.rca.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.rca.asset.entity.Student;
import com.rca.asset.entity.UserData;
import com.rca.asset.service.JwtService;
import com.rca.asset.service.StudentService;
import com.rca.asset.service.UserDataService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academics")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserDataService userServices;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/registration")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String addStudent(@RequestBody Student student,HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }
        UserData info=userServices.loadCurrentUser(username);
        student.setCreated(info);
        studentService.addStudent(student);

        return "Student " + student.getFirstName() + " created";
    }

    @GetMapping("/info")
    public String info() {
        return "Amazing day";
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudent(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@RequestBody Student student, @PathVariable Integer id){
        studentService.updateStudent(student,id);
        return "Student " + student.getFirstName() + " updated!";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "User deleted successfully!";
    }

    @GetMapping
    public List<Student> findStudents(){
        return studentService.getAllStudents();
    }
}
