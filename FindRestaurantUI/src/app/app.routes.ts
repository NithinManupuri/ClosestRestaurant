import { Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { AddRestuarantComponent } from './add-restuarant/add-restuarant.component';

export const routes: Routes = [
    {path: 'index',component: IndexComponent},
    {path: '',redirectTo:"/index",pathMatch: 'full'},
    {path: "addRestaurant" ,component: AddRestuarantComponent}
];
