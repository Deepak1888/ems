import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ApiService } from '../api.service';
import { AdminComponent } from '../admin/admin.component';
import { AppComponent } from '../app.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
@NgModule({
  imports: [ BrowserModule ],
  declarations: [ AdminComponent ],
  bootstrap: [ AppComponent ]
})

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  activeLinkIndex = -1; 
  navLinks: any[];
  user: any;
  roles:Array<string>[] = [];
  constructor(private router: Router,public dataService: ApiService,private HttpClient: HttpClient) { 
    this.navLinks = [
      {
          label: 'Home',
          link: './',
          index: 0
      }, {
          label: 'Admin',
          link: './admin',
          index: 1
      }, {
          label: 'Employee',
          link: './employee',
          index: 2
      }, 
  ];
  }

  ngOnInit() {
  console.log(`Home Component OnInit`);
  this.getUser();
  //  this.getRoles();
  this.router.events.subscribe((res) => {
  this.activeLinkIndex = this.navLinks.indexOf(this.navLinks.find(tab => tab.link === '.' + this.router.url));
  })
}
getUser() {
  this.HttpClient.get('/server/user').subscribe((user:any) => {
    this.user = user;
   for (let index in this.user.authorities) {
      this.roles.push(this.user.authorities[index].authority);
   }
    // console.log('Logged User in app: ', JSON.stringify(this.user),this.roles);
  })
};



}
