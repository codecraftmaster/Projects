package com.example.EmployeeManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.EmployeeManagementSystem.Entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService service;


	public EmployeeController(EmployeeService service) {
	this.service = service;
	}


	@GetMapping
	public String list(Model model) {
	model.addAttribute("employees", service.findAll());
	return "employees/list";
	}


	@GetMapping("/new")
	public String createForm(Model model) {
	model.addAttribute("employee", new Employee());
	return "employees/form";
	}


	@PostMapping
	public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult br) {
	if (br.hasErrors()) return "employees/form";
	service.save(employee);
	return "redirect:/employees";
	}


	@GetMapping("/{id}/edit")
	public String editForm(@PathVariable Long id, Model model) {
	var e = service.findById(id).orElseThrow();
	model.addAttribute("employee", e);
	return "employees/form";
	}


	@PostMapping("/{id}/delete")
	public String delete(@PathVariable Long id) {
	service.delete(id);
	return "redirect:/employees";
	}


	@GetMapping("/{id}")
	public String view(@PathVariable Long id, Model model) {
	var e = service.findById(id).orElseThrow();
	model.addAttribute("employee", e);
	return "employees/view";
	}

}