package rca.ac.home.work.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Consultant {
    @Id
    private String consultantName;
    @Embedded
    private Contact contact;
    @OneToMany(mappedBy = "consultant",cascade = CascadeType.ALL)
    private List<Employee> employees;

    @OneToOne(mappedBy = "leader")
    private Department department;

    public Consultant() {
    }

    public Consultant(String consultantName) {
        this.consultantName = consultantName;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String name) {
        this.consultantName = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
