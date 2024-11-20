package rca.ac.rw.relations.services;

import org.springframework.stereotype.Service;
import rca.ac.rw.relations.models.School;
import rca.ac.rw.relations.models.Student;
import rca.ac.rw.relations.models.StudentDto;
import rca.ac.rw.relations.models.StudentResponseDto;

@Service
public class StudentMapper {
    public Student toStudent(StudentDto dto){
        if(dto == null){
            throw new NullPointerException("Student Dto should not be null");
        }

        var student = new Student();
        student.setFirstname(dto.getFirstName());
        student.setLastname(dto.getLastName());
        student.setEmail(dto.getEmail());

        var school = new School();
        school.setId(dto.getSchoolId());
        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
}