package com.sweta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweta.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
