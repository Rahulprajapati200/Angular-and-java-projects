import { Component ,OnInit} from '@angular/core';
import { CustomerService } from '../../service/customer.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-get-all-customers',
  standalone: true,
  imports: [CommonModule,FormsModule,HttpClientModule,ReactiveFormsModule,RouterModule],
  providers:[CustomerService],
  templateUrl: './get-all-customers.component.html',
  styleUrl: './get-all-customers.component.css'
})
export class GetAllCustomersComponent implements OnInit {

  constructor(private customerservice:CustomerService,
    private router:Router){}

  customers:any[] =[];

  ngOnInit(): void {
    this.getAllCustomers();
  }

  getAllCustomers(){
    this.customerservice.getAllCustomers().subscribe((res)=>{
      console.log(res);
      this.customers=res;
    });
  }

  deleteCustomer(id:number): void{
    console.log(id);
    this.customerservice.deleteCustomer(id).subscribe((res)=>{
      console.log(res);
      this.getAllCustomers();

    })
  }




}
