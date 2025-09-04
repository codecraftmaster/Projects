package com.example.StudentManagement.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.StudentManagement.Entity.Course;
import com.example.StudentManagement.Service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // LIST all courses
    @GetMapping
    public String list(Model model) {
        model.addAttribute("courses", courseService.all());
        return "courses/list";  // templates/courses/list.html
    }

    // SHOW create course form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        return "courses/create"; // templates/courses/create.html
    }

    // SAVE new course
    @PostMapping("/create")
    public String createCourse(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }

    // SHOW edit course form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Course course = courseService.byId(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
        model.addAttribute("course", course);
        return "courses/edit"; // templates/courses/edit.html
    }

    // UPDATE course
    @PostMapping("/edit/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute Course course) {
        course.setId(id);
        courseService.save(course);
        return "redirect:/courses";
    }

    // DELETE course
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return "redirect:/courses";
    }
}
