package com.example.StudentManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagement.Entity.Course;
import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Repository.CourseRepository;
import com.example.StudentManagement.Repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	private final StudentRepository students;
	private final CourseRepository courses;


	public StudentService(StudentRepository students, CourseRepository courses) {
	this.students = students; this.courses = courses;
	}


	public List<Student> all() { return students.findAll(); }
	public Optional<Student> byId(Long id) { return students.findById(id); }
	public Student save(Student s) { return students.save(s); }
	public void delete(Long id) { students.deleteById(id); }


	public void enroll(Long studentId, Long courseId) {
	Student s = students.findById(studentId).orElseThrow();
	Course c = courses.findById(courseId).orElseThrow();
	s.getCourses().add(c);
	students.save(s);
	}


	public void unenroll(Long studentId, Long courseId) {
	Student s = students.findById(studentId).orElseThrow();
	Course c = courses.findById(courseId).orElseThrow();
	s.getCourses().remove(c);
	students.save(s);
	}

}
