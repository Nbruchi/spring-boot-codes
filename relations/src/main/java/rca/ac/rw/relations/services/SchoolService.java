package rca.ac.rw.relations.services;

import org.springframework.stereotype.Service;
import rca.ac.rw.relations.models.School;
import rca.ac.rw.relations.models.SchoolDto;
import rca.ac.rw.relations.repos.SchoolRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolService {
    private final SchoolRepo schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepo schoolRepo,SchoolMapper schoolMapper){
        this.schoolRepository = schoolRepo;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto createSchool(SchoolDto dto){
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDto> getAllSchools(){
        return schoolRepository
                .findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }

    public Optional<School> getSchool(Integer id){
        return schoolRepository.findById(id);
    }

    public Optional<School> updateSchool(SchoolDto school, Integer id){
        return schoolRepository.findById(id).map(updatedSchool -> {
            updatedSchool.setName(school.getName());

            return schoolRepository.save(updatedSchool);
        });
    }

    public Void deleteSchool(Integer id){
        schoolRepository.deleteById(id);
        return null;
    }
}
