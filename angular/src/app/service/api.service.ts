import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {User} from "../model/user.model";
import {Observable} from "rxjs/index";


@Injectable()
export class ApiService {

  constructor(private http: HttpClient) { }
  baseUrl: string = 'http://localhost:9010/pessoas-service/';

  findUsers(texto: string) :Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl+ 'texto?texto' +texto);
  }

  getUsers() : Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl+'agenda');
  }

  getUserById(id: number): Observable<any> {
    return this.http.get<any>(this.baseUrl + 'id?id=' +id);
  }

  createUser(user: User): Observable<any[]> {
    return this.http.post<any>(this.baseUrl, user);
  }

  updateUser(user: User): Observable<any[]> {
    return this.http.put<any>(this.baseUrl + '?id=' + user.id, user);
  }

  deleteUser(id: number): Observable<any[]> {
    return this.http.delete<any>(this.baseUrl + '?id=' + id);
  }
}
