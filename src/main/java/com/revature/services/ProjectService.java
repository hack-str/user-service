package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Project;
import com.revature.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	public Project getProjectById(int id) {
		return projectRepository.findOne(id);
	}
	
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}
	
	public void deleteProject(int id) {
		projectRepository.delete(id);;
	}
}
