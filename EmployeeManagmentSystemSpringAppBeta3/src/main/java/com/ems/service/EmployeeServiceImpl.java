package com.ems.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ems.entity.EmployeeEntity;
import com.ems.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public Optional<EmployeeEntity> addEmployee(EmployeeEntity e) {
		EmployeeEntity save = empRepo.save(e);
		return Optional.of(save);
	}

	@Override
	public Optional<List<EmployeeEntity>> getAllEmployees() {
		List<EmployeeEntity> al = empRepo.findAll();
		return Optional.of(al);
	}

	@Override
	public Optional<Integer> getEmployeesCount() {
		return empRepo.getEmpCount();
	}

	@Override
	public Optional<EmployeeEntity> getEmployeeById(Long id) {
		Optional<EmployeeEntity> emp = empRepo.findById(id);
		return emp;
	}

	@Override
	public void updateEmployee(EmployeeEntity employee) {
		empRepo.save(employee);
	}
	
	@Override
	public void deleteEmployeeById(Long id) {
	    empRepo.deleteById(id);
	}

}
