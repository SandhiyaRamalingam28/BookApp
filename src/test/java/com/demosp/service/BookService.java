package com.demosp.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demosp.model.Book;
import com.demosp.model.Users;
import com.demosp.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;
	
	public Book saveBooks(Book book) {
		return repo.save(book);
	}
	
	public Optional<Book> getBookById(int bookId) {
		return repo.findById(bookId);
	}
	
	public List<Book> searchBook(String word) {
		return repo.searchByKeyword(word);
	}

	 public List<Book> getBookList() {
		return repo.findAll();
		
	}
}
