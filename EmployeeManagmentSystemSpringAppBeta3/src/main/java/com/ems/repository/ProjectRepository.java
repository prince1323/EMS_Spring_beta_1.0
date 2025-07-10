package com.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>
{
	@Query(nativeQuery = true, value = "select count(*) from MVC_PROJ1_PROJECT")
	public Optional<Integer> getProjectCount();
}
