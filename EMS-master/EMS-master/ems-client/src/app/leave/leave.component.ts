import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-leave',
  templateUrl: './leave.component.html',
  styleUrls: ['./leave.component.css']
})
export class LeaveComponent implements OnInit {
  leaves: Array<any>;
  displayedColumns: string[] = ['firstName', 'lastName', 'emailAddress'];
  constructor(private ApiService:ApiService) { }

  ngOnInit() {
    this.getLeavesData()
  }
  getLeavesData(){
    this.ApiService.getLeavesData().subscribe(
      res => {
        this.leaves = res.leaveRecords;
        console.log('getLeavesData Response: ',JSON.stringify(res))
      },
      err =>{
        console.log('getLeavesData Error: ',err)
      },
      () => {
        // No errors, route to new page
      }
      );
  }

}
