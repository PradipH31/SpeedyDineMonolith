import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  constructor(private router: Router) {
    this.router.navigate(['/']);
  }
  
  title = 'speedy-dine-app';
  imageUrl = "/assets/images/logo.png"
}
