import { Injectable } from "@angular/core";
import { Feature, View } from 'ol';
import TileLayer from 'ol/layer/Tile';
import { get as getProjection, Projection } from 'ol/proj';
import { WMTS } from 'ol/source';
import WMTSTileGrid from 'ol/tilegrid/WMTS';
import proj4 from 'proj4';
import { register } from 'ol/proj/proj4';
import VectorLayer from "ol/layer/Vector";
import { Point } from "ol/geom";
import Style from "ol/style/Style";
import Icon from "ol/style/Icon";
import VectorSource from "ol/source/Vector";
import { Rover } from "../../../models/rover.model";

@Injectable({ providedIn: 'root' })
export class MarsMapService {

  private readonly MARS_CRS = "urn:ogc:def:crs:EPSG::104905";

  private readonly BASE_RESOLUTIONS = [
    0.703125, 0.3515625, 0.17578125, 0.087890625, 0.0439453125,
    0.02197265625, 0.010986328125, 0.0054931640625, 0.00274658203125,
    0.001373291015625, 0.0006866455078125
  ];

  constructor() {
    proj4.defs(this.MARS_CRS, "+proj=longlat +a=3396190 +b=3376200 +no_defs");
    register(proj4);
  }

  getMarsProjection(): Projection {
    return getProjection(this.MARS_CRS)!;
  }

  getCuriosityCtxLayer(): TileLayer {
    const matrixIds = this.BASE_RESOLUTIONS.map((_, i) => i.toString());

    return new TileLayer({
      className: 'mars-map-tiles',
      maxZoom: 100,
      source: new WMTS({
        url: "/nasa-trek/tiles/Mars/EQ/curiosity_ctx_mosaic/1.0.0//default/default028mm/{TileMatrix}/{TileRow}/{TileCol}.png",
        layer: "curiosity_ctx_mosaic",
        requestEncoding: "REST",
        matrixSet: "default028mm",
        format: "image/png",
        style: "default",
        crossOrigin: 'anonymous',

        projection: this.getMarsProjection(),

        tileGrid: new WMTSTileGrid({
          origin: [-180, 90],
          resolutions: this.BASE_RESOLUTIONS,
          matrixIds: matrixIds
        }),

        wrapX: false,
      }),
    });
  }

  createMarsView(): View {
    const curiosityExtent: [number, number, number, number] = [136.2768, -7.2137, 139.3864, -3.5804];

    const viewResolutions = [...this.BASE_RESOLUTIONS];
    for (let i = 0; i < 4; i++) {
      viewResolutions.push(viewResolutions[viewResolutions.length - 1] / 2);
    }

    return new View({
      projection: this.getMarsProjection(),
      center: [137.8, -4.5],
      resolutions: viewResolutions,
      zoom: 10,
      extent: curiosityExtent,
      constrainOnlyCenter: false,
      smoothExtentConstraint: true,
      maxZoom: viewResolutions.length - 1
    });
  }


  // ======= ROVER POSITION ICON =======================

  getRoverPosIconLayer(rover: Rover | undefined): VectorLayer {
    // TODO - remove later. Temporary fix
    if (!rover) {
      rover = {id: '0', sol: 0, longitude: 0, lattitude: 0};

    }
    const iconFeature = new Feature({
      geometry: new Point([
        rover.longitude,
        rover.lattitude
      ]),
      name: 'Null Island',
      population: 4000,
      rainfall: 500,
    });

    const iconStyle = new Style({
      image: new Icon({
        anchor: [0.5, 1],
        scale: 0.1,
        anchorXUnits: 'fraction',
        anchorYUnits: 'fraction',
        src: '/assets/rover_pointer.png',
      }),
    });

    iconFeature.setStyle(iconStyle);

    const vectorSource = new VectorSource({
      features: [iconFeature],
    });

    return new VectorLayer({
      source: vectorSource,
    });
  }

  // ========== ROVER POINTS =============================

  private pathSource = new VectorSource();

  getPathLayer(): VectorLayer {
    return new VectorLayer({
      source: this.pathSource,
      style: {
        'circle-stroke-color': 'hsl(0 100% 100% / 0.9)',
        'circle-stroke-width': 0.75,
        'circle-radius': 5,
        'circle-fill-color': 'hsl(210 100% 40% / 0.9)',
      },
    });
  }

  updatePathData(points: Rover[]): void {
    this.pathSource.clear();
    const features = points.map(p => new Feature({
      geometry: new Point([p.longitude, p.lattitude]),
      ...p
    }));
    this.pathSource.addFeatures(features);
  }

  getRoverPointsLayer(points: Rover[]): VectorLayer {
    const features = points.map(p => new Feature({
      geometry: new Point([p.longitude, p.lattitude]),
      ...p
    }));

    return new VectorLayer({
      source: new VectorSource({
        features: features
      }),
      style: {
        'circle-stroke-color': 'hsl(0 100% 100% / 0.9)',
        'circle-stroke-width': 0.75,
        'circle-radius': 5,
        'circle-fill-color': 'hsl(210 100% 40% / 0.9)',
      },
    });
  }

}
