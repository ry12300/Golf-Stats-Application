package com.ryd.golfstats.golfstats.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

public class Round {

    private ObjectId _id;

    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("userId")
    private String userId;

    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("course")
    private String course;

    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("score")
    private int score;

    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("fairwayPercentage")
    private int fairwayPercentage;

    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("greenPercentage")
    private int greenPercentage;

    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("numberOfPutts")
    private int numberOfPutts;

    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("notes")
    private String notes;

}
