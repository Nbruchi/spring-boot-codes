package rca.ac.rw.mis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rca.ac.rw.mis.model.*;
import rca.ac.rw.mis.repos.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MisApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PersonRepo repo){
		return args -> {

			Person p1 = new Person("John", "Muhire", "johnmuhire@gmail.com");
			Person p2 = new Person("Mary","Muhire", "muhireange@gmail.com");
			Person p3 = new Person("Odette","Muhire", "muhireodette@gmail.com");
			Person p4 = new Person("Ange","Buhire", "buhireange@gmail.com");
			Person p5 = new Person("John","Buhire", "johnbuhire@gmail.com");
			List<Person> people = new ArrayList<Person>();
			people.add(p1);
			people.add(p2);
			people.add(p3);
			people.add(p4);
			people.add(p5);
			repo.saveAll(people);

			List<Person> personList = repo.findAll();

			System.out.println("All people: ");
			for(Person person : personList){
				System.out.println(person.getFirstName());
			}

			List<Person> peopleList = repo.findByLastName("Muhire");
			System.out.println("All people with Muhire as Lastname: ");
			for(Person person : peopleList){
				System.out.println(person.getFirstName());
			}

			List<Person> peopleEmails = repo.findByEmailContaining("buhire");
			System.out.println("All people with buhire in their emails: ");
			for(Person person : peopleEmails){
				System.out.println(person.getEmail());
			}

			List<Person> peopleNames = repo.findByFirstName("John");

			System.out.println("People with John as firstname:");
			for(Person person : peopleNames){
				System.out.println(person.getEmail());
			}
		};
	}
}
