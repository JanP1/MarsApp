package com.marsapp.marsapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marsapp.marsapp.model.WeatherDataAvg;
import com.marsapp.marsapp.service.WeatherDataAvgService;

@RestController
@RequestMapping("api/weather")
public class WeatherDataController {

    private final WeatherDataAvgService weatherDataAvgService;

    public WeatherDataController(WeatherDataAvgService weatherDataAvgService) {
        this.weatherDataAvgService = weatherDataAvgService;
    }

    public WeatherDataAvg getLatest() {
        return weatherDataAvgService.getLatestWeatherMeasurement();
    }

}
