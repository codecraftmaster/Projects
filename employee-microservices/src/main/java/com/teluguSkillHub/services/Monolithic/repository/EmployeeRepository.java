package com.teluguSkillHub.services.Monolithic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teluguSkillHub.services.Monolithic.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
