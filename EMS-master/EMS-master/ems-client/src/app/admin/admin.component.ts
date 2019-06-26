import { Component, OnInit } from '@angular/core';
// import { HttpClient } from '@angular/common/http';
import { ApiService } from '../api.service';
export class User{
  constructor(
    public userId:Number,
    public username:string,
    public email:string,
    public mobile:string,
  ) {}
}
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit {
  users: Array<any>;
  employees:string[];
  displayedColumns: string[] = ['name', 'email', 'mobile', 'roles','edit','remove'];

  constructor(
    public ApiService: ApiService
    // ,    private httpClient: HttpClient
    ) { }

  ngOnInit() { 
  console.log(`AdminComponent OnInit`);
  //  this.getAdmin();
  this.getUsers()
  // this.getUsers2()
  
  }
  //  getAdmin() {
	// 	this.http.get('/server/admin').subscribe((data:any) => {
  //     // this.user = user;
	// 		console.log('Logged User in app: ', JSON.stringify(data));
	// 	})
  // };

  getUsers(){
    this.ApiService.getUsers().subscribe(
      res => {
        this.users = res;
        console.log('getUsers Response: ',JSON.stringify(res))
      },
      err =>{
        console.log('getUsers Error: ',err)
      },
      () => {
        // No errors, route to new page
      }
      );
  }

  deleteUser(){
    alert('Deleting user')
    this.ApiService.deleteUser().subscribe(
      res=>console.log('Deleted!')
    )
  }
  updateUser(){
    alert('Update user')
  }
  // getUsers2(){
  //   this.httpClient.get<User[]>('/server/users').subscribe(
  //     res => console.log('getUsers2 Response: ', JSON.stringify(res)),
  //     err=> console.log('getUsers2 Error: ',err)
  //    );
  // }
}
