import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';
import { ItemFav } from '../item-fav';

@Component({
  selector: 'app-favlist',
  templateUrl: './favlist.component.html',
  styleUrls: ['./favlist.component.css']
})
export class FavlistComponent implements OnInit {

  book=new Book();
  bookList:ItemFav[]=[];
  msg='';
  keyword:string;
  userId: number;
  constructor(private router:Router,private service:BookService) { }

  ngOnInit(): void {
    this.display();
  }

  deleteFromFav(bookid:number){
    this.userId=JSON.parse(localStorage.getItem("userId")!);
    this.service.removeFromFav(bookid,this.userId).subscribe(
      ( data: ItemFav[])=>{
        this.bookList=data;
      }
    )

  }
  searchSubmit()
  { 
    if(this.keyword.length >0)
    {
      this.searchProduct();
    }
    else{
      this.display();
    }
  }
  private searchProduct(){
    this.service.searchBook(this.keyword).subscribe(data => {
      this.bookList = data;
    },
    error=>{
      console.error(error);
      this.msg="No Book Found";
      console.error(error);
    }
    );
  }
  display(){
    this.userId=JSON.parse(localStorage.getItem("userId")!);
    console.log(this.userId);
    this.service.getFavoriteBookList(this.userId).subscribe(
      data=>
        {
          console.log("Favorite List Received");
          this.bookList=data;
          console.log(this.bookList)
        },
        error=> 
        {
          console.log("Exception Occured in receiving the Book list");
        }
      )
  }
}
