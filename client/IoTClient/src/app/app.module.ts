import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AgmCoreModule } from '@agm/core';
import {AccordionModule} from 'primeng/components/accordion/accordion';
import {MenuItem} from 'primeng/components/common/api';



import { AppComponent } from './app.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { ReadingComponent } from './reading/reading.component';
import { VehicleService } from './vehicle.service';
import { ReadingService } from './reading.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './/app-routing.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ReadingAllComponent } from './reading-all/reading-all.component';
import { GoogleMapsComponent } from './google-maps/google-maps.component';


@NgModule({
  declarations: [
    AppComponent,
    VehicleComponent,
    ReadingComponent,
    DashboardComponent,
    ReadingAllComponent,
    GoogleMapsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    AgmCoreModule.forRoot({
      apiKey:'AIzaSyBJhPcDmppsGGPmOjkTA62gM1JGhVTKLA4'
    }),
    AccordionModule
  ],
  providers: [VehicleService, ReadingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
