package com.marsapp.marsapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marsapp.marsapp.model.WeatherDataAvg;
import com.marsapp.marsapp.repository.WeatherDataAvgRepository;

@RestController
@RequestMapping("api/weather")
public class WeatherDataController {

// TODO : change this - move all the unnecesary logic to a service
    private final WeatherDataAvgRepository weatherDataAvgRepository;

    public WeatherDataController(WeatherDataAvgRepository weatherDataAvgRepository) {
        this.weatherDataAvgRepository = weatherDataAvgRepository;
    }

    public WeatherDataAvg getLatest() {

    }

}
