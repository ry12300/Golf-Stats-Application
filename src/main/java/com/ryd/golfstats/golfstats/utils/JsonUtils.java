package com.ryd.golfstats.golfstats.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ryd.golfstats.golfstats.model.Round;

public class JsonUtils {

    // todo - make generic i.e. return Object not round
    public static Round fromJson(final String json) {
        try {
            return new ObjectMapper().readValue(json, Round.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
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
