package com.example.EmployeeManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagementSystem.Entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
