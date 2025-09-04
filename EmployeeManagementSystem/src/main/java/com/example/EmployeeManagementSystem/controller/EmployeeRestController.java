package com.example.EmployeeManagementSystem.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
private final EmployeeService service;


public EmployeeRestController(EmployeeService service) {
this.service = service;
}


@GetMapping
public List<Employee> all() { return service.findAll(); }


@GetMapping("/{id}")
public ResponseEntity<Employee> get(@PathVariable Long id) {
return service.findById(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}


@PostMapping
public ResponseEntity<Employee> create(@RequestBody Employee e) {
Employee saved = service.save(e);
return ResponseEntity.created(URI.create("/api/employees/" + saved.getId())).body(saved);
}


@PutMapping("/{id}")
public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee e) {
return service.findById(id).map(existing -> {
existing.setFirstName(e.getFirstName());
existing.setLastName(e.getLastName());
existing.setEmail(e.getEmail());
existing.setDepartment(e.getDepartment());
existing.setSalary(e.getSalary());
service.save(existing);
return ResponseEntity.ok(existing);
}).orElse(ResponseEntity.notFound().build());
}


@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id) {
service.delete(id);
return ResponseEntity.noContent().build();
}
}