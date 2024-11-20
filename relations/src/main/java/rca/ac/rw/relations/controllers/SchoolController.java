package rca.ac.rw.relations.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rca.ac.rw.relations.models.School;
import rca.ac.rw.relations.models.SchoolDto;
import rca.ac.rw.relations.services.SchoolService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/relations/schools")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @PostMapping
    public ResponseEntity<SchoolDto> createSchool(@RequestBody SchoolDto school){
        return new ResponseEntity<>(schoolService.createSchool(school), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<School>> updateSchool(@RequestBody SchoolDto school, @PathVariable Integer id){
       Optional<School> updatedSchool = schoolService.updateSchool(school,id);

       if(updatedSchool.isPresent()){
           return new ResponseEntity<>(updatedSchool,HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping
    public ResponseEntity<List<SchoolDto>> getAllSchools(){
        return new ResponseEntity<>(schoolService.getAllSchools(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<School>> getSchoolById(@PathVariable Integer id){
        return new ResponseEntity<>(schoolService.getSchool(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Integer id){
        return new ResponseEntity<>(schoolService.deleteSchool(id),HttpStatus.NO_CONTENT);
    }
}
