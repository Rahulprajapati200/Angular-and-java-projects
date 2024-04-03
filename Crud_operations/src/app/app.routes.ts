import { Routes } from '@angular/router';
import { PostCustomerComponent } from './components/post-customer/post-customer.component';
import { GetAllCustomersComponent } from './components/get-all-customers/get-all-customers.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';

export const routes: Routes = [
    {
        path:"",
        redirectTo:"getAllCustomers",
        pathMatch: "full"
    },
    {
        path:"customer",
        component:PostCustomerComponent
    },
    {
        path:"getAllCustomers",
        component:GetAllCustomersComponent
    },
    {
        path:"customer/:id",
        component:UpdateCustomerComponent
    }
];
