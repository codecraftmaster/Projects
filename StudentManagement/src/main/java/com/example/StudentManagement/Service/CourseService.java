package com.example.StudentManagement.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagement.Entity.Course;
import com.example.StudentManagement.Repository.CourseRepository;

@Service
@Transactional
public class CourseService {
	private final CourseRepository courses;
	public CourseService(CourseRepository courses) { this.courses = courses; }
	public List<Course> all() { return courses.findAll(); }
	public Optional<Course> byId(Long id) { return courses.findById(id); }
	public Course save(Course c) { return courses.save(c); }
	public void delete(Long id) { courses.deleteById(id); }

}
