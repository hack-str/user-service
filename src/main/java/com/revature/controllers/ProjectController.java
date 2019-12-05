package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Project;
import com.revature.services.ProjectService;

@CrossOrigin
@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}

	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable("id") int id) {
		return projectService.getProjectById(id);
	}

	@PostMapping
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		return new ResponseEntity<Project>(projectService.createProject(project),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") int id){
		projectService.deleteProject(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable("id") int id, @RequestBody Project project){
		project.setId(id);
		return new ResponseEntity<Project>(projectService.updateProject(project),HttpStatus.OK);
	}
}
