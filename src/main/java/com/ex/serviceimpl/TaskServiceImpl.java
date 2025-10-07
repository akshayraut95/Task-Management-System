package com.ex.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.module.Task;
import com.ex.repository.TaskRepository;
import com.ex.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	
	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return taskRepository.save(task);
	}

	@Override
	public Task getTaskById(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id).orElse(null);
	}

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepository.findAll();
	}

	@Override
	public List<Task> getTasksByProjectId(Long projectId) {
		// TODO Auto-generated method stub
		return taskRepository.findByProjectId(projectId);
	}

	@Override
	public List<Task> getTasksByUserId(Long userId) {
		// TODO Auto-generated method stub
		return taskRepository.findByAssignedUser_Id(userId);
	}

	@Override
	public void deleteTask(Long id) {
		// TODO Auto-generated method stub
		
		taskRepository.deleteById(id);
	}

	@Override
	public Task updateTaskStatus(Long taskId, String status) {
		
		Task task=taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("task not found with id "+taskId));
		task.setStatus(status); // Directly update entity
		return taskRepository.save(task);
	}

}
