package com.marsapp.marsapp.rover;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marsapp.marsapp.exceptions.ResourceNotFoundException;

@Service
public class RoverDataService {

    private final RoverDataRepository roverDataRepository;

    public RoverDataService(RoverDataRepository roverDataRepository) {
        this.roverDataRepository = roverDataRepository;
    }

    public List<RoverData> getInBBox(double xmin, double ymin, double xmax, double ymax) {
        return roverDataRepository.findInBBox(xmin, ymin, xmax, ymax);
    }   

    public RoverData getLatestRoverPosition() {
        return roverDataRepository
            .findFirstByOrderBySolDesc()
            .orElseThrow(() -> new ResourceNotFoundException("Rover position for sol not found"));
    }

    public List<RoverData> getRoverPositionInGivenTimePeriod(int startSol, int endSol) {
        List<RoverData> roverPositions = roverDataRepository.findBySolBetween(startSol, endSol);
        
        if (roverPositions.isEmpty()) {
            throw new ResourceNotFoundException("Rover position for sol not found");
        }
        
        return roverPositions;
    }

    public List<RoverData> getRoverPositionFormDateUntillLatest(int startSol) {

        List<RoverData> roverPositions = roverDataRepository.findBySolGreaterThanEqual(startSol);
        
        if (roverPositions.isEmpty()) {
            throw new ResourceNotFoundException("Rover position for sol not found");
        }
        
        return roverPositions;
    }

    
}
