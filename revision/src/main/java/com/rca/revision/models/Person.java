package com.rca.revision.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "people")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false,nullable = false)
    private UUID id;
    @NotBlank(message = "Firstname is required")
    private String firstname;
    @NotBlank(message = "Lastname is required")
    private String lastname;
    @Email(message = "Email already exists")
    private String email;
    @NotBlank(message = "Mobile number is required")
    @Column(nullable = false,unique = true)
    private String mobile;
    @Column(nullable = false)
    private String password;
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;
    @OneToMany(mappedBy = "creator",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Post> posts;
}
