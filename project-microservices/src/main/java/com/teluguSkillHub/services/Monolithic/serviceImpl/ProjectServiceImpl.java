package com.teluguSkillHub.services.Monolithic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teluguSkillHub.services.Monolithic.entity.Project;
import com.teluguSkillHub.services.Monolithic.repository.ProjectRepository;
import com.teluguSkillHub.services.Monolithic.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	
	@Override
	public Project saveProject(Project project) {
		Project savedProject=projectRepository.save(project);
		return savedProject;
	}
	@Override
	public Project getProjectByCode(long projectCode) {
		Project foundProject=projectRepository.findByProjectCode(projectCode);
		return foundProject;
	}

}
