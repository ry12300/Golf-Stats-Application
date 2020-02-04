package com.ryd.golfstats.golfstats.repository;

import com.ryd.golfstats.golfstats.model.Round;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface RoundRepository extends MongoRepository<Round, String> {

    List<Round> findByUserId(String userId);

    Optional<Round> findBy_id(ObjectId objectId);
}
