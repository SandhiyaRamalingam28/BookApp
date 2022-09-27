package com.demosp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Service;

@Entity
@Service
public class ItemFav 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int favId;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	private Book book;

	public ItemFav() {}
	public ItemFav(int id, int favId, Book book) {
		super();
		this.id = id;
		this.favId = favId;
		this.book = book;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFavId() {
		return favId;
	}
	public void setFavId(int favId) {
		this.favId = favId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "ItemFav [id=" + id + ", favId=" + favId + ", book=" + book + "]";
	}
	
	
	
}
