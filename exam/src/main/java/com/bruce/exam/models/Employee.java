package com.bruce.exam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    @NotBlank(message = "Firstname is required")
    @Column(nullable = false)
    private String firstname;
    @NotBlank(message = "Lastname is required")
    @Column(nullable = false)
    private String lastname;
    @NotBlank(message = "Institution is required")
    @Column(nullable = false)
    private String institution;
    @NotBlank(message = "Position is required")
    @Column(nullable = false)
    private String position;

    public Employee() {
    }

    public Employee(String firstname, String lastname, String institution, String position) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.institution = institution;
        this.position = position;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
