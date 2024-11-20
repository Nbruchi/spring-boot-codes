package rca.ac.rw.mis.services;

import org.springframework.stereotype.Service;
import rca.ac.rw.mis.model.Person;
import rca.ac.rw.mis.repos.PersonRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepo repo;

    public PersonService(PersonRepo personRepo){
        this.repo = personRepo;
    }

    public void addPerson(Person person){
        repo.save(person);
    }

    public List<Person> listAllPeople(){
        return repo.findAll();
    }

    public Optional<Person> findPersonById(Integer id){
        return repo.findById(id);
    }

    public List<Person> findAllPeopleWithLastName(String last){
        return repo.findByLastName(last);
    }
}
