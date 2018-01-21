import { Injectable } from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {ReadingFormat} from './reading';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { of } from 'rxjs/observable/of';
import { catchError, map, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ReadingService {

  private Reading_URL = 'http://localhost:8080/readings';



  constructor(private http: HttpClient) { }

  /** GET Vehicles from the server */
  getAllReadings (): Observable<ReadingFormat[]> {
    return this.http.get<ReadingFormat[]>(this.Reading_URL);
  }

  getReadingByVin(vin: string): Observable<ReadingFormat[]> {
    console.log(vin);
    const ReadingByVin_URL = `${this.Reading_URL}/vin=${vin}`;
    return this.http.get<ReadingFormat[]>(ReadingByVin_URL);
  }

}
