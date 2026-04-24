import { Component, OnInit } from '@angular/core';
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

  constructor(private marsMapService: MarsMapService) {}

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
  }
}
