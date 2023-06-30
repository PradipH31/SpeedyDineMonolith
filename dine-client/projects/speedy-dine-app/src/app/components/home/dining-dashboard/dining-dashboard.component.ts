import { Component, inject } from '@angular/core';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-dining-dashboard',
  templateUrl: './dining-dashboard.component.html',
  styleUrls: ['./dining-dashboard.component.scss']
})
export class DiningDashboardComponent {
  private breakpointObserver = inject(BreakpointObserver);

  /** Based on the screen size, switch from standard to one column per row */
  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title: 'Items', cols: 1, rows: 1 },
          { title: 'Restaurants', cols: 1, rows: 1 },
          { title: 'Orders', cols: 2, rows: 1 }
        ];
      }

      return [
        { title: 'Items', cols: 1, rows: 1 },
        { title: 'Restaurants', cols: 1, rows: 1 },
        { title: 'Orders', cols: 2, rows: 1 }
      ];
    })
  );
}
