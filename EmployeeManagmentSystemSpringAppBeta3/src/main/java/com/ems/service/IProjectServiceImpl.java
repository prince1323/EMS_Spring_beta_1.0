package com.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.repository.ProjectRepository;

@Service
public class IProjectServiceImpl implements IProjectService {

	@Autowired
	private ProjectRepository projRepo;
	
	@Override
	public Optional<Integer> getProjectCount() {
		return projRepo.getProjectCount();
	}

}
