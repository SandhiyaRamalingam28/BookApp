package com.demosp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demosp.model.Book;
import com.demosp.model.FavBook;
import com.demosp.model.Users;
import com.demosp.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	@Autowired
	private Optional<Users> user;
	
	public Users saveUsers(Users users) {
		return repo.save(users);
		
	}
	public Users fetchUsersByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public Users fetchUsersByEmailIdAndPassword(String email,String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}
	public Optional<Users> getUserById(int userId) {
		
		return repo.findById(userId);
	}
	public void saveFaveToUser(FavBook favBook, Users users) {
		user=repo.findById(users.getId());
		users=user.get();
		users.setFavoriteBook(favBook);
		repo.save(users);
		
	}
	
	
	

}
