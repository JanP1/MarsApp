import { Component, signal } from '@angular/core';
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

  // Based on
  //
  //      public readonly currentBbox = output<number[]>();
  //
  // from MarsMapComponent
  currentMapExtent: number[] = [];

  // Sent to the @Input of MarsMapComponent
  pathPointsInView = signal<Rover[]>([]);

  private canFetchPoints = false;

  constructor(private roverService: RoverService) {}

  ngOnInit(): void {
    this.roverLastPosition$ = this.roverService.getLatestRoverPosition();
  }

  // Triggered when shouldDisplayPoints
  // is being changed in MarsMapComponent
  togglePathVisibility(shouldDisplay: boolean) {
    this.canFetchPoints = shouldDisplay;
    if (!shouldDisplay) {
      this.pathPointsInView.set([]);
    }
  }

  // Triggered when currentBbox changes in MarsMapComponent
  handleMapChange(bbox: number[]): void {
    this.currentMapExtent = bbox.map(num => Math.round(num * 10000) / 10000);

    // Only fetch if the zoom is 12 or greater
    if (this.canFetchPoints) {
      this.roverService.getPathPointsInBBox(bbox).subscribe(points => {
        this.pathPointsInView.set(points);
        console.log(points);
      });
    }
  }

}
