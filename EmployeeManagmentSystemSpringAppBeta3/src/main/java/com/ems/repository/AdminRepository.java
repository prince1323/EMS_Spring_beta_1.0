package com.ems.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ems.entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {

	public Optional<AdminEntity> findByUsernameAndPassword(String username, String password);

	@Query(nativeQuery = true, value = "select count(*) from MVC_PROJ1_EMS_EMP_ENTITY")
	public Integer getTotalEmployees();
	
	@Query(nativeQuery = true, value = "select count(*) from MVC_PROJ1_EMS_DEPT_ENTITY")
	public Integer getTotalDepartments();
	
	@Query(nativeQuery = true, value = "select count(*) from MVC_PROJ1_PROJECT")
	public Integer getTotalProject();
	
}
