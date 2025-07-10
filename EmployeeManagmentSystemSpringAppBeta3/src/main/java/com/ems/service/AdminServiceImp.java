package com.ems.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.AdminEntity;
import com.ems.repository.AdminRepository;

@Service
public class AdminServiceImp implements IAdminService
{
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public AdminEntity AdminLogin(String Username, String password) {
		Optional<AdminEntity> ad = adminRepo.findByUsernameAndPassword(Username, password);
		return ad.orElseGet(()->null);	
	}

}
