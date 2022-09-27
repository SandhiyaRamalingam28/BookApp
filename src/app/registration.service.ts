import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Users } from './users';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private _http : HttpClient) { }

  public loginUsersFromRemote(users :Users):Observable<any>{
    return this._http.post<any>("http://localhost:8090/login",users)
  }

  public registerUsersFromRemote(users :Users):Observable<any>{
    return this._http.post<any>("http://localhost:8090/registerusers",users)
  }

  public homePageFromRemote(users :Users):Observable<any>{
    return this._http.post<any>("http://localhost:8090/registerusers",users)
  }

  


}
