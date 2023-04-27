import { Component, OnInit } from '@angular/core';
import { StorageServiceService } from 'src/app/storage-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit{
  data?: any;
  flag:boolean = false;

  constructor(private storageService: StorageServiceService){}

  ngOnInit(): void {
    this.getUserType();
    this.showUserNav();
  }

  getUserType(){
    console.log(this.storageService.getUser());
    this.data = this.storageService.getUser();
    console.log(this.data.usertype);
  }

  showUserNav(){
    if(this.data.usertype === "user"){
      this.flag = true;
      console.log("im here");
    }
  }

}
