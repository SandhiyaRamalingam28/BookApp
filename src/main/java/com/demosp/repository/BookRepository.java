package com.demosp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demosp.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

//	public List<Book> findByUsers_Id(int userId);

	@Query(value = "SELECT p FROM Book p WHERE  p.bookName LIKE '%' || :keyword || '%'"
			+ " OR p.description LIKE '%' || :keyword || '%'" + " OR p.authorName LIKE '%' || :keyword || '%'")
	public List<Book> searchByKeyword(String keyword);

}
