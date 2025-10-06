package com.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.module.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

	 List<Task> findByProjectId(Long projectId);
	   
	 List<Task> findByAssignedUser_Id(Long userId);

	
}
