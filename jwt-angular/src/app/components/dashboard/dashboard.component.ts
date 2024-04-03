import { Component, OnInit } from '@angular/core';
import { JwtService } from '../../service/jwt.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  providers:[JwtService],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit{
 helloMessage!:String;

  constructor(private service: JwtService){}
  ngOnInit(): void {
    this.hello();

     
  }
  hello(){
    this.service.hello().subscribe((Response)=>{
      console.log(Response);
      this.helloMessage=Response.helloMessage;
    }

    )
  }

}
