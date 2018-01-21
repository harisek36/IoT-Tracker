import { Component, OnInit } from '@angular/core';
import { VehicleService} from '../vehicle.service';
import {VehicleFormat} from '../vehicle';

@Component({
  selector: 'app-vehicle',
  templateUrl: './vehicle.component.html',
  styleUrls: ['./vehicle.component.css']
})
export class VehicleComponent implements OnInit {
  vehicles: VehicleFormat[];
  constructor(private vehicleService: VehicleService) { }

  ngOnInit() {
    this.getVehicles();
  }

  getVehicles(): void {
    this.vehicleService.getHeroes()
      .subscribe(vehicles => this.vehicles = vehicles);
  }

}
