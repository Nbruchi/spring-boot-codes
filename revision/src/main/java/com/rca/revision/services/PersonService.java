package com.rca.revision.services;

import com.rca.revision.models.Person;
import com.rca.revision.repos.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonRepo repository;

    public PersonService(PersonRepo personRepo){
        this.repository = personRepo;
    }

    public Person createPerson(Person person){return repository.save(person);};

    public List<Person> getAllPeople(){
        return repository.findAll();
    }

    public Optional<Person> getPerson(UUID id){
        return repository.findById(id);
    }

    public Optional<Person> update(Person person, UUID id){
        return repository.findById(id).map(user -> {
           user.setFirstname(person.getFirstname());
           user.setLastname(person.getLastname());
           user.setEmail(person.getEmail());
           user.setMobile(person.getMobile());

           return repository.save(user);
        });
    }

    public String deletePerson(UUID id){
        repository.deleteById(id);
        return "Person deleted";
    }
}
