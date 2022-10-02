package com.demosp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demosp.model.Book;
import com.demosp.model.FavBook;

@Repository
public interface FavBookRepository  extends JpaRepository<FavBook, Integer>{


	FavBook findByUsers_Id(int id);
	
}
