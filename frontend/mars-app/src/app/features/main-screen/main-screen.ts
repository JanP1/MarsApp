import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Weather } from '../weather-screen/models/weather.model';
import { WeatherService } from './services/weather.service';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-main-screen',
  imports: [
    AsyncPipe,
  ],
  templateUrl: './main-screen.html',
  styleUrl: './main-screen.scss',
})
export class MainScreen {
  weather$!: Observable<Weather>;

  constructor(private weatherService: WeatherService) {}

  ngOnInit(): void {

    this.weather$ = this.weatherService.getLatestWeather();

  }


}
