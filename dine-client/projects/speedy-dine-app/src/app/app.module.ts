import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import { DiningDashboardComponent } from './components/home/dining-dashboard/dining-dashboard.component';
import { OrdersComponent } from './components/home/orders/orders.component';
import { ItemsComponent } from './components/home/items/items.component';
import { RestaurantsComponent } from './components/home/restaurants/restaurants.component';
import { HeroComponent } from './components/home/hero/hero.component';

@NgModule({
  declarations: [
    AppComponent,
    DiningDashboardComponent,
    OrdersComponent,
    ItemsComponent,
    RestaurantsComponent,
    HeroComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
