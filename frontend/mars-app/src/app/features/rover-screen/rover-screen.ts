import { Component, signal, ChangeDetectionStrategy } from '@angular/core';
import { Observable } from 'rxjs';
import { Rover } from './models/rover.model';
import { RoverService } from './services/rover.service';
import { MarsMapComponent } from './components/mars-map-component/mars-map-component';

@Component({
  selector: 'app-rover-screen',
  imports: [MarsMapComponent],
  templateUrl: './rover-screen.html',
  changeDetection: ChangeDetectionStrategy.Eager,
  styleUrl: './rover-screen.scss',
})
export class RoverScreen {
  constructor(private roverService: RoverService) {}

  roverLastPositionValue = signal<Rover>({ id: '0', sol: 0, lattitude: 0, longitude: 0 });

  // Sent to the @Input of MarsMapComponent
  pathPointsInView = signal<Rover[]>([]);

  private canFetchPoints = false;

  ngOnInit(): void {
    this.roverService.getLatestRoverPosition().subscribe((rover) => {
      this.roverLastPositionValue.set(rover);
      console.log(
        'Rover last position: ' + rover.lattitude.toString() + ' ' + rover.longitude.toString(),
      );
    });
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
    // Only fetch if the zoom is 12 or greater
    if (this.canFetchPoints) {
      this.roverService.getPathPointsInBBox(bbox).subscribe((points) => {
        this.pathPointsInView.set(points);
        console.log(points);
      });
    }
  }
}
