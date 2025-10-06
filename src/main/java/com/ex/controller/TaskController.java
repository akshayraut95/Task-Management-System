package com.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ex.module.Task;
import com.ex.service.TaskService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	//create task
	@PostMapping("/save")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		//TODO: process POST request
		
		return ResponseEntity.ok(taskService.saveTask(task));
	}
	
	// get task by id
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
		
		return ResponseEntity.ok(taskService.getTaskById(id)); 
	}
	
	// get all tasks
	@GetMapping("/")
	public ResponseEntity<List<Task>> getAllTasks() {
		
		return ResponseEntity.ok(taskService.getAllTasks());
	}
	
	// get tasks by projectId
	@GetMapping("/project/{projectId}")
	public ResponseEntity<List<Task>> getTasksByProject(@PathVariable Long ProjectId) {
		
		return  ResponseEntity.ok(taskService.getTasksByProjectId(ProjectId));
	}
	

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {
		
		return ResponseEntity.ok(taskService.getTasksByUserId(userId));
	}
	
	// delete task by
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
      
		taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
	}
	
	// api added by me ...
	
	@PutMapping("status/{taskId}")
	public ResponseEntity<Task> updateTaskStatus(@PathVariable Long taskId, @RequestBody String status) {
    
		Task updatedTask=taskService.updateTaskStatus(taskId, status);
		
		return ResponseEntity.ok(updatedTask);
	}
	
}




