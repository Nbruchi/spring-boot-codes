package rca.ac.rw.relations.services;

import org.springframework.stereotype.Service;
import rca.ac.rw.relations.models.School;
import rca.ac.rw.relations.models.SchoolDto;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDto dto) {
        return new School(dto.getName());
    }

    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }
}
