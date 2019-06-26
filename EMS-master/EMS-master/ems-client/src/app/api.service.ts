import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
export class User{
  constructor(
    public userId:Number,
    public username:string,
    public email:string,
    public mobile:string,
  ) {}
}


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  apiURL: string = 'http://localhost:8080';
  constructor(public httpClient: HttpClient) { }
  // Login(){
  //   alert(1)
  //   this.httpClient.get('/server').subscribe((res)=>{
  //     alert(2)
  //       console.log(res);
  //   });
  // }

  public getUsers():Observable<any>{
    return this.httpClient.get('/server/users');
  }
  // getUsers2()
  // {
  //   console.log("getUsers2: ",this.httpClient.get<User[]>('/server/users'));
  //   return this.httpClient.get<User[]>('/server/users');
  // }
  public deleteUser():Observable<any>{
    return this.httpClient.delete('/server/users/'+1);
  }
  public getLeavesData():Observable<any>{
    return this.httpClient.get('/server/leaves/feign');
  }

}
