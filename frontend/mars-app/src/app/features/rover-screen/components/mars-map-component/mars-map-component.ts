import { Component, OnInit } from '@angular/core';
import { Map, View } from 'ol';
import TileLayer from 'ol/layer/Tile';
import { get as getProjection } from 'ol/proj';
import { WMTS } from 'ol/source';
import WMTSTileGrid from 'ol/tilegrid/WMTS';
import proj4 from 'proj4';
import {register} from 'ol/proj/proj4';

@Component({
  selector: 'app-mars-map-component',
  imports: [],
  templateUrl: './mars-map-component.html',
  styleUrl: './mars-map-component.scss',
})
export class MarsMapComponent implements OnInit {
  map!: Map;

  ngOnInit(): void {
    proj4.defs("urn:ogc:def:crs:EPSG::104905", "+proj=longlat +a=3396190 +b=3376200 +no_defs");
    register(proj4);
    const projection = getProjection('urn:ogc:def:crs:EPSG::104905')!;

    const resolutions = [
      0.703125,
      0.3515625,
      0.17578125,
      0.087890625,
      0.0439453125,
      0.02197265625,
      0.010986328125,
      0.0054931640625,
      0.00274658203125,
      0.001373291015625,
      0.0006866455078125
    ];

    const matrixIds = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10'];

    const curiosityExtent: [number, number, number, number] = [136.2768, -7.2137, 139.3864, -3.5804];

    this.map = new Map({
      target: 'mars-map',
      layers: [
        new TileLayer({
          source: new WMTS({
            url: "/nasa-trek/tiles/Mars/EQ/curiosity_ctx_mosaic/1.0.0//{Style}/{TileMatrixSet}/{TileMatrix}/{TileRow}/{TileCol}.png",

            layer: "curiosity_ctx_mosaic",
            requestEncoding: "REST",
            matrixSet: "default028mm",
            format: "image/png",
            style: "default",

            crossOrigin: 'anonymous',

            projection: projection,
            tileGrid: new WMTSTileGrid({
              origin: [-180, 90],
              resolutions: resolutions,
              matrixIds: matrixIds
            }),
            wrapX: true,
          }),
        }),
      ],
      view: new View({
        projection: projection,
        center: [137.8, -4.5],
        resolutions: resolutions,
        zoom: 8,

        extent: curiosityExtent,

        minZoom: 4,
        maxZoom: 10,

        constrainOnlyCenter: false,
        smoothExtentConstraint: true
      }),
    });
  }
}
