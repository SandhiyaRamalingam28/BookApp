import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http : HttpClient) { }
  
  public saveBook(book :Book):Observable<any>{
    return this.http.post<any>("http://localhost:8090/saveBook",book)
  }
  
  public getBookList():Observable<any>{
    return this.http.get<any>("http://localhost:8090/getBookList")
  }

  public addBookToFavorite(userId:number,bookId:number):Observable<any>{
    console.log(userId+" "+bookId)
    return this.http.get<any>("http://localhost:8090/addToFavorite/"+userId+"/"+bookId);
  }

  public getFavoriteBookList(userId:number):Observable<any>{
    return this.http.get<any>("http://localhost:8090/getFavoriteList/"+userId)
  }

  public searchBook(keyword:string):Observable<any>{
    return this.http.get<any>("http://localhost:8090/search/"+keyword)
  }

  public removeFromFav(userId:number,bookId:number):Observable<any>{
    return this.http.delete<any>("http://localhost:8090/deleteBookFromFav/"+userId+"/"+bookId);
  }
}
