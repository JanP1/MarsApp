import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Rover } from './models/rover.model';
import { RoverService } from './services/rover.service';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-rover-screen',
  imports: [AsyncPipe],
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
