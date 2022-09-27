package com.demosp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demosp.model.Book;
import com.demosp.model.FavBook;
import com.demosp.model.ItemFav;
import com.demosp.model.Users;
import com.demosp.repository.FavBookRepository;
import com.demosp.repository.ItemFavRepository;

@Service
public class FavBookService {
	
	@Autowired
	private FavBookRepository repo; 
	@Autowired
	private BookService bookService;
	@Autowired
	private ItemFavRepository itemRepo;
	@Autowired 
	private RegistrationService loginService;
	@Autowired
	private FavBook favBook; 
	@Autowired
	private Optional<FavBook> favBook1;
	@Autowired 
	private ItemFav itemFav;
	@Autowired 
	private Optional<Users> user;
	@Autowired 
	private Users users;
	@Autowired 
	private Optional<Book> bookOpt;
	@Autowired
	private Book book;
	
	public FavBook addBooksToFavorites(Book book, Users user) 
	{
		List<ItemFav>list;
		favBook=repo.findByUsers_Id(user.getId());
		itemFav=new ItemFav();
		System.out.println("addToFav^%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%5"+user.getId());
		if(favBook==null)
		{
			System.out.println(" Fav null");
			favBook=new FavBook();
			list=new ArrayList<ItemFav>();
			itemFav.setBook(book);
			itemFav.setFavId(user.getId());
			itemRepo.save(itemFav);
			list.add(itemFav);
			System.out.println();
			System.out.println();
			
		}else
		{
			System.out.println(" Fav exist&&&&&&&&&&&&&&&&&&&&&7"+user.getId()+favBook.getId());
			itemFav.setBook(book);
			itemFav.setFavId(user.getId());			
			list=favBook.getitemFav();
			itemRepo.save(itemFav);
			list.add(itemFav);
		}
		System.out.println(list);
		favBook.setitemFav(list);
		favBook.setUser(user);
		loginService.saveFaveToUser(favBook, user);
		//return repo.save(favBook);
		return favBook;
	}

	public  FavBook getFavByUserId(int userId) {
		favBook=new FavBook();
		return repo.findByUsers_Id(userId);
	}

	public FavBook removeBookFromList(int userId, int bookId) {
		user=loginService.getUserById(userId);
		users=new Users();
		users=user.get();
		book=new Book();
		bookOpt=bookService.getBookById(bookId);
		book=bookOpt.get();
		favBook1=repo.findById(userId);
		favBook=favBook1.get();
		List<ItemFav>list=favBook.getitemFav();
		System.out.println();
		for(ItemFav item :list) {
			System.out.println(item.getId()+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			if(item.getBook().getId()==bookId && item.getFavId()==favBook.getId()) {
				itemFav=item;
				System.out.println(itemFav+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				break;
			}
		}
		System.out.println(favBook.toString()+"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		list.remove(itemFav);
		favBook.setitemFav(list);
		repo.save(favBook);
		System.out.println(favBook.toString()+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return favBook;
	}

}
