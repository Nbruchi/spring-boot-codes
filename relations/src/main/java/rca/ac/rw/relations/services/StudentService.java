package rca.ac.rw.relations.services;

import org.springframework.stereotype.Service;
import rca.ac.rw.relations.models.Student;
import rca.ac.rw.relations.models.StudentDto;
import rca.ac.rw.relations.models.StudentResponseDto;
import rca.ac.rw.relations.repos.StudentRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepo studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepo studentRepo,StudentMapper studentMapper){
        this.studentRepository = studentRepo;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto createStudent(StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public Optional<Student> updateStudent(Student updatedStudent,Integer id){
        return studentRepository.findById(id).map(student -> {
            student.setFirstname(updatedStudent.getFirstname());
            student.setLastname(updatedStudent.getLastname());
            student.setEmail(updatedStudent.getEmail());
            student.setSchool(updatedStudent.getSchool());

            return studentRepository.save(student);
        });
    }

    public Optional<Student> getStudentById(Integer id){
        return studentRepository.findById(id);
    }

    public List<StudentResponseDto> getAllStudents(){
        return studentRepository
                .findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    public Void deleteStudent(Integer id){
        studentRepository.deleteById(id);
        return null;
    }
}
