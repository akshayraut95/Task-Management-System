package com.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ex.module.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
