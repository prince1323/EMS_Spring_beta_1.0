package com.ems.service;

import com.ems.entity.AdminEntity;

public interface IAdminService 
{
	public AdminEntity AdminLogin(String Username, String password);
//	public Integer getTotalNoOfEmployees();
//	public Integer getTotalNoOfDepartments();
//	public Integer getTotalNoOfProjects();
}
