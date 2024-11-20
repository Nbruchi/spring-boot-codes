package rca.ac.rw.mis.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rca.ac.rw.mis.model.Person;
import rca.ac.rw.mis.services.PersonService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/people")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    public void addPerson(Person person){
        service.addPerson(person);
    }
}
