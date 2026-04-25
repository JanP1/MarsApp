package com.marsapp.marsapp.rover;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rover")
public class RoverDataController {
    private final RoverDataService roverDataService;

    public RoverDataController(RoverDataService roverDataService) {
        this.roverDataService = roverDataService;
    }

    @GetMapping("position/latest")
    public RoverData getLatestPosition() {
        return roverDataService.getLatestRoverPosition();
    }

    @GetMapping("position")
    public List<RoverData> getRoverPositions(
            @RequestParam(name = "from") int from,
            @RequestParam(name = "to", required = false) Integer to) {
        
        if (to != null) {
            return roverDataService.getRoverPositionInGivenTimePeriod(from, to);
        }
        
        return roverDataService.getRoverPositionFormDateUntillLatest(from);
    }

    // Get all points that are inside the provided coordinates
    @GetMapping("bbox")
    public List<RoverData> getInBBox(
            @RequestParam double xmin,
            @RequestParam double ymin,
            @RequestParam double xmax,
            @RequestParam double ymax
    ) {
        return roverDataService.getInBBox(xmin, ymin, xmax, ymax);
    }
}
