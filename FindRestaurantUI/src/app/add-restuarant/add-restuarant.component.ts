import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Restaurant } from '../restaurant';
import { RouterLink } from '@angular/router';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-add-restuarant',
  standalone: true,
  imports: [FormsModule,RouterLink],
  templateUrl: './add-restuarant.component.html',
  styleUrl: './add-restuarant.component.css'
})
export class AddRestuarantComponent {
 status: String=""
 restaurant: Restaurant =new Restaurant();
 constructor(private service: ServiceService){}

  insert(){

    this.service.addService(this.restaurant).subscribe(res =>{
      console.log(this.status)
      this.status=res;
      this.clearStatusAfterDelay(3000)
    })
  }
      clearStatusAfterDelay(delay: number) {
        setTimeout(() => {
          this.status = ''; 
        }, delay);
      }

}
