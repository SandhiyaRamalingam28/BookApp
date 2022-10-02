package com.demosp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Service
public class FavBook 
{
	@Id
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="favBook_id")
	private List<ItemFav>itemFav;
			
	//see how cart id is saved if error exists in cart as user id is saved as cart id
	@MapsId
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("favoriteBook")
	private Users users;

	
	public FavBook() {	}

	public FavBook(int id, List<ItemFav> itemFav, Users users) {
		this.id = id;
		this.itemFav = itemFav;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<ItemFav> getitemFav() {
		return itemFav;
	}


	public void setitemFav(List<ItemFav> itemFav) {
		this.itemFav = itemFav;
	}


	public Users getUser() {
		return users;
	}


	public void setUser(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "FavBook [id=" + id + ", itemFav=" + itemFav + ", users=" + users + "]";
	}
	
	

}
