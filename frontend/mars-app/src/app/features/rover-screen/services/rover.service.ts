import { HttpClient } from "@angular/common/http";
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

}
