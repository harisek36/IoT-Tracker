import {Component, Input, OnInit} from '@angular/core';
import {ReadingService } from '../reading.service';
import {ReadingFormat } from '../reading';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-reading',
  templateUrl: './reading.component.html',
  styleUrls: ['./reading.component.css']
})
export class ReadingComponent implements OnInit {

  readingsByVin: ReadingFormat[];
  readings: ReadingFormat[];
  constructor(private readingService: ReadingService,
              private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.getReadingsByVin();
  }

  getReadingsByVin(): void {
    const readingvin = this.route.snapshot.paramMap.get('vin');
    this.readingService.getHeroesByVin(readingvin.toString())
      .subscribe(result => this.readingsByVin = result);

  }

  getReadings(): void {
    this.readingService.getHeroes()
      .subscribe(reading => this.readings = reading);
  }
}
