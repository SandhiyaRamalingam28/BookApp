package com.demosp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demosp.model.Users;
import com.demosp.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repo;
	
	public Users saveUsers(Users users) {
		return repo.save(users);
		
	}
	public Users fetchUsersByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public Users fetchUsersByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}

}
