package com.ex.service;

import java.util.List;

import com.ex.module.Project;

public interface ProjectService {

	Project saveProject(Project project);
    
	Project getProjectById(Long id);
    
	List<Project> getAllProjects();
    
	void deleteProject(Long id);
}
