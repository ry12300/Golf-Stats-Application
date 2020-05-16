package com.ryd.golfstats.golfstats.service;

import com.ryd.golfstats.golfstats.consumer.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("WeatherService")
public class WeatherService {

    @Autowired
    public WeatherService() {
    }

    // todo need to change this to be location etc
    public String getWeather(String url) {

        return Consumer.callExternalAPI(url);
    }

}
