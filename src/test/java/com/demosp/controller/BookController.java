package com.demosp.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demosp.model.Book;
import com.demosp.model.Users;
import com.demosp.service.BookService;
import com.demosp.service.RegistrationService;


@RestController
public class BookController {

	
	@Autowired
	private BookService service;
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/saveBook")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<HttpStatus> saveBook(@RequestBody Book book) {
		try {
			System.out.println("caldl;admd");
		service.saveBooks(book);
		return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	@GetMapping ("/getBookList")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Book>> getBookList()
	{
		try
		{
			return new ResponseEntity<>(service.getBookList(), HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@GetMapping("/search/{word}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Book>> searchBook (@PathVariable String word){
		try
		{
			return new ResponseEntity<>(service.searchBook(word), HttpStatus.OK);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}

