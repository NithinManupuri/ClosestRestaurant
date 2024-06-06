import { Component } from '@angular/core';
import { Restaurant } from '../restaurant';
import { ServiceService } from '../service.service';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ResponseRestaurant } from '../response-restaurant';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [RouterLink,FormsModule,CommonModule],
  templateUrl: './index.component.html',
  styleUrl: './index.component.css'
})
export class IndexComponent {
     area: string= ''
     view: boolean=false
   list: ResponseRestaurant[]=[];
   constructor(private service: ServiceService){}

    get(){
      console.log(this.area)
      this.service.getRestaurant(this.area).subscribe(res =>{
        console.log(res)
        this.view =true
        this.list=res;
      });
    }
}
