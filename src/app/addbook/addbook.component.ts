import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-addbook',
  templateUrl: './addbook.component.html',
  styleUrls: ['./addbook.component.css']
})
export class AddbookComponent implements OnInit {

  book=new Book();
  constructor(private service : BookService,private router : Router) { }

  ngOnInit(): void {
  }
  saveBook()
  {
    this.service.saveBook(this.book).subscribe(
      (data: Book)=>{
        console.warn("saved "),
        

        this.router.navigate(['/home']);
      }
    )
  }

}
