package com.example.EmployeeManagementSystem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initData(EmployeeRepository repo) {
	return args -> {
	repo.save(new Employee("Alice", "Johnson", "alice.johnson@example.com", "Engineering", 72000.0));
	repo.save(new Employee("Bob", "Mehta", "bob.mehta@example.com", "Sales", 54000.0));
	repo.save(new Employee("Cathy", "Lee", "cathy.lee@example.com", "HR", 60000.0));
	};
	}

}
