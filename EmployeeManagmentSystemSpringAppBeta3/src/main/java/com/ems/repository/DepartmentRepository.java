package com.ems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.entity.DepartmentEntity;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
	
	@Query(nativeQuery = true, value = "select count(*) from MVC_PROJ1_EMS_DEPT_ENTITY")
	public Optional<Integer> getDeptCount();
}
