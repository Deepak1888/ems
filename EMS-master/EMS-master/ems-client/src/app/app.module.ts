import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

//added by mayuris
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { NavComponent } from './nav/nav.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { EmployeeComponent } from './employee/employee.component';
import {MatTabsModule,MatButtonModule,MatToolbarModule,MatCardModule, MatDialogModule, MatInputModule, MatTableModule,
 MatMenuModule,MatIconModule, MatProgressSpinnerModule} from '@angular/material'
 import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LeaveComponent } from './leave/leave.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavComponent,
    AdminComponent,
    HomeComponent,
    EmployeeComponent,
    HeaderComponent,
    FooterComponent,
    LeaveComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatTabsModule,
    MatButtonModule,
    MatToolbarModule,
    MatCardModule, 
    MatInputModule, 
    MatDialogModule, 
    MatTableModule, 
    MatMenuModule,
    MatIconModule,
    MatProgressSpinnerModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
