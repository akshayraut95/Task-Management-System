package com.ex.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.module.Project;
import com.ex.service.ProjectService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
   @PostMapping("/save")
   public ResponseEntity<Project> createProject(@RequestBody Project project)
   {
	   return ResponseEntity.ok(projectService.saveProject(project));
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
       
	   return ResponseEntity.ok(projectService.getProjectById(id));
   }
   
   @GetMapping("/")
   public ResponseEntity<List<Project>> getAllProjects() {
       
	   return ResponseEntity.ok(projectService.getAllProjects());
   }
   
   
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteProjectById(@PathVariable Long id)
   {
	   projectService.deleteProject(id);
	   return ResponseEntity.ok("project deleted succesfully");
   }
   
   
   
   
   
   
}
