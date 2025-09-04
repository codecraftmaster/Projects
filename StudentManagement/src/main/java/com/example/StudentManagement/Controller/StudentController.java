package com.example.StudentManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.StudentManagement.Entity.Student;
import com.example.StudentManagement.Service.CourseService;
import com.example.StudentManagement.Service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	private final StudentService studentService;
	private final CourseService courseService;


	public StudentController(StudentService studentService, CourseService courseService) {
	this.studentService = studentService;
	this.courseService = courseService;

}

	@GetMapping
	public String list(Model model) {
	model.addAttribute("students", studentService.all());
	 return "students/list";
	}
	@GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/students";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.byId(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        model.addAttribute("student", student);
        return "students/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        student.setId(id); // ensure the ID is set
        studentService.save(student);
        return "redirect:/students";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
    @GetMapping("/{id}/courses")
    public String manageCourses(@PathVariable Long id, Model model) {
        Student student = studentService.byId(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        model.addAttribute("student", student);
        model.addAttribute("allCourses", courseService.all());
        return "students/courses";
    }

    @PostMapping("/{id}/courses/enroll")
    public String enrollCourse(@PathVariable Long id, @RequestParam Long courseId) {
        studentService.enroll(id, courseId);
        return "redirect:/students/" + id + "/courses";
    }

    @PostMapping("/{id}/courses/unenroll")
    public String unenrollCourse(@PathVariable Long id, @RequestParam Long courseId) {
        studentService.unenroll(id, courseId);
        return "redirect:/students/" + id + "/courses";
    }

}

