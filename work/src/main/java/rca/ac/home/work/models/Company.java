package rca.ac.home.work.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    private String companyName;
    @Embedded
    private Address address;
    @ManyToMany(mappedBy = "companies",cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Department> departments;

    public Company() {
    }

    public Company(String companyName, Address address) {
        this.companyName = companyName;
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String name) {
        this.companyName = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
