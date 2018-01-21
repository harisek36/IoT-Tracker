import { Component, OnInit } from '@angular/core';
import { ReadingFormat } from '../reading';
import { ReadingService } from '../reading.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reading-all',
  templateUrl: './reading-all.component.html',
  styleUrls: ['./reading-all.component.css']
})

export class ReadingAllComponent implements OnInit {

  readings: ReadingFormat[];

  constructor(private readingService: ReadingService) { }

  ngOnInit() {
    this.getReadings();
  }
  getReadings(): void {
    this.readingService.getAllReadings()
      .subscribe(reading => this.readings = reading);
  }

}
