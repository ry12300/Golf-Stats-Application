package com.ryd.golfstats.golfstats.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

// todo - make this abstract and a add a concrete implementation - if needed?

@Slf4j
public class Consumer {

    public static String callExternalAPI(final String url) {

        //  see: https://www.baeldung.com/rest-template
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        return result;
    }

}