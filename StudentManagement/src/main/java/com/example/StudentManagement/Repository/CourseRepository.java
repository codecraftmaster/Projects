package com.example.StudentManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagement.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	Optional<Course> findByCode(String code);

}
