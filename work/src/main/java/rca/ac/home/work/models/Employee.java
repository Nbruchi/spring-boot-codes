package rca.ac.home.work.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Employee {
    @Id
    @NotEmpty
    private String employeeName;
    @NotNull
    private Integer age;
    private LocalDate hiredDate;

    @Embedded
    private Contact contact;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_companies",
            joinColumns = @JoinColumn(name = "employeeName"),
            inverseJoinColumns = @JoinColumn(name = "company")
    )
    private List<Company> companies;

    @ManyToOne
    @JoinColumn(name = "consultantName")
    private Consultant consultant;

    @OneToOne
    @JoinColumn
    private Department department;

    @OneToOne
    @JoinColumn
    private Vehicle vehicle;

    public Employee() {
    }

    public Employee(String employeeName, Integer age, LocalDate hiredDate) {
        this.employeeName = employeeName;
        this.age = age;
        this.hiredDate = hiredDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }
}
