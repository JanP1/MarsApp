import { Injectable } from "@angular/core";
import { environment } from "../../../../environments/environment.development";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Weather } from "../../weather-screen/models/weather.model";

@Injectable({providedIn: 'root'})
export class WeatherService {
  private readonly baseUrl = `${environment.apiUrl}/api/weather`

  constructor(private http: HttpClient) {}

  getLatestWeather(): Observable<Weather> {
    return this.http.get<Weather>(this.baseUrl + "/latest");
  }

}
