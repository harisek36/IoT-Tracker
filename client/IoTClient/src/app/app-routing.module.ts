import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { GoogleMapsComponent } from './google-maps/google-maps.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { ReadingComponent } from './reading/reading.component';
import { ReadingAllComponent } from './reading-all/reading-all.component';

const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'readings/:vin', component: ReadingComponent },
  { path: 'readingall', component: ReadingAllComponent },
  { path: 'vehicles', component: VehicleComponent },
  { path: 'vehicles', component: VehicleComponent },
  { path: 'maps/:lat/:lon', component: GoogleMapsComponent}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
  declarations: []
})

export class AppRoutingModule { }
