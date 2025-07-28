package com.teluguSkillHub.services.Monolithic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teluguSkillHub.services.Monolithic.entity.Project;
import com.teluguSkillHub.services.Monolithic.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	//save new projects
	@PostMapping
	public Project createProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}
	
	@GetMapping("/{project_code}")
	public Project getProjectByCode(
			@PathVariable(name="project_code")long project_code
			) {
		return projectService.getProjectByCode(project_code);
	}

}
