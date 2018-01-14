import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { ReadingComponent } from './reading/reading.component';
import {VehicleService} from './vehicle.service';
import {ReadingService} from './reading.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './/app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';


@NgModule({
  declarations: [
    AppComponent,
    VehicleComponent,
    ReadingComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [VehicleService, ReadingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
