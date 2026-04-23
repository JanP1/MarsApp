import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Rover } from './models/rover.model';
import { RoverService } from './services/rover.service';
import { MarsMapComponent } from './components/mars-map-component/mars-map-component';

@Component({
  selector: 'app-rover-screen',
  imports: [
    MarsMapComponent
  ],
  templateUrl: './rover-screen.html',
  styleUrl: './rover-screen.scss',
})
export class RoverScreen {
  roverLastPosition$!: Observable<Rover>;

  constructor(private roverService: RoverService) {}

  ngOnInit(): void {
    this.roverLastPosition$ = this.roverService.getLatestRoverPosition();
  }

}
