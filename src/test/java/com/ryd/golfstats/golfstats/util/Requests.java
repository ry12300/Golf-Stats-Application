package com.ryd.golfstats.golfstats.util;

import com.ryd.golfstats.golfstats.model.Round;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class Requests {

    private Requests() {
    }

    public static RequestBuilder getRoundsByUserId(String userId) {

        return MockMvcRequestBuilders
            .get("/rounds/" + userId)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
    }

    public static RequestBuilder createRound(Round round) {

        return MockMvcRequestBuilders
            .post("/rounds")
            .accept(MediaType.APPLICATION_JSON)
            .content(TestHelper.toJson(round))
            .contentType(MediaType.APPLICATION_JSON);
    }
}
