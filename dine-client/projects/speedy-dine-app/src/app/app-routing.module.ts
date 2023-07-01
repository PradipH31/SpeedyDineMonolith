import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeroComponent } from './components/home/hero/hero.component';
import { DiningDashboardComponent } from './components/home/dining-dashboard/dining-dashboard.component';

const routes: Routes = [
  { path: '', component: HeroComponent },
  { path: 'profile', component: DiningDashboardComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
