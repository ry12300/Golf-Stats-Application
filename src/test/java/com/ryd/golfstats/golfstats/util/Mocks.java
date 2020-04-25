package com.ryd.golfstats.golfstats.util;

import com.github.javafaker.Faker;
import com.ryd.golfstats.golfstats.model.Round;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public class Mocks {

    private Mocks(){ }

    public static ObjectId objectId(){
        return new ObjectId();
    }

    public static Round pinehurstRound() {

        //is faker useful here?
        Faker faker = new Faker();

        return new Round()
            .userId("user3")
            .course("Pinehurst")
            .date(LocalDate.now())
            .score(94)
            .fairwayPercentage(20)
            .greenPercentage(20)
            .numberOfPutts(27)
            .notes("played well on back 9");
    }

}
