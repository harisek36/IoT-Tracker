import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-google-maps',
  templateUrl: './google-maps.component.html',
  styleUrls: ['./google-maps.component.css']
})
export class GoogleMapsComponent implements OnInit {

  lat ;
  lon ;

  constructor(private route: ActivatedRoute) { }

  ngOnInit() {
    this.getLatLog();
  }
  getLatLog(): void {
    const _lat = this.route.snapshot.paramMap.get('lat');
    const _lon = this.route.snapshot.paramMap.get('lon');
    this.lat = _lat;
    this.lon  = _lon;
  }

}
