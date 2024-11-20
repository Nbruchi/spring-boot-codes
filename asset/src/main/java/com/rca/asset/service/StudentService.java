package com.rca.asset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rca.asset.entity.Student;
import com.rca.asset.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;
    public void addStudent(Student st) {
        repo.save(st);
    }

    public Optional<Student> getStudentById(Integer id){
        return repo.findById(id);
    }

    public void deleteStudent(Integer id){
        repo.deleteById(id);
    }

    public Optional<Student> updateStudent(Student updatedStudent,Integer id){
        return repo.findById(id).map(student -> {
            student.setFirstName(updatedStudent.getFirstName());
            student.setLaptops(updatedStudent.getLaptops());
            student.setLastName(updatedStudent.getLastName());
            student.setEmail(updatedStudent.getEmail());

            return repo.save(student);
        });
    }

    public List<Student> getAllStudents(){
        return repo.findAll();
    }
}
