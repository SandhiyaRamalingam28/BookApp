package com.demosp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demosp.model.Users;
import com.demosp.service.RegistrationService;



@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registerusers")
	@CrossOrigin(origins = "http://localhost:4200")
	public Users registerUsers(@RequestBody Users users) throws Exception {
		System.out.println(users.getUserName()+" "+ users.getPassword());
		String tempEmailId = users.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			Users usersobj = service.fetchUsersByEmailId(tempEmailId);
			if(usersobj != null) {
				throw new Exception("user with"+tempEmailId+" is already exist");
			}
		}
		Users usersObj = null;
		usersObj= service.saveUsers(users);
		return usersObj;
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public Users loginUser(@RequestBody Users users) throws Exception {
		String tempEmailId =users.getEmailId();
		String tempPass = users.getPassword();
		Users usersObbj = null; 
		if(tempEmailId !=null && tempPass !=null) {
			usersObbj = service.fetchUsersByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(usersObbj == null) {
			throw new Exception("Bad Credentials");
		}
		return usersObbj;
	}
	
}
