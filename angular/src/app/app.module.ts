import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListUserComponent } from './user/list-user/list-user.component';
import { AddUserComponent } from './user/add-user/add-user.component';
import { EditUserComponent } from './user/edit-user/edit-user.component';
import {routing} from "./app.routing";
import {ReactiveFormsModule, FormsModule} from "@angular/forms";
import {ApiService} from "./service/api.service";
import {HttpClientModule} from "@angular/common/http";
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { MatIconModule } from '@angular/material';


@NgModule({
  declarations: [
    AppComponent,
    ListUserComponent,
    AddUserComponent,
    EditUserComponent
  ],
  imports: [
    BrowserModule,
    routing,
    ReactiveFormsModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    FormsModule,
    MatIconModule
    ],
  providers: [ApiService],
  bootstrap: [AppComponent]
})
export class AppModule { }
