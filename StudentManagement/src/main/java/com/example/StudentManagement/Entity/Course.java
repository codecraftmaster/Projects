package com.example.StudentManagement.Entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Course {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@NotBlank @Size(max = 200)
@Column(unique = true)
private String code; // e.g., CS101


@NotBlank @Size(max = 255)
private String title;


@Size(max = 1000)
private String description;


@ManyToMany(mappedBy = "courses")
private Set<Student> students = new LinkedHashSet<>();


// getters/setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getCode() { return code; }
public void setCode(String code) { this.code = code; }
public String getTitle() { return title; }
public void setTitle(String title) { this.title = title; }
public String getDescription() { return description; }
public void setDescription(String description) { this.description = description; }
public Set<Student> getStudents() { return students; }
public void setStudents(Set<Student> students) { this.students = students; }
}