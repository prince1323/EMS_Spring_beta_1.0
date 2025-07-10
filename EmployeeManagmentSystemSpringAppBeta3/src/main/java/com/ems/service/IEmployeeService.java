package com.ems.service;

import java.util.List;
import java.util.Optional;
import com.ems.entity.EmployeeEntity;


public interface IEmployeeService
{
	public Optional<EmployeeEntity> addEmployee(EmployeeEntity e);
	public Optional<List<EmployeeEntity>>  getAllEmployees();
	public Optional<Integer> getEmployeesCount();
	public Optional<EmployeeEntity> getEmployeeById(Long id);
	public void updateEmployee(EmployeeEntity employee);
	public void deleteEmployeeById(Long id);
}
