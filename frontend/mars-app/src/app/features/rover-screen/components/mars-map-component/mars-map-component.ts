import { Component, OnInit, output } from '@angular/core';
import { Map } from 'ol';
import { MarsMapService } from './services/mars-map.service';

@Component({
  selector: 'app-mars-map-component',
  standalone: true,
  templateUrl: './mars-map-component.html',
  styleUrl: './mars-map-component.scss',
})
export class MarsMapComponent implements OnInit {

  map!: Map;

  public readonly currentBbox = output<number[]>();
  public readonly shouldDisplayPoints = output<boolean>();

  initMapLogic() {
    this.map.on('moveend', () => {
      const view = this.map.getView();
      const mapSize = this.map.getSize();

      if (mapSize && view) {
        const bbox = view.calculateExtent(mapSize);
        const zoom = view.getZoom() || 0;

        this.shouldDisplayPoints.emit(zoom >= 12);
        this.currentBbox.emit(bbox);

      }
    });
  }

  constructor(
    private marsMapService: MarsMapService,
  ) {}

  ngOnInit(): void {
    this.initializeMap();
  }

  private initializeMap(): void {

    this.map = new Map({
      target: 'mars-map',
      layers: [
        this.marsMapService.getCuriosityCtxLayer(),
        this.marsMapService.getRoverPosIconLayer()
      ],
      view: this.marsMapService.createMarsView(),

    });

    this.initMapLogic();

  }
}
