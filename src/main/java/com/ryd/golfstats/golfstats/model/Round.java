package com.ryd.golfstats.golfstats.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.bson.types.ObjectId;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class Round {

    private ObjectId _id;

    @NotEmpty
    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("userId")
    private String userId;

    @NotEmpty(message = "Course Name should not be empty")
    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("course")
    private String course;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("date")
    private LocalDate date;

    @Min(value = 1, message = "Score should not be less than 1")
    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("score")
    private int score;

    @Max(value = 100, message = "Fairway Percentage should not be greater than 100")
    @Getter
    @Setter
    @Accessors(fluent = true)
    @JsonProperty("fairwayPercentage")
    private int fairwayPercentage;

    @Max(value = 100, message = "Green Percentage should not be greater than 100")
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
