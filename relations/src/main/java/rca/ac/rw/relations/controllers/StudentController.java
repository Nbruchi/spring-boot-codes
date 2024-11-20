package rca.ac.rw.relations.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rca.ac.rw.relations.models.Student;
import rca.ac.rw.relations.models.StudentDto;
import rca.ac.rw.relations.models.StudentResponseDto;
import rca.ac.rw.relations.services.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relations/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.createStudent(studentDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Student>> updateStudent(@RequestBody Student student,@PathVariable Integer id){
        Optional<Student> updatedStudent = studentService.updateStudent(student,id);

        if(updatedStudent.isPresent()){
            return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id){
        return new ResponseEntity<>(studentService.deleteStudent(id),HttpStatus.NO_CONTENT);
    }
}
