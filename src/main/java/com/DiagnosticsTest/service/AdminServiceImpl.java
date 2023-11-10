package com.DiagnosticsTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DiagnosticsTest.entity.Admin;
import com.DiagnosticsTest.entity.User;
import com.DiagnosticsTest.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired   
	public AdminRepository adminRepository;
	
	

	@Override
	public List<Admin> findByRole(String user) {
		
		return adminRepository.findByRole(user);
	}

	@Override
	public Admin findByEmail(String user) {
		
		return adminRepository.findByEmail(user);
	}

	@Override
	public List<Admin> findAll() {
		
		return adminRepository.findAll();
	}

	@Override
	public void save(Admin admin) {
		
		adminRepository.save(admin);
		
	}


}
