package com.example.StudentManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagement.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByEmail(String email);

}
