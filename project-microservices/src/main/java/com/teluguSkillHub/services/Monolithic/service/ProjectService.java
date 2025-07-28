package com.teluguSkillHub.services.Monolithic.service;

import com.teluguSkillHub.services.Monolithic.entity.Project;

public interface ProjectService {
	public Project saveProject(Project project);
	public Project getProjectByCode(long projectCode);

}
