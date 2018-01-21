import {Component, Input, OnInit} from '@angular/core';
import {ReadingService } from '../reading.service';
import {ReadingFormat } from '../reading';
import { ActivatedRoute } from '@angular/router';
import { VehicleFormat} from '../vehicle';
import {VehicleService} from '../vehicle.service';
import {AccordionModule} from 'primeng/components/accordion/accordion';
import {MenuItem} from 'primeng/components/common/api';


@Component({
  selector: 'app-reading',
  templateUrl: './reading.component.html',
  styleUrls: ['./reading.component.css']
})

export class ReadingComponent implements OnInit {

  readingsByVin: ReadingFormat[];
  vehicleWithVin: VehicleFormat;
  //
  // data: any;
  // msgs: any[];

  constructor(private readingService: ReadingService,
              private vehicleService: VehicleService,
              private route: ActivatedRoute ) { }

  ngOnInit() {
    this.getReadingsByVin();
    this.getVehicleByVin();
  }

  // graph(): void {
  //   this.data = {
  //     labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
  //     datasets: [
  //       {
  //         label: 'First Dataset',
  //         data: [65, 59, 80, 81, 56, 55, 40],
  //         fill: false,
  //         borderColor: '#4bc0c0'
  //       },
  //       {
  //         label: 'Second Dataset',
  //         data: [28, 48, 40, 19, 86, 27, 90],
  //         fill: false,
  //         borderColor: '#565656'
  //       }
  //     ]
  //   };
  // }

  // selectData(event) {
  //   this.msgs = [];
  //   this.msgs.push({severity: 'info', summary: 'Data Selected','detail': this.data.datasets[event.element._datasetIndex].data[event.element._index]});
  // }

  getReadingsByVin(): void {
    const readingVin = this.route.snapshot.paramMap.get('vin');
    this.readingService.getReadingByVin(readingVin.toString())
      .subscribe(result => this.readingsByVin = result);
  }
  getVehicleByVin(): void {
    const vehicleVin = this.route.snapshot.paramMap.get('vin');
    this.vehicleService.getVehicleByVin(vehicleVin.toString())
      .subscribe(result => this.vehicleWithVin = result);
  }
}
