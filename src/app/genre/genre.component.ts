import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-genre',
  templateUrl: './genre.component.html',
  styleUrls: ['./genre.component.css']
})
export class GenreComponent implements OnInit {

  book=new Book();
  bookList:Book[]=[];
  msg='';
  keyword!:string;
  found=true;
  userId:number;

  constructor(private router:Router,private service:BookService) { }

  ngOnInit(): void { 
    this.display();
  }

  display(){
    this.service.getBookList().subscribe(
      data=>
        {
          console.log("Inventory List Received");
          this.bookList=data;
          console.log(this.bookList)
        },
        error=> 
        {
          console.log("Exception Occured in receiving the Book list");
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
  addToFav(bookId:number)
  {
    this.userId=JSON.parse(localStorage.getItem("userId")!);
    console.log(this.userId);
    this.service.addBookToFavorite(this.userId,bookId).subscribe(data =>
      {
        console.log(data);
      })
  }
}
