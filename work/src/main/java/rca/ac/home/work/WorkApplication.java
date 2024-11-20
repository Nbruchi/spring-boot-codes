package rca.ac.home.work;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rca.ac.home.work.models.*;
import rca.ac.home.work.repos.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
		CompanyRepo companyRepo,
		ConsultantRepo consultantRepo,
		DepartmentRepo departmentRepo,
		EmployeeRepo employeeRepo,
		VehicleRepo vehicleRepo
	){
		return args -> {
			// Company
			Address address = new Address("Kigali","Gisozi");
			Company company = new Company("Apple",address);
			companyRepo.save(company);

			// Department
			Department department = new Department("Product Management");
			department.setCompany(company);

			// Vehicle
			Vehicle vehicle = new Vehicle("Model 3","Tesla", LocalDate.of(2024,4,10));

			// Consultant
			Consultant consultant = new Consultant("Steve");
			department.setLeader(consultant);

			// Employee
			Contact contact = new Contact("bruce@gmail.com","078877665544");
			Employee employee = new Employee("Bruce",20,LocalDate.of(2024,1,20));
			employee.setContact(contact);

			List<Company> companyList = new ArrayList<>();
			companyList.add(company);
			employee.setCompanies(companyList);

			employee.setConsultant(consultant);
			employee.setDepartment(department);
			employee.setVehicle(vehicle);

			vehicle.setOwner(employee);

			consultantRepo.save(consultant);
			departmentRepo.save(department);

			vehicleRepo.save(vehicle);
			employeeRepo.save(employee);
		};
	};
}
