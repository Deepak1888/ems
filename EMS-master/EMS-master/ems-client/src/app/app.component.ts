import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'EMS';
  temp: Array<string>=['a','b'];
  // temp2: ['a','b'];
  tempflag:boolean = false;

  constructor(private http: HttpClient){};
  ngOnInit() {

  }




}
