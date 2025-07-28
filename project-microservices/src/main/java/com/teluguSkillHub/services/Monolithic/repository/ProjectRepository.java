package com.teluguSkillHub.services.Monolithic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teluguSkillHub.services.Monolithic.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {
	Project findByProjectCode(long employeeSAssignedProject);

}
