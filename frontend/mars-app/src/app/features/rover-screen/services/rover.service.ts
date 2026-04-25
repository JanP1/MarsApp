import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "../../../../environments/environment.development";
import { Observable } from "rxjs";
import { Rover } from "../models/rover.model";

@Injectable({providedIn: 'root'})
export class RoverService {

  private readonly baseUrl = `${environment.apiUrl}/api/rover`;

  constructor(private http: HttpClient) { }

  getLatestRoverPosition() : Observable<Rover> {
    return this.http.get<Rover>(this.baseUrl + "/position/latest")
  }

  getPathPointsInBBox(bbox: number[]): Observable<Rover[]> {
    const params = new HttpParams()
      .set('xmin', bbox[0])
      .set('ymin', bbox[1])
      .set('xmax', bbox[2])
      .set('ymax', bbox[3]);

    return this.http.get<Rover[]>(`${this.baseUrl}/bbox`, { params });
  }
}
