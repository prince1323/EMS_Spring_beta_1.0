package com.ems.service;

import java.util.List;
import java.util.Optional;

import com.ems.entity.DepartmentEntity;

public interface IDepartmentService {
	public Optional<Integer> getDepartmentCount();
	public void addDepartment(DepartmentEntity dept);
	public Optional<List<DepartmentEntity>> getDepartmentList();
}
