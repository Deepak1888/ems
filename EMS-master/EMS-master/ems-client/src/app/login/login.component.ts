import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: Object;
  constructor(private http: HttpClient) { }

  ngOnInit() { console.log(`login OnInit`); 
this.getUser()}
   getUser() {
		this.http.get('/server/user').subscribe(user => {
			this.user = user;
			console.log('Logged User : ', this.user);
		})
  };
  
  login(){
    // this.http.get('/server/').subscribe(user => {
    //   this.user = user;
    //   console.log('Logged User : ', this.user);
    // })
    window.location.href='http://localhost:8080/'
  }

}
