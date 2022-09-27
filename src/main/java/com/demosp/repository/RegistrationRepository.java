package com.demosp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demosp.model.Users;

public interface RegistrationRepository extends JpaRepository<Users, Integer>{
	public Users findByEmailId(String emailId);
	public Users findByEmailIdAndPassword(String emailId,String password);

}
