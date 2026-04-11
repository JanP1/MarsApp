package com.marsapp.marsapp.weather;

import java.util.List;

import org.springframework.stereotype.Service;
import com.marsapp.marsapp.exceptions.ResourceNotFoundException;


@Service
public class WeatherDataAvgService {
    private final WeatherDataAvgRepository weatherDataAvgRepository;

    public WeatherDataAvgService(WeatherDataAvgRepository weatherDataAvgRepository) {
        this.weatherDataAvgRepository = weatherDataAvgRepository;
    }

    public WeatherDataAvg getLatestWeatherMeasurement() {
        return weatherDataAvgRepository
            .findFirstByOrderBySolDesc()
            .orElseThrow(() -> new ResourceNotFoundException("Data for sol not found"));
    }

    public List<WeatherDataAvg> getLastWeekWeatherMeasurement() {
        List<WeatherDataAvg> measurements = weatherDataAvgRepository.findFirst7ByOrderBySolDesc();
        
        if (measurements.isEmpty()) {
            throw new ResourceNotFoundException("Data for last week not found");
        }
        
        return measurements;
    }

    public WeatherDataAvg getBySolValue(String searchedSol) {
        return weatherDataAvgRepository
            .findBySol(searchedSol)
            .orElseThrow(() -> new ResourceNotFoundException("Data for given sol not found"));
    }
    
}
