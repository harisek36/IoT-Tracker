import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

import { VehicleFormat } from './vehicle';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class VehicleService {

  private Vehicle_URL = 'http://localhost:8080/vehicles';

  constructor(private http: HttpClient) { }

  /** GET Vehicles from the server */
  getHeroes (): Observable<VehicleFormat[]> {
    return this.http.get<VehicleFormat[]>(this.Vehicle_URL)
      .pipe(
        tap(heroes => this.log(`fetched heroes`)),
        catchError(this.handleError('getHeroes', []))
      );
  }

}
