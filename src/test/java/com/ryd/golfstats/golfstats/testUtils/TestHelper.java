package com.ryd.golfstats.golfstats.testUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class TestHelper {

    private TestHelper() {
    }

    public static String toJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule()); //used for localDate
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
