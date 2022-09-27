package com.demosp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demosp.model.Book;
import com.demosp.model.FavBook;
import com.demosp.model.ItemFav;
import com.demosp.model.Users;
import com.demosp.service.BookService;
import com.demosp.service.FavBookService;
import com.demosp.service.RegistrationService;

@RestController
public class FavBookController 
{
	@Autowired  
	private FavBook favBook;
	@Autowired
	private FavBookService service;
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private BookService bookService;
	
	@GetMapping("/addToFavorite/{userId}/{bookId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<HttpStatus> addToFavorite(@PathVariable int userId,@PathVariable int bookId) {
		try {
			
			Optional<Book>book=bookService.getBookById(bookId);
			Optional<Users>user= registrationService.getUserById(userId);
			if(book.isEmpty() && user.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
			System.out.println(book.get().getId() +"  "+ user.get().getId());
			favBook=service.addBooksToFavorites(book.get(),user.get());
			//registrationService.saveFaveToUser(favBook,user.get());
			return new ResponseEntity<>(HttpStatus.OK);
			}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@GetMapping("/getFavoriteList/{userId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ItemFav>> getFavoriteList(@PathVariable int userId){
		try {
			Optional<Users>user= registrationService.getUserById(userId);
			if(user.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			favBook=service.getFavByUserId(userId);
			return new ResponseEntity<>(favBook.getitemFav(), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@DeleteMapping("/deleteBookFromFav/{userId}/{bookId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<ItemFav>> deleteFav (@PathVariable int userId, @PathVariable int bookId)
	{
		try {
			favBook=service.removeBookFromList(userId,bookId);
			return new ResponseEntity<>(favBook.getitemFav(),HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
