package rca.ac.rw.mis.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rca.ac.rw.mis.model.Person;

import java.util.List;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    List<Person> findByLastName(String name);

    List<Person> findByEmail(String mail);

    List<Person> findByEmailContaining(String buhire);

    List<Person> findByFirstName(String firstName);
}
