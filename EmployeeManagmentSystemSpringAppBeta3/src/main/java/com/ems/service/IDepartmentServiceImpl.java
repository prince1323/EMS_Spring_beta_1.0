package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.DepartmentEntity;
import com.ems.repository.DepartmentRepository;

@Service
public class IDepartmentServiceImpl implements IDepartmentService
{

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	public Optional<Integer> getDepartmentCount() {
		return deptRepo.getDeptCount();
	}

	@Override
	public void addDepartment(DepartmentEntity dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<List<DepartmentEntity>> getDepartmentList() {
		List<DepartmentEntity> all = deptRepo.findAll();
		return Optional.of(all);
	}

//	@Override
//	public void addDepartment(DepartmentEntity dept) {
//		deptRepo.save(dept);
//	}

}
