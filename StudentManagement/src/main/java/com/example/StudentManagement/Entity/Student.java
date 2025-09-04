package com.example.StudentManagement.Entity;



import java.time.LocalDate;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Student {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@NotBlank @Size(max = 100)
private String firstName;


@NotBlank @Size(max = 100)
private String lastName;


@Email @NotBlank
@Column(unique = true)
private String email;


private LocalDate dob;


@ManyToMany
@JoinTable(name = "student_courses",
joinColumns = @JoinColumn(name = "student_id"),
inverseJoinColumns = @JoinColumn(name = "course_id"))
private Set<Course> courses = new LinkedHashSet<>();


// getters/setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getFirstName() { return firstName; }
public void setFirstName(String firstName) { this.firstName = firstName; }
public String getLastName() { return lastName; }
public void setLastName(String lastName) { this.lastName = lastName; }
public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }
public LocalDate getDob() { return dob; }
public void setDob(LocalDate dob) { this.dob = dob; }
public Set<Course> getCourses() { return courses; }
public void setCourses(Set<Course> courses) { this.courses = courses; }
}