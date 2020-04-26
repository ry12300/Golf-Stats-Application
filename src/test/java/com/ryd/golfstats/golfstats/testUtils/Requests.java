package com.ryd.golfstats.golfstats.testUtils;

import com.ryd.golfstats.golfstats.model.Round;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class Requests {

    private Requests() {
    }

    public static RequestBuilder getAllRoundsByUserId(String userId) {

        return MockMvcRequestBuilders
            .get("/users/" + userId + "/rounds/")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
    }

    public static RequestBuilder getSpecificRound(String userId, String roundId) {

        return MockMvcRequestBuilders
            .get("/users/" + userId + "/rounds/" + roundId)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
    }


    public static RequestBuilder createRound(String userId, Round round) {

        return MockMvcRequestBuilders
            .post("/users/" + userId + "/rounds/")
            .accept(MediaType.APPLICATION_JSON)
            .content(TestHelper.toJson(round))
            .contentType(MediaType.APPLICATION_JSON);
    }

    public static RequestBuilder deleteRound(String userId, String roundId, Round round) {

        return MockMvcRequestBuilders
            .delete("/users/" + userId + "/rounds/" + roundId)
            .accept(MediaType.APPLICATION_JSON)
            .content(TestHelper.toJson(round))
            .contentType(MediaType.APPLICATION_JSON);
    }

    // todo - add for patch and delete
}
