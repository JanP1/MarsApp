package com.marsapp.marsapp.service;

import org.springframework.stereotype.Service;

import com.marsapp.marsapp.model.WeatherDataAvg;
import com.marsapp.marsapp.repository.WeatherDataAvgRepository;

@Service
public class WeatherDataAvgService {
    private final WeatherDataAvgRepository weatherDataAvgRepository;

    public WeatherDataAvgService(WeatherDataAvgRepository weatherDataAvgRepository) {
        this.weatherDataAvgRepository = weatherDataAvgRepository;
    }

    public WeatherDataAvg getLatestWeatherMeasurement() {
        return weatherDataAvgRepository.findFirstByOrderBySolDesc();
    }
    
}
