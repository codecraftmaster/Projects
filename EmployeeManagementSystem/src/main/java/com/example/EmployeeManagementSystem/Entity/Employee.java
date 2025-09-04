package com.example.EmployeeManagementSystem.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@NotBlank
private String firstName;


@NotBlank
private String lastName;


@Email
@NotBlank
private String email;


private String department;


@PositiveOrZero
private Double salary;


public Employee() {}


public Employee(String firstName, String lastName, String email, String department, Double salary) {
this.firstName = firstName;
this.lastName = lastName;
this.email = email;
this.department = department;
this.salary = salary;
}


// getters and setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getFirstName() { return firstName; }
public void setFirstName(String firstName) { this.firstName = firstName; }
public String getLastName() { return lastName; }
public void setLastName(String lastName) { this.lastName = lastName; }
public String getEmail() { return email; }
public void setEmail(String email) { this.email = email; }
public String getDepartment() { return department; }
public void setDepartment(String department) { this.department = department; }
public Double getSalary() { return salary; }
public void setSalary(Double salary) { this.salary = salary; }
}