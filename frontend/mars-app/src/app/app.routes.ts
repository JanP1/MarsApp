import { Routes } from '@angular/router';
import { MainScreen } from './features/main-screen/main-screen';
import { WeatherScreen } from './features/weather-screen/weather-screen';
import { RoverScreen } from './features/rover-screen/rover-screen';
import { NewsScreen } from './features/news-screen/news-screen';

export const routes: Routes = [
  {
    path: '',
    component: MainScreen,
  },
  {
    path: 'weather',
    component: WeatherScreen,
  },
  {
    path: 'rover',
    component: RoverScreen,
  },
  {
    path: 'news',
    component: NewsScreen,
  },
];
