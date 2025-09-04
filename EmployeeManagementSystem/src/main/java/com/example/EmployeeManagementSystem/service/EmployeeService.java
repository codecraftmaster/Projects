package com.example.EmployeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
@Transactional

public class EmployeeService {
	private final EmployeeRepository repo;


	public EmployeeService(EmployeeRepository repo) {
	this.repo = repo;
	}


	public List<Employee> findAll() { return repo.findAll(); }
	public Optional<Employee> findById(Long id) { return repo.findById(id); }
	public Employee save(Employee e) { return repo.save(e); }
	public void delete(Long id) { repo.deleteById(id); }

}
