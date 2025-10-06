package com.ex.service;

import java.util.List;

import com.ex.module.Task;

public interface TaskService {

	
	Task saveTask(Task task);
    
	Task getTaskById(Long id);
    
	List<Task> getAllTasks();
    
	List<Task> getTasksByProjectId(Long projectId);
    
	List<Task> getTasksByUserId(Long userId);
    
	void deleteTask(Long id);
	
	Task updateTaskStatus(Long taskId, String status);
}
