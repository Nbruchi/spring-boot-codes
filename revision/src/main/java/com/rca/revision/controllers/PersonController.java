package com.rca.revision.controllers;

import com.rca.revision.models.Person;
import com.rca.revision.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/people")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Person> createUser(@RequestBody Person person){
        return ResponseEntity.ok(service.createPerson(person));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllUsers(){
        return ResponseEntity.ok(service.getAllPeople());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable UUID id){
        return ResponseEntity.ok(service.getPerson(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Person>> updatePerson(@RequestBody Person person,@PathVariable UUID id){
        return ResponseEntity.ok(service.update(person,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable UUID id){
        return ResponseEntity.ok(service.deletePerson(id));
    }
}


