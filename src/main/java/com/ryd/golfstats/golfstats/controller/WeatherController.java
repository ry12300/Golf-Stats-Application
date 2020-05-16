package com.ryd.golfstats.golfstats.controller;

import com.ryd.golfstats.golfstats.service.WeatherService;
import com.ryd.golfstats.golfstats.utils.Assert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@Slf4j
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        Assert.notNull(weatherService, "weatherService");
        this.weatherService = weatherService;
    }

    // todo - need to have a a path param with location to get specific weather
    /**
     * Get Weather from a specifc area
     */
    @GetMapping(
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String getWeather() {

        final String URL = "https://www.metaweather.com/api/location/44418/";

        return weatherService.getWeather(URL);
    }
}
