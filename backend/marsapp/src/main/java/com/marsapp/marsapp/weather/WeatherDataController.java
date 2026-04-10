package com.marsapp.marsapp.weather;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/weather")
public class WeatherDataController {

    private final WeatherDataAvgService weatherDataAvgService;

    public WeatherDataController(WeatherDataAvgService weatherDataAvgService) {
        this.weatherDataAvgService = weatherDataAvgService;
    }

    @GetMapping("latest")
    public WeatherDataAvg getLatest() {
        return weatherDataAvgService.getLatestWeatherMeasurement();
    }

}
